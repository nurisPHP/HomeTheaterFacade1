
package hometheater.subsystem;

public class Projector {

    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("Projector is ON");
    }

    public void setWideScreenMode() {
        if (!isOn) {
            throw new IllegalStateException(
                    "Projector must be ON first");
        }

        System.out.println("Wide screen mode enabled");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Projector is OFF");
    }
}
