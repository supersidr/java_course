import com.fasterxml.jackson.annotation.JsonProperty;

public class CatsFacts {
    private final String id;
    private final String text;
    private final String user;
    private final String upvotes;

    public CatsFacts(
            @JsonProperty("id") String id,
            @JsonProperty("text") String text,
            @JsonProperty("type") String user,
            @JsonProperty("upvotes") String upvotes) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.upvotes = upvotes;
    }

    public String getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", user='" + user + '\'' +
                ", upvotes='" + upvotes + '\'' +
                '}';
    }
}
