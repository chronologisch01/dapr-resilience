dapr stop --app-id carservice

mvn clean package

dapr run --app-id carservice --app-port 8085 --enable-app-health-check --app-health-check-path=/health --config ../config.yaml --components-path ../Components/ -- java -jar ./target/CarService-0.0.1-SNAPSHOT.jar --server.port=8085 &
dapr run --app-id carservice --app-port 8081 --enable-app-health-check --app-health-check-path=/health --config ../config.yaml --components-path ../Components/ -- java -jar ./target/CarService-0.0.1-SNAPSHOT.jar --server.port=8081
#dapr run --app-id carservice --app-port 8085 --config ../config.yaml --components-path ../Components/ --metrics-port 9090 -- java -jar ./target/CarService-0.0.1-SNAPSHOT.jar --server.port=8085 &
#dapr run --app-id carservice --app-port 8081 --config ../config.yaml --components-path ../Components/ --metrics-port 9091 -- java -jar ./target/CarService-0.0.1-SNAPSHOT.jar --server.port=8081
