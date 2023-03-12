kubectl delete -f ./Policies/.

kubectl delete -f ./Deployment/.

kubectl apply -f ./Deployment/config.yaml

kubectl apply -f ./Policies/resiliency-circuit.yaml

kubectl apply -f ./Deployment/carservice.yaml

