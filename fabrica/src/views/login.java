/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Color;
import connections.MySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import objects.LoginFuncionario;

/**
 *
 * @author annas
 */
public class Login extends javax.swing.JFrame {
    MySQL conectar = new MySQL();
    LoginFuncionario validaFuncionario = new LoginFuncionario();
    /**
     * Creates new form login
     */
    public Login() {
        initComponents();
    }
    
    private Boolean FuncionarioExistente(String usuario) throws SQLException{
        this.conectar.conectaBanco();
        
        
        String resultado = "";
        String comando = "SELECT email from funcionario where email = '" + usuario + "';";
                
        this.conectar.executarSQL(comando);
        
        while (this.conectar.getResultSet().next()) {
             resultado = this.conectar.getResultSet().getString(1);
             
             if(!resultado.equals("")) return true;
        }
                return false;
    }
    private Boolean Logar(String usuario, String senha) throws SQLException{
        
        this.conectar.conectaBanco();
        
        String usuarioBanco = "";
        String comando = "SELECT email from funcionario where email  = '" + usuario + "';";
                
        this.conectar.executarSQL(comando);
        
        while (this.conectar.getResultSet().next()) {
             usuarioBanco = this.conectar.getResultSet().getString(1);
        }
        System.out.println("USUARIO: " + usuarioBanco);
        String senhaBanco = "";
        comando = "Select senha from funcionario where senha = '" + usuario + "';";
        
        this.conectar.executarSQL(comando);
            while (this.conectar.getResultSet().next()) {
            senhaBanco = this.conectar.getResultSet().getString(1);
        }
            System.out.println("SENHA DO BANCO: " + senhaBanco);
        Boolean existe = FuncionarioExistente(usuario);
        if(existe){
            setLabel("USUARIO EXISTE", Color.yellow);
         if(usuario.equals(usuarioBanco) && senha.equals(senhaBanco)){
            return true;
            }
        }else{setLabel("USUARIO NÃO EXISTE", Color.yellow);}
       
        return false;
    }
    
    //essa função serve apenas para alterar a label de aviso
    private void setLabel(String texto, Color color){
                lbl_stats.setText(texto);
                lbl_stats.setForeground(color);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel2 = new java.awt.Panel();
        lbl_stats = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        txt_user = new javax.swing.JTextField();
        label4 = new java.awt.Label();
        canvas1 = new java.awt.Canvas();
        canvas2 = new java.awt.Canvas();
        btn_login = new javax.swing.JButton();
        btn_cadastrar = new javax.swing.JButton();
        txt_senha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setMinimumSize(new java.awt.Dimension(800, 637));
        setName("login"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        panel2.setBackground(new java.awt.Color(0, 63, 89));
        panel2.setForeground(new java.awt.Color(0, 25, 35));
        panel2.setMaximumSize(new java.awt.Dimension(32000, 32000));
        panel2.setName("login"); // NOI18N
        panel2.setLayout(null);

        lbl_stats.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        panel2.add(lbl_stats);
        lbl_stats.setBounds(180, 390, 200, 20);
        lbl_stats.getAccessibleContext().setAccessibleName("Status");

        label2.setText("label2");
        panel2.add(label2);
        label2.setBounds(0, 0, 0, 0);

        label3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("E-mail");
        panel2.add(label3);
        label3.setBounds(170, 200, 70, 25);

        txt_user.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        panel2.add(txt_user);
        txt_user.setBounds(170, 230, 488, 45);

        label4.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        label4.setForeground(new java.awt.Color(255, 255, 255));
        label4.setText("Senha");
        panel2.add(label4);
        label4.setBounds(170, 310, 70, 25);
        panel2.add(canvas1);
        canvas1.setBounds(0, 0, 0, 0);
        panel2.add(canvas2);
        canvas2.setBounds(0, 0, 0, 0);

        btn_login.setBackground(new java.awt.Color(240, 140, 23));
        btn_login.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("Entrar");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        panel2.add(btn_login);
        btn_login.setBounds(170, 460, 220, 40);

        btn_cadastrar.setBackground(new java.awt.Color(240, 140, 23));
        btn_cadastrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cadastrar.setText("Cadastrar-se");
        btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarActionPerformed(evt);
            }
        });
        panel2.add(btn_cadastrar);
        btn_cadastrar.setBounds(440, 460, 220, 40);
        panel2.add(txt_senha);
        txt_senha.setBounds(170, 340, 490, 40);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN");
        panel2.add(jLabel1);
        jLabel1.setBounds(360, 60, 120, 60);

        getContentPane().add(panel2);
        panel2.setBounds(0, 0, 810, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verificaUsuarios(LoginFuncionario validaFucFuncionario){
    this.conectar.conectaBanco();
    
    validaFucFuncionario.setEmail(txt_user.getText());
    validaFucFuncionario.setSenha(txt_senha.getText());
    
    try{
        String sql = ("SELECT * from funcionario where email=? and senha=?");
        
        PreparedStatement ps = conectar.getConn().prepareStatement(sql);
        
        ps.setString(1, txt_user.getText());        
        ps.setString(2, txt_senha.getText());
        
        ResultSet rs = ps.executeQuery();

       
        if(rs.next() && !txt_user.getText().equals("") && !txt_senha.getText().equals("")){
            TabelaAgendamento tela = new TabelaAgendamento();
            tela.setVisible(true);
            dispose();
            JOptionPane.showMessageDialog(null, "Bem vindo");
        }else {
           JOptionPane.showMessageDialog(null, "Email ou senha inválido");


        }
        
    } catch(Exception e){
        System.out.println(e);
    }
    }
    
    
    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        
        String email, senha;
        
        email = txt_user.getText();
        senha = txt_senha.getText(); 

        LoginFuncionario validaFuncionario = new LoginFuncionario();
        validaFuncionario.setEmail(email);
        validaFuncionario.setSenha(senha);
        
        verificaUsuarios(validaFuncionario);
        
        System.out.println("usuario: " + email);
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
       NovoLogin cadastrar = new NovoLogin();
        cadastrar.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_cadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JButton btn_login;
    private java.awt.Canvas canvas1;
    private java.awt.Canvas canvas2;
    private javax.swing.JLabel jLabel1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label lbl_stats;
    private java.awt.Panel panel2;
    private javax.swing.JPasswordField txt_senha;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
