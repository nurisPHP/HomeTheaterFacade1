
package hometheater.subsystem;

public class DvdPlayer {

    private boolean isOn = false;
    private boolean isPlaying = false;

    public void turnOn() {
        isOn = true;
        System.out.println("DVD Player is ON");
    }

    public void play(String movie) {
        if (!isOn) {
            throw new IllegalStateException(
                    "DVD Player must be ON first");
        }

        if (movie == null || movie.isBlank()) {
            throw new IllegalArgumentException(
                    "Movie title cannot be empty");
        }

        isPlaying = true;
        System.out.println("Playing movie: " + movie);
    }

    public void stop() {
        if (isPlaying) {
            isPlaying = false;
            System.out.println("Movie stopped");
        }
    }

    public void turnOff() {
        stop();
        isOn = false;
        System.out.println("DVD Player is OFF");
    }
}
