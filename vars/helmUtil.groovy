def prepareDefaultValues(Map args = [:]) {
  def pathToDefaultValuesFile = 'values.yaml'
  def pathToDefaultValuesBackupFile = 'values.yaml.backup'
  def backupExists = fileExists "./${pathToDefaultValuesBackupFile}"
  if (backupExists) {
    sh "cp ./${pathToDefaultValuesBackupFile} ./${pathToDefaultValuesFile}"
  } else {
    sh "cp ./${pathToDefaultValuesFile} ./${pathToDefaultValuesBackupFile}"
  }
  withCredentials([
    string(credentialsId: args.registry, variable: 'HOST')
    string(credentialsId: args.pullSecret, variable: 'SECRET')
  ]) {
    withEnv([
      "IMG_NAMESPACE=${args.namespace}",
      "IMG_NAME=${args.image}"
    ]) {
      sh """
        envsubst < ${pathToDefaultValuesFile} > ${pathToDefaultValuesFile}.tmp && \
        mv ${pathToDefaultValuesFile}.tmp ${pathToDefaultValuesFile}
      """
    }
  }
}

def createManifestFile(Map args = [:]) {
  sh "helm template ${args.release} . -f ${args.values} > ${args.output}"
}