/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author vinic
 */
public class Board {
    private final Symbols board[][];
    
    public Board() {
        this.board = new Symbols[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Symbols.E;
            }
        }
    }
    
    public Board(Symbols[][] board) {
        this.board = new Symbols[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }
    
    public void setBoardAt(Symbols symbol, int i, int j) {
        if (i < 0 || i > 2 || j < 0 || j > 2) {
            return;
        }
        this.board[i][j] = symbol;
    }
    
    public Symbols getBoardAt(int i, int j) {
        if (i < 0 || i > 2 || j < 0 || j > 2) {
            return Symbols.E;
        }
        return this.board[i][j];
    }
    
    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j] == Symbols.E)
                    return false;
            }
        }
        return true;
    }
    
    
    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = Symbols.E;
            }
        }
    }
    
    public Symbols[][] getBoard() {
        return this.board;
    }
    
    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n\t");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(this.board[i][j]).append(", ");
            }
            sb.append("\n\t");
        }
        sb.append("]\n");
        return sb.toString();
    }
}
