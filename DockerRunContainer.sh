docker run -p 8080:8080 --name lyrestapi_app -e DB_HOST=$1 -e DB_NAME=$2 lyrestapi
docker rm lyrestapi_app