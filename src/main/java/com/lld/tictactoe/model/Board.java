package com.lld.tictactoe.model;

public class Board {
    int size;
    PlayingPiece[][]board;

    public Board(int size) {
        board = new PlayingPiece[size][size];
        this.size = size;
    }

    public boolean addPiece(PlayingPiece playingPiece, int x, int y) {
        if(board[x][y] != null) {
            return false;
        }

        board[x][y] = playingPiece;
        return true;
    }

    public void print() {
        for(int i = 0; i<size; i++) {
            for(int j = 0; j<size; j++) {
                if(board[i][j] == null) {
                    System.out.print("-   ");
                } else {
                    System.out.print(board[i][j].pieceType + "  ");
                }
            }
            System.out.println();
        }
    }

    public PlayingPiece getValue(int row, int col) {
        return board[row][col];
    }

    public boolean hasEmptyPosition() {
        for(int i = 0; i< size; i++) {
            for(int j = 0; j< size; j++) {
                if(board[i][j] == null) {
                    return true;
                }
            }
        }

        return false;
    }


}
