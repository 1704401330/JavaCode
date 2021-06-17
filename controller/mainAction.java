package Bowling.controller;

import Bowling.entity.Game.GameType;
import Bowling.entity.Member.Player;
import Bowling.entity.Member.Team;
import Bowling.entity.system.BowlingSys;
import Bowling.view.BowlingPane;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import java.util.*;

public class mainAction {

    private BowlingSys bowlingSys = BowlingSys.getInstance();
    private StageController stageController = StageController.getInstance();
    private BowlingPane pane = new BowlingPane();

    @FXML
    private Label Inf;
    @FXML
    private TextArea resultLable;

    @FXML
    public void join(){
        stageController.setStage("join","main");
    }
    @FXML
    public void start(){
        if(bowlingSys.isManager(bowlingSys.getCurrentPlayer())) bowlingSys.play();
        else if (!bowlingSys.getCurrentPlayer().getFlag())bowlingSys.getCurrentPlayer().play();
        else pane.paintHint("你已经比赛完毕！");

    }

    @FXML
    public void setInf(){
        if(!bowlingSys.isManager(bowlingSys.getCurrentPlayer())) pane.paintHint("对不起您不是管理员！");

        else {
            String result = pane.paintInput("请输入通知：");
            bowlingSys.setInf(result);
            Inf.setText(bowlingSys.getInf());
        }
    }

    @FXML
    public void getGameResult(){
        List<Team> teams= new ArrayList<>();
        for (Team team:bowlingSys.getTeams())
            if (team.getGameType().equals(bowlingSys.getGameType())) teams.add(team);
        String result = "队伍名称                    分数                    排名\n";
        int i=0,score=0;
        for(Team team:teams){
            if (score!=team.getAllScore()){
                score = team.getAllScore();
                 i++;
             }
            result =result+team.toString()+
                    String.format("%3d",team.getAllScore())+
                    "                    "+String.format("%2d\n",i);
            bowlingSys.getTeams().ceiling(team).setRanking(i);
        }
        resultLable.setText(result);
    }

    @FXML
    public void getSelfResult(){
        if(bowlingSys.isManager(bowlingSys.getCurrentPlayer())) resultLable.setText("您是管理员，没有参赛！");
        else {
            String str = "队伍名称                    分数                    排名\n";
            Team team = bowlingSys.searchTeam();
            Player player = bowlingSys.getCurrentPlayer();
            str = str + team.toString()+String.format("%3d",team.getAllScore())+
                    "                    "+String.format("%2d\n\n\n\n",team.getRanking())+
                    "个人分数：\n"+player.getScores().toString();
            resultLable.setText(str);
        }
    }

    @FXML
    public void removeAll(){
        if (bowlingSys.isManager(bowlingSys.getCurrentPlayer())) {
            bowlingSys.setFlag(false);
            bowlingSys.remove();
            resultLable.setText("");
            getGameResult();
        }
        else pane.paintHint("您没有权限！");
    }

    @FXML
    public void back(){
        stageController.setStage("login","main");
    }

    @FXML
    public void exit(){
        System.exit(0);
    }

    @FXML
    public void getSelfInf(){
        Inf.setText(bowlingSys.getCurrentPlayer().toString());
    }

    @FXML
    public void getInf(){
        Inf.setText(bowlingSys.getInf());
    }

    @FXML
    public void setSingleGame(){
        bowlingSys.setGameType(GameType.SINGLE);
    }

    @FXML
    public void setDoubleGame(){
        bowlingSys.setGameType(GameType.DOUBLE);
    }

    @FXML
    public void setTripleGame(){
        bowlingSys.setGameType(GameType.TRIPLE);
    }

    @FXML
    public void setQuinGame(){
        bowlingSys.setGameType(GameType.QUINTUPLE);
    }

    @FXML
    public void setEliteGame(){
        bowlingSys.setGameType(GameType.ELITE);
    }

    @FXML
    public void  setVerGame(){
        bowlingSys.setGameType(GameType.VERSATILE);
    }

}
