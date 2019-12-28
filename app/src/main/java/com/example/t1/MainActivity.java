package com.example.t1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.Layout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.t1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private GameViewModel mViewModel;
    private ActivityMainBinding mainBinding;
    private Player player1 = new Player("Muhammad", "X");
    private Player player2 = new Player("Javad", "O");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = ViewModelProviders
                .of(this , new GameFactory(
                        new GameBoard(player1, player2)
                )).get(GameViewModel.class);
        mViewModel.getWinner().observe(this, this::checkWinner);
        mainBinding.setViewmodel(mViewModel);
    }

    private void checkWinner(Player winner) {
//        if(winner == null)return;
        if(winner == GameBoard.NO_ONE){
            Toast.makeText(this, "No one win this game . ", Toast.LENGTH_SHORT).show();
            mViewModel.clearCells();
        }else if(winner == player1){
            Toast.makeText(this, ">> "+ player1.name +"<< win this game . ", Toast.LENGTH_SHORT).show();
            mViewModel.clearCells();
        }else if(winner == player2){
            Toast.makeText(this, ">> "+ player2.name +"<< win this game . ", Toast.LENGTH_SHORT).show();
            mViewModel.clearCells();
        }

    }
}
