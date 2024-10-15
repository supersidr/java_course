import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int HTTP_PORT = 9999;
    private static final int MAX_CONNECTIONS = 64;

    private final List<String> validPaths = List.of("/index.html", "/spring.svg", "/spring.png", "/resources.html", "/styles.css", "/app.js", "/links.html", "/forms.html", "/classic.html", "/events.html", "/events.js");
    private final ExecutorService executorService = Executors.newFixedThreadPool(MAX_CONNECTIONS);


    public Server() {
    }

    private static String pathFound(String mimeType, long length) throws IOException {
        return "HTTP/1.1 200 OK\r\n" +
                "Content-Type: " + mimeType + "\r\n" +
                "Content-Length: " + length + "\r\n" +
                "Connection: close\r\n" +
                "\r\n";
    }

    private static void pathNotFound(BufferedOutputStream out) throws IOException {
        out.write((
                "HTTP/1.1 404 Not Found\r\n" +
                        "Content-Length: 0\r\n" +
                        "Connection: close\r\n" +
                        "\r\n"
        ).getBytes());
        out.flush();
    }

    public void start() {
        try (final var serverSocket = new ServerSocket(HTTP_PORT)) {
            while (true) {
                final var socket = serverSocket.accept();
                executorService.submit(() -> connect(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect(Socket socket) {
        try (
                socket;
                final var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                final var out = new BufferedOutputStream(socket.getOutputStream())
        ) {
            // read only request line for simplicity
            // must be in form GET /path HTTP/1.1
            final String[] parts = getParts(in);
            final var path = parts[1];

            if (parts.length != 3) {
                // just close socket
            } else if (!validPaths.contains(path)) {
                pathNotFound(out);
            } else {
                getTrueResponse(out, path);
            }

//            final var path = parts[1];
//            if (!validPaths.contains(path)) {
//                pathNotFound(out);
//                continue;
//            }

            final var filePath = Path.of(".", "public", path);
            final var mimeType = Files.probeContentType(filePath);

            getTrueResponse(out, path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getTrueResponse( BufferedOutputStream out,  String path) throws IOException {
        // special case for classic
        var filePath = Path.of(".", "public", path);
        var mimeType = Files.probeContentType(filePath);
        if (path.equals("/classic.html")) {
            final var template = Files.readString(filePath);
            final var content = template.replace(
                    "{time}",
                    LocalDateTime.now().toString()
            ).getBytes();
            out.write(pathFound(mimeType, content.length).getBytes());
            out.write(content);
        } else {
            final var length = Files.size(filePath);
            out.write(pathFound(mimeType,length).getBytes());
            Files.copy(filePath, out);
        }
        out.flush();
    }

    private static String[] getParts(BufferedReader in) throws IOException {
        final var requestLine = in.readLine();
        return requestLine.split(" ");
    }
}
