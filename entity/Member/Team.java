package Bowling.entity.Member;

import Bowling.entity.Game.GameType;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name ;
    private List<Player> players = new ArrayList<>();
    private GameType gameType;
    private int allScore;
    private int playerNum = 0;

    public Team(String name, GameType gameType) {
        this.name = name;
        this.gameType = gameType;

    }

    public Team(String name, List<Player> players, GameType gameType) {
        this.name = name;
        this.players = players;
        this.gameType = gameType;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public int compareTo(Team team){
        int result = Integer.compare(allScore, team.allScore);
        if(result == 0) result = name.compareTo(team.name);
        return result;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    public void add(Player player){
        if(players.size()==2) {
            System.out.println("错误！");
            return ;
        }
        players.add(player);
    }

    public int getAllScore(){
        for (Player player : players){
            allScore += player.getAllScore();
        }
        return allScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAllScore(int allScore) {
        this.allScore = allScore;
    }
}
