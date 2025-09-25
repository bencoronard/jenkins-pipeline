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
    string name: 'ARG', defaultValue: '', description: 'Specify an argument'
  }

  stages {

    stage('Initialize') {
      steps {
        runScript file: env.SCRIPT, arg: params.ARG
      }
    }

  }

  post {
    always {
      cleanWs()
    }
  }
}
