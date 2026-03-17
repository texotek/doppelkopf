call mvn clean
call mvn package -P server
call mvn package -P client

start "Server" cmd /k java -jar .\target\server.jar
start "1" cmd /k java -jar .\target\client.jar
start "2" cmd /k java -jar .\target\client.jar
start "3" cmd /k java -jar .\target\client.jar
start "4" cmd /k java -jar .\target\client.jar