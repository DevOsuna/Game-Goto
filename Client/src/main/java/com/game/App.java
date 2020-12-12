package com.game;

import com.game.controller.HomeController;
import com.game.model.Table;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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

    public void showPartida(){

        table = new Table();
        table.setMain(this);
        table.setNombreJugador(namePlayer);
        tableJuego = table.getTablero(level);

        Label lbTiempo = new Label("Tiempo :");
        lbTiempo.setTextFill(Color.BLACK);
        lbTiempo.setFont(new Font("Arial", 30));
        lbSeconds = new Label();
        lbSeconds.setFont(new Font("Arial", 30));

        HBox hBoxTiempo = new HBox();
        hBoxTiempo.setAlignment(Pos.CENTER);
        hBoxTiempo.setSpacing(40);
        hBoxTiempo.getChildren().addAll(lbTiempo, lbSeconds);

        AnchorPane pane = new AnchorPane();
        pane.getChildren().add(tableJuego);
        AnchorPane.setLeftAnchor(tableJuego, 15.00);
        AnchorPane.setRightAnchor(tableJuego, 15.00);

        Button btnIntentar = new Button("Volver a Intentar");
        btnIntentar.setTextFill(Color.BLACK);
        loadStyle(btnIntentar);

        Button btnMenu = new Button("Menu");
        btnMenu.setTextFill(Color.BLACK);
        loadStyle(btnMenu);

        HBox hboxBotones = new HBox();
        hboxBotones.setAlignment(Pos.CENTER);
        hboxBotones.setSpacing(40);
        hboxBotones.getChildren().addAll(btnIntentar, btnMenu);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(hBoxTiempo, pane, hboxBotones);

        setRoot(vBox);
        loadEventMoveCharacter();

        btnIntentar.setOnMouseClicked( e-> {
            showPartida();
        });

        btnMenu.setOnMouseClicked( e-> {
            table.resetGame();
            showMenu();
        });

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
            table.eventoTablero(event);
        });

        table.iniciarTemporizador();
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

    public static void main(String[] args) { launch(); }

}