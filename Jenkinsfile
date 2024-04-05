pipeline {
    agent any

    tools {
        maven 'Maven-tool' // Name of the Maven tool you configured in Jenkins
        jdk 'JDK-tool' // Name of the JDK tool you configured in Jenkins, and testing the webhook. test2 on 3.27.24
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