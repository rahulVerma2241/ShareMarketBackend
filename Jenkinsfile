pipeline {
    agent any

    
    stages {
        stage('Checkout') {
            steps {
                // Checkout the current repository
                git 'https://github.com/rahulVerma2241/ShareMarketBackend.git'
            }
        }

        stage('Build') {
            steps {
                // Example: Use Gradle, Maven, or another build tool
                // sh './gradlew build'
                echo 'Building the application...'
                sh 'echo "Build step"'
            }
        }

        stage('Test') {
            steps {
                // Run tests (e.g., unit tests)
                // sh './gradlew test'
                echo 'Running tests...'
                sh 'echo "Test step"'
            }
        }

        stage('Deploy') {
            steps {
                // Deploy the application
                // Example: Deploy to a server, push Docker image, etc.
                echo 'Deploying the application...'
                sh 'echo "Deploy step"'
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
