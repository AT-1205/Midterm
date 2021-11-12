package com.midterm.midterm;

import javafx.event.ActionEvent;

import java.io.File;
import java.io.IOException;

public interface NoteInterface {
    void createNewNote(ActionEvent event) throws IOException;
    void getInfo(ActionEvent event) throws IOException;
    void exit();
}

interface MainInterface {
    void clearTxt();
    void importFile();
    void save();
    void saveSystem(File file, String content);
    void changeFont(ActionEvent event);
    void changeSize(ActionEvent event);
    void changeTxtFont(String newFont);
    void changeTxtSize(String size);
    void changeColor(ActionEvent event);


}
