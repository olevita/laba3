package mypackage;

import arrayaccess.ArrayFileWriter;
import arrayaccess.Fill;
import arrayaccess.Model;
import arrayaccess.Sort;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        VBox menu = new VBox();
        Model array = new Model(0,0);
        TextField x = new TextField();
        x.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                x.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        x.setPromptText("Width");
        x.setMaxWidth(100);

        TextField y = new TextField();
        y.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                y.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        y.setPromptText("Height");
        y.setMaxWidth(100);

        Button generateArray = new Button("Generate array");
        generateArray.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int width = Integer.parseInt(x.getText());
                int height = Integer.parseInt(y.getText());
                array.setArray(new int[width][height]);
                Fill.fill(array, 0);
            }
        });

        Button showArray = new Button("Show array");
        showArray.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage showStage = new Stage();
                showStage.setTitle("Array");
                String arrayString = array.toString();
                arrayString = arrayString.substring(1, arrayString.length() - 1);
                arrayString = String.join("\n", arrayString.split("\\]\\["));
                Label label = new Label(arrayString);

                Scene showScene = new Scene(label);
                showStage.setScene(showScene);
                showStage.show();
            }
        });

        Button sortArray = new Button("Sort array");
        sortArray.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Sort.sort(array);
            }
        });

        Button saveToFileArray = new Button("Save to file");
        saveToFileArray.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ArrayFileWriter.write(array);
            }
        });

        menu.getChildren().addAll(generateArray, x, y, showArray, sortArray, saveToFileArray);
        menu.setPadding(new Insets(10, 50, 50, 50));
        menu.setSpacing(10);

        Scene scene = new Scene(menu);
        stage.setScene(scene);
        stage.setTitle("Array Access");
        stage.setWidth(300);
        stage.setHeight(250);
        stage.setMaxWidth(300);
        stage.setMaxHeight(250);
        stage.setMinWidth(300);
        stage.setMinHeight(250);
        stage.show();
    }
}
