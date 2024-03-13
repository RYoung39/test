pipeline {
    agent any

    stages {

        stage('Build') {
            steps {

                echo 'Running maven build...'
                sh 'mvn clean package'
                archiveArtifacts artifacts: '**/target/*.jar'

            }
        }

        stage('Prod Deploy') {
            when {
                branch 'main'
            }

            steps {

                echo 'Deploying Prod...'
                sh '''
                get_maven_project_version() {
                  mvn -q \
                    -Dexec.executable="echo" \
                    -Dexec.args='${project.version}' \
                    --non-recursive \
                    exec:exec
                }
                VERSION="$(get_maven_project_version)"
                docker build -f ./scripts/Dockerfile -t demo:$VERSION .
                docker tag demo:$VERSION demo:latest
                docker compose -f ./scripts/compose.yaml up -d
                '''

            }
        }
    }

}
