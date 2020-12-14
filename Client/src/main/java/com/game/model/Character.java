package com.game.model;

import com.game.model.enums.Direction;
import javafx.scene.image.ImageView;

public class Character {

    private ImageView[] images;

    public Character() {
        images = new ImageView[4];
        loadImages();
        imagesConfig();
    }

    private void loadImages() {
        images[0] = new ImageView(Character.class.getResource("personajeIzquierda.png").toString());
        images[1] = new ImageView(Character.class.getResource("personajeDerecha.png").toString());
        images[2] = new ImageView(Character.class.getResource("personajeFrente.png").toString());
        images[3] = new ImageView(Character.class.getResource("personajeAtras.png").toString());
    }

    private void imagesConfig() {

        for (ImageView image: images) {
            image.setFitHeight(50);
            image.setFitWidth(50);
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
