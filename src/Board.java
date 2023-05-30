import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
public class Board extends JPanel {

    public Pieces[] piece = new Pieces[13];
    static Board board = new Board();
    private final int[][] emptyBoard =
            {{0,0,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,0}};
    public int[][] gameBoard =
                   {{0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0}};
    public final int[][] finishedBoard =
                   {{1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1}};


    //adds a piece to the board
    public void addMatrix(int[][] board, Pieces piece)
    {

        for(int j = 0;j< 4; j++ )
        {
            for(int i = 0;i<4; i++)
            {
                if(j+piece.getY() <8 && i+piece.getX()<8 && j+ piece.getY() >=0 && i+piece.getX()>=0)
                board[j+piece.getY()][i+piece.getX()] = board[j+piece.getY()][i+piece.getX()] + piece.getArray()[j][i];
            }
        }
    }
    //removes a piece from the board
    public void subtractMatrix(int[][] board, Pieces piece)
    {
        for(int j =0;j<4;j++)
        {
            for(int i =0;i<4;i++)
            {
                if(j+piece.getY() <8 && i+piece.getX()<8 && j+ piece.getY() >=0 && i+piece.getX()>=0)
                    board[j+piece.getY()][i+piece.getX()] = board[j+piece.getY()][i+piece.getX()] - piece.getArray()[j][i];
            }
        }
    }
    //prints the board with all the pieces on it
   public void printBoard(int[][] board) {


       for(int j = 0;j< 8; j++ )
       {
           for(int i = 0;i<8; i++)
           {
               System.out.print(board[j][i] + " ");
           }
           System.out.print("\n");
       }


    }
    //creates all the pieces
    public void setUp(){


        int [][] array0 =
                        {{1,1,1,0},
                         {1,0,1,0},
                         {0,0,0,0},
                         {0,0,0,0}};
        int [][] array1 =
                        {{1,1,1,1},
                         {0,0,1,0},
                         {0,0,0,0},
                         {0,0,0,0}};
        int [][] array2 =
                         {{1,0,0,0},
                          {1,1,0,0},
                          {0,1,0,0},
                          {0,1,0,0}};
        int [][] array3 =
                        {{1,0,1,0},
                         {1,1,1,0},
                         {1,0,1,0},
                         {0,0,0,0}};
        int [][] array4 =
                        {{0,1,0,0},
                         {1,1,1,0},
                         {1,0,0,0},
                         {0,0,0,0}};
        int [][] array5 =
                        {{1,1,0,0},
                         {1,1,0,0},
                         {0,0,0,0},
                         {0,0,0,0}};
        int [][] array6 =
                        {{1,0,0,0},
                         {1,1,1,0},
                         {0,0,1,0},
                         {0,0,0,0}};
        int [][] array7 =
                        {{1,0,0,0},
                         {1,0,0,0},
                         {1,1,1,0},
                         {0,0,0,0}};
        int [][] array8 =
                        {{1,1,0,0},
                         {0,1,1,0},
                         {0,0,0,0},
                         {0,0,0,0}};
        int [][] array9 =
                        {{1,1,1,0},
                         {0,1,0,0},
                         {0,0,0,0},
                         {0,0,0,0}};
        int [][] array10 =
                        {{1,0,0,0},
                         {1,1,1,1},
                         {0,0,0,0},
                         {0,0,0,0}};
        int [][] array11 =
                        {{1,1,1,0},
                         {1,1,1,0},
                         {0,0,0,0},
                         {0,0,0,0}};
        int [][] array12 =
                        {{1,1,0,0},
                         {0,1,0,0},
                         {0,1,0,0},
                         {0,0,0,0}};
        Color color0 = new Color(250,60,70);
        Color color1 = new Color(20,140,85);
        Color color2 = new Color(36,62,62);
        Color color3 = new Color(200,215,225);
        Color color4 = new Color(100,45,140);
        Color color5 = new Color(35,70,150);
        Color color6 = new Color(180,100,200);
        Color color7 = new Color(170,200,70);
        Color color8 = new Color(50,200,210);
        Color color9 = new Color(135,40,145);
        Color color10 = new Color(30,30,80);
        Color color11 = new Color(130,120,191);
        Color color12= new Color(110,180,60);
        board.piece[0] = new Pieces((int)(Math.random() * 20) -8 ,(int)(Math.random()*10) -3, array0, color0);
        board.piece[1] = new Pieces((int)(Math.random() * 20) -8 ,(int)(Math.random()*10) -3, array1,color1);
        board.piece[2] = new Pieces((int)(Math.random() * 20) -8 ,(int)(Math.random()*10) -3, array2,color2);
        board.piece[3] = new Pieces((int)(Math.random() * 20) -8 ,(int)(Math.random()*10) -3, array3,color3);
        board.piece[4] = new Pieces((int)(Math.random() * 20) -8 ,(int)(Math.random()*10) -3, array4,color4);
        board.piece[5] = new Pieces((int)(Math.random() * 20) -8 ,(int)(Math.random()*10) -3, array5,color5);
        board.piece[6] = new Pieces((int)(Math.random() * 20) -8 ,(int)(Math.random()*10) -3, array6,color6);
        board.piece[7] = new Pieces((int)(Math.random() * 20) -8 ,(int)(Math.random()*10) -3, array7,color7);
        board.piece[8] = new Pieces((int)(Math.random() * 20) -8 ,(int)(Math.random()*10) -3, array8,color8);
        board.piece[9] = new Pieces((int)(Math.random() * 20) -8 ,(int)(Math.random()*10) -3, array9,color9);
        board.piece[10] = new Pieces((int)(Math.random() * 20) -8 ,(int)(Math.random()*10) -3, array10,color10);
        board.piece[11] = new Pieces((int)(Math.random() * 20) -8 ,(int)(Math.random()*10) -3, array11,color11);
        board.piece[12] = new Pieces((int)(Math.random() * 20) -8 ,(int)(Math.random()*10) -3, array12,color12);
        for(int n=0;n<13;n++) {
            board.addMatrix(board.gameBoard, board.piece[n]);
        }
    }
    //takes number and char from user and uses it to do an action with a specific piece
    public void processInput(int n, char input)
    {
        if(input == 'a')
        {
            board.subtractMatrix(board.gameBoard,board.piece[n]);
            board.piece[n].moveLeft(board.piece[n]);
            board.addMatrix(board.gameBoard,board.piece[n]);
        }
        if(input == 'w')
        {
            board.subtractMatrix(board.gameBoard,board.piece[n]);
            board.piece[n].moveUp(board.piece[n]);
            board.addMatrix(board.gameBoard,board.piece[n]);
        }
        if(input == 's')
        {
            board.subtractMatrix(board.gameBoard,board.piece[n]);
            board.piece[n].moveDown(board.piece[n]);
            board.addMatrix(board.gameBoard,board.piece[n]);
        }
        if(input == 'd')
        {
            board.subtractMatrix(board.gameBoard,board.piece[n]);
            board.piece[n].moveRight(board.piece[n]);
            board.addMatrix(board.gameBoard,board.piece[n]);
        }
        if(input == 'q')
        {
            board.subtractMatrix(board.gameBoard,board.piece[n]);
            board.piece[n].rotateLeft(board.piece[n].getArray());
            board.addMatrix(board.gameBoard,board.piece[n]);
        }
        if(input == 'e')
        {
            board.subtractMatrix(board.gameBoard,board.piece[n]);
            board.piece[n].rotateRight(board.piece[n].getArray());
            board.addMatrix(board.gameBoard,board.piece[n]);
        }

    }
















  /*  public static void main(String[] args) {
        Scanner kboard = new Scanner(System.in);

        board.setUp();
        board.addMatrix(board.gameBoard,board.piece[0]);
        board.addMatrix(board.gameBoard,board.piece[1]);
        board.addMatrix(board.gameBoard,board.piece[2]);
        board.addMatrix(board.gameBoard,board.piece[3]);
        board.addMatrix(board.gameBoard,board.piece[4]);
        board.addMatrix(board.gameBoard,board.piece[5]);
        board.addMatrix(board.gameBoard,board.piece[6]);
        board.addMatrix(board.gameBoard,board.piece[7]);
        board.addMatrix(board.gameBoard,board.piece[8]);
        board.addMatrix(board.gameBoard,board.piece[9]);
        board.addMatrix(board.gameBoard,board.piece[10]);
        board.addMatrix(board.gameBoard,board.piece[11]);
        board.addMatrix(board.gameBoard,board.piece[12]);



        board.printBoard(board.gameBoard);
        while(true) {
            //n is the piece number, input controls the action
            int n = kboard.nextInt();
            char input = kboard.next().charAt(0);
            board.processInput(n, input);
            board.printBoard(board.gameBoard);
        }





    }

   */
}
