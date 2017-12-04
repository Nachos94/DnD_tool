/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creazione_personaggio;

import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */

public class Creazione_Personaggio {

    static String name;

    static String tx_stat;

    static int txcm;
    static int txcd;

    static int Forza;
    static int Destrezza;
    static int Costituzione;
    static int Intelligenza;
    static int Saggezza;
    static int Carisma;
    static String caratteristiche;

    static int FOR;
    static int DES;
    static int COS;
    static int INT;
    static int SAG;
    static int CAR;

    static int Lv;
    static int BAB;
    static int PF;
    static int DV;
    static String Ts;
    static String Lv_tx;

    static String Guerriero;
    static String Mago;
    static String Ladro;
    static String Barbaro;
    static String Chierico;
    static String Druido;
    static String Monaco;
    static String Paladino;

    static String capacita;
    static String capacita1;
    static String capacita2;
    static String capacita3;
    static String capacita4;
    static String capacita5;
    static String capacita6;
    static String capacita7;
    static String capacita8;
    static String capacita9;
    static String capacita10;
    static String capacita11;
    static String capacita12;
    static String capacita13;
    static String capacita14;
    static String capacita15;
    static String capacita16;
    static String capacita17;
    static String capacita18;
    static String capacita19;
    static String capacita20;
    static String risultato;

    public static void main(String[] args) {

        /*
        raccolgo caratteristiche
          raccolgo lv
          raccolgo classe - che racchiude capacità speciali, calcolo ts , calcolo bab , dado vita
          raccolgo equipaggiamento
        
          calcolo punti ferita,CA, Bonus al colpire, bonus ai danni
         */
        String name = JOptionPane.showInputDialog("---- nome del Personaggio ----");

        raccoltaCaratteristiche();

        String Lv_tx = JOptionPane.showInputDialog("A che lv vuoi creare il personaggio?");
        Lv = Integer.parseInt(Lv_tx);

        raccoltaClasse();

    }

    static void raccoltaCaratteristiche() {

        tx_stat = JOptionPane.showInputDialog("Forza");
        Forza = Integer.parseInt(tx_stat);
        tx_stat = JOptionPane.showInputDialog("Destrezza");
        Destrezza = Integer.parseInt(tx_stat);
        tx_stat = JOptionPane.showInputDialog("Costituzione");
        Costituzione = Integer.parseInt(tx_stat);
        tx_stat = JOptionPane.showInputDialog("Intelligenza");
        Intelligenza = Integer.parseInt(tx_stat);
        tx_stat = JOptionPane.showInputDialog("Saggezza");
        Saggezza = Integer.parseInt(tx_stat);
        tx_stat = JOptionPane.showInputDialog("Carisma");
        Carisma = Integer.parseInt(tx_stat);

        FOR = (Forza - 10) / 2;
        DES = (Destrezza - 10) / 2;
        COS = (Costituzione - 10) / 2;
        INT = (Intelligenza - 10) / 2;
        SAG = (Saggezza - 10) / 2;
        CAR = (Carisma - 10) / 2;

        caratteristiche = "Forza: " + Forza + "| " + FOR + "\n";
        caratteristiche += "Destrezza: " + Destrezza + "| " + DES + "\n";
        caratteristiche += "Costituzione: " + Costituzione + "| " + COS + "\n";
        caratteristiche += "Intelligenza: " + Intelligenza + "| " + INT + "\n";
        caratteristiche += "Saggezza: " + Saggezza + "| " + SAG + "\n";
        caratteristiche += "Carisma: " + Carisma + "| " + CAR + "\n";

        JOptionPane.showMessageDialog(null, caratteristiche);

    }

    static void raccoltaClasse() {

        String classe = JOptionPane.showInputDialog("Seleziona la classe: \n"
                + "Guerriero\n"
                + "Ladro\n"
                + "Mago\n"
                + "Barbaro\n"
                + "Chierico\n"
                + "Monaco\n"
                + "Paladino\n").toUpperCase();

        if (classe.equals("GUERRIERO")) {

            Guerriero();
        }

        if (classe.equals("MAGO")) {

            Mago();
        }
        if (classe.equals("LADRO")) {

            Ladro();
        }
        if (classe.equals("BARBARO")) {

            Barbaro();

        }
        if (classe.equals("CHIERICO")) {

            Chierico();
        }
        if (classe.equals("MONACO")) {

            Monaco();

        }
        if (classe.equals("PALADINO")) {

            Paladino();
        }
        //capagità speciali in base al lv (ciclo for con array)
        //calcolo ts = tempra , riflessi , volontà 
        //calcolo BAB
        //punti ferita = (1/2 dado vita * (lv-1)) + dado vita
    }

    static void Guerriero() {
        DV = 10;

        PF = (((1 / 2) * DV) * (Lv - 1)) + DV + (COS * Lv);

        int Tempra = Math.round(Lv / 2) + COS + 2; //9
        int Riflessi = Math.round(Lv / 3) + DES; //6
        int Volonta = Math.round(Lv / 3) + SAG; //6

        Ts = "Tempra: " + Tempra + "\n";
        Ts += "Riflessi: " + Riflessi + "\n";
        Ts += "Volontà: " + Volonta + "\n";

        JOptionPane.showMessageDialog(null, Ts);

        BAB = Lv;

        int txcm = FOR + BAB;
        int txcd = DES + BAB;

       
        String Guerriero = "-----" + name + "-----";
        Guerriero = "tiri salvezza: \n" + Ts;
        Guerriero += "bonus attacco base: " + BAB + "\n";
        Guerriero += "Bonus al colpire in mischia: " + txcm + "\n";
        Guerriero += "Bonus al colpire a distanza: " + txcd + "\n";
        Guerriero += "Punti Ferita: " + PF + "\n";

        JOptionPane.showMessageDialog(null, caratteristiche + " " + Guerriero);

        capacitaClasseW();

    }

