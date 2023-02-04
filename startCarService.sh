docker stop carservice-2
#mvn clean package

docker build -t carservice -f ./CarService/Dockerfile .

#docker run carservice &
docker run carservice
