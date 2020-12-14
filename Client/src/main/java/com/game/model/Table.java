package com.game.model;

import com.game.App;
import com.game.model.enums.Direction;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.io.File;

public class Table {

    private App app;
    private int duration;
    private Timeline timer;

    private String playerName;
    private GridPane boardGame;
    private int size;
    private int level;
    private ImageView iviewCharacter;
    private ImageView iviewVehicle;
    private ImageView iviewHome;
    private ImageView[][] objects;
    private ImageView[][] obstacles;

    public Table() {
        boardGame = new GridPane();
        duration = 0;
    }

    public GridPane getBoardGame(int level) {

        this.level = level;
        this.size = 10 + level;
        ImageView[][] obstacles = loadObstacles();

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                if(obstacles[i][j] != null) {
                    GridPane.setHalignment(obstacles[i][j], HPos.CENTER);
                    boardGame.add(obstacles[i][j], i, j);
                }
            }

            boardGame.getColumnConstraints().add(new ColumnConstraints(50));
            boardGame.getRowConstraints().add(new RowConstraints(50));
        }

        boardGame.setStyle("-fx-background-color: #13E9F4;");
        return boardGame;
    }

    private ImageView[][] loadObstacles() {

        objects = new ImageView[size][size];

        for (int i = 0; i < objects.length; i++) {

            for (int j = 0; j < objects.length; j++) {

                objects[i][j] = null;
            }
        }

        switch (level) {
            case 1:
                levelOneTable(objects);
                duration = 30;
                break;

            case 2:
                levelTwoTable(objects);
                duration = 60;
                break;

            default:
                break;
        }

        return objects;
    }

    private void levelOneTable(ImageView[][] objetos) {

        ImageView image;
        obstacles = new ImageView[size][size];

        image = new ImageView(Table.class.getResource("taller.png").toString());
        this.iviewHome = objetos[9][0] = image;
        obstacles[9][0] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);
        image.setId("1");

        image = new ImageView(Table.class.getResource("store.png").toString());
        objetos[3][2] = image;
        obstacles[3][2] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);
        image.setId("2");

        image = new ImageView(Table.class.getResource("store.png").toString());
        objetos[4][2] = image;
        obstacles[4][2] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);
        image.setId("3");

        image = new ImageView(Table.class.getResource("store.png").toString());
        objetos[5][2] = image;
        obstacles[5][2] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);
        image.setId("4");

        image = new ImageView(Table.class.getResource("store.png").toString());
        objetos[2][5] = image;
        obstacles[2][5] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);
        image.setId("5");

        image = new ImageView(Table.class.getResource("store.png").toString());
        objetos[5][5] = image;
        obstacles[5][5] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);
        image.setId("6");

        image = new ImageView(Table.class.getResource("store.png").toString());
        objetos[6][6] = image;
        obstacles[6][6] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);
        image.setId("7");

        image = new ImageView(Table.class.getResource("store.png").toString());
        objetos[8][5] = image;
        obstacles[8][5] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);
        image.setId("8");

        image = new ImageView(Table.class.getResource("store.png").toString());
        objetos[8][7] = image;
        obstacles[8][7] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);
        image.setId("9");

        image = new ImageView(Table.class.getResource("store.png").toString());
        objetos[7][0] = image;
        obstacles[7][0] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);
        image.setId("10");

        image = new ImageView(Table.class.getResource("store.png").toString());
        objetos[7][1] = image;
        obstacles[7][1] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);
        image.setId("11");

        image = new ImageView(Table.class.getResource("store.png").toString());
        objetos[7][3] = image;
        obstacles[7][3] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);
        image.setId("12");

        image = new ImageView(Table.class.getResource("store.png").toString());
        objetos[4][4] = image;
        obstacles[4][4] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);
        image.setId("13");

        image = new ImageView(Table.class.getResource("store.png").toString());
        objetos[1][3] = image;
        obstacles[1][3] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);
        image.setId("14");

        image = new ImageView(Table.class.getResource("store.png").toString());
        objetos[9][9] = image;
        obstacles[9][9] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);
        image.setId("15");

        image = new ImageView(Table.class.getResource("store.png").toString());
        objetos[3][7] = image;
        obstacles[3][7] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);

        image = new ImageView(Table.class.getResource("store.png").toString());
        objetos[4][8] = image;
        obstacles[4][8] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);

        image = new ImageView(Table.class.getResource("store.png").toString());
        objetos[5][8] = image;
        obstacles[5][8] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);

        image = new ImageView(Table.class.getResource("hospital.png").toString());
        objetos[0][6] = image;
        obstacles[0][6] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);

        image = new ImageView(Table.class.getResource("hospital.png").toString());
        objetos[0][7] = image;
        obstacles[0][7] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);

        image = new ImageView(Table.class.getResource("home.png").toString());
        objetos[0][0] = image;
        obstacles[0][0] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);

        image = new ImageView(Table.class.getResource("home.png").toString());
        objetos[2][9] = image;
        obstacles[2][9] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);

        image = new ImageView(Table.class.getResource("office.png").toString());
        objetos[5][10] = image;
        obstacles[5][10] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);

        image = new ImageView(Table.class.getResource("office.png").toString());
        objetos[7][8] = image;
        obstacles[7][8] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);

        image = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[9][2] = image;
        obstacles[9][2] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);

        image = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[10][4] = image;
        obstacles[10][4] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);

        image = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[10][5] = image;
        obstacles[10][5] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);

        image = new Vehicle().getImageView(Direction.RIGHT);
        this.iviewVehicle = image;
        objetos[1][8] = image;
        image.setFitHeight(40);
        image.setFitWidth(50);
        image.setId("16");

        image = new Character().getImageView(Direction.DOWN);
        this.iviewCharacter = image;
        objetos[0][9] = image;
        image.setFitHeight(50);
        image.setFitWidth(50);
        image.setId("17");

        this.objects = objetos;

    }

    private void levelTwoTable(ImageView[][] objetos) {

        ImageView imagen;
        obstacles = new ImageView[size][size];

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[0][0] = imagen;
        obstacles[0][0] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[0][3] = imagen;
        obstacles[0][3] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[0][8] = imagen;
        obstacles[0][8] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("mansion.png").toString());
        objetos[1][5] = imagen;
        obstacles[1][5] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[2][3] = imagen;
        obstacles[2][3] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[2][5] = imagen;
        obstacles[2][5] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("park.png").toString());
        objetos[2][8] = imagen;
        obstacles[2][8] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[2][10] = imagen;
        obstacles[2][10] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("home.png").toString());
        objetos[2][1] = imagen;
        obstacles[2][1] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("park.png").toString());
        objetos[3][8] = imagen;
        obstacles[3][8] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("mansion.png").toString());
        objetos[4][2] = imagen;
        obstacles[4][2] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[4][6] = imagen;
        obstacles[4][6] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[4][11] = imagen;
        obstacles[4][11] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("home.png").toString());
        objetos[5][4] = imagen;
        obstacles[5][4] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("hospital.png").toString());
        objetos[5][7] = imagen;
        obstacles[5][7] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[5][9] = imagen;
        obstacles[5][9] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("office.png").toString());
        objetos[5][11] = imagen;
        obstacles[5][11] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("park.png").toString());
        objetos[5][0] = imagen;
        obstacles[5][0] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[6][11] = imagen;
        obstacles[6][11] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[7][1] = imagen;
        obstacles[7][1] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("hospital.png").toString());
        objetos[7][3] = imagen;
        obstacles[7][3] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("park.png").toString());
        objetos[7][5] = imagen;
        obstacles[7][5] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("home.png").toString());
        objetos[7][8] = imagen;
        obstacles[7][8] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("park.png").toString());
        objetos[8][5] = imagen;
        obstacles[8][5] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[8][10] = imagen;
        obstacles[8][10] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("home.png").toString());
        objetos[9][1] = imagen;
        obstacles[9][1] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("pasoPeatonal.png").toString());
        objetos[9][2] = imagen;
