/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objects.Agendamento;
import javax.swing.table.DefaultTableModel;
import objects.TabelaAgenda;

/**
 *
 * @author fekwa
 */
public class TabelaAgendamento extends javax.swing.JFrame {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Agendamento> lista = new ArrayList<>();
    /**
     * Creates new form tabela
     */
    
    public TabelaAgendamento() {
        initComponents();
        listarValores();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_agendamento1 = new javax.swing.JButton();
        btn_agenda3 = new javax.swing.JButton();
        btn_agenda4 = new javax.swing.JButton();
        btn_agenda5 = new javax.swing.JButton();
        btn_agenda6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 63, 89));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Serviço", "Horário",  "Valor", "Data"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 540));
        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 780, 600));

        jPanel3.setBackground(new java.awt.Color(240, 140, 23));
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("AGENDA");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(0, 70, 220, 30);

        btn_agendamento1.setBackground(new java.awt.Color(231, 168, 95));
        btn_agendamento1.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btn_agendamento1.setForeground(new java.awt.Color(255, 255, 255));
        btn_agendamento1.setText("NOVO AGENDAMENTO");
        btn_agendamento1.setBorder(null);
        btn_agendamento1.setBorderPainted(false);
        btn_agendamento1.setFocusPainted(false);
        btn_agendamento1.setFocusable(false);
        btn_agendamento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agendamento1ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_agendamento1);
        btn_agendamento1.setBounds(0, 140, 220, 48);

        btn_agenda3.setBackground(new java.awt.Color(231, 168, 95));
        btn_agenda3.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btn_agenda3.setForeground(new java.awt.Color(255, 255, 255));
        btn_agenda3.setText("EDITAR AGENDAMENTO");
        btn_agenda3.setBorder(null);
        btn_agenda3.setRequestFocusEnabled(false);
        btn_agenda3.setRolloverEnabled(false);
        btn_agenda3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agenda3ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_agenda3);
        btn_agenda3.setBounds(0, 190, 220, 48);

        btn_agenda4.setBackground(new java.awt.Color(231, 168, 95));
        btn_agenda4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_agenda4.setForeground(new java.awt.Color(255, 255, 255));
        btn_agenda4.setText("TABELA AGENDA");
        btn_agenda4.setBorder(null);
        btn_agenda4.setRequestFocusEnabled(false);
        btn_agenda4.setRolloverEnabled(false);
        btn_agenda4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agenda4ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_agenda4);
        btn_agenda4.setBounds(0, 240, 220, 48);

        btn_agenda5.setBackground(new java.awt.Color(255, 102, 51));
        btn_agenda5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_agenda5.setForeground(new java.awt.Color(255, 255, 255));
        btn_agenda5.setText("SAIR");
        btn_agenda5.setBorder(null);
        btn_agenda5.setRequestFocusEnabled(false);
        btn_agenda5.setRolloverEnabled(false);
        btn_agenda5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agenda5ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_agenda5);
        btn_agenda5.setBounds(0, 490, 220, 30);

        btn_agenda6.setBackground(new java.awt.Color(231, 168, 95));
        btn_agenda6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_agenda6.setForeground(new java.awt.Color(255, 255, 255));
        btn_agenda6.setText("TABELA CLIENTE");
        btn_agenda6.setBorder(null);
        btn_agenda6.setRequestFocusEnabled(false);
        btn_agenda6.setRolloverEnabled(false);
        btn_agenda6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agenda6ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_agenda6);
        btn_agenda6.setBounds(0, 290, 220, 48);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agendamento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agendamento1ActionPerformed
        CadastrarCliente agendament = new CadastrarCliente();
        agendament.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_agendamento1ActionPerformed

    private void btn_agenda3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agenda3ActionPerformed
        PesquisarAtualizarDeletarAgendamento agend = new PesquisarAtualizarDeletarAgendamento();
        agend.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_agenda3ActionPerformed

    private void btn_agenda4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agenda4ActionPerformed
        TabelaAgendamento agend = new TabelaAgendamento();
        agend.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_agenda4ActionPerformed

    private void btn_agenda5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agenda5ActionPerformed
        login agend = new login();
        agend.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_agenda5ActionPerformed

    private void btn_agenda6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agenda6ActionPerformed
        TabelaClienteInfo agend = new TabelaClienteInfo();
        agend.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_agenda6ActionPerformed

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
            java.util.logging.Logger.getLogger(TabelaAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabelaAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabelaAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabelaAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabelaAgendamento().setVisible(true);
            }
        });
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agenda3;
    private javax.swing.JButton btn_agenda4;
    private javax.swing.JButton btn_agenda5;
    private javax.swing.JButton btn_agenda6;
    private javax.swing.JButton btn_agendamento1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void listarValores(){
        try {
            TabelaAgenda agenda = new TabelaAgenda();
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);
            ArrayList<Agendamento> lista = agenda.PesquisarAgendamento();
            
            for(int num = 0; num < lista.size(); num ++){
                model.addRow(new Object[]{
                    lista.get(num).getNome(),
                    lista.get(num).getCpf(),
                    lista.get(num).getServico(),  
                    lista.get(num).getHora(), 
                    lista.get(num).getValor(),
                    lista.get(num).getAgenda()
                    
                    
                });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Algo errado aconteceu" + erro);
        }
    }

}
