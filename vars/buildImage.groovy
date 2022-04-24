#!/usr/bin/env groovy

def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-pri-repo-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t ajanghala/my-private-repo:3.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push ajanghala/my-private-repo:tagname'
    }
}