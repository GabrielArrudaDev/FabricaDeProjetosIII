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
public class Agenda {
     MySQL conectar = new MySQL();
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<AgendamentoAnimal> lista = new ArrayList<>();
    
   public ArrayList<AgendamentoAnimal> PesquisarAgendamento(){
       String sql = "select * from agendamento";
       this.conectar.conectaBanco();
       conn = conectar.getConn();
       try {
           pstm = conn.prepareStatement(sql);
           rs = pstm.executeQuery();
           
           while(rs.next()){
               AgendamentoAnimal agend = new AgendamentoAnimal();
               agend.setNomeDono(rs.getString("nomeDono"));               
               agend.setNomeAnimal(rs.getString("nomeAnimal"));
               agend.setServico(rs.getString("servico"));
               agend.setHora(rs.getString("hora"));
               agend.setAgenda(rs.getString("agenda"));
               
               lista.add(agend);
           }
       } catch(SQLException erro) {
           JOptionPane.showMessageDialog(null, "Algo errado aconteceu" + erro);
       }
       return lista;
   }
}
