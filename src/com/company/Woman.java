package com.company;

public class Woman implements BodyTypeFormula {
    @Override
    public String calctype(int n1) {
        String res="";
        if(n1<16){
            res="Ectomorph";
        }
        else if(n1>=16 && n1<18){
            res="Mesomorph";
        }
        else if(n1>=18){
            res="Endomorph";
        }
        return res;
    }
}
