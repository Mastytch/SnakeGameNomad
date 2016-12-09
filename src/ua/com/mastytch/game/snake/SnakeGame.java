package ua.com.mastytch.game.snake;

import ua.com.mastytch.game.snake.objects.Apple;
import ua.com.mastytch.game.snake.objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by mastytchmac on 09.12.16.
 */
public class SnakeGame extends JPanel implements ActionListener {

    public static final int SCALE = 32;
    public static final int WIDTH = 16;
    public static final int HEIGHT = 16;
    public static final int SPEED = 4;

    Snake snake = new Snake(8, 8, 7, 8);
    Apple apple = new Apple((int)(Math.random() * WIDTH), (int)(Math.random() * HEIGHT));
    Timer timer = new Timer(1000/SPEED, this);

    public SnakeGame(){

        timer.start();
        addKeyListener(new Keyboard());
        setFocusable(true);
    }
    public void paint(Graphics g){

        g.setColor(color(5, 50, 10));
        g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);

        g.setColor(color(255, 216, 0));

        for (int xx = 0; xx < WIDTH * SCALE; xx+=SCALE) {
            g.drawLine(xx, 0, xx, HEIGHT * SCALE);
        }
        for (int yy = 0; yy < HEIGHT * SCALE; yy+=SCALE) {
            g.drawLine(0, yy, WIDTH * SCALE, yy);
        }

        for (int d = 0; d < snake.length; d++) {
            g.setColor(color(0, 0, 255));
            g.fillRect(snake.snakeX[d] * SCALE + 1, snake.snakeY[d] * SCALE +1, SCALE - 1, SCALE -1);
        }

        g.setColor(color(255, 0, 0));
        g.fillRect(apple.posX * SCALE -1, apple.posY * SCALE -1, SCALE -1, SCALE -1);
    }

    public Color color (int red, int green, int blue){
        return new Color(red, green, blue);
    }


    public static void main(String[] args) {



        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setSize(WIDTH*SCALE, HEIGHT*SCALE);
        jFrame.setLocationRelativeTo(null);
        jFrame.add (new SnakeGame());
        jFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        snake.move();

        if ((snake.snakeX[0] == apple.posX) & (snake.snakeY[0] == apple.posY)) {
            apple.setRandomPos();
            snake.length++;
        }
        for (int i = 1; i < snake.length; i++) {
            if ((snake.snakeX[i] == apple.posX) & (snake.snakeY[i] == apple.posY)) {
                apple.setRandomPos();
            }
        }

        repaint();
    }

    private class Keyboard extends KeyAdapter{
        public void keyPressed(KeyEvent kEvt){
            int key = kEvt.getKeyCode();

            if ((key == KeyEvent.VK_RIGHT) & snake.direction != 2) snake.direction = 0;
            if ((key == KeyEvent.VK_DOWN) & snake.direction != 3) snake.direction = 1;
            if ((key == KeyEvent.VK_LEFT) & snake.direction != 0) snake.direction = 2;
            if ((key == KeyEvent.VK_UP) & snake.direction != 1) snake.direction = 3;
        }
    }
}
