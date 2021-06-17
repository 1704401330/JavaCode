package Bowling.entity.system;

import Bowling.entity.Game.GameType;
import Bowling.entity.Member.Player;
import Bowling.entity.Member.Team;
import Bowling.view.BowlingPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class BowlingSys {

    private List<Player> players = new ArrayList<>();
    private TreeSet<Team> teams = new TreeSet<Team>();
    private Player CurrentPlayer;
    private GameType gameType;
    private String inf="暂无通知！";
    private boolean flag = false;

    private static BowlingSys instance = null;
    private BowlingPane bowlingPane = new BowlingPane();

    public static BowlingSys getInstance(){
        if(instance==null) {
            instance = new BowlingSys();
            instance.InitialPlayer();
            instance.InitialTeam();
        }
        return instance;
    }

    /**
     * 开始比赛
     */
    public void play(){
        if(!flag) {
            TreeSet<Team> newteams = new TreeSet<>();
            for (Team team : teams) {
                if (!team.getFlag()) {
                    team.play();
                    newteams.add(new Team(team.getName(), team.getGameType(), team.calAllScore(), team.getPlayerNum(), team.getPlayers(), true));
                }
            }
            teams = newteams;
            flag = true;
        }
        else bowlingPane.paintHint("已经比赛完毕！");
    }

    /**
     * 分组
     */
    public void InitialTeam(){
        Team team = null;int i=0,j=0;
        for(Player player:players){
            if (isManager(player)) continue;
            if(team == null) {
                team = new Team(
                        String.format("队伍%03d号",i),
                        rand()
                );
            }
            team.addPlayer(player);
            team.setPlayerNum(team.getPlayerNum()+1);
            if(team.getPlayerNum()==team.getGameType().getNum()) {
                teams.add(team);
                team = null;
                i++;
            }
            j++;
            if(j>100) break;
        }
    }

    /**
     * 随机 比赛
     * @return
     */
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

    /**
     * 初始化 人员
     */
    public void InitialPlayer(){
        Player player;
        for(int i=0;i <300;i++){
            player = new Player(
                    String.format(i>100?"人机%03d号":"管理员%03d号",i+1),
                    String.format("%d",i>100? 20000+i+1:10000+i+1),
                    String.format("123456"),
                    String.format("123456%03d",i),
                    String.format("南昌市")
            );
            players.add(player);
        }
    }

    /**
     * 搜寻 所在队伍
     * @return
     */
    public Team searchTeam(){
        for(Team team:teams){
            for(Player player:team.getPlayers())
                if(player.getAccount()== CurrentPlayer.account) {
                    setCurrentPlayer(player);
                    return team;
                }
        }
        return null;
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
                CurrentPlayer = player;
                return true;
            }
        }
        return false;
    }

    /**
     * 删除比赛记录
     */
    public void remove(){
        TreeSet<Team> newteams = new TreeSet<>();
        for (Team team : teams)
            if (team.getFlag()) {
                team.remove();
                newteams.add(new Team(team.getName(), team.getGameType(), 0, team.getPlayerNum(), team.getPlayers(), false));
            }
        teams = newteams;
        for(int i=0;i<players.size();i++){
            players.get(i).setFlag(false);
            players.get(i).remove();
        }
    }

    /**
     * 是否是管理员
     * @param player
     * @return
     */
    public boolean isManager(Player player){
        if (player.getAccount().compareTo("20000")<0) return true;
        return false;
    }

    public TreeSet<Team> getTeams() {
        return teams;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public Player getCurrentPlayer() {
        return CurrentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        CurrentPlayer = currentPlayer;
    }

    @Override
    public String toString() {
        return "BowlingSys{" +
                "players=" + players +
                ", teams=" + teams +
                ", CurrentPlayer=" + CurrentPlayer +
                ", gameType=" + gameType +
                '}';
    }

    public String getInf() {
        return inf;
    }

    public void setInf(String inf) {
        this.inf = inf;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setTeams(TreeSet<Team> teams) {
        this.teams = teams;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
