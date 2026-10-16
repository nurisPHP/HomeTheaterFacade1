
package hometheater.subsystem;

public class Screen {

    private boolean isDown = false;

    public void down() {
        if (!isDown) {
            isDown = true;
            System.out.println("Screen is DOWN");
        }
    }

    public void up() {
        if (isDown) {
            isDown = false;
            System.out.println("Screen is UP");
        }
    }
}
