package ch.zhaw.prog2.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainWindowController {

    @FXML
    private Label lableTitel;

    @FXML
    private TextField textEingabe;

    @FXML
    private TextArea textHistory;
    
    public void initialize() {
    	connectProperties();
    }

    @FXML
    void hinzufuegenText(ActionEvent event) {
    	textHistory.setText(textEingabe.getText() + System.lineSeparator() + textHistory.getText());
    }

    @FXML
    void leerenTextEingeben(ActionEvent event) {
    	textEingabe.clear();
    }
    
    private void connectProperties() {
    	lableTitel.textProperty().bind(textEingabe.textProperty());
    }

}
