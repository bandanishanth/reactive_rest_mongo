# Reactive Mongo Application using Reactive Spring Boot

## The application uses MongoDB to demonstrate Reactive rest API's making use of Spring Boot

**Step 1** : Run MongoDB using your console\n. The application connects to the default Mongo Port.
Change as needed in the application properties.

**CAUTION: The Application in it's current form deletes all the entries in the document every time it is run.**

**To change this remove the deleteAll() function in the 'ReactiveRestMongoApplication.java' and modify as needed.**

**Step 2** : Run the Spring Boot Application from the IDE which runs on port 8080 by default. This too can be changed via application properties.

**Step 3** : In your web console once the connection is established you should see three objects displayed as stored in the document in your database.

**NOTE: The ID's as randomly generated using UUID in the application. So the ID changes each time the Application is run**

**Step4** : Open your web browser and visit localhost:8080/__PATH__ to acces reactive application.

__AVAILABLE PATHS__:
1. `/rest/employee/all` : Displays all the records in the database.
2. `/rest/employee/{__id__}` : Retrieves the Object from DB where ID={id}.
3. `/rest/employee/{__id__}/events` : **Displays** the Object on the browser **repatedly** on the browser window at an interval of **2 seconds**.
