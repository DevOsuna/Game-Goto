package com.game;

import com.game.controller.GameOneController;
import com.game.controller.HomeController;
import com.game.model.Table;
import com.game.socket.Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    public static String namePlayer;
    public static Label lbSeconds;
    public static int level = 1;
    private GridPane tableJuego;
    private Table table;

    public static Client client;

    private static GameOneController gameOneController;
    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {

        this.stage = stage;
        showMenu();
        stage.show();

    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static void setRoot(Parent parent) {
        scene.setRoot(parent);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public void showOneGame(){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("GameOne.fxml"));
            scene = new Scene(fxmlLoader.load());

            this.gameOneController = fxmlLoader.getController();
            gameOneController.setApp(this);

            loadEventMoveCharacter();

            stage.setScene(scene);

        } catch(Exception e) {
            e.printStackTrace();
        }

        /*
        table = new Table();
        table.setApp(this);
        table.setPlayerName(namePlayer);
        tableJuego = table.getBoardGame(level);

        Label lbTime = new Label("Tiempo :");
        lbTime.setTextFill(Color.BLACK);
        lbTime.setFont(new Font("Arial", 30));
        lbSeconds = new Label();
        lbSeconds.setFont(new Font("Arial", 30));

        HBox hBoxTime = new HBox();
        hBoxTime.setAlignment(Pos.CENTER);
        hBoxTime.setSpacing(40);
        hBoxTime.getChildren().addAll(lbTime, lbSeconds);

        AnchorPane pane = new AnchorPane();
        pane.getChildren().add(tableJuego);
        AnchorPane.setLeftAnchor(tableJuego, 15.00);
        AnchorPane.setRightAnchor(tableJuego, 15.00);

        Button btnTryAgain = new Button("Volver a Intentar");
        btnTryAgain.setTextFill(Color.BLACK);
        loadStyle(btnTryAgain);

        Button btnMenu = new Button("Menu");
        btnMenu.setTextFill(Color.BLACK);
        loadStyle(btnMenu);

        HBox hboxButtons = new HBox();
        hboxButtons.setAlignment(Pos.CENTER);
        hboxButtons.setSpacing(40);
        hboxButtons.getChildren().addAll(btnTryAgain, btnMenu);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(hBoxTime, pane, hboxButtons);

        btnTryAgain.setOnMouseClicked( e-> {
                table.stopTimer();
                showOneGame();
        });

        btnMenu.setOnMouseClicked( e-> {
            table.stopTimer();
            showMenu();
        });

        scene = new Scene(vBox);
        stage.setScene(scene);
        loadEventMoveCharacter();

         */

    }

    public void showMenu(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("home.fxml"));
            scene = new Scene(fxmlLoader.load());

            HomeController controller = fxmlLoader.getController();
            controller.setMain(this);

            stage.setScene(scene);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void loadEventMoveCharacter() {

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            gameOneController.eventBoardGame(event);
        });

        gameOneController.startTimer();
    }

    private void loadStyle(Button btn) {

        btn.setStyle("-fx-background-color: \r\n" +
                "        #090a0c,\r\n" +
                "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\r\n" +
                "        linear-gradient(#20262b, #191d22),\r\n" +
                "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\r\n" +
                "    -fx-background-radius: 5,4,3,5;\r\n" +
                "    -fx-background-insets: 0,1,2,0;\r\n" +
                "    -fx-text-fill: white;\r\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\r\n" +
                "    -fx-font-family: \"Arial\";\r\n" +
                "    -fx-text-fill: linear-gradient(white, #d0d0d0);\r\n" +
                "    -fx-font-size: 12px;\r\n" +
                "    -fx-padding: 10 20 10 20;");
    }

    public static void main(String[] args) throws Exception {
        launch();
    }

}