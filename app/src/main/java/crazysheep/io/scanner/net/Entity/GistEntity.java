package crazysheep.io.scanner.net.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yang.li on 2016/12/3.
 */
public class GistEntity implements IEntity {

    @SerializedName("id")
    protected String id;
    @SerializedName("url")
    protected String url;
    @SerializedName("created_at")
    protected String created_at;

    public String getCreated_at() {
        return created_at;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return String.format("\n{\nid: %s,\nurl: %s,\ncreated_at: %s\n}",
                id, url, created_at);
    }
}
