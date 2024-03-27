pipeline {
    agent any

    tools {
        maven 'Jenkins installed 3.9.6' // Name of the Maven tool you configured in Jenkins
        jdk 'Amazon Corretto 17' // Name of the JDK tool you configured in Jenkins, and testing the webhook. test1 on 3.27.24
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
    }
}