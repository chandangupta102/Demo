package com.lld;

import com.lld.tictactoe.Game;

public class Main {
    public static void main(String args[]) {
        System.out.println("****** WELCOME TO LLD *****");

        /**
         * Tic Tac Toe Game LLD Implementation
         */
        Game game = new Game();
        System.out.println("WINNER IS: " + game.start());

    }
}
