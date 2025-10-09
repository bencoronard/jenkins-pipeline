@Library('dev-hireben-common') _

pipeline {

  agent { label 'linux' }

  options {
    timeout time: 1, unit: 'MINUTES'
  }

  parameters{
    string name: 'CMD', defaultValue: "echo 'Hello, world!'", description: 'Specify a command'
  }

  stages {
    stage('Test') {
      steps {
        sh "${params.CMD}"
      }
    }
  }

  post {
    always {
      cleanWs()
    }
  }
}
