def call() {
    echo "Running CD Pipeline for ${env.JOB_NAME}"

    stage('Container Build') {
        sh """
        sudo podman build -t ${env.JOB_NAME}:latest .
        """
    }

    stage('Deploy Container') {
        sh """
        sudo podman stop ${env.JOB_NAME} || true
        sudo podman rm ${env.JOB_NAME} || true
        sudo podman run -d --name ${env.JOB_NAME} -p 8080:8080 ${env.JOB_NAME}:latest
        """
    }
}
