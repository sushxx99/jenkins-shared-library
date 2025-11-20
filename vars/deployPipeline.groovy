def call() {
    stage('Container Build') {
        steps {
            sh '''
            podman build -t demo-app:latest .
            '''
        }
    }

    stage('Deploy Container') {
        steps {
            sh '''
            podman stop demo-app || true
            podman rm demo-app || true
            podman run -d --name demo-app -p 8081:8080 demo-app:latest
            '''
        }
    }
}
