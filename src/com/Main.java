package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void init() throws Exception {
        System.out.print("Program started successfully!\n");
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Program.fxml"));
        stage.setTitle("Product list app");
        stage.setScene(new Scene(root,347, 500));
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.print("Program was closed!\n");
    }

    public static void main(String args[]){
        launch(args);
    }

}
