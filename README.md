# mars-robot
A Spring Boot application to control a Robot's movements in Mars.

# Build
mvn clean install

# Run
java -jar target/mars-robot.jar

# Samples of usage

1) Right Rotations ->
http://localhost:8080/rest/mars/MMRMMRMM (Response: (2, 0, S))

2) Left movement ->
http://localhost:8080/rest/mars/MML (Response: (0, 2, W))

3) Invalid command ->
http://localhost:8080/rest/mars/AAA (Response:  400 Bad Request)

4) Invalid position ->
http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM (Response:  400 Bad Request)
