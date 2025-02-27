pipeline {
    agent any

    tools{
      maven 'Maven3'
      jdk 'JDK_21'
      }

    stages {
        stage('Checkout') {
            steps {
                git branch:'main', url: 'https://github.com/S-Vilka/ClassAssignmentAkido.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
