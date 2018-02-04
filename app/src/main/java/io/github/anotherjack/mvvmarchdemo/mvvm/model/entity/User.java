package io.github.anotherjack.mvvmarchdemo.mvvm.model.entity;

/**
 * Created by jack on 2018/2/2.
 */

public class User {
    private int id;
    private String login;
    private String avatar_url;

    public User(int id, String login, String avatar_url) {
        this.id = id;
        this.login = login;
        this.avatar_url = avatar_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
