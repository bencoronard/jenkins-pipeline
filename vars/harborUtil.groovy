def checkImageExistence(Map args = [:]) {
  withCredentials([
    string(credentialsId: args.registry, variable: 'HOST')
  ]) {
    def imageEncoded = URLEncoder.encode(args.image, 'UTF-8')
    def tagEncoded = URLEncoder.encode(args.tag, 'UTF-8')
    httpRequest(
      httpMode: 'HEAD',
      url: "https://${HOST}/v2/${imageEncoded}/manifests/${tagEncoded}",
      authentication: args.credentialsId,
      ignoreSslErrors: true,
      responseHandle: 'NONE'
    )
  }
}

def addTagToExistingImage(Map args = [:]) {
  withCredentials([
    string(credentialsId: args.registry, variable: 'HOST')
  ]) {
    def imageEncoded = URLEncoder.encode(args.image, 'UTF-8')
    def tagEncoded = URLEncoder.encode(args.tag, 'UTF-8')
    def newTagEncoded = URLEncoder.encode(args.newTag, 'UTF-8')
    def response = httpRequest(
      httpMode: 'GET',
      url: "https://${HOST}/v2/${imageEncoded}/manifests/${tagEncoded}",
      authentication: args.credentialsId,
      customHeaders: [[name: 'Accept', value: 'application/vnd.docker.distribution.manifest.v2+json']],
      ignoreSslErrors: true
    )
    httpRequest(
      httpMode: 'PUT',
      url: "https://${HOST}/v2/${imageEncoded}/manifests/${newTagEncoded}",
      authentication: args.credentialsId,
      customHeaders: [[name: 'Content-Type', value: 'application/vnd.docker.distribution.manifest.v2+json']],
      requestBody: response.content,
      ignoreSslErrors: true,
      responseHandle: 'NONE'
    )
  }
}