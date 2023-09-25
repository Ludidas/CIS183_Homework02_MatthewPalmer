package com.example.homework02_program01;

public class Colors
{
    private String hexRed;
    private String hexGreen;
    private String hexBlue;

    public Colors()
    {

    }
    public Colors(String r, String g, String b)
    {
        this.hexRed=r;
        this.hexGreen=g;
        this.hexBlue=b;
    }

    //Getters-Setters
    public String getHexRed() {return hexRed;}

    public void setHexRed(String hexRed) {this.hexRed = hexRed;}

    public String getHexGreen() {return hexGreen;}

    public void setHexGreen(String hexGreen) {this.hexGreen = hexGreen;}

    public String getHexBlue() {return hexBlue;}

    public void setHexBlue(String hexBlue) {this.hexBlue = hexBlue;}

    //--------------------------------------------------------------------------------------

    //Decimal to Hexadecimal Converter
    public static String decimalToHex(int d) {
        String digits = "0123456789ABCDEF";
        if (d <= 0) return "0";
        int base = 16;   // flexible to change in any base under 16
        String hex = "";
        while (d > 0)
        {
            int digit = d % base;              // rightmost digit
            hex = digits.charAt(digit) + hex;  // string concatenation
            d = d / base;
        }
        return hex;
    }

}