    static void Mago() {
        DV = 4;

        PF = (((1 / 2) * DV) * (Lv - 1)) + DV + (COS * Lv);

        int Tempra = Math.round(Lv / 3) + COS; //9
        int Riflessi = Math.round(Lv / 3) + DES; //6
        int Volonta = Math.round(Lv / 2) + SAG + 2; //6

        Ts = "Tempra: " + Tempra + "\n";
        Ts += "Riflessi: " + Riflessi + "\n";
        Ts += "Volontà: " + Volonta + "\n";

        JOptionPane.showMessageDialog(null, Ts);

        BAB = Math.round(Lv / 2);

        int txcm = tiro_colpireM(FOR, BAB);
        int txcd = tiro_colpireD(DES, BAB);

        String Mago = "-----" + name + "-----";
        Mago += "tiri salvezza: \n" + Ts;
        Mago += "bonus attacco base: " + BAB + "\n";
        Mago += "Bonus al colpire in mischia: " + txcm + "\n";
        Mago += "Bonus al colpire a distanza: " + txcd + "\n";
        Mago += "Punti Ferita: " + PF + "\n";

        JOptionPane.showMessageDialog(null, caratteristiche + " " + Mago);
        
        capacitaClasseM();
    }

    static void Ladro() {
        DV = 6;

        PF = (((1 / 2) * DV) * (Lv - 1)) + DV + (COS * Lv);

        int Tempra = Math.round(Lv / 3) + COS; //9
        int Riflessi = Math.round(Lv / 2) + DES + 2; //6
        int Volonta = Math.round(Lv / 3) + SAG; //6

        Ts = "Tempra: " + Tempra + "\n";
        Ts += "Riflessi: " + Riflessi + "\n";
        Ts += "Volontà: " + Volonta + "\n";

        JOptionPane.showMessageDialog(null, Ts);

        BAB = Math.round(Lv / 4) * 3;

        int txcm = tiro_colpireM(FOR, BAB);
        int txcd = tiro_colpireD(DES, BAB);
        
        String Ladro = "-----" + name + "-----";
        Ladro += "tiri salvezza: \n" + Ts;
        Ladro += "bonus attacco base: " + BAB + "\n";
        Ladro += "Bonus al colpire in mischia: " + txcm + "\n";
        Ladro += "Bonus al colpire a distanza: " + txcd + "\n";
        Ladro += "Punti Ferita: " + PF + "\n";

        JOptionPane.showMessageDialog(null, caratteristiche + " " + Ladro);
        
        capacitaClasseR();
    }

    static void Barbaro() {
        DV = 12;

        PF = (((1 / 2) * DV) * (Lv - 1)) + DV + (COS * Lv);

        int Tempra = Math.round(Lv / 2) + COS + 2; //9
        int Riflessi = Math.round(Lv / 3) + DES; //6
        int Volonta = Math.round(Lv / 3) + SAG; //6

        Ts = "Tempra: " + Tempra + "\n";
        Ts += "Riflessi: " + Riflessi + "\n";
        Ts += "Volontà: " + Volonta + "\n";

        JOptionPane.showMessageDialog(null, Ts);

        BAB = Math.round(Lv / 4) * 3;

        int txcm = tiro_colpireM(FOR, BAB);
        int txcd = tiro_colpireD(DES, BAB);
        
        String Barbaro = "-----" + name + "-----";
        Barbaro += "tiri salvezza: \n" + Ts;
        Barbaro += "bonus attacco base: " + BAB + "\n";
        Barbaro += "Bonus al colpire in mischia: " + txcm + "\n";
        Barbaro += "Bonus al colpire a distanza: " + txcd + "\n";
        Barbaro += "Punti Ferita: " + PF + "\n";

        JOptionPane.showMessageDialog(null, caratteristiche + " " + Barbaro);
    }

    static void Chierico() {

        DV = 8;

        PF = (((1 / 2) * DV) * (Lv - 1)) + DV + (COS * Lv);

        int Tempra = Math.round(Lv / 2) + COS + 2; //9
        int Riflessi = Math.round(Lv / 3) + DES; //6
        int Volonta = Math.round(Lv / 2) + SAG + 2; //6

        Ts = "Tempra: " + Tempra + "\n";
        Ts += "Riflessi: " + Riflessi + "\n";
        Ts += "Volontà: " + Volonta + "\n";

        JOptionPane.showMessageDialog(null, Ts);

        BAB = Math.round(Lv / 4) * 3;

        int txcm = tiro_colpireM(FOR, BAB);
        int txcd = tiro_colpireD(DES, BAB);
        
        String Chierico = "-----" + name + "-----";
         Chierico += "tiri salvezza: \n" + Ts;
        Chierico += "bonus attacco base: " + BAB + "\n";
        Chierico += "Bonus al colpire in mischia: " + txcm + "\n";
        Chierico += "Bonus al colpire a distanza: " + txcd + "\n";
        Chierico += "Punti Ferita: " + PF + "\n";

        JOptionPane.showMessageDialog(null, caratteristiche + " " + Chierico);

        capacitaClasseC();

    }

