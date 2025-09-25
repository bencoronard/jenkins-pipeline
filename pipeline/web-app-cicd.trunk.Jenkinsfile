@Library('dev-hireben-common') _

pipeline {

  agent { label 'linux' }

  options {
    timeout time: 10, unit: 'MINUTES'
  }

  environment {
    SCRIPT = credentials 'script-hello'
  }

  parameters{
    choice name: 'ENV_TO_ROLLBACK', choices: ['dev', 'stag', 'prod'], description: 'Choose environment to rollback'
    string name: 'ROLLBACK_TO_VERSION', defaultValue: '', description: 'Specify a commit/tag to rollback (e.g., "abc1234", "v1.0.0")'
  }

  stages {

    stage('Initialize metadata') {
      steps {
        echo 'Hello, world'
      }
    }

    stage('Check image existence') {
      steps {
        echo 'Hello, world'
      }
    }

    stage('Checkout source code') {
      steps {
        echo 'Hello, world'
      }
    }

    stage('Build image') {
      steps {
        echo 'Hello, world'
      }
    }

  }

  post {
    always {
      cleanWs()
    }
  }
}
