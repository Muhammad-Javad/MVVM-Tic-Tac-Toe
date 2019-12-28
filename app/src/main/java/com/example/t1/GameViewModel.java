package com.example.t1;

import androidx.databinding.ObservableArrayMap;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GameViewModel extends ViewModel {

    GameBoard game;
    public ObservableArrayMap<String, Player> cells;

    public GameViewModel(GameBoard game){
        this.game = game;
        cells = new ObservableArrayMap<>();
    }

    public void onCellClick(String key){
        int row = Integer.parseInt(String.valueOf(key.charAt(0)));
        int column = Integer.parseInt(String.valueOf(key.charAt(1)));
        if(game.cells[row][column] == null){
            cells.put(key, game.currentPlayer);
            game.addPlayerCell(row, column);
        }
    }

    public void clearCells(){
        cells.clear();
        game.reset();
    }

    public LiveData<Player> getWinner(){
        return game.winner;
    }

}
