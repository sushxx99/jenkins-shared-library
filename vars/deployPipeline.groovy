def call() {

    echo "Running CD Pipeline for ${env.JOB_NAME}"

    // Define port mapping based on microservice name
    def port = 8080
    if (env.JOB_NAME == "jenkins-demo-app") {
        port = 8081
    } else if (env.JOB_NAME == "jenkins-demo-app-2") {
        port = 8082
    } else if (env.JOB_NAME == "jenkins-demo-app-3") {
        port = 8083
    }

    stage('Container Build') {
        sh """
        sudo podman build -t ${env.JOB_NAME}:latest .
        """
    }

    stage('Deploy Container') {
        sh """
        sudo podman stop ${env.JOB_NAME} || true
        sudo podman rm ${env.JOB_NAME} || true
        sudo podman run -d --name ${env.JOB_NAME} -p ${port}:8080 ${env.JOB_NAME}:latest
        """
    }
}
