# AtosTest

## Database
This project is a solution proposed by me for atos offer test;<br />
The database used for this project is h2 embedded, please open [h2-console](localhost:8080/h2-console) for the ui!
<br />datasource is : "jdbc:h2:mem:testdb"
<br /> the table "registred_user" contains 4 lines by default to test the api, you can find the sql code in resources/data.sql 

## How to run the project
- clone this project or download it
- open the project in your preferred IDE
- Either run the project or generate the jar using mvn clean install and execute it


## Technical Details

* In this project I've used **spring-boot-starter-validation** <br />
You can find the 2 annotations created in the package validators.annotations; these annotations validate the age/country of user, the project compare these values to the ones in application.properties, so if you need to change the country or the minimal age, you can do it directly from application.properties<br />
For the mandatory fields I've used @NotNull and @NotBlank to handle this!
* In the user Model, the Gender field is a string but its controlled so that it can have one of these values (Male, Female, Other), the control is on UserServiceImpl.class:21 
* For the logging part, I've user aop, to log the execution time as well as the arguments and the response
* The documentation of API was done by [springdoc-openapi] http://localhost:8080/swagger-ui/index.html

## Examples of API usage
* Getting User detail, for this example I've passed "mboukhenaif" as userName <br />
```curl -X 'GET' \'http://localhost:8080/api/users/mboukhenaif' \ -H 'accept: */*'``` <br />
* Adding new User 
```
curl -X 'POST' \
  'http://localhost:8080/api/users/add' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "userName": "tested",
  "birthday": "1997-08-27",
  "country": "France",
  "phoneNumber": "+33677969192",
  "gender": "Male"
  }'
  ```