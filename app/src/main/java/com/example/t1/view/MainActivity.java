package com.example.t1.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.t1.R;
import com.example.t1.databinding.ActivityMainBinding;
import com.example.t1.model.GameBoard;
import com.example.t1.model.Player;
import com.example.t1.viewmodel.GameFactory;
import com.example.t1.viewmodel.GameViewModel;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MY" + MainActivity.class.getName();

    private GameViewModel mViewModel;
    private ActivityMainBinding mainBinding;
    private Player player1 = new Player("Muhammad", "X");
    private Player player2 = new Player("Javad", "O");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCraete()");
        //Binding
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //ViewModel
        mViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        if(mViewModel.cells == null && mViewModel.game == null){
            mViewModel.init(new GameBoard(player1, player2));
        }
        mViewModel.getWinner().observe(this, this::checkWinner);
        mainBinding.setViewmodel(mViewModel);

    }

    private void checkWinner(Player winner) {
        if(winner.equals(GameBoard.NO_ONE)){
            Toast.makeText(this, "No one win this game . ", Toast.LENGTH_SHORT).show();
            mViewModel.clearCells();
        }else if(winner.equals(player1)){
            Toast.makeText(this, ">> "+ player1.name +"<< win this game . ", Toast.LENGTH_SHORT).show();
            mViewModel.clearCells();
        }else if(winner.equals(player2)){
            Toast.makeText(this, ">> "+ player2.name +"<< win this game . ", Toast.LENGTH_SHORT).show();
            mViewModel.clearCells();
        }

    }
}
