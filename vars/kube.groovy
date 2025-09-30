def applyYamlFile(String pathToYaml = '.') {
  sh "kubectl apply -f ${pathToYaml}"
}