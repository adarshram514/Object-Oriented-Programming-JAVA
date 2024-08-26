import java.util.*;
import java.io.Serializable;

public class MineModel implements Serializable {
   
    public static final int SAFE = 4;
    public static final int MINE_FLAG = 3;
    public static final int FLAG = 2;
    public static final int MINE = 1;
    public static final int NO_MINE = 0;
    public static final int C = 10;
    public static final int R = 10;
    public static int sqauresClicked = 0;
    private boolean gameStatus = false;
    private boolean gameWon = false;
    public static int bombs = 30;
    private int[][] board = new int[R][C];
    private int[][] neighbors = new int [R][C];

    public MineModel() {
        for(int i = 0; i < bombs; i++)
        {
            Random rand = new Random();
            int r = rand.nextInt(R);
            int c = rand.nextInt(C);
            board[r][c] = MINE;
        }

        for(int j = 0; j < R; j++)
        {
            for(int k = 0; k < C; k++)
            {
                if(board[j][k] == MINE)
                {
                    neighbors[j][k] = MINE;
                }
                else
                {
                    board[j][k] = NO_MINE;
                    neighbors[j][k] = (findNeighbors(j, k));

                }
            }
        }
    }

    public int findNeighbors(int r, int c) {
        int numOfMines = 0;
        for (int i = r - 1; i <= r + 1; i++)
        {
            for (int j = c - 1; j <= c + 1; j++)
            {
                if (((i < 0) || (i >= R) || (j < 0) || (j >= C)))
                {
                    continue;
                }
                if (board[i][j] == MINE)
                {
                    numOfMines++;
                }
            }
        }
        return numOfMines;
    }

    public void flagSquare(int r, int c) {
        if (board[r][c] == MINE)
        {
            board[r][c] = MINE_FLAG;
        }
        else if (board[r][c] == MINE_FLAG)
        {
            board[r][c] = MINE;
        }

        if(board[r][c] == NO_MINE)
        {
            board[r][c] = FLAG;
        }
        else if (board[r][c] == FLAG)
        {
            board[r][c] = NO_MINE;
        }
    }

    public void revealSquare(int r, int c) {
        if(board[r][c] == NO_MINE)
        {
            board[r][c] = SAFE;
            sqauresClicked++;
            System.out.println(sqauresClicked);
            if(sqauresClicked == R * C - bombs)
            {
                gameWon = true;
            }
        }
        if (board[r][c] == MINE)
        {
            setStatus();
            for (int i = 0; i < R; i++)
            {
                for(int j = 0; j < C; j++)
                {
                    if(board[i][j] == MINE_FLAG)
                    {
                        board[i][j] = MINE;
                    }
                }
            }
        }
    }

    public void setSquares()
    {
        sqauresClicked = 0;
    }
    public void setBombs(int amount)
    {
        bombs = amount;
    }
    public boolean getWin()
    {
        return gameWon;
    }
    public void setStatus()
    {
        gameStatus = true;
    }
    public boolean getStatus()
    {
        return gameStatus;
    }

    public int getMine(int x, int y)
    {
        return board[x][y];
    }
    public int getNeighbor(int x, int y)
    {
        return neighbors[x][y];
    }
}