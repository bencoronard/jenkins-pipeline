@Library('dev-hireben-common') _

// Git events
def IS_TAG_EVENT = env.gitlabActionType == 'TAG_PUSH'
def IS_MERGE_EVENT = env.gitlabActionType == 'MERGE'
def EVENT_TARGET = env.gitlabTargetBranch
// Workflow actions
def IS_MERGE_TRUNK = IS_MERGE_EVENT && EVENT_TARGET == 'main'
def IS_TAG_RC = IS_TAG_EVENT && (EVENT_TARGET ==~ /v\d+\.\d+\.\d+-rc/)
def IS_TAG_RELEASE = IS_TAG_EVENT && (EVENT_TARGET ==~ /v\d+\.\d+\.\d+/)
def IS_ROLLBACK = !IS_MERGE_TRUNK && !IS_TAG_RC && !IS_TAG_RELEASE
// Directories
def CODE_DIR = '.code'
def HELM_DIR = '.helm'
def PROD_DIR = '.prod'

pipeline {

  agent { label 'linux' }

  options {
    timeout time: 10, unit: 'MINUTES'
  }

  environment {
    SCRIPT = credentials 'script-hello'
  }

  parameters{
    choice name: 'ENV_TO_ROLLBACK', choices: ['dev', 'stage', 'prod'], description: 'Choose environment to rollback'
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
