package com.example.homework02_program01;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<ColorInfo> listOfColors;

    public ColorListAdapter(Context c, ArrayList<ColorInfo> ls)
    {
        //Passed to the class from MainActivity.java
        context=c;
        listOfColors=ls;
    }

    @Override
    public int getCount() {return listOfColors.size();}

    @Override
    public Object getItem(int i) {return listOfColors.get(i);}

    @Override
    public long getItemId(int i) {return i;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view==null)
        {
            LayoutInflater mInflater=(LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view=mInflater.inflate(R.layout.custom_cell, null);
        }

        //Find GUI elements in my custom_cell
        TextView red=view.findViewById(R.id.tv_v_customCell_red);
        TextView redNum=view.findViewById(R.id.tv_v_customCell_redNum);
        TextView green=view.findViewById(R.id.tv_v_customCell_green);
        TextView greenNum=view.findViewById(R.id.tv_v_customCell_greenNum);
        TextView blue=view.findViewById(R.id.tv_v_customCell_blue);
        TextView blueNum=view.findViewById(R.id.tv_v_customCell_blueNum);
        TextView hex=view.findViewById(R.id.tv_v_customCell_hex);
        TextView hexCode=view.findViewById(R.id.tv_v_customCell_hexCode);
        View customCell_j=view.findViewById(R.id.customCell_v);

        //get the user at position i
        ColorInfo colors=listOfColors.get(i);

        //set the HTU for the custom_cell.xml
        redNum.setText(colors.getHexRed());
        greenNum.setText(colors.getHexGreen());
        blueNum.setText(colors.getHexBlue());
        hexCode.setText(colors.getHex());
        customCell_j.setBackgroundColor(Color.parseColor("#"+hexCode.getText().toString()));

        //Sets text color
        if(Integer.parseInt(redNum.getText().toString()) <50 && Integer.parseInt(greenNum.getText().toString()) <50 &&
        Integer.parseInt(blueNum.getText().toString()) <50)
        {
            red.setTextColor(Color.parseColor("#FFFFFF"));
            redNum.setTextColor(Color.parseColor("#FFFFFF"));
            green.setTextColor(Color.parseColor("#FFFFFF"));
            greenNum.setTextColor(Color.parseColor("#FFFFFF"));
            blue.setTextColor(Color.parseColor("#FFFFFF"));
            blueNum.setTextColor(Color.parseColor("#FFFFFF"));
            hex.setTextColor(Color.parseColor("#FFFFFF"));
            hexCode.setTextColor(Color.parseColor("#FFFFFF"));
        }

        return view;
    }


}