    static void Druido() {

        DV = 8;

        PF = (((1 / 2) * DV) * (Lv - 1)) + DV + (COS * Lv);

        int Tempra = Math.round(Lv / 2) + COS + 2; //9
        int Riflessi = Math.round(Lv / 3) + DES; //6
        int Volonta = Math.round(Lv / 2) + SAG + 2; //6

        Ts = "Tempra: " + Tempra + "\n";
        Ts += "Riflessi: " + Riflessi + "\n";
        Ts += "Volontà: " + Volonta + "\n";

        JOptionPane.showMessageDialog(null, Ts);

        BAB = Math.round(Lv / 4) * 3;

        int txcm = tiro_colpireM(FOR, BAB);
        int txcd = tiro_colpireD(DES, BAB);
        
        String Druido = "-----" + name + "-----";
         Druido += "tiri salvezza: \n" + Ts;
        Druido += "bonus attacco base: " + BAB + "\n";
        Druido += "Bonus al colpire in mischia: " + txcm + "\n";
        Druido += "Bonus al colpire a distanza: " + txcd + "\n";
        Druido += "Punti Ferita: " + PF + "\n";

        JOptionPane.showMessageDialog(null, caratteristiche + " " + Druido);

    }

    static void Monaco() {

        DV = 8;

        PF = (((1 / 2) * DV) * (Lv - 1)) + DV + (COS * Lv);

        int Tempra = Math.round(Lv / 2) + COS + 2; //9
        int Riflessi = Math.round(Lv / 2) + DES + 2; //6
        int Volonta = Math.round(Lv / 2) + SAG + 2; //6

        Ts = "Tempra: " + Tempra + "\n";
        Ts += "Riflessi: " + Riflessi + "\n";
        Ts += "Volontà: " + Volonta + "\n";

        JOptionPane.showMessageDialog(null, Ts);

        BAB = Math.round(Lv / 4) * 3;

        int txcm = tiro_colpireM(FOR, BAB);
        int txcd = tiro_colpireD(DES, BAB);
        
        String Monaco = "-----" + name + "-----";
         Monaco = "tiri salvezza: \n" + Ts;
        Monaco += "bonus attacco base: " + BAB + "\n";
        Monaco += "Bonus al colpire in mischia: " + txcm + "\n";
        Monaco += "Bonus al colpire a distanza: " + txcd + "\n";
        Monaco += "Punti Ferita: " + PF + "\n";

        JOptionPane.showMessageDialog(null, caratteristiche + " " + Monaco);

    }

    static void Paladino() {

        DV = 10;

        PF = (((1 / 2) * DV) * (Lv - 1)) + DV + (COS * Lv);

        int Tempra = Math.round(Lv / 2) + COS + 2; //9
        int Riflessi = Math.round(Lv / 3) + DES; //6
        int Volonta = Math.round(Lv / 3) + SAG; //6

        Ts = "Tempra: " + Tempra + "\n";
        Ts += "Riflessi: " + Riflessi + "\n";
        Ts += "Volontà: " + Volonta + "\n";

        JOptionPane.showMessageDialog(null, Ts);

        BAB = Lv;

        int txcm = tiro_colpireM(FOR, BAB);
        int txcd = tiro_colpireD(DES, BAB);
        
        String Paladino = "-----" + name + "-----";
        Paladino = "tiri salvezza: \n" + Ts;
        Paladino += "bonus attacco base: " + BAB + "\n";
        Paladino += "Bonus al colpire in mischia: " + txcm + "\n";
        Paladino += "Bonus al colpire a distanza: " + txcd + "\n";
        Paladino += "Punti Ferita: " + PF + "\n";

        JOptionPane.showMessageDialog(null, caratteristiche + " " + Paladino);

    }

    static int tiro_colpireM(int FOR, int BAB) {

        int risultato;

        risultato = FOR + BAB;

        return risultato;
    }

    static int tiro_colpireD(int DES, int BAB) {

        int risultato;

        risultato = DES + BAB;

        return risultato;

    }

