import java.io.IOException;

public class Main {

    public static void main(String [] args) throws IOException {
        Arguments arguments = new Arguments(args);
        SocketHandler.app = new RequestHandler(arguments.directory());
        Server server = new Server(arguments.port());
        server.start();
    }
}
