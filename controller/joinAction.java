package Bowling.controller;

import Bowling.entity.Game.GameType;
import Bowling.entity.Member.Player;
import Bowling.entity.Member.Team;
import Bowling.entity.system.BowlingSys;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class joinAction {

    private GameType gameType;
    private BowlingSys bowlingSys = BowlingSys.getInstance();
    private StageController stageController = StageController.getInstance();

    @FXML
    private TextField teamName;
    @FXML
    private TextField player1;
    @FXML
    private TextField player2;
    @FXML
    private TextField player3;
    @FXML
    private TextField player4;
    @FXML
    private TextField player5;

    @FXML
    public void join(){
        String name = teamName.getText();
        String[] str ={ player1.getText(),
         player2.getText(),
         player3.getText(),
         player4.getText(),
         player5.getText()};

        List<Player> players = new ArrayList<>();
        for(int i=0;i<gameType.getNum();i++)
            players.add(bowlingSys.searchPlayer(str[i]));
        Team team = new Team(name,gameType,0, gameType.getNum(),players,false);
        bowlingSys.getTeams().add(team);
        stageController.setStage("main","join");
    }

    @FXML
    public void setSingleGame(){
        gameType = GameType.SINGLE;
    }

    @FXML
    public void setDoubleGame(){
        gameType = GameType.DOUBLE;
    }

    @FXML
    public void setTripleGame(){
        gameType = GameType.TRIPLE;
    }

    @FXML
    public void setQuinGame(){
        gameType = GameType.QUINTUPLE;
    }

    @FXML
    public void setEliteGame(){
        gameType = GameType.ELITE;
    }

    @FXML
    public void  setVerGame(){
        gameType = GameType.VERSATILE;
    }
}
