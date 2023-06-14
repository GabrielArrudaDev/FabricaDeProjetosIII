/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import javax.swing.JOptionPane;
import connections.MySQL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import objects.AgendamentoAnimal;

/**
 *
 * @author annas
 */
public class agenda extends javax.swing.JFrame {
        MySQL conectar = new MySQL();
        AgendamentoAnimal novoAgendamento = new AgendamentoAnimal();
    /**
     * Creates new form agendamento
     */
    public agenda() {
        initComponents();
    }
    
    private void pesquisaNewAgendamento(AgendamentoAnimal novoAgendamento){
    this.conectar.conectaBanco();
        
        String pesquisaNewAgendamento = txt_cpf.getText();
        
        
        try{
        this.conectar.executarSQL("SELECT "
            + "nomeDono,"
            + "nomeAnimal,"
            + "telefone,"
            + "animal,"
            + "servico,"
            + "hora,"
            + "kilos,"
            + "agenda,"
            + "cpf"
            + " FROM"
            + " agendamento"
            + " WHERE"
            + " cpf = '" + pesquisaNewAgendamento + "'" + ";"
                
        );
        while (this.conectar.getResultSet().next()){
            novoAgendamento.setNomeDono(this.conectar.getResultSet().getString(1));
            novoAgendamento.setNomeAnimal(this.conectar.getResultSet().getString(2));
            novoAgendamento.setTelefone(this.conectar.getResultSet().getString(3));
            novoAgendamento.setAnimal(this.conectar.getResultSet().getString(4));
            novoAgendamento.setServico(this.conectar.getResultSet().getString(5));
            novoAgendamento.setHora(this.conectar.getResultSet().getString(6));
            novoAgendamento.setKilos(this.conectar.getResultSet().getString(7));
            novoAgendamento.setAgenda(this.conectar.getResultSet().getString(8));
            novoAgendamento.setCpf(this.conectar.getResultSet().getString(9));
            
        }
         
       if(novoAgendamento.getCpf()==null)
            JOptionPane.showMessageDialog(null, "Erro ao buscar funcionário!");
        } catch (Exception e){
            
            
            
        } finally{
            
            txt_nome_dono.setText(novoAgendamento.getNomeDono());
            txt_nome_animal.setText(novoAgendamento.getNomeAnimal());
            txt_telefone.setText(novoAgendamento.getTelefone());
            txt_animal.setSelectedItem(novoAgendamento.getAnimal());
            txt_servico.setSelectedItem(novoAgendamento.getServico());
            cmb_hora.setSelectedItem(novoAgendamento.getHora());
            txt_kilos.setSelectedItem(novoAgendamento.getKilos());
            txt_agenda.setText(novoAgendamento.getAgenda());
            txt_cpf.setText(novoAgendamento.getCpf());

            this.conectar.fechaBanco();
            
                
        } 

    }
    
        
                  

    private void deletaAgendamento(AgendamentoAnimal novoAgendamento ){
        this.conectar.conectaBanco();

        String pesquisaNewAgendamento = this.txt_cpf.getText();
        
            novoAgendamento.setNomeDono(txt_nome_dono.getText());
            novoAgendamento.setNomeAnimal(txt_nome_animal.getText());
            novoAgendamento.setTelefone(txt_telefone.getText());
            novoAgendamento.setAnimal((String)txt_animal.getSelectedItem());
            novoAgendamento.setServico((String)txt_servico.getSelectedItem());
            novoAgendamento.setKilos((String) txt_kilos.getSelectedItem());
            novoAgendamento.setAgenda(txt_agenda.getText());
            novoAgendamento.setCpf(txt_cpf.getText());

        try{
            this.conectar.updateSQL(
            " DELETE FROM agendamento"
            + " WHERE"
            + " cpf = '" + pesquisaNewAgendamento + "'"
            );
        }catch(Exception e){
            
            
        }finally{
            txt_nome_dono.setText("");
            txt_nome_animal.setText("");
            txt_telefone.setText("");
            txt_animal.setSelectedItem("");
            txt_servico.setSelectedItem("");
            txt_kilos.setSelectedItem("");
            txt_agenda.setText("");
            txt_cpf.setText("");
            novoAgendamento.setNomeDono("");
            novoAgendamento.setNomeAnimal("");
            novoAgendamento.setTelefone("");
            novoAgendamento.setAnimal("");
            novoAgendamento.setServico("");
            novoAgendamento.setHora("");
            novoAgendamento.setKilos("");
            novoAgendamento.setAgenda("");
            novoAgendamento.setCpf("");



            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Agendamento e Usuario Deletado!");
        }    

    }
     
