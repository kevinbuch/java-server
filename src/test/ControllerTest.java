import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(JUnit4.class)
public class ControllerTest {

    public Request request = mock(Request.class);
    public Controller controller = new Controller();

    @Test
    public void returnsNotAllowed() {
        request.method = "GET";
        request.route = "/";
        assertEquals(405, controller.send(request).status);
    }

    @Test
    public void returnsNotAllowedPost() {
        request.method = "POST";
        request.route = "/";
        assertEquals(405, controller.send(request).status);
    }

        @Test
    public void returnsNotAllowedPut() {
        request.method = "PUT";
        request.route = "/";
        assertEquals(405, controller.send(request).status);
    }

    @Test
    public void returnsNotAllowedDelete() {
        request.method = "DELETE";
        request.route = "/";
        assertEquals(405, controller.send(request).status);
    }

    @Test
    public void returnsNotAllowedHead() {
        request.method = "HEAD";
        request.route = "/";
        assertEquals(405, controller.send(request).status);
    }

    @Test
    public void returnsOptions() {
        request.method = "OPTIONS";
        request.route = "/";
        assertEquals(200, controller.send(request).status);
    }
}
