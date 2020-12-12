package com.game.model;

import com.game.App;
import com.game.model.enums.Position;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.io.File;
import java.util.Optional;

public class Table {

    private App main;
    private int duracion;
    private Timeline time;

    private String nombreJugador;
    private GridPane tablero;
    private int tamanoTablero;
    private int nivel;
    private ImageView iviewPersonaje;
    private ImageView iviewVehiculo;
    private ImageView iviewCasa;
    private ImageView[][] objetos;
    private ImageView[][] obstaculos;

    public Table() {
        tablero = new GridPane();
        duracion = 0;
    }

    public GridPane getTablero(int nivel) {

        this.nivel = nivel;
        this.tamanoTablero = 10 + (nivel);
        ImageView[][] matrizObstaculos = cargarObstaculos();

        for (int i = 0; i < tamanoTablero; i++) {

            for (int j = 0; j < tamanoTablero; j++) {

                if(matrizObstaculos[i][j] != null) {
                    GridPane.setHalignment(matrizObstaculos[i][j], HPos.CENTER);
                    tablero.add(matrizObstaculos[i][j], i, j);
                }
            }

            tablero.getColumnConstraints().add(new ColumnConstraints(50));
            tablero.getRowConstraints().add(new RowConstraints(50));
        }

        tablero.setStyle("-fx-background-color: #13E9F4;");
        return tablero;
    }

    public void detenerTiempo() {
        time.stop();
    }

    public void resetGame() {
        time.stop();
        duracion = 0;
        clearTablePositions();
    }

    private ImageView[][] cargarObstaculos() {

        objetos = new ImageView[tamanoTablero][tamanoTablero];

        for (int i = 0; i < objetos.length; i++) {

            for (int j = 0; j < objetos.length; j++) {

                objetos[i][j] = null;
            }
        }

        switch (nivel) {
            case 1:
                tablaNivel1(objetos);
                duracion = 30;
                break;

            case 2:
                tablaNivel2(objetos);
                duracion = 60;
                break;

            default:
                break;
        }

        return objetos;
    }

    private void tablaNivel1(ImageView[][] objetos) {

        ImageView imagen;
        obstaculos = new ImageView[tamanoTablero][tamanoTablero];

        imagen = new ImageView(Table.class.getResource("taller.png").toString());
        this.iviewCasa = objetos[9][0] = imagen;
        obstaculos[9][0] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        imagen.setId("1");

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[3][2] = imagen;
        obstaculos[3][2] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        imagen.setId("2");

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[4][2] = imagen;
        obstaculos[4][2] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        imagen.setId("3");

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[5][2] = imagen;
        obstaculos[5][2] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        imagen.setId("4");

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[2][5] = imagen;
        obstaculos[2][5] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        imagen.setId("5");

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[5][5] = imagen;
        obstaculos[5][5] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        imagen.setId("6");

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[6][6] = imagen;
        obstaculos[6][6] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        imagen.setId("7");

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[8][5] = imagen;
        obstaculos[8][5] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        imagen.setId("8");

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[8][7] = imagen;
        obstaculos[8][7] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        imagen.setId("9");

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[7][0] = imagen;
        obstaculos[7][0] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        imagen.setId("10");

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[7][1] = imagen;
        obstaculos[7][1] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        imagen.setId("11");

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[7][3] = imagen;
        obstaculos[7][3] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        imagen.setId("12");

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[4][4] = imagen;
        obstaculos[4][4] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        imagen.setId("13");

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[1][3] = imagen;
        obstaculos[1][3] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        imagen.setId("14");

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[9][9] = imagen;
        obstaculos[9][9] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        imagen.setId("15");

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[3][7] = imagen;
        obstaculos[3][7] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[4][8] = imagen;
        obstaculos[4][8] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[5][8] = imagen;
        obstaculos[5][8] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("hospital.png").toString());
        objetos[0][6] = imagen;
        obstaculos[0][6] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("hospital.png").toString());
        objetos[0][7] = imagen;
        obstaculos[0][7] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("home.png").toString());
        objetos[0][0] = imagen;
        obstaculos[0][0] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("home.png").toString());
        objetos[2][9] = imagen;
        obstaculos[2][9] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("office.png").toString());
        objetos[5][10] = imagen;
        obstaculos[5][10] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("office.png").toString());
        objetos[7][8] = imagen;
        obstaculos[7][8] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[9][2] = imagen;
        obstaculos[9][2] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[10][4] = imagen;
        obstaculos[10][4] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[10][5] = imagen;
        obstaculos[10][5] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new Vehicle().getImageView(Position.RIGHT);
        this.iviewVehiculo = imagen;
        objetos[1][8] = imagen;
        imagen.setFitHeight(40);
        imagen.setFitWidth(50);
        imagen.setId("16");

        imagen = new Character().getImageView(Position.BACK);
        this.iviewPersonaje = imagen;
        objetos[0][9] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        imagen.setId("17");

        this.objetos = objetos;

    }

    private void tablaNivel2(ImageView[][] objetos) {

        ImageView imagen;
        obstaculos = new ImageView[tamanoTablero][tamanoTablero];

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[0][0] = imagen;
        obstaculos[0][0] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[0][3] = imagen;
        obstaculos[0][3] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[0][8] = imagen;
        obstaculos[0][8] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("mansion.png").toString());
        objetos[1][5] = imagen;
        obstaculos[1][5] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[2][3] = imagen;
        obstaculos[2][3] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[2][5] = imagen;
        obstaculos[2][5] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("park.png").toString());
        objetos[2][8] = imagen;
        obstaculos[2][8] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[2][10] = imagen;
        obstaculos[2][10] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("home.png").toString());
        objetos[2][1] = imagen;
        obstaculos[2][1] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("park.png").toString());
        objetos[3][8] = imagen;
        obstaculos[3][8] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("mansion.png").toString());
        objetos[4][2] = imagen;
        obstaculos[4][2] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[4][6] = imagen;
        obstaculos[4][6] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[4][11] = imagen;
        obstaculos[4][11] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("home.png").toString());
        objetos[5][4] = imagen;
        obstaculos[5][4] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("hospital.png").toString());
        objetos[5][7] = imagen;
        obstaculos[5][7] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[5][9] = imagen;
        obstaculos[5][9] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("office.png").toString());
        objetos[5][11] = imagen;
        obstaculos[5][11] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("park.png").toString());
        objetos[5][0] = imagen;
        obstaculos[5][0] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[6][11] = imagen;
        obstaculos[6][11] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[7][1] = imagen;
        obstaculos[7][1] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("hospital.png").toString());
        objetos[7][3] = imagen;
        obstaculos[7][3] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("park.png").toString());
        objetos[7][5] = imagen;
        obstaculos[7][5] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("home.png").toString());
        objetos[7][8] = imagen;
        obstaculos[7][8] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("park.png").toString());
        objetos[8][5] = imagen;
        obstaculos[8][5] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[8][10] = imagen;
        obstaculos[8][10] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("home.png").toString());
        objetos[9][1] = imagen;
        obstaculos[9][1] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("pasoPeatonal.png").toString());
        objetos[9][2] = imagen;
