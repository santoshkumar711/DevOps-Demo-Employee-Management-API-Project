// This script used for docker-compose, if you want to run app using docker-compose pls use this script.
// This script is fully auto deployment script .
//pipeline {
//    agent any
//
//     tools {
//        jdk "JDK17"
//        maven "M3" // Jenkins me configure kiya hua Maven ka naam
//    }
//
//    environment {
//        DOCKER_HUB_USER = 'santoshkumar711'
//        IMAGE_NAME = 'employee-app'
//        IMAGE_TAG = 'v1'
//        CONTAINER_NAME = "employee-app"
//    }
//
//    stages {
//        stage('Checkout Code') {
//            steps {
//                git branch: 'master', url: 'https://github.com/santoshkumar711/DevOps-Demo-Employee-Management-API-Project.git'
//            }
//        }
//
//    stage('Maven Build') {
//        steps {
//             bat "mvn clean package -DskipTests"
//            }
//        }
//
//
//        stage('Build Docker Image') {
//            steps {
//                bat "docker build -t $DOCKER_HUB_USER/$IMAGE_NAME:$IMAGE_TAG ."
//            }
//        }
//
//        stage('Push to Docker Hub') {
//            steps {
//                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
//                    bat "echo $PASS | docker login -u $USER --password-stdin"
//                    bat "docker push $DOCKER_HUB_USER/$IMAGE_NAME:$IMAGE_TAG"
//                }
//            }
//        }
//
//        stage('Deploy') {
//            steps {
//            bat "docker rm -f employee-app || echo No old app container"
//            bat "docker-compose pull"
//            bat "docker-compose up -d"
//            }
//        }
//    }
//    post {
//        always {
//            bat 'docker image prune -f'
//        }
//    }
//}
/////////////////////////////////////////////////***********************************/////////////////////////////////////////////////////////////////////

















































