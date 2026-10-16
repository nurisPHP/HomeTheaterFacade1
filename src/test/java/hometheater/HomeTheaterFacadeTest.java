
package hometheater;

import hometheater.exception.HomeTheaterException;
import hometheater.facade.HomeTheaterFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HomeTheaterFacadeTest {

    private HomeTheaterFacade homeTheater;

    @BeforeEach
    void setUp() {
        homeTheater = new HomeTheaterFacade();
    }

    // TEST 1: Valid movie
    @Test
    void shouldStartMovieSuccessfully() {
        assertDoesNotThrow(() ->
                homeTheater.watchMovie("Interstellar"));
    }

    // TEST 2: Empty movie title
    @Test
    void shouldRejectEmptyMovieTitle() {
        assertThrows(HomeTheaterException.class,
                () -> homeTheater.watchMovie(""));
    }

    // TEST 3: Null movie title
    @Test
    void shouldRejectNullMovieTitle() {
        assertThrows(HomeTheaterException.class,
                () -> homeTheater.watchMovie(null));
    }

    // TEST 4: Stop movie
    @Test
    void shouldStopMovieSuccessfully() {
        homeTheater.watchMovie("Avatar");

        assertDoesNotThrow(() ->
                homeTheater.endMovie());
    }

    // TEST 5: Stop without starting
    @Test
    void shouldRejectStoppingWithoutMovie() {
        assertThrows(HomeTheaterException.class,
                () -> homeTheater.endMovie());
    }

    // TEST 6: Start movie twice
    @Test
    void shouldRejectStartingSecondMovie() {
        homeTheater.watchMovie("Interstellar");

        assertThrows(HomeTheaterException.class,
                () -> homeTheater.watchMovie("Avatar"));
    }
}
