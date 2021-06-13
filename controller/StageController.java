package Bowling.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.HashMap;

public class StageController {
    private HashMap<String, Stage> stages = new HashMap<String, Stage>();

    private static StageController instance = null;
    public static StageController getInstance(){
        if(instance == null) {
            instance = new StageController();
        }
        return instance;
    }

    public void addStage(String name , Stage stage){
        stages.put(name,stage);
    }

    public Stage getStage(String name){
        return stages.get(name);
    }

    public void setPrimaryStage(String primaryStageName, Stage primaryStage) {
        this.addStage(primaryStageName, primaryStage);
    }

    public boolean loadStage(String name, String resources, StageStyle...styles){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resources));
            AnchorPane pane =(AnchorPane) fxmlLoader.load();

            //构造对应的Stage
            Scene scene = new Scene(pane,600,400);
            Stage stage = new Stage();
            stage.setScene(scene);

            // 配置initStyle
            for(StageStyle style:styles){
                stage.initStyle(style);
            }

            this.addStage(name,stage);

            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean setStage(String name){
        this.getStage(name).show();
        return true;
    }

    public boolean setStage(String show,String close){
        getStage(close).close();
        setStage(show);
        return true;
    }

}
