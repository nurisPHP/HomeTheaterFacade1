
package hometheater.subsystem;

public class PopcornPopper {

    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("Popcorn Popper is ON");
    }

    public void pop() {
        if (!isOn) {
            throw new IllegalStateException(
                    "Popcorn Popper must be ON first");
        }

        System.out.println("Popcorn is ready!");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Popcorn Popper is OFF");
    }
}
