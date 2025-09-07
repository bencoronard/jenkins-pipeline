def call() {
  stage('Build') {
    sh 'echo Building...'
  }
  stage('Test') {
    sh 'echo Running tests...'
  }
}
