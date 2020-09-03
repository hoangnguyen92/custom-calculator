#Ezbob Task
This is solution of the interview task for Ezbob
##Run
To run this solution please follow these steps:
1. Run `./mvnw clean install` 
1. To test the solution run 
    `java -jar target/task-0.0.1-SNAPSHOT.jar <json_string>` <br />
    Example:<br />
    `java -jar target/task-0.0.1-SNAPSHOT.jar "{\"numbers\":[1,2,3,4,5],\"operator\":\"plus\"}"`
1. The result of the calculation will be saved in `result.log` file

NOTE: everytime you run the jar it will append the new result or error to the `result.log` file. It will not remove the old results.