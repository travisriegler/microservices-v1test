pipeline {
    agent any

    tools {
        maven 'Maven-tool' // Name of the Maven tool you configured in Jenkins
        jdk 'JDK-tool' // Name of the JDK tool you configured in Jenkins. test4 on 4.11.24
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Echo Env Variables') {
            steps {
                script {
                    echo "BRANCH_NAME: ${env.BRANCH_NAME}"
                    echo "CHANGE_ID: ${env.CHANGE_ID}"
                    echo "CHANGE_TARGET: ${env.CHANGE_TARGET}"
                    echo "CHANGE_BRANCH: ${env.CHANGE_BRANCH}"
                    echo "CHANGE_AUTHOR: ${env.CHANGE_AUTHOR}"
                    echo "CHANGE_TITLE: ${env.CHANGE_TITLE}"
                    echo "BUILD_NUMBER: ${env.BUILD_NUMBER}"
                    echo "JOB_NAME: ${env.JOB_NAME}"
                    echo "JENKINS_URL: ${env.JENKINS_URL}"
                    echo "GIT_COMMIT: ${env.GIT_COMMIT}"
                    echo "GIT_BRANCH: ${env.GIT_BRANCH}"
                    echo "1"
                }
            }
        }
    }
}