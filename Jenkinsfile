pipeline {
    agent any

    tools {
        maven 'jenkins_maven'
        dockerTool 'jenkins_docker'
    }

    environment {
        DOCKER_IMAGE= '1rahul23/share-market-jenkins:latest'
    }
    
    stages {
        stage('Checkout') {
            steps {
                // Checkout the current repository
                git branch: 'main', url: 'https://github.com/rahulVerma2241/ShareMarketBackend.git'
            }
        }

        stage('Build And Test') {
            steps {
                // maven command for creating build along with testing
                sh 'mvn clean package'
            }
        }

        stage('Docker Build and Push') {
            steps {
                script {
                    def customImage = docker.build(DOCKER_IMAGE)
                    customImage.push()
                }
            }
        }
    
        stage('Deploy') {
            steps {
                // Run the Spring Boot application
                echo 'Deploying the Spring Boot application...'
                sh 'nohup java -jar target/ShareMarketBackend-0.0.1-SNAPSHOT.jar &'

                sleep 30

                script {
                    def response = sh(script: "curl --write-out '%{http_code}' --silent --output /dev/null http://localhost:8081/sharemarket/api/data", returnStdout: true).trim()
                    if (response != '200') {
                        error("Health check failed")
                    }
                    else {
                        echo 'Health is passed'
                    }
                }
            }
        }
    }

    post {
        always {
            // Clean up, send notifications, etc.
            echo 'Cleaning up...'
            sh 'echo "Cleanup step"'
        }
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
