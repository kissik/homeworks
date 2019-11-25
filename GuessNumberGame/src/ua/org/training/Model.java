package ua.org.training;

import java.util.Random;

/**
 * Created by @kissik on 21 NOV 2019
 */

public class Model {

    private int leftBorder,
                rightBorder;
    private boolean isWin;
    private int statistics;

    private int number;

    public int getLeftBorder() {
        return leftBorder;
    }

    public int getRightBorder(){
        return rightBorder;
    }

    public int getNumber(){
        return number;
    }

    public Model(int leftBorder, int rightBorder){
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
        this.isWin = false;
        this.statistics = 0;
        this.number = getRandom();
    }

    private int getRandom(){
        Random r = new Random();
        return r.nextInt(this.rightBorder - this.leftBorder - 1) + this.leftBorder + 1;
    }

    public void setNumber(){
        this.number = getRandom();
    }

    public boolean guessNumber(int shot){

        this.statistics++;
        if ((shot < number) && (shot > getLeftBorder())) this.leftBorder = shot;
        if ((shot > number) && (shot < getRightBorder())) this.rightBorder = shot;
        if (shot == number) this.isWin = true;

        return this.isWin();
    }

    public boolean isWin(){
        return this.isWin;
    }

    public String getStatistics(String message){
        return message + this.statistics;
    }

    public String getHelp(String message, String delimiter){
        return message + this.leftBorder + delimiter + this.rightBorder;
    }
}