    static void capacitaClasseW() {

        capacita = "";
        capacita1 = "lv1 talento bonus\n";
        capacita2 = "lv2 talento bonus\n";
        capacita3 = "\n";
        capacita4 = "lv4 talento bonus\n";
        capacita5 = "\n";
        capacita6 = "lv6 talento bonus\n";
        capacita7 = "\n";
        capacita8 = "lv8 talento bonus\n";
        capacita9 = "\n";
        capacita10 = "lv10 talento bonus\n";
        capacita11 = "\n";
        capacita12 = "lv12 talento bonus\n";
        capacita13 = "\n";
        capacita14 = "lv14 talento bonus\n";
        capacita15 = "\n";
        capacita16 = "lv16 talento bonus\n";
        capacita17 = "\n";
        capacita18 = "lv18 talento bonus\n";
        capacita19 = "\n";
        capacita20 = "lv20 talento bonus\n";
        //ad ogni scelta possibile aggiungo la somma di quelle precedenti
        String[] capacita_classe = new String[21];
        capacita_classe[0] = capacita;
        capacita_classe[1] = capacita1 + capacita_classe[0];
        capacita_classe[2] = capacita2 + capacita_classe[1];
        capacita_classe[3] = capacita3 + capacita_classe[2];
        capacita_classe[4] = capacita4 + capacita_classe[3];
        capacita_classe[5] = capacita5 + capacita_classe[4];
        capacita_classe[6] = capacita6 + capacita_classe[5];
        capacita_classe[7] = capacita7 + capacita_classe[6];
        capacita_classe[8] = capacita8 + capacita_classe[7];
        capacita_classe[9] = capacita9 + capacita_classe[8];
        capacita_classe[10] = capacita10 + capacita_classe[9];
        capacita_classe[11] = capacita11 + capacita_classe[10];
        capacita_classe[12] = capacita12 + capacita_classe[11];
        capacita_classe[13] = capacita13 + capacita_classe[12];
        capacita_classe[14] = capacita14 + capacita_classe[13];
        capacita_classe[15] = capacita15 + capacita_classe[14];
        capacita_classe[16] = capacita16 + capacita_classe[15];
        capacita_classe[17] = capacita17 + capacita_classe[16];
        capacita_classe[18] = capacita18 + capacita_classe[17];
        capacita_classe[19] = capacita19 + capacita_classe[18];
        capacita_classe[20] = capacita20 + capacita_classe[19];
        //creo la selezione di input tra cui scegliere
        String[] livello = new String[20];
        livello[0] = "1";
        livello[1] = "2";
        livello[2] = "3";
        livello[3] = "4";
        livello[4] = "5";
        livello[5] = "6";
        livello[6] = "7";
        livello[7] = "8";
        livello[8] = "9";
        livello[9] = "10";
        livello[10] = "11";
        livello[11] = "12";
        livello[12] = "13";
        livello[13] = "14";
        livello[14] = "15";
        livello[15] = "16";
        livello[16] = "17";
        livello[17] = "18";
        livello[18] = "19";
        livello[19] = "20";
        //inserisco le capacità del guerriero

        //devo selezionare il dato corrispondente al lv immesso, il ciclo while deve andare avanti finchè la variabile Lv non è uguale a capacita_classe[Lv]
        //cerco in livello[] la posizione di Lv
        JOptionPane.showMessageDialog(null, caratteristiche + " " + Guerriero + " " + capacita_classe[Lv]);

    }

    static void capacitaClasseM() {

        capacita = "";
        capacita1 = "Tucchetti, Scuola di specializzazione\n";
        capacita2 = "\n";
        capacita3 = "\n";
        capacita4 = "\n";
        capacita5 = "lv 5 talento Bonus\n";
        capacita6 = "\n";
        capacita7 = "\n";
        capacita8 = "\n";
        capacita9 = "\n";
        capacita10 = "lv10 talento bonus\n";
        capacita11 = "\n";
        capacita12 = "\n";
        capacita13 = "\n";
        capacita14 = "\n";
        capacita15 = "lv 15 talento bonus\n";
        capacita16 = "\n";
        capacita17 = "\n";
        capacita18 = "\n";
        capacita19 = "\n";
        capacita20 = "lv20 talento bonus\n";
        //ad ogni scelta possibile aggiungo la somma di quelle precedenti
        String[] capacita_classe = new String[21];
        capacita_classe[0] = capacita;
        capacita_classe[1] = capacita1 + capacita_classe[0];
        capacita_classe[2] = capacita2 + capacita_classe[1];
        capacita_classe[3] = capacita3 + capacita_classe[2];
        capacita_classe[4] = capacita4 + capacita_classe[3];
        capacita_classe[5] = capacita5 + capacita_classe[4];
        capacita_classe[6] = capacita6 + capacita_classe[5];
        capacita_classe[7] = capacita7 + capacita_classe[6];
        capacita_classe[8] = capacita8 + capacita_classe[7];
        capacita_classe[9] = capacita9 + capacita_classe[8];
        capacita_classe[10] = capacita10 + capacita_classe[9];
        capacita_classe[11] = capacita11 + capacita_classe[10];
        capacita_classe[12] = capacita12 + capacita_classe[11];
        capacita_classe[13] = capacita13 + capacita_classe[12];
        capacita_classe[14] = capacita14 + capacita_classe[13];
        capacita_classe[15] = capacita15 + capacita_classe[14];
        capacita_classe[16] = capacita16 + capacita_classe[15];
        capacita_classe[17] = capacita17 + capacita_classe[16];
        capacita_classe[18] = capacita18 + capacita_classe[17];
        capacita_classe[19] = capacita19 + capacita_classe[18];
        capacita_classe[20] = capacita20 + capacita_classe[19];
        //creo la selezione di input tra cui scegliere
        String[] livello = new String[20];
        livello[0] = "1";
        livello[1] = "2";
        livello[2] = "3";
        livello[3] = "4";
        livello[4] = "5";
        livello[5] = "6";
        livello[6] = "7";
        livello[7] = "8";
        livello[8] = "9";
        livello[9] = "10";
        livello[10] = "11";
        livello[11] = "12";
        livello[12] = "13";
        livello[13] = "14";
        livello[14] = "15";
        livello[15] = "16";
        livello[16] = "17";
        livello[17] = "18";
        livello[18] = "19";
        livello[19] = "20";
        //inserisco le capacità del guerriero

        //devo selezionare il dato corrispondente al lv immesso, il ciclo while deve andare avanti finchè la variabile Lv non è uguale a capacita_classe[Lv]
        //cerco in livello[] la posizione di Lv
        JOptionPane.showMessageDialog(null, caratteristiche + " " + Mago + " " + capacita_classe[Lv]);

    }

