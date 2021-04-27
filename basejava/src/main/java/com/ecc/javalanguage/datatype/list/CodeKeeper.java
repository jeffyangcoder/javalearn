package com.ecc.javalanguage.datatype.list;

import java.util.ArrayList;
import java.util.Iterator;

public class CodeKeeper {
    ArrayList list;
    String[] codes = {"alpha","lambda","gamma","delta" , "zeta"};

    public CodeKeeper(){
         list = new ArrayList();

        for(String i:codes){
            addCodes(i);
        }

        //display all

        for (Iterator iterator = list.iterator();iterator.hasNext();){
            String output = (String) iterator.next();
            System.out.println(output);
        }
    }

    private void addCodes(String code){
        if (!list.contains(code)){
            list.add(code);
        }
    }

    public static void main(String[] args) {

        CodeKeeper codeKeeper = new CodeKeeper();
    }
}
