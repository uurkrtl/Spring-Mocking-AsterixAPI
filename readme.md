## Setup: Github Project

Create a new Spring Boot project together for an "Asterix API" in IntelliJ with the dependencies Spring Data Mongo and Spring Web.

What is the URL to the Github repository?
`inputfield`

## Coding: Recap: REST Controller "GET"

Define a character record with the fields id, name, age, profession.

Build an AsterixController that returns this list at the endpoint `GET /asterix/characters`:

```java
return List.of(
        new Character("1", "Asterix", 35, "Krieger"),
        new Character("2", "Obelix", 35, "Lieferant"),
        new Character("3", "Miraculix", 60, "Druide"),
        new Character("4", "Majestix", 60, "Häuptling"),
        new Character("5", "Troubadix", 25, "Barden"),
        new Character("6", "Gutemine", 35, "Häuptlingsfrau"),
        new Character("7", "Idefix", 5, "Hund"),
        new Character("8", "Geriatrix", 70, "Rentner"),
        new Character("9", "Automatix", 35, "Schmied"),
        new Character("10", "Grockelix", 35, "Fischer")
);
```

Call the endpoint with Postman. You should see the list of characters.

## Coding: MongoDB

Now let the AsterixController load the characters from a MongoDB database.

> ⚠️ Attention: Make sure to set your AtlasDB URL as an environment variable so that your password doesn't end up on GitHub!

> ⚠️ Attention: The name of the database collection MUST match the name of the record, but start with a lowercase letter! For example, if your entity is a record called "AsterixCharacter", then the MongoDB collection must be named "asterixCharacter"!

Manually write the character data into the database beforehand (using Compass). Tip: You can use ChatGPT to convert the data to JSON.

Feel free to use the [example code from the lecture](https://github.com/bartfastiel/spring-data) as a template. Remember the things you need:
* The Maven dependency for Spring Data MongoDB
* A repository interface that implements `MongoRepository<CharacterRecord, String>`
* The MongoDB URL (from environment variable) and the database name in `application.properties`
* The environment variable `MONGODB_URI` with the launch configuration in IntelliJ

If you make a change to a character in AtlasDB (via Compass), you should be able to receive the updated data in Postman.

## Bonus: Create, Update, and Delete

Extend the AsterixController to also support POST, PUT, and DELETE.

## Bonus: Swagger SpringDoc

Add this dependency to your project:

```xml
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.2.0</version>
		</dependency>
```

After restarting the Spring Boot application, navigate to http://localhost:8080/swagger-ui/index.html

You should now see documentation of your API.

