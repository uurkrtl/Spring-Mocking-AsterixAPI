## Coding: Spring Service (Layered Structure)

The task refers to the Asterix task you did last.

* Step 1: Add a Service layer to the task you last completed.

## Coding: CRUD

If you didn't get to the bonus task yesterday, then...

* Implement an endpoint in the AsterixController that creates a character.

## Coding: DTO

* Create a DTO for the POST endpoint so that the client cannot specify an Id for the new character.
* And generate a random Id for the character.

## Bonus: CRUD

If you didn't manage to do it yesterday, ...

```markdown
* implement a endpoint in the AsterixController that returns a Character based on its id.
* implement a endpoint in the AsterixController that deletes a Character based on its id.
* implement a endpoint in the AsterixController that updates a Character based on its id.
```
## Bonus: Services

Advanced IdService

* Create an IdService class with a method `public String randomId()`. This method should use the UUID class to generate a random id.
* Use dependency injection in the AsterixService to inject the IdService class and generate an id when creating new characters.

## Bonus: Query

If not done yesterday, follow the following steps in order:

* Step 1: Add a query parameter `age` to your getAllCharacter endpoint.
* Step 2: Filter all characters that have a maximum age based on this parameter. (First load all characters from the database and use familiar Java methods for filtering)
* Step 3: Look at Generated Query Methods and use them to directly load the filtered characters from the database. (Only read section 3)


## Bonus: DTO

* Create a DTO for the PUT endpoint so that the client cannot change the Id of an existing character.

## Bonus: Villages, Pets, Weapons

Consider creating a more detailed API for the Asterix universe.

Implement the API using Spring Boot and Spring Data.

Pay attention to the REST conventions (RFC documentation!).