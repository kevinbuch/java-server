import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;
import java.net.*;
import java.io.*;

@RunWith(JUnit4.class)
public class SocketHandlerTest {

    @Test
    public void initsWithASocketAndDirectory() {
        SocketHandler handler = new SocketHandler(new Socket(), "/public");
        assertEquals(handler.socket.getClass(), Socket.class);
        assertEquals(handler.directory, "/public");
    }

    @Test
    public void parsesInputStream() throws IOException {
        InputStream input = new ByteArrayInputStream("Testing the input parser".getBytes());
        assertEquals("Testing the input parser", SocketHandler.inputString(input));
    }
}

