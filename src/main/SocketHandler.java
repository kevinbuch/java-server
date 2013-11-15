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
            Request request = makeRequest(inputString(input));
            System.out.println(request.inputString);
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

    public Request makeRequest(String inputString) {
        return new Request(inputString);
    }

    public static String inputString(InputStream input) throws IOException {
        StringBuffer output = new StringBuffer();
        byte[] bytes = new byte[4096];
        output.append(new String(bytes, 0, input.read(bytes)));
        return output.toString();
    }
}
