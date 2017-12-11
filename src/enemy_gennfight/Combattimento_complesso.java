/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enemy_gennfight;

import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class Combattimento_complesso {

    //creazione personaggio, creazione personaggio avversario, combattimento tra i personaggi
    
    
    
    static int BAB;
    static String taglia;
    static int b_taglia;

    static int forza;
    static int destrezza;
    static int costituzione;
    static int intelligenza;
    static int saggezza;
    static int carisma;

    static int FOR = (forza - 10) / 2;
    static int DES = (destrezza - 10) / 2;
    static int COS = (costituzione - 10) / 2;
    static int INT = (intelligenza - 10) / 2;
    static int SAG = (saggezza - 10) / 2;
    static int CAR = (carisma - 10) / 2;

    static double txc;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    static void SelezioneMostro() //richiesta di dati utili per la costruzione di un avversario
    {
        String mostro = JOptionPane.showInputDialog("Che mostro stai affrontando?");
        
        if (mostro.equals("goblin"))
            
        {
        
        Nemico goblin; 
        Umanoide();
        
        }
        
        
    }

    static void CombattiMostro() //simulazione combattimento
    {

    }

    static void Tiro_Colpire() {
//generazione di tiri per colpire 

        int bonus_colpire = BAB + FOR + b_taglia;

        txc = Math.random();

        if (txc <= 0.05) {

            txc = 1;
        }
        if (txc > 0.05 && txc <= 0.10) {

            txc = 2;
        }
        if (txc > 0.10 && txc <= 0.15) {

            txc = 3;
        }
        if (txc > 0.15 && txc <= 0.20) {

            txc = 4;
        }
        if (txc > 0.20 && txc <= 0.25) {

            txc = 5;
        }
        if (txc > 0.25 && txc <= 0.30) {

            txc = 6;
        }
        if (txc > 0.30 && txc <= 0.35) {

            txc = 7;
        }
        if (txc > 0.35 && txc <= 0.40) {

            txc = 8;
        }
        if (txc > 0.40 && txc <= 0.45) {

            txc = 9;
        }
        if (txc > 0.45 && txc <= 0.50) {

            txc = 10;
        }
        if (txc > 0.50 && txc <= 0.55) {

            txc = 11;
        }
        if (txc > 0.55 && txc <= 0.60) {

            txc = 12;
        }
        if (txc > 0.60 && txc <= 0.65) {

            txc = 13;
        }
        if (txc > 0.65 && txc <= 0.70) {

            txc = 14;
        }
        if (txc > 0.70 && txc <= 0.75) {

            txc = 15;
        }
        if (txc > 0.75 && txc <= 0.80) {

            txc = 16;
        }
        if (txc > 0.80 && txc <= 0.85) {

            txc = 17;
        }
        if (txc > 0.85 && txc <= 0.90) {

            txc = 18;
        }
        if (txc > 0.90 && txc <= 0.95) {

            txc = 19;
        }
        if (txc > 0.95 && txc <= 1) {

            txc = 20;
        }

        int Tiro_colpire = (int) txc + bonus_colpire;

    }

    static void Tiro_danni() //generazione di tiri per i danni
    {

        int bonus_danni = FOR + altro;

        int Tiro_Danni = txd + bonus_danni;

    }

   class Nemico {
        
      
     int forza;
     int destrezza;
     int costituzione;
     int intelligenza;
     int saggezza;
     int carisma;
        
     int taglia;
     
     String tipo; 
        
    
        
    } 




static public void Umanoide(){
       
   
      int tipo_DV;
      int BAB;
               
      int tempra;
      int riflessi;
      int volontà;        
  
      
            
} 

}

