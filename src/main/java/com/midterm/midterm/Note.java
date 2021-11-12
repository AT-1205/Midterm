package com.midterm.midterm;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Note {
    public Stage stage;
    public Scene scene;
    static boolean confirm;

    public void newStage(ActionEvent event, String currentStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Diary.class.getResource(currentStage)));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void backToMain(ActionEvent event) throws IOException {
        newStage(event, "welcomePage.fxml");
    }

    public void showAlert(String message) {
        Stage alertWindow = new Stage();
        alertWindow.initModality(Modality.APPLICATION_MODAL);
        alertWindow.setTitle("Error!");
        alertWindow.setMinWidth(200);

        Label label = new Label();
        label.setText(message);

        VBox layout = new VBox();
        layout.getChildren().add(label);

        Scene scene = new Scene(layout);
        alertWindow.setScene(scene);
        alertWindow.showAndWait();
    }

    public boolean closeProgram() {
        Stage alertWindow = new Stage();
        alertWindow.initModality(Modality.APPLICATION_MODAL);
        alertWindow.setTitle("Close");
        alertWindow.setMinWidth(300);

        Label label = new Label();
        label.setText("Are you sure you want to exit the program?");
        Button yesBtn = new Button("Yes");
        Button noBtn = new Button(("No"));



        yesBtn.setOnAction(e -> {
            confirm = true;
            alertWindow.close();
        });
        noBtn.setOnAction(e -> {
            confirm = false;
            alertWindow.close();
        });


        VBox layout = new VBox();
        layout.getChildren().addAll(label, yesBtn, noBtn);

        Scene scene = new Scene(layout);
        alertWindow.setScene(scene);
        alertWindow.showAndWait();

        return confirm;
    }
}
