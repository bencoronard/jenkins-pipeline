@Library('dev-hireben-common') _

// Git events
def EVENT_TARGET = env.gitlabMergeRequestLastCommit

pipeline {

  agent { label 'linux' }

  options {
    timeout time: 10, unit: 'MINUTES'
  }

  stages {

    stage('Query merge status') {
      steps {
        echo 'Querying merge status...'
      }
    }

    stage('Pull source code') {
      steps {
        echo 'Pulling source code...'
      }
    }

    stage('Parallel tests') {
      failFast true
      parallel {

        stage('Unit test') {
          steps {
            echo 'Performing unit test...'
          }
        }

        stage('Perform SAST (quick)') {
          steps {
            echo 'Performing SAST...'
          }
        }

        stage('Perform SCA (quick)') {
          steps {
            echo 'Performing SCA...'
          }
        }

      }
    }

  }

  post {
    always {
      cleanWs()
    }
  }
}