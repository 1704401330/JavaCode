package Bowling;

import Bowling.controller.StageController;
import javafx.application.Application;
import javafx.stage.Stage;

public class test extends Application {

    private StageController stageController ;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        stageController = StageController.getInstance();

        stageController.loadStage("login", "../view/login.fxml");
        stageController.loadStage("main", "../view/main.fxml");
        stageController.loadStage("join","../view/join.fxml");

        stageController.setStage("login");
    }

}
