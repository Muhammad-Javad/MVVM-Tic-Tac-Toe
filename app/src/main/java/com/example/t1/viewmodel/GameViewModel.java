package com.example.t1.viewmodel;

import androidx.databinding.ObservableArrayMap;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.t1.model.GameBoard;
import com.example.t1.model.Player;

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
