/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

import connections.MySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author annas
 */
public class TabelaAgenda {
     MySQL conectar = new MySQL();
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Agendamento> lista = new ArrayList<>();
    
   public ArrayList<Agendamento> PesquisarAgendamento(){
       String sql = "select * from agendamento";
       this.conectar.conectaBanco();
       conn = conectar.getConn();
       try {
           pstm = conn.prepareStatement(sql);
           rs = pstm.executeQuery();
           
           while(rs.next()){
               Agendamento agend = new Agendamento();
               agend.setNome(rs.getString("nome"));  
               agend.setCpf(rs.getString("cpf"));  
               agend.setServico(rs.getString("servico"));
               agend.setHora(rs.getString("hora"));
               agend.setValor(rs.getString("valor"));
               agend.setAgenda(rs.getString("agenda"));
               
               
               lista.add(agend);
           }
       } catch(SQLException erro) {
           JOptionPane.showMessageDialog(null, "Algo errado aconteceu" + erro);
       }
       return lista;
   }
}
