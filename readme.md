## Coding: Mocking in Unit Tests

In this task, you will apply what you have learned to write unit tests for a service.

* Create unit tests for the
    * `findAllCharacters` method,
    * `findById` method,
    * `updateCharacter` method,
    * `deleteCharacter` method
      of the CharacterService. Use Mockito to mock the dependency on the CharacterRepository.

## Coding: Id Generation

* Create an `IdService` class where you provide a method to generate a random id.
* Use this class in the CharacterService to generate the id for a new procharacterduct. (Use dependency injection)
* Create a unit test for the `addCharacter` method in the CharacterService, also mock the IdService.

## Bonus: Strict Tests

* In each unit test, check that the method of your mock was called only once and no other methods were called.

## Bonus: Static Mocking

Create a unit test for the `IdService` class.

* Research how to mock the static method call `UUID.randomUUID()`.

## Bonus: Date/ArgumentCaptor

* Extend your Character class to include the creation timestamp.
* Use the `addCharacter` method in the CharacterService to determine and store the current timestamp of creation.
* Modify your unit test and check that the creation timestamp is after January 1, 2020, and before 9 PM. Use the ArgumentCaptor from Mockito [Link](https://www.baeldung.com/mockito-argumentcaptor)

## Bonus: Random Character

* Create a method `public void setSeed(long seed)` in the CharacterService.
* Create a method `getRandomCharacter` in the CharacterService that uses a seed to return a random pharacter.
* Write a unit test for this method, set the seed to a fixed value so that the same pharacter is selected every time.

## Bonus: Without Mockito

* Write all your tests without Mockito.