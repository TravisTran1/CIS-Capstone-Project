package Logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User admin = new User(false, true, "sl4y3r", 857403049, "tanjir0@gmail.com", "Kamado Tanjiro");
    @Test
    void getSubscriber() {
        assertEquals(false, admin.getSubscriber());
    }

    @Test
    void getAdmin() {
        assertEquals(true, admin.getAdmin());
    }

    @Test
    void getUsername() {
        assertEquals("sl4y3r", admin.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals(857403049, admin.getPassword());
    }

    @Test
    void getEmail() {
        assertEquals("tanjir0@gmail.com", admin.getEmail());
    }

    @Test
    void getFullName() {
        assertEquals("Kamado Tanjiro", admin.getFullName());
    }
}