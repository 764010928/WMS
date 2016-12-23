package crazysheep.io.scanner.net.Entity;

/**
 * Created by Bing on 2016/12/9.
 */

public class UserEntity {

    /**
     * username : terminal
     * password : 123456
     * storeId : 1
     */

    private String username;
    private String password;
    private String storeId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
}
