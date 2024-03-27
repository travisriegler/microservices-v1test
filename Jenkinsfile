pipeline {
    agent any

    tools {
        maven 'Jenkins installed 3.9.6' // Name of the Maven tool you configured in Jenkins
        jdk 'Amazon Corretto 17' // Name of the JDK tool you configured in Jenkins, and testing the webhook. test1 on 3.27.24
    }

    environment {
        IMAGE_TAG = "my-app:${env.BUILD_ID}"
        DOCKER_REGISTRY = "my-registry.example.com"
        IMAGE_NAME = "my-app"
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
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${env.DOCKER_REGISTRY}/${env.IMAGE_NAME}:${env.IMAGE_TAG}")
                }
            }
        }
    }
}