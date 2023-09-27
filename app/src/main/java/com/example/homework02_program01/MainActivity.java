package com.example.homework02_program01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
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
    ListView lv_j_colorList;
    ArrayList<ColorInfo> listOfColors;
    ColorListAdapter adapter;
    View mainActivity_j;



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
        lv_j_colorList=findViewById(R.id.lv_v_colorList);
        mainActivity_j=findViewById(R.id.mainActivity_v);

        //Colors colors=new Colors();
        listOfColors=new ArrayList<ColorInfo>();


        saveColorButtonEventHandler();
        seekBarEventHandler();
        listViewEventHandler();
        fillListView();


    }

    public void saveColorButtonEventHandler()
    {
        btn_j_saveColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Log.d("Bababooey",sb_j_blue.getProgress()+"");

                addColor();
                adapter.notifyDataSetChanged();
                resetBackgroundColor();
            }
        });
    }
    public void addColor()
    {
        //Add a new color to the list with the info from seek bars
        ColorInfo newColorInfo=new ColorInfo(tv_j_redNum.getText().toString(), tv_j_greenNum.getText().toString(),
                tv_j_blueNum.getText().toString(), tv_j_hex.getText().toString());

        //Store the information in the arrayList
        listOfColors.add(newColorInfo);
    }

    public void fillListView()
    {
        adapter=new ColorListAdapter(this, listOfColors);
        lv_j_colorList.setAdapter(adapter);
    }

    //=============================================================================================

    public void seekBarEventHandler()
    {
        ColorInfo newColor=new ColorInfo();
        //Changes text on number depending on seek bar progress
        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                //i equals seekbar progress
                int x=0;
                String r=ColorInfo.decimalToHex(i);
                tv_j_redNum.setText(i + "");
                newColor.setHexRed(r);

                hexModifier(r,x);
                hexBackgroundColor();
                textColorChange();
                //Log.d("Red",r);
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
                String g=ColorInfo.decimalToHex(i);
                tv_j_greenNum.setText(i + "");
                newColor.setHexGreen(g);

                hexModifier(g,x);
                hexBackgroundColor();
                textColorChange();
                //Log.d("Green",g);
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
                String bl=ColorInfo.decimalToHex(i);
                tv_j_blueNum.setText(i+"");
                newColor.setHexBlue(bl);

                hexModifier(bl,x);
                hexBackgroundColor();
                textColorChange();
                //Log.d("Blue",bl);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });



    }

    public void listViewEventHandler()
    {
        lv_j_colorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {

                tv_j_redNum.setText(listOfColors.get(i).getHexRed());
                tv_j_greenNum.setText(listOfColors.get(i).getHexGreen());
                tv_j_blueNum.setText(listOfColors.get(i).getHexBlue());
                tv_j_hex.setText(listOfColors.get(i).getHex());
                sb_j_red.setProgress(Integer.parseInt(listOfColors.get(i).getHexRed()));
                sb_j_green.setProgress(Integer.parseInt(listOfColors.get(i).getHexGreen()));
                sb_j_blue.setProgress(Integer.parseInt(listOfColors.get(i).getHexBlue()));
                hexBackgroundColor();


                Log.d("int i", i +"");
            }
        });
    }

    //==================================================================================

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
    }

    public void hexBackgroundColor()
    {
        //Takes hex value from the hex representation to change background color
        mainActivity_j.setBackgroundColor(Color.parseColor("#"+tv_j_hex.getText().toString()));
    }

    public void textColorChange()
    {
        //Change text to be white if all values of red, green, and blue are less than 50, else change it to black
        if (Integer.parseInt(tv_j_redNum.getText().toString())<50 && Integer.parseInt(tv_j_greenNum.getText().toString())<50 &&
                Integer.parseInt(tv_j_blueNum.getText().toString())<50)
        {
            tv_j_red.setTextColor(Color.parseColor("#FFFFFF"));
            tv_j_green.setTextColor(Color.parseColor("#FFFFFF"));
            tv_j_blue.setTextColor(Color.parseColor("#FFFFFF"));
            tv_j_redNum.setTextColor(Color.parseColor("#FFFFFF"));
            tv_j_greenNum.setTextColor(Color.parseColor("#FFFFFF"));
            tv_j_blueNum.setTextColor(Color.parseColor("#FFFFFF"));
            tv_j_represent.setTextColor(Color.parseColor("#FFFFFF"));
            tv_j_hex.setTextColor(Color.parseColor("#FFFFFF"));
        }
        else
        {
            tv_j_red.setTextColor(Color.parseColor("#000000"));
            tv_j_green.setTextColor(Color.parseColor("#000000"));
            tv_j_blue.setTextColor(Color.parseColor("#000000"));
            tv_j_redNum.setTextColor(Color.parseColor("#000000"));
            tv_j_greenNum.setTextColor(Color.parseColor("#000000"));
            tv_j_blueNum.setTextColor(Color.parseColor("#000000"));
            tv_j_represent.setTextColor(Color.parseColor("#000000"));
            tv_j_hex.setTextColor(Color.parseColor("#000000"));
        }
    }

    public void resetBackgroundColor()
    {
        tv_j_hex.setText("FFFFFF");
        tv_j_redNum.setText("255");
        tv_j_greenNum.setText("255");
        tv_j_blueNum.setText("255");
        sb_j_red.setProgress(255);
        sb_j_green.setProgress(255);
        sb_j_blue.setProgress(255);


        //resets the colors
        hexBackgroundColor();
        textColorChange();
    }


}