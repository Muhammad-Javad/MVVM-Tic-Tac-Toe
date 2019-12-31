package com.example.t1.viewmodel;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.databinding.ObservableArrayMap;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.t1.model.GameBoard;
import com.example.t1.model.Player;
import com.example.t1.view.MainActivity;

import java.util.Map;
import java.util.TreeMap;

public class GameViewModel extends ViewModel {

    public GameBoard game;
    public ObservableArrayMap<String, Player> cells;

    public void onCellClick(String key){
        int row = Integer.parseInt(String.valueOf(key.charAt(0)));
        int column = Integer.parseInt(String.valueOf(key.charAt(1)));
        if(game.cells[row][column] == null){
            cells.put(key, game.currentPlayer);
            game.addPlayerCell(row, column);
        }
        display();
        DisplayLogic();
    }

    public void init(GameBoard game){
        this.game = game;
        cells = new ObservableArrayMap<>();
    }

    public void clearCells(){
        cells.clear();
        game.reset();
    }

    public LiveData<Player> getWinner(){
        return game.winner;
    }

    public void display(){
        for (int i = 0; i < cells.size(); i++){
            Log.i(MainActivity.TAG, "Display -> " + cells.keyAt(i));
        }
        Log.i(MainActivity.TAG, "================================================");
    }


    public void DisplayLogic(){
//        Log.i(MainActivity.TAG, "================================================");
//        Log.i(MainActivity.TAG, "++++++++++++++++++++++++++++++++++++++++++++++++");
        for (int i = 0; i < game.cells.length; i++){
            for (int j = 0; j < game.cells[0].length; j++){
                if(game.cells[i][j] != null)
                    Log.i(MainActivity.TAG, "Game -> " + i + j + " = " + game.cells[i][j].player.name);
            }
        }
        Log.i(MainActivity.TAG, "++++++++++++++++++++++++++++++++++++++++++++++++");
    }

}
