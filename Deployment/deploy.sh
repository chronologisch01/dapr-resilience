kubectl apply -f config.yaml
kubectl apply -f carservice.yaml
kubectl apply -f worker.yaml
kubectl rollout status deploy/worker
kubectl rollout status deploy/carservice
kubectl get pods
minikube service --all