
package hometheater.subsystem;

public class Lights {

    private int brightness = 100;

    public void dim(int level) {
        if (level < 0 || level > 100) {
            throw new IllegalArgumentException(
                    "Brightness must be between 0 and 100");
        }

        brightness = level;
        System.out.println("Lights brightness: " + brightness + "%");
    }

    public void turnOn() {
        brightness = 100;
        System.out.println("Lights are ON (100%)");
    }
}
