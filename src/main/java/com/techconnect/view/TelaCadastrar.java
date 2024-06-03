/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.techconnect.view;

import com.techconnect.DAO.UsuarioDAO;
import com.techconnect.Usuario;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author thiag
 */
public class TelaCadastrar extends javax.swing.JFrame {

    private void limparCampos() {
        nomeTextField.setText("");
        idadeTextField.setText("");
        cpfTextField.setText("");
        emailTextField.setText("");
        loginTextField.setText("");
        senhaTextField.setText("");
        sexoComboBox.setSelectedIndex(0); // Assume que o índice 0 é o valor padrão
    }
    
    private boolean emptyFields() {
            boolean empty = true;

            if (nomeTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "ATENÇÃO! Nome não pode ser vazio.");
            } else if (idadeTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "ATENÇÃO! Idade não pode ser vazio.");
            } else if (cpfTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "ATENÇÃO! CPF não pode ser vazio.");
            } else if (emailTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "ATENÇÃO! Email não pode ser vazio.");
            } else if (loginTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "ATENÇÃO! Login não pode ser vazio.");
            } else if (senhaTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "ATENÇÃO! Senha não pode ser vazio.");
            } else {
                empty = false;
            }

            return empty;
        }

        private boolean strTestes() {

            boolean empty = true;
            
            Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
            Matcher emailMatcher = emailPattern.matcher(emailTextField.getText());
            
            if (cpfTextField.getText().matches("[0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][0-9]{2}") == false) {
                JOptionPane.showMessageDialog(rootPane, "ATENÇÃO! CPF tem que ser no formato XXX.XXX.XXX-XX");
            } else if (!emailMatcher.matches()) {
                JOptionPane.showMessageDialog(rootPane, "ATENÇÃO! E-mail deve estar no formato exemplo@dominio.com");
            } else {
                empty = false;
            }

            return empty;
        }
    
    /**
     * Creates new form TelaCadastrar
     */
    public TelaCadastrar() {
        
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        idadeTextField = new javax.swing.JTextField();
        cpfTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        botaoCadastrar = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        tituloTechConnect = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        loginTextField = new javax.swing.JTextField();
        senhaTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sexoComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(626, 578));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(java.awt.Color.black);
        jLabel3.setText("Cadastre-se");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.black);
        jLabel1.setText("Nome:");

        nomeTextField.setFont(new java.awt.Font("Dialog", 0, 19)); // NOI18N
        nomeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTextField(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.black);
        jLabel2.setText("Idade:");

        idadeTextField.setFont(new java.awt.Font("Dialog", 0, 19)); // NOI18N
        idadeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idadeTextField(evt);
            }
        });

        cpfTextField.setFont(new java.awt.Font("Dialog", 0, 19)); // NOI18N
        cpfTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfTextField(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.black);
        jLabel4.setText("CPF:");

        emailTextField.setFont(new java.awt.Font("Dialog", 0, 19)); // NOI18N
        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextField(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(java.awt.Color.black);
        jLabel5.setText("Email:");

        botaoCadastrar.setBackground(new java.awt.Color(102, 184, 16));
        botaoCadastrar.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        botaoCadastrar.setForeground(java.awt.Color.black);
        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.black, null, null));
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarbotaoCadastratActionPerformed(evt);
            }
        });

        botaoSair.setBackground(new java.awt.Color(255, 102, 102));
        botaoSair.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        botaoSair.setForeground(java.awt.Color.black);
        botaoSair.setText("Sair");
        botaoSair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.black, null, null));
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairbotaoCadastratActionPerformed(evt);
            }
        });

        tituloTechConnect.setBackground(java.awt.Color.black);
        tituloTechConnect.setFont(new java.awt.Font("Dialog", 1, 29)); // NOI18N
        tituloTechConnect.setForeground(java.awt.Color.black);
        tituloTechConnect.setText("Tech Connect");
        tituloTechConnect.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.black);
        jLabel6.setText("Sexo:");

        loginTextField.setFont(new java.awt.Font("Dialog", 0, 19)); // NOI18N
        loginTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginTextField(evt);
            }
        });

        senhaTextField.setFont(new java.awt.Font("Dialog", 0, 19)); // NOI18N
        senhaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaTextField(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.black);
        jLabel7.setText("Senha:");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setForeground(java.awt.Color.black);
        jLabel8.setText("Login:");

        sexoComboBox.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        sexoComboBox.setForeground(java.awt.Color.black);
        sexoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Trans", "Não binário", "Outro", "Prefiro não dizer" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(241, 241, 241))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tituloTechConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(212, 212, 212))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addComponent(cpfTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addComponent(idadeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addComponent(nomeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addComponent(senhaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addComponent(loginTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addComponent(sexoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tituloTechConnect)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(sexoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastrar)
                    .addComponent(botaoSair))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeTextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTextField
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTextField

    private void idadeTextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idadeTextField
        // TODO add your handling code here:
    }//GEN-LAST:event_idadeTextField

    private void cpfTextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfTextField
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfTextField

    private void emailTextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextField
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextField

    private void botaoCadastrarbotaoCadastratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarbotaoCadastratActionPerformed

        if (!emptyFields() && !strTestes()) {
            String nome = nomeTextField.getText();
            String idade = idadeTextField.getText();
            String cpf = cpfTextField.getText();
            String email = emailTextField.getText();
            String sexo = (String) sexoComboBox.getSelectedItem(); 
            String login = loginTextField.getText();
            String senha = senhaTextField.getText();

            Usuario usuario = new Usuario(nome, login, senha, idade, cpf, email, sexo);
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            boolean sucesso = usuarioDAO.cadastrarUsuario(usuario);

            if (sucesso) {
                JOptionPane.showMessageDialog(rootPane, "Usuário cadastrado com sucesso!");
                limparCampos(); // Limpa os campos após o cadastro
            } else {
                JOptionPane.showMessageDialog(rootPane, "Erro ao cadastrar usuário. Tente novamente.");
            }
        
    }
        
    }//GEN-LAST:event_botaoCadastrarbotaoCadastratActionPerformed

    private void botaoSairbotaoCadastratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairbotaoCadastratActionPerformed
        this.dispose();
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
    }//GEN-LAST:event_botaoSairbotaoCadastratActionPerformed

    private void loginTextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginTextField
        // TODO add your handling code here:
    }//GEN-LAST:event_loginTextField

    private void senhaTextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaTextField
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaTextField

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
            java.util.logging.Logger.getLogger(TelaCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JTextField cpfTextField;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTextField idadeTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField loginTextField;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JTextField senhaTextField;
    private javax.swing.JComboBox<String> sexoComboBox;
    private javax.swing.JLabel tituloTechConnect;
    // End of variables declaration//GEN-END:variables
}
/*eventoDAO eventoDAO = new eventoDAO();

        try {
            eventoDAO.cadastraEvento(nome, descricao, dataInicio, dataTermino);
            JOptionPane.showMessageDialog(null, "Evento Cadastrado com Sucesso!!!");
            nomeTextField.setText("");
            idadeTextField.setText("");
            cpfTextField.setText("");
            emailTextField.setText("");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar evento!!!");
        }*/