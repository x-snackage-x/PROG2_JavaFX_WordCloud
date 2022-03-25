package ch.zhaw.prog2.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainWindowController implements IsObserver{

    @FXML
    private Label lableTitel;

    @FXML
    private TextField textEingabe;

    @FXML
    private TextArea textHistory;
    
    private WordModel model;
    
    private WordModelDecorator observableModel;
    
    public void initialize() {
    	connectProperties();
    	model = new WordModel();
    	observableModel = new WordModelDecorator(model);
    	observableModel.addListener(this);
    }

    @FXML
    void hinzufuegenText(ActionEvent event) {
    	//textHistory.setText(textEingabe.getText() + System.lineSeparator() + textHistory.getText());
    	for(String word : textEingabe.getText().split(" ")) {
    		observableModel.addWord(word.toLowerCase());
    	}
    	textEingabe.clear();
    }

    @FXML
    void leerenTextEingeben(ActionEvent event) {
    	textEingabe.clear();
    }
    
    private void connectProperties() {
    	lableTitel.textProperty().bind(textEingabe.textProperty());
    }

	@Override
	public void update() {
		textHistory.setText(model.toString());
	}

}
