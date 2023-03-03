# What is this repository? 

# Container creating

## Running in minikube
When running in minikube I had to run the following command in order to being able to use docker images in minikube. (Before building the images)
```properties
eval $(minikube docker-env)
```

## Creating CarService Container
```properties
cd CarService
mvn clean package
mvn docker build -t carservice .
```

## Creating Worker Container

```properties
cd Worker
mvn clean package
mvn docker build -t worker .
```

# Running with Healthcheck
```properties
kubectl apply -f ./Deployment/config.yaml
kubectl apply -f ./Deployment/carservice-healthcheck.yaml
```
### Expose port of Container
```properties
kubectl get pods
kubectl port-forward <podname> 8080 3500
```
The spring boot app will be available on localhost:8080 while the sidecar is available on localhost:3500

### Call the app via sidecar
```properties
curl -i http://localhost:3500/v1.0/invoke/carservice/method/car/1
```
### Disable the endpoint
```properties
curl -X POST -i http://localhost:8080/enabled/false
```

Now, after some time the call from before should fail because of the failing health check
### Get logs of app and sidecar
```properties
kubectl logs <podname>
kubectl logs <podname> daprd
```




### Delete old deployments
```properties
kubectl delete -f ./Deployment/.
```



