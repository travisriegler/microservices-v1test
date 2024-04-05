pipeline {
    agent any

    tools {
        maven 'Maven-tool' // Name of the Maven tool you configured in Jenkins
        jdk 'JDK-tool' // Name of the JDK tool you configured in Jenkins. test3 on 4.5.24
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