    static void capacitaClasseR() {

        capacita = "";
        capacita1 = "Attacco furtivo +1d6\n";
        capacita2 = " \n";
        capacita3 = "Attacco furtivo +2d6\n";
        capacita4 = "\n";
        capacita5 = "Attacco furtivo +3d6\n";
        capacita6 = "\n";
        capacita7 = "Attacco furtivo +4d6\n";
        capacita8 = "\n";
        capacita9 = "Attacco furtivo +5d6\n";
        capacita10 = "\n";
        capacita11 = "Attacco furtivo +6d6\n";
        capacita12 = "\n";
        capacita13 = "Attacco furtivo +7d6\n";
        capacita14 = "\n";
        capacita15 = "Attacco furtivo +8d6\n";
        capacita16 = "\n";
        capacita17 = "Attacco furtivo +9d6\n";
        capacita18 = "\n";
        capacita19 = "Attacco furtivo +10d6\n";
        capacita20 = "\n";
        //ad ogni scelta possibile aggiungo la somma di quelle precedenti
        String[] capacita_classe = new String[21];
        capacita_classe[0] = capacita;
        capacita_classe[1] = capacita1 + capacita_classe[0];
        capacita_classe[2] = capacita2 + capacita_classe[1];
        capacita_classe[3] = capacita3 + capacita_classe[2];
        capacita_classe[4] = capacita4 + capacita_classe[3];
        capacita_classe[5] = capacita5 + capacita_classe[4];
        capacita_classe[6] = capacita6 + capacita_classe[5];
        capacita_classe[7] = capacita7 + capacita_classe[6];
        capacita_classe[8] = capacita8 + capacita_classe[7];
        capacita_classe[9] = capacita9 + capacita_classe[8];
        capacita_classe[10] = capacita10 + capacita_classe[9];
        capacita_classe[11] = capacita11 + capacita_classe[10];
        capacita_classe[12] = capacita12 + capacita_classe[11];
        capacita_classe[13] = capacita13 + capacita_classe[12];
        capacita_classe[14] = capacita14 + capacita_classe[13];
        capacita_classe[15] = capacita15 + capacita_classe[14];
        capacita_classe[16] = capacita16 + capacita_classe[15];
        capacita_classe[17] = capacita17 + capacita_classe[16];
        capacita_classe[18] = capacita18 + capacita_classe[17];
        capacita_classe[19] = capacita19 + capacita_classe[18];
        capacita_classe[20] = capacita20 + capacita_classe[19];
        //creo la selezione di input tra cui scegliere
        String[] livello = new String[20];
        livello[0] = "1";
        livello[1] = "2";
        livello[2] = "3";
        livello[3] = "4";
        livello[4] = "5";
        livello[5] = "6";
        livello[6] = "7";
        livello[7] = "8";
        livello[8] = "9";
        livello[9] = "10";
        livello[10] = "11";
        livello[11] = "12";
        livello[12] = "13";
        livello[13] = "14";
        livello[14] = "15";
        livello[15] = "16";
        livello[16] = "17";
        livello[17] = "18";
        livello[18] = "19";
        livello[19] = "20";
        //inserisco le capacità del guerriero

        //devo selezionare il dato corrispondente al lv immesso, il ciclo while deve andare avanti finchè la variabile Lv non è uguale a capacita_classe[Lv]
        //cerco in livello[] la posizione di Lv
        JOptionPane.showMessageDialog(null, caratteristiche + " " + Guerriero + " " + capacita_classe[Lv]);

    }

