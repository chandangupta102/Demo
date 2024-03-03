package com.lld;

import com.lld.java8.FunctionalInterfaceClass;
import com.lld.java8.StreamIntermediateStateTest;
import com.lld.java8.StreamTerminalStateTest;

public class Main {
    public static void main(String args[]) {
        System.out.println("****** WELCOME TO LLD *****");

        /**
         * Tic Tac Toe Game LLD Implementation
         */
//        Game game = new Game();
//        System.out.println("WINNER IS: " + game.start());

        /**
         * Java 8 test
         */
        StreamTerminalStateTest streamTest = new StreamTerminalStateTest();
        streamTest.start();

        StreamIntermediateStateTest streamIntermediateStateTest = new StreamIntermediateStateTest();
        streamIntermediateStateTest.start();

        FunctionalInterfaceClass functionalInterfaceClass = new FunctionalInterfaceClass();
        functionalInterfaceClass.start();



    }
}
