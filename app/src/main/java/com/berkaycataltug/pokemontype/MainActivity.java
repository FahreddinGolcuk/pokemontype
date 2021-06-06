package com.berkaycataltug.pokemontype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button1 = findViewById(R.id.button_id_1);
        final Button button2 = findViewById(R.id.button_id_2);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               pushFunction1(v);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pushFunction2(v);
            }
        });
    }

    public void pushFunction1(View v){
        Intent intent = new Intent(this, Function1Activity.class);
        startActivity(intent);
    }
    public void pushFunction2(View v){
        Intent intent = new Intent(this, Function2Activity.class);
        startActivity(intent);
    }
}