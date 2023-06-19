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
import objects.Agendamento;

/**
 *
 * @author annas
 */
public class PesquisarAtualizarDeletarAgendamento extends javax.swing.JFrame {
        MySQL conectar = new MySQL();
        Agendamento novoAgendamento = new Agendamento();
    /**
     * Creates new form agendamento
     */
    public PesquisarAtualizarDeletarAgendamento() {
        initComponents();
    }
    
    private void pesquisaNewAgendamento(Agendamento novoAgendamento){
    this.conectar.conectaBanco();
        
        String pesquisaNewAgendamento = txt_cpf.getText();
        
        
        try{
        this.conectar.executarSQL("SELECT "
            + "nome,"
            + "telefone,"
            + "endereco,"
            + "genero,"
            + "idade,"
            + "cpf"
            + " FROM"
            + " cliente"
            + " WHERE"
            + " cpf = '" + pesquisaNewAgendamento + "'" + ";"
           
                
        );
        
       
        while (this.conectar.getResultSet().next()){
            novoAgendamento.setNome(this.conectar.getResultSet().getString(1));
            novoAgendamento.setTelefone(this.conectar.getResultSet().getString(2));
            novoAgendamento.setEndereco(this.conectar.getResultSet().getString(3));
            novoAgendamento.setGenero(this.conectar.getResultSet().getString(4));
            novoAgendamento.setIdade(this.conectar.getResultSet().getString(5));
            novoAgendamento.setCpf(this.conectar.getResultSet().getString(6));
            
        }
        
         
       if(novoAgendamento.getCpf()==null)
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente!");
        } catch (Exception e){
            
            
            
        } finally{
            
            txt_nome.setText(novoAgendamento.getNome());
            txt_telefone.setText(novoAgendamento.getTelefone());
            txt_endereco.setText(novoAgendamento.getEndereco());
            cmb_genero.setSelectedItem(novoAgendamento.getGenero());
            cmb_idade.setSelectedItem(novoAgendamento.getIdade());
            txt_cpf.setText(novoAgendamento.getCpf());

            this.conectar.fechaBanco();
            
                
        } 
        this.conectar.conectaBanco();
        
        String pesquisaNewAgendamento1 = txt_cpf.getText();
        try{
        this.conectar.executarSQL("SELECT "
            + "nome,"
            + "cpf,"
            + "servico,"
            + "hora,"
            + "valor,"
            + "agenda"
            + " FROM"
            + " agendamento"
            + " WHERE"
            + " cpf = '" + pesquisaNewAgendamento + "'" + ";"
           
                
        );
        
       
        while (this.conectar.getResultSet().next()){
            novoAgendamento.setNome(this.conectar.getResultSet().getString(1));
            novoAgendamento.setCpf(this.conectar.getResultSet().getString(2));
            novoAgendamento.setServico(this.conectar.getResultSet().getString(3));
            novoAgendamento.setHora(this.conectar.getResultSet().getString(4));
            novoAgendamento.setValor(this.conectar.getResultSet().getString(5));
            novoAgendamento.setAgenda(this.conectar.getResultSet().getString(6));
            
        }
        
         
       if(novoAgendamento.getCpf()==null)
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente!");
        } catch (Exception e){
            
            
            
        } finally{
            
            txt_nome.setText(novoAgendamento.getNome());
            txt_cpf.setText(novoAgendamento.getCpf());
            txt_servico.setSelectedItem(novoAgendamento.getServico());
            cmb_hora.setSelectedItem(novoAgendamento.getHora());
            txt_valor.setSelectedItem(novoAgendamento.getValor());
            txt_cpf.setText(novoAgendamento.getCpf());

            this.conectar.fechaBanco();
            
                
        } 

    }
          