//		obstaculos[9][2] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[9][3] = imagen;
        obstacles[9][3] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[9][4] = imagen;
        obstacles[9][4] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("mansion.png").toString());
        objetos[9][10] = imagen;
        obstacles[9][10] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[9][11] = imagen;
        obstacles[9][11] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("school1.png").toString());
        objetos[10][6] = imagen;
        obstacles[10][6] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[11][3] = imagen;
        obstacles[11][3] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("park.png").toString());
        objetos[11][8] = imagen;
        obstacles[11][8] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("taller.png").toString());
        this.iviewHome = imagen;
        objetos[11][4] = imagen;
        obstacles[11][4] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new Vehicle().getImageView(Direction.RIGHT);
        this.iviewVehicle = imagen;
        objetos[1][10] = imagen;
        imagen.setFitHeight(40);
        imagen.setFitWidth(50);

        imagen = new Character().getImageView(Direction.RIGHT);
        this.iviewCharacter = imagen;
        objetos[0][11] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        imagen.setId("17");

        this.objects = objetos;
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
            case RIGHT:
            case DOWN:  return colOrRowIndex == (size - 1);
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

        if(existsOnBoardGame(iviewHome, posColumnCar+1, posRowCar) != null)
            isWinner = true;

        else if(existsOnBoardGame(iviewHome, posColumnCar-1, posRowCar) != null)
            isWinner = true;

        else if(existsOnBoardGame(iviewHome, posColumnCar, posRowCar + 1) != null)
            isWinner = true;

        else if(existsOnBoardGame(iviewHome, posColumnCar, posRowCar - 1) != null)
            isWinner = true;

        if (isWinner) showWinnerAlert();

        return isWinner;
    }

    private boolean isLockedUp() {

        boolean isLockedUp = false;
        int posRow = GridPane.getRowIndex(iviewVehicle);
        int posColumn = GridPane.getColumnIndex(iviewVehicle);

        if(posColumn > 0 && posColumn < size - 1 && posRow > 0 && posRow < size - 1) {

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

                if(node.equals(object))
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

                    App.lbSeconds.setText( String.valueOf(duration--) );
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

    private void showWinnerAlert(){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        File imageFile = new File(Table.class.getResource("jugador.png").toString());;

        stopTimer();
        alert.setTitle(":)");
        alert.setHeaderText("¡En Hora Buena!");
        alert.setContentText("¡FELICIDADES " + playerName + " HAS GANADO!");

        if(imageFile.exists())
            alert.setGraphic(new ImageView(Table.class.getResource("jugador.png").toString()));

        alert.showAndWait();

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

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setApp(App app) {
        this.app = app;
    }

}
