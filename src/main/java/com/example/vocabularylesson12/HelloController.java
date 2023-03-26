package com.example.vocabularylesson12;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.*;


public class HelloController {
    public Map<String, String> vocabulary = new HashMap<>();
    public TextField KeyInput=new TextField();
    public TextField ValueInput=new TextField();
    public ListView listViewKeys;
    public ListView listViewValues;
    public Button closeTheWindow;


    public void addToCollection(ActionEvent actionEvent) {
        vocabulary.put(KeyInput.getText(),ValueInput.getText());
        String V = ValueInput.getText();
        String K ="";
        listViewKeys.getItems().add(vocabulary.get(KeyInput.getText()));
        for (String Key : vocabulary.keySet()){
            if (vocabulary.get(Key).equals(V) )  {
                K = Key;
                break;}}
        listViewValues.getItems().add(K);
        ValueInput.clear();
        KeyInput.clear();
    }

    public void deleteFromTheCollection(ActionEvent actionEvent) {
        int deletedWord = listViewKeys.getSelectionModel().getSelectedIndex();
        vocabulary.remove(deletedWord);
        listViewKeys.getItems().remove(deletedWord);
        listViewValues.getItems().remove(deletedWord);

    }
    public void editeTheWord(ActionEvent actionEvent){
        MultipleSelectionModel editedWord = listViewValues.getSelectionModel();
        listViewValues.getItems().remove(editedWord.getSelectedIndex());
        String word = editedWord.toString();
        String V = word;
        String K ="";
        for (String Key : vocabulary.keySet()){
            if (vocabulary.get(Key).equals(V) )  {
                K = Key;
                break; }}
        listViewValues.getItems().add(KeyInput.getText());
        ValueInput.clear();
        vocabulary.put(K,KeyInput.getText());
    }

    public void closeTheWindow(ActionEvent actionEvent) {
        Stage stage = (Stage)closeTheWindow.getScene().getWindow();
        stage.close();
    }
}