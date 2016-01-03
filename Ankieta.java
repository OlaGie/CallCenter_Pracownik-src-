/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import net.proteanit.sql.DbUtils;
/**
 *
 * @author Ola
 */
public class Ankieta extends javax.swing.JFrame {

    Connection conn = new DatabaseConnection().connect();
    ResultSet rs = null;
    PreparedStatement pst = null;
    String sql="";
    private Integer nrPracownika;
    
    /**
     * Creates new form Ankieta
     */
    public Ankieta(Integer nrPracownika) {
        initComponents();
        this.nrPracownika=nrPracownika;
        fillPollComboBox();
    }
    public Ankieta(){
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Pytania = new javax.swing.JTable();
        jComboBox_Ankieta = new javax.swing.JComboBox();
        jButton_Zatwierdz = new javax.swing.JButton();
        jLabel_WybierzAnkiete = new javax.swing.JLabel();
        jButton_Zamknij = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable_Pytania.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nr Pytania", "Treść", "1", "2", "3", "4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_Pytania);

        jComboBox_Ankieta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton_Zatwierdz.setText("Wyświetl");
        jButton_Zatwierdz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_ZatwierdzMouseClicked(evt);
            }
        });

        jLabel_WybierzAnkiete.setForeground(new java.awt.Color(204, 0, 0));

        jButton_Zamknij.setText("Zamknij");
        jButton_Zamknij.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_ZamknijMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel_WybierzAnkiete, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Zatwierdz))
                    .addComponent(jComboBox_Ankieta, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton_Zamknij)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox_Ankieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Zatwierdz)
                    .addComponent(jLabel_WybierzAnkiete))
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_Zamknij)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Zatwierdzenie wyboru poszczegolnej ankiety z ComboBox i wyswietlenie pytan dla ww ankiety w tabeliP
     */  
    private void jButton_ZatwierdzMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ZatwierdzMouseClicked
        // TODO add your handling code here:
        fillQuestionTable(pollChoice());
    }//GEN-LAST:event_jButton_ZatwierdzMouseClicked
    /**
     * Zamkniecie okna wyswietlajacego tresc ankiet
     */
    private void jButton_ZamknijMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ZamknijMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton_ZamknijMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ankieta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ankieta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ankieta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ankieta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ankieta(2).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Zamknij;
    private javax.swing.JButton jButton_Zatwierdz;
    private javax.swing.JComboBox jComboBox_Ankieta;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel_WybierzAnkiete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable_Pytania;
    // End of variables declaration//GEN-END:variables
    /**
     * Funkcja wypelniajaca ComboBox numerami ankiet oraz opisem poszczegolnej ankiety
     */
    public void fillPollComboBox(){
        sql = "SELECT concat(NrAnkiety,'. ',Opis) FROM ankiety where NrPracownika="+nrPracownika;
        try {
            //wyczyszczenie ComboBox
            jComboBox_Ankieta.removeAllItems();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jComboBox_Ankieta.addItem("Wybierz ankiete: ");
            //załadowanie wynikow zapytania z bazy danych do ComboBox
            while(rs.next()){
                jComboBox_Ankieta.addItem(rs.getString(1));
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error connecting to a database. " + e);
        }
    }
    /**
     * Funkcja zwracająca numer ankiety jaki zostal wybrany przez uzytkownika
     * @return nrAnkiety
     */    
    public Integer pollChoice()
    {
        Integer nrAnkiety;
        nrAnkiety=jComboBox_Ankieta.getSelectedIndex();
       //System.out.println(nrAnkiety);
        return nrAnkiety;
    }
     /**
     * Funkcja wypełniająca tabele pytaniami z poszczegolnych ankiet
     * @param nrAnkiety
     */ 
        public int numberOfQuestions(int nrAnkiety){
        try{
            sql = "SELECT count(distinct NrPytania) as liczba from zbiory_odpowiedzi where NrAnkiety="+nrAnkiety;            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            int liczbaPytan=rs.getInt(1);    
            return liczbaPytan;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error connecting to a datrabase. "+ex);
        }
        return 0;
    }
        public int maxNumberOfQuestions(){
            try{
                sql="SELECT max(NrPytania) from zbiory_odpowiedzi";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                rs.next();
                int maxLiczbaPytan=rs.getInt(1);
                return maxLiczbaPytan;
            }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error connecting to a datrabase. "+ex);
        }            
        return 0;
        }

    public void fillQuestionTable(Integer nrAnkiety)
    {
        if (nrAnkiety.equals(0)){
            jLabel_WybierzAnkiete.setText("Wybierz ankiete");
        }
        else{
            jLabel_WybierzAnkiete.setText("");
            //zapytanie zwracajace ile jest pytan w danej ankiecie

            try {
                for(int i=1;i<maxNumberOfQuestions()+1; i++){
                    for(int l=0;l<6;l++){
                        jTable_Pytania.setValueAt("",i-1,l);                   
                    }
                }
                for(int i=1;i<numberOfQuestions(nrAnkiety)+1;i++)
                {
                    //zapytanie zwracajace tresc kolejnych pytan dla danej ankiety
                    sql="SELECT Pytanie from pytania where NrPytania="+i+" and NrAnkiety="+nrAnkiety;
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();

                    while(rs.next()){
                        String pytanie=rs.getString(1);
                        //umieszczenie nr-u pytania i treści poszczegolnych pytan w pierwszych dwoch kolumnach tabeli
                        jTable_Pytania.setValueAt(i,i-1,0);
                        jTable_Pytania.setValueAt(pytanie,i-1,1);
                    }    
                    //zapytanie zwracajace ilosc odpowiedzi dla danego pytania
                    sql="SELECT count(NrOdpowiedzi) from zbiory_odpowiedzi where NrPytania="+i+" and NrAnkiety="+nrAnkiety;
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();
                    rs.next();
                    int liczbaOdpowiedzi=rs.getInt(1);
                    //System.out.println(liczbaOdpowiedzi);
                    //umieszczenie poszczegolnych odpowiedzi w kolejnych kolumnach tabeli
                    for(int k=1, l=2; k<liczbaOdpowiedzi+1; k++,l++)
                    {
                    sql="SELECT Odpowiedz from zbiory_odpowiedzi where NrOdpowiedzi="+k+" and NrPytania="+i+" and NrAnkiety="+nrAnkiety;
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();  
                        while(rs.next()){
                           String odpowiedz=rs.getString(1);
                           System.out.println(odpowiedz);
                           jTable_Pytania.setValueAt(odpowiedz,i-1,l);
                       }                              
                    }
            }    
                //System.out.println(liczbaPytan);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error connecting to a database. " + ex);
            }
        }
    }

}
