// This script used for docker-compose, if you want to run app using docker-compose pls use this script.
// This script is fully auto deployment script.
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

// This Script used for if you deploy jar file AWS EC2 instance.
// This Script is working fully auto deployment.
//pipeline {
//    agent any
//
//    tools {
//        jdk 'JDK17'                // Jenkins → Global Tool Configuration में defined
//        maven 'M3'             // Jenkins → Global Tool Configuration में defined
//        git 'Default'              // Optional, अगर defined है
//    }
//
//    environment {
//        EC2_USER = 'ubuntu'
//        EC2_HOST = '16.170.7.215'  // अपना EC2 public IP यहाँ रखो
//        EC2_PATH = '/home/ubuntu/employee.jar'
//    }
//
//    triggers {
//        // जब भी master/main branch पर GitHub push हो, Jenkins अपने आप trigger होगा
//        githubPush()
//    }
//
//    stages {
//        stage('Git Checkout') {
//            steps {
//                echo 'Fetching source code from GitHub...'
//                git branch: 'master', url: 'https://github.com/santoshkumar711/DevOps-Demo-Employee-Management-API-Project.git'
//            }
//        }
//
//        stage('Build') {
//            steps {
//                echo 'Building the application...'
//                bat 'mvn clean package -DskipTests'
//            }
//        }
//
//        stage('Deploy to EC2') {
//            steps {
//                withCredentials([sshUserPrivateKey(credentialsId: 'ec2-key', keyFileVariable: 'SSH_KEY')]) {
//                    bat '''
//                    echo Converting SSH key path to Unix format...
//                    for /f "delims=" %%i in ('call ^"C:\\Program Files\\Git\\usr\\bin\\cygpath.exe^" "%SSH_KEY%"') do set "SSH_KEY_UNIX=%%i"
//                    echo Unix SSH key path is: %SSH_KEY_UNIX%
//
//                    echo Deploying santosh.jar to EC2 instance...
//                    call "C:\\Program Files\\Git\\bin\\bash.exe" -c "scp -o StrictHostKeyChecking=no -i \\"$SSH_KEY_UNIX\\" target/employee.jar ${EC2_USER}@${EC2_HOST}:${EC2_PATH}"
//
//                    echo Restarting service on EC2...
//                    call "C:\\Program Files\\Git\\bin\\bash.exe" -c "ssh -o StrictHostKeyChecking=no -i \\"$SSH_KEY_UNIX\\" ${EC2_USER}@${EC2_HOST} 'sudo systemctl daemon-reload && sudo systemctl restart employee.service'"
//
//                    echo ✅ Deployment completed successfully!
//                    '''
//                }
//            }
//        }
//    }
//
//    post {
//        success {
//            echo '✅ Deployment Successful! Your app is now live on EC2 🚀'
//        }
//        failure {
//            echo '❌ Deployment failed! Please check the Jenkins logs for details.'
//        }
//    }
//}
/////////////////////////////////////////////********************************************************/////////////////////////////////////////////////////

// If you want to deploy project by docker you can use this script. 
// This script is fully auto deployment script.
//pipeline {
//    agent any
//
//    tools {
//        jdk "JDK17"
//        maven "M3"
//    }
//
//    environment {
//        DOCKER_HUB_USER = "santoshkumar711"
//        IMAGE_NAME = "employee-app"
//        IMAGE_TAG = "v1"
//        CONTAINER_NAME = "employee-app"
//    }
//
//    stages {
//        stage('Checkout SCM') {
//            steps {
//                git branch: 'master', url: 'https://github.com/santoshkumar711/DevOps-Demo-Employee-Management-API-Project.git'
//            }
//        }
//
//        stage('Maven Build') {
//            steps {
//                bat "mvn clean package -DskipTests"
//            }
//        }
//
//        stage('Build Docker Image') {
//            steps {
//                bat "docker build -t $DOCKER_HUB_USER/$IMAGE_NAME:$IMAGE_TAG ."
//            }
//        }
//
//        stage('Push Docker Image') {
//            steps {
//                withCredentials([usernamePassword(
//                    credentialsId: 'dockerhub-creds',
//                    usernameVariable: 'USERNAME',
//                    passwordVariable: 'PASSWORD'
//                )]) {
//                    bat """
//                    echo $PASSWORD | docker login -u $USERNAME --password-stdin
//                    docker push $DOCKER_HUB_USER/$IMAGE_NAME:$IMAGE_TAG
//                    docker logout
//                    """
//                }
//            }
//        }
//
//        stage('Pull Latest Image') {
//            steps {
//                withCredentials([usernamePassword(
//                    credentialsId: 'dockerhub-creds',
//                    usernameVariable: 'USERNAME',
//                    passwordVariable: 'PASSWORD'
//                )]) {
//                    bat """
//                    echo $PASSWORD | docker login -u $USERNAME --password-stdin
//                    docker pull $DOCKER_HUB_USER/$IMAGE_NAME:$IMAGE_TAG
//                    docker logout
//                    """
//                }
//            }
//        }
//
//        stage('Stop & Run Container') {
//            steps {
//                bat "docker stop $CONTAINER_NAME || true"
//                bat "docker rm $CONTAINER_NAME || true"
//                bat "docker run -d --name $CONTAINER_NAME -p 8082:8082 $DOCKER_HUB_USER/$IMAGE_NAME:$IMAGE_TAG"
//            }
//        }
//    }
//
//    post {
//        always {
//            echo "Pipeline finished."
//            bat "docker image prune -f"
//        }
//        failure {
//            echo "Pipeline failed. Check logs."
//        }
//    }
//}
////////////////////////////////////////////////////*****************************************///////////////////////////////////////////////////////
















































