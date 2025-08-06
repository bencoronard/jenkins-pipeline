pipeline {
    agent {
        docker 'my-image'
    }
    options {
        timeout(time: 1, unit: 'HOURS')
        timestamps()
    }
    environment {
        BUILD_PATH = "${WORKSPACE}/build"
    }
    tools {
        maven 'Maven 3'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            when {
                expression { params.BUILD_TYPE == 'release' }
            }
            steps {
                dir('my-project') {
                    sh 'mvn clean package'
                }
            }
        }
        stage('Deploy to Staging') {
            steps {
                script {
                    echo 'Deploying to staging environment...'
                }
            }
        }
        stage('Deploy to Prod') {
            when {
                branch 'main'
            }
            input {
                message 'Proceed with deployment to production?'
                ok 'Yes, deploy'
            }
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    sh 'deploy-to-prod.sh'
                }
            }
        }
    }
    post {
        always {
            echo 'Pipeline finished.'
        }
        success {
            echo 'Pipeline was successful.'
        }
        failure {
            echo 'Pipeline failed.'
        }
        changed {
            echo 'Pipeline status changed.'
        }
    }
}