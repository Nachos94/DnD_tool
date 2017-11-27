package dm_alphatool;

import javax.swing.JOptionPane;

/**
 *
 * @author Nachos
 */
public class DM_AlphaTool {

    /**
     * @param args the command line arguments
     */
    // TODO code application logic here
    public static void main(String[] args) {
        // TODO code application logic here


        /* nome del boss
    
    costituzione = input  
    destrezza= input
    
    COS = (costituzione -10 )/2 
    DV  = [input (scelto tra 4, 6 , 8, 10 , 12 )] * input numero di dadi vita]
    
    PF = [DV * input (scelto tra 4, 6 , 8, 10 , 12 )* 5/6]  + mod costituzione * DV
    
    armatura nat = input 
    DES = (destrezza - 10) /2
    armatura = input    
    taglia = input (scelto tra piccolissima + 8, minuta + 6, minuscola +4, piccola +1, media, grande -1, enorme -4, mastodontica -6, colossale -8)
    
    CA = Armatura nat + DES + Armatura + Taglia
    RD = input (scelto tra 5 o 10 o 15) 
    
    Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 
    
   
         */
        int costituzione;
        int destrezza;
        int tiro_colpire;
        int totale = 0;
        String tx_dv;
        int armatura_nat;
        int armatura;

        int RD;

        String name = JOptionPane.showInputDialog("nome del BOSS");

        String tx_numero = JOptionPane.showInputDialog("destrezza del BOSS");

        destrezza = Integer.parseInt(tx_numero);

        tx_numero = JOptionPane.showInputDialog("costituzione del BOSS");

        costituzione = Integer.parseInt(tx_numero);

        tx_numero = JOptionPane.showInputDialog("armatura del BOSS");

        armatura = Integer.parseInt(tx_numero);

        tx_numero = JOptionPane.showInputDialog("armatura naturale del BOSS");

        armatura_nat = Integer.parseInt(tx_numero);

        String taglia = JOptionPane.showInputDialog("taglia del BOSS\n" + "piccolissima\n"
                + "minuta\n" + "minuscola\n" + "piccola\n" + "media\n" + "grande\n" + "enorme\n" + "mastodontica\n" + "colossale\n");  //scelta della taglia 

        if (taglia.toUpperCase().equals("GRANDE")) {
            int DES = (destrezza - 10) / 2;
            int CA = (10 + armatura_nat + armatura - 1 + DES);

            tx_dv = JOptionPane.showInputDialog("Inserire dado vita del BOSS \n" + "d4\n d6\n d8\n d10\n d12"); //scelta del DV

            if (tx_dv.equals("d12")) {

                String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                int NDV = Integer.parseInt(tx_ndv);
                int COS = (costituzione - 10) / 2;
                int punti_ferita = 12 * 5 / 6 * NDV + COS * NDV;
                String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                if (tx_rd.equals("5")) {

                    RD = Integer.parseInt(tx_rd);

                    String report = "----" + name + "----\n";
                    report += "costituzione del boss: " + costituzione + "\n";
                    report += "destrezza del boss: " + destrezza + "\n ";
                    report += "CA del boss: " + CA + "\n";
                    report += "RD del boss: " + RD + "\n";
                    report += "punti ferita: " + punti_ferita + "\n";

                    JOptionPane.showMessageDialog(null, report);
                    for (int i = 0; i < punti_ferita; i++) {

                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                        tiro_colpire = Integer.parseInt(t_c);

                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                            int tiro_danni = Integer.parseInt(t_d);

                            int[] danni_totali;
                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                            danni_totali[i] = Integer.parseInt(t_d);

                            // int[] listaanticipi;
                            //sarà poi una variabile
                            int PF_rimanenti;

                            totale = totale + danni_totali[i];

                            PF_rimanenti = punti_ferita - totale;

                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                        }

                        if (totale >= punti_ferita) {

                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                    + "HAI UCCISO IL BOSS!!";

                            JOptionPane.showMessageDialog(null, report_vittoria);
                        }
                    }
                }
                if (tx_rd.equals("10")) {

                    RD = Integer.parseInt(tx_rd);

                    String report = "----" + name + "----\n";
                    report += "costituzione del boss: " + costituzione + "\n";
                    report += "destrezza del boss: " + destrezza + "\n ";
                    report += "CA del boss: " + CA + "\n";
                    report += "RD del boss: " + RD + "\n";
                    report += "punti ferita: " + punti_ferita + "\n";

                    JOptionPane.showMessageDialog(null, report);
                    for (int i = 0; i < punti_ferita; i++) {

                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                        tiro_colpire = Integer.parseInt(t_c);

                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                            int tiro_danni = Integer.parseInt(t_d);

                            int[] danni_totali;
                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                            danni_totali[i] = Integer.parseInt(t_d);

                            // int[] listaanticipi;
                            //sarà poi una variabile
                            int PF_rimanenti;

                            totale = totale + danni_totali[i];

                            PF_rimanenti = punti_ferita - totale;

                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                        }

                        if (totale >= punti_ferita) {

                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                    + "HAI UCCISO IL BOSS!!";

                            JOptionPane.showMessageDialog(null, report_vittoria);
                        }

                        /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                         */
                    }
                }
                if (tx_rd.equals("15")) {

                    RD = Integer.parseInt(tx_rd);

                    String report = "----" + name + "----\n";
                    report += "costituzione del boss: " + costituzione + "\n";
                    report += "destrezza del boss: " + destrezza + "\n ";
                    report += "CA del boss: " + CA + "\n";
                    report += "RD del boss: " + RD + "\n";
                    report += "punti ferita: " + punti_ferita + "\n";

                    JOptionPane.showMessageDialog(null, report);
                    for (int i = 0; i < punti_ferita; i++) {

                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                        tiro_colpire = Integer.parseInt(t_c);

                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                            int tiro_danni = Integer.parseInt(t_d);

                            int[] danni_totali;
                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                            danni_totali[i] = Integer.parseInt(t_d);

                            // int[] listaanticipi;
                            //sarà poi una variabile
                            int PF_rimanenti;

                            totale = totale + danni_totali[i];

                            PF_rimanenti = punti_ferita - totale;

                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                        }

                        if (totale >= punti_ferita) {

                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                    + "HAI UCCISO IL BOSS!!";

                            JOptionPane.showMessageDialog(null, report_vittoria);
                        }
                    }
                }
            }

            if (tx_dv.equals("d10")) {

                String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                int NDV = Integer.parseInt(tx_ndv);
                int COS = (costituzione - 10) / 2;
                int punti_ferita = 10 * 5 / 6 * NDV + COS * NDV;

                String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                if (tx_rd.equals("5")) {

                    RD = Integer.parseInt(tx_rd);

                    String report = "----" + name + "----\n";
                    report += "costituzione del boss: " + costituzione + "\n";
                    report += "destrezza del boss: " + destrezza + "\n ";
                    report += "CA del boss: " + CA + "\n";
                    report += "RD del boss: " + RD + "\n";
                    report += "punti ferita: " + punti_ferita + "\n";

                    JOptionPane.showMessageDialog(null, report);
                    for (int i = 0; i < punti_ferita; i++) {

                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                        tiro_colpire = Integer.parseInt(t_c);

                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                            int tiro_danni = Integer.parseInt(t_d);

                            int[] danni_totali;
                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                            danni_totali[i] = Integer.parseInt(t_d);

                            // int[] listaanticipi;
                            //sarà poi una variabile
                            int PF_rimanenti;

                            totale = totale + danni_totali[i];

                            PF_rimanenti = punti_ferita - totale;

                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                        }

                        if (totale >= punti_ferita) {

                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                    + "HAI UCCISO IL BOSS!!";

                            JOptionPane.showMessageDialog(null, report_vittoria);
                        }
                    }
                }
                if (tx_rd.equals("10")) {

                    RD = Integer.parseInt(tx_rd);

                    String report = "----" + name + "----\n";
                    report += "costituzione del boss: " + costituzione + "\n";
                    report += "destrezza del boss: " + destrezza + "\n ";
                    report += "CA del boss: " + CA + "\n";
                    report += "RD del boss: " + RD + "\n";
                    report += "punti ferita: " + punti_ferita + "\n";

                    JOptionPane.showMessageDialog(null, report);
                    for (int i = 0; i < punti_ferita; i++) {

                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                        tiro_colpire = Integer.parseInt(t_c);

                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                            int tiro_danni = Integer.parseInt(t_d);

                            int[] danni_totali;
                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                            danni_totali[i] = Integer.parseInt(t_d);

                            // int[] listaanticipi;
                            //sarà poi una variabile
                            int PF_rimanenti;

                            totale = totale + danni_totali[i];

                            PF_rimanenti = punti_ferita - totale;

                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                        }

                        if (totale >= punti_ferita) {

                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                    + "HAI UCCISO IL BOSS!!";

                            JOptionPane.showMessageDialog(null, report_vittoria);
                        }

                        /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                         */
                    }
                }
                if (tx_rd.equals("15")) {

                    RD = Integer.parseInt(tx_rd);

                    String report = "----" + name + "----\n";
                    report += "costituzione del boss: " + costituzione + "\n";
                    report += "destrezza del boss: " + destrezza + "\n ";
                    report += "CA del boss: " + CA + "\n";
                    report += "RD del boss: " + RD + "\n";
                    report += "punti ferita: " + punti_ferita + "\n";

                    JOptionPane.showMessageDialog(null, report);
                    for (int i = 0; i < punti_ferita; i++) {

                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                        tiro_colpire = Integer.parseInt(t_c);

                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                            int tiro_danni = Integer.parseInt(t_d);

                            int[] danni_totali;
                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                            danni_totali[i] = Integer.parseInt(t_d);

                            // int[] listaanticipi;
                            //sarà poi una variabile
                            int PF_rimanenti;

                            totale = totale + danni_totali[i];

                            PF_rimanenti = punti_ferita - totale;

                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                        }

                        if (totale >= punti_ferita) {

                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                    + "HAI UCCISO IL BOSS!!";

                            JOptionPane.showMessageDialog(null, report_vittoria);
                        }
                    }
                }
            }
            if (tx_dv.equals("d8")) {

                String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                int NDV = Integer.parseInt(tx_ndv);
                int COS = (costituzione - 10) / 2;
                int punti_ferita = 8 * 5 / 6 * NDV + COS * NDV;
                String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                if (tx_rd.equals("5")) {

                    RD = Integer.parseInt(tx_rd);

                    String report = "----" + name + "----\n";
                    report += "costituzione del boss: " + costituzione + "\n";
                    report += "destrezza del boss: " + destrezza + "\n ";
                    report += "CA del boss: " + CA + "\n";
                    report += "RD del boss: " + RD + "\n";
                    report += "punti ferita: " + punti_ferita + "\n";

                    JOptionPane.showMessageDialog(null, report);
                    for (int i = 0; i < punti_ferita; i++) {

                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                        tiro_colpire = Integer.parseInt(t_c);

                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                            int tiro_danni = Integer.parseInt(t_d);

                            int[] danni_totali;
                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                            danni_totali[i] = Integer.parseInt(t_d);

                            // int[] listaanticipi;
                            //sarà poi una variabile
                            int PF_rimanenti;

                            totale = totale + danni_totali[i];

                            PF_rimanenti = punti_ferita - totale;

                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                        }

                        if (totale >= punti_ferita) {

                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                    + "HAI UCCISO IL BOSS!!";

                            JOptionPane.showMessageDialog(null, report_vittoria);
                        }
                    }
                }
                if (tx_rd.equals("10")) {

                    RD = Integer.parseInt(tx_rd);

                    String report = "----" + name + "----\n";
                    report += "costituzione del boss: " + costituzione + "\n";
                    report += "destrezza del boss: " + destrezza + "\n ";
                    report += "CA del boss: " + CA + "\n";
                    report += "RD del boss: " + RD + "\n";
                    report += "punti ferita: " + punti_ferita + "\n";

                    JOptionPane.showMessageDialog(null, report);
                    for (int i = 0; i < punti_ferita; i++) {

                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                        tiro_colpire = Integer.parseInt(t_c);

                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                            int tiro_danni = Integer.parseInt(t_d);

                            int[] danni_totali;
                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                            danni_totali[i] = Integer.parseInt(t_d);

                            // int[] listaanticipi;
                            //sarà poi una variabile
                            int PF_rimanenti;

                            totale = totale + danni_totali[i];

                            PF_rimanenti = punti_ferita - totale;

                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                        }

                        if (totale >= punti_ferita) {

                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                    + "HAI UCCISO IL BOSS!!";

                            JOptionPane.showMessageDialog(null, report_vittoria);
                        }

                        /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                         */
                    }
                }
                if (tx_rd.equals("15")) {

                    RD = Integer.parseInt(tx_rd);

                    String report = "----" + name + "----\n";
                    report += "costituzione del boss: " + costituzione + "\n";
                    report += "destrezza del boss: " + destrezza + "\n ";
                    report += "CA del boss: " + CA + "\n";
                    report += "RD del boss: " + RD + "\n";
                    report += "punti ferita: " + punti_ferita + "\n";

                    JOptionPane.showMessageDialog(null, report);
                    for (int i = 0; i < punti_ferita; i++) {

                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                        tiro_colpire = Integer.parseInt(t_c);

                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                            int tiro_danni = Integer.parseInt(t_d);

                            int[] danni_totali;
                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                            danni_totali[i] = Integer.parseInt(t_d);

                            // int[] listaanticipi;
                            //sarà poi una variabile
                            int PF_rimanenti;

                            totale = totale + danni_totali[i];

                            PF_rimanenti = punti_ferita - totale;

                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                        }

                        if (totale >= punti_ferita) {

                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                    + "HAI UCCISO IL BOSS!!";

                            JOptionPane.showMessageDialog(null, report_vittoria);
                        }
                    }
                }
            }
        
        if (tx_dv.equals("d6")) {

            String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

            int NDV = Integer.parseInt(tx_ndv);
            int COS = (costituzione - 10) / 2;
            int punti_ferita = 6 * 5 / 6 * NDV + COS * NDV;

            String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

            if (tx_rd.equals("5")) {

                RD = Integer.parseInt(tx_rd);

                String report = "----" + name + "----\n";
                report += "costituzione del boss: " + costituzione + "\n";
                report += "destrezza del boss: " + destrezza + "\n ";
                report += "CA del boss: " + CA + "\n";
                report += "RD del boss: " + RD + "\n";
                report += "punti ferita: " + punti_ferita + "\n";

                JOptionPane.showMessageDialog(null, report);
                for (int i = 0; i < punti_ferita; i++) {

                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                    tiro_colpire = Integer.parseInt(t_c);

                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                        int tiro_danni = Integer.parseInt(t_d);

                        int[] danni_totali;
                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                        danni_totali[i] = Integer.parseInt(t_d);

                        // int[] listaanticipi;
                        //sarà poi una variabile
                        int PF_rimanenti;

                        totale = totale + danni_totali[i];

                        PF_rimanenti = punti_ferita - totale;

                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                    }

                    if (totale >= punti_ferita) {

                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                + "HAI UCCISO IL BOSS!!";

                        JOptionPane.showMessageDialog(null, report_vittoria);
                    }
                }
            }
            if (tx_rd.equals("10")) {

                RD = Integer.parseInt(tx_rd);

                String report = "----" + name + "----\n";
                report += "costituzione del boss: " + costituzione + "\n";
                report += "destrezza del boss: " + destrezza + "\n ";
                report += "CA del boss: " + CA + "\n";
                report += "RD del boss: " + RD + "\n";
                report += "punti ferita: " + punti_ferita + "\n";

                JOptionPane.showMessageDialog(null, report);
                for (int i = 0; i < punti_ferita; i++) {

                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                    tiro_colpire = Integer.parseInt(t_c);

                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                        int tiro_danni = Integer.parseInt(t_d);

                        int[] danni_totali;
                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                        danni_totali[i] = Integer.parseInt(t_d);

                        // int[] listaanticipi;
                        //sarà poi una variabile
                        int PF_rimanenti;

                        totale = totale + danni_totali[i];

                        PF_rimanenti = punti_ferita - totale;

                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                    }

                    if (totale >= punti_ferita) {

                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                + "HAI UCCISO IL BOSS!!";

                        JOptionPane.showMessageDialog(null, report_vittoria);
                    }

                    /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                     */
                }
            }
            if (tx_rd.equals("15")) {

                RD = Integer.parseInt(tx_rd);

                String report = "----" + name + "----\n";
                report += "costituzione del boss: " + costituzione + "\n";
                report += "destrezza del boss: " + destrezza + "\n ";
                report += "CA del boss: " + CA + "\n";
                report += "RD del boss: " + RD + "\n";
                report += "punti ferita: " + punti_ferita + "\n";

                JOptionPane.showMessageDialog(null, report);
                for (int i = 0; i < punti_ferita; i++) {

                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                    tiro_colpire = Integer.parseInt(t_c);

                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                        int tiro_danni = Integer.parseInt(t_d);

                        int[] danni_totali;
                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                        danni_totali[i] = Integer.parseInt(t_d);

                        // int[] listaanticipi;
                        //sarà poi una variabile
                        int PF_rimanenti;

                        totale = totale + danni_totali[i];

                        PF_rimanenti = punti_ferita - totale;

                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                    }

                    if (totale >= punti_ferita) {

                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                + "HAI UCCISO IL BOSS!!";

                        JOptionPane.showMessageDialog(null, report_vittoria);
                    }
                }
            }
        }

        if (tx_dv.equals("d4")) {

            String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

            int NDV = Integer.parseInt(tx_ndv);
            int COS = (costituzione - 10) / 2;
            int punti_ferita = 4 * 5 / 6 * NDV + COS * NDV;

            String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

            if (tx_rd.equals("5")) {

                RD = Integer.parseInt(tx_rd);

                String report = "----" + name + "----\n";
                report += "costituzione del boss: " + costituzione + "\n";
                report += "destrezza del boss: " + destrezza + "\n ";
                report += "CA del boss: " + CA + "\n";
                report += "RD del boss: " + RD + "\n";
                report += "punti ferita: " + punti_ferita + "\n";

                JOptionPane.showMessageDialog(null, report);
                for (int i = 0; i < punti_ferita; i++) {

                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                    tiro_colpire = Integer.parseInt(t_c);

                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                        int tiro_danni = Integer.parseInt(t_d);

                        int[] danni_totali;
                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                        danni_totali[i] = Integer.parseInt(t_d);

                        // int[] listaanticipi;
                        //sarà poi una variabile
                        int PF_rimanenti;

                        totale = totale + danni_totali[i];

                        PF_rimanenti = punti_ferita - totale;

                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                    }

                    if (totale >= punti_ferita) {

                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                + "HAI UCCISO IL BOSS!!";

                        JOptionPane.showMessageDialog(null, report_vittoria);
                    }
                }
            }
            if (tx_rd.equals("10")) {

                RD = Integer.parseInt(tx_rd);

                String report = "----" + name + "----\n";
                report += "costituzione del boss: " + costituzione + "\n";
                report += "destrezza del boss: " + destrezza + "\n ";
                report += "CA del boss: " + CA + "\n";
                report += "RD del boss: " + RD + "\n";
                report += "punti ferita: " + punti_ferita + "\n";

                JOptionPane.showMessageDialog(null, report);
                for (int i = 0; i < punti_ferita; i++) {

                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                    tiro_colpire = Integer.parseInt(t_c);

                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                        int tiro_danni = Integer.parseInt(t_d);

                        int[] danni_totali;
                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                        danni_totali[i] = Integer.parseInt(t_d);

                        // int[] listaanticipi;
                        //sarà poi una variabile
                        int PF_rimanenti;

                        totale = totale + danni_totali[i];

                        PF_rimanenti = punti_ferita - totale;

                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                    }

                    if (totale >= punti_ferita) {

                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                + "HAI UCCISO IL BOSS!!";

                        JOptionPane.showMessageDialog(null, report_vittoria);
                    }

                    /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                     */
                }
            }
            if (tx_rd.equals("15")) {

                RD = Integer.parseInt(tx_rd);

                String report = "----" + name + "----\n";
                report += "costituzione del boss: " + costituzione + "\n";
                report += "destrezza del boss: " + destrezza + "\n ";
                report += "CA del boss: " + CA + "\n";
                report += "RD del boss: " + RD + "\n";
                report += "punti ferita: " + punti_ferita + "\n";

                JOptionPane.showMessageDialog(null, report);
                for (int i = 0; i < punti_ferita; i++) {

                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                    tiro_colpire = Integer.parseInt(t_c);

                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                        int tiro_danni = Integer.parseInt(t_d);

                        int[] danni_totali;
                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                        danni_totali[i] = Integer.parseInt(t_d);

                        // int[] listaanticipi;
                        //sarà poi una variabile
                        int PF_rimanenti;

                        totale = totale + danni_totali[i];

                        PF_rimanenti = punti_ferita - totale;

                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                    }

                    if (totale >= punti_ferita) {

                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                + "HAI UCCISO IL BOSS!!";

                        JOptionPane.showMessageDialog(null, report_vittoria);
                    }
                }
            }
        } }

        if (taglia.toUpperCase().equals("ENORME")) {

            int DES = (destrezza - 10) / 2;
            int CA = (10 + armatura_nat + armatura - 4 + DES);
           
            
            tx_dv = JOptionPane.showInputDialog("Inserire dado vita del BOSS \n" + "d4\n d6\n d8\n d10\n d12"); //scelta del DV

            if (tx_dv.equals("d12")) {

                String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 
            int NDV = Integer.parseInt(tx_ndv);
            int COS = (costituzione - 10) / 2;
            int punti_ferita = 4 * 5 / 6 * NDV + COS * NDV;

                String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                if (tx_rd.equals("5")) {

                    RD = Integer.parseInt(tx_rd);

                    String report = "----" + name + "----\n";
                    report += "costituzione del boss: " + costituzione + "\n";
                    report += "destrezza del boss: " + destrezza + "\n ";
                    report += "CA del boss: " + CA + "\n";
                    report += "RD del boss: " + RD + "\n";
                    report += "punti ferita: " + punti_ferita + "\n";

                    JOptionPane.showMessageDialog(null, report);
                    for (int i = 0; i < punti_ferita; i++) {

                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                        tiro_colpire = Integer.parseInt(t_c);

                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                            int tiro_danni = Integer.parseInt(t_d);

                            int[] danni_totali;
                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                            danni_totali[i] = Integer.parseInt(t_d);

                            // int[] listaanticipi;
                            //sarà poi una variabile
                            int PF_rimanenti;

                            totale = totale + danni_totali[i];

                            PF_rimanenti = punti_ferita - totale;

                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                        }

                        if (totale >= punti_ferita) {

                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                    + "HAI UCCISO IL BOSS!!";

                            JOptionPane.showMessageDialog(null, report_vittoria);
                        }
                    }
                }
                if (tx_rd.equals("10")) {

                    RD = Integer.parseInt(tx_rd);

                    String report = "----" + name + "----\n";
                    report += "costituzione del boss: " + costituzione + "\n";
                    report += "destrezza del boss: " + destrezza + "\n ";
                    report += "CA del boss: " + CA + "\n";
                    report += "RD del boss: " + RD + "\n";
                    report += "punti ferita: " + punti_ferita + "\n";

                    JOptionPane.showMessageDialog(null, report);
                    for (int i = 0; i < punti_ferita; i++) {

                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                        tiro_colpire = Integer.parseInt(t_c);

                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                            int tiro_danni = Integer.parseInt(t_d);

                            int[] danni_totali;
                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                            danni_totali[i] = Integer.parseInt(t_d);

                            // int[] listaanticipi;
                            //sarà poi una variabile
                            int PF_rimanenti;

                            totale = totale + danni_totali[i];

                            PF_rimanenti = punti_ferita - totale;

                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                        }

                        if (totale >= punti_ferita) {

                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                    + "HAI UCCISO IL BOSS!!";

                            JOptionPane.showMessageDialog(null, report_vittoria);
                        }

                        /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                         */
                    }
                }
                if (tx_rd.equals("15")) {

                    RD = Integer.parseInt(tx_rd);

                    String report = "----" + name + "----\n";
                    report += "costituzione del boss: " + costituzione + "\n";
                    report += "destrezza del boss: " + destrezza + "\n ";
                    report += "CA del boss: " + CA + "\n";
                    report += "RD del boss: " + RD + "\n";
                    report += "punti ferita: " + punti_ferita + "\n";

                    JOptionPane.showMessageDialog(null, report);
                    for (int i = 0; i < punti_ferita; i++) {

                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                        tiro_colpire = Integer.parseInt(t_c);

                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                            int tiro_danni = Integer.parseInt(t_d);

                            int[] danni_totali;
                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                            danni_totali[i] = Integer.parseInt(t_d);

                            // int[] listaanticipi;
                            //sarà poi una variabile
                            int PF_rimanenti;

                            totale = totale + danni_totali[i];

                            PF_rimanenti = punti_ferita - totale;

                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                        }

                        if (totale >= punti_ferita) {

                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                    + "HAI UCCISO IL BOSS!!";

                            JOptionPane.showMessageDialog(null, report_vittoria);
                        }
                    }
                }  }

                if (tx_dv.equals("d10")) {

                    String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                    int NDV = Integer.parseInt(tx_ndv);
                    int COS = (costituzione - 10) / 2;
                    int punti_ferita = 10 * 5 / 6 * NDV + COS * NDV;

                    String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                    if (tx_rd.equals("5")) {

                        RD = Integer.parseInt(tx_rd);

                        String report = "----" + name + "----\n";
                        report += "costituzione del boss: " + costituzione + "\n";
                        report += "destrezza del boss: " + destrezza + "\n ";
                        report += "CA del boss: " + CA + "\n";
                        report += "RD del boss: " + RD + "\n";
                        report += "punti ferita: " + punti_ferita + "\n";

                        JOptionPane.showMessageDialog(null, report);
                        for (int i = 0; i < punti_ferita; i++) {

                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                            tiro_colpire = Integer.parseInt(t_c);

                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                int tiro_danni = Integer.parseInt(t_d);

                                int[] danni_totali;
                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                danni_totali[i] = Integer.parseInt(t_d);

                                // int[] listaanticipi;
                                //sarà poi una variabile
                                int PF_rimanenti;

                                totale = totale + danni_totali[i];

                                PF_rimanenti = punti_ferita - totale;

                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                            }

                            if (totale >= punti_ferita) {

                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                        + "HAI UCCISO IL BOSS!!";

                                JOptionPane.showMessageDialog(null, report_vittoria);
                            }
                        }
                    }
                    if (tx_rd.equals("10")) {

                        RD = Integer.parseInt(tx_rd);

                        String report = "----" + name + "----\n";
                        report += "costituzione del boss: " + costituzione + "\n";
                        report += "destrezza del boss: " + destrezza + "\n ";
                        report += "CA del boss: " + CA + "\n";
                        report += "RD del boss: " + RD + "\n";
                        report += "punti ferita: " + punti_ferita + "\n";

                        JOptionPane.showMessageDialog(null, report);
                        for (int i = 0; i < punti_ferita; i++) {

                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                            tiro_colpire = Integer.parseInt(t_c);

                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                int tiro_danni = Integer.parseInt(t_d);

                                int[] danni_totali;
                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                danni_totali[i] = Integer.parseInt(t_d);

                                // int[] listaanticipi;
                                //sarà poi una variabile
                                int PF_rimanenti;

                                totale = totale + danni_totali[i];

                                PF_rimanenti = punti_ferita - totale;

                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                            }

                            if (totale >= punti_ferita) {

                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                        + "HAI UCCISO IL BOSS!!";

                                JOptionPane.showMessageDialog(null, report_vittoria);
                            }

                            /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                             */
                        }
                    }
                    if (tx_rd.equals("15")) {

                        RD = Integer.parseInt(tx_rd);

                        String report = "----" + name + "----\n";
                        report += "costituzione del boss: " + costituzione + "\n";
                        report += "destrezza del boss: " + destrezza + "\n ";
                        report += "CA del boss: " + CA + "\n";
                        report += "RD del boss: " + RD + "\n";
                        report += "punti ferita: " + punti_ferita + "\n";

                        JOptionPane.showMessageDialog(null, report);
                        for (int i = 0; i < punti_ferita; i++) {

                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                            tiro_colpire = Integer.parseInt(t_c);

                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                int tiro_danni = Integer.parseInt(t_d);

                                int[] danni_totali;
                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                danni_totali[i] = Integer.parseInt(t_d);

                                // int[] listaanticipi;
                                //sarà poi una variabile
                                int PF_rimanenti;

                                totale = totale + danni_totali[i];

                                PF_rimanenti = punti_ferita - totale;

                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                            }

                            if (totale >= punti_ferita) {

                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                        + "HAI UCCISO IL BOSS!!";

                                JOptionPane.showMessageDialog(null, report_vittoria);
                            }
                        }
                    } }
                    if (tx_dv.equals("d8")) {

                        String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                        int NDV = Integer.parseInt(tx_ndv);
                        int COS = (costituzione - 10) / 2;
                        int punti_ferita = 8 * 5 / 6 * NDV + COS * NDV;

                        String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                        if (tx_rd.equals("5")) {

                            RD = Integer.parseInt(tx_rd);

                            String report = "----" + name + "----\n";
                            report += "costituzione del boss: " + costituzione + "\n";
                            report += "destrezza del boss: " + destrezza + "\n ";
                            report += "CA del boss: " + CA + "\n";
                            report += "RD del boss: " + RD + "\n";
                            report += "punti ferita: " + punti_ferita + "\n";

                            JOptionPane.showMessageDialog(null, report);
                            for (int i = 0; i < punti_ferita; i++) {

                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                tiro_colpire = Integer.parseInt(t_c);

                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                    int tiro_danni = Integer.parseInt(t_d);

                                    int[] danni_totali;
                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                    danni_totali[i] = Integer.parseInt(t_d);

                                    // int[] listaanticipi;
                                    //sarà poi una variabile
                                    int PF_rimanenti;

                                    totale = totale + danni_totali[i];

                                    PF_rimanenti = punti_ferita - totale;

                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                }

                                if (totale >= punti_ferita) {

                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                            + "HAI UCCISO IL BOSS!!";

                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                }
                            }
                        }
                        if (tx_rd.equals("10")) {

                            RD = Integer.parseInt(tx_rd);

                            String report = "----" + name + "----\n";
                            report += "costituzione del boss: " + costituzione + "\n";
                            report += "destrezza del boss: " + destrezza + "\n ";
                            report += "CA del boss: " + CA + "\n";
                            report += "RD del boss: " + RD + "\n";
                            report += "punti ferita: " + punti_ferita + "\n";

                            JOptionPane.showMessageDialog(null, report);
                            for (int i = 0; i < punti_ferita; i++) {

                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                tiro_colpire = Integer.parseInt(t_c);

                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                    int tiro_danni = Integer.parseInt(t_d);

                                    int[] danni_totali;
                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                    danni_totali[i] = Integer.parseInt(t_d);

                                    // int[] listaanticipi;
                                    //sarà poi una variabile
                                    int PF_rimanenti;

                                    totale = totale + danni_totali[i];

                                    PF_rimanenti = punti_ferita - totale;

                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                }

                                if (totale >= punti_ferita) {

                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                            + "HAI UCCISO IL BOSS!!";

                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                }

                                /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                 */
                            }
                        }
                        if (tx_rd.equals("15")) {

                            RD = Integer.parseInt(tx_rd);

                            String report = "----" + name + "----\n";
                            report += "costituzione del boss: " + costituzione + "\n";
                            report += "destrezza del boss: " + destrezza + "\n ";
                            report += "CA del boss: " + CA + "\n";
                            report += "RD del boss: " + RD + "\n";
                            report += "punti ferita: " + punti_ferita + "\n";

                            JOptionPane.showMessageDialog(null, report);
                            for (int i = 0; i < punti_ferita; i++) {

                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                tiro_colpire = Integer.parseInt(t_c);

                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                    int tiro_danni = Integer.parseInt(t_d);

                                    int[] danni_totali;
                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                    danni_totali[i] = Integer.parseInt(t_d);

                                    // int[] listaanticipi;
                                    //sarà poi una variabile
                                    int PF_rimanenti;

                                    totale = totale + danni_totali[i];

                                    PF_rimanenti = punti_ferita - totale;

                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                }

                                if (totale >= punti_ferita) {

                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                            + "HAI UCCISO IL BOSS!!";

                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                }
                            }
                        }
                    }
                
           
        if (tx_dv.equals("d6")) {

            String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

            int NDV = Integer.parseInt(tx_ndv);
            int COS = (costituzione - 10) / 2;
            int punti_ferita = 6 * 5 / 6 * NDV + COS * NDV;
            String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

            if (tx_rd.equals("5")) {

                RD = Integer.parseInt(tx_rd);

                String report = "----" + name + "----\n";
                report += "costituzione del boss: " + costituzione + "\n";
                report += "destrezza del boss: " + destrezza + "\n ";
                report += "CA del boss: " + CA + "\n";
                report += "RD del boss: " + RD + "\n";
                report += "punti ferita: " + punti_ferita + "\n";

                JOptionPane.showMessageDialog(null, report);
                for (int i = 0; i < punti_ferita; i++) {

                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                    tiro_colpire = Integer.parseInt(t_c);

                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                        int tiro_danni = Integer.parseInt(t_d);

                        int[] danni_totali;
                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                        danni_totali[i] = Integer.parseInt(t_d);

                        // int[] listaanticipi;
                        //sarà poi una variabile
                        int PF_rimanenti;

                        totale = totale + danni_totali[i];

                        PF_rimanenti = punti_ferita - totale;

                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                    }

                    if (totale >= punti_ferita) {

                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                + "HAI UCCISO IL BOSS!!";

                        JOptionPane.showMessageDialog(null, report_vittoria);
                    }
                }
            }
            if (tx_rd.equals("10")) {

                RD = Integer.parseInt(tx_rd);

                String report = "----" + name + "----\n";
                report += "costituzione del boss: " + costituzione + "\n";
                report += "destrezza del boss: " + destrezza + "\n ";
                report += "CA del boss: " + CA + "\n";
                report += "RD del boss: " + RD + "\n";
                report += "punti ferita: " + punti_ferita + "\n";

                JOptionPane.showMessageDialog(null, report);
                for (int i = 0; i < punti_ferita; i++) {

                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                    tiro_colpire = Integer.parseInt(t_c);

                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                        int tiro_danni = Integer.parseInt(t_d);

                        int[] danni_totali;
                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                        danni_totali[i] = Integer.parseInt(t_d);

                        // int[] listaanticipi;
                        //sarà poi una variabile
                        int PF_rimanenti;

                        totale = totale + danni_totali[i];

                        PF_rimanenti = punti_ferita - totale;

                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                    }

                    if (totale >= punti_ferita) {

                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                + "HAI UCCISO IL BOSS!!";

                        JOptionPane.showMessageDialog(null, report_vittoria);
                    }

                    /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                     */
                }
            }
            if (tx_rd.equals("15")) {

                RD = Integer.parseInt(tx_rd);

                String report = "----" + name + "----\n";
                report += "costituzione del boss: " + costituzione + "\n";
                report += "destrezza del boss: " + destrezza + "\n ";
                report += "CA del boss: " + CA + "\n";
                report += "RD del boss: " + RD + "\n";
                report += "punti ferita: " + punti_ferita + "\n";

                JOptionPane.showMessageDialog(null, report);
                for (int i = 0; i < punti_ferita; i++) {

                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                    tiro_colpire = Integer.parseInt(t_c);

                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                        int tiro_danni = Integer.parseInt(t_d);

                        int[] danni_totali;
                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                        danni_totali[i] = Integer.parseInt(t_d);

                        // int[] listaanticipi;
                        //sarà poi una variabile
                        int PF_rimanenti;

                        totale = totale + danni_totali[i];

                        PF_rimanenti = punti_ferita - totale;

                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                    }

                    if (totale >= punti_ferita) {

                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                + "HAI UCCISO IL BOSS!!";

                        JOptionPane.showMessageDialog(null, report_vittoria);
                    }
                }
            }}

            if (tx_dv.equals("d4")) {

                String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                int NDV = Integer.parseInt(tx_ndv);
                int COS = (costituzione - 10) / 2;
                int punti_ferita = 4 * 5 / 6 * NDV + COS * NDV;

                String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                if (tx_rd.equals("5")) {

                    RD = Integer.parseInt(tx_rd);

                    String report = "----" + name + "----\n";
                    report += "costituzione del boss: " + costituzione + "\n";
                    report += "destrezza del boss: " + destrezza + "\n ";
                    report += "CA del boss: " + CA + "\n";
                    report += "RD del boss: " + RD + "\n";
                    report += "punti ferita: " + punti_ferita + "\n";

                    JOptionPane.showMessageDialog(null, report);
                    for (int i = 0; i < punti_ferita; i++) {

                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                        tiro_colpire = Integer.parseInt(t_c);

                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                            int tiro_danni = Integer.parseInt(t_d);

                            int[] danni_totali;
                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                            danni_totali[i] = Integer.parseInt(t_d);

                            // int[] listaanticipi;
                            //sarà poi una variabile
                            int PF_rimanenti;

                            totale = totale + danni_totali[i];

                            PF_rimanenti = punti_ferita - totale;

                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                        }

                        if (totale >= punti_ferita) {

                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                    + "HAI UCCISO IL BOSS!!";

                            JOptionPane.showMessageDialog(null, report_vittoria);
                        }
                    }
                }
                if (tx_rd.equals("10")) {

                    RD = Integer.parseInt(tx_rd);

                    String report = "----" + name + "----\n";
                    report += "costituzione del boss: " + costituzione + "\n";
                    report += "destrezza del boss: " + destrezza + "\n ";
                    report += "CA del boss: " + CA + "\n";
                    report += "RD del boss: " + RD + "\n";
                    report += "punti ferita: " + punti_ferita + "\n";

                    JOptionPane.showMessageDialog(null, report);
                    for (int i = 0; i < punti_ferita; i++) {

                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                        tiro_colpire = Integer.parseInt(t_c);

                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                            int tiro_danni = Integer.parseInt(t_d);

                            int[] danni_totali;
                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                            danni_totali[i] = Integer.parseInt(t_d);

                            // int[] listaanticipi;
                            //sarà poi una variabile
                            int PF_rimanenti;

                            totale = totale + danni_totali[i];

                            PF_rimanenti = punti_ferita - totale;

                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                        }

                        if (totale >= punti_ferita) {

                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                    + "HAI UCCISO IL BOSS!!";

                            JOptionPane.showMessageDialog(null, report_vittoria);
                        }

                        /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                         */
                    }
                }
                if (tx_rd.equals("15")) {

                    RD = Integer.parseInt(tx_rd);

                    String report = "----" + name + "----\n";
                    report += "costituzione del boss: " + costituzione + "\n";
                    report += "destrezza del boss: " + destrezza + "\n ";
                    report += "CA del boss: " + CA + "\n";
                    report += "RD del boss: " + RD + "\n";
                    report += "punti ferita: " + punti_ferita + "\n";

                    JOptionPane.showMessageDialog(null, report);
                    for (int i = 0; i < punti_ferita; i++) {

                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                        tiro_colpire = Integer.parseInt(t_c);

                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                            int tiro_danni = Integer.parseInt(t_d);

                            int[] danni_totali;
                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                            danni_totali[i] = Integer.parseInt(t_d);

                            // int[] listaanticipi;
                            //sarà poi una variabile
                            int PF_rimanenti;

                            totale = totale + danni_totali[i];

                            PF_rimanenti = punti_ferita - totale;

                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                        }

                        if (totale >= punti_ferita) {

                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                    + "HAI UCCISO IL BOSS!!";

                            JOptionPane.showMessageDialog(null, report_vittoria);
                        }
                    }
                }
            }}
        
            if (taglia.toUpperCase().equals("MASTODONTICO")) {

                int DES = (destrezza - 10) / 2;
                int CA = (10 + armatura_nat + armatura - 6 + DES);

                tx_dv = JOptionPane.showInputDialog("Inserire dado vita del BOSS \n" + "d4\n d6\n d8\n d10\n d12"); //scelta del DV

                if (tx_dv.equals("d12")) {

                    String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                    int NDV = Integer.parseInt(tx_ndv);
                    int COS = (costituzione - 10) / 2;
                    int punti_ferita = 12 * 5 / 6 * NDV + COS * NDV;
                    String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                    if (tx_rd.equals("5")) {

                        RD = Integer.parseInt(tx_rd);

                        String report = "----" + name + "----\n";
                        report += "costituzione del boss: " + costituzione + "\n";
                        report += "destrezza del boss: " + destrezza + "\n ";
                        report += "CA del boss: " + CA + "\n";
                        report += "RD del boss: " + RD + "\n";
                        report += "punti ferita: " + punti_ferita + "\n";

                        JOptionPane.showMessageDialog(null, report);
                        for (int i = 0; i < punti_ferita; i++) {

                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                            tiro_colpire = Integer.parseInt(t_c);

                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                int tiro_danni = Integer.parseInt(t_d);

                                int[] danni_totali;
                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                danni_totali[i] = Integer.parseInt(t_d);

                                // int[] listaanticipi;
                                //sarà poi una variabile
                                int PF_rimanenti;

                                totale = totale + danni_totali[i];

                                PF_rimanenti = punti_ferita - totale;

                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                            }

                            if (totale >= punti_ferita) {

                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                        + "HAI UCCISO IL BOSS!!";

                                JOptionPane.showMessageDialog(null, report_vittoria);
                            }
                        }
                    }
                    if (tx_rd.equals("10")) {

                        RD = Integer.parseInt(tx_rd);

                        String report = "----" + name + "----\n";
                        report += "costituzione del boss: " + costituzione + "\n";
                        report += "destrezza del boss: " + destrezza + "\n ";
                        report += "CA del boss: " + CA + "\n";
                        report += "RD del boss: " + RD + "\n";
                        report += "punti ferita: " + punti_ferita + "\n";

                        JOptionPane.showMessageDialog(null, report);
                        for (int i = 0; i < punti_ferita; i++) {

                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                            tiro_colpire = Integer.parseInt(t_c);

                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                int tiro_danni = Integer.parseInt(t_d);

                                int[] danni_totali;
                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                danni_totali[i] = Integer.parseInt(t_d);

                                // int[] listaanticipi;
                                //sarà poi una variabile
                                int PF_rimanenti;

                                totale = totale + danni_totali[i];

                                PF_rimanenti = punti_ferita - totale;

                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                            }

                            if (totale >= punti_ferita) {

                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                        + "HAI UCCISO IL BOSS!!";

                                JOptionPane.showMessageDialog(null, report_vittoria);
                            }

                            /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                             */
                        }
                    }
                    if (tx_rd.equals("15")) {

                        RD = Integer.parseInt(tx_rd);

                        String report = "----" + name + "----\n";
                        report += "costituzione del boss: " + costituzione + "\n";
                        report += "destrezza del boss: " + destrezza + "\n ";
                        report += "CA del boss: " + CA + "\n";
                        report += "RD del boss: " + RD + "\n";
                        report += "punti ferita: " + punti_ferita + "\n";

                        JOptionPane.showMessageDialog(null, report);
                        for (int i = 0; i < punti_ferita; i++) {

                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                            tiro_colpire = Integer.parseInt(t_c);

                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                int tiro_danni = Integer.parseInt(t_d);

                                int[] danni_totali;
                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                danni_totali[i] = Integer.parseInt(t_d);

                                // int[] listaanticipi;
                                //sarà poi una variabile
                                int PF_rimanenti;

                                totale = totale + danni_totali[i];

                                PF_rimanenti = punti_ferita - totale;

                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                            }

                            if (totale >= punti_ferita) {

                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                        + "HAI UCCISO IL BOSS!!";

                                JOptionPane.showMessageDialog(null, report_vittoria);
                            }
                        }
                    }
                }
                    if (tx_dv.equals("d10")) {

                        String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                        int NDV = Integer.parseInt(tx_ndv);
                        int COS = (costituzione - 10) / 2;
                        int punti_ferita = 10 * 5 / 6 * NDV + COS * NDV;

                        String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                        if (tx_rd.equals("5")) {

                            RD = Integer.parseInt(tx_rd);

                            String report = "----" + name + "----\n";
                            report += "costituzione del boss: " + costituzione + "\n";
                            report += "destrezza del boss: " + destrezza + "\n ";
                            report += "CA del boss: " + CA + "\n";
                            report += "RD del boss: " + RD + "\n";
                            report += "punti ferita: " + punti_ferita + "\n";

                            JOptionPane.showMessageDialog(null, report);
                            for (int i = 0; i < punti_ferita; i++) {

                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                tiro_colpire = Integer.parseInt(t_c);

                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                    int tiro_danni = Integer.parseInt(t_d);

                                    int[] danni_totali;
                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                    danni_totali[i] = Integer.parseInt(t_d);

                                    // int[] listaanticipi;
                                    //sarà poi una variabile
                                    int PF_rimanenti;

                                    totale = totale + danni_totali[i];

                                    PF_rimanenti = punti_ferita - totale;

                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                }

                                if (totale >= punti_ferita) {

                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                            + "HAI UCCISO IL BOSS!!";

                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                }
                            }
                        }
                        if (tx_rd.equals("10")) {

                            RD = Integer.parseInt(tx_rd);

                            String report = "----" + name + "----\n";
                            report += "costituzione del boss: " + costituzione + "\n";
                            report += "destrezza del boss: " + destrezza + "\n ";
                            report += "CA del boss: " + CA + "\n";
                            report += "RD del boss: " + RD + "\n";
                            report += "punti ferita: " + punti_ferita + "\n";

                            JOptionPane.showMessageDialog(null, report);
                            for (int i = 0; i < punti_ferita; i++) {

                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                tiro_colpire = Integer.parseInt(t_c);

                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                    int tiro_danni = Integer.parseInt(t_d);

                                    int[] danni_totali;
                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                    danni_totali[i] = Integer.parseInt(t_d);

                                    // int[] listaanticipi;
                                    //sarà poi una variabile
                                    int PF_rimanenti;

                                    totale = totale + danni_totali[i];

                                    PF_rimanenti = punti_ferita - totale;

                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                }

                                if (totale >= punti_ferita) {

                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                            + "HAI UCCISO IL BOSS!!";

                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                }

                                /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                 */
                            }
                        }
                        if (tx_rd.equals("15")) {

                            RD = Integer.parseInt(tx_rd);

                            String report = "----" + name + "----\n";
                            report += "costituzione del boss: " + costituzione + "\n";
                            report += "destrezza del boss: " + destrezza + "\n ";
                            report += "CA del boss: " + CA + "\n";
                            report += "RD del boss: " + RD + "\n";
                            report += "punti ferita: " + punti_ferita + "\n";

                            JOptionPane.showMessageDialog(null, report);
                            for (int i = 0; i < punti_ferita; i++) {

                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                tiro_colpire = Integer.parseInt(t_c);

                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                    int tiro_danni = Integer.parseInt(t_d);

                                    int[] danni_totali;
                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                    danni_totali[i] = Integer.parseInt(t_d);

                                    // int[] listaanticipi;
                                    //sarà poi una variabile
                                    int PF_rimanenti;

                                    totale = totale + danni_totali[i];

                                    PF_rimanenti = punti_ferita - totale;

                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                }

                                if (totale >= punti_ferita) {

                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                            + "HAI UCCISO IL BOSS!!";

                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                }
                            }
                        }}
                        if (tx_dv.equals("d8")) {

                            String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                            int NDV = Integer.parseInt(tx_ndv);
                            int COS = (costituzione - 10) / 2;
                            int punti_ferita = 8 * 5 / 6 * NDV + COS * NDV;

                            String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                            if (tx_rd.equals("5")) {

                                RD = Integer.parseInt(tx_rd);

                                String report = "----" + name + "----\n";
                                report += "costituzione del boss: " + costituzione + "\n";
                                report += "destrezza del boss: " + destrezza + "\n ";
                                report += "CA del boss: " + CA + "\n";
                                report += "RD del boss: " + RD + "\n";
                                report += "punti ferita: " + punti_ferita + "\n";

                                JOptionPane.showMessageDialog(null, report);
                                for (int i = 0; i < punti_ferita; i++) {

                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                    tiro_colpire = Integer.parseInt(t_c);

                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                        int tiro_danni = Integer.parseInt(t_d);

                                        int[] danni_totali;
                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                        danni_totali[i] = Integer.parseInt(t_d);

                                        // int[] listaanticipi;
                                        //sarà poi una variabile
                                        int PF_rimanenti;

                                        totale = totale + danni_totali[i];

                                        PF_rimanenti = punti_ferita - totale;

                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                    }

                                    if (totale >= punti_ferita) {

                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                + "HAI UCCISO IL BOSS!!";

                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                    }
                                }
                            }
                            if (tx_rd.equals("10")) {

                                RD = Integer.parseInt(tx_rd);

                                String report = "----" + name + "----\n";
                                report += "costituzione del boss: " + costituzione + "\n";
                                report += "destrezza del boss: " + destrezza + "\n ";
                                report += "CA del boss: " + CA + "\n";
                                report += "RD del boss: " + RD + "\n";
                                report += "punti ferita: " + punti_ferita + "\n";

                                JOptionPane.showMessageDialog(null, report);
                                for (int i = 0; i < punti_ferita; i++) {

                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                    tiro_colpire = Integer.parseInt(t_c);

                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                        int tiro_danni = Integer.parseInt(t_d);

                                        int[] danni_totali;
                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                        danni_totali[i] = Integer.parseInt(t_d);

                                        // int[] listaanticipi;
                                        //sarà poi una variabile
                                        int PF_rimanenti;

                                        totale = totale + danni_totali[i];

                                        PF_rimanenti = punti_ferita - totale;

                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                    }

                                    if (totale >= punti_ferita) {

                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                + "HAI UCCISO IL BOSS!!";

                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                    }

                                    /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                     */
                                }
                            }
                            if (tx_rd.equals("15")) {

                                RD = Integer.parseInt(tx_rd);

                                String report = "----" + name + "----\n";
                                report += "costituzione del boss: " + costituzione + "\n";
                                report += "destrezza del boss: " + destrezza + "\n ";
                                report += "CA del boss: " + CA + "\n";
                                report += "RD del boss: " + RD + "\n";
                                report += "punti ferita: " + punti_ferita + "\n";

                                JOptionPane.showMessageDialog(null, report);
                                for (int i = 0; i < punti_ferita; i++) {

                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                    tiro_colpire = Integer.parseInt(t_c);

                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                        int tiro_danni = Integer.parseInt(t_d);

                                        int[] danni_totali;
                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                        danni_totali[i] = Integer.parseInt(t_d);

                                        // int[] listaanticipi;
                                        //sarà poi una variabile
                                        int PF_rimanenti;

                                        totale = totale + danni_totali[i];

                                        PF_rimanenti = punti_ferita - totale;

                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                    }

                                    if (totale >= punti_ferita) {

                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                + "HAI UCCISO IL BOSS!!";

                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                    }
                                }
                            }}
                            if (tx_dv.equals("d6")) {

                                String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                int NDV = Integer.parseInt(tx_ndv);
                                int COS = (costituzione - 10) / 2;
                                int punti_ferita = 6 * 5 / 6 * NDV + COS * NDV;
                                String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                if (tx_rd.equals("5")) {

                                    RD = Integer.parseInt(tx_rd);

                                    String report = "----" + name + "----\n";
                                    report += "costituzione del boss: " + costituzione + "\n";
                                    report += "destrezza del boss: " + destrezza + "\n ";
                                    report += "CA del boss: " + CA + "\n";
                                    report += "RD del boss: " + RD + "\n";
                                    report += "punti ferita: " + punti_ferita + "\n";

                                    JOptionPane.showMessageDialog(null, report);
                                    for (int i = 0; i < punti_ferita; i++) {

                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                        tiro_colpire = Integer.parseInt(t_c);

                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                            int tiro_danni = Integer.parseInt(t_d);

                                            int[] danni_totali;
                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                            danni_totali[i] = Integer.parseInt(t_d);

                                            // int[] listaanticipi;
                                            //sarà poi una variabile
                                            int PF_rimanenti;

                                            totale = totale + danni_totali[i];

                                            PF_rimanenti = punti_ferita - totale;

                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                        }

                                        if (totale >= punti_ferita) {

                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                    + "HAI UCCISO IL BOSS!!";

                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                        }
                                    }
                                }
                                if (tx_rd.equals("10")) {

                                    RD = Integer.parseInt(tx_rd);

                                    String report = "----" + name + "----\n";
                                    report += "costituzione del boss: " + costituzione + "\n";
                                    report += "destrezza del boss: " + destrezza + "\n ";
                                    report += "CA del boss: " + CA + "\n";
                                    report += "RD del boss: " + RD + "\n";
                                    report += "punti ferita: " + punti_ferita + "\n";

                                    JOptionPane.showMessageDialog(null, report);
                                    for (int i = 0; i < punti_ferita; i++) {

                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                        tiro_colpire = Integer.parseInt(t_c);

                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                            int tiro_danni = Integer.parseInt(t_d);

                                            int[] danni_totali;
                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                            danni_totali[i] = Integer.parseInt(t_d);

                                            // int[] listaanticipi;
                                            //sarà poi una variabile
                                            int PF_rimanenti;

                                            totale = totale + danni_totali[i];

                                            PF_rimanenti = punti_ferita - totale;

                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                        }

                                        if (totale >= punti_ferita) {

                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                    + "HAI UCCISO IL BOSS!!";

                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                        }

                                        /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                         */
                                    }
                                }
                                if (tx_rd.equals("15")) {

                                    RD = Integer.parseInt(tx_rd);

                                    String report = "----" + name + "----\n";
                                    report += "costituzione del boss: " + costituzione + "\n";
                                    report += "destrezza del boss: " + destrezza + "\n ";
                                    report += "CA del boss: " + CA + "\n";
                                    report += "RD del boss: " + RD + "\n";
                                    report += "punti ferita: " + punti_ferita + "\n";

                                    JOptionPane.showMessageDialog(null, report);
                                    for (int i = 0; i < punti_ferita; i++) {

                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                        tiro_colpire = Integer.parseInt(t_c);

                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                            int tiro_danni = Integer.parseInt(t_d);

                                            int[] danni_totali;
                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                            danni_totali[i] = Integer.parseInt(t_d);

                                            // int[] listaanticipi;
                                            //sarà poi una variabile
                                            int PF_rimanenti;

                                            totale = totale + danni_totali[i];

                                            PF_rimanenti = punti_ferita - totale;

                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                        }

                                        if (totale >= punti_ferita) {

                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                    + "HAI UCCISO IL BOSS!!";

                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                        }
                                    }
                                }
                            }
                                if (tx_dv.equals("d4")) {

                                    String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                    int NDV = Integer.parseInt(tx_ndv);
                                    int COS = (costituzione - 10) / 2;
                                    int punti_ferita = 4 * 5 / 6 * NDV + COS * NDV;
                                    String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                    if (tx_rd.equals("5")) {

                                        RD = Integer.parseInt(tx_rd);

                                        String report = "----" + name + "----\n";
                                        report += "costituzione del boss: " + costituzione + "\n";
                                        report += "destrezza del boss: " + destrezza + "\n ";
                                        report += "CA del boss: " + CA + "\n";
                                        report += "RD del boss: " + RD + "\n";
                                        report += "punti ferita: " + punti_ferita + "\n";

                                        JOptionPane.showMessageDialog(null, report);
                                        for (int i = 0; i < punti_ferita; i++) {

                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                            tiro_colpire = Integer.parseInt(t_c);

                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                int tiro_danni = Integer.parseInt(t_d);

                                                int[] danni_totali;
                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                danni_totali[i] = Integer.parseInt(t_d);

                                                // int[] listaanticipi;
                                                //sarà poi una variabile
                                                int PF_rimanenti;

                                                totale = totale + danni_totali[i];

                                                PF_rimanenti = punti_ferita - totale;

                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                            }

                                            if (totale >= punti_ferita) {

                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                        + "HAI UCCISO IL BOSS!!";

                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                            }
                                        }
                                    }
                                    if (tx_rd.equals("10")) {

                                        RD = Integer.parseInt(tx_rd);

                                        String report = "----" + name + "----\n";
                                        report += "costituzione del boss: " + costituzione + "\n";
                                        report += "destrezza del boss: " + destrezza + "\n ";
                                        report += "CA del boss: " + CA + "\n";
                                        report += "RD del boss: " + RD + "\n";
                                        report += "punti ferita: " + punti_ferita + "\n";

                                        JOptionPane.showMessageDialog(null, report);
                                        for (int i = 0; i < punti_ferita; i++) {

                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                            tiro_colpire = Integer.parseInt(t_c);

                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                int tiro_danni = Integer.parseInt(t_d);

                                                int[] danni_totali;
                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                danni_totali[i] = Integer.parseInt(t_d);

                                                // int[] listaanticipi;
                                                //sarà poi una variabile
                                                int PF_rimanenti;

                                                totale = totale + danni_totali[i];

                                                PF_rimanenti = punti_ferita - totale;

                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                            }

                                            if (totale >= punti_ferita) {

                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                        + "HAI UCCISO IL BOSS!!";

                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                            }

                                            /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                             */
                                        }
                                    }
                                    if (tx_rd.equals("15")) {

                                        RD = Integer.parseInt(tx_rd);

                                        String report = "----" + name + "----\n";
                                        report += "costituzione del boss: " + costituzione + "\n";
                                        report += "destrezza del boss: " + destrezza + "\n ";
                                        report += "CA del boss: " + CA + "\n";
                                        report += "RD del boss: " + RD + "\n";
                                        report += "punti ferita: " + punti_ferita + "\n";

                                        JOptionPane.showMessageDialog(null, report);
                                        for (int i = 0; i < punti_ferita; i++) {

                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                            tiro_colpire = Integer.parseInt(t_c);

                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                int tiro_danni = Integer.parseInt(t_d);

                                                int[] danni_totali;
                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                danni_totali[i] = Integer.parseInt(t_d);

                                                // int[] listaanticipi;
                                                //sarà poi una variabile
                                                int PF_rimanenti;

                                                totale = totale + danni_totali[i];

                                                PF_rimanenti = punti_ferita - totale;

                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                            }

                                            if (totale >= punti_ferita) {

                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                        + "HAI UCCISO IL BOSS!!";

                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                            }
                                        }
                                    }
                                }
            }
                                if (taglia.toUpperCase().equals("COLOSSALE")) {

                                    int DES = (destrezza - 10) / 2;
                                    int CA = (10 + armatura_nat + armatura - 8 + DES);

                                    tx_dv = JOptionPane.showInputDialog("Inserire dado vita del BOSS \n" + "d4\n d6\n d8\n d10\n d12"); //scelta del DV

                                    if (tx_dv.equals("d12")) {

                                        String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                        int NDV = Integer.parseInt(tx_ndv);
                                        int COS = (costituzione - 10) / 2;
                                        int punti_ferita = 12 * 5 / 6 * NDV + COS * NDV;

                                        String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                        if (tx_rd.equals("5")) {

                                            RD = Integer.parseInt(tx_rd);

                                            String report = "----" + name + "----\n";
                                            report += "costituzione del boss: " + costituzione + "\n";
                                            report += "destrezza del boss: " + destrezza + "\n ";
                                            report += "CA del boss: " + CA + "\n";
                                            report += "RD del boss: " + RD + "\n";
                                            report += "punti ferita: " + punti_ferita + "\n";

                                            JOptionPane.showMessageDialog(null, report);
                                            for (int i = 0; i < punti_ferita; i++) {

                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                tiro_colpire = Integer.parseInt(t_c);

                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                    int tiro_danni = Integer.parseInt(t_d);

                                                    int[] danni_totali;
                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                    // int[] listaanticipi;
                                                    //sarà poi una variabile
                                                    int PF_rimanenti;

                                                    totale = totale + danni_totali[i];

                                                    PF_rimanenti = punti_ferita - totale;

                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                }

                                                if (totale >= punti_ferita) {

                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                            + "HAI UCCISO IL BOSS!!";

                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                }
                                            }
                                        }
                                        if (tx_rd.equals("10")) {

                                            RD = Integer.parseInt(tx_rd);

                                            String report = "----" + name + "----\n";
                                            report += "costituzione del boss: " + costituzione + "\n";
                                            report += "destrezza del boss: " + destrezza + "\n ";
                                            report += "CA del boss: " + CA + "\n";
                                            report += "RD del boss: " + RD + "\n";
                                            report += "punti ferita: " + punti_ferita + "\n";

                                            JOptionPane.showMessageDialog(null, report);
                                            for (int i = 0; i < punti_ferita; i++) {

                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                tiro_colpire = Integer.parseInt(t_c);

                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                    int tiro_danni = Integer.parseInt(t_d);

                                                    int[] danni_totali;
                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                    // int[] listaanticipi;
                                                    //sarà poi una variabile
                                                    int PF_rimanenti;

                                                    totale = totale + danni_totali[i];

                                                    PF_rimanenti = punti_ferita - totale;

                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                }

                                                if (totale >= punti_ferita) {

                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                            + "HAI UCCISO IL BOSS!!";

                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                }

                                                /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                 */
                                            }
                                        }
                                        if (tx_rd.equals("15")) {

                                            RD = Integer.parseInt(tx_rd);

                                            String report = "----" + name + "----\n";
                                            report += "costituzione del boss: " + costituzione + "\n";
                                            report += "destrezza del boss: " + destrezza + "\n ";
                                            report += "CA del boss: " + CA + "\n";
                                            report += "RD del boss: " + RD + "\n";
                                            report += "punti ferita: " + punti_ferita + "\n";

                                            JOptionPane.showMessageDialog(null, report);
                                            for (int i = 0; i < punti_ferita; i++) {

                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                tiro_colpire = Integer.parseInt(t_c);

                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                    int tiro_danni = Integer.parseInt(t_d);

                                                    int[] danni_totali;
                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                    // int[] listaanticipi;
                                                    //sarà poi una variabile
                                                    int PF_rimanenti;

                                                    totale = totale + danni_totali[i];

                                                    PF_rimanenti = punti_ferita - totale;

                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                }

                                                if (totale >= punti_ferita) {

                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                            + "HAI UCCISO IL BOSS!!";

                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                }
                                            }
                                        } }

                                        if (tx_dv.equals("d10")) {

                                            String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                            int NDV = Integer.parseInt(tx_ndv);
                                            int COS = (costituzione - 10) / 2;
                                            int punti_ferita = 10 * 5 / 6 * NDV + COS * NDV;

                                            String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                            if (tx_rd.equals("5")) {

                                                RD = Integer.parseInt(tx_rd);

                                                String report = "----" + name + "----\n";
                                                report += "costituzione del boss: " + costituzione + "\n";
                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                report += "CA del boss: " + CA + "\n";
                                                report += "RD del boss: " + RD + "\n";
                                                report += "punti ferita: " + punti_ferita + "\n";

                                                JOptionPane.showMessageDialog(null, report);
                                                for (int i = 0; i < punti_ferita; i++) {

                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                    tiro_colpire = Integer.parseInt(t_c);

                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                        int tiro_danni = Integer.parseInt(t_d);

                                                        int[] danni_totali;
                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                        // int[] listaanticipi;
                                                        //sarà poi una variabile
                                                        int PF_rimanenti;

                                                        totale = totale + danni_totali[i];

                                                        PF_rimanenti = punti_ferita - totale;

                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                    }

                                                    if (totale >= punti_ferita) {

                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                + "HAI UCCISO IL BOSS!!";

                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                    }
                                                }
                                            }
                                            if (tx_rd.equals("10")) {

                                                RD = Integer.parseInt(tx_rd);

                                                String report = "----" + name + "----\n";
                                                report += "costituzione del boss: " + costituzione + "\n";
                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                report += "CA del boss: " + CA + "\n";
                                                report += "RD del boss: " + RD + "\n";
                                                report += "punti ferita: " + punti_ferita + "\n";

                                                JOptionPane.showMessageDialog(null, report);
                                                for (int i = 0; i < punti_ferita; i++) {

                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                    tiro_colpire = Integer.parseInt(t_c);

                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                        int tiro_danni = Integer.parseInt(t_d);

                                                        int[] danni_totali;
                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                        // int[] listaanticipi;
                                                        //sarà poi una variabile
                                                        int PF_rimanenti;

                                                        totale = totale + danni_totali[i];

                                                        PF_rimanenti = punti_ferita - totale;

                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                    }

                                                    if (totale >= punti_ferita) {

                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                + "HAI UCCISO IL BOSS!!";

                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                    }

                                                    /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                     */
                                                }
                                            }
                                            if (tx_rd.equals("15")) {

                                                RD = Integer.parseInt(tx_rd);

                                                String report = "----" + name + "----\n";
                                                report += "costituzione del boss: " + costituzione + "\n";
                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                report += "CA del boss: " + CA + "\n";
                                                report += "RD del boss: " + RD + "\n";
                                                report += "punti ferita: " + punti_ferita + "\n";

                                                JOptionPane.showMessageDialog(null, report);
                                                for (int i = 0; i < punti_ferita; i++) {

                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                    tiro_colpire = Integer.parseInt(t_c);

                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                        int tiro_danni = Integer.parseInt(t_d);

                                                        int[] danni_totali;
                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                        // int[] listaanticipi;
                                                        //sarà poi una variabile
                                                        int PF_rimanenti;

                                                        totale = totale + danni_totali[i];

                                                        PF_rimanenti = punti_ferita - totale;

                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                    }

                                                    if (totale >= punti_ferita) {

                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                + "HAI UCCISO IL BOSS!!";

                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                    }
                                                }
                                            } }
                                            if (tx_dv.equals("d8")) {

                                                String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                int NDV = Integer.parseInt(tx_ndv);
                                                int COS = (costituzione - 10) / 2;
                                                int punti_ferita = 8 * 5 / 6 * NDV + COS * NDV;

                                                String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                if (tx_rd.equals("5")) {

                                                    RD = Integer.parseInt(tx_rd);

                                                    String report = "----" + name + "----\n";
                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                    report += "CA del boss: " + CA + "\n";
                                                    report += "RD del boss: " + RD + "\n";
                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                    JOptionPane.showMessageDialog(null, report);
                                                    for (int i = 0; i < punti_ferita; i++) {

                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                        tiro_colpire = Integer.parseInt(t_c);

                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                            int tiro_danni = Integer.parseInt(t_d);

                                                            int[] danni_totali;
                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                            // int[] listaanticipi;
                                                            //sarà poi una variabile
                                                            int PF_rimanenti;

                                                            totale = totale + danni_totali[i];

                                                            PF_rimanenti = punti_ferita - totale;

                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                        }

                                                        if (totale >= punti_ferita) {

                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                    + "HAI UCCISO IL BOSS!!";

                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                        }
                                                    }
                                                }
                                                if (tx_rd.equals("10")) {

                                                    RD = Integer.parseInt(tx_rd);

                                                    String report = "----" + name + "----\n";
                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                    report += "CA del boss: " + CA + "\n";
                                                    report += "RD del boss: " + RD + "\n";
                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                    JOptionPane.showMessageDialog(null, report);
                                                    for (int i = 0; i < punti_ferita; i++) {

                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                        tiro_colpire = Integer.parseInt(t_c);

                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                            int tiro_danni = Integer.parseInt(t_d);

                                                            int[] danni_totali;
                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                            // int[] listaanticipi;
                                                            //sarà poi una variabile
                                                            int PF_rimanenti;

                                                            totale = totale + danni_totali[i];

                                                            PF_rimanenti = punti_ferita - totale;

                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                        }

                                                        if (totale >= punti_ferita) {

                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                    + "HAI UCCISO IL BOSS!!";

                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                        }

                                                        /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                         */
                                                    }
                                                }
                                                if (tx_rd.equals("15")) {

                                                    RD = Integer.parseInt(tx_rd);

                                                    String report = "----" + name + "----\n";
                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                    report += "CA del boss: " + CA + "\n";
                                                    report += "RD del boss: " + RD + "\n";
                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                    JOptionPane.showMessageDialog(null, report);
                                                    for (int i = 0; i < punti_ferita; i++) {

                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                        tiro_colpire = Integer.parseInt(t_c);

                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                            int tiro_danni = Integer.parseInt(t_d);

                                                            int[] danni_totali;
                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                            // int[] listaanticipi;
                                                            //sarà poi una variabile
                                                            int PF_rimanenti;

                                                            totale = totale + danni_totali[i];

                                                            PF_rimanenti = punti_ferita - totale;

                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                        }

                                                        if (totale >= punti_ferita) {

                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                    + "HAI UCCISO IL BOSS!!";

                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                        }
                                                    }
                                                }}
                                                if (tx_dv.equals("d6")) {

                                                    String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                    int NDV = Integer.parseInt(tx_ndv);
                                                    int COS = (costituzione - 10) / 2;
                                                    int punti_ferita = 6 * 5 / 6 * NDV + COS * NDV;

                                                    String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                    if (tx_rd.equals("5")) {

                                                        RD = Integer.parseInt(tx_rd);

                                                        String report = "----" + name + "----\n";
                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                        report += "CA del boss: " + CA + "\n";
                                                        report += "RD del boss: " + RD + "\n";
                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                        JOptionPane.showMessageDialog(null, report);
                                                        for (int i = 0; i < punti_ferita; i++) {

                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                            tiro_colpire = Integer.parseInt(t_c);

                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                int[] danni_totali;
                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                // int[] listaanticipi;
                                                                //sarà poi una variabile
                                                                int PF_rimanenti;

                                                                totale = totale + danni_totali[i];

                                                                PF_rimanenti = punti_ferita - totale;

                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                            }

                                                            if (totale >= punti_ferita) {

                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                        + "HAI UCCISO IL BOSS!!";

                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                            }
                                                        }
                                                    }
                                                    if (tx_rd.equals("10")) {

                                                        RD = Integer.parseInt(tx_rd);

                                                        String report = "----" + name + "----\n";
                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                        report += "CA del boss: " + CA + "\n";
                                                        report += "RD del boss: " + RD + "\n";
                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                        JOptionPane.showMessageDialog(null, report);
                                                        for (int i = 0; i < punti_ferita; i++) {

                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                            tiro_colpire = Integer.parseInt(t_c);

                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                int[] danni_totali;
                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                // int[] listaanticipi;
                                                                //sarà poi una variabile
                                                                int PF_rimanenti;

                                                                totale = totale + danni_totali[i];

                                                                PF_rimanenti = punti_ferita - totale;

                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                            }

                                                            if (totale >= punti_ferita) {

                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                        + "HAI UCCISO IL BOSS!!";

                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                            }

                                                            /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                             */
                                                        }
                                                    }
                                                    if (tx_rd.equals("15")) {

                                                        RD = Integer.parseInt(tx_rd);

                                                        String report = "----" + name + "----\n";
                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                        report += "CA del boss: " + CA + "\n";
                                                        report += "RD del boss: " + RD + "\n";
                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                        JOptionPane.showMessageDialog(null, report);
                                                        for (int i = 0; i < punti_ferita; i++) {

                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                            tiro_colpire = Integer.parseInt(t_c);

                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                int[] danni_totali;
                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                // int[] listaanticipi;
                                                                //sarà poi una variabile
                                                                int PF_rimanenti;

                                                                totale = totale + danni_totali[i];

                                                                PF_rimanenti = punti_ferita - totale;

                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                            }

                                                            if (totale >= punti_ferita) {

                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                        + "HAI UCCISO IL BOSS!!";

                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                            }
                                                        }
                                                    }}
                                                    if (tx_dv.equals("d4")) {

                                                        String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                        int NDV = Integer.parseInt(tx_ndv);
                                                        int COS = (costituzione - 10) / 2;
                                                        int punti_ferita = 4 * 5 / 6 * NDV + COS * NDV;

                                                        String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                        if (tx_rd.equals("5")) {

                                                            RD = Integer.parseInt(tx_rd);

                                                            String report = "----" + name + "----\n";
                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                            report += "CA del boss: " + CA + "\n";
                                                            report += "RD del boss: " + RD + "\n";
                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                            JOptionPane.showMessageDialog(null, report);
                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                    int[] danni_totali;
                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                    // int[] listaanticipi;
                                                                    //sarà poi una variabile
                                                                    int PF_rimanenti;

                                                                    totale = totale + danni_totali[i];

                                                                    PF_rimanenti = punti_ferita - totale;

                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                }

                                                                if (totale >= punti_ferita) {

                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                            + "HAI UCCISO IL BOSS!!";

                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                }
                                                            }
                                                        }
                                                        if (tx_rd.equals("10")) {

                                                            RD = Integer.parseInt(tx_rd);

                                                            String report = "----" + name + "----\n";
                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                            report += "CA del boss: " + CA + "\n";
                                                            report += "RD del boss: " + RD + "\n";
                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                            JOptionPane.showMessageDialog(null, report);
                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                    int[] danni_totali;
                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                    // int[] listaanticipi;
                                                                    //sarà poi una variabile
                                                                    int PF_rimanenti;

                                                                    totale = totale + danni_totali[i];

                                                                    PF_rimanenti = punti_ferita - totale;

                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                }

                                                                if (totale >= punti_ferita) {

                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                            + "HAI UCCISO IL BOSS!!";

                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                }

                                                                /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                 */
                                                            }
                                                        }
                                                        if (tx_rd.equals("15")) {

                                                            RD = Integer.parseInt(tx_rd);

                                                            String report = "----" + name + "----\n";
                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                            report += "CA del boss: " + CA + "\n";
                                                            report += "RD del boss: " + RD + "\n";
                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                            JOptionPane.showMessageDialog(null, report);
                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                    int[] danni_totali;
                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                    // int[] listaanticipi;
                                                                    //sarà poi una variabile
                                                                    int PF_rimanenti;

                                                                    totale = totale + danni_totali[i];

                                                                    PF_rimanenti = punti_ferita - totale;

                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                }

                                                                if (totale >= punti_ferita) {

                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                            + "HAI UCCISO IL BOSS!!";

                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                }
                                                            }
                                                        }
                                                    } }

                                                    if (taglia.toUpperCase().equals("MEDIA")) {

                                                        int DES = (destrezza - 10) / 2;
                                                        int CA = (10 + armatura_nat + armatura - 0 + DES);

                                                        tx_dv = JOptionPane.showInputDialog("Inserire dado vita del BOSS \n" + "d4\n d6\n d8\n d10\n d12"); //scelta del DV

                                                        if (tx_dv.equals("d12")) {

                                                            String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                            int NDV = Integer.parseInt(tx_ndv);
                                                            int COS = (costituzione - 10) / 2;
                                                            int punti_ferita = 12 * 5 / 6 * NDV + COS * NDV;
                                                            String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                            if (tx_rd.equals("5")) {

                                                                RD = Integer.parseInt(tx_rd);

                                                                String report = "----" + name + "----\n";
                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                report += "CA del boss: " + CA + "\n";
                                                                report += "RD del boss: " + RD + "\n";
                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                JOptionPane.showMessageDialog(null, report);
                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                        int[] danni_totali;
                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                        // int[] listaanticipi;
                                                                        //sarà poi una variabile
                                                                        int PF_rimanenti;

                                                                        totale = totale + danni_totali[i];

                                                                        PF_rimanenti = punti_ferita - totale;

                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                    }

                                                                    if (totale >= punti_ferita) {

                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                + "HAI UCCISO IL BOSS!!";

                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                    }
                                                                }
                                                            }
                                                            if (tx_rd.equals("10")) {

                                                                RD = Integer.parseInt(tx_rd);

                                                                String report = "----" + name + "----\n";
                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                report += "CA del boss: " + CA + "\n";
                                                                report += "RD del boss: " + RD + "\n";
                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                JOptionPane.showMessageDialog(null, report);
                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                        int[] danni_totali;
                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                        // int[] listaanticipi;
                                                                        //sarà poi una variabile
                                                                        int PF_rimanenti;

                                                                        totale = totale + danni_totali[i];

                                                                        PF_rimanenti = punti_ferita - totale;

                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                    }

                                                                    if (totale >= punti_ferita) {

                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                + "HAI UCCISO IL BOSS!!";

                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                    }

                                                                    /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                     */
                                                                }
                                                            }
                                                            if (tx_rd.equals("15")) {

                                                                RD = Integer.parseInt(tx_rd);

                                                                String report = "----" + name + "----\n";
                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                report += "CA del boss: " + CA + "\n";
                                                                report += "RD del boss: " + RD + "\n";
                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                JOptionPane.showMessageDialog(null, report);
                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                        int[] danni_totali;
                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                        // int[] listaanticipi;
                                                                        //sarà poi una variabile
                                                                        int PF_rimanenti;

                                                                        totale = totale + danni_totali[i];

                                                                        PF_rimanenti = punti_ferita - totale;

                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                    }

                                                                    if (totale >= punti_ferita) {

                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                + "HAI UCCISO IL BOSS!!";

                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                    }
                                                                }
                                                            } }

                                                            if (tx_dv.equals("d10")) {

                                                                String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                int NDV = Integer.parseInt(tx_ndv);
                                                                int COS = (costituzione - 10) / 2;
                                                                int punti_ferita = 10 * 5 / 6 * NDV + COS * NDV;
                                                                String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                if (tx_rd.equals("5")) {

                                                                    RD = Integer.parseInt(tx_rd);

                                                                    String report = "----" + name + "----\n";
                                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                                    report += "CA del boss: " + CA + "\n";
                                                                    report += "RD del boss: " + RD + "\n";
                                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                                    JOptionPane.showMessageDialog(null, report);
                                                                    for (int i = 0; i < punti_ferita; i++) {

                                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                        tiro_colpire = Integer.parseInt(t_c);

                                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                            int tiro_danni = Integer.parseInt(t_d);

                                                                            int[] danni_totali;
                                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                                            // int[] listaanticipi;
                                                                            //sarà poi una variabile
                                                                            int PF_rimanenti;

                                                                            totale = totale + danni_totali[i];

                                                                            PF_rimanenti = punti_ferita - totale;

                                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                        }

                                                                        if (totale >= punti_ferita) {

                                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                    + "HAI UCCISO IL BOSS!!";

                                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                                        }
                                                                    }
                                                                }
                                                                if (tx_rd.equals("10")) {

                                                                    RD = Integer.parseInt(tx_rd);

                                                                    String report = "----" + name + "----\n";
                                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                                    report += "CA del boss: " + CA + "\n";
                                                                    report += "RD del boss: " + RD + "\n";
                                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                                    JOptionPane.showMessageDialog(null, report);
                                                                    for (int i = 0; i < punti_ferita; i++) {

                                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                        tiro_colpire = Integer.parseInt(t_c);

                                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                            int tiro_danni = Integer.parseInt(t_d);

                                                                            int[] danni_totali;
                                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                                            // int[] listaanticipi;
                                                                            //sarà poi una variabile
                                                                            int PF_rimanenti;

                                                                            totale = totale + danni_totali[i];

                                                                            PF_rimanenti = punti_ferita - totale;

                                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                        }

                                                                        if (totale >= punti_ferita) {

                                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                    + "HAI UCCISO IL BOSS!!";

                                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                                        }

                                                                        /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                         */
                                                                    }
                                                                }
                                                                if (tx_rd.equals("15")) {

                                                                    RD = Integer.parseInt(tx_rd);

                                                                    String report = "----" + name + "----\n";
                                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                                    report += "CA del boss: " + CA + "\n";
                                                                    report += "RD del boss: " + RD + "\n";
                                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                                    JOptionPane.showMessageDialog(null, report);
                                                                    for (int i = 0; i < punti_ferita; i++) {

                                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                        tiro_colpire = Integer.parseInt(t_c);

                                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                            int tiro_danni = Integer.parseInt(t_d);

                                                                            int[] danni_totali;
                                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                                            // int[] listaanticipi;
                                                                            //sarà poi una variabile
                                                                            int PF_rimanenti;

                                                                            totale = totale + danni_totali[i];

                                                                            PF_rimanenti = punti_ferita - totale;

                                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                        }

                                                                        if (totale >= punti_ferita) {

                                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                    + "HAI UCCISO IL BOSS!!";

                                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                                        }
                                                                    }
                                                                } }
                                                                if (tx_dv.equals("d8")) {

                                                                    String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                    int NDV = Integer.parseInt(tx_ndv);
                                                                    int COS = (costituzione - 10) / 2;
                                                                    int punti_ferita = 8 * 5 / 6 * NDV + COS * NDV;

                                                                    String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                    if (tx_rd.equals("5")) {

                                                                        RD = Integer.parseInt(tx_rd);

                                                                        String report = "----" + name + "----\n";
                                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                                        report += "CA del boss: " + CA + "\n";
                                                                        report += "RD del boss: " + RD + "\n";
                                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                                        JOptionPane.showMessageDialog(null, report);
                                                                        for (int i = 0; i < punti_ferita; i++) {

                                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                            tiro_colpire = Integer.parseInt(t_c);

                                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                                int[] danni_totali;
                                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                                // int[] listaanticipi;
                                                                                //sarà poi una variabile
                                                                                int PF_rimanenti;

                                                                                totale = totale + danni_totali[i];

                                                                                PF_rimanenti = punti_ferita - totale;

                                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                            }

                                                                            if (totale >= punti_ferita) {

                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                                            }
                                                                        }
                                                                    }
                                                                    if (tx_rd.equals("10")) {

                                                                        RD = Integer.parseInt(tx_rd);

                                                                        String report = "----" + name + "----\n";
                                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                                        report += "CA del boss: " + CA + "\n";
                                                                        report += "RD del boss: " + RD + "\n";
                                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                                        JOptionPane.showMessageDialog(null, report);
                                                                        for (int i = 0; i < punti_ferita; i++) {

                                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                            tiro_colpire = Integer.parseInt(t_c);

                                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                                int[] danni_totali;
                                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                                // int[] listaanticipi;
                                                                                //sarà poi una variabile
                                                                                int PF_rimanenti;

                                                                                totale = totale + danni_totali[i];

                                                                                PF_rimanenti = punti_ferita - totale;

                                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                            }

                                                                            if (totale >= punti_ferita) {

                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                                            }

                                                                            /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                             */
                                                                        }
                                                                    }
                                                                    if (tx_rd.equals("15")) {

                                                                        RD = Integer.parseInt(tx_rd);

                                                                        String report = "----" + name + "----\n";
                                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                                        report += "CA del boss: " + CA + "\n";
                                                                        report += "RD del boss: " + RD + "\n";
                                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                                        JOptionPane.showMessageDialog(null, report);
                                                                        for (int i = 0; i < punti_ferita; i++) {

                                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                            tiro_colpire = Integer.parseInt(t_c);

                                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                                int[] danni_totali;
                                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                                // int[] listaanticipi;
                                                                                //sarà poi una variabile
                                                                                int PF_rimanenti;

                                                                                totale = totale + danni_totali[i];

                                                                                PF_rimanenti = punti_ferita - totale;

                                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                            }

                                                                            if (totale >= punti_ferita) {

                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                                            }
                                                                        }
                                                                    } }
                                                                
                                                                    if (tx_dv.equals("d6")) {

                                                                        String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                        int NDV = Integer.parseInt(tx_ndv);
                                                                        int COS = (costituzione - 10) / 2;
                                                                        int punti_ferita = 6 * 5 / 6 * NDV + COS * NDV;

                                                                        String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                        if (tx_rd.equals("5")) {

                                                                            RD = Integer.parseInt(tx_rd);

                                                                            String report = "----" + name + "----\n";
                                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                                            report += "CA del boss: " + CA + "\n";
                                                                            report += "RD del boss: " + RD + "\n";
                                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                                            JOptionPane.showMessageDialog(null, report);
                                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                                    int[] danni_totali;
                                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                                    // int[] listaanticipi;
                                                                                    //sarà poi una variabile
                                                                                    int PF_rimanenti;

                                                                                    totale = totale + danni_totali[i];

                                                                                    PF_rimanenti = punti_ferita - totale;

                                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                }

                                                                                if (totale >= punti_ferita) {

                                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                            + "HAI UCCISO IL BOSS!!";

                                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                }
                                                                            }
                                                                        }
                                                                        if (tx_rd.equals("10")) {

                                                                            RD = Integer.parseInt(tx_rd);

                                                                            String report = "----" + name + "----\n";
                                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                                            report += "CA del boss: " + CA + "\n";
                                                                            report += "RD del boss: " + RD + "\n";
                                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                                            JOptionPane.showMessageDialog(null, report);
                                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                                    int[] danni_totali;
                                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                                    // int[] listaanticipi;
                                                                                    //sarà poi una variabile
                                                                                    int PF_rimanenti;

                                                                                    totale = totale + danni_totali[i];

                                                                                    PF_rimanenti = punti_ferita - totale;

                                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                }

                                                                                if (totale >= punti_ferita) {

                                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                            + "HAI UCCISO IL BOSS!!";

                                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                }

                                                                                /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                 */
                                                                            }
                                                                        }
                                                                        if (tx_rd.equals("15")) {

                                                                            RD = Integer.parseInt(tx_rd);

                                                                            String report = "----" + name + "----\n";
                                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                                            report += "CA del boss: " + CA + "\n";
                                                                            report += "RD del boss: " + RD + "\n";
                                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                                            JOptionPane.showMessageDialog(null, report);
                                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                                    int[] danni_totali;
                                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                                    // int[] listaanticipi;
                                                                                    //sarà poi una variabile
                                                                                    int PF_rimanenti;

                                                                                    totale = totale + danni_totali[i];

                                                                                    PF_rimanenti = punti_ferita - totale;

                                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                }

                                                                                if (totale >= punti_ferita) {

                                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                            + "HAI UCCISO IL BOSS!!";

                                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                }
                                                                            }
                                                                        } }

                                                                        if (tx_dv.equals("d4")) {

                                                                            String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                            int NDV = Integer.parseInt(tx_ndv);
                                                                            int COS = (costituzione - 10) / 2;
                                                                            int punti_ferita = 4 * 5 / 6 * NDV + COS * NDV;

                                                                            String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                            if (tx_rd.equals("5")) {

                                                                                RD = Integer.parseInt(tx_rd);

                                                                                String report = "----" + name + "----\n";
                                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                                report += "CA del boss: " + CA + "\n";
                                                                                report += "RD del boss: " + RD + "\n";
                                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                                JOptionPane.showMessageDialog(null, report);
                                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                                        int[] danni_totali;
                                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                                        // int[] listaanticipi;
                                                                                        //sarà poi una variabile
                                                                                        int PF_rimanenti;

                                                                                        totale = totale + danni_totali[i];

                                                                                        PF_rimanenti = punti_ferita - totale;

                                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                    }

                                                                                    if (totale >= punti_ferita) {

                                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                + "HAI UCCISO IL BOSS!!";

                                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                    }
                                                                                }
                                                                            }
                                                                            if (tx_rd.equals("10")) {

                                                                                RD = Integer.parseInt(tx_rd);

                                                                                String report = "----" + name + "----\n";
                                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                                report += "CA del boss: " + CA + "\n";
                                                                                report += "RD del boss: " + RD + "\n";
                                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                                JOptionPane.showMessageDialog(null, report);
                                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                                        int[] danni_totali;
                                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                                        // int[] listaanticipi;
                                                                                        //sarà poi una variabile
                                                                                        int PF_rimanenti;

                                                                                        totale = totale + danni_totali[i];

                                                                                        PF_rimanenti = punti_ferita - totale;

                                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                    }

                                                                                    if (totale >= punti_ferita) {

                                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                + "HAI UCCISO IL BOSS!!";

                                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                    }

                                                                                    /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                     */
                                                                                }
                                                                            }
                                                                            if (tx_rd.equals("15")) {

                                                                                RD = Integer.parseInt(tx_rd);

                                                                                String report = "----" + name + "----\n";
                                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                                report += "CA del boss: " + CA + "\n";
                                                                                report += "RD del boss: " + RD + "\n";
                                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                                JOptionPane.showMessageDialog(null, report);
                                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                                        int[] danni_totali;
                                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                                        // int[] listaanticipi;
                                                                                        //sarà poi una variabile
                                                                                        int PF_rimanenti;

                                                                                        totale = totale + danni_totali[i];

                                                                                        PF_rimanenti = punti_ferita - totale;

                                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                    }

                                                                                    if (totale >= punti_ferita) {

                                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                + "HAI UCCISO IL BOSS!!";

                                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                    }
                                                                                }
                                                                            }
                                                                        } } 

                                                                        if (taglia.toUpperCase().equals("PICCOLA")) {

                                                                            int DES = (destrezza - 10) / 2;
                                                                            int CA = (10 + armatura_nat + armatura + 1 + DES);

                                                                            tx_dv = JOptionPane.showInputDialog("Inserire dado vita del BOSS \n" + "d4\n d6\n d8\n d10\n d12"); //scelta del DV

                                                                            if (tx_dv.equals("d12")) {

                                                                                String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                int NDV = Integer.parseInt(tx_ndv);
                                                                                int COS = (costituzione - 10) / 2;
                                                                                int punti_ferita = 12 * 5 / 6 * NDV + COS * NDV;
                                                                                String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                if (tx_rd.equals("5")) {

                                                                                    RD = Integer.parseInt(tx_rd);

                                                                                    String report = "----" + name + "----\n";
                                                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                                                    report += "CA del boss: " + CA + "\n";
                                                                                    report += "RD del boss: " + RD + "\n";
                                                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                                                    JOptionPane.showMessageDialog(null, report);
                                                                                    for (int i = 0; i < punti_ferita; i++) {

                                                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                        tiro_colpire = Integer.parseInt(t_c);

                                                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                            int tiro_danni = Integer.parseInt(t_d);

                                                                                            int[] danni_totali;
                                                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                                                            // int[] listaanticipi;
                                                                                            //sarà poi una variabile
                                                                                            int PF_rimanenti;

                                                                                            totale = totale + danni_totali[i];

                                                                                            PF_rimanenti = punti_ferita - totale;

                                                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                        }

                                                                                        if (totale >= punti_ferita) {

                                                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                    + "HAI UCCISO IL BOSS!!";

                                                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                        }
                                                                                    }
                                                                                }
                                                                                if (tx_rd.equals("10")) {

                                                                                    RD = Integer.parseInt(tx_rd);

                                                                                    String report = "----" + name + "----\n";
                                                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                                                    report += "CA del boss: " + CA + "\n";
                                                                                    report += "RD del boss: " + RD + "\n";
                                                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                                                    JOptionPane.showMessageDialog(null, report);
                                                                                    for (int i = 0; i < punti_ferita; i++) {

                                                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                        tiro_colpire = Integer.parseInt(t_c);

                                                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                            int tiro_danni = Integer.parseInt(t_d);

                                                                                            int[] danni_totali;
                                                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                                                            // int[] listaanticipi;
                                                                                            //sarà poi una variabile
                                                                                            int PF_rimanenti;

                                                                                            totale = totale + danni_totali[i];

                                                                                            PF_rimanenti = punti_ferita - totale;

                                                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                        }

                                                                                        if (totale >= punti_ferita) {

                                                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                    + "HAI UCCISO IL BOSS!!";

                                                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                        }

                                                                                        /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                         */
                                                                                    }
                                                                                }
                                                                                if (tx_rd.equals("15")) {

                                                                                    RD = Integer.parseInt(tx_rd);

                                                                                    String report = "----" + name + "----\n";
                                                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                                                    report += "CA del boss: " + CA + "\n";
                                                                                    report += "RD del boss: " + RD + "\n";
                                                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                                                    JOptionPane.showMessageDialog(null, report);
                                                                                    for (int i = 0; i < punti_ferita; i++) {

                                                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                        tiro_colpire = Integer.parseInt(t_c);

                                                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                            int tiro_danni = Integer.parseInt(t_d);

                                                                                            int[] danni_totali;
                                                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                                                            // int[] listaanticipi;
                                                                                            //sarà poi una variabile
                                                                                            int PF_rimanenti;

                                                                                            totale = totale + danni_totali[i];

                                                                                            PF_rimanenti = punti_ferita - totale;

                                                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                        }

                                                                                        if (totale >= punti_ferita) {

                                                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                    + "HAI UCCISO IL BOSS!!";

                                                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                        }
                                                                                    }
                                                                                } }

                                                                                if (tx_dv.equals("d10")) {

                                                                                    String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                    int NDV = Integer.parseInt(tx_ndv);
                                                                                    int COS = (costituzione - 10) / 2;
                                                                                    int punti_ferita = 10 * 5 / 6 * NDV + COS * NDV;
                                                                                    String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                    if (tx_rd.equals("5")) {

                                                                                        RD = Integer.parseInt(tx_rd);

                                                                                        String report = "----" + name + "----\n";
                                                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                                                        report += "CA del boss: " + CA + "\n";
                                                                                        report += "RD del boss: " + RD + "\n";
                                                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                                                        JOptionPane.showMessageDialog(null, report);
                                                                                        for (int i = 0; i < punti_ferita; i++) {

                                                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                            tiro_colpire = Integer.parseInt(t_c);

                                                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                                                int[] danni_totali;
                                                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                                                // int[] listaanticipi;
                                                                                                //sarà poi una variabile
                                                                                                int PF_rimanenti;

                                                                                                totale = totale + danni_totali[i];

                                                                                                PF_rimanenti = punti_ferita - totale;

                                                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                            }

                                                                                            if (totale >= punti_ferita) {

                                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    if (tx_rd.equals("10")) {

                                                                                        RD = Integer.parseInt(tx_rd);

                                                                                        String report = "----" + name + "----\n";
                                                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                                                        report += "CA del boss: " + CA + "\n";
                                                                                        report += "RD del boss: " + RD + "\n";
                                                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                                                        JOptionPane.showMessageDialog(null, report);
                                                                                        for (int i = 0; i < punti_ferita; i++) {

                                                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                            tiro_colpire = Integer.parseInt(t_c);

                                                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                                                int[] danni_totali;
                                                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                                                // int[] listaanticipi;
                                                                                                //sarà poi una variabile
                                                                                                int PF_rimanenti;

                                                                                                totale = totale + danni_totali[i];

                                                                                                PF_rimanenti = punti_ferita - totale;

                                                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                            }

                                                                                            if (totale >= punti_ferita) {

                                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                            }

                                                                                            /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                             */
                                                                                        }
                                                                                    }
                                                                                    if (tx_rd.equals("15")) {

                                                                                        RD = Integer.parseInt(tx_rd);

                                                                                        String report = "----" + name + "----\n";
                                                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                                                        report += "CA del boss: " + CA + "\n";
                                                                                        report += "RD del boss: " + RD + "\n";
                                                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                                                        JOptionPane.showMessageDialog(null, report);
                                                                                        for (int i = 0; i < punti_ferita; i++) {

                                                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                            tiro_colpire = Integer.parseInt(t_c);

                                                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                                                int[] danni_totali;
                                                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                                                // int[] listaanticipi;
                                                                                                //sarà poi una variabile
                                                                                                int PF_rimanenti;

                                                                                                totale = totale + danni_totali[i];

                                                                                                PF_rimanenti = punti_ferita - totale;

                                                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                            }

                                                                                            if (totale >= punti_ferita) {

                                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                                JOptionPane.showMessageDialog(null, report_vittoria);

                                                                                            }

                                                                                            if (totale >= punti_ferita) {

                                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                            }
                                                                                        }
                                                                                    } }
                                                                                    if (tx_dv.equals("d8")) {

                                                                                        String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                        int NDV = Integer.parseInt(tx_ndv);
                                                                                        int COS = (costituzione - 10) / 2;
                                                                                        int punti_ferita = 8 * 5 / 6 * NDV + COS * NDV;

                                                                                        String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                        if (tx_rd.equals("5")) {

                                                                                            RD = Integer.parseInt(tx_rd);

                                                                                            String report = "----" + name + "----\n";
                                                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                                                            report += "CA del boss: " + CA + "\n";
                                                                                            report += "RD del boss: " + RD + "\n";
                                                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                                                            JOptionPane.showMessageDialog(null, report);
                                                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                                                    int[] danni_totali;
                                                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                                                    // int[] listaanticipi;
                                                                                                    //sarà poi una variabile
                                                                                                    int PF_rimanenti;

                                                                                                    totale = totale + danni_totali[i];

                                                                                                    PF_rimanenti = punti_ferita - totale;

                                                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                }

                                                                                                if (totale >= punti_ferita) {

                                                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                            + "HAI UCCISO IL BOSS!!";

                                                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (tx_rd.equals("10")) {

                                                                                            RD = Integer.parseInt(tx_rd);

                                                                                            String report = "----" + name + "----\n";
                                                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                                                            report += "CA del boss: " + CA + "\n";
                                                                                            report += "RD del boss: " + RD + "\n";
                                                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                                                            JOptionPane.showMessageDialog(null, report);
                                                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                                                    int[] danni_totali;
                                                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                                                    // int[] listaanticipi;
                                                                                                    //sarà poi una variabile
                                                                                                    int PF_rimanenti;

                                                                                                    totale = totale + danni_totali[i];

                                                                                                    PF_rimanenti = punti_ferita - totale;

                                                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                }

                                                                                                if (totale >= punti_ferita) {

                                                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                            + "HAI UCCISO IL BOSS!!";

                                                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                }

                                                                                                /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                                 */
                                                                                            }
                                                                                        }
                                                                                        if (tx_rd.equals("15")) {

                                                                                            RD = Integer.parseInt(tx_rd);

                                                                                            String report = "----" + name + "----\n";
                                                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                                                            report += "CA del boss: " + CA + "\n";
                                                                                            report += "RD del boss: " + RD + "\n";
                                                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                                                            JOptionPane.showMessageDialog(null, report);
                                                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                                                    int[] danni_totali;
                                                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                                                    // int[] listaanticipi;
                                                                                                    //sarà poi una variabile
                                                                                                    int PF_rimanenti;

                                                                                                    totale = totale + danni_totali[i];

                                                                                                    PF_rimanenti = punti_ferita - totale;

                                                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                }

                                                                                                if (totale >= punti_ferita) {

                                                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                            + "HAI UCCISO IL BOSS!!";

                                                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                }
                                                                                            }
                                                                                        }} 
                                                                                        if (tx_dv.equals("d6")) {

                                                                                            String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                            int NDV = Integer.parseInt(tx_ndv);
                                                                                            int COS = (costituzione - 10) / 2;
                                                                                            int punti_ferita = 6 * 5 / 6 * NDV + COS * NDV;
                                                                                            String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                            if (tx_rd.equals("5")) {

                                                                                                RD = Integer.parseInt(tx_rd);

                                                                                                String report = "----" + name + "----\n";
                                                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                report += "CA del boss: " + CA + "\n";
                                                                                                report += "RD del boss: " + RD + "\n";
                                                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                                                JOptionPane.showMessageDialog(null, report);
                                                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                                                        int[] danni_totali;
                                                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                                                        // int[] listaanticipi;
                                                                                                        //sarà poi una variabile
                                                                                                        int PF_rimanenti;

                                                                                                        totale = totale + danni_totali[i];

                                                                                                        PF_rimanenti = punti_ferita - totale;

                                                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                    }

                                                                                                    if (totale >= punti_ferita) {

                                                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                + "HAI UCCISO IL BOSS!!";

                                                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            if (tx_rd.equals("10")) {

                                                                                                RD = Integer.parseInt(tx_rd);

                                                                                                String report = "----" + name + "----\n";
                                                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                report += "CA del boss: " + CA + "\n";
                                                                                                report += "RD del boss: " + RD + "\n";
                                                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                                                JOptionPane.showMessageDialog(null, report);
                                                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                                                        int[] danni_totali;
                                                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                                                        // int[] listaanticipi;
                                                                                                        //sarà poi una variabile
                                                                                                        int PF_rimanenti;

                                                                                                        totale = totale + danni_totali[i];

                                                                                                        PF_rimanenti = punti_ferita - totale;

                                                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                    }

                                                                                                    if (totale >= punti_ferita) {

                                                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                + "HAI UCCISO IL BOSS!!";

                                                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                    }

                                                                                                    /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                                     */
                                                                                                }
                                                                                            }
                                                                                            if (tx_rd.equals("15")) {

                                                                                                RD = Integer.parseInt(tx_rd);

                                                                                                String report = "----" + name + "----\n";
                                                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                report += "CA del boss: " + CA + "\n";
                                                                                                report += "RD del boss: " + RD + "\n";
                                                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                                                JOptionPane.showMessageDialog(null, report);
                                                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                                                        int[] danni_totali;
                                                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                                                        // int[] listaanticipi;
                                                                                                        //sarà poi una variabile
                                                                                                        int PF_rimanenti;

                                                                                                        totale = totale + danni_totali[i];

                                                                                                        PF_rimanenti = punti_ferita - totale;

                                                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                    }

                                                                                                    if (totale >= punti_ferita) {

                                                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                + "HAI UCCISO IL BOSS!!";

                                                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                    }
                                                                                                }
                                                                                            } }

                                                                                            if (tx_dv.equals("d4")) {

                                                                                                String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                                int NDV = Integer.parseInt(tx_ndv);
                                                                                                int COS = (costituzione - 10) / 2;
                                                                                                int punti_ferita = 4 * 5 / 6 * NDV + COS * NDV;
                                                                                                String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                                if (tx_rd.equals("5")) {

                                                                                                    RD = Integer.parseInt(tx_rd);

                                                                                                    String report = "----" + name + "----\n";
                                                                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                    report += "CA del boss: " + CA + "\n";
                                                                                                    report += "RD del boss: " + RD + "\n";
                                                                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                                                                    JOptionPane.showMessageDialog(null, report);
                                                                                                    for (int i = 0; i < punti_ferita; i++) {

                                                                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                        tiro_colpire = Integer.parseInt(t_c);

                                                                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                            int tiro_danni = Integer.parseInt(t_d);

                                                                                                            int[] danni_totali;
                                                                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                                                                            // int[] listaanticipi;
                                                                                                            //sarà poi una variabile
                                                                                                            int PF_rimanenti;

                                                                                                            totale = totale + danni_totali[i];

                                                                                                            PF_rimanenti = punti_ferita - totale;

                                                                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                        }

                                                                                                        if (totale >= punti_ferita) {

                                                                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                    + "HAI UCCISO IL BOSS!!";

                                                                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                if (tx_rd.equals("10")) {

                                                                                                    RD = Integer.parseInt(tx_rd);

                                                                                                    String report = "----" + name + "----\n";
                                                                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                    report += "CA del boss: " + CA + "\n";
                                                                                                    report += "RD del boss: " + RD + "\n";
                                                                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                                                                    JOptionPane.showMessageDialog(null, report);
                                                                                                    for (int i = 0; i < punti_ferita; i++) {

                                                                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                        tiro_colpire = Integer.parseInt(t_c);

                                                                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                            int tiro_danni = Integer.parseInt(t_d);

                                                                                                            int[] danni_totali;
                                                                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                                                                            // int[] listaanticipi;
                                                                                                            //sarà poi una variabile
                                                                                                            int PF_rimanenti;

                                                                                                            totale = totale + danni_totali[i];

                                                                                                            PF_rimanenti = punti_ferita - totale;

                                                                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                        }

                                                                                                        if (totale >= punti_ferita) {

                                                                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                    + "HAI UCCISO IL BOSS!!";

                                                                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                        }

                                                                                                        /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                                         */
                                                                                                    }
                                                                                                }
                                                                                                if (tx_rd.equals("15")) {

                                                                                                    RD = Integer.parseInt(tx_rd);

                                                                                                    String report = "----" + name + "----\n";
                                                                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                    report += "CA del boss: " + CA + "\n";
                                                                                                    report += "RD del boss: " + RD + "\n";
                                                                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                                                                    JOptionPane.showMessageDialog(null, report);
                                                                                                    for (int i = 0; i < punti_ferita; i++) {

                                                                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                        tiro_colpire = Integer.parseInt(t_c);

                                                                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                            int tiro_danni = Integer.parseInt(t_d);

                                                                                                            int[] danni_totali;
                                                                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                                                                            // int[] listaanticipi;
                                                                                                            //sarà poi una variabile
                                                                                                            int PF_rimanenti;

                                                                                                            totale = totale + danni_totali[i];

                                                                                                            PF_rimanenti = punti_ferita - totale;

                                                                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                        }

                                                                                                        if (totale >= punti_ferita) {

                                                                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                    + "HAI UCCISO IL BOSS!!";

                                                                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            } }
                                                                                            if (taglia.toUpperCase().equals("MINUSCOLA")) {

                                                                                                int DES = (destrezza - 10) / 2;
                                                                                                int CA = (10 + armatura_nat + armatura + 4 + DES);

                                                                                                tx_dv = JOptionPane.showInputDialog("Inserire dado vita del BOSS \n" + "d4\n d6\n d8\n d10\n d12"); //scelta del DV

                                                                                                if (tx_dv.equals("d12")) {

                                                                                                    String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                                    int NDV = Integer.parseInt(tx_ndv);
                                                                                                    int COS = (costituzione - 10) / 2;
                                                                                                    int punti_ferita = 12 * 5 / 6 * NDV + COS * NDV;
                                                                                                    String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                                    if (tx_rd.equals("5")) {

                                                                                                        RD = Integer.parseInt(tx_rd);

                                                                                                        String report = "----" + name + "----\n";
                                                                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                        report += "CA del boss: " + CA + "\n";
                                                                                                        report += "RD del boss: " + RD + "\n";
                                                                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                                                                        JOptionPane.showMessageDialog(null, report);
                                                                                                        for (int i = 0; i < punti_ferita; i++) {

                                                                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                            tiro_colpire = Integer.parseInt(t_c);

                                                                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                                                                int[] danni_totali;
                                                                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                // int[] listaanticipi;
                                                                                                                //sarà poi una variabile
                                                                                                                int PF_rimanenti;

                                                                                                                totale = totale + danni_totali[i];

                                                                                                                PF_rimanenti = punti_ferita - totale;

                                                                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                            }

                                                                                                            if (totale >= punti_ferita) {

                                                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    if (tx_rd.equals("10")) {

                                                                                                        RD = Integer.parseInt(tx_rd);

                                                                                                        String report = "----" + name + "----\n";
                                                                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                        report += "CA del boss: " + CA + "\n";
                                                                                                        report += "RD del boss: " + RD + "\n";
                                                                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                                                                        JOptionPane.showMessageDialog(null, report);
                                                                                                        for (int i = 0; i < punti_ferita; i++) {

                                                                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                            tiro_colpire = Integer.parseInt(t_c);

                                                                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                                                                int[] danni_totali;
                                                                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                // int[] listaanticipi;
                                                                                                                //sarà poi una variabile
                                                                                                                int PF_rimanenti;

                                                                                                                totale = totale + danni_totali[i];

                                                                                                                PF_rimanenti = punti_ferita - totale;

                                                                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                            }

                                                                                                            if (totale >= punti_ferita) {

                                                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                            }

                                                                                                            /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                                             */
                                                                                                        }
                                                                                                    }
                                                                                                    if (tx_rd.equals("15")) {

                                                                                                        RD = Integer.parseInt(tx_rd);

                                                                                                        String report = "----" + name + "----\n";
                                                                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                        report += "CA del boss: " + CA + "\n";
                                                                                                        report += "RD del boss: " + RD + "\n";
                                                                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                                                                        JOptionPane.showMessageDialog(null, report);
                                                                                                        for (int i = 0; i < punti_ferita; i++) {

                                                                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                            tiro_colpire = Integer.parseInt(t_c);

                                                                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                                                                int[] danni_totali;
                                                                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                // int[] listaanticipi;
                                                                                                                //sarà poi una variabile
                                                                                                                int PF_rimanenti;

                                                                                                                totale = totale + danni_totali[i];

                                                                                                                PF_rimanenti = punti_ferita - totale;

                                                                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                            }

                                                                                                            if (totale >= punti_ferita) {

                                                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                            }
                                                                                                        }
                                                                                                    } } 

                                                                                                    if (tx_dv.equals("d10")) {

                                                                                                        String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                                        int NDV = Integer.parseInt(tx_ndv);
                                                                                                        int COS = (costituzione - 10) / 2;
                                                                                                        int punti_ferita = 10 * 5 / 6 * NDV + COS * NDV;
                                                                                                        String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                                        if (tx_rd.equals("5")) {

                                                                                                            RD = Integer.parseInt(tx_rd);

                                                                                                            String report = "----" + name + "----\n";
                                                                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                            report += "CA del boss: " + CA + "\n";
                                                                                                            report += "RD del boss: " + RD + "\n";
                                                                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                                                                            JOptionPane.showMessageDialog(null, report);
                                                                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                                                                    int[] danni_totali;
                                                                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                    // int[] listaanticipi;
                                                                                                                    //sarà poi una variabile
                                                                                                                    int PF_rimanenti;

                                                                                                                    totale = totale + danni_totali[i];

                                                                                                                    PF_rimanenti = punti_ferita - totale;

                                                                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                }

                                                                                                                if (totale >= punti_ferita) {

                                                                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                            + "HAI UCCISO IL BOSS!!";

                                                                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        if (tx_rd.equals("10")) {

                                                                                                            RD = Integer.parseInt(tx_rd);

                                                                                                            String report = "----" + name + "----\n";
                                                                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                            report += "CA del boss: " + CA + "\n";
                                                                                                            report += "RD del boss: " + RD + "\n";
                                                                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                                                                            JOptionPane.showMessageDialog(null, report);
                                                                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                                                                    int[] danni_totali;
                                                                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                    // int[] listaanticipi;
                                                                                                                    //sarà poi una variabile
                                                                                                                    int PF_rimanenti;

                                                                                                                    totale = totale + danni_totali[i];

                                                                                                                    PF_rimanenti = punti_ferita - totale;

                                                                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                }

                                                                                                                if (totale >= punti_ferita) {

                                                                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                            + "HAI UCCISO IL BOSS!!";

                                                                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                }

                                                                                                                /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                                                 */
                                                                                                            }
                                                                                                        }
                                                                                                        if (tx_rd.equals("15")) {

                                                                                                            RD = Integer.parseInt(tx_rd);

                                                                                                            String report = "----" + name + "----\n";
                                                                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                            report += "CA del boss: " + CA + "\n";
                                                                                                            report += "RD del boss: " + RD + "\n";
                                                                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                                                                            JOptionPane.showMessageDialog(null, report);
                                                                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                                                                    int[] danni_totali;
                                                                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                    // int[] listaanticipi;
                                                                                                                    //sarà poi una variabile
                                                                                                                    int PF_rimanenti;

                                                                                                                    totale = totale + danni_totali[i];

                                                                                                                    PF_rimanenti = punti_ferita - totale;

                                                                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                }

                                                                                                                if (totale >= punti_ferita) {

                                                                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                            + "HAI UCCISO IL BOSS!!";

                                                                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                }
                                                                                                            }
                                                                                                        } }
                                                                                                    
                                                                                                        if (tx_dv.equals("d8")) {

                                                                                                            String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                                            int NDV = Integer.parseInt(tx_ndv);
                                                                                                            int COS = (costituzione - 10) / 2;
                                                                                                            int punti_ferita = 8 * 5 / 6 * NDV + COS * NDV;
                                                                                                            String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                                            if (tx_rd.equals("5")) {

                                                                                                                RD = Integer.parseInt(tx_rd);

                                                                                                                String report = "----" + name + "----\n";
                                                                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                report += "CA del boss: " + CA + "\n";
                                                                                                                report += "RD del boss: " + RD + "\n";
                                                                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                JOptionPane.showMessageDialog(null, report);
                                                                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                                                                        int[] danni_totali;
                                                                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                        // int[] listaanticipi;
                                                                                                                        //sarà poi una variabile
                                                                                                                        int PF_rimanenti;

                                                                                                                        totale = totale + danni_totali[i];

                                                                                                                        PF_rimanenti = punti_ferita - totale;

                                                                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                    }

                                                                                                                    if (totale >= punti_ferita) {

                                                                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                + "HAI UCCISO IL BOSS!!";

                                                                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                            if (tx_rd.equals("10")) {

                                                                                                                RD = Integer.parseInt(tx_rd);

                                                                                                                String report = "----" + name + "----\n";
                                                                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                report += "CA del boss: " + CA + "\n";
                                                                                                                report += "RD del boss: " + RD + "\n";
                                                                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                JOptionPane.showMessageDialog(null, report);
                                                                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                                                                        int[] danni_totali;
                                                                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                        // int[] listaanticipi;
                                                                                                                        //sarà poi una variabile
                                                                                                                        int PF_rimanenti;

                                                                                                                        totale = totale + danni_totali[i];

                                                                                                                        PF_rimanenti = punti_ferita - totale;

                                                                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                    }

                                                                                                                    if (totale >= punti_ferita) {

                                                                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                + "HAI UCCISO IL BOSS!!";

                                                                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                    }

                                                                                                                    /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                                                     */
                                                                                                                }
                                                                                                            }
                                                                                                            if (tx_rd.equals("15")) {

                                                                                                                RD = Integer.parseInt(tx_rd);

                                                                                                                String report = "----" + name + "----\n";
                                                                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                report += "CA del boss: " + CA + "\n";
                                                                                                                report += "RD del boss: " + RD + "\n";
                                                                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                JOptionPane.showMessageDialog(null, report);
                                                                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                                                                        int[] danni_totali;
                                                                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                        // int[] listaanticipi;
                                                                                                                        //sarà poi una variabile
                                                                                                                        int PF_rimanenti;

                                                                                                                        totale = totale + danni_totali[i];

                                                                                                                        PF_rimanenti = punti_ferita - totale;

                                                                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                    }

                                                                                                                    if (totale >= punti_ferita) {

                                                                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                + "HAI UCCISO IL BOSS!!";

                                                                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                    }
                                                                                                                }
                                                                                                            } }
                                                                                                            if (tx_dv.equals("d6")) {

                                                                                                                String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                                                int NDV = Integer.parseInt(tx_ndv);
                                                                                                                int COS = (costituzione - 10) / 2;
                                                                                                                int punti_ferita = 6 * 5 / 6 * NDV + COS * NDV;

                                                                                                                String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                                                if (tx_rd.equals("5")) {

                                                                                                                    RD = Integer.parseInt(tx_rd);

                                                                                                                    String report = "----" + name + "----\n";
                                                                                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                    report += "CA del boss: " + CA + "\n";
                                                                                                                    report += "RD del boss: " + RD + "\n";
                                                                                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                    JOptionPane.showMessageDialog(null, report);
                                                                                                                    for (int i = 0; i < punti_ferita; i++) {

                                                                                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                        tiro_colpire = Integer.parseInt(t_c);

                                                                                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                            int tiro_danni = Integer.parseInt(t_d);

                                                                                                                            int[] danni_totali;
                                                                                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                            // int[] listaanticipi;
                                                                                                                            //sarà poi una variabile
                                                                                                                            int PF_rimanenti;

                                                                                                                            totale = totale + danni_totali[i];

                                                                                                                            PF_rimanenti = punti_ferita - totale;

                                                                                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                        }

                                                                                                                        if (totale >= punti_ferita) {

                                                                                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                    + "HAI UCCISO IL BOSS!!";

                                                                                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                                if (tx_rd.equals("10")) {

                                                                                                                    RD = Integer.parseInt(tx_rd);

                                                                                                                    String report = "----" + name + "----\n";
                                                                                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                    report += "CA del boss: " + CA + "\n";
                                                                                                                    report += "RD del boss: " + RD + "\n";
                                                                                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                    JOptionPane.showMessageDialog(null, report);
                                                                                                                    for (int i = 0; i < punti_ferita; i++) {

                                                                                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                        tiro_colpire = Integer.parseInt(t_c);

                                                                                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                            int tiro_danni = Integer.parseInt(t_d);

                                                                                                                            int[] danni_totali;
                                                                                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                            // int[] listaanticipi;
                                                                                                                            //sarà poi una variabile
                                                                                                                            int PF_rimanenti;

                                                                                                                            totale = totale + danni_totali[i];

                                                                                                                            PF_rimanenti = punti_ferita - totale;

                                                                                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                        }

                                                                                                                        if (totale >= punti_ferita) {

                                                                                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                    + "HAI UCCISO IL BOSS!!";

                                                                                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                        }

                                                                                                                        /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                                                         */
                                                                                                                    }
                                                                                                                }
                                                                                                                if (tx_rd.equals("15")) {

                                                                                                                    RD = Integer.parseInt(tx_rd);

                                                                                                                    String report = "----" + name + "----\n";
                                                                                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                    report += "CA del boss: " + CA + "\n";
                                                                                                                    report += "RD del boss: " + RD + "\n";
                                                                                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                    JOptionPane.showMessageDialog(null, report);
                                                                                                                    for (int i = 0; i < punti_ferita; i++) {

                                                                                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                        tiro_colpire = Integer.parseInt(t_c);

                                                                                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                            int tiro_danni = Integer.parseInt(t_d);

                                                                                                                            int[] danni_totali;
                                                                                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                            // int[] listaanticipi;
                                                                                                                            //sarà poi una variabile
                                                                                                                            int PF_rimanenti;

                                                                                                                            totale = totale + danni_totali[i];

                                                                                                                            PF_rimanenti = punti_ferita - totale;

                                                                                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                        }

                                                                                                                        if (totale >= punti_ferita) {

                                                                                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                    + "HAI UCCISO IL BOSS!!";

                                                                                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                        }
                                                                                                                    }
                                                                                                                } }

                                                                                                                if (tx_dv.equals("d4")) {

                                                                                                                    String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                                                    int NDV = Integer.parseInt(tx_ndv);
                                                                                                                    int COS = (costituzione - 10) / 2;
                                                                                                                    int punti_ferita = 4 * 5 / 6 * NDV + COS * NDV;
                                                                                                                    String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                                                    if (tx_rd.equals("5")) {

                                                                                                                        RD = Integer.parseInt(tx_rd);

                                                                                                                        String report = "----" + name + "----\n";
                                                                                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                        report += "CA del boss: " + CA + "\n";
                                                                                                                        report += "RD del boss: " + RD + "\n";
                                                                                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                        JOptionPane.showMessageDialog(null, report);
                                                                                                                        for (int i = 0; i < punti_ferita; i++) {

                                                                                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                            tiro_colpire = Integer.parseInt(t_c);

                                                                                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                int[] danni_totali;
                                                                                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                // int[] listaanticipi;
                                                                                                                                //sarà poi una variabile
                                                                                                                                int PF_rimanenti;

                                                                                                                                totale = totale + danni_totali[i];

                                                                                                                                PF_rimanenti = punti_ferita - totale;

                                                                                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                            }

                                                                                                                            if (totale >= punti_ferita) {

                                                                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                    if (tx_rd.equals("10")) {

                                                                                                                        RD = Integer.parseInt(tx_rd);

                                                                                                                        String report = "----" + name + "----\n";
                                                                                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                        report += "CA del boss: " + CA + "\n";
                                                                                                                        report += "RD del boss: " + RD + "\n";
                                                                                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                        JOptionPane.showMessageDialog(null, report);
                                                                                                                        for (int i = 0; i < punti_ferita; i++) {

                                                                                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                            tiro_colpire = Integer.parseInt(t_c);

                                                                                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                int[] danni_totali;
                                                                                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                // int[] listaanticipi;
                                                                                                                                //sarà poi una variabile
                                                                                                                                int PF_rimanenti;

                                                                                                                                totale = totale + danni_totali[i];

                                                                                                                                PF_rimanenti = punti_ferita - totale;

                                                                                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                            }

                                                                                                                            if (totale >= punti_ferita) {

                                                                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                            }

                                                                                                                            /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                                                             */
                                                                                                                        }
                                                                                                                    }
                                                                                                                    if (tx_rd.equals("15")) {

                                                                                                                        RD = Integer.parseInt(tx_rd);

                                                                                                                        String report = "----" + name + "----\n";
                                                                                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                        report += "CA del boss: " + CA + "\n";
                                                                                                                        report += "RD del boss: " + RD + "\n";
                                                                                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                        JOptionPane.showMessageDialog(null, report);
                                                                                                                        for (int i = 0; i < punti_ferita; i++) {

                                                                                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                            tiro_colpire = Integer.parseInt(t_c);

                                                                                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                int[] danni_totali;
                                                                                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                // int[] listaanticipi;
                                                                                                                                //sarà poi una variabile
                                                                                                                                int PF_rimanenti;

                                                                                                                                totale = totale + danni_totali[i];

                                                                                                                                PF_rimanenti = punti_ferita - totale;

                                                                                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                            }

                                                                                                                            if (totale >= punti_ferita) {

                                                                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                } }

                                                                                                                if (taglia.toUpperCase().equals("MINUTA")) {

                                                                                                                    int DES = (destrezza - 10) / 2;
                                                                                                                    int CA = (10 + armatura_nat + armatura + 6 + DES);

                                                                                                                    tx_dv = JOptionPane.showInputDialog("Inserire dado vita del BOSS \n" + "d4\n d6\n d8\n d10\n d12"); //scelta del DV

                                                                                                                    if (tx_dv.equals("d12")) {

                                                                                                                        String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                                                        int NDV = Integer.parseInt(tx_ndv);
                                                                                                                        int COS = (costituzione - 10) / 2;
                                                                                                                        int punti_ferita = 12 * 5 / 6 * NDV + COS * NDV;

                                                                                                                        String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                                                        if (tx_rd.equals("5")) {

                                                                                                                            RD = Integer.parseInt(tx_rd);

                                                                                                                            String report = "----" + name + "----\n";
                                                                                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                            report += "CA del boss: " + CA + "\n";
                                                                                                                            report += "RD del boss: " + RD + "\n";
                                                                                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                            JOptionPane.showMessageDialog(null, report);
                                                                                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                    int[] danni_totali;
                                                                                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                    // int[] listaanticipi;
                                                                                                                                    //sarà poi una variabile
                                                                                                                                    int PF_rimanenti;

                                                                                                                                    totale = totale + danni_totali[i];

                                                                                                                                    PF_rimanenti = punti_ferita - totale;

                                                                                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                }

                                                                                                                                if (totale >= punti_ferita) {

                                                                                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                            + "HAI UCCISO IL BOSS!!";

                                                                                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (tx_rd.equals("10")) {

                                                                                                                            RD = Integer.parseInt(tx_rd);

                                                                                                                            String report = "----" + name + "----\n";
                                                                                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                            report += "CA del boss: " + CA + "\n";
                                                                                                                            report += "RD del boss: " + RD + "\n";
                                                                                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                            JOptionPane.showMessageDialog(null, report);
                                                                                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                    int[] danni_totali;
                                                                                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                    // int[] listaanticipi;
                                                                                                                                    //sarà poi una variabile
                                                                                                                                    int PF_rimanenti;

                                                                                                                                    totale = totale + danni_totali[i];

                                                                                                                                    PF_rimanenti = punti_ferita - totale;

                                                                                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                }

                                                                                                                                if (totale >= punti_ferita) {

                                                                                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                            + "HAI UCCISO IL BOSS!!";

                                                                                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                }

                                                                                                                                /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                                                                 */
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (tx_rd.equals("15")) {

                                                                                                                            RD = Integer.parseInt(tx_rd);

                                                                                                                            String report = "----" + name + "----\n";
                                                                                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                            report += "CA del boss: " + CA + "\n";
                                                                                                                            report += "RD del boss: " + RD + "\n";
                                                                                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                            JOptionPane.showMessageDialog(null, report);
                                                                                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                    int[] danni_totali;
                                                                                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                    // int[] listaanticipi;
                                                                                                                                    //sarà poi una variabile
                                                                                                                                    int PF_rimanenti;

                                                                                                                                    totale = totale + danni_totali[i];

                                                                                                                                    PF_rimanenti = punti_ferita - totale;

                                                                                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                }

                                                                                                                                if (totale >= punti_ferita) {

                                                                                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                            + "HAI UCCISO IL BOSS!!";

                                                                                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } }  

                                                                                                                        if (tx_dv.equals("d10")) {

                                                                                                                            String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                                                            int NDV = Integer.parseInt(tx_ndv);
                                                                                                                            int COS = (costituzione - 10) / 2;
                                                                                                                            int punti_ferita = 10 * 5 / 6 * NDV + COS * NDV;

                                                                                                                            String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                                                            if (tx_rd.equals("5")) {

                                                                                                                                RD = Integer.parseInt(tx_rd);

                                                                                                                                String report = "----" + name + "----\n";
                                                                                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                report += "CA del boss: " + CA + "\n";
                                                                                                                                report += "RD del boss: " + RD + "\n";
                                                                                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                JOptionPane.showMessageDialog(null, report);
                                                                                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                        int[] danni_totali;
                                                                                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                        // int[] listaanticipi;
                                                                                                                                        //sarà poi una variabile
                                                                                                                                        int PF_rimanenti;

                                                                                                                                        totale = totale + danni_totali[i];

                                                                                                                                        PF_rimanenti = punti_ferita - totale;

                                                                                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                    }

                                                                                                                                    if (totale >= punti_ferita) {

                                                                                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                + "HAI UCCISO IL BOSS!!";

                                                                                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                            if (tx_rd.equals("10")) {

                                                                                                                                RD = Integer.parseInt(tx_rd);

                                                                                                                                String report = "----" + name + "----\n";
                                                                                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                report += "CA del boss: " + CA + "\n";
                                                                                                                                report += "RD del boss: " + RD + "\n";
                                                                                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                JOptionPane.showMessageDialog(null, report);
                                                                                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                        int[] danni_totali;
                                                                                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                        // int[] listaanticipi;
                                                                                                                                        //sarà poi una variabile
                                                                                                                                        int PF_rimanenti;

                                                                                                                                        totale = totale + danni_totali[i];

                                                                                                                                        PF_rimanenti = punti_ferita - totale;

                                                                                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                    }

                                                                                                                                    if (totale >= punti_ferita) {

                                                                                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                + "HAI UCCISO IL BOSS!!";

                                                                                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                    }

                                                                                                                                    /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                                                                     */
                                                                                                                                }
                                                                                                                            }
                                                                                                                            if (tx_rd.equals("15")) {

                                                                                                                                RD = Integer.parseInt(tx_rd);

                                                                                                                                String report = "----" + name + "----\n";
                                                                                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                report += "CA del boss: " + CA + "\n";
                                                                                                                                report += "RD del boss: " + RD + "\n";
                                                                                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                JOptionPane.showMessageDialog(null, report);
                                                                                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                        int[] danni_totali;
                                                                                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                        // int[] listaanticipi;
                                                                                                                                        //sarà poi una variabile
                                                                                                                                        int PF_rimanenti;

                                                                                                                                        totale = totale + danni_totali[i];

                                                                                                                                        PF_rimanenti = punti_ferita - totale;

                                                                                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                    }

                                                                                                                                    if (totale >= punti_ferita) {

                                                                                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                + "HAI UCCISO IL BOSS!!";

                                                                                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            } }
                                                                                                                            if (tx_dv.equals("d8")) {

                                                                                                                                String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                                                                int NDV = Integer.parseInt(tx_ndv);
                                                                                                                                int COS = (costituzione - 10) / 2;
                                                                                                                                int punti_ferita = 8 * 5 / 6 * NDV + COS * NDV;
                                                                                                                                String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                                                                if (tx_rd.equals("5")) {

                                                                                                                                    RD = Integer.parseInt(tx_rd);

                                                                                                                                    String report = "----" + name + "----\n";
                                                                                                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                    report += "CA del boss: " + CA + "\n";
                                                                                                                                    report += "RD del boss: " + RD + "\n";
                                                                                                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                    JOptionPane.showMessageDialog(null, report);
                                                                                                                                    for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                        tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                            int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                            int[] danni_totali;
                                                                                                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                            // int[] listaanticipi;
                                                                                                                                            //sarà poi una variabile
                                                                                                                                            int PF_rimanenti;

                                                                                                                                            totale = totale + danni_totali[i];

                                                                                                                                            PF_rimanenti = punti_ferita - totale;

                                                                                                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                        }

                                                                                                                                        if (totale >= punti_ferita) {

                                                                                                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                    + "HAI UCCISO IL BOSS!!";

                                                                                                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                if (tx_rd.equals("10")) {

                                                                                                                                    RD = Integer.parseInt(tx_rd);

                                                                                                                                    String report = "----" + name + "----\n";
                                                                                                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                    report += "CA del boss: " + CA + "\n";
                                                                                                                                    report += "RD del boss: " + RD + "\n";
                                                                                                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                    JOptionPane.showMessageDialog(null, report);
                                                                                                                                    for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                        tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                            int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                            int[] danni_totali;
                                                                                                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                            // int[] listaanticipi;
                                                                                                                                            //sarà poi una variabile
                                                                                                                                            int PF_rimanenti;

                                                                                                                                            totale = totale + danni_totali[i];

                                                                                                                                            PF_rimanenti = punti_ferita - totale;

                                                                                                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                        }

                                                                                                                                        if (totale >= punti_ferita) {

                                                                                                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                    + "HAI UCCISO IL BOSS!!";

                                                                                                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                        }

                                                                                                                                        /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                                                                         */
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                if (tx_rd.equals("15")) {

                                                                                                                                    RD = Integer.parseInt(tx_rd);

                                                                                                                                    String report = "----" + name + "----\n";
                                                                                                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                    report += "CA del boss: " + CA + "\n";
                                                                                                                                    report += "RD del boss: " + RD + "\n";
                                                                                                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                    JOptionPane.showMessageDialog(null, report);
                                                                                                                                    for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                        tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                            int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                            int[] danni_totali;
                                                                                                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                            // int[] listaanticipi;
                                                                                                                                            //sarà poi una variabile
                                                                                                                                            int PF_rimanenti;

                                                                                                                                            totale = totale + danni_totali[i];

                                                                                                                                            PF_rimanenti = punti_ferita - totale;

                                                                                                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                        }

                                                                                                                                        if (totale >= punti_ferita) {

                                                                                                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                    + "HAI UCCISO IL BOSS!!";

                                                                                                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                } } 
                                                                                                                                if (tx_dv.equals("d6")) {

                                                                                                                                    String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                                                                    int NDV = Integer.parseInt(tx_ndv);
                                                                                                                                    int COS = (costituzione - 10) / 2;
                                                                                                                                    int punti_ferita = 6 * 5 / 6 * NDV + COS * NDV;

                                                                                                                                    String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                                                                    if (tx_rd.equals("5")) {

                                                                                                                                        RD = Integer.parseInt(tx_rd);

                                                                                                                                        String report = "----" + name + "----\n";
                                                                                                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                        report += "CA del boss: " + CA + "\n";
                                                                                                                                        report += "RD del boss: " + RD + "\n";
                                                                                                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                        JOptionPane.showMessageDialog(null, report);
                                                                                                                                        for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                            tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                int[] danni_totali;
                                                                                                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                // int[] listaanticipi;
                                                                                                                                                //sarà poi una variabile
                                                                                                                                                int PF_rimanenti;

                                                                                                                                                totale = totale + danni_totali[i];

                                                                                                                                                PF_rimanenti = punti_ferita - totale;

                                                                                                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                            }

                                                                                                                                            if (totale >= punti_ferita) {

                                                                                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    if (tx_rd.equals("10")) {

                                                                                                                                        RD = Integer.parseInt(tx_rd);

                                                                                                                                        String report = "----" + name + "----\n";
                                                                                                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                        report += "CA del boss: " + CA + "\n";
                                                                                                                                        report += "RD del boss: " + RD + "\n";
                                                                                                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                        JOptionPane.showMessageDialog(null, report);
                                                                                                                                        for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                            tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                int[] danni_totali;
                                                                                                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                // int[] listaanticipi;
                                                                                                                                                //sarà poi una variabile
                                                                                                                                                int PF_rimanenti;

                                                                                                                                                totale = totale + danni_totali[i];

                                                                                                                                                PF_rimanenti = punti_ferita - totale;

                                                                                                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                            }

                                                                                                                                            if (totale >= punti_ferita) {

                                                                                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                            }

                                                                                                                                            /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                                                                             */
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    if (tx_rd.equals("15")) {

                                                                                                                                        RD = Integer.parseInt(tx_rd);

                                                                                                                                        String report = "----" + name + "----\n";
                                                                                                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                        report += "CA del boss: " + CA + "\n";
                                                                                                                                        report += "RD del boss: " + RD + "\n";
                                                                                                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                        JOptionPane.showMessageDialog(null, report);
                                                                                                                                        for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                            tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                int[] danni_totali;
                                                                                                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                // int[] listaanticipi;
                                                                                                                                                //sarà poi una variabile
                                                                                                                                                int PF_rimanenti;

                                                                                                                                                totale = totale + danni_totali[i];

                                                                                                                                                PF_rimanenti = punti_ferita - totale;

                                                                                                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                            }

                                                                                                                                            if (totale >= punti_ferita) {

                                                                                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                            }
                                                                                                                                        } }
                                                                                                                                    }

                                                                                                                                    if (tx_dv.equals("d4")) {

                                                                                                                                        String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                                                                        int NDV = Integer.parseInt(tx_ndv);
                                                                                                                                        int COS = (costituzione - 10) / 2;
                                                                                                                                        int punti_ferita = 4 * 5 / 6 * NDV + COS * NDV;
                                                                                                                                        String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                                                                        if (tx_rd.equals("5")) {

                                                                                                                                            RD = Integer.parseInt(tx_rd);

                                                                                                                                            String report = "----" + name + "----\n";
                                                                                                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                            report += "CA del boss: " + CA + "\n";
                                                                                                                                            report += "RD del boss: " + RD + "\n";
                                                                                                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                            JOptionPane.showMessageDialog(null, report);
                                                                                                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                    int[] danni_totali;
                                                                                                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                    // int[] listaanticipi;
                                                                                                                                                    //sarà poi una variabile
                                                                                                                                                    int PF_rimanenti;

                                                                                                                                                    totale = totale + danni_totali[i];

                                                                                                                                                    PF_rimanenti = punti_ferita - totale;

                                                                                                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                                }

                                                                                                                                                if (totale >= punti_ferita) {

                                                                                                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                            + "HAI UCCISO IL BOSS!!";

                                                                                                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        if (tx_rd.equals("10")) {

                                                                                                                                            RD = Integer.parseInt(tx_rd);

                                                                                                                                            String report = "----" + name + "----\n";
                                                                                                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                            report += "CA del boss: " + CA + "\n";
                                                                                                                                            report += "RD del boss: " + RD + "\n";
                                                                                                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                            JOptionPane.showMessageDialog(null, report);
                                                                                                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                    int[] danni_totali;
                                                                                                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                    // int[] listaanticipi;
                                                                                                                                                    //sarà poi una variabile
                                                                                                                                                    int PF_rimanenti;

                                                                                                                                                    totale = totale + danni_totali[i];

                                                                                                                                                    PF_rimanenti = punti_ferita - totale;

                                                                                                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                                }

                                                                                                                                                if (totale >= punti_ferita) {

                                                                                                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                            + "HAI UCCISO IL BOSS!!";

                                                                                                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                                }

                                                                                                                                                /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                                                                                 */
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        if (tx_rd.equals("15")) {

                                                                                                                                            RD = Integer.parseInt(tx_rd);

                                                                                                                                            String report = "----" + name + "----\n";
                                                                                                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                            report += "CA del boss: " + CA + "\n";
                                                                                                                                            report += "RD del boss: " + RD + "\n";
                                                                                                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                            JOptionPane.showMessageDialog(null, report);
                                                                                                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                    int[] danni_totali;
                                                                                                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                    // int[] listaanticipi;
                                                                                                                                                    //sarà poi una variabile
                                                                                                                                                    int PF_rimanenti;

                                                                                                                                                    totale = totale + danni_totali[i];

                                                                                                                                                    PF_rimanenti = punti_ferita - totale;

                                                                                                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                                }

                                                                                                                                                if (totale >= punti_ferita) {

                                                                                                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                            + "HAI UCCISO IL BOSS!!";

                                                                                                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    } }

                                                                                                                                    if (taglia.toUpperCase().equals("PICCOLISSIMA")) {

                                                                                                                                        int DES = (destrezza - 10) / 2;
                                                                                                                                        int CA = (10 + armatura_nat + armatura + 8 + DES);

                                                                                                                                        tx_dv = JOptionPane.showInputDialog("Inserire dado vita del BOSS \n" + "d4\n d6\n d8\n d10\n d12"); //scelta del DV

                                                                                                                                        if (tx_dv.equals("d12")) {

                                                                                                                                            String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                                                                            int NDV = Integer.parseInt(tx_ndv);
                                                                                                                                            int COS = (costituzione - 10) / 2;
                                                                                                                                            int punti_ferita = 12 * 5 / 6 * NDV + COS * NDV;
                                                                                                                                            String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                                                                            if (tx_rd.equals("5")) {

                                                                                                                                                RD = Integer.parseInt(tx_rd);

                                                                                                                                                String report = "----" + name + "----\n";
                                                                                                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                                report += "CA del boss: " + CA + "\n";
                                                                                                                                                report += "RD del boss: " + RD + "\n";
                                                                                                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                                JOptionPane.showMessageDialog(null, report);
                                                                                                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                        int[] danni_totali;
                                                                                                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                        // int[] listaanticipi;
                                                                                                                                                        //sarà poi una variabile
                                                                                                                                                        int PF_rimanenti;

                                                                                                                                                        totale = totale + danni_totali[i];

                                                                                                                                                        PF_rimanenti = punti_ferita - totale;

                                                                                                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                                    }

                                                                                                                                                    if (totale >= punti_ferita) {

                                                                                                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                                + "HAI UCCISO IL BOSS!!";

                                                                                                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            if (tx_rd.equals("10")) {

                                                                                                                                                RD = Integer.parseInt(tx_rd);

                                                                                                                                                String report = "----" + name + "----\n";
                                                                                                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                                report += "CA del boss: " + CA + "\n";
                                                                                                                                                report += "RD del boss: " + RD + "\n";
                                                                                                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                                JOptionPane.showMessageDialog(null, report);
                                                                                                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                        int[] danni_totali;
                                                                                                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                        // int[] listaanticipi;
                                                                                                                                                        //sarà poi una variabile
                                                                                                                                                        int PF_rimanenti;

                                                                                                                                                        totale = totale + danni_totali[i];

                                                                                                                                                        PF_rimanenti = punti_ferita - totale;

                                                                                                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                                    }

                                                                                                                                                    if (totale >= punti_ferita) {

                                                                                                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                                + "HAI UCCISO IL BOSS!!";

                                                                                                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                                    }

                                                                                                                                                    /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                                                                                     */
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            if (tx_rd.equals("15")) {

                                                                                                                                                RD = Integer.parseInt(tx_rd);

                                                                                                                                                String report = "----" + name + "----\n";
                                                                                                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                                report += "CA del boss: " + CA + "\n";
                                                                                                                                                report += "RD del boss: " + RD + "\n";
                                                                                                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                                JOptionPane.showMessageDialog(null, report);
                                                                                                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                        int[] danni_totali;
                                                                                                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                        // int[] listaanticipi;
                                                                                                                                                        //sarà poi una variabile
                                                                                                                                                        int PF_rimanenti;

                                                                                                                                                        totale = totale + danni_totali[i];

                                                                                                                                                        PF_rimanenti = punti_ferita - totale;

                                                                                                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                                    }

                                                                                                                                                    if (totale >= punti_ferita) {

                                                                                                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                                + "HAI UCCISO IL BOSS!!";

                                                                                                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            } }

                                                                                                                                            if (tx_dv.equals("d10")) {

                                                                                                                                                String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                                                                                int NDV = Integer.parseInt(tx_ndv);
                                                                                                                                                int COS = (costituzione - 10) / 2;
                                                                                                                                                int punti_ferita = 10 * 5 / 6 * NDV + COS * NDV;
                                                                                                                                                String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                                                                                if (tx_rd.equals("5")) {

                                                                                                                                                    RD = Integer.parseInt(tx_rd);

                                                                                                                                                    String report = "----" + name + "----\n";
                                                                                                                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                                    report += "CA del boss: " + CA + "\n";
                                                                                                                                                    report += "RD del boss: " + RD + "\n";
                                                                                                                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                                    JOptionPane.showMessageDialog(null, report);
                                                                                                                                                    for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                                        tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                            int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                            int[] danni_totali;
                                                                                                                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                            // int[] listaanticipi;
                                                                                                                                                            //sarà poi una variabile
                                                                                                                                                            int PF_rimanenti;

                                                                                                                                                            totale = totale + danni_totali[i];

                                                                                                                                                            PF_rimanenti = punti_ferita - totale;

                                                                                                                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                                        }

                                                                                                                                                        if (totale >= punti_ferita) {

                                                                                                                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                                    + "HAI UCCISO IL BOSS!!";

                                                                                                                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                if (tx_rd.equals("10")) {

                                                                                                                                                    RD = Integer.parseInt(tx_rd);

                                                                                                                                                    String report = "----" + name + "----\n";
                                                                                                                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                                    report += "CA del boss: " + CA + "\n";
                                                                                                                                                    report += "RD del boss: " + RD + "\n";
                                                                                                                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                                    JOptionPane.showMessageDialog(null, report);
                                                                                                                                                    for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                                        tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                            int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                            int[] danni_totali;
                                                                                                                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                            // int[] listaanticipi;
                                                                                                                                                            //sarà poi una variabile
                                                                                                                                                            int PF_rimanenti;

                                                                                                                                                            totale = totale + danni_totali[i];

                                                                                                                                                            PF_rimanenti = punti_ferita - totale;

                                                                                                                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                                        }

                                                                                                                                                        if (totale >= punti_ferita) {

                                                                                                                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                                    + "HAI UCCISO IL BOSS!!";

                                                                                                                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                                        }

                                                                                                                                                        /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                                                                                         */
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                if (tx_rd.equals("15")) {

                                                                                                                                                    RD = Integer.parseInt(tx_rd);

                                                                                                                                                    String report = "----" + name + "----\n";
                                                                                                                                                    report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                                    report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                                    report += "CA del boss: " + CA + "\n";
                                                                                                                                                    report += "RD del boss: " + RD + "\n";
                                                                                                                                                    report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                                    JOptionPane.showMessageDialog(null, report);
                                                                                                                                                    for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                                        String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                                        tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                                        if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                            String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                            // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                            // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                            int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                            int[] danni_totali;
                                                                                                                                                            danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                            danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                            // int[] listaanticipi;
                                                                                                                                                            //sarà poi una variabile
                                                                                                                                                            int PF_rimanenti;

                                                                                                                                                            totale = totale + danni_totali[i];

                                                                                                                                                            PF_rimanenti = punti_ferita - totale;

                                                                                                                                                            JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                                        }

                                                                                                                                                        if (totale >= punti_ferita) {

                                                                                                                                                            String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                                    + "HAI UCCISO IL BOSS!!";

                                                                                                                                                            JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                } }
                                                                                                                                                if (tx_dv.equals("d8")) {

                                                                                                                                                    String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                                                                                    int NDV = Integer.parseInt(tx_ndv);
                                                                                                                                                    int COS = (costituzione - 10) / 2;
                                                                                                                                                    int punti_ferita = 8 * 5 / 6 * NDV + COS * NDV;
                                                                                                                                                    String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                                                                                    if (tx_rd.equals("5")) {

                                                                                                                                                        RD = Integer.parseInt(tx_rd);

                                                                                                                                                        String report = "----" + name + "----\n";
                                                                                                                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                                        report += "CA del boss: " + CA + "\n";
                                                                                                                                                        report += "RD del boss: " + RD + "\n";
                                                                                                                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                                        JOptionPane.showMessageDialog(null, report);
                                                                                                                                                        for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                                            tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                                int[] danni_totali;
                                                                                                                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                                // int[] listaanticipi;
                                                                                                                                                                //sarà poi una variabile
                                                                                                                                                                int PF_rimanenti;

                                                                                                                                                                totale = totale + danni_totali[i];

                                                                                                                                                                PF_rimanenti = punti_ferita - totale;

                                                                                                                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                                            }

                                                                                                                                                            if (totale >= punti_ferita) {

                                                                                                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                                                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    if (tx_rd.equals("10")) {

                                                                                                                                                        RD = Integer.parseInt(tx_rd);

                                                                                                                                                        String report = "----" + name + "----\n";
                                                                                                                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                                        report += "CA del boss: " + CA + "\n";
                                                                                                                                                        report += "RD del boss: " + RD + "\n";
                                                                                                                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                                        JOptionPane.showMessageDialog(null, report);
                                                                                                                                                        for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                                            tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                                int[] danni_totali;
                                                                                                                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                                // int[] listaanticipi;
                                                                                                                                                                //sarà poi una variabile
                                                                                                                                                                int PF_rimanenti;

                                                                                                                                                                totale = totale + danni_totali[i];

                                                                                                                                                                PF_rimanenti = punti_ferita - totale;

                                                                                                                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                                            }

                                                                                                                                                            if (totale >= punti_ferita) {

                                                                                                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                                                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                                            }

                                                                                                                                                            /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                                                                                             */
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    if (tx_rd.equals("15")) {

                                                                                                                                                        RD = Integer.parseInt(tx_rd);

                                                                                                                                                        String report = "----" + name + "----\n";
                                                                                                                                                        report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                                        report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                                        report += "CA del boss: " + CA + "\n";
                                                                                                                                                        report += "RD del boss: " + RD + "\n";
                                                                                                                                                        report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                                        JOptionPane.showMessageDialog(null, report);
                                                                                                                                                        for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                                            String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                                            tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                                            if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                                String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                                // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                                // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                                int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                                int[] danni_totali;
                                                                                                                                                                danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                                danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                                // int[] listaanticipi;
                                                                                                                                                                //sarà poi una variabile
                                                                                                                                                                int PF_rimanenti;

                                                                                                                                                                totale = totale + danni_totali[i];

                                                                                                                                                                PF_rimanenti = punti_ferita - totale;

                                                                                                                                                                JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                                            }

                                                                                                                                                            if (totale >= punti_ferita) {

                                                                                                                                                                String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                                        + "HAI UCCISO IL BOSS!!";

                                                                                                                                                                JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    } }
                                                                                                                                                    if (tx_dv.equals("d6")) {

                                                                                                                                                        String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                                                                                        int NDV = Integer.parseInt(tx_ndv);
                                                                                                                                                        int COS = (costituzione - 10) / 2;
                                                                                                                                                        int punti_ferita = 6 * 5 / 6 * NDV + COS * NDV;
                                                                                                                                                        String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                                                                                        if (tx_rd.equals("5")) {

                                                                                                                                                            RD = Integer.parseInt(tx_rd);

                                                                                                                                                            String report = "----" + name + "----\n";
                                                                                                                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                                            report += "CA del boss: " + CA + "\n";
                                                                                                                                                            report += "RD del boss: " + RD + "\n";
                                                                                                                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                                            JOptionPane.showMessageDialog(null, report);
                                                                                                                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                                    int[] danni_totali;
                                                                                                                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                                    // int[] listaanticipi;
                                                                                                                                                                    //sarà poi una variabile
                                                                                                                                                                    int PF_rimanenti;

                                                                                                                                                                    totale = totale + danni_totali[i];

                                                                                                                                                                    PF_rimanenti = punti_ferita - totale;

                                                                                                                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                                                }

                                                                                                                                                                if (totale >= punti_ferita) {

                                                                                                                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                                            + "HAI UCCISO IL BOSS!!";

                                                                                                                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        if (tx_rd.equals("10")) {

                                                                                                                                                            RD = Integer.parseInt(tx_rd);

                                                                                                                                                            String report = "----" + name + "----\n";
                                                                                                                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                                            report += "CA del boss: " + CA + "\n";
                                                                                                                                                            report += "RD del boss: " + RD + "\n";
                                                                                                                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                                            JOptionPane.showMessageDialog(null, report);
                                                                                                                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                                    int[] danni_totali;
                                                                                                                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                                    // int[] listaanticipi;
                                                                                                                                                                    //sarà poi una variabile
                                                                                                                                                                    int PF_rimanenti;

                                                                                                                                                                    totale = totale + danni_totali[i];

                                                                                                                                                                    PF_rimanenti = punti_ferita - totale;

                                                                                                                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                                                }

                                                                                                                                                                if (totale >= punti_ferita) {

                                                                                                                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                                            + "HAI UCCISO IL BOSS!!";

                                                                                                                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                                                }

                                                                                                                                                                /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                                                                                                 */
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        if (tx_rd.equals("15")) {

                                                                                                                                                            RD = Integer.parseInt(tx_rd);

                                                                                                                                                            String report = "----" + name + "----\n";
                                                                                                                                                            report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                                            report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                                            report += "CA del boss: " + CA + "\n";
                                                                                                                                                            report += "RD del boss: " + RD + "\n";
                                                                                                                                                            report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                                            JOptionPane.showMessageDialog(null, report);
                                                                                                                                                            for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                                                String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                                                tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                                                if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                                    String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                                    // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                                    // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                                    int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                                    int[] danni_totali;
                                                                                                                                                                    danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                                    danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                                    // int[] listaanticipi;
                                                                                                                                                                    //sarà poi una variabile
                                                                                                                                                                    int PF_rimanenti;

                                                                                                                                                                    totale = totale + danni_totali[i];

                                                                                                                                                                    PF_rimanenti = punti_ferita - totale;

                                                                                                                                                                    JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                                                }

                                                                                                                                                                if (totale >= punti_ferita) {

                                                                                                                                                                    String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                                            + "HAI UCCISO IL BOSS!!";

                                                                                                                                                                    JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        } }

                                                                                                                                                        if (tx_dv.equals("d4")) {

                                                                                                                                                            String tx_ndv = JOptionPane.showInputDialog("Numero Dadi Vita del BOSS"); //scelta numero DV 

                                                                                                                                                            int NDV = Integer.parseInt(tx_ndv);
                                                                                                                                                            int COS = (costituzione - 10) / 2;
                                                                                                                                                            int punti_ferita = 4 * 5 / 6 * NDV + COS * NDV;

                                                                                                                                                            String tx_rd = JOptionPane.showInputDialog("Inserire Riduzione del danno \n" + "RD 5 \n RD 10 \n RD 15");

                                                                                                                                                            if (tx_rd.equals("5")) {

                                                                                                                                                                RD = Integer.parseInt(tx_rd);

                                                                                                                                                                String report = "----" + name + "----\n";
                                                                                                                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                                                report += "CA del boss: " + CA + "\n";
                                                                                                                                                                report += "RD del boss: " + RD + "\n";
                                                                                                                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                                                JOptionPane.showMessageDialog(null, report);
                                                                                                                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                                        int[] danni_totali;
                                                                                                                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                                        // int[] listaanticipi;
                                                                                                                                                                        //sarà poi una variabile
                                                                                                                                                                        int PF_rimanenti;

                                                                                                                                                                        totale = totale + danni_totali[i];

                                                                                                                                                                        PF_rimanenti = punti_ferita - totale;

                                                                                                                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                                                    }

                                                                                                                                                                    if (totale >= punti_ferita) {

                                                                                                                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                                                + "HAI UCCISO IL BOSS!!";

                                                                                                                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                            if (tx_rd.equals("10")) {

                                                                                                                                                                RD = Integer.parseInt(tx_rd);

                                                                                                                                                                String report = "----" + name + "----\n";
                                                                                                                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                                                report += "CA del boss: " + CA + "\n";
                                                                                                                                                                report += "RD del boss: " + RD + "\n";
                                                                                                                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                                                JOptionPane.showMessageDialog(null, report);
                                                                                                                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                                        int[] danni_totali;
                                                                                                                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                                        // int[] listaanticipi;
                                                                                                                                                                        //sarà poi una variabile
                                                                                                                                                                        int PF_rimanenti;

                                                                                                                                                                        totale = totale + danni_totali[i];

                                                                                                                                                                        PF_rimanenti = punti_ferita - totale;

                                                                                                                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                                                    }

                                                                                                                                                                    if (totale >= punti_ferita) {

                                                                                                                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                                                + "HAI UCCISO IL BOSS!!";

                                                                                                                                                                        JOptionPane.showMessageDialog(null, report_vittoria);
                                                                                                                                                                    }

                                                                                                                                                                    /*   Attacco
   tiro per colpire = input dato dal giocatore se (  input >= CA allora boss colpito)
   tiro per i danni = input dato dal giocatore - RD se (totale >= PF allora boss morto)
    
  altrimenti ritorno al tiro per colpire 

                                                                                                                                                                     */
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                            if (tx_rd.equals("15")) {

                                                                                                                                                                RD = Integer.parseInt(tx_rd);

                                                                                                                                                                String report = "----" + name + "----\n";
                                                                                                                                                                report += "costituzione del boss: " + costituzione + "\n";
                                                                                                                                                                report += "destrezza del boss: " + destrezza + "\n ";
                                                                                                                                                                report += "CA del boss: " + CA + "\n";
                                                                                                                                                                report += "RD del boss: " + RD + "\n";
                                                                                                                                                                report += "punti ferita: " + punti_ferita + "\n";

                                                                                                                                                                JOptionPane.showMessageDialog(null, report);
                                                                                                                                                                for (int i = 0; i < punti_ferita; i++) {

                                                                                                                                                                    String t_c = JOptionPane.showInputDialog("tira per colpire");

                                                                                                                                                                    tiro_colpire = Integer.parseInt(t_c);

                                                                                                                                                                    if (tiro_colpire >= CA) {

//tira i danni (ovvero prendere imput dei danni , sottrarre i danni dai punti ferita e mostrarli al DM)
                                                                                                                                                                        String t_d = JOptionPane.showInputDialog("tira per i danni");
                                                                                                                                                                        // String tx_anticipo = JOptionPane.showInputDialog(\"quanto lasci?\", \"0\");
                                                                                                                                                                        // listaanticipi[i] = Integer.parseInt(tx_anticipo);  

                                                                                                                                                                        int tiro_danni = Integer.parseInt(t_d);

                                                                                                                                                                        int[] danni_totali;
                                                                                                                                                                        danni_totali = new int[tiro_danni];//listaanticipi = new int[quanti];
                                                                                                                                                                        danni_totali[i] = Integer.parseInt(t_d);

                                                                                                                                                                        // int[] listaanticipi;
                                                                                                                                                                        //sarà poi una variabile
                                                                                                                                                                        int PF_rimanenti;

                                                                                                                                                                        totale = totale + danni_totali[i];

                                                                                                                                                                        PF_rimanenti = punti_ferita - totale;

                                                                                                                                                                        JOptionPane.showMessageDialog(null, PF_rimanenti);

                                                                                                                                                                    }

                                                                                                                                                                    if (totale >= punti_ferita) {

                                                                                                                                                                        String report_vittoria = "---- COMPLIMENTI ---- \n"
                                                                                                                                                                                + "HAI UCCISO IL BOSS!!";

                                                                                                                                                                        JOptionPane.showMessageDialog(null, report_vittoria);

                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                    }}}
                                                                                                                                                
                                                                    