pipeline {
    agent any
    stages {
        stage('Build'){
            steps{
                echo '------ Build Stage ------'
                withMaven(maven:'Jenkins_maven3'){
                    sh 'mvn clean compile'
                }
            }
        }
        stage('Test'){
             steps {
                echo 'Testing ...'
            }
        }
        stage('Deploy'){
             steps {
                echo 'Deploying ...'
            }
        }
    }

}