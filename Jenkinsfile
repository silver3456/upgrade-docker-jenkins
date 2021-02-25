pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                sh "docker build -t='silver3456/upgrade-selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
			        sh "docker login --username=${user} --password=${pass}"
			        sh "docker push silver3456/upgrade-selenium-docker:latest"
			    }                           
            }
        }
    }
}
