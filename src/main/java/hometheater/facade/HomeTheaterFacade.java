
package hometheater.facade;

import hometheater.exception.HomeTheaterException;
import hometheater.subsystem.Amplifier;
import hometheater.subsystem.DvdPlayer;
import hometheater.subsystem.Projector;
import hometheater.subsystem.Screen;
import hometheater.subsystem.Lights;
import hometheater.subsystem.PopcornPopper;

public class HomeTheaterFacade {

    private final Amplifier amplifier;
    private final DvdPlayer dvdPlayer;
    private final Projector projector;
    private final Screen screen;
    private final Lights lights;
    private final PopcornPopper popcornPopper;

    private boolean movieStarted = false;

    public HomeTheaterFacade() {
        amplifier = new Amplifier();
        dvdPlayer = new DvdPlayer();
        projector = new Projector();
        screen = new Screen();
        lights = new Lights();
        popcornPopper = new PopcornPopper();
    }

    public void watchMovie(String movie) {
        validateMovie(movie);

        if (movieStarted) {
            throw new HomeTheaterException(
                    "A movie is already playing");
        }

        try {
            prepareTheater();
            dvdPlayer.play(movie);
            movieStarted = true;

            System.out.println("Home Theater is READY!");

        } catch (RuntimeException exception) {
            try {
                shutdownTheater();
            } catch (RuntimeException cleanupException) {
                exception.addSuppressed(cleanupException);
            }

            throw new HomeTheaterException(
                    "Failed to start movie: " + movie,
                    exception
            );
        }
    }

    private void validateMovie(String movie) {
        if (movie == null || movie.isBlank()) {
            throw new HomeTheaterException(
                    "Movie title cannot be null or empty");
        }
    }

    private void prepareTheater() {
        System.out.println("\nPreparing to watch movie...");

        popcornPopper.turnOn();
        popcornPopper.pop();

        lights.dim(10);
        screen.down();

        projector.turnOn();
        projector.setWideScreenMode();

        amplifier.turnOn();
        amplifier.setVolume(50);

        dvdPlayer.turnOn();
    }

    public void endMovie() {
        if (!movieStarted) {
            throw new HomeTheaterException(
                    "No movie is currently playing");
        }

        try {
            shutdownTheater();
            movieStarted = false;

            System.out.println("Home Theater is OFF!");

        } catch (RuntimeException exception) {
            throw new HomeTheaterException(
                    "Failed to shut down Home Theater",
                    exception
            );
        }
    }

    private void shutdownTheater() {
        dvdPlayer.stop();
        dvdPlayer.turnOff();

        amplifier.turnOff();
        projector.turnOff();

        screen.up();
        lights.turnOn();

        popcornPopper.turnOff();
    }
}
