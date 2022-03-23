package animal;

import com.google.gson.annotations.SerializedName;

public class About {
    private String id;
    private String text;
    private Animal type;
    private String user;
    @SerializedName(value = "upvotes")
    private Integer upvote;

    public About(String id,
                 String text,
                 Animal type,
                 String user,
                 Integer upvote) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvote = upvote;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Animal getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public Integer getUpvote() {
        return upvote;
    }

    @Override
    public String toString() {
        return "About{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", type=" + type +
                ", user='" + user + '\'' +
                ", upvote=" + upvote +
                '}';
    }
}