//		obstaculos[9][2] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("store.png").toString());
        objetos[9][3] = imagen;
        obstaculos[9][3] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[9][4] = imagen;
        obstaculos[9][4] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("mansion.png").toString());
        objetos[9][10] = imagen;
        obstaculos[9][10] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[9][11] = imagen;
        obstaculos[9][11] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("school1.png").toString());
        objetos[10][6] = imagen;
        obstaculos[10][6] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("tree.png").toString());
        objetos[11][3] = imagen;
        obstaculos[11][3] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("park.png").toString());
        objetos[11][8] = imagen;
        obstaculos[11][8] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new ImageView(Table.class.getResource("taller.png").toString());
        this.iviewCasa = imagen;
        objetos[11][4] = imagen;
        obstaculos[11][4] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);

        imagen = new Vehicle().getImageView(Position.RIGHT);
        this.iviewVehiculo = imagen;
        objetos[1][10] = imagen;
        imagen.setFitHeight(40);
        imagen.setFitWidth(50);

        imagen = new Character().getImageView(Position.RIGHT);
        this.iviewPersonaje = imagen;
        objetos[0][11] = imagen;
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        imagen.setId("17");

        this.objetos = objetos;
    }

    public void eventoTablero(KeyEvent e) {

        if (e.getCode() == KeyCode.RIGHT) {

            boolean avanza = true;
            int posFila = GridPane.getRowIndex(iviewPersonaje);
            int posColumna = GridPane.getColumnIndex(iviewPersonaje);
            tablero.getChildren().remove(iviewPersonaje);

            iviewPersonaje = new Character().getImageView(Position.RIGHT);

            iviewPersonaje.setFitHeight(50);
            iviewPersonaje.setFitWidth(50);
            tablero.add(iviewPersonaje, posColumna, posFila);

            if(posColumna < tamanoTablero - 1) {

                if(obstaculos[posColumna+1][posFila] == null) {

                    if(existeEnTablero(iviewVehiculo, posColumna+1, posFila) != null) { //corregir

                        posFila = GridPane.getRowIndex(iviewVehiculo);
                        posColumna = GridPane.getColumnIndex(iviewVehiculo);

                        if(posColumna < tamanoTablero - 1 && obstaculos[posColumna+1][posFila] == null) {

                            tablero.getChildren().remove(iviewVehiculo);

                            iviewVehiculo = new Vehicle().getImageView(Position.RIGHT);
                            iviewVehiculo.setFitHeight(40);
                            iviewVehiculo.setFitWidth(50);
                            iviewVehiculo.setId("16");
                            tablero.add(iviewVehiculo, posColumna, posFila);

                            GridPane.setColumnIndex(iviewVehiculo, GridPane.getColumnIndex(iviewVehiculo) + 1 );
                            esGanador(iviewVehiculo);
                            isLockedUp(iviewVehiculo);
                        }
                        else {
                            avanza = false;
                        }
                    }

                    if(avanza == true)
                        GridPane.setColumnIndex(iviewPersonaje, GridPane.getColumnIndex(iviewPersonaje) + 1 );
                }
            }
        }

        if (e.getCode() == KeyCode.LEFT) {

            boolean avanza = true;
            int posFila = GridPane.getRowIndex(iviewPersonaje);
            int posColumna = GridPane.getColumnIndex(iviewPersonaje);
            tablero.getChildren().remove(iviewPersonaje);

            iviewPersonaje = new Character().getImageView(Position.LEFT);

            iviewPersonaje.setFitHeight(50);
            iviewPersonaje.setFitWidth(50);
            tablero.add(iviewPersonaje, posColumna, posFila);

            if(posColumna > 0) {

                if(obstaculos[posColumna-1][posFila] == null) {

                    if(existeEnTablero(iviewVehiculo, posColumna-1, posFila) != null) { //corregir

                        posFila = GridPane.getRowIndex(iviewVehiculo);
                        posColumna = GridPane.getColumnIndex(iviewVehiculo);

                        if(posColumna > 0 && obstaculos[posColumna-1][posFila] == null) {

                            tablero.getChildren().remove(iviewVehiculo);

                            iviewVehiculo = new Vehicle().getImageView(Position.LEFT);
                            iviewVehiculo.setFitHeight(40);
                            iviewVehiculo.setFitWidth(50);
                            iviewVehiculo.setId("16");
                            tablero.add(iviewVehiculo, posColumna, posFila);

                            GridPane.setColumnIndex(iviewVehiculo, GridPane.getColumnIndex(iviewVehiculo) - 1 );
                            esGanador(iviewVehiculo);
                            isLockedUp(iviewVehiculo);
                        }
                        else {
                            avanza = false;
                        }
                    }

                    if(avanza == true)
                        GridPane.setColumnIndex(iviewPersonaje, GridPane.getColumnIndex(iviewPersonaje) -1 );
                }
            }
        }

        if(e.getCode() == KeyCode.UP) {

            boolean avanza = true;
            int posFila = GridPane.getRowIndex(iviewPersonaje);
            int posColumna = GridPane.getColumnIndex(iviewPersonaje);
            tablero.getChildren().remove(iviewPersonaje);

            iviewPersonaje = new Character().getImageView(Position.FRONT);

            iviewPersonaje.setFitHeight(50);
            iviewPersonaje.setFitWidth(50);
            tablero.add(iviewPersonaje, posColumna, posFila);

            if(posFila > 0) {

                if(obstaculos[posColumna][posFila-1] == null) {

                    if(existeEnTablero(iviewVehiculo, posColumna, posFila-1) != null) { //corregir

                        posFila = GridPane.getRowIndex(iviewVehiculo);
                        posColumna = GridPane.getColumnIndex(iviewVehiculo);

                        if(posFila > 0 && obstaculos[posColumna][posFila-1] == null) {

                            tablero.getChildren().remove(iviewVehiculo);

                            iviewVehiculo = new Vehicle().getImageView(Position.FRONT);
                            iviewVehiculo.setFitHeight(40);
                            iviewVehiculo.setFitWidth(40);
                            iviewVehiculo.setId("16");
                            tablero.add(iviewVehiculo, posColumna, posFila);

                            GridPane.setRowIndex(iviewVehiculo, GridPane.getRowIndex(iviewVehiculo) - 1 );
                            esGanador(iviewVehiculo);
                            isLockedUp(iviewVehiculo);
                        }
                        else {
                            avanza = false;
                        }
                    }

                    if(avanza == true)
                        GridPane.setRowIndex(iviewPersonaje, GridPane.getRowIndex(iviewPersonaje) -1 );
                }
            }
        }

        if (e.getCode() == KeyCode.DOWN) {

            boolean avanza = true;
            int posFila = GridPane.getRowIndex(iviewPersonaje);
            int posColumna = GridPane.getColumnIndex(iviewPersonaje);
            tablero.getChildren().remove(iviewPersonaje);

            iviewPersonaje = new Character().getImageView(Position.BACK);

            iviewPersonaje.setFitHeight(50);
            iviewPersonaje.setFitWidth(50);
            tablero.add(iviewPersonaje, posColumna, posFila);

            if(posFila < tamanoTablero - 1) {

                if(obstaculos[posColumna][posFila+1] == null) {

                    if(existeEnTablero(iviewVehiculo, posColumna, posFila+1) != null) { //corregir

                        posFila = GridPane.getRowIndex(iviewVehiculo);
                        posColumna = GridPane.getColumnIndex(iviewVehiculo);

                        if(posFila < tamanoTablero - 1 && obstaculos[posColumna][posFila+1] == null) {

                            tablero.getChildren().remove(iviewVehiculo);

                            iviewVehiculo = new Vehicle().getImageView(Position.BACK);
                            iviewVehiculo.setFitHeight(40);
                            iviewVehiculo.setFitWidth(40);
                            iviewVehiculo.setId("16");
                            tablero.add(iviewVehiculo, posColumna, posFila);

                            GridPane.setRowIndex(iviewVehiculo, GridPane.getRowIndex(iviewVehiculo) + 1 );
                            esGanador(iviewVehiculo);
                            isLockedUp(iviewVehiculo);
                        }
                        else {
                            avanza = false;
                        }
                    }

                    if(avanza == true)
                        GridPane.setRowIndex(iviewPersonaje, GridPane.getRowIndex(iviewPersonaje) + 1 );
                }
            }
        }

    }

    private Node existeEnTablero(ImageView objeto, int col, int row) {

        for (Node node : tablero.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {

                System.out.println(node.equals(objeto));
                if(node.equals(objeto))
                    return node;
            }
        }
        return null;
    }

    private void esGanador(ImageView vehiculo) {

        Optional<ButtonType> result = null;
        int posColumna = GridPane.getColumnIndex(vehiculo);
        int posFila = GridPane.getRowIndex(vehiculo);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(":)");
        alert.setHeaderText("¡En Hora Buena!");
        alert.setContentText("¡FELICIDADES " + nombreJugador + " HAS GANADO!");

        File imagenFile = new File(Table.class.getResource("jugador.png").toString());
        if(imagenFile.exists()) {
            alert.setGraphic(new ImageView(Table.class.getResource("jugador.png").toString()));
        }

        if(existeEnTablero(iviewCasa, posColumna+1, posFila) != null) {
            detenerTiempo();
            result = alert.showAndWait();
        }

        if(existeEnTablero(iviewCasa, posColumna-1, posFila) != null) {
            detenerTiempo();
            result = alert.showAndWait();
        }

        if(existeEnTablero(iviewCasa, posColumna, posFila + 1) != null) {
            detenerTiempo();
            result = alert.showAndWait();
        }

        if(existeEnTablero(iviewCasa, posColumna, posFila - 1) != null) {
            detenerTiempo();
            result = alert.showAndWait();
        }

        if (result != null && result.get() == ButtonType.OK) {

            if(nivel < 2) {
                App.level = ++nivel;
                resetGame();
                main.showPartida();
            }
            else {
                App.level = 1;
                resetGame();
                main.showMenu();
            }
        }
    }

    private void isLockedUp(ImageView vehiculo) {

        boolean isLockedUp = false;
        int posColumna = GridPane.getColumnIndex(vehiculo);
        int posFila = GridPane.getRowIndex(vehiculo);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(":(");
        alert.setHeaderText("¡Ups!");
        alert.setContentText("Te has quedado atrapado intenta de nuevo");

        if(posColumna > 0 && posColumna < tamanoTablero - 1 && posFila > 0 && posFila < tamanoTablero - 1) {

            if(obstaculos[posColumna][posFila-1] != null && obstaculos[posColumna+1][posFila] != null)
                isLockedUp = true;

            if(obstaculos[posColumna][posFila-1] != null && obstaculos[posColumna-1][posFila] != null)
                isLockedUp = true;

            if(obstaculos[posColumna][posFila+1] != null && obstaculos[posColumna+1][posFila] != null)
                isLockedUp = true;

            if(obstaculos[posColumna][posFila+1] != null && obstaculos[posColumna-1][posFila] != null)
                isLockedUp = true;

        } else
            isLockedUp = true;

        if(isLockedUp) {
            detenerTiempo();
            alert.showAndWait();
            resetGame();
            main.showPartida();
        }
    }

    public void iniciarTemporizador() {

        time = new Timeline();
        time.setCycleCount(duracion + 1);

        KeyFrame keyFrame = new KeyFrame(

                Duration.seconds(1),

                e ->{

                    if(duracion == 0) {

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle(":(");
                        alert.setHeaderText("¡Ups!");
                        alert.setContentText("El tiempo se agoto, intenta de nuevo");
                        alert.show();

                    }
                    App.lbSeconds.setText( String.valueOf(duracion--) );
                });

        time.getKeyFrames().add(keyFrame);
        time.play();
    }

    private void clearTablePositions() {
        GridPane.setColumnIndex(iviewPersonaje, 0);
        GridPane.setRowIndex(iviewPersonaje, tamanoTablero);
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public void setMain(App main) {
        this.main = main;
    }
}