    static void capacitaClasseB() {

        capacita = "";
        capacita1 = "\n";
        capacita2 = "lv2 talento bonus\n";
        capacita3 = "\n";
        capacita4 = "lv4 talento bonus\n";
        capacita5 = "\n";
        capacita6 = "lv6 talento bonus\n";
        capacita7 = "\n";
        capacita8 = "lv8 talento bonus\n";
        capacita9 = "\n";
        capacita10 = "lv10 talento bonus\n";
        capacita11 = "\n";
        capacita12 = "lv12 talento bonus\n";
        capacita13 = "\n";
        capacita14 = "lv14 talento bonus\n";
        capacita15 = "\n";
        capacita16 = "lv16 talento bonus\n";
        capacita17 = "\n";
        capacita18 = "lv18 talento bonus\n";
        capacita19 = "\n";
        capacita20 = "lv20 talento bonus\n";
        //ad ogni scelta possibile aggiungo la somma di quelle precedenti
        String[] capacita_classe = new String[21];
        capacita_classe[0] = capacita;
        capacita_classe[1] = capacita1 + capacita_classe[0];
        capacita_classe[2] = capacita2 + capacita_classe[1];
        capacita_classe[3] = capacita3 + capacita_classe[2];
        capacita_classe[4] = capacita4 + capacita_classe[3];
        capacita_classe[5] = capacita5 + capacita_classe[4];
        capacita_classe[6] = capacita6 + capacita_classe[5];
        capacita_classe[7] = capacita7 + capacita_classe[6];
        capacita_classe[8] = capacita8 + capacita_classe[7];
        capacita_classe[9] = capacita9 + capacita_classe[8];
        capacita_classe[10] = capacita10 + capacita_classe[9];
        capacita_classe[11] = capacita11 + capacita_classe[10];
        capacita_classe[12] = capacita12 + capacita_classe[11];
        capacita_classe[13] = capacita13 + capacita_classe[12];
        capacita_classe[14] = capacita14 + capacita_classe[13];
        capacita_classe[15] = capacita15 + capacita_classe[14];
        capacita_classe[16] = capacita16 + capacita_classe[15];
        capacita_classe[17] = capacita17 + capacita_classe[16];
        capacita_classe[18] = capacita18 + capacita_classe[17];
        capacita_classe[19] = capacita19 + capacita_classe[18];
        capacita_classe[20] = capacita20 + capacita_classe[19];
        //creo la selezione di input tra cui scegliere
        String[] livello = new String[20];
        livello[0] = "1";
        livello[1] = "2";
        livello[2] = "3";
        livello[3] = "4";
        livello[4] = "5";
        livello[5] = "6";
        livello[6] = "7";
        livello[7] = "8";
        livello[8] = "9";
        livello[9] = "10";
        livello[10] = "11";
        livello[11] = "12";
        livello[12] = "13";
        livello[13] = "14";
        livello[14] = "15";
        livello[15] = "16";
        livello[16] = "17";
        livello[17] = "18";
        livello[18] = "19";
        livello[19] = "20";
        //inserisco le capacità del guerriero

        //devo selezionare il dato corrispondente al lv immesso, il ciclo while deve andare avanti finchè la variabile Lv non è uguale a capacita_classe[Lv]
        //cerco in livello[] la posizione di Lv
        JOptionPane.showMessageDialog(null, caratteristiche + " " + Guerriero + " " + capacita_classe[Lv]);

    }

    static void capacitaClasseC() {

        capacita = "";
        capacita1 = "Orazioni, Scacciare/intimorire non morti, Dominio \n";
        capacita2 = "\n";
        capacita3 = "\n";
        capacita4 = "\n";
        capacita5 = "\n";
        capacita6 = "\n";
        capacita7 = "\n";
        capacita8 = "\n";
        capacita9 = "\n";
        capacita10 = "\n";
        capacita11 = "\n";
        capacita12 = "\n";
        capacita13 = "\n";
        capacita14 = "\n";
        capacita15 = "\n";
        capacita16 = "\n";
        capacita17 = "\n";
        capacita18 = "\n";
        capacita19 = "\n";
        capacita20 = "\n";
        //ad ogni scelta possibile aggiungo la somma di quelle precedenti
        String[] capacita_classe = new String[21];
        capacita_classe[0] = capacita;
        capacita_classe[1] = capacita1 + capacita_classe[0];
        capacita_classe[2] = capacita2 + capacita_classe[1];
        capacita_classe[3] = capacita3 + capacita_classe[2];
        capacita_classe[4] = capacita4 + capacita_classe[3];
        capacita_classe[5] = capacita5 + capacita_classe[4];
        capacita_classe[6] = capacita6 + capacita_classe[5];
        capacita_classe[7] = capacita7 + capacita_classe[6];
        capacita_classe[8] = capacita8 + capacita_classe[7];
        capacita_classe[9] = capacita9 + capacita_classe[8];
        capacita_classe[10] = capacita10 + capacita_classe[9];
        capacita_classe[11] = capacita11 + capacita_classe[10];
        capacita_classe[12] = capacita12 + capacita_classe[11];
        capacita_classe[13] = capacita13 + capacita_classe[12];
        capacita_classe[14] = capacita14 + capacita_classe[13];
        capacita_classe[15] = capacita15 + capacita_classe[14];
        capacita_classe[16] = capacita16 + capacita_classe[15];
        capacita_classe[17] = capacita17 + capacita_classe[16];
        capacita_classe[18] = capacita18 + capacita_classe[17];
        capacita_classe[19] = capacita19 + capacita_classe[18];
        capacita_classe[20] = capacita20 + capacita_classe[19];
        //creo la selezione di input tra cui scegliere
        String[] livello = new String[20];
        livello[0] = "1";
        livello[1] = "2";
        livello[2] = "3";
        livello[3] = "4";
        livello[4] = "5";
        livello[5] = "6";
        livello[6] = "7";
        livello[7] = "8";
        livello[8] = "9";
        livello[9] = "10";
        livello[10] = "11";
        livello[11] = "12";
        livello[12] = "13";
        livello[13] = "14";
        livello[14] = "15";
        livello[15] = "16";
        livello[16] = "17";
        livello[17] = "18";
        livello[18] = "19";
        livello[19] = "20";
        //inserisco le capacità del guerriero

        //devo selezionare il dato corrispondente al lv immesso, il ciclo while deve andare avanti finchè la variabile Lv non è uguale a capacita_classe[Lv]
        //cerco in livello[] la posizione di Lv
        JOptionPane.showMessageDialog(null, caratteristiche + " " + Guerriero + " " + capacita_classe[Lv]);

    }

    static void capacitaClasseD() {

        capacita = "";
        capacita1 = "lv1 talento bonus\n";
        capacita2 = "lv2 talento bonus\n";
        capacita3 = "\n";
        capacita4 = "lv4 talento bonus\n";
        capacita5 = "\n";
        capacita6 = "lv6 talento bonus\n";
        capacita7 = "\n";
        capacita8 = "lv8 talento bonus\n";
        capacita9 = "\n";
        capacita10 = "lv10 talento bonus\n";
        capacita11 = "\n";
        capacita12 = "lv12 talento bonus\n";
        capacita13 = "\n";
        capacita14 = "lv14 talento bonus\n";
        capacita15 = "\n";
        capacita16 = "lv16 talento bonus\n";
        capacita17 = "\n";
        capacita18 = "lv18 talento bonus\n";
        capacita19 = "\n";
        capacita20 = "lv20 talento bonus\n";
        //ad ogni scelta possibile aggiungo la somma di quelle precedenti
        String[] capacita_classe = new String[21];
        capacita_classe[0] = capacita;
        capacita_classe[1] = capacita1 + capacita_classe[0];
        capacita_classe[2] = capacita2 + capacita_classe[1];
        capacita_classe[3] = capacita3 + capacita_classe[2];
        capacita_classe[4] = capacita4 + capacita_classe[3];
        capacita_classe[5] = capacita5 + capacita_classe[4];
        capacita_classe[6] = capacita6 + capacita_classe[5];
        capacita_classe[7] = capacita7 + capacita_classe[6];
        capacita_classe[8] = capacita8 + capacita_classe[7];
        capacita_classe[9] = capacita9 + capacita_classe[8];
        capacita_classe[10] = capacita10 + capacita_classe[9];
        capacita_classe[11] = capacita11 + capacita_classe[10];
        capacita_classe[12] = capacita12 + capacita_classe[11];
        capacita_classe[13] = capacita13 + capacita_classe[12];
        capacita_classe[14] = capacita14 + capacita_classe[13];
        capacita_classe[15] = capacita15 + capacita_classe[14];
        capacita_classe[16] = capacita16 + capacita_classe[15];
        capacita_classe[17] = capacita17 + capacita_classe[16];
        capacita_classe[18] = capacita18 + capacita_classe[17];
        capacita_classe[19] = capacita19 + capacita_classe[18];
        capacita_classe[20] = capacita20 + capacita_classe[19];
        //creo la selezione di input tra cui scegliere
        String[] livello = new String[20];
        livello[0] = "1";
        livello[1] = "2";
        livello[2] = "3";
        livello[3] = "4";
        livello[4] = "5";
        livello[5] = "6";
        livello[6] = "7";
        livello[7] = "8";
        livello[8] = "9";
        livello[9] = "10";
        livello[10] = "11";
        livello[11] = "12";
        livello[12] = "13";
        livello[13] = "14";
        livello[14] = "15";
        livello[15] = "16";
        livello[16] = "17";
        livello[17] = "18";
        livello[18] = "19";
        livello[19] = "20";
        //inserisco le capacità del guerriero

        //devo selezionare il dato corrispondente al lv immesso, il ciclo while deve andare avanti finchè la variabile Lv non è uguale a capacita_classe[Lv]
        //cerco in livello[] la posizione di Lv
        JOptionPane.showMessageDialog(null, caratteristiche + " " + Guerriero + " " + capacita_classe[Lv]);

    }

    static void capacitaClasseMon() {

        capacita = "";
        capacita1 = "lv1 talento bonus\n";
        capacita2 = "lv2 talento bonus\n";
        capacita3 = "\n";
        capacita4 = "lv4 talento bonus\n";
        capacita5 = "\n";
        capacita6 = "lv6 talento bonus\n";
        capacita7 = "\n";
        capacita8 = "lv8 talento bonus\n";
        capacita9 = "\n";
        capacita10 = "lv10 talento bonus\n";
        capacita11 = "\n";
        capacita12 = "lv12 talento bonus\n";
        capacita13 = "\n";
        capacita14 = "lv14 talento bonus\n";
        capacita15 = "\n";
        capacita16 = "lv16 talento bonus\n";
        capacita17 = "\n";
        capacita18 = "lv18 talento bonus\n";
        capacita19 = "\n";
        capacita20 = "lv20 talento bonus\n";
        //ad ogni scelta possibile aggiungo la somma di quelle precedenti
        String[] capacita_classe = new String[21];
        capacita_classe[0] = capacita;
        capacita_classe[1] = capacita1 + capacita_classe[0];
        capacita_classe[2] = capacita2 + capacita_classe[1];
        capacita_classe[3] = capacita3 + capacita_classe[2];
        capacita_classe[4] = capacita4 + capacita_classe[3];
        capacita_classe[5] = capacita5 + capacita_classe[4];
        capacita_classe[6] = capacita6 + capacita_classe[5];
        capacita_classe[7] = capacita7 + capacita_classe[6];
        capacita_classe[8] = capacita8 + capacita_classe[7];
        capacita_classe[9] = capacita9 + capacita_classe[8];
        capacita_classe[10] = capacita10 + capacita_classe[9];
        capacita_classe[11] = capacita11 + capacita_classe[10];
        capacita_classe[12] = capacita12 + capacita_classe[11];
        capacita_classe[13] = capacita13 + capacita_classe[12];
        capacita_classe[14] = capacita14 + capacita_classe[13];
        capacita_classe[15] = capacita15 + capacita_classe[14];
        capacita_classe[16] = capacita16 + capacita_classe[15];
        capacita_classe[17] = capacita17 + capacita_classe[16];
        capacita_classe[18] = capacita18 + capacita_classe[17];
        capacita_classe[19] = capacita19 + capacita_classe[18];
        capacita_classe[20] = capacita20 + capacita_classe[19];
        //creo la selezione di input tra cui scegliere
        String[] livello = new String[20];
        livello[0] = "1";
        livello[1] = "2";
        livello[2] = "3";
        livello[3] = "4";
        livello[4] = "5";
        livello[5] = "6";
        livello[6] = "7";
        livello[7] = "8";
        livello[8] = "9";
        livello[9] = "10";
        livello[10] = "11";
        livello[11] = "12";
        livello[12] = "13";
        livello[13] = "14";
        livello[14] = "15";
        livello[15] = "16";
        livello[16] = "17";
        livello[17] = "18";
        livello[18] = "19";
        livello[19] = "20";
        //inserisco le capacità del guerriero

        //devo selezionare il dato corrispondente al lv immesso, il ciclo while deve andare avanti finchè la variabile Lv non è uguale a capacita_classe[Lv]
        //cerco in livello[] la posizione di Lv
        JOptionPane.showMessageDialog(null, caratteristiche + " " + Guerriero + " " + capacita_classe[Lv]);

    }

