# pull iimage sql and prepare database dadcooking
docker pull mysql:5.7
docker run -p 3306:3306 --name dadcooking-db -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=dadcooking -d mysql:5.7