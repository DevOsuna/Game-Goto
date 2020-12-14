package com.game.controller;

import com.game.App;
import com.game.model.Character;
import com.game.model.Player;
import com.game.model.Table;
import com.game.model.Vehicle;
import com.game.model.enums.Direction;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class GameOneController implements Initializable, Observer {

    @FXML
    private GridPane boardGame;

    @FXML
    private ImageView iviewVehicle;

    @FXML
    private ImageView iviewCharacter;

    @FXML
    private ImageView iviewGarage;

    private ImageView vehicleRivals;
    private ImageView characterRivals;

    private App app;
    private int duration;
    private Timeline timer;

    private final int sizeWidth = 13;
    private final int sizeHeight = 11;
    private String playerName;
    private int level;
    private ImageView[][] objects;
    private ImageView[][] obstacles;

    public GameOneController() {
        duration = 30;
        App.client.addObserver(this);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vehicleRivals = new ImageView();
        characterRivals = new ImageView();
        boardGame.add(vehicleRivals, 1, 9);
        boardGame.add(characterRivals, 0, 9);
        load();
    }

    private void load() {

        loadObstacles();

        for (int i = 0; i < sizeWidth; i++) {

            for (int j = 0; j < sizeHeight; j++) {

                if(objects[i][j] != null) {
                    GridPane.setHalignment(objects[i][j], HPos.CENTER);
                    GridPane.setColumnIndex(objects[i][j], i);
                    GridPane.setRowIndex(objects[i][j], j);
                    boardGame.add(objects[i][j], i, j);
                }
            }

            boardGame.getColumnConstraints().add(new ColumnConstraints(50));
            boardGame.getRowConstraints().add(new RowConstraints(41));
        }
    }

    private ImageView[][] loadObstacles() {

        objects = new ImageView[sizeWidth][sizeHeight];

        for (int i = 0; i < sizeWidth; i++) {

            for (int j = 0; j < sizeHeight; j++) {

                objects[i][j] = null;
            }
        }

        getObstacles();

        return objects;
    }

    private void getObstacles() {

        ImageView image;
        obstacles = new ImageView[sizeWidth][sizeHeight];

        image = new ImageView(Table.class.getResource("home.png").toString());
        image.setFitHeight(44);
        image.setFitWidth(49);
        objects[0][1] = image;
        obstacles[0][1] = image;

        image = new ImageView(Table.class.getResource("office.png").toString());
        image.setFitHeight(49);
        image.setFitWidth(63);
        objects[0][5] = image;
        obstacles[0][5] = image;

        image = new ImageView(Table.class.getResource("tree.png").toString());
        image.setFitHeight(49);
        image.setFitWidth(45);
        objects[1][3] = image;
        obstacles[1][3] = image;

        image = new ImageView(Table.class.getResource("fire-hydrant.png").toString());
        image.setFitHeight(32);
        image.setFitWidth(34);
        objects[1][7] = image;
        obstacles[1][7] = image;

        image = new ImageView(Table.class.getResource("tree.png").toString());
        image.setFitHeight(49);
        image.setFitWidth(45);
        objects[2][0] = image;
        obstacles[2][0] = image;

        image = new ImageView(Table.class.getResource("tree.png").toString());
        image.setFitHeight(49);
        image.setFitWidth(45);
        objects[2][5] = image;
        obstacles[2][5] = image;

        image = new ImageView(Table.class.getResource("cat.png").toString());
        image.setFitHeight(36);
        image.setFitWidth(42);
        objects[3][0] = image;
        obstacles[3][0] = image;

        image = new ImageView(Table.class.getResource("park.png").toString());
        image.setFitHeight(47);
        image.setFitWidth(53);
        objects[3][2] = image;
        obstacles[3][2] = image;

        image = new ImageView(Table.class.getResource("mansion.png").toString());
        image.setFitHeight(46);
        image.setFitWidth(54);
        objects[3][5] = image;
        obstacles[3][5] = image;

        image = new ImageView(Table.class.getResource("tree.png").toString());
        image.setFitHeight(49);
        image.setFitWidth(45);
        objects[3][9] = image;
        obstacles[3][9] = image;

        image = new ImageView(Table.class.getResource("fountain.png").toString());
        image.setFitHeight(47);
        image.setFitWidth(52);
        objects[4][2] = image;
        obstacles[4][2] = image;

        image = new ImageView(Table.class.getResource("cat.png").toString());
        image.setFitHeight(33);
        image.setFitWidth(36);
        objects[4][8] = image;
        obstacles[4][8] = image;

        image = new ImageView(Table.class.getResource("tree.png").toString());
        image.setFitHeight(49);
        image.setFitWidth(45);
        objects[5][4] = image;
        obstacles[5][4] = image;

        image = new ImageView(Table.class.getResource("office.png").toString());
        image.setFitHeight(49);
        image.setFitWidth(54);
        objects[5][6] = image;
        obstacles[5][6] = image;

        image = new ImageView(Table.class.getResource("store.png").toString());
        image.setFitHeight(47);
        image.setFitWidth(56);
        objects[5][10] = image;
        obstacles[5][10] = image;

        image = new ImageView(Table.class.getResource("dog.png").toString());
        image.setFitHeight(35);
        image.setFitWidth(44);
        objects[6][2] = image;
        obstacles[6][2] = image;

        image = new ImageView(Table.class.getResource("mansion.png").toString());
        image.setFitHeight(45);
        image.setFitWidth(51);
        objects[6][7] = image;
        obstacles[6][7] = image;

        image = new ImageView(Table.class.getResource("fire-hydrant.png").toString());
        image.setFitHeight(34);
        image.setFitWidth(52);
        objects[6][9] = image;
        obstacles[6][9] = image;

        image = new ImageView(Table.class.getResource("school1.png").toString());
        image.setFitHeight(45);
        image.setFitWidth(56);
        objects[7][3] = image;
        obstacles[7][3] = image;

        image = new ImageView(Table.class.getResource("dog.png").toString());
        image.setFitHeight(35);
        image.setFitWidth(44);
        objects[7][5] = image;
        obstacles[7][5] = image;

        image = new ImageView(Table.class.getResource("tree.png").toString());
        image.setFitHeight(43);
        image.setFitWidth(47);
        objects[7][8] = image;
        obstacles[7][8] = image;

        image = new ImageView(Table.class.getResource("dog.png").toString());
        image.setFitHeight(34);
        image.setFitWidth(41);
        objects[7][10] = image;
        obstacles[7][10] = image;

        image = new ImageView(Table.class.getResource("tree.png").toString());
        image.setFitHeight(41);
        image.setFitWidth(51);
        objects[8][0] = image;
        obstacles[8][0] = image;

        image = new ImageView(Table.class.getResource("store.png").toString());
        image.setFitHeight(41);
        image.setFitWidth(42);
        objects[8][2] = image;
        obstacles[8][2] = image;

        image = new ImageView(Table.class.getResource("tree.png").toString());
        image.setFitHeight(41);
        image.setFitWidth(51);
        objects[8][3] = image;
        obstacles[8][3] = image;

        image = new ImageView(Table.class.getResource("tree.png").toString());
        image.setFitHeight(41);
        image.setFitWidth(51);
        objects[9][6] = image;
        obstacles[9][6] = image;

        image = new ImageView(Table.class.getResource("tree.png").toString());
        image.setFitHeight(41);
        image.setFitWidth(51);
        objects[9][9] = image;
        obstacles[9][9] = image;

        image = new ImageView(Table.class.getResource("home.png").toString());
        image.setFitHeight(45);
        image.setFitWidth(49);
        objects[10][0] = image;
        obstacles[10][0] = image;

        image = new ImageView(Table.class.getResource("hospital.png").toString());
        image.setFitHeight(44);
        image.setFitWidth(49);
        objects[10][4] = image;
        obstacles[10][4] = image;

        image = new ImageView(Table.class.getResource("fountain.png").toString());
        image.setFitHeight(44);
        image.setFitWidth(47);
        objects[10][7] = image;
        obstacles[10][7] = image;

        image = new ImageView(Table.class.getResource("school1.png").toString());
        image.setFitHeight(46);
        image.setFitWidth(51);
        objects[11][5] = image;
        obstacles[11][5] = image;

        image = new ImageView(Table.class.getResource("home.png").toString());
        image.setFitHeight(45);
        image.setFitWidth(49);
        objects[11][7] = image;
        obstacles[11][7] = image;

        image = new ImageView(Table.class.getResource("tree.png").toString());
        image.setFitHeight(41);
        image.setFitWidth(51);
        objects[12][1] = image;
        obstacles[12][1] = image;

        image = new ImageView(Table.class.getResource("park.png").toString());
        image.setFitHeight(47);
        image.setFitWidth(53);
        objects[12][3] = image;
        obstacles[12][3] = image;

        // Taller
        image = new ImageView((Table.class.getResource("taller.png").toString()));
        image.setFitHeight(45);
        image.setFitWidth(49);
        obstacles[6][1] = image;
        this.iviewGarage = objects[6][1] = image;

        // Carro
        image = new Vehicle().getImageView(Direction.RIGHT);
        image.setFitHeight(40);
        image.setFitWidth(50);
        this.iviewVehicle = objects[1][9] = image;

        // Character
        image = new Character().getImageView(Direction.DOWN);
        image.setFitHeight(47);
        image.setFitWidth(63);
        this.iviewCharacter = objects[0][9] = image;

    }

    public void eventBoardGame(KeyEvent e) {

        boolean eventWasActivated = true;

        switch (e.getCode()){

            case RIGHT:
                move(Direction.RIGHT);
                break;

            case LEFT:
                move(Direction.LEFT);
                break;

            case UP:
                move(Direction.UP);
                break;

            case DOWN:
                move(Direction.DOWN);
                break;

            default: eventWasActivated = false;
        }

        if (eventWasActivated) {

            if (isWinner())
                nextLevel();

            else if (isLockedUp())
                playAgain();
        }
    }

    private void move(Direction direction) {

        turnCharacter(direction);

        if(canTheCharacterMove(direction)) {

            if (isTheCarOnThe(direction)) {
                turnCar(direction);
                moveCar(direction);
            }

            moveCharacter(direction);
        }
    }

    private boolean isTheCarOnThe(Direction direction){

        int rowCurrent = GridPane.getRowIndex(iviewCharacter);
        int colCurrent = GridPane.getColumnIndex(iviewCharacter);

        switch (direction){
            case RIGHT:
                return existsOnBoardGame(iviewVehicle, ++colCurrent, rowCurrent) != null;
            case LEFT:
                return existsOnBoardGame(iviewVehicle, --colCurrent, rowCurrent) != null;
            case UP:
                return existsOnBoardGame(iviewVehicle, colCurrent, --rowCurrent) != null;
            case DOWN:
                return existsOnBoardGame(iviewVehicle, colCurrent, ++rowCurrent) != null;
            default: return false;
        }
    }

    private boolean canTheCharacterMove(Direction direction) {

        int index = -1;
        boolean canMove = false;
        int posRowCurrent = GridPane.getRowIndex(iviewCharacter);
        int posColumnCurrent = GridPane.getColumnIndex(iviewCharacter);

        switch (direction){
            case RIGHT: index = posColumnCurrent++; break;
            case LEFT:  index = posColumnCurrent--; break;
            case UP:    index = posRowCurrent--;    break;
            case DOWN:  index = posRowCurrent++;    break;
        }

        if(!isItTheEdgeOfTheMap(index, direction)) {

            if (!isThereAnObstacle(posColumnCurrent, posRowCurrent)) {

                canMove = true;

                if (existsOnBoardGame(iviewVehicle, posColumnCurrent, posRowCurrent) != null)
                    canMove = canTheCarMove(direction);

            }
        }

        return canMove;
    }

    private void moveCharacter(Direction direction) {

        int rowCurrent = GridPane.getRowIndex(iviewCharacter);
        int colCurrent = GridPane.getColumnIndex(iviewCharacter);

        switch (direction){
            case RIGHT: GridPane.setColumnIndex(iviewCharacter, ++colCurrent);  break;
            case LEFT:  GridPane.setColumnIndex(iviewCharacter, --colCurrent);  break;
            case UP:    GridPane.setRowIndex(iviewCharacter, --rowCurrent);     break;
            case DOWN:  GridPane.setRowIndex(iviewCharacter, ++rowCurrent);     break;
        }

        notifyMovementCharacter(colCurrent, rowCurrent, direction);
    }

    private void notifyMovementCharacter(int col, int row, Direction direction) {
        Player player = new Player();
        player.setDirectionCharacter(direction);
        player.setColCharacter(col);
        player.setRowCharacter(row);
        ObjectOutputStream output = App.client.output;
        try {
            output.writeObject(player);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void moveCar(Direction direction) {

        int rowCurrent = GridPane.getRowIndex(iviewVehicle);
        int colCurrent = GridPane.getColumnIndex(iviewVehicle);

        switch (direction){
            case RIGHT: GridPane.setColumnIndex(iviewVehicle, ++colCurrent); break;
            case LEFT:  GridPane.setColumnIndex(iviewVehicle, --colCurrent); break;
            case UP:    GridPane.setRowIndex(iviewVehicle, --rowCurrent);    break;
            case DOWN:  GridPane.setRowIndex(iviewVehicle, ++rowCurrent);    break;
        }

        notifyMovement(colCurrent, rowCurrent, direction);

    }

    private void notifyMovement(int col, int row, Direction direction) {

        Player player = new Player();
        player.setColVehicle(col);
        player.setRowVehicle(row);
        player.setDirectionVehicle(direction);

        switch (direction){
            case RIGHT:  --col; break;
            case LEFT:   ++col; break;
            case UP:     ++row; break;
            case DOWN:   --row; break;
        }

        player.setColCharacter(col);
        player.setRowCharacter(row);
        player.setDirectionCharacter(direction);

        try {
            ObjectOutputStream output = App.client.output;
            output.writeObject(player);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean canTheCarMove(Direction direction){

        int index = -1;
        boolean canMove = false;
        int rowCurrent = GridPane.getRowIndex(iviewVehicle);
        int columnCurrent = GridPane.getColumnIndex(iviewVehicle);

        switch (direction){
            case RIGHT: index = columnCurrent++; break;
            case LEFT:  index = columnCurrent--; break;
            case UP:    index = rowCurrent--;    break;
            case DOWN:  index = rowCurrent++;    break;
        }

        if(!isItTheEdgeOfTheMap(index, direction))

            if (!isThereAnObstacle(columnCurrent, rowCurrent))
                canMove = true;

        return canMove;
    }

    private boolean isItTheEdgeOfTheMap(int colOrRowIndex, Direction direction) {

        switch (direction){
            case RIGHT: return colOrRowIndex == (sizeWidth - 1); // No existia...
            case DOWN:  return colOrRowIndex == (sizeHeight - 1);
            case LEFT:
            case UP:    return colOrRowIndex == 0;
            default:    return false;
        }
    }

    private boolean isThereAnObstacle(int column, int row) {
        return obstacles[column][row] != null;
    }

    private void turnCharacter(Direction direction) {

        int posRow = GridPane.getRowIndex(iviewCharacter);
        int posColumn = GridPane.getColumnIndex(iviewCharacter);

        boardGame.getChildren().remove(iviewCharacter);

        iviewCharacter = new Character().getImageView(direction);

        boardGame.add(iviewCharacter, posColumn, posRow);

    }

    private void turnCar(Direction direction) {

        int posRow = GridPane.getRowIndex(iviewVehicle);
        int posColumn = GridPane.getColumnIndex(iviewVehicle);

        boardGame.getChildren().remove(iviewVehicle);

        iviewVehicle = new Vehicle().getImageView(direction);

        boardGame.add(iviewVehicle, posColumn, posRow);

    }

    private boolean isWinner() {

        boolean isWinner = false;
        int posRowCar = GridPane.getRowIndex(iviewVehicle);
        int posColumnCar = GridPane.getColumnIndex(iviewVehicle);

        if(existsOnBoardGame(iviewGarage, posColumnCar+1, posRowCar) != null)
            isWinner = true;

        else if(existsOnBoardGame(iviewGarage, posColumnCar-1, posRowCar) != null)
            isWinner = true;

        else if(existsOnBoardGame(iviewGarage, posColumnCar, posRowCar + 1) != null)
            isWinner = true;

        else if(existsOnBoardGame(iviewGarage, posColumnCar, posRowCar - 1) != null)
            isWinner = true;

        if (isWinner) {
            notifyWinner();
            showWinnerAlert(App.namePlayer);
        }

        return isWinner;
    }

    private void notifyWinner() {

        Player player = new Player();
        player.setName(App.namePlayer);
        player.setWinner(true);

        try {
            ObjectOutputStream output = App.client.output;
            output.writeObject(player);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isLockedUp() {

        boolean isLockedUp = false;
        int posRow = GridPane.getRowIndex(iviewVehicle);
        int posColumn = GridPane.getColumnIndex(iviewVehicle);

        if(posColumn > 0 && posColumn < sizeWidth - 1 && posRow > 0 && posRow < sizeWidth - 1) {

            if(obstacles[posColumn][posRow-1] != null && obstacles[posColumn+1][posRow] != null)
                isLockedUp = true;

            else if(obstacles[posColumn][posRow-1] != null && obstacles[posColumn-1][posRow] != null)
                isLockedUp = true;

            else if(obstacles[posColumn][posRow+1] != null && obstacles[posColumn+1][posRow] != null)
                isLockedUp = true;

            else if(obstacles[posColumn][posRow+1] != null && obstacles[posColumn-1][posRow] != null)
                isLockedUp = true;

        } else isLockedUp = true;

        if (isLockedUp) showTrappedCarAlert();
        return isLockedUp;
    }

    private Node existsOnBoardGame(ImageView object, int col, int row) {

        for (Node node : boardGame.getChildren()) {

            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {

                if (node.equals(object))
                    return node;
            }

        }
        return null;
    }

    private void nextLevel(){

        if(level == 1) {
            App.level = ++level;
            app.showOneGame();
        }
        else {
            App.level = 1;
            gameOver();
        }

    }

    public void startTimer() {

        timer = new Timeline();
        timer.setCycleCount(duration + 1);

        KeyFrame keyFrame = new KeyFrame(

                Duration.seconds(1),

                e -> {
                    if(duration == 0)
                        showTimeUpAlert();

                    //App.lbSeconds.setText( String.valueOf(duration--) );
                });

        timer.getKeyFrames().add(keyFrame);
        timer.play();
    }

    private void showTimeUpAlert(){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(":(");
        alert.setHeaderText("¡Ups!");
        alert.setContentText("El tiempo se agoto, intenta de nuevo");
        alert.show();
    }

    private void showWinnerAlert(String playerName){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        File imageFile = new File(Table.class.getResource("jugador.png").toString());;

        stopTimer();
        alert.setTitle(":)");
        alert.setHeaderText("¡En Hora Buena!");
        alert.setContentText("¡FELICIDADES " + playerName + " HAS GANADO!");

        if(imageFile.exists())
            alert.setGraphic(new ImageView(Table.class.getResource("jugador.png").toString()));

        alert.showAndWait();
        app.showMenu();

    }

    private void showTrappedCarAlert() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        stopTimer();
        alert.setTitle(":(");
        alert.setHeaderText("¡Ups!");
        alert.setContentText("Te has quedado atrapado intenta de nuevo");

        alert.showAndWait();
    }

    private void playAgain() { app.showOneGame(); }

    private void gameOver(){ app.showMenu(); }

    public void stopTimer() {
        timer.stop();
    }

    public void setApp(App app) {
        this.app = app;
    }

    @Override
    public void update(Observable o, Object arg) {

        Player player = (Player) arg;

        if (player.isWinner())
            Platform.runLater(() -> showWinnerAlert(player.getName()));

        else if (player.getDirectionCharacter() != null && player.getDirectionVehicle() != null) {

            Platform.runLater(() -> {
                boardGame.getChildren().remove(vehicleRivals);
                boardGame.getChildren().remove(characterRivals);
            });

            vehicleRivals = new Vehicle().getImageView(player.getDirectionVehicle());
            characterRivals = new Character().getImageView(player.getDirectionCharacter());
            characterRivals.setOpacity(0.2);
            vehicleRivals.setOpacity(0.2);

            int colCharacter = player.getColCharacter();
            int rowCharacter = player.getRowCharacter();
            int colVehicle = player.getColVehicle();
            int rowVehicle = player.getRowVehicle();

            Platform.runLater(() -> {
                boardGame.add(vehicleRivals, colVehicle, rowVehicle);
                boardGame.add(characterRivals, colCharacter, rowCharacter);
            });

        } else if (player.getDirectionCharacter() != null && player.getDirectionVehicle() == null) {

            Platform.runLater(() -> {
                boardGame.getChildren().remove(characterRivals);
            });

            characterRivals = new Character().getImageView(player.getDirectionCharacter());
            characterRivals.setOpacity(0.2);

            int colCharacter = player.getColCharacter();
            int rowCharacter = player.getRowCharacter();

            Platform.runLater(() -> {
                boardGame.add(characterRivals, colCharacter, rowCharacter);
            });

        }
    }
}
