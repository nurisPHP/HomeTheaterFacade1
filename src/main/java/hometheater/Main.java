
package hometheater;

import hometheater.exception.HomeTheaterException;
import hometheater.facade.HomeTheaterFacade;

public class Main {

    public static void main(String[] args) {
        HomeTheaterFacade homeTheater =
                new HomeTheaterFacade();

        try {
            homeTheater.watchMovie("Interstellar");
            homeTheater.endMovie();

            System.out.println("\nTesting invalid movie title:");
            homeTheater.watchMovie("");

        } catch (HomeTheaterException exception) {
            System.out.println(
                    "Error: " + exception.getMessage()
            );
        }
    }
}
