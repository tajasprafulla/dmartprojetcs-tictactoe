package com.example.tictactoe.ModelClass;

public class OnlinePlayer {
    String status;
    String invite;
    String role;


    public OnlinePlayer(String status, String invite, String role) {
        this.status = status;
        this.invite = invite;
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInvite() {
        return invite;
    }

    public void setInvite(String invite) {
        this.invite = invite;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



}
