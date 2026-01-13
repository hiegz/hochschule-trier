package oop.minesweeper;

import java.util.Arrays;

public class Game
{
    private boolean[][] mines;
    private int[][] board;
    private boolean gameStarted;
    private int rows;
    private int cols;
    private int cellsToReveal;

    public void startGame(boolean[][] matrix)
    {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
        {
            throw new IllegalArgumentException("Ungültiges Array");
        }

        int colLength = matrix[0].length;
        for (boolean[] row : matrix)
        {
            if (row == null || row.length != colLength)
            {
                throw new IllegalArgumentException("Array muss rechteckig sein");
            }
        }

        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.mines = new boolean[rows][cols];
        this.board = new int[rows][cols];
        this.gameStarted = true;
        this.cellsToReveal = rows * cols;

        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                this.mines[r][c] = matrix[r][c];
                this.board[r][c] = -1;
                if (matrix[r][c])
                {
                    cellsToReveal--;
                }
            }
        }
    }

    public MoveResult move(int row, int col)
    {
        if (!gameStarted)
        {
            return MoveResult.NOT_STARTED;
        }
        if (board[row][col] != -1)
        {
            return MoveResult.USELESS;
        }

        if (mines[row][col])
        {
            for (int r = 0; r < rows; r++)
            {
                for (int c = 0; c < cols; c++)
                {
                    if (mines[r][c])
                    {
                        board[r][c] = 9;
                    }
                }
            }
            gameStarted = false;
            return MoveResult.LOST;
        }
        else
        {
            reveal(row, col);
            if (cellsToReveal == 0)
            {
                gameStarted = false;
                return MoveResult.WON;
            }
            else
            {
                return MoveResult.CONTINUE;
            }
        }
    }

    private void reveal(int row, int col)
    {
        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != -1)
        {
            return;
        }

        int minesAround = countAdjacentMines(row, col);
        board[row][col] = minesAround;
        cellsToReveal--;

        if (minesAround == 0)
        {
            for (int dr = -1; dr <= 1; dr++)
            {
                for (int dc = -1; dc <= 1; dc++)
                {
                    if (dr != 0 || dc != 0)
                    {
                        reveal(row + dr, col + dc);
                    }
                }
            }
        }
    }

    private int countAdjacentMines(int row, int col)
    {
        int count = 0;
        for (int dr = -1; dr <= 1; dr++)
        {
            for (int dc = -1; dc <= 1; dc++)
            {
                if (dr == 0 && dc == 0)
                {
                    continue;
                }
                int r = row + dr;
                int c = col + dc;
                if (r >= 0 && r < rows && c >= 0 && c < cols && mines[r][c])
                {
                    count++;
                }
            }
        }
        return count;
    }

    public int[][] getBoard()
    {
        int[][] copy = new int[rows][cols];
        for (int r = 0; r < rows; r++)
        {
            copy[r] = Arrays.copyOf(board[r], cols);
        }
        return copy;
    }
}
