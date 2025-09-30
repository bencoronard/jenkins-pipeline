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