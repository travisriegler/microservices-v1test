pipeline {
    agent any

    tools {
        maven 'Jenkins installed 3.9.6' // Name of the Maven tool you configured in Jenkins
        jdk 'Amazon Corretto 17' // Name of the JDK tool you configured in Jenkins, and testing the webhook. test2 on 3.27.24
    }

    environment {
        IMAGE_TAG = "${env.BUILD_ID}"
        DOCKER_REGISTRY = "travisriegler"
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
        stage('Push Docker Image') {
            steps {
                script {
                    // Login to Docker Hub using credentials fetched from AWS Secrets Manager
                    withCredentials([string(credentialsId: 'docker-jenkins-patv2', variable: 'DOCKER_JENKINS_PAT')]) {
                        sh "echo $DOCKER_JENKINS_PAT | docker login --username travisriegler --password-stdin"
                    }

                    // Push the built image to Docker Hub
                    sh "docker push ${env.DOCKER_REGISTRY}/${env.IMAGE_NAME}:${env.IMAGE_TAG}"
                }
            }
        }

        stage('Connect to EKS') {
            steps {
                script {
                    sh "aws eks update-kubeconfig --region us-east-1 --name v1test"
                }
            }
        }
    }
}