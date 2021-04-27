package com.ecc.javalanguage.datatype.bitset;

public class test {
    public static void main(String[] args) {
        HolidaySked cal = new HolidaySked();
        if (args.length > 0) {
            try {
                int whichDay = Integer.parseInt(args[0]);
                if (cal.isHoliday(whichDay)) {
                    System.out.println("Day number:" + whichDay + " is a holiday!");
                } else {
                    System.out.println("Day number: " + whichDay + " is not a holiday!");
                }
            }catch (NumberFormatException nfe){
                System.out.println("Error:" + nfe.getMessage());
            }
        }
    }
}
