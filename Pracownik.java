/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package callcenter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
import java.awt.event.*;
/*
 * Utworzenie klasy Pracownik
 */
public class Pracownik {
    private String imie;
    private String nazwisko;
    private String login;
    private String miasto;
    private String kod;
    private String ulica;
    private String nrDomu;
    private String nrMieszkania;
    private static Integer nr;
    
    public Pracownik(Integer nr){
        this.nr=nr;
    }
      /**
     * Pobranie z bazy danych dla poszczegolnego pracownika
     */        
    public String Pobierz(String nazwa) throws SQLException{
        
        Connection myConn=null;
        Statement myStmt=null;
        ResultSet myRs=null;
        String text="";
        String text2="";
  
        try {
            myConn =DriverManager.getConnection("jdbc:mysql://localhost/callcenter","root", "");
            System.out.println("Baza Danych połączona");
            
            myStmt= myConn.createStatement();
            //Pobranie z bazy danych jezykow przypisanych dla danego pracownika
            if(nazwa.equals("Jezyk"))
            {
                myRs = myStmt.executeQuery("SELECT " + nazwa + " FROM `jezyki` WHERE KodJezyka IN (select KodJezyka from pracownik_jezyki where NrPracownika="+nr+")");

                while (myRs.next()) {
                    text= myRs.getString(nazwa)+", ";
                    text2=text2 +" "+text;
                }               
            }
            else{
                myRs = myStmt.executeQuery("select " + nazwa+" from pracownik where NrPracownika ="+nr);

                while (myRs.next()) {
                    //System.out.println(myRs.getString(nazwa));// + ", " + myRs.getString("Address"));
                    return text= myRs.getString(nazwa);
                }               
            }

        }
        catch(SQLException se){
        System.out.println("Brak bazy danych " + se);
         }
        finally {
            if (myRs !=null){
                myRs.close();
            }
            if (myStmt !=null){
                myStmt.close();
            }
            if (myConn !=null){
                myConn.close();
            }
        }
        return text2;
    }
     /**
     * Funkcja edytujaca jezyki danego pracownika
     */ 
      public int JezykEdycja (String jezyk) throws SQLException
   {
        Connection myConn=null;
        Statement myStmt=null;
        ResultSet myRs=null;
        ResultSet myRsKod=null;
        ResultSet myRsNr=null;

        try {
            myConn =DriverManager.getConnection("jdbc:mysql://localhost/callcenter","root", "");
            System.out.println("Baza Danych połączona");
            
            myStmt= myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT Jezyk FROM `jezyki` WHERE KodJezyka IN (select KodJezyka from pracownik_jezyki where NrPracownika ="+nr+")");

                while (myRs.next()) {
                    if(myRs.getString("Jezyk").equals(jezyk)){
                        return 1;
                    }     
                }
                //zapytanie zwracajace kod jezyka wybranego przez uzytkownika
                myRsKod = myStmt.executeQuery("SELECT KodJezyka from jezyki where Jezyk like'"+jezyk+"'");
                myRsKod.next();
                String Kod=myRsKod.getString("KodJezyka");
                    
                //dodanie wybranego jezyka do bazy
                //System.out.println("kod jezyka: "+Kod);
                myStmt.execute("INSERT INTO `pracownik_jezyki`(`NrPracownika`, `KodJezyka`) VALUES ("+nr+",'"+Kod+"')");
        }
        catch(SQLException se){
        System.out.println("Brak bazy danych " + se);
         }
        finally {
            if (myRs !=null){
                myRs.close();
            }
            if (myStmt !=null){
                myStmt.close();
            }
            if (myConn !=null){
                myConn.close();
            }
        }
        return 0;
    }
     /**
     * Funkcja edytujaca dane pracownika
     */      
     public void Edycja(String pole, String wartosc) throws SQLException {
        Connection myConn=null;
        Statement myStmt=null;
        ResultSet myRs=null;
        ResultSet myRsKod=null;
        ResultSet myRsNr=null;

        try {
            myConn =DriverManager.getConnection("jdbc:mysql://localhost/callcenter","root", "");
            System.out.println("Baza Danych połączona");
            
            myStmt= myConn.createStatement();
            if(pole.equals("Haslo"))
            {
                myStmt.execute("UPDATE `login` SET `Haslo`='"+wartosc+"' WHERE login='pracownik'");
            }
            else{
                myStmt.execute("UPDATE `pracownik` SET "+pole+"='"+wartosc+"' WHERE NrPracownika="+nr);
            }

        }
        catch(SQLException se){
        System.out.println("Brak bazy danych " + se);
         }
        finally {

            if (myStmt !=null){
                myStmt.close();
            }
            if (myConn !=null){
                myConn.close();
            }
        }
                 
     }
      
    
    public static void main(String[] args) throws SQLException{
        
        Pracownik pracownik=new Pracownik(2);
       // String text=pracownik.Pobierz("Jezyk");
        //System.out.println(text);
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
