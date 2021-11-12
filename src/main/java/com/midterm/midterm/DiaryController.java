package com.midterm.midterm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class DiaryController extends Note implements Initializable, MainInterface {

    @FXML
    private MenuItem arial;

    @FXML
    private MenuItem century;


    @FXML
    private MenuItem dubai;

    @FXML
    private MenuItem gabriola;


    @FXML
    private MenuItem serif;


    @FXML
    public TextArea txtField;

    @FXML
    private MenuItem size11;

    @FXML
    private MenuItem size12;

    @FXML
    private MenuItem size15;

    @FXML
    private MenuItem size17;

    @FXML
    private MenuItem size20;

    @FXML
    private MenuItem size24;

    @FXML
    private MenuItem size27;

    @FXML
    private ColorPicker colorPicker;


    @FXML
    private MenuItem bGColor;

    @FXML
    private MenuItem txtColorBtn;

    FileChooser file = new FileChooser();



    @Override
    public void clearTxt() {
        txtField.clear();

    }

    @Override
    public void importFile() {

        File newFile = file.showOpenDialog(new Stage());
        try {
            Scanner scan = new Scanner(newFile);
            while (scan.hasNextLine()) {
                txtField.appendText(scan.nextLine() + "\n");
            }
        } catch (Error | FileNotFoundException e) {
            showAlert("This file can not be imported. Choose another file or try again!");

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void save() {
        File newFile = file.showSaveDialog(new Stage());
        if (newFile!= null) {
            saveSystem(newFile, txtField.getText());
        }
    }

    @Override
    public void saveSystem(File file, String content) {

        try {

            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(content);
            printWriter.close();

        } catch (FileNotFoundException e) {

            showAlert("Error appeared. Try again!");

        }

    }

    @Override
    public void changeFont(ActionEvent event) {
        if (arial.equals(event.getSource())) {
            changeTxtFont("Arial");
        } else if (serif.equals(event.getSource())) {
            changeTxtFont("Serif");
        } else if (dubai.equals(event.getSource())) {
            changeTxtFont("Dubai");
        } else if (gabriola.equals(event.getSource())) {
            changeTxtFont("Gabriola");
        } else if (century.equals(event.getSource())) {
            changeTxtFont("Century Gothic");
        }

    }

    @Override
    public void changeSize(ActionEvent event) {
        if (size11.equals(event.getSource())) {
            changeTxtSize("11");
        } else if (size12.equals(event.getSource())) {
            changeTxtSize("12");
        } else if (size15.equals(event.getSource())) {
            changeTxtSize("15");
        } else if (size17.equals(event.getSource())) {
            changeTxtSize("17");
        } else if (size20.equals(event.getSource())) {
            changeTxtSize("20");
        } else if (size24.equals(event.getSource())) {
            changeTxtSize("24");
        } else if (size27.equals(event.getSource())) {
            changeTxtSize("27");
        }
    }

    @Override
    public void changeTxtFont(String newFont) {
        txtField.setFont(Font.font(newFont));
    }

    @Override
    public void changeTxtSize(String size) {
        txtField.setStyle("-fx-font-size: " + size + ";");
    }


    @Override
    public void changeColor(ActionEvent event) {
        if (txtColorBtn.equals(event.getSource())) {
            txtField.setStyle("-fx-text-fill: " + toRGBCode(colorPicker.getValue()));
        } else if (bGColor.equals(event.getSource())) {
            txtField.setStyle("-fx-background-color: " + toRGBCode(colorPicker.getValue()));
        }

    }

    public static String toRGBCode( Color color )
    {
        return String.format( "#%02X%02X%02X",
                (int)( color.getRed() * 255 ),
                (int)( color.getGreen() * 255 ),
                (int)( color.getBlue() * 255 ) );
    }

}

