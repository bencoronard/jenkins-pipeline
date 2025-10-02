@Library('dev-hireben-common') _

// Workflow variables
def ENV_DEV = 'dev'
// Directories
def DIR_SOURCE_CODE = '.source'

pipeline {

  agent { label 'linux' }

  options {
    timeout time: 5, unit: 'MINUTES'
  }

  stages {

    stage('Extract configurations') {
      steps {
        echo 'Extracting configurations...'
      }
    }

    stage('Generate manifests') {
      steps {
        echo 'Generating manifest...'
      }
    }

    stage('Apply manifests') {
      steps {
        echo 'Generating manifest...'
      }
    }

  }

  post {
    always {
      cleanWs()
    }
  }
}
