package com.company.models;

import java.util.HashMap;

public class Constants {
    private static HashMap<String,String> constantsMap =new HashMap<>();

    public Constants(){
        loadFromDB();
    }

    public static void setFineRate(int r) {
        constantsMap.put("fineRate",String.valueOf(r));
    }

    public static int getRate() {
        return Integer.parseInt(constantsMap.getOrDefault("rate","10"));

    }

    public void loadFromDB(){

    }
    public static int getFineRate(){
        return Integer.parseInt(constantsMap.getOrDefault("fineRate","14"));
    }

}
