package com.example.homework02_program01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_j_saveColor;
    TextView tv_j_red;
    TextView tv_j_green;
    TextView tv_j_blue;
    TextView tv_j_represent;
    TextView tv_j_redNum;
    TextView tv_j_greenNum;
    TextView tv_j_blueNum;
    TextView tv_j_hex;
    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;
    ArrayList<Colors> listOfColors;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_j_saveColor=findViewById(R.id.btn_v_saveColor);
        tv_j_red=findViewById(R.id.tv_v_red);
        tv_j_green=findViewById(R.id.tv_v_green);
        tv_j_blue=findViewById(R.id.tv_v_blue);
        tv_j_represent=findViewById(R.id.tv_v_represent);
        tv_j_redNum=findViewById(R.id.tv_v_redNum);
        tv_j_greenNum=findViewById(R.id.tv_v_greenNum);
        tv_j_blueNum=findViewById(R.id.tv_v_blueNum);
        tv_j_hex=findViewById(R.id.tv_v_hex);
        sb_j_red=findViewById(R.id.sb_v_red);
        sb_j_green=findViewById(R.id.sb_v_green);
        sb_j_blue=findViewById(R.id.sb_v_blue);


        Colors colors=new Colors();
        listOfColors=new ArrayList<Colors>();


        saveColorButtonEventHandler();
    }

    public void saveColorButtonEventHandler()
    {
        btn_j_saveColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Log.d("Bababooey",sb_j_blue.getProgress()+"");

                addColor();
            }
        });
    }
    public void addColor()
    {
        //Get int from the seek bars based on what the number is
        int red=sb_j_red.getProgress();
        int green=sb_j_green.getProgress();
        int blue=sb_j_blue.getProgress();

        //Add a new color to the list with the info from seek bars
        Colors newColor=new Colors(red, green, blue);

        //Store the information in the arrayList
        listOfColors.add(newColor);
    }



}