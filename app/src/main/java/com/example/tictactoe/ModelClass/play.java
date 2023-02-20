package com.example.tictactoe.ModelClass;

import java.util.HashMap;

public class play {

    public play(String gameId, String time, String name, String email) {
        this.gameId = gameId;
        this.time = time;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.map = map;
    }

    String gameId;
    String time;
    String name;
    String email;
    String phone;
    HashMap<String,String> map;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }
}

