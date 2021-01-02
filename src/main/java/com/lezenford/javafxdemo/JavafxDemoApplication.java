package com.lezenford.javafxdemo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavafxDemoApplication extends Application {

	public static void main(String[] args) {
		JavafxDemoApplication.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//create new container
		VBox vBox = new VBox();

		//set weight and height for container
		vBox.setPrefHeight(200);
		vBox.setPrefWidth(300);

		//set alignment into container
		vBox.setAlignment(Pos.CENTER);

		//create label
		Label label = new Label("Test JavaFx app");

		//set style fo font size
		label.setStyle("-fx-font-size: 24px");

		//add label to container
		vBox.getChildren().add(label);

		//create button
		Button button = new Button("Close");

		//set button weight
		button.setPrefWidth(200);

		//add button action
		button.setOnMouseClicked(event -> Platform.exit());

		//add button to container
		vBox.getChildren().add(button);

		//create Scene
		Scene scene = new Scene(vBox);

		//set scene to stage
		primaryStage.setScene(scene);

		primaryStage.show();
	}
}
