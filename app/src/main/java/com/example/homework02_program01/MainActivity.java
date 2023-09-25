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


        //Colors colors=new Colors();
        listOfColors=new ArrayList<Colors>();


        saveColorButtonEventHandler();
        seekBarEventHandler();


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
        //Colors newColor=new Colors(red, green, blue);

        //Store the information in the arrayList
        //listOfColors.add(newColor);
    }

    public void seekBarEventHandler()
    {
        Colors newColor=new Colors();
        //Changes text on number depending on seek bar progress
        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                //i equals seekbar progress
                int x=0;
                String r=Colors.decimalToHex(i);
                tv_j_redNum.setText(i + "");
                newColor.setHexRed(r);

                hexModifier(r,x);
                Log.d("Red",r);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        sb_j_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                //i equals seekbar progress
                int x=1;
                String g=Colors.decimalToHex(i);
                tv_j_greenNum.setText(i + "");
                newColor.setHexGreen(g);

                hexModifier(g,x);
                Log.d("Green",g);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        sb_j_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                //i equals seekbar progress
                int x=2;
                String bl=Colors.decimalToHex(i);
                tv_j_blueNum.setText(i+"");
                newColor.setHexBlue(bl);

                hexModifier(bl,x);
                Log.d("Blue",bl);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });



    }


    public void hexModifier(String hexClr, int x)
    {
        //i equals seek bar hex portion
        //x represents the part of the hex which needs to be replaced

        String hex=tv_j_hex.getText().toString();
        String hexReplace="";

        //If red is changed, add new hex to beginning and re-add rest to new string
        if(x == 0)
        {
            hexReplace+=hexClr;

            for(int i=2;i<6;i++)
            {
                hexReplace+=hex.charAt(i);
            }
        }
        //If green is changed, add current hex nums to beginning and end while putting new hex color in middle
        else if(x==1)
        {
            for(int i=0;i<2;i++)
            {
                hexReplace+=hex.charAt(i);
            }
            hexReplace+=hexClr;
            for(int i=4; i<6;i++)
            {
                hexReplace+=hex.charAt(i);
            }
        }
        //If blue is changed, add first four current hex nums to beginning while putting new color at the end
        else if(x==2)
        {
            for(int i=0; i<4; i++)
            {
                hexReplace+=hex.charAt(i);
            }
            hexReplace+=hexClr;
        }




        tv_j_hex.setText(hexReplace);
        setBackgroundColor();
    }

    public void setBackgroundColor()
    {

    }


}