package Bowling.entity.Member;

import Bowling.entity.Game.GameType;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Team implements Comparable<Team>{

    private String name ;
    private GameType gameType;
    private int allScore;
    private int playerNum=0;
    private int ranking ;
    private List<Player> players = new ArrayList<>();
    private boolean flag = false;

    public Team(String name, GameType gameType) {
        this.name = name;
        this.gameType = gameType;
        this.allScore=0;
        this.playerNum=0;

    }

    public Team(String name, GameType gameType, int allScore, int playerNum, List<Player> players ,boolean flag) {
        this.name = name;
        this.gameType = gameType;
        this.allScore = allScore;
        this.playerNum = playerNum;
        this.players = players;
        this.flag = flag;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public int compareTo(Team team){

        int result = Integer.compare(team.getAllScore(),allScore);
        if(result == 0) result = this.getName().compareTo(team.getName());
        if(result ==0) result = this.getGameType().compareTo(team.getGameType());
        return result;
    }

    public void play(){
        for (Player player:players)
            player.play();
    }

    /**
     * 删除比赛记录
     */
    public  void remove(){
        for(int i=0;i<players.size();i++)
            players.get(i).remove();
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

    public int calAllScore(){
        int newallScore = 0;
        for (Player player : players){
            newallScore += player.getAllScore();
        }
        this.allScore = newallScore;
        return newallScore;
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

    public int getAllScore(){
        return allScore;
    }

    @Override
    public String toString() {
        return  name+
                "                    ";
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
