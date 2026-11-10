
package view;

public class CriarItem extends javax.swing.JFrame {
    
    
    // Declarando as variáveis objeto
    private model.Personagem personagem;
    private model.Usuario usuario;
    
    
    public CriarItem() {
        initComponents();
    }

    // Construtor que recebe os dados
    public CriarItem(model.Personagem _personagem, model.Usuario _usuario) {
        initComponents();
        this.personagem = _personagem;
        this.usuario = _usuario;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblItem = new javax.swing.JLabel();
        txtTipo = new javax.swing.JComboBox<>();
        txtItem = new javax.swing.JTextField();
        btnCriar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("CRIAR ITEM");

        lblTipo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTipo.setText("Tipo:");

        lblItem.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblItem.setText("Item:");

        txtTipo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comum", "Equipamento" }));
        txtTipo.setSelectedIndex(-1);

        txtItem.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        btnCriar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCriar.setText("CRIAR");
        btnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTipo)
                            .addComponent(lblItem))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTipo, 0, 329, Short.MAX_VALUE)
                            .addComponent(txtItem))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(btnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblTitulo)
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItem)
                    .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed
        
        String nomeItem = txtItem.getText().trim();
        String tipo = (String) txtTipo.getSelectedItem(); // Pega o que foi selecionado no ComboBox

        if (nomeItem.isEmpty() || tipo == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        model.Item novoItem = new model.Item();
        novoItem.setPersonagens_id(this.personagem.getId());
        novoItem.setItem(nomeItem);
        novoItem.setTipo(tipo);

        DataAccess.ItemDAO dao = new DataAccess.ItemDAO();
        if (dao.cadastrarItem(novoItem)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Item adicionado!");
            // Volta para a tela de itens
            new view.Itens(this.personagem, this.usuario).setVisible(true);
            this.dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao adicionar item.");
        }
        
    }//GEN-LAST:event_btnCriarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        // Volta para a tela de itens sem salvar
        new view.Itens(this.personagem, this.usuario).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(CriarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCriar;
    private javax.swing.JLabel lblItem;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtItem;
    private javax.swing.JComboBox<String> txtTipo;
    // End of variables declaration//GEN-END:variables
}
