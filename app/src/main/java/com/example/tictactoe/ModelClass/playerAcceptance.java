package com.example.tictactoe.ModelClass;

public class playerAcceptance {



    private String apid;
    private String opid;
    private String request_status;
    private String gameId;


    public playerAcceptance(String apid, String opid, String request_status, String gameId) {
        this.apid = apid;
        this.opid = opid;
        this.request_status = request_status;
        this.gameId = gameId;
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

    public String getRequest_status() {
        return request_status;
    }

    public void setRequest_status(String request_status) {
        this.request_status = request_status;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

}
