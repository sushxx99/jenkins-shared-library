def call() { 
    echo "Running CI Pipeline for ${env.JOB_NAME}"

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
