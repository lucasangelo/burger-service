# burger-service
To run this application a mysql instance is needed, in order to facilitate this job just need to run the container
configured in the docker-compose.yaml. Running:

> docker-compose up

The application uses Java 11 and Maven 3, to run it please execute the following command:

> mvn spring-boot:run

## API
/burgers - GET request to list all burgers in the menu;

/burgers/{burgerId} - GET request with Burger Id to show an specific burger info with all the ingredients;

/burgers/price - POST request passing all ingredients and their quantities to know a burger total price;

/ingredients - GET request to list all available ingredients;