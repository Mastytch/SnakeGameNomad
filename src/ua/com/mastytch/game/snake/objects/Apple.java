package ua.com.mastytch.game.snake.objects;

import ua.com.mastytch.game.snake.SnakeGame;

/**
 * Created by mastytchmac on 09.12.16.
 */
public class Apple {

    SnakeGame main;

    public int posX;
    public int posY;

    public Apple(int startX, int startY){
        posX = startX;
        posY = startY;
    }

    public void setRandomPos(){

        posX = (int)(Math.random() * main.WIDTH);
        posY = (int)(Math.random() * main.HEIGHT);

    }
}
