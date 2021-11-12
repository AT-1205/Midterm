package com.midterm.midterm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller extends Note implements Initializable, NoteInterface {

    @FXML
    public Button newNoteBtn;
    @FXML
    public Button aboutBtn;
    @FXML
    private Button exitBtn;


    @Override
    public void exit() {
        if(closeProgram()) {
            Stage stage = (Stage) exitBtn.getScene().getWindow();
            stage.close();
        }
    }


    @Override
    public void createNewNote(ActionEvent event) throws IOException {
        newStage(event, "diary.fxml");
    }



    @Override
    public void getInfo(ActionEvent event) throws IOException {
        newStage(event, "infoPage.fxml");

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}