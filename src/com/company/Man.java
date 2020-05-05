package com.company;

public class Man implements BodyTypeFormula {


    @Override
    public String calctype(int n1) {
        String res="";
        if(n1<18){
            res="Ectomorph";
        }
        else if(n1>=18 && n1<20){
            res="Mesomorph";
        }
        else if(n1>=20){
            res="Endomorph";
        }
        return res;
    }
}
