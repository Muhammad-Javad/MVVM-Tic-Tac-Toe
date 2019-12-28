package com.example.t1;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class GameFactory implements ViewModelProvider.Factory {

    private GameBoard gameBoard;

    public GameFactory(GameBoard board){
        this.gameBoard = board;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new GameViewModel(gameBoard);
    }
}