    private void deletaAgendamento(Agendamento novoAgendamento ){
        this.conectar.conectaBanco();

        String pesquisaNewAgendamento = this.txt_cpf.getText();
        
            novoAgendamento.setNome(txt_nome.getText());
            novoAgendamento.setTelefone(txt_telefone.getText());
            novoAgendamento.setServico((String)txt_servico.getSelectedItem());
            novoAgendamento.setValor((String)txt_valor.getSelectedItem());
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
            txt_nome.setText("");
            txt_telefone.setText("");
            txt_servico.setSelectedItem("");
            txt_valor.setSelectedItem("");
            txt_agenda.setText("");
            txt_cpf.setText("");
            cmb_genero.setSelectedItem("");
            cmb_idade.setSelectedItem("");
            txt_endereco.setText("");
            novoAgendamento.setNome("");
            novoAgendamento.setTelefone("");
            novoAgendamento.setServico("");
            novoAgendamento.setHora("");
            novoAgendamento.setValor("");
            novoAgendamento.setAgenda("");
            novoAgendamento.setCpf("");
            novoAgendamento.setGenero("");
            novoAgendamento.setIdade("");
            novoAgendamento.setEndereco("");

            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Agendamento e Usuario Deletado!");
        }    

    }
     
    private void atualizaAgendamento(Agendamento novoAgendamento ){
        this.conectar.conectaBanco();

        String pesquisaNewAgendamento = this.txt_cpf.getText();
            Date d = null;
            DateFormat data = new SimpleDateFormat("dd/MM/yyyy" );
             try{
                d = data.parse(data.format(jCalendar1.getDate()));
                
                
            } catch(Exception e){
                   e.printStackTrace();
               }
            novoAgendamento.setNome(txt_nome.getText());
            novoAgendamento.setCpf(txt_cpf.getText());
            novoAgendamento.setServico((String)txt_servico.getSelectedItem());
            novoAgendamento.setHora((String)cmb_hora.getSelectedItem());
            novoAgendamento.setValor((String)txt_valor.getSelectedItem());
            novoAgendamento.setAgenda(data.format(d));
            try{
            this.conectar.insertSQL("INSERT INTO agendamento("
            + "nome,"
            + "cpf,"
            + "servico,"
            + "hora,"
            + "valor,"
            + "agenda"
            + ")VALUES("
            + "'" +novoAgendamento.getNome()+"',"
            + "'" +novoAgendamento.getCpf()+"',"
            + "'" +novoAgendamento.getServico()+"',"
            + "'" +novoAgendamento.getHora()+ "',"
            + "'" +novoAgendamento.getValor()+ "',"
            + "'" +novoAgendamento.getAgenda()+ "'" 
            + ");");

            this.conectar.updateSQL(
            " UPDATE agendamento SET "
            + " servico = '" + novoAgendamento.getServico()+"'"
            + ", hora = '" + novoAgendamento.getHora()+"'"
            + ", valor = '" + novoAgendamento.getValor()+"'"
            + ", agenda = '" + novoAgendamento.getAgenda()+"'"
            );
              
        }catch(Exception e){
            System.out.println("Erro ao atualizar agendamento" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar agendamento");
            
        }finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Agendamento atualizado!");
        }   
    }
        
    private void atualizaAgendamento1(Agendamento novoAgendamento ){
        this.conectar.conectaBanco();

        String pesquisaNewAgendamento = this.txt_cpf.getText();
            novoAgendamento.setNome(txt_nome.getText());
            novoAgendamento.setTelefone(txt_telefone.getText());
            novoAgendamento.setEndereco(txt_endereco.getText());
            novoAgendamento.setGenero((String)cmb_genero.getSelectedItem());
            novoAgendamento.setIdade((String)cmb_idade.getSelectedItem());
            novoAgendamento.setCpf(txt_cpf.getText());
            
            try{
            this.conectar.updateSQL(
            " UPDATE cliente SET "
            + " nome = '" + novoAgendamento.getNome()+"'"
            + ", telefone = '" + novoAgendamento.getTelefone()+"'"
            + ", endereco = '" + novoAgendamento.getEndereco()+"'"
            + ", genero = '" + novoAgendamento.getGenero()+"'"
            + ", idade = '" + novoAgendamento.getIdade()+"'"
            + ", cpf = '" + novoAgendamento.getCpf()+"'"
            + " WHERE"
            + " cpf = '"+ pesquisaNewAgendamento + "'" + ";"
            );
        }catch(Exception e){
       
        }finally{
            this.conectar.fechaBanco();
            
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
        btn_agenda6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_altera = new javax.swing.JButton();
        btn_deleta = new javax.swing.JButton();
        txt_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_agenda = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmb_hora = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btn_pesquisa = new javax.swing.JButton();
        txt_servico = new javax.swing.JComboBox<>();
        txt_telefone = new javax.swing.JFormattedTextField();
        txt_cpf = new javax.swing.JFormattedTextField();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        txt_valor = new javax.swing.JComboBox<>();
        txt_endereco = new javax.swing.JTextField();
        jLabel_Servico = new javax.swing.JLabel();
        cmb_genero = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmb_idade = new javax.swing.JComboBox<>();

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
        btn_agenda2.setText("TABELA AGENDA");
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
        jPanel1.add(btn_agenda6);
        btn_agenda6.setBounds(0, 290, 220, 48);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 220, 590);

        jPanel2.setBackground(new java.awt.Color(0, 63, 89));
        jPanel2.setMinimumSize(new java.awt.Dimension(870, 620));
        jPanel2.setLayout(null);

        btn_altera.setBackground(new java.awt.Color(0, 102, 0));
        btn_altera.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_altera.setForeground(new java.awt.Color(255, 255, 255));
        btn_altera.setText("Cadastrar");
        btn_altera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alteraActionPerformed(evt);
            }
        });
        jPanel2.add(btn_altera);
        btn_altera.setBounds(330, 480, 130, 40);

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
        btn_deleta.setBounds(490, 480, 130, 40);
        jPanel2.add(txt_nome);
        txt_nome.setBounds(40, 70, 230, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 50, 90, 16);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Telefone:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(40, 170, 90, 16);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Idade:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(40, 360, 80, 16);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Valor:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(520, 360, 100, 16);

        txt_agenda.setEnabled(false);
        txt_agenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_agendaActionPerformed(evt);
            }
        });
        jPanel2.add(txt_agenda);
        txt_agenda.setBounds(300, 320, 200, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Horário");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(520, 300, 160, 16);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CPF:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(40, 110, 50, 16);

        cmb_hora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:00", "9:00", "10:00", "11:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00" }));
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
        cmb_hora.setBounds(520, 320, 200, 30);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Data:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(300, 300, 160, 16);

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
        btn_pesquisa.setBounds(170, 480, 130, 40);

        txt_servico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cabelo Masculino", "Pezinho", "Barba", "Cabelo Masculino & Barba", "Barba & Pezinho", "Cabelo Feminino", "Sobrancelha", "Cilios", "Cabelo F & Sobrancelha", "Cabelo F & Cilios", "Cabelo F & Sobrancelha & Cilios", "Sobrancelha & Cilios" }));
        jPanel2.add(txt_servico);
        txt_servico.setBounds(300, 380, 200, 30);

        try {
            txt_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(txt_telefone);
        txt_telefone.setBounds(40, 190, 230, 30);

        try {
            txt_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(txt_cpf);
        txt_cpf.setBounds(40, 130, 230, 30);
        jPanel2.add(jCalendar1);
        jCalendar1.setBounds(300, 70, 420, 220);

        txt_valor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "R$ 10,00", "R$ 20,00", "R$ 30,00", "R$ 40,00", "R$ 50,00", "R$ 60,00", "R$ 70,00", "R$ 80,00", "R$ 90,00", "R$ 100,00", "R$ 110,00", "R$ 120,00", "R$ 130,00", "R$ 140,00", "R$ 150,00", "R$ 150,00", "R$ 160,00", "R$ 170,00", "R$ 180,00", "R$ 190,00", "R$ 200,00", "R$ 210,00", "R$ 220,00", "R$ 230,00", "R$ 240,00", "R$ 250,00", "R$ 260,00", "R$ 270,00", "R$ 280,00", "R$ 290,00", "R$ 300,00" }));
        txt_valor.setFocusable(false);
        txt_valor.setLightWeightPopupEnabled(false);
        txt_valor.setRequestFocusEnabled(false);
        txt_valor.setVerifyInputWhenFocusTarget(false);
        txt_valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_valorActionPerformed(evt);
            }
        });
        jPanel2.add(txt_valor);
        txt_valor.setBounds(520, 380, 200, 30);
        jPanel2.add(txt_endereco);
        txt_endereco.setBounds(40, 260, 230, 30);

        jLabel_Servico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_Servico.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Servico.setText("Endereço:");
        jPanel2.add(jLabel_Servico);
        jLabel_Servico.setBounds(40, 240, 70, 20);

        cmb_genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));
        cmb_genero.setFocusable(false);
        cmb_genero.setLightWeightPopupEnabled(false);
        cmb_genero.setRequestFocusEnabled(false);
        cmb_genero.setVerifyInputWhenFocusTarget(false);
        cmb_genero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_generoActionPerformed(evt);
            }
        });
        jPanel2.add(cmb_genero);
        cmb_genero.setBounds(40, 320, 230, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Serviço:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(300, 360, 80, 16);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Gênero:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(40, 300, 80, 16);

        cmb_idade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120" }));
        cmb_idade.setFocusable(false);
        cmb_idade.setLightWeightPopupEnabled(false);
        cmb_idade.setRequestFocusEnabled(false);
        cmb_idade.setVerifyInputWhenFocusTarget(false);
        cmb_idade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_idadeActionPerformed(evt);
            }
        });
        jPanel2.add(cmb_idade);
        cmb_idade.setBounds(40, 380, 230, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(220, 0, 770, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agendamentoActionPerformed
       CadastrarCliente agendament = new CadastrarCliente();
       agendament.setVisible(true);
       dispose();
    }//GEN-LAST:event_btn_agendamentoActionPerformed

    private void btn_alteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alteraActionPerformed
        DateFormat teste = new SimpleDateFormat("dd/MM/yyyy" );
        atualizaAgendamento(novoAgendamento);
        atualizaAgendamento1(novoAgendamento);

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
        PesquisarAtualizarDeletarAgendamento agend = new PesquisarAtualizarDeletarAgendamento();
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
        TabelaAgendamento agend = new TabelaAgendamento();
        agend.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_agenda2ActionPerformed

    private void btn_agenda3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agenda3ActionPerformed
        login agend = new login();
        agend.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_agenda3ActionPerformed

    private void txt_valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_valorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valorActionPerformed

    private void btn_agenda6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agenda6ActionPerformed
        TabelaClienteInfo agend = new TabelaClienteInfo();
        agend.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_agenda6ActionPerformed

    private void cmb_generoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_generoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_generoActionPerformed

    private void cmb_idadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_idadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_idadeActionPerformed

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
            java.util.logging.Logger.getLogger(PesquisarAtualizarDeletarAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisarAtualizarDeletarAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisarAtualizarDeletarAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisarAtualizarDeletarAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisarAtualizarDeletarAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agenda1;
    private javax.swing.JButton btn_agenda2;
    private javax.swing.JButton btn_agenda3;
    private javax.swing.JButton btn_agenda6;
    private javax.swing.JButton btn_agendamento;
    private javax.swing.JButton btn_altera;
    private javax.swing.JButton btn_deleta;
    private javax.swing.JButton btn_pesquisa;
    private javax.swing.JComboBox<String> cmb_genero;
    private javax.swing.JComboBox<String> cmb_hora;
    private javax.swing.JComboBox<String> cmb_idade;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Servico;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_agenda;
    private javax.swing.JFormattedTextField txt_cpf;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JComboBox<String> txt_servico;
    private javax.swing.JFormattedTextField txt_telefone;
    private javax.swing.JComboBox<String> txt_valor;
    // End of variables declaration//GEN-END:variables

    
}
