package com.example.t1.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.t1.model.GameBoard;

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
