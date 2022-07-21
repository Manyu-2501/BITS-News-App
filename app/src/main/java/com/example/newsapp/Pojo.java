package com.example.newsapp;

public class Pojo {
    String content;
    String username;
    String email;

    public Pojo(String content,String username,String email){
        this.content = content;
        this.username = username;
        this.email = email;
    }



    public String getPostContent(){
        return this.content;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setPostContent(String content){
        this.content = content;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
