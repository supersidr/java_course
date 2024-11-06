import org.apache.hc.core5.http.NameValuePair;
import java.util.List;
import java.util.Optional;

public class Request {
    private final String method;
    private final String path;
    private final String version;
    private final List<String> headers;
    private final byte[] body;

    private final List<NameValuePair> getParams;
    private final List<NameValuePair> postParams;

    public Request(String method,
                   String path,
                   String version,
                   List<String> headers,
                   byte[] body,
                   List<NameValuePair> getParams,
                   List<NameValuePair> postParams
    ) {
        this.method = method;
        this.path = path;
        this.version = version;
        this.headers = headers;
        this.body = body;
        this.getParams = getParams;
        this.postParams = postParams;
    }


    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }


    public byte[] getBody() {
        return body;
    }

    public Optional<String> getHeaders(String name) {
        return RequestParser.extractHeader(headers, name);
    }

    public String getVersion() {
        return version;
    }

    public List<NameValuePair> getGetParams() {
        return getParams;
    }

    public String getGetParam(String name) {
        return getParams.stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .map(NameValuePair::getValue)
                .orElse(null);
    }

    public List<NameValuePair> getPostParams() {
        return postParams;
    }

    public String getPostParam(String name) {
        return postParams.stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .map(NameValuePair::getValue)
                .orElse(null);
    }
}
