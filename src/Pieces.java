import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class Pieces   {

    private int x;
    private int y;
    private int[][] array;
    private Color color;


    public Pieces(int pX, int pY,int[][] pieceArray, Color pieceColor)
    {
        array = pieceArray;
        x=pX;
        y=pY;
        color = pieceColor;
    }

    public int getX() {
        return x;
    }
    public void setX(int n, Pieces piece) {
        piece.x =n;
    }
    public int getY() {
        return y;
    }
    public void setY(int n, Pieces piece){
        piece.y=n;
    }
    public int[][] getArray(){
        return array;
    }
    public Color getColor(){
        return color;
    }

    public void rotateLeft(int[][] array){
        int[][]finalArray = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        for(int j=0; j<4; j++)
        {
            for(int i = 0; i<4; i++)
            {
                finalArray[j][i]= array[i][j];
            }
        }


        for(int j=0; j<4; j++)
        {
            for(int i = 0; i<4; i++)
            {
                array[j][i]= finalArray[3-j][i];
            }
        }
    }

    public void rotateRight(int[][] array){
        rotateLeft(array);
        rotateLeft(array);
        rotateLeft(array);
    }

    public void moveUp(Pieces piece){

        piece.y -= 1;
    }
    public void moveDown(Pieces piece){
        piece.y += 1;
    }
    public void moveLeft(Pieces piece){
        piece.x -= 1;
    }
    public void moveRight(Pieces piece){
        piece.x += 1;
    }
}
