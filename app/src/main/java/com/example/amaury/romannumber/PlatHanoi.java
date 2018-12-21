package com.example.amaury.romannumber;

import java.util.ArrayList;

public class PlatHanoi {

    private ArrayList<Integer> tourA;
    private ArrayList<Integer> tourB;
    private ArrayList<Integer> tourC;



    int nbPalets;
    int nbCoups;



    public PlatHanoi (int nbPalets) {

        this.nbPalets = nbPalets;

        tourA = new ArrayList<Integer>();
        tourB = new ArrayList<Integer>();
        tourC = new ArrayList<Integer>();

        for(int i= nbPalets; i> 0; i--){
            tourA.add(i);
        }
        this.afficheFancy();
    }

    public void resoudre(){
        this.moveAll(tourA, tourC, tourB, nbPalets );
        this.afficheNbCoups();
    }

    public void moveAll(ArrayList<Integer> depart, ArrayList<Integer> arrivee, ArrayList<Integer> other, int niveau){
        if (niveau > 0) {
            if (niveau > 1) {
                moveAll(depart, other, arrivee,niveau - 1);
                movePalet(depart, arrivee);
                moveAll(other, arrivee, depart,niveau - 1);
            } else {
                movePalet(depart, arrivee);
            }
        }
        else{
            System.out.println("Pas de palets!");
        }

        nbCoups++;

    }

    public void affiche() {
        ArrayList[] tours = {tourA, tourB, tourC};
        for(int idTour = 0; idTour< tours.length; idTour++){
            for(int index=0; index < tours[idTour].size(); index++){
                System.out.print(tours[idTour].get(index) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void afficheNbCoups(){
        System.out.println(nbCoups);
    }

    public void movePalet(ArrayList<Integer> depart, ArrayList<Integer> arrivee){
        arrivee.add(depart.get(depart.size() - 1));
        depart.remove(depart.size() - 1);
        this.afficheFancy();
    }

    public void afficheFancy(){
        ArrayList[] tours = {tourA, tourB, tourC};
        for(int index=nbPalets - 1; index >=0 ; index--){
            for(int tour=0; tour < tours.length; tour ++){
                if(tours[tour].size() > index) {
                    System.out.print("      " + tours[tour].get(index));
                }
                else{
                    System.out.print("       ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}



