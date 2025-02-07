pipeline {
    agent any

    tools {
        maven 'jenkins_maven'
    }
    
    stages {
        stage('Checkout') {
            steps {
                // Checkout the current repository
                git branch: 'main', url: 'https://github.com/rahulVerma2241/ShareMarketBackend.git'
            }
        }

        stage('Build') {
            steps {
        
                sh 'mvn clean package'
                
            }
        }

        stage('Test') {
             steps {
              
                sh 'mvn test'
                
            }
        }

    
        stage('Deploy') {
            steps {
                // Run the Spring Boot application
                echo 'Deploying the Spring Boot application...'
                sh 'nohup java -jar target/ShareMarketBackend-0.0.1-SNAPSHOT.jar &'

                sleep 30

                script {
                    def response = sh(script: "curl --writeout '%{http_code}' --silent --output /dev/null http://localhost:8081/actuator/health", returnStdout: true).trim()
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
