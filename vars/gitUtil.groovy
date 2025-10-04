def pullCodeFromRemote(Map args = [:]) {
  def extensionsList = []
  if (args.includeSubmodules) {
    extensionsList.add([
      $class: 'SubmoduleOption',
      parentCredentials: true,
      recursiveSubmodules: true,
      trackingSubmodules: true
    ])
  }
  checkout([
    $class: 'GitSCM',
    branches: [[name: args.reference]],
    userRemoteConfigs: [[
      url: args.repository,
      credentialsId: args.credentialsId
    ]],
    extensions: extensionsList
  ])
}

def checkoutBranch(String branch) {
  sh "git checkout -b ${branch} origin/${branch}"
}

def commitAllAndPushToRemote(Map args = [:]) {
  withCredentials([
    string(credentialsId: args.registry, variable: 'HOST')
  ]) {
    sh """
      git add . && \
      git commit -m '${args.message}' && \
      git push
    """
  }
}

def queryMRStatus(Map args = [:]) {
  withCredentials([
    string(credentialsId: args.repository, variable: 'HOST'),
    string(credentialsId: args.credentialsId, variable: 'TOKEN')
  ]) {
    def response = httpRequest(
      url: "http://${HOST}/api/v4/projects/${args.projectId}/merge_requests/${args.mrId}",
      customHeaders: [
        [name: 'PRIVATE-TOKEN', value: "${TOKEN}"]
      ],
      ignoreSslErrors: true
    )
    return readJSON(text: response.content)
  }
}