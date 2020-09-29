package com.example.chorsiphai.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Game implements Serializable {
    @SerializedName("gid")
    @Expose
    public Integer gid;
    @SerializedName("gameCode")
    @Expose
    public String gameCode;
    @SerializedName("turnsRemaining")
    @Expose
    public int turnsRemaining;
    @SerializedName("winner")
    @Expose
    public User winner;
    @SerializedName("player2")
    @Expose
    public User player2;
    @SerializedName("player3")
    @Expose
    public User player3;
    @SerializedName("player4")
    @Expose
    public User player4;
    @SerializedName("player1")
    @Expose
    public User player1;
    @SerializedName("lastPlayer")
    @Expose
    public Integer lastPlayer;
    @SerializedName("completed")
    @Expose
    public Boolean completed;
    @SerializedName("aborted")
    @Expose
    public Boolean aborted;

    @Override
    public String toString() {
        return "Game{" +
                "gid=" + gid +
                ", gameCode='" + gameCode + '\'' +
                ", turnsRemaining=" + turnsRemaining +
                ", winner=" + winner +
                ", player2=" + player2 +
                ", player3=" + player3 +
                ", player4=" + player4 +
                ", player1=" + player1 +
                ", lastPlayer=" + lastPlayer +
                ", completed=" + completed +
                ", aborted=" + aborted +
                '}';
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGameCode() {
        return gameCode;
    }

    public void setGameCode(String gameCode) {
        this.gameCode = gameCode;
    }

    public int getTurnsRemaining() {
        return turnsRemaining;
    }

    public void setTurnsRemaining(int turnsRemaining) {
        this.turnsRemaining = turnsRemaining;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }

    public User getPlayer2() {
        return player2;
    }

    public void setPlayer2(User player2) {
        this.player2 = player2;
    }

    public User getPlayer3() {
        return player3;
    }

    public void setPlayer3(User player3) {
        this.player3 = player3;
    }

    public User getPlayer4() {
        return player4;
    }

    public void setPlayer4(User player4) {
        this.player4 = player4;
    }

    public User getPlayer1() {
        return player1;
    }

    public void setPlayer1(User player1) {
        this.player1 = player1;
    }

    public Integer getLastPlayer() {
        return lastPlayer;
    }

    public void setLastPlayer(Integer lastPlayer) {
        this.lastPlayer = lastPlayer;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Boolean getAborted() {
        return aborted;
    }

    public void setAborted(Boolean aborted) {
        this.aborted = aborted;
    }
}
