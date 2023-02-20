package com.example.tictactoe.ModelClass;

public class onlineLoginModel {



    private String status= "";
    private String apid = "";
    private String opid = "" ;
    private String gameId = "";
    private String requeststatus="";
    private String invite="";


    public onlineLoginModel(String status, String apid, String opid, String gameId, String requeststatus) {

        this.status = status;
        this.apid = apid;
        this.opid = opid;
        this.gameId = gameId;
        this.requeststatus = requeststatus;
    }




    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApid() {
        return apid;
    }

    public void setApid(String apid) {
        this.apid = apid;
    }

    public String getOpid() {
        return opid;
    }

    public void setOpid(String opid) {
        this.opid = opid;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getRequeststatus() {
        return requeststatus;
    }

    public void setRequeststatus(String requeststatus) {
        this.requeststatus = requeststatus;
    }




}
