package com.game.model;

import com.game.model.enums.Direction;
import javafx.scene.image.ImageView;

public class Vehicle {

    private ImageView[] images;

    public Vehicle() {
        images = new ImageView[4];
        loadImages();
        imagesConfig();
    }

    private void loadImages() {

        images[0] = new ImageView(Vehicle.class.getResource("carroIzquierda.png").toString());
        images[1] = new ImageView(Vehicle.class.getResource("carroDerecha.png").toString());
        images[2] = new ImageView(Vehicle.class.getResource("carroFrente.png").toString());
        images[3] = new ImageView(Vehicle.class.getResource("carroAtras.png").toString());
    }

    private void imagesConfig() {

        for (ImageView image: images) {
            image.setFitHeight(40);
            image.setFitWidth(40);
        }
    }

    public ImageView getImageView(Direction direction) {

        switch (direction) {

            case LEFT:
                return images[0];

            case RIGHT:
                return images[1];

            case UP:
                return images[2];

            case DOWN:
                return images[3];

            default:
                return null;
        }
    }
}
