def call() {
    echo "Running CD Pipeline"

    stage('Container Build') {
        sh '''
        podman build -t demo-app:latest .
        '''
    }

    stage('Deploy Container') {
        sh '''
        sudo podman stop demo-app || true
        sudo podman rm demo-app || true
        sudo podman run -d --name demo-app -p 8081:8080 demo-app:latest
        '''
    }
}
