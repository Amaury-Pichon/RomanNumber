package com.example.amaury.romannumber;


public class KatHanoi {

    public static void main (String[] args ) {

        int random =  3 + (int)(Math.random() * 5* System.currentTimeMillis());
        hanoi(5);

    }

    public static void hanoi(int nbrDisk){

        PlatHanoi monPlateau = new PlatHanoi(nbrDisk);
        monPlateau.resoudre();


    }



}

