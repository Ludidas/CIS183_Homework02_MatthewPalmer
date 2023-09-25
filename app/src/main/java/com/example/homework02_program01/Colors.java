package com.example.homework02_program01;

public class Colors
{
    private int hexRed;
    private int hexGreen;
    private int hexBlue;

    public Colors()
    {

    }
    public Colors(int r, int g, int b)
    {
        this.hexRed=r;
        this.hexGreen=g;
        this.hexBlue=b;
    }


    public int getHexRed() {return hexRed;}

    public void setHexRed(int hexRed) {this.hexRed = hexRed;}

    public int getHexGreen() {return hexGreen;}

    public void setHexGreen(int hexGreen) {this.hexGreen = hexGreen;}

    public int getHexBlue() {return hexBlue;}

    public void setHexBlue(int hexBlue) {this.hexBlue = hexBlue;}
}
