package Bowling.controller;

import Bowling.entity.system.BowlingSys;
import Bowling.view.BowlingPane;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginAction {
    @FXML
    private TextField accountText;
    @FXML
    private PasswordField passwordField;

    private BowlingSys bowlingSys = BowlingSys.getInstance();
    private StageController stageController = StageController.getInstance();
    private BowlingPane pane = new BowlingPane();

    @FXML
    public void login(){
        String account = accountText.getText();
        String password = passwordField.getText();
        if (bowlingSys.isLegal(account,password)){
            bowlingSys.setCurrentPlayer(bowlingSys.searchPlayer(account));
            stageController.setStage("main","login");
        }
        else pane.paintHint("密码或账户错误！");
    }

    @FXML
    public void forgetPassWord(){
        String telphone = pane.paintInput("请输入电话:");
        if (telphone==bowlingSys.searchPlayer(accountText.getText()).getPhoneNum())
            bowlingSys.searchPlayer(accountText.getText()).setPassword(pane.paintInput("请输入新密码："));
        else pane.paintHint("验证电话错误！");
    }

}
