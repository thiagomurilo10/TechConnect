/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.techconnect.view;

import com.techconnect.DAO.EventoDAO;
import com.techconnect.Evento;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thiag
 */
public class TelaUsuario extends javax.swing.JFrame {
    
    private EventoDAO eventoDAO;

    public TelaUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        eventoDAO = new EventoDAO(); // Instância do DAO
    }
    
    private void carregarEventos(String ordenacao) {
        List<Evento> eventos = eventoDAO.buscarEventos(ordenacao);
        DefaultTableModel model = (DefaultTableModel) tblEvento.getModel();
        model.setRowCount(0); // Limpa a tabela

        for (Evento evento : eventos) {
            if (evento.getDataFinal().after(new Date())) {
                model.addRow(new Object[]{
                    evento.getId(),
                    evento.getNome(),
                    evento.getDescricao(),
                    evento.getDataInicio(),
                    evento.getDataFinal()
                });
            }
        }
    }

    private void buscarEventosPorNome(String nome) {
        
        var eventos = eventoDAO.buscarEventosPorNome(nome);
        DefaultTableModel model = (DefaultTableModel) tblEvento.getModel();
        model.setRowCount(0); // Limpa a tabela

        for (Evento evento : eventos) {
            model.addRow(new Object[]{
                evento.getId(),
                evento.getNome(),
                evento.getDescricao(),
                evento.getDataInicio(),
                evento.getDataFinal()
            });
        }
    }

    private void buscarEventosPorData(String data) {
        if (data == null || data.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha uma data válida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            java.sql.Date sqlDate = java.sql.Date.valueOf(data);
            List<Evento> eventos = eventoDAO.buscarEventosPorData(sqlDate);
            DefaultTableModel model = (DefaultTableModel) tblEvento.getModel();
            model.setRowCount(0); // Limpa a tabela

            for (Evento evento : eventos) {
                model.addRow(new Object[]{
                        evento.getId(),
                        evento.getNome(),
                        evento.getDescricao(),
                        evento.getDataInicio(),
                        evento.getDataFinal()
                });
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha uma data válida.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
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
        tituloTechConnect = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nomePesquisarTextField = new javax.swing.JTextField();
        botaoPesquisarNome = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEvento = new javax.swing.JTable();
        botaoSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        dataPesquisarTextField = new javax.swing.JTextField();
        botaoPesquisarData = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(626, 578));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(java.awt.Color.black);
        jLabel3.setText("Listagem de eventos disponíveis");

        tituloTechConnect.setBackground(java.awt.Color.black);
        tituloTechConnect.setFont(new java.awt.Font("Dialog", 1, 29)); // NOI18N
        tituloTechConnect.setForeground(java.awt.Color.black);
        tituloTechConnect.setText("Tech Connect");
        tituloTechConnect.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 19)); // NOI18N
        jLabel1.setForeground(java.awt.Color.black);
        jLabel1.setText("Pesquisar evento por nome:");

        nomePesquisarTextField.setFont(new java.awt.Font("Dialog", 0, 19)); // NOI18N
        nomePesquisarTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomePesquisarTextField(evt);
            }
        });

        botaoPesquisarNome.setBackground(new java.awt.Color(9, 148, 206));
        botaoPesquisarNome.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        botaoPesquisarNome.setForeground(java.awt.Color.black);
        botaoPesquisarNome.setText("Pesquisar");
        botaoPesquisarNome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.black, null, null));
        botaoPesquisarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarNomebotaoCadastratActionPerformed(evt);
            }
        });

        tblEvento.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        tblEvento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do evento", "Descrição", "Data de início", "Data de término"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEvento);

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

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 19)); // NOI18N
        jLabel2.setForeground(java.awt.Color.black);
        jLabel2.setText("Ordenar pela data de início (até o dia atual):");

        dataPesquisarTextField.setFont(new java.awt.Font("Dialog", 0, 19)); // NOI18N
        dataPesquisarTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataPesquisarTextField(evt);
            }
        });

        botaoPesquisarData.setBackground(new java.awt.Color(9, 148, 206));
        botaoPesquisarData.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        botaoPesquisarData.setForeground(java.awt.Color.black);
        botaoPesquisarData.setText("Pesquisar");
        botaoPesquisarData.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.black, null, null));
        botaoPesquisarData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarDatabotaoCadastratActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel4.setForeground(java.awt.Color.black);
        jLabel4.setText("OBS: (no formato YYYY-MM-DD por favor)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(339, 339, 339))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel4)))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(nomePesquisarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(dataPesquisarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                        .addComponent(botaoPesquisarData, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(botaoPesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1))
                        .addGap(21, 21, 21))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tituloTechConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(348, 348, 348))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(261, 261, 261))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(tituloTechConnect)
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomePesquisarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisarNome))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dataPesquisarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisarData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(botaoSair)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomePesquisarTextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomePesquisarTextField
        // TODO add your handling code here:
    }//GEN-LAST:event_nomePesquisarTextField

    private void botaoPesquisarNomebotaoCadastratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarNomebotaoCadastratActionPerformed
        String nome = nomePesquisarTextField.getText();
        buscarEventosPorNome(nome);
        carregarEventos("nome");
    }//GEN-LAST:event_botaoPesquisarNomebotaoCadastratActionPerformed

    private void botaoSairbotaoCadastratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairbotaoCadastratActionPerformed
        this.dispose();
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
    }//GEN-LAST:event_botaoSairbotaoCadastratActionPerformed

    private void dataPesquisarTextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataPesquisarTextField
        // TODO add your handling code here:
    }//GEN-LAST:event_dataPesquisarTextField

    private void botaoPesquisarDatabotaoCadastratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarDatabotaoCadastratActionPerformed
        String dataStr = dataPesquisarTextField.getText();
        if (dataStr.matches("[0-2]{1}[0-9]{3}[-][0-1]{1}[0-9]{1}[-][0-3]{1}[0-9]{1}")) {
            try {
                java.sql.Date sqlDate = java.sql.Date.valueOf(dataStr);
                List<Evento> eventos = eventoDAO.buscarEventosPorData(sqlDate);
                DefaultTableModel model = (DefaultTableModel) tblEvento.getModel();
                model.setRowCount(0); // Limpa a tabela

                for (Evento evento : eventos) {
                    model.addRow(new Object[]{
                            evento.getId(),
                            evento.getNome(),
                            evento.getDescricao(),
                            evento.getDataInicio(),
                            evento.getDataFinal()
                    });
                }
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, preencha uma data válida.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "ATENÇÃO! Data agendada precisa ser válida e no formato YYYY-MM-DD", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoPesquisarDatabotaoCadastratActionPerformed

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
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoPesquisarData;
    private javax.swing.JButton botaoPesquisarNome;
    private javax.swing.JButton botaoSair;
    private javax.swing.JTextField dataPesquisarTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomePesquisarTextField;
    private javax.swing.JTable tblEvento;
    private javax.swing.JLabel tituloTechConnect;
    // End of variables declaration//GEN-END:variables
}
