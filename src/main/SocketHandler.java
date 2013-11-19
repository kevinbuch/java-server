import java.net.*;
import java.io.*;

public class SocketHandler implements Runnable {

    public Socket socket;
    public static Callable app;

    public SocketHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            Request request = makeRequest(input);
            Response response = app.call(request);
            output.write(response.output());
            output.flush();
            input.close();
            output.close();
            socket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public Request makeRequest(InputStream input) throws IOException {
        return new Request(input);
    }
}
