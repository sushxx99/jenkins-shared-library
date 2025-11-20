def call() {
    echo "Running CD Pipeline"

    stage('Container Build') {
        sh '''
        podman build -t demo-app:latest .
        '''
    }

    stage('Deploy Container') {
        sh '''
        podman stop demo-app || true
        podman rm demo-app || true
        podman run -d --name demo-app -p 8081:8080 demo-app:latest
        '''
    }
}
