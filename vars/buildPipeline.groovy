def call() { 
    echo "Running CI Pipeline for ${env.JOB_NAME}"
    echo "Shared Library Update: This line appears in ALL microservice pipelines!"	

    stage('Checkout') {
        checkout scm
    }

    stage('Build') {
        echo "Building application…"
        sh 'echo "Build step complete"'
    }

    stage('Test') {
        echo "Running tests…"
        sh 'echo "Test step complete"'
    }
}
