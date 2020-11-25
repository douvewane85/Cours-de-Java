/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author user
 */
public class User {
    protected int id;
    protected String login;
    protected String pwd;
    protected String type;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    public User() {
    }

    //Creation
    public User(String login, String pwd) {
        this.login = login;
        this.pwd = pwd;
    }
    
    //Lister
    public User(int id, String login, String pwd) {
        this.id = id;
        this.login = login;
        this.pwd = pwd;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", login=" + login + ", pwd=" + pwd + ", type=" + type + '}';
    }
    
    
    
    
    
}
