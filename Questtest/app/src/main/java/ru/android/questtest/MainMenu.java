package ru.android.questtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        Button NewGame = (Button)findViewById(R.id.NewGame);
        NewGame.setOnClickListener(this);

        Button Remove = (Button)findViewById(R.id.remove);
        Remove.setClickable(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.NewGame:
                Intent intent = new Intent(this, Game.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
