package com.example.homework02_program01;

public class ColorInfo
{
    //hex portions are saved in "FF" format and added together to make the full hex
    private String hexRed;
    private String hexGreen;
    private String hexBlue;
    private String hexCode;

    public ColorInfo()
    {

    }
    public ColorInfo(String r, String g, String b, String h)
    {
        this.hexRed=r;
        this.hexGreen=g;
        this.hexBlue=b;
        this.hexCode=h;
    }

    //Getters-Setters
    public String getHexRed() {return hexRed;}

    public void setHexRed(String hexRed) {this.hexRed = hexRed;}

    public String getHexGreen() {return hexGreen;}

    public void setHexGreen(String hexGreen) {this.hexGreen = hexGreen;}

    public String getHexBlue() {return hexBlue;}

    public void setHexBlue(String hexBlue) {this.hexBlue = hexBlue;}
    public String getHex() {return hexCode;}

    public void setHex(String hexCode) {this.hexCode = hexCode;}

    //--------------------------------------------------------------------------------------

    //Decimal to Hexadecimal Converter
    public static String decimalToHex(int d) {
        String digits = "0123456789ABCDEF";
        int base = 16;   // flexible to change in any base under 16
        String hex = "";

        //Catches single digit values
        if (d <= 0) return "00";
        if (d>0 && d<16)
        {
            int digit=d%base;
            hex="0"+digits.charAt(digit);

            return hex;
        }

        //Handles all double digit values
        while (d > 0)
        {
            int digit = d % base; // rightmost digit
            hex = digits.charAt(digit) + hex;  // string concatenation
            d = d / base;
        }

        return hex;
    }




}
