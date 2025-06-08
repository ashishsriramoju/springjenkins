pipeline {
    agent any

    environment {
        IMAGE_NAME = "springjenkins"
        CONTAINER_NAME = "springjenkins"
    }

    stages {
        stage('Build') {
            steps {
                echo "Building the Spring Boot application..."
                sh './mvnw clean package -DskipTests=false'
            }
        }

        stage('Test') {
            steps {
                echo "Running tests..."
                sh './mvnw test'
            }
        }

        stage('Run Docker Container') {
            steps {
                echo "Running Docker container..."
                sh '''
                    docker build -t $IMAGE_NAME .
                    docker stop $CONTAINER_NAME || true
                    docker rm $CONTAINER_NAME || true
                    docker run -d --name $CONTAINER_NAME -p $PORT:$PORT $IMAGE_NAME
                '''
            }
        }

        stage('Stop Docker Container') {
            steps {
                echo "Stopping Docker container..."
                sh '''
                    docker stop $CONTAINER_NAME || echo "Container already stopped"
                    docker rm $CONTAINER_NAME || echo "Container already removed"
                '''
            }
        }
    }
}
