pipeline {
    agent any
    stages {
        stage('Compile'){
            steps{
                echo '------ Compile Stage ------'
                withMaven(maven:'Jenkins_maven3'){
                    sh 'mvn clean compile'
                }
            }
        }
        stage('Build'){
             steps {
                echo '------ Build Stage ------'
                withMaven(maven:'Jenkins_maven3'){
                    sh 'mvn clean package -DskipTests'
                }
            }
        }
        stage('Deploy'){             
             steps {
                echo '------ Build Stage ------'
                withCredentials([[ $class: 'UsernamePasswordMultiBinding',
                credentialsId: 'PCF_PASS',
                usernameVariable: 'USERNAME',
                passwordVariable: 'PASSWORD' ]]){
                    sh 'cf login -a https://api.run.pivotal.io -u $USERNAME  -p $PASSWORD'
                    sh 'cf target -s development'
                    sh 'cf push'
                }
            }
        }
    }

}