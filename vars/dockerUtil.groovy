def buildImage(Map args = [:]) {
  withCredentials([
    string(credentialsId: args.registry, variable: 'HOST')
  ]) {
    docker.withRegistry(constructRegistryUrl("${HOST}"), args.credentialsId) {
      return docker.build(
        "${HOST}/${args.name}:${args.tag}",
        "--build-arg -f ${args.dockerfile} ENVIR=${args.environment}"
      )
    }
  }
}

def pushToRegistry(Map args = [:]) {
  withCredentials([
    string(credentialsId: args.registry, variable: 'HOST')
  ]) {
    docker.withRegistry(constructRegistryUrl("${HOST}"), args.credentialsId) {
      args.image.push()
    }
  }
}

def execInsideDocker(Map args = [:], Closure closure) {
  withCredentials([
    string(credentialsId: args.registry, variable: 'HOST')
  ]) {
    def fullImageName = "${HOST}/${args.image}"
    docker.withRegistry(constructRegistryUrl("${HOST}"), args.credentialsId) {
      docker.image(fullImageName).inside {
        closure.call()
      }
    }
  }
}

def constructRegistryUrl(String host) {
  return "https://${host}"
}