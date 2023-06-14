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
import objects.Funcionario;

/**
 *
 * @author annas
 */
public class login extends javax.swing.JFrame {
    MySQL conectar = new MySQL();
    Funcionario validaFuncionario = new Funcionario();
    /**
     * Creates new form login
     */
    public login() {
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

        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        lbl_stats = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        txt_user = new javax.swing.JTextField();
        label4 = new java.awt.Label();
        txt_senha = new javax.swing.JTextField();
        btn_cadastrar = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        canvas1 = new java.awt.Canvas();
        canvas2 = new java.awt.Canvas();
        panel3 = new java.awt.Panel();
        label5 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setMinimumSize(new java.awt.Dimension(1142, 637));
        setName("login"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        panel1.setBackground(new java.awt.Color(0, 63, 89));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N
        jLabel1.setIconTextGap(0);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addContainerGap(308, Short.MAX_VALUE))
        );

        getContentPane().add(panel1);
        panel1.setBounds(-10, 0, 370, 640);

        panel2.setBackground(new java.awt.Color(250, 250, 250));
        panel2.setForeground(new java.awt.Color(0, 25, 35));
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
        label3.setText("E-mail");
        panel2.add(label3);
        label3.setBounds(180, 190, 70, 25);

        txt_user.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        panel2.add(txt_user);
        txt_user.setBounds(180, 230, 488, 45);

        label4.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        label4.setText("Senha");
        panel2.add(label4);
        label4.setBounds(180, 300, 70, 25);
        panel2.add(txt_senha);
        txt_senha.setBounds(180, 340, 488, 45);

        btn_cadastrar.setBackground(new java.awt.Color(255, 204, 204));
        btn_cadastrar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/cad.png"))); // NOI18N
        btn_cadastrar.setText("Cadastre-se");
        btn_cadastrar.setBorderPainted(false);
        btn_cadastrar.setContentAreaFilled(false);
        btn_cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cadastrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cadastrar.setIconTextGap(1);
        btn_cadastrar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_cadastrar.setMaximumSize(new java.awt.Dimension(230, 120));
        btn_cadastrar.setMinimumSize(new java.awt.Dimension(219, 120));
        btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarActionPerformed(evt);
            }
        });
        panel2.add(btn_cadastrar);
        btn_cadastrar.setBounds(450, 430, 196, 91);

        btn_login.setBackground(new java.awt.Color(255, 204, 204));
        btn_login.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/entrar.png"))); // NOI18N
        btn_login.setText("Entrar");
        btn_login.setBorderPainted(false);
        btn_login.setContentAreaFilled(false);
        btn_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_login.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_login.setIconTextGap(1);
        btn_login.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_login.setMaximumSize(new java.awt.Dimension(230, 120));
        btn_login.setMinimumSize(new java.awt.Dimension(219, 120));
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        panel2.add(btn_login);
        btn_login.setBounds(200, 430, 196, 91);
        panel2.add(canvas1);
        canvas1.setBounds(0, 0, 0, 0);
        panel2.add(canvas2);
        canvas2.setBounds(0, 0, 0, 0);

        panel3.setBackground(new java.awt.Color(0, 102, 102));
        panel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel3.setPreferredSize(new java.awt.Dimension(44, 5));

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );

        panel2.add(panel3);
        panel3.setBounds(430, 125, 35, 7);

        label5.setFont(new java.awt.Font("SansSerif", 0, 50)); // NOI18N
        label5.setText("Login");
        panel2.add(label5);
        label5.setBounds(339, 60, 127, 68);

        getContentPane().add(panel2);
        panel2.setBounds(360, 0, 780, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verificaUsuarios(Funcionario validaFucFuncionario){
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
            tabela tela = new tabela();
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

        Funcionario validaFuncionario = new Funcionario();
        validaFuncionario.setEmail(email);
        validaFuncionario.setSenha(senha);
        
        verificaUsuarios(validaFuncionario);
        
        System.out.println("usuario: " + email);
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
        newAccount cadastrar = new newAccount();
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
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
    private java.awt.Label label5;
    private java.awt.Label lbl_stats;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private javax.swing.JTextField txt_senha;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
