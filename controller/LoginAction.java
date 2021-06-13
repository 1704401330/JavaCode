package Bowling.controller;

import Bowling.entity.system.BowlingSys;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginAction {
    @FXML
    private TextField accountText;
    @FXML
    private PasswordField passwordText;

    private BowlingSys bowlingSys = BowlingSys.getInstance();
    private StageController stageController = StageController.getInstance();

    @FXML
    public void login(){
        String account = accountText.getText();
        String password = passwordText.getText();
        if (bowlingSys.isLegal(account,password)){
            stageController.setStage("main","login");
        }
        else System.out.println("错误！");
    }

}
