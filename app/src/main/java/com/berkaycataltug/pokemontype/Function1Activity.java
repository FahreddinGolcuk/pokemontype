package com.berkaycataltug.pokemontype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Pokemon {
    String name;
    String type;
    String[] weak;
    String[] strong;
    Pokemon(String name,String type,String[] strong,String[] weak){
        this.name = name;
        this.type = type;
        this.strong = strong;
        this.weak = weak;
    }
}

class MockPokemon {
    private ArrayList<Pokemon> arrayList;

    private static MockPokemon instance;

    private MockPokemon(){
        arrayList = new ArrayList<Pokemon>();
        arrayList.add(new Pokemon("abra","psychic",new String[]{"fighting","poison"},new String[]{"steel","pyschic","dark"}));
        arrayList.add(new Pokemon("bellsprout","grass",new String[]{"fighting","poison"},new String[]{"steel","pyschic","dark"}));
        arrayList.add(new Pokemon("bulbasaur","grass",new String[]{"fighting","poison"},new String[]{"steel","pyschic","dark"}));
        arrayList.add(new Pokemon("charmander","fire",new String[]{"fighting","poison"},new String[]{"steel","pyschic","dark"}));
        arrayList.add(new Pokemon("geodude","rock",new String[]{"fighting","poison"},new String[]{"steel","pyschic","dark"}));
        arrayList.add(new Pokemon("growlithe","fire",new String[]{"fighting","poison"},new String[]{"steel","pyschic","dark"}));
        arrayList.add(new Pokemon("machop","fighting",new String[]{"fighting","poison"},new String[]{"steel","pyschic","dark"}));
        arrayList.add(new Pokemon("mankey","fighting",new String[]{"fighting","poison"},new String[]{"steel","pyschic","dark"}));
        arrayList.add(new Pokemon("oddish","grass",new String[]{"fighting","poison"},new String[]{"steel","pyschic","dark"}));
        arrayList.add(new Pokemon("pidgey","flying",new String[]{"fighting","poison"},new String[]{"steel","pyschic","dark"}));
        arrayList.add(new Pokemon("pikachu","electric",new String[]{"fighting","poison"},new String[]{"steel","pyschic","dark"}));
        arrayList.add(new Pokemon("poliwag","water",new String[]{"fighting","poison"},new String[]{"steel","pyschic","dark"}));
        arrayList.add(new Pokemon("ponyta","fire",new String[]{"fighting","poison"},new String[]{"steel","pyschic","dark"}));
        arrayList.add(new Pokemon("rattata","normal",new String[]{"fighting","poison"},new String[]{"steel","pyschic","dark"}));
        arrayList.add(new Pokemon("snorlax","normal",new String[]{"fighting","poison"},new String[]{"steel","pyschic","dark"}));
        arrayList.add(new Pokemon("squirtle","water",new String[]{"fighting","poison"},new String[]{"steel","pyschic","dark"}));
        arrayList.add(new Pokemon("staryu","water",new String[]{"fighting","poison"},new String[]{"steel","pyschic","dark"}));
        arrayList.add(new Pokemon("vulpix","fire",new String[]{"fighting","poison"},new String[]{"steel","pyschic","dark"}));
    }

    public static MockPokemon getInstance(){
        if (instance == null){
            instance = new MockPokemon();
        }
        return instance;
    }

    public ArrayList<Pokemon> getArrayList() {
        return arrayList;
    }
}

public class Function1Activity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button sendBtn;

    private RadioButton option1;
    private RadioButton option2;
    private RadioButton option3;
    private RadioButton option4;
    private ImageView IV;
    private Pokemon selectedPokemon;
    private int gameCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function1);
        prepareGame();
    }

    private void prepareGame(){
        radioGroup = findViewById(R.id.radioGroup);
        sendBtn = findViewById(R.id.send_btn);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        ImageView IV = findViewById(R.id.imageView);
        ArrayList<Pokemon> randomSelecteds = getRandomElement(MockPokemon.getInstance().getArrayList(),4);
        Random r = new Random();
        int randomIndex = r.nextInt(5);
        int j = getResources().getIdentifier("@drawable/"+randomSelecteds.get(randomIndex).name+'_'+randomSelecteds.get(randomIndex).type, "null", getPackageName());
        IV.setImageResource(j);
        option1.setText(randomSelecteds.get(0).type);
        option2.setText(randomSelecteds.get(1).type);
        option3.setText(randomSelecteds.get(2).type);
        option4.setText(randomSelecteds.get(3).type);
        selectedPokemon = randomSelecteds.get(randomIndex);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(selectedId);
                if(selectedPokemon.name == radioButton.getText()){
                    gameCounter++;
                    prepareGame();
                }
                else {
                    Toast.makeText(Function1Activity.this, "WRONG", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Log.e("SELECTED", randomSelecteds.get(randomIndex).name+MockPokemon.getInstance().getArrayList().size());
    }

    private ArrayList<Pokemon> getRandomElement(ArrayList<Pokemon> list, int totalItems){
        Random rand = new Random();
        ArrayList<Pokemon> newList = new ArrayList<>();
        ArrayList<Pokemon> tmpList = new ArrayList<>(list);
        for(int i = 0; i<totalItems; i++){
            int randomIndex = rand.nextInt(tmpList.size());
            newList.add(tmpList.get(randomIndex));
            tmpList.remove(randomIndex);
        }
        return newList;
    }
}