import java.awt.*;
import javax.swing.*;
import java.awt.Robot;
import java.awt.event.*;
import java.awt.Graphics;
import java.util.Scanner;

public class BoardGraphics extends Board implements ActionListener, KeyListener,MouseListener {


    private final int windowWidth = 1200;
    private final int windowHeight = 650;
    private final int boardHeight = 400;
    private final int boardWidth = 400;

    private boolean right, left, up, down, turnRight, turnLeft;

    private final int boardXEnd = (boardWidth + windowWidth) /2;
    private final int boardXStart = boardXEnd - boardWidth;
    private final int boardYEnd = (boardHeight + windowHeight) /2;
    private final int boardYStart = boardYEnd - boardHeight;
    private final int square = boardWidth/8;

    private Timer timer;
    public static int selected =0;
    private static final Scanner kboard = new Scanner(System.in);
    private int mouseX;
    private int mouseY;


    public BoardGraphics()
    {
        setPreferredSize(new Dimension(windowWidth, windowHeight));
    }

    public Color getSquareColor(int x, int y) {
       Color clickedColor = Color.red;
        try {
                Robot robot = new Robot();
                 clickedColor = robot.getPixelColor(x, y);
            }
            catch(AWTException e){
                e.printStackTrace();
        }
        return clickedColor;

    }

    public void actionPerformed(ActionEvent e) {
        update();
        repaint();

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_D)
        {
            right = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_W)
        {
            up = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_S)
        {
            down = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_E)
        {
            turnRight = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_Q)
        {
            turnLeft = true;
        }

    }

    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_D)
        {
            right = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            left = false;

        }
        if(e.getKeyCode() == KeyEvent.VK_W)
        {
            up = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_S)
        {
            down = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_E)
        {
            turnRight = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_Q)
        {
            turnLeft = false;
        }
    }

    public void setUpPuzzle(){

        if(timer != null){
            timer.stop();
        }

        timer = new Timer(60, this);
        timer.start();
        up=down=left=right=turnRight=turnLeft=false;
        board.setUp();
    }
    
    public void update()
    {

        //makes the selected piece move
        if(left){
            board.piece[selected].moveLeft(board.piece[selected]);
        }
        if(right){
            board.piece[selected].moveRight(board.piece[selected]);
        }
        if(up){
            board.piece[selected].moveUp(board.piece[selected]);
        }
        if(down){
            board.piece[selected].moveDown(board.piece[selected]);
        }
        if(turnRight){
            board.piece[selected].rotateRight(board.piece[selected].getArray());
        }
        if(turnLeft){
            board.piece[selected].rotateLeft(board.piece[selected].getArray());
        }

        //stops a piece from leaving the screen
        if(board.piece[selected].getX() <-8)
        {
            board.piece[selected].setX(-8,board.piece[selected]);
        }
        if(board.piece[selected].getX() > 13)
        {
            board.piece[selected].setX(13,board.piece[selected]);
        }
        if(board.piece[selected].getY() < -4){
            board.piece[selected].setY(-4,board.piece[selected]);
        }
        if(board.piece[selected].getY() > 8){
            board.piece[selected].setY(8,board.piece[selected]);
        }

        //allows the player to win
        if(board.gameBoard == board.finishedBoard){
            System.out.println("you win");
        }


    }

    public void mousePressed(MouseEvent e){
        mouseX = e.getXOnScreen();
        mouseY = e.getYOnScreen();
        Color a = getSquareColor(mouseX,mouseY);

         if(a.equals(board.piece[0].getColor())){
             selected =0;
         }
         if(a.equals(board.piece[1].getColor())){
            selected =1;
        }
         if(a.equals(board.piece[2].getColor())){
            selected =2;
        }
        if(a.equals(board.piece[3].getColor())){
            selected =3;
        }
        if(a.equals(board.piece[4].getColor())){
            selected =4;
        }
        if(a.equals(board.piece[5].getColor())){
            selected =5;
        }
        if(a.equals(board.piece[6].getColor())){
            selected =6;
        }
        if(a.equals(board.piece[7].getColor())){
            selected =7;
        }
        if(a.equals(board.piece[8].getColor())){
            selected =8;
        }
        if(a.equals(board.piece[9].getColor())){
        selected =9;
        }
         if(a.equals(board.piece[10].getColor())){
        selected =10;
        }
         if(a.equals(board.piece[11].getColor())){
        selected =11;
        }
         if(a.equals(board.piece[12].getColor())){
        selected =12;
        }
    }
    public void mouseReleased(MouseEvent e){
    }
    public void mouseClicked(MouseEvent e){
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e){
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, windowWidth, windowHeight);

        g.setColor(Color.BLACK);
        g.fillRect(boardXStart, boardYStart, boardWidth, boardHeight);

        Color boardGray = new Color(12,12,12);
        g.setColor(boardGray);

        for(int y=0; y<8;y++)
        {
            for(int x =0; x<8; x+=2)
            {
                g.fillRect(boardXStart + (y% 2 + x)*square,boardYStart + y*square,square,square);
            }
        }
        drawPiece(board.piece[0], g);
        drawPiece(board.piece[1], g);
        drawPiece(board.piece[2], g);
        drawPiece(board.piece[3], g);
        drawPiece(board.piece[4], g);
        drawPiece(board.piece[5], g);
        drawPiece(board.piece[6], g);
        drawPiece(board.piece[7], g);
        drawPiece(board.piece[8], g);
        drawPiece(board.piece[9], g);
        drawPiece(board.piece[10], g);
        drawPiece(board.piece[11], g);
        drawPiece(board.piece[12], g);
        drawPiece(board.piece[selected], g);
    }

    public void drawPiece(Pieces piece,Graphics g)
    {
        for(int j =0; j<4; j++)
        {
            for(int i=0;i<4; i++)
            {
                if(piece.getArray()[j][i] ==1)
                {
                    g.setColor(piece.getColor());
                    g.fillRect(boardXStart + (piece.getX() + i)*square, boardYStart + (piece.getY() +j)*square, square,square);
                }
            }
        }
    }
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setTitle("Puzzle");
        //explore group layout maybe to allow for more components.
        frame.setLayout(new BorderLayout());


        BoardGraphics puzzle = new BoardGraphics();
        frame.add(puzzle, BorderLayout.CENTER);

        puzzle.addKeyListener(puzzle);
        frame.addKeyListener(puzzle);
        
        puzzle.addMouseListener(puzzle);
        frame.addMouseListener(puzzle);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();

         puzzle.setUpPuzzle();
    }
}


