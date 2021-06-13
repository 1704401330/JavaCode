package Bowling;

import Bowling.controller.StageController;
import javafx.application.Application;
import javafx.stage.Stage;

public class test extends Application {
    private StageController stageController ;

    private static String longinView = "login";
    private static String loginViewRes = "../view/login.fxml";

    private static String mainView = "main";
    private static String mainViewRes = "../view/main.fxml";
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        stageController = StageController.getInstance();

        stageController.loadStage(longinView, loginViewRes);
        stageController.loadStage(mainView, mainViewRes);

        stageController.setStage(longinView);
    }
}
