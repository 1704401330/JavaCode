package Bowling.view;

import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;

public class BowlingPane {
    /**
     * 输入匡
     * @param str
     * @return
     */
    public String paintInput(String str) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("保龄球系统");
        dialog.setHeaderText("信息输入!");
        dialog.setContentText(str);

        //输入并转换为 int 型
        Optional<String> input = dialog.showAndWait();
        if(input.isEmpty()) return null;
        return input.get();
    }
    /**
     * 提示匡
     * @param str
     */
    public void paintHint(String str){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("保龄球系统");
        alert.setHeaderText("提示！");
        alert.setContentText(str);
        alert.showAndWait();
    }
}
