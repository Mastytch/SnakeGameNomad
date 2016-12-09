package ua.com.mastytch.game.snake.objects;

import ua.com.mastytch.game.snake.SnakeGame;

/**
 * Created by mastytchmac on 09.12.16.
 */
public class Snake {

    SnakeGame sg;

    public int direction = 0;
    public int length = 2;


    public int snakeX[] = new int[sg.WIDTH * sg.HEIGHT];
    public int snakeY[] = new int[sg.WIDTH * sg.HEIGHT];

    public Snake(int x0, int y0, int x1, int y1) {
        snakeX[0] = x0;
        snakeY[0] = y0;
        snakeX[1] = x1;
        snakeY[1] = y1;

    }

    public void move(){

        for (int d = length; d > 0 ; d--) {
            snakeX[d] = snakeX[d-1];
            snakeY[d] = snakeY[d-1];
        }

        if (direction == 0) snakeX[0]++;
        if (direction == 1) snakeY[0]++;
        if (direction == 2) snakeX[0]--;
        if (direction == 3) snakeY[0]--;

        for (int i = length -1; i > 0; i--) {
            if ((snakeX[0] == snakeX[i] & snakeY[0] == snakeY[i])) length = i-2; //змея откусывает хвост. :(
        }


        if(snakeX[0] > sg.WIDTH) snakeX[0] = 0;
        if(snakeX[0] < 0) snakeX[0] = sg.WIDTH - 1;
        if(snakeY[0] > sg.HEIGHT) snakeY[0] = 0;
        if(snakeY[0] < 0) snakeY[0] = sg.HEIGHT - 1;


        if (length < 2) length = 2;

    }
}
