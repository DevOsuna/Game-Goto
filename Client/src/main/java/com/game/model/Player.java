package com.game.model;

import com.game.model.enums.Direction;

import java.io.Serializable;

public class Player implements Serializable {

    boolean isWinner;
    private int numRivals;
    private String name;
    private int colCharacter;
    private int rowCharacter;
    private int colVehicle;
    private int rowVehicle;
    private Direction directionVehicle;
    private Direction directionCharacter;

    public Player() {
        isWinner = false;
        numRivals = 0;
        name = "";
        colCharacter = -1;
        rowCharacter = -1;
        colVehicle = -1;
        rowVehicle = -1;
        directionCharacter = null;
        directionVehicle = null;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColCharacter() {
        return colCharacter;
    }

    public void setColCharacter(int colCharacter) {
        this.colCharacter = colCharacter;
    }

    public int getRowCharacter() {
        return rowCharacter;
    }

    public void setRowCharacter(int rowCharacter) {
        this.rowCharacter = rowCharacter;
    }

    public int getNumRivals() {
        return numRivals;
    }

    public void setNumRivals(int numRivals) {
        this.numRivals = numRivals;
    }

    public Direction getDirectionVehicle() {
        return directionVehicle;
    }

    public void setDirectionVehicle(Direction directionVehicle) {
        this.directionVehicle = directionVehicle;
    }

    public Direction getDirectionCharacter() {
        return directionCharacter;
    }

    public void setDirectionCharacter(Direction directionCharacter) {
        this.directionCharacter = directionCharacter;
    }

    public int getColVehicle() {
        return colVehicle;
    }

    public void setColVehicle(int colVehicle) {
        this.colVehicle = colVehicle;
    }

    public int getRowVehicle() {
        return rowVehicle;
    }

    public void setRowVehicle(int rowVehicle) {
        this.rowVehicle = rowVehicle;
    }
}
