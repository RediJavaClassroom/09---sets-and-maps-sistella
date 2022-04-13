# [Set & Map](https://redi-school.github.io/intermediate-java/09-ds-2-set-and-map/)

## Exercise

Let's create a movie rating system. Think about a website like [iMDB](https://www.imdb.com/)
or [Rotten Tomatoes](https://www.rottentomatoes.com/), which are **online databases** and **review aggregators** of films, television series, home videos, video games, and streaming content online

### 1 - Creating the `Movie` class
Let's define the Movie class and its properties

1. In the package [`com.redi.j2`](src/main/java/com/redi/j2), create a public class to represent a `Movie`
2. Add the following `private final` properties to the `Movie`, with **Getters** (no Setters)
    - `UUID id` - a unique identifier for the movie
    - `String name` - the name of the movie
    - `Map<BigDecimal, Integer> ratings` - a map counting the number of times a rating was given. 
      - A rating is a `BigDecimal` between 0 and 10 (see how to use a [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html) in [this link](https://stackoverflow.com/a/37217646)).
      - Here's an **example** of how this mapping could look like:
        ```
         0.5 -> 3 (rating / amount)
         5.5 -> 1 (rating / amount)
         7.0 -> 2 (rating / amount)
        ```
    - `SortedSet<String> tags` a set of tags for this movie **sorted in alphabetical order**
    - `Set<String> actors` a set of actors and actresses in this movie. Should not be sorted.
3. Add a constructor that receives only the `id`, and `name` in that order and set the corresponding properties
   - All the other properties (`ratings`, `tags` and `actors`) must be initialized empty
4. Add another constructor that receives all the properties in the order defined above and set the corresponding
   properties.
5. Generate the following methods
    - `toString`
    - `equals` and `hashCode`

### 2 - Behaviors of the `Movie` class. 
Now implement the following methods

1. `addTag` adds a tag to the set of tags. This method accepts `String tag` and returns nothing.
2. `removeTag` removes a tag from the set of tags. This method accepts `String tag` and returns nothing.
3. `addActor` adds an actor to the set of actors. This method accepts `String actor` and returns nothing.
4. `removeActor` removes an actor from the set of actors. This method accepts `String actor` and returns nothing.
5. `addRating` adds a rating to this movie. This method accepts `BigDecimal rating` and returns `boolean`.
    - if the `rating` is not between 0 and 10 then return `false`
    - if the `ratings` map does not contain the `rating` then set the count to 1 and return `true`.
    - if the `ratings` map contains the `rating` then increment its count by 1 and return `true`.
6. `removeRating` removes a rating from this movie. This method accepts `BigDecimal rating` and returns `boolean`
    - if the `rating` is not between 0 and 10 then return `false`
    - if the `ratings` map does not contain the `rating` then return `false`
    - if the `ratings` map contains the `rating` then decrement its count by 1 and return `true`.
    - if the count is zero after decrementing, then remove the `rating` from the map.
    - the count should never be negative.
7. `hasTags`: This method accepts `Set<String> searchTags` and returns a `Set<String>` containing all the tags of this
   movie that are also present in `searchTags`. More formally, we call this **an intersection of two sets.**

### 3 - Calculating the ratings for a `Movie`
Finally, let's calculate the score of a Movie based on all the ratings.

1. Create the interface `RatingsCalculator` in the package [`com.redi.j2`](src/main/java/com/redi/j2) 
   - The interface defines a method called `calculate`, that receives a `Movie` and returns a `BigDecimal`
2. Create the class `AverageRatingsCalculator` implementing the interface with method `calculate` to return the average of the ratings of the provided movie as follows:
      ```
      (0.5 * 3) + (5.5 * 1) + (7.0 * 2)
      --------------------------------- = 3.5
                (3 + 1 + 2)
      ```
3. Create class `TomatoRatingsCalculator` implementing the interface with method `calculate` returning the _Tomato_ rating. 
   - The _Tomato_ rating is the total number of ratings greater than `5.0` divided by the total number of ratings available. From the example above 5.5 has count 1 and 7.0 has count 2 hence the method should return;
     ```
        1 + 2
     -----------  X 10 = 5.0
     (3 + 1 + 2)
     ```
