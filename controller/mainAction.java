package Bowling.controller;

import Bowling.entity.Member.Player;
import Bowling.entity.Member.Team;
import Bowling.entity.system.BowlingSys;
import javafx.fxml.FXML;

public class mainAction {
    private BowlingSys bowlingSys = BowlingSys.getInstance();
    private StageController stageController = StageController.getInstance();

    @FXML
    public void start(){

       bowlingSys.play();

    }

    @FXML
    public void getGameInf(){
        for (Team team:bowlingSys.getTeams()){
            for(Player player: team.getPlayers())
                System.out.println(player.toString());
        }
    }

}
