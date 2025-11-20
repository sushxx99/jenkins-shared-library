def call() {
    echo "Running CI Pipeline"

    stage('Checkout') {
        checkout scm
    }

    stage('Build') {
        sh 'echo "Building application…"'
    }

    stage('Test') {
        sh 'echo "Running tests…"'
    }
}