    private void atualizaAgendamento(AgendamentoAnimal novoAgendamento ){
        this.conectar.conectaBanco();

        String pesquisaNewAgendamento = this.txt_cpf.getText();
            Date d = null;
            DateFormat data = new SimpleDateFormat("dd/MM/yyyy" );
             try{
                d = data.parse(data.format(jCalendar1.getDate()));
                
                
            } catch(Exception e){
                   e.printStackTrace();
               }
            novoAgendamento.setNomeDono(txt_nome_dono.getText());
            novoAgendamento.setTelefone(txt_telefone.getText());
            novoAgendamento.setServico((String)txt_servico.getSelectedItem());
            novoAgendamento.setHora((String)cmb_hora.getSelectedItem());
            novoAgendamento.setKilos((String)txt_kilos.getSelectedItem());
            
            novoAgendamento.setAgenda(data.format(d));
        try{
            this.conectar.updateSQL(
            " UPDATE agendamento SET "
            + " nomeDono = '" + novoAgendamento.getNomeDono()+"'"
            + ", telefone = '" + novoAgendamento.getTelefone()+"'"
            + ", servico = '" + novoAgendamento.getServico()+"'"
            + ", hora = '" + novoAgendamento.getHora()+"'"
            + ", kilos = '" + novoAgendamento.getKilos()+"'"
            + ", agenda = '" + novoAgendamento.getAgenda()+"'"
            + ", cpf = '" + novoAgendamento.getCpf()+"'"
            + " WHERE"
            + " cpf = '"+ pesquisaNewAgendamento + "'" + ";"
            );
        }catch(Exception e){
            System.out.println("Erro ao atualizar agendamento" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar agendamento");
            
        }finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Agendamento atualizado!");
        }    

    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_agendamento = new javax.swing.JButton();
        btn_agenda1 = new javax.swing.JButton();
        btn_agenda2 = new javax.swing.JButton();
        btn_agenda3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_altera = new javax.swing.JButton();
        btn_deleta = new javax.swing.JButton();
        txt_nome_animal = new javax.swing.JTextField();
        txt_nome_dono = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_agenda = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmb_hora = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btn_pesquisa = new javax.swing.JButton();
        txt_kilos = new javax.swing.JComboBox<>();
        txt_animal = new javax.swing.JComboBox<>();
        txt_servico = new javax.swing.JComboBox<>();
        txt_telefone = new javax.swing.JFormattedTextField();
        txt_cpf = new javax.swing.JFormattedTextField();
        jCalendar1 = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(984, 618));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(240, 140, 23));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EDITAR");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 70, 220, 30);

        btn_agendamento.setBackground(new java.awt.Color(231, 168, 95));
        btn_agendamento.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btn_agendamento.setForeground(new java.awt.Color(255, 255, 255));
        btn_agendamento.setText("NOVO AGENDAMENTO");
        btn_agendamento.setBorder(null);
        btn_agendamento.setBorderPainted(false);
        btn_agendamento.setFocusPainted(false);
        btn_agendamento.setFocusable(false);
        btn_agendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agendamentoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agendamento);
        btn_agendamento.setBounds(0, 140, 220, 48);

        btn_agenda1.setBackground(new java.awt.Color(231, 168, 95));
        btn_agenda1.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btn_agenda1.setForeground(new java.awt.Color(255, 255, 255));
        btn_agenda1.setText("EDITAR AGENDAMENTO");
        btn_agenda1.setBorder(null);
        btn_agenda1.setRequestFocusEnabled(false);
        btn_agenda1.setRolloverEnabled(false);
        btn_agenda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agenda1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agenda1);
        btn_agenda1.setBounds(0, 190, 220, 48);

        btn_agenda2.setBackground(new java.awt.Color(231, 168, 95));
        btn_agenda2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_agenda2.setForeground(new java.awt.Color(255, 255, 255));
        btn_agenda2.setText("AGENDA");
        btn_agenda2.setBorder(null);
        btn_agenda2.setRequestFocusEnabled(false);
        btn_agenda2.setRolloverEnabled(false);
        btn_agenda2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agenda2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agenda2);
        btn_agenda2.setBounds(0, 240, 220, 48);

        btn_agenda3.setBackground(new java.awt.Color(255, 102, 51));
        btn_agenda3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_agenda3.setForeground(new java.awt.Color(255, 255, 255));
        btn_agenda3.setText("SAIR");
        btn_agenda3.setBorder(null);
        btn_agenda3.setRequestFocusEnabled(false);
        btn_agenda3.setRolloverEnabled(false);
        btn_agenda3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agenda3ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agenda3);
        btn_agenda3.setBounds(0, 490, 220, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 220, 620);

        jPanel2.setBackground(new java.awt.Color(0, 63, 89));
        jPanel2.setMinimumSize(new java.awt.Dimension(870, 620));
        jPanel2.setLayout(null);

        btn_altera.setBackground(new java.awt.Color(0, 102, 0));
        btn_altera.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_altera.setForeground(new java.awt.Color(255, 255, 255));
        btn_altera.setText("Alterar");
        btn_altera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alteraActionPerformed(evt);
            }
        });
        jPanel2.add(btn_altera);
        btn_altera.setBounds(190, 480, 130, 40);

        btn_deleta.setBackground(new java.awt.Color(255, 51, 51));
        btn_deleta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_deleta.setForeground(new java.awt.Color(255, 255, 255));
        btn_deleta.setText("Apagar");
        btn_deleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deletaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_deleta);
        btn_deleta.setBounds(340, 480, 130, 40);
        jPanel2.add(txt_nome_animal);
        txt_nome_animal.setBounds(160, 310, 110, 30);
        jPanel2.add(txt_nome_dono);
        txt_nome_dono.setBounds(40, 70, 230, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 50, 90, 16);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Telefone:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(40, 230, 90, 16);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Serviço:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(40, 170, 80, 16);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Animal:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(40, 350, 70, 16);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nome animal:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(160, 290, 110, 16);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Peso do animal:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(40, 290, 100, 16);

        txt_agenda.setEnabled(false);
        txt_agenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_agendaActionPerformed(evt);
            }
        });
        jPanel2.add(txt_agenda);
        txt_agenda.setBounds(300, 310, 200, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Horário");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(520, 290, 160, 16);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CPF:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(40, 110, 50, 16);

        cmb_hora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:00", "9:00", "10:00", "11:00", "13:00", "14:00", "15:00", "16:00" }));
        cmb_hora.setFocusable(false);
        cmb_hora.setLightWeightPopupEnabled(false);
        cmb_hora.setRequestFocusEnabled(false);
        cmb_hora.setVerifyInputWhenFocusTarget(false);
        cmb_hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_horaActionPerformed(evt);
            }
        });
        jPanel2.add(cmb_hora);
        cmb_hora.setBounds(520, 310, 200, 30);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Data:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(300, 290, 160, 16);

        btn_pesquisa.setBackground(new java.awt.Color(240, 140, 23));
        btn_pesquisa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_pesquisa.setForeground(new java.awt.Color(255, 255, 255));
        btn_pesquisa.setText("Pesquisar");
        btn_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_pesquisa);
        btn_pesquisa.setBounds(40, 480, 130, 40);

        txt_kilos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0-5 KG", "5-10 KG", "10-15 KG", "15-20 KG", "20-25 KG", "25-30 KG", "30+" }));
        jPanel2.add(txt_kilos);
        txt_kilos.setBounds(40, 310, 100, 30);

        txt_animal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gato", "Cachorro" }));
        jPanel2.add(txt_animal);
        txt_animal.setBounds(40, 370, 230, 30);

        txt_servico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banho", "Tosa", "Banho & Tosa" }));
        jPanel2.add(txt_servico);
        txt_servico.setBounds(40, 190, 230, 30);

        try {
            txt_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(txt_telefone);
        txt_telefone.setBounds(40, 250, 230, 30);

        try {
            txt_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(txt_cpf);
        txt_cpf.setBounds(40, 130, 230, 30);
        jPanel2.add(jCalendar1);
        jCalendar1.setBounds(300, 70, 420, 220);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(220, 0, 770, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agendamentoActionPerformed
       newAgendamento agendament = new newAgendamento();
       agendament.setVisible(true);
       dispose();
    }//GEN-LAST:event_btn_agendamentoActionPerformed

    private void btn_alteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alteraActionPerformed
        DateFormat teste = new SimpleDateFormat("dd/MM/yyyy" );
        atualizaAgendamento(novoAgendamento);

        Date dl = null;
        try{
            dl = teste.parse(teste.format(jCalendar1.getDate()));
        } catch(Exception e){
            e.printStackTrace();
        }

        txt_agenda.setText(teste.format(dl));        
    }//GEN-LAST:event_btn_alteraActionPerformed

    private void btn_deletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deletaActionPerformed
        deletaAgendamento(novoAgendamento);
    }//GEN-LAST:event_btn_deletaActionPerformed

    private void cmb_horaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_horaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_horaActionPerformed

    private void btn_agenda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agenda1ActionPerformed
        agenda agend = new agenda();
        agend.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_agenda1ActionPerformed

    private void btn_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisaActionPerformed
        pesquisaNewAgendamento(novoAgendamento);
         if(novoAgendamento.getCpf()=="")
            JOptionPane.showMessageDialog(null, "Erro ao buscar funcionário!");
    }//GEN-LAST:event_btn_pesquisaActionPerformed

    private void txt_agendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_agendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_agendaActionPerformed

    private void btn_agenda2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agenda2ActionPerformed
        tabela agend = new tabela();
        agend.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_agenda2ActionPerformed

    private void btn_agenda3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agenda3ActionPerformed
        login agend = new login();
        agend.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_agenda3ActionPerformed

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
            java.util.logging.Logger.getLogger(agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agenda1;
    private javax.swing.JButton btn_agenda2;
    private javax.swing.JButton btn_agenda3;
    private javax.swing.JButton btn_agendamento;
    private javax.swing.JButton btn_altera;
    private javax.swing.JButton btn_deleta;
    private javax.swing.JButton btn_pesquisa;
    private javax.swing.JComboBox<String> cmb_hora;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_agenda;
    private javax.swing.JComboBox<String> txt_animal;
    private javax.swing.JFormattedTextField txt_cpf;
    private javax.swing.JComboBox<String> txt_kilos;
    private javax.swing.JTextField txt_nome_animal;
    private javax.swing.JTextField txt_nome_dono;
    private javax.swing.JComboBox<String> txt_servico;
    private javax.swing.JFormattedTextField txt_telefone;
    // End of variables declaration//GEN-END:variables

    
}
