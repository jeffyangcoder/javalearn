package com.ecc.javalanguage.aboutClass;

public class HexReader {
    String[] input ={"00A110D1D260219 ","78700F1318141E0C ","6A197D45B0FFFFF "};

    public static void main(String[] args) {
        HexReader hex = new HexReader();
        for(int i=0;i<hex.input.length;i++){
            hex.realine(hex.input[i]);
        }
    }

    private void realine(String op) {
        try{
            for(int j = 0;j + 1 < op.length();j+=2){
                String sub = op.substring(j,j+2);
                int num = Integer.parseInt(sub,16);
                if(num == 255)   return;
                System.out.println(num + " ");
            }
        }finally {
            System.out.println(" ");
        }
    }
}
