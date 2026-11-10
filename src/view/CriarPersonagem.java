
package view;

public class CriarPersonagem extends javax.swing.JFrame {
    
    private model.Usuario usuario; // Guarda o usuário logado
    private byte[] fotoEmBytes = null; // Guarda a imagem escolhida
    
    public CriarPersonagem() {
        initComponents();
    }
    
    public CriarPersonagem(model.Usuario _usuario) {
        
        initComponents();
        this.usuario = _usuario;
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        btnCriar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnImagem = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        lblImagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("CRIAR PERSONAGEM");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNome.setText("Nome:");

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

        btnImagem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnImagem.setText("Adicionar Imagem");
        btnImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagemActionPerformed(evt);
            }
        });

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        lblImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagem.setText("(imagem)");

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
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnImagem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitulo)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed
        
        String nome = txtNome.getText().trim();
    
        // Valida se não está vazio
        if (nome.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "O nome do personagem não pode estar vazio!");
            return;
        }

        // Cria o objeto tipo Personagem chamado novoPersonagem
        model.Personagem novoPersonagem = new model.Personagem();
        novoPersonagem.setNome(nome); // Define o nome do personagem
        novoPersonagem.setUsuarios_id(this.usuario.getId()); // Define o usuário dono do personagem
        novoPersonagem.setFoto(fotoEmBytes); // Define a foto importada ao personagem
        
        // DataAcess.PersonagemDAO para acessar a classe PersonagemDAO sem precisar de um "import DataAccess.PersonagemDAO;"
        // Cria um objeto chamado "dao" do tipo PersonagemDAO para usar os métodos dessa classe aqui
        DataAccess.PersonagemDAO dao = new DataAccess.PersonagemDAO();
        
        // Tenta realizar o método cadastrarPersonagem apartir do objeto "dao", indexando o objeto "novoPersonagem" criado e configurado
        if (dao.cadastrarPersonagem(novoPersonagem)) {
            
            javax.swing.JOptionPane.showMessageDialog(this, "Personagem criado com sucesso!");

            // Volta para a tela de personagens para ver o novo botão
            new view.Personagens(this.usuario).setVisible(true);
            this.dispose();
            
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao criar personagem.");
        }
        
    }//GEN-LAST:event_btnCriarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        // Volta para a tela de personagens sem salvar nada
        new view.Personagens(this.usuario).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagemActionPerformed
        
        // 1. Chama o método que abre a janela e retorna os bytes
        fotoEmBytes = selecionarFoto();

        // Se a foto não for nula (ou seja, o usuário escolheu algo)
        if (fotoEmBytes != null) {

            // 2. Chama o método que redimensiona
            javax.swing.ImageIcon iconeRedimensionado = redimensionarImagem(fotoEmBytes, lblImagem);

            // 3. Aplica na tela
            if (iconeRedimensionado != null) {
                lblImagem.setIcon(iconeRedimensionado);
                lblImagem.setText(""); // Remove o texto "(imagem)"
            }
        }
        
        
    }//GEN-LAST:event_btnImagemActionPerformed

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
            java.util.logging.Logger.getLogger(CriarPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriarPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriarPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriarPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarPersonagem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCriar;
    private javax.swing.JButton btnImagem;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
    
    
    private byte[] selecionarFoto() {
        
        // Forçando o Windows a abrir o FileDialog no modo de visualização de Ícones grandes (por qualidade de vida)
        System.setProperty("sun.awt.windows.useCommonItemDialog", "true");
        System.setProperty("apple.awt.fileDialogForDirectories", "false"); // Prevenção para Mac
        
        // Cria o seletor nativo do sistema operacional passando a janela atual e o título
        java.awt.FileDialog dialog = new java.awt.FileDialog(this, "Selecione uma Imagem", java.awt.FileDialog.LOAD);
        
        // Define um filtro simples (aceita apenas imagens)
        dialog.setFilenameFilter((dir, name) -> name.toLowerCase().endsWith(".png") || 
                                             name.toLowerCase().endsWith(".jpg") || 
                                             name.toLowerCase().endsWith(".jpeg"));
        
        dialog.setVisible(true); // Abre a janela
        
        // Se o usuário selecionar uma imagem na janela e confirmar...
        if (dialog.getFile() != null) {
            try {
                
                // Recebe o arquivo selecionado como "arquivo"
                java.io.File arquivo = new java.io.File(dialog.getDirectory(), dialog.getFile());
                // Converte o arquivo selecionado para Bytes e o retorna
                return java.nio.file.Files.readAllBytes(arquivo.toPath());
                
            } catch (java.io.IOException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Erro ao ler o arquivo.");
                return null;
            }
        }
        return null; // Se o usuário clicou em cancelar
    }
    
    private javax.swing.ImageIcon redimensionarImagem(byte[] _fotoBytes, javax.swing.JLabel _label) {
        
        // Se não há arquivo de foto, retorna null
        if (_fotoBytes == null) {
            return null;
        }

        try {
            
            // DETALHE IMPORTANTE:
            // O tipo de objeto "ImageIcon" é usado para exibição em telas, como encaixar em um Label.
            // Enquanto o tipo de objeto "Image" é usado para ser manipulado, sendo cortado ou redimensionado.
            
            // Cria um objeto Icon a partir do arquivo em Bytes
            javax.swing.ImageIcon icone = new javax.swing.ImageIcon(_fotoBytes);
            // Converte o objeto Icon em um objeto Image com a imagem original
            java.awt.Image imagemOriginal = icone.getImage();
            
            // Recebe as proporções da Label
            int larguraLabel = _label.getWidth();
            int alturaLabel = _label.getHeight();
            
            // Se o programa acabou de abrir, usa o PreferredSize (por segurança)
            if (larguraLabel == 0 || alturaLabel == 0) {
                larguraLabel = (int) _label.getPreferredSize().getWidth();
                alturaLabel = (int) _label.getPreferredSize().getHeight();
            }
            
            // Recebe o tamanho da imagemOriginal
            int larguraOriginal = imagemOriginal.getWidth(null);
            int alturaOriginal = imagemOriginal.getHeight(null);
            
            // Calcula a proporção para não distorcer
            double escalaX = (double) larguraLabel / larguraOriginal;
            double escalaY = (double) alturaLabel / alturaOriginal;
            // Percebe se a maior escala da imagem original é horizontal ou vertical, para não ser cortada em redimensionamentos
            double escalaFinal = Math.min(escalaX, escalaY);
            
            // Redimensiona os eixos da imagem original
            int novaLargura = (int) (larguraOriginal * escalaFinal);
            int novaAltura = (int) (alturaOriginal * escalaFinal);
            
            // Redimensiona a imagem de forma suave (com antialiasing) para encaixar no label
            java.awt.Image imagemRedimensionada = imagemOriginal.getScaledInstance(novaLargura, novaAltura, java.awt.Image.SCALE_SMOOTH);
            
            // 
            return new javax.swing.ImageIcon(imagemRedimensionada);
            
        } catch (Exception e) {
            System.out.println("Erro ao redimensionar: " + e.getMessage());
            return null;
        }
    }
    
    
}
