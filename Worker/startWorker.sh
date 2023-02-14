dapr stop worker

mvn clean package

dapr run --app-id worker --app-port 8080 --config ../config.yaml --components-path ../Components/ -- java -jar ./target/Worker-0.0.1-SNAPSHOT.jar --server.port=8080
