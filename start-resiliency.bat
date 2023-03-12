kubectl delete -f ./Deployment/.

kubectl apply -f ./Deployment/config.yaml

kubectl apply -f ./Policies/resiliency-retry.yaml

kubectl apply -f ./Deployment/carservice.yaml