    static void capacitaClasseP() {

        capacita = "";
        capacita1 = "lv1 Aura di bene, Individuazione del male,  punire il male 1\\g \n";
        capacita2 = "lv2 Grazia divina, Imposizione delle mani \n";
        capacita3 = "lv3 Aura di coraggio\n";
        capacita4 = "lv4 Scacciare non morti\n";
        capacita5 = "Cavalcatura \n";
        capacita6 = "lv6 talento bonus\n";
        capacita7 = "\n";
        capacita8 = "lv8 talento bonus\n";
        capacita9 = "\n";
        capacita10 = "lv10 talento bonus\n";
        capacita11 = "\n";
        capacita12 = "lv12 talento bonus\n";
        capacita13 = "\n";
        capacita14 = "lv14 talento bonus\n";
        capacita15 = "\n";
        capacita16 = "lv16 talento bonus\n";
        capacita17 = "\n";
        capacita18 = "lv18 talento bonus\n";
        capacita19 = "\n";
        capacita20 = "lv20 talento bonus\n";
        //ad ogni scelta possibile aggiungo la somma di quelle precedenti
        String[] capacita_classe = new String[21];
        capacita_classe[0] = capacita;
        capacita_classe[1] = capacita1 + capacita_classe[0];
        capacita_classe[2] = capacita2 + capacita_classe[1];
        capacita_classe[3] = capacita3 + capacita_classe[2];
        capacita_classe[4] = capacita4 + capacita_classe[3];
        capacita_classe[5] = capacita5 + capacita_classe[4];
        capacita_classe[6] = capacita6 + capacita_classe[5];
        capacita_classe[7] = capacita7 + capacita_classe[6];
        capacita_classe[8] = capacita8 + capacita_classe[7];
        capacita_classe[9] = capacita9 + capacita_classe[8];
        capacita_classe[10] = capacita10 + capacita_classe[9];
        capacita_classe[11] = capacita11 + capacita_classe[10];
        capacita_classe[12] = capacita12 + capacita_classe[11];
        capacita_classe[13] = capacita13 + capacita_classe[12];
        capacita_classe[14] = capacita14 + capacita_classe[13];
        capacita_classe[15] = capacita15 + capacita_classe[14];
        capacita_classe[16] = capacita16 + capacita_classe[15];
        capacita_classe[17] = capacita17 + capacita_classe[16];
        capacita_classe[18] = capacita18 + capacita_classe[17];
        capacita_classe[19] = capacita19 + capacita_classe[18];
        capacita_classe[20] = capacita20 + capacita_classe[19];
        //creo la selezione di input tra cui scegliere
        String[] livello = new String[20];
        livello[0] = "1";
        livello[1] = "2";
        livello[2] = "3";
        livello[3] = "4";
        livello[4] = "5";
        livello[5] = "6";
        livello[6] = "7";
        livello[7] = "8";
        livello[8] = "9";
        livello[9] = "10";
        livello[10] = "11";
        livello[11] = "12";
        livello[12] = "13";
        livello[13] = "14";
        livello[14] = "15";
        livello[15] = "16";
        livello[16] = "17";
        livello[17] = "18";
        livello[18] = "19";
        livello[19] = "20";
        //inserisco le capacità del guerriero

        //devo selezionare il dato corrispondente al lv immesso, il ciclo while deve andare avanti finchè la variabile Lv non è uguale a capacita_classe[Lv]
        //cerco in livello[] la posizione di Lv
        JOptionPane.showMessageDialog(null, caratteristiche + " " + Guerriero + " " + capacita_classe[Lv]);

    }
}
