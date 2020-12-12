package com.game.controller;

import com.game.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    private App main;

    @FXML
    private ImageView iviewCamera;

    @FXML
    private ImageView iviewPhoto;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnJugar;

    @FXML
    private ImageView iviewFondo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iviewFondo.setImage(new Image
                (HomeController.class.getResource("fondoMenu.jpg").toString()));
        iviewPhoto.setImage(new Image
                (HomeController.class.getResource("picture.png").toString()));
    }

    @FXML
    public void handleJugar(ActionEvent event) {
        App.namePlayer = txtNombre.getText();
        main.showPartida();
    }

    @FXML
    public void hadleFoto() {

        iviewPhoto.setOnMouseClicked(event ->{

            Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
            alert.setTitle("¡SONRIEEEEE!");
            alert.setHeaderText("¡SONRIEEEEE!");
            alert.setContentText("Entendido");
            ImageView imagen = new ImageView
                    (HomeController.class.getResource("camera2.png").toString());
            imagen.setFitHeight(40);
            imagen.setFitWidth(40);
            alert.setGraphic(imagen);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get()== ButtonType.OK) {}

            else {}

            Webcam webCam = Webcam.getDefault();
            webCam.open();

            try {

                File imagenFile = new File(
                        HomeController.class.getResource("jugador.png").getPath());

                if(imagenFile.exists()) {
                    imagenFile.delete();
                    imagenFile.createNewFile();
                }
                else {
                    imagenFile.createNewFile();
                }

                ImageIO.write(webCam.getImage(), "PNG", new File(
                        HomeController.class.getResource("jugador.png").getPath()));
                webCam.close();
                iviewPhoto.setImage(new Image(
                        HomeController.class.getResource("jugador.png").getPath()));

            } catch (Exception e) {

                e.printStackTrace();

            }
        });
    }

    public void setMain(App main) {
        this.main = main;
    }
}
