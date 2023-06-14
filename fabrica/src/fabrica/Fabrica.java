/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fabrica;

import views.login;
import connections.Testes;
import java.sql.SQLException;

/**
 *
 * @author annas
 */
public class Fabrica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        login logar = new login();

        logar.setVisible(true);
       
        
    }
    
}
