module com.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires webcam.capture;
    requires java.desktop;

    opens com.game.controller to javafx.fxml;
    exports com.game;
}