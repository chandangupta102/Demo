package com.lld.tictactoe;

import com.lld.tictactoe.enums.PieceType;
import com.lld.tictactoe.model.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    Board board;
    Queue<Player> playerQueue;
    Scanner scanner;
    int position[];
    public Game() {
        playerQueue = new LinkedList<>();
        playerQueue.add(new Player("ABC", new PlayingPieceO()));
        playerQueue.add(new Player("XYZ", new PlayingPieceX()));
        board = new Board(3);
        scanner = new Scanner(System.in);
    }

    private void userInput() {
        position = new int[2];
        System.out.print("Please Enter the row -> ");
        position[0] = scanner.nextInt();
        System.out.print("Please Enter the column -> ");
        position[1] = scanner.nextInt();
    }

    public String start() {
        board.print();
        while (true) {
            Player playerTurn = playerQueue.remove();
            userInput();
            boolean isSuccess = board.addPiece(playerTurn.getPlayingPiece(), position[0], position[1]);
            playerQueue.add(playerTurn);
            if(!isSuccess) {
                System.out.println("Please enter correct Position");
                continue;
            }
            board.print();

            if(isWinner(playerTurn.getPlayingPiece().getPieceType())) {
                return playerTurn.getName();
            }

            if(!board.hasEmptyPosition()) {
                break;
            }
        }

        return "DRAW";
    }

    private boolean isWinner(PieceType pieceType) {
        boolean isRowMatch = true;
        boolean isColMatch = true;
        boolean isDiagonalMatch = true;
        boolean isSecondDiagonalMatch = true;

        for(int i = 0; i< 3; i++) {
            PlayingPiece playingPiece = board.getValue(position[0], i);
            if(playingPiece == null || playingPiece.getPieceType() != pieceType) {
                isRowMatch = false;
                break;
            }
        }

        for(int i = 0; i< 3; i++) {
            PlayingPiece playingPiece = board.getValue(i, position[1]);
            if(playingPiece == null || playingPiece.getPieceType() != pieceType) {
                isColMatch = false;
                break;
            }
        }

        for(int i = 0, j= 0; i< 3; i++, j++) {
            PlayingPiece playingPiece = board.getValue(i, j);
            if(playingPiece == null || playingPiece.getPieceType() != pieceType) {
                isDiagonalMatch = false;
                break;
            }
        }

        for(int i = 0, j= 2; i < 3; i++, j--) {
            PlayingPiece playingPiece = board.getValue(i, j);
            if(playingPiece == null || playingPiece.getPieceType() != pieceType) {
                isSecondDiagonalMatch = false;
                break;
            }
        }



        return isRowMatch || isColMatch || isDiagonalMatch || isSecondDiagonalMatch;
    }

}
