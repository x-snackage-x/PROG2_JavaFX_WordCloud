package ch.zhaw.prog2.application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindow extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		openMainWindow(primaryStage);
	}
	
	private void openMainWindow(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
		Pane rootNode = loader.load();
		
		MainWindowController controller = loader.getController();
		controller.initialize();
		
		Scene scene = new Scene(rootNode); 
		stage.setScene(scene);
		stage.show();
	}
}