# Home Theater Facade Pattern

## Assignment #4 — Facade Design Pattern

### Project Description
This project demonstrates the Facade Design Pattern using a Home Theater System developed in Java 17.

The HomeTheaterFacade class provides a simple interface to control multiple home theater devices.

### Subsystem Classes
- Amplifier — controls sound and volume.
- DvdPlayer — plays and stops movies.
- Projector — controls the projector.
- Screen — raises and lowers the screen.
- Lights — controls brightness.
- PopcornPopper — prepares popcorn.

### Facade Pattern
The HomeTheaterFacade provides two main methods:

- `watchMovie(String movie)` — prepares the theater and starts a movie.
- `endMovie()` — stops the movie and shuts down the devices.

### Clean Code Principles
The project applies principles from Clean Code Chapters 7, 8, and 9:

1. Use Exceptions Rather Than Return Codes.
2. Provide Context with Exceptions.
3. Clear Boundaries.
4. One Concept per Test.
5. Independent Unit Tests.

### Technologies
- Java 17
- Gradle
- JUnit 5
- Facade Design Pattern

### Testing
The project includes six JUnit 5 unit tests covering valid movie playback, invalid titles, stopping movies, and preventing duplicate playback.

Run tests with:

`./gradlew test`

On Windows:

`gradlew.bat test`

### Project Structure
- `src/main/java/hometheater` — main application
- `src/main/java/hometheater/facade` — Facade implementation
- `src/main/java/hometheater/subsystem` — device classes
- `src/main/java/hometheater/exception` — custom exception
- `src/test/java/hometheater` — JUnit tests

### Conclusion
The Facade Pattern simplifies communication between the client and the home theater subsystem. It improves readability, organization, and maintainability.
