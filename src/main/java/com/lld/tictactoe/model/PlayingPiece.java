package com.lld.tictactoe.model;

import com.lld.tictactoe.enums.PieceType;

public class PlayingPiece {
    PieceType pieceType;

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    PlayingPiece(PieceType pieceType) {
        this.pieceType = pieceType;
    }
}
