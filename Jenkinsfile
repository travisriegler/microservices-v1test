pipeline {
    agent any

    tools {
        maven 'Maven-tool' // Name of the Maven tool you configured in Jenkins
        jdk 'JDK-tool' // Name of the JDK tool you configured in Jenkins. test12 on 4.10.24
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