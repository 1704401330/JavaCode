package Bowling.entity.system;

import Bowling.entity.Game.GameType;
import Bowling.entity.Member.Member;
import Bowling.entity.Member.Player;
import Bowling.entity.Member.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class BowlingSys {

    private Member member;
    private List<Player> players = new ArrayList<>();
    private TreeSet<Team> teams = new TreeSet<Team>();

    private static BowlingSys instance = null;

    public static BowlingSys getInstance(){
        if(instance==null) {
            instance = new BowlingSys();
            instance.InitialPlayer();

        }
        return instance;
    }

    public void play(){
        for(Player player:players)
            player.play();
        instance.InitialTeam();
    }

    /**
     * 分组
     */
    public void InitialTeam(){
        Team team = null;int i=0;
        for(Player player:players){
            if(team == null) {
                team = new Team(
                        String.format("队列%d号",i),
                        rand()
                );
            }
            else {
                team.addPlayer(player);
                team.setPlayerNum(team.getPlayerNum()+1);
            }
            if(team.getPlayerNum()==team.getGameType().getNum()) {
                team = null;
                i++;
            }
        }
        for(Team team1:teams){
            for(Player player:team1.getPlayers()){
                System.out.println(player.toString());
            }
        }

    }

    public GameType rand(){
        Random rd = new Random();
        return switch (rd.nextInt(6)){
            case 0 -> GameType.SINGLE;
            case 1 -> GameType.DOUBLE;
            case 2 -> GameType.TRIPLE;
            case 3 -> GameType.QUINTUPLE;
            case 4 -> GameType.ELITE;
            case 5 -> GameType.VERSATILE;
            default -> throw new IllegalStateException("Unexpected value: " + rd.nextInt(6));
        };
    }
    public void InitialPlayer(){
        Player player;
        for(int i=0;i <100;i++){
            player = new Player(
                    String.format("人机%d号",i+1),
                    String.format("%d",10000+i+1),
                    String.format("123456"),
                    String.format("123456%d",i),
                    String.format("南昌市")
            );
            players.add(player);
        }

    }



    public Player searchPlayer(String account){
        for(Player player:players){
            if(player.account.equals(account)) return player;
        }
        return null;
    }

    public boolean isLegal(String account,String passworld){
        Player player = searchPlayer(account);
        if(player!=null){
            if(player.password.equals(passworld)) {
                member = player;
                return true;
            }
        }
        return false;
    }

    public TreeSet<Team> getTeams() {
        return teams;
    }

    public void setTeams(Team team) {
        teams.add(team);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
