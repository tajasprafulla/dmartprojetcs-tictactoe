package com.example.tictactoe.ModelClass;

import java.util.HashMap;

public class playeronline2 {

    String turner;

    public String getReset() {
        return reset;
    }

    public void setReset(String reset) {
        this.reset = reset;
    }

    String reset;

    public String getTurner() {
        return turner;
    }

    public void setTurner(String turner) {
        this.turner = turner;
    }

    public playeronline2(HashMap<String, String> map, String i, String turner,String reset) {

        this.i = i;
        this.map = map;
        this.turner = turner;
        this.reset = reset;
    }


    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }

    String i;
    HashMap<String,String> map;



}
