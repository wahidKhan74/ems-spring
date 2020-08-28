pipeline {
    agent any
    stages {
        stage('Compile'){
            steps{
                echo '------ Compile Stage ------'
                withMaven(maven:'maven_3.6.3'){
                    sh 'mvn clean compile'
                }
            }
        }
        stage('Build'){
             steps {
                echo '------ Build Stage ------'
                withMaven(maven:'maven_3.6.3'){
                    sh 'mvn clean package -DskipTests'
                }
            }
        }
        stage('Deploy'){             
             steps {
                echo '------ Build Stage ------'
                withCredentials([[ $class: 'UsernamePasswordMultiBinding',
                credentialsId: 'PCF_CREDS',
                usernameVariable: 'USERNAME',
                passwordVariable: 'PASSWORD' ]]){
                    sh 'cf login -a https://api.run.pivotal.io -u $USERNAME  -p $PASSWORD'
                    sh 'cf target -s production'
                    sh 'cf push'
                }
            }
        }
    }

}
