@Library('dev-hireben-common') _

pipeline {

  agent { label 'linux' }

  stages {

    stage('Initialize') {
      steps {
        init()
      }
    }

  }

  post {
    success {
      echo 'Pipeline ran successfully'
    }
  }
}
