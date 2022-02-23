import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegisterFunctionTest {
    private RegisterServlet registerServlet = new RegisterServlet();
    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    @BeforeEach
    void setUp() throws Exception {
        username = "idk";
        password = "idk";
        email = "idk@gmail.com";
        phoneNumber = "999";
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testRegisterFunction() {
        //fail("Not yet implemented");
        int i = registerServlet.RegisterFunction(username, password, email,phoneNumber);
        //assertEquals(i,1);
        assertTrue(i > 0);
    }

}