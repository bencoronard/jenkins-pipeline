@Library('dev-hireben-common') _

// Git events
def IS_TAG_EVENT = env.gitlabActionType == 'TAG_PUSH'
def IS_MERGE_EVENT = env.gitlabActionType == 'MERGE'
def EVENT_TARGET = env.gitlabTargetBranch
// Workflow actions
def IS_MERGE_TRUNK = IS_MERGE_EVENT && EVENT_TARGET == 'main'
def IS_TAG_RC = IS_TAG_EVENT && (EVENT_TARGET ==~ /v\d+\.\d+\.\d+-rc/)
def IS_TAG_RELEASE = IS_TAG_EVENT && (EVENT_TARGET ==~ /v\d+\.\d+\.\d+/)
// Directories
def DIR_SOURCE_CODE = '.source'
def DIR_VALUES = '.values'
def DIR_TEMPLATE = '.template'
def DIR_PROD = '.prod'

pipeline {

  agent { label 'linux' }

  options {
    timeout time: 10, unit: 'MINUTES'
  }

  parameters{
    choice name: 'ENV_TO_ROLLBACK', choices: ['dev', 'stage', 'prod'], description: 'Choose environment to rollback'
    string name: 'ROLLBACK_TO_VERSION', defaultValue: '', description: 'Specify a commit/tag to rollback (e.g., "abc1234", "v1.0.0")'
  }

  stages {

    stage('Query merge data') {
      when {
        expression { IS_MERGE_TRUNK }
      }
      steps {
        echo 'Hello, world'
      }
    }

    stage('Pull source code') {
      when {
        expression { IS_MERGE_TRUNK }
      }
      steps {
        echo 'Hello, world'
      }
    }

    stage('Trigger SAST/SCA') {
      when {
        expression { IS_MERGE_TRUNK }
      }
      steps {
        echo 'Hello, world'
      }
    }

    stage('Build image') {
      when {
        expression { IS_MERGE_TRUNK }
      }
      steps {
        echo 'Hello, world'
      }
    }

    stage('Push to registry') {
      when {
        expression { IS_MERGE_TRUNK }
      }
      steps {
        echo 'Hello, world'
      }
    }

    stage('Check image existence') {
      when {
        expression { !IS_MERGE_TRUNK }
      }
      steps {
        echo 'Hello, world'
      }
    }

    stage('Generate manifest') {
      steps {
        echo 'Hello, world'
      }
    }

    stage('Add tag to existing image') {
      when {
        anyOf {
          expression { IS_TAG_RC }
          expression { IS_TAG_RELEASE }
        }
      }
      steps {
        echo 'Hello, world'
      }
    }

    stage('Schedule DAST') {
      when {
        expression { IS_TAG_RC }
      }
      steps {
        echo 'Hello, world'
      }
    }

    stage('Deploy') {
      when {
        allOf {
          expression { !IS_TAG_RELEASE }
          expression { params.ENV_TO_ROLLBACK != 'prod' }
        }
      }
      steps {
        echo 'Hello, world'
      }
    }

    stage('Deliver manifest') {
      when {
        anyOf {
          expression { IS_TAG_RELEASE }
        }
      }
      steps {
        echo 'Hello, world'
      }
    }

    stage('Deliver image') {
      when {
        expression { IS_TAG_RELEASE }
      }
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
