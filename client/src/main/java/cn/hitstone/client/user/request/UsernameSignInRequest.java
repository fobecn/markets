package cn.hitstone.client.user.request;

public class UsernameSignInRequest {

    private String username;

    /**
     * 加密后的密码在使用端生成
     * rawPassword + salt + publicSalt
     */
    private String password;

    private String salt;

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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
