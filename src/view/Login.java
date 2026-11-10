package view;

public class Login extends javax.swing.JFrame {
    
    // Salvando na memória os atributos do usuário logado em formato de objeto
    private model.Usuario usuario;
    
    // Boolean que define a imagem atual (0 para primeira, 1 para segunda)
    private boolean imagemBase = false;
    
    public Login() {
        initComponents();
        
        // Carrega a imagem de dentro do projeto
        try { 
            
            // Definindo um atalho para a primeira imagem
            java.net.URL urlOriginal = getClass().getResource("/imagens/pao.png");
            
            // Colocando a imagem "urlOriginal" no JLabel "lblFoto"
            // E chamando o método "redimensionarParaLabel" para devolver "ImageIcon", que já será aplicado ao lblFoto
            lblFoto.setIcon(redimensionarParaLabel(urlOriginal, lblFoto)); 
            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSenha = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        btnEntrar = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnTrocar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSenha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblSenha.setText("Senha:");

        lblLogin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblLogin.setText("Login:");

        txtLogin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtLogin.setText("admin");

        txtSenha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtSenha.setText("123");

        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEntrar.setText("ENTRAR");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setPreferredSize(new java.awt.Dimension(300, 195));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("PROJETO.CHAR");

        btnTrocar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTrocar.setText("Trocar Espécime");
        btnTrocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrocarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSenha)
                    .addComponent(lblLogin))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(206, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitulo)
                            .addComponent(btnTrocar))
                        .addGap(367, 367, 367))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(lblTitulo)
                .addGap(25, 25, 25)
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTrocar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogin))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        
        // O código só prossegue se passar pelos 'filtros' do método "validation" e returnar true
        if (!validation()) { return; }
        
        javax.swing.JOptionPane.showMessageDialog(this, "Bem-vindo, " + this.usuario.getNome() + "!");
        
        // Cria a tela de personagens, com o construtor que entrega o objeto "usuario"
        view.Personagens telaPersonagens = new view.Personagens(this.usuario);
        telaPersonagens.setVisible(true); // Torna a tela criada visível
        this.dispose(); // Fecha a tela de login
        
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnTrocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrocarActionPerformed
        
        if (!imagemBase) {
            
            // Definindo um atalho para a segunda imagem
            java.net.URL urlNova = getClass().getResource("/imagens/alface.png");
            
            // Colocando a imagem "urlNova" no JLabel "lblFoto"
            // E chamando o método "redimensionarParaLabel" para devolver "ImageIcon", que já será aplicado ao lblFoto
            lblFoto.setIcon(redimensionarParaLabel(urlNova, lblFoto));
            
            imagemBase = true;
            
        } else {
            
            // Definindo um atalho para a primeira imagem
            java.net.URL urlOriginal = getClass().getResource("/imagens/pao.png");
            
            // Colocando a imagem "urlOriginal" no JLabel "lblFoto"
            // E chamando o método "redimensionarParaLabel" para devolver "ImageIcon", que já será aplicado ao lblFoto
            lblFoto.setIcon(redimensionarParaLabel(urlOriginal, lblFoto)); 
            
            imagemBase = false;
            
        }
        
        
    }//GEN-LAST:event_btnTrocarActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnTrocar;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
    
    private boolean validation() {
        
        // Recebe os atributos digitados pelo usuário
        String login = txtLogin.getText().trim();
        String senha = txtSenha.getText().trim();
        // Criptografa a senha digitada para comparar com a do banco
        String senhaCripto = DataAccess.Criptografia.getSHA(senha);
        
        
        // Verificando se os campos estão vazios
        if (login.isEmpty() || senha.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos");
            return false;
        }
        
        
        // Prepara o objeto
        model.Usuario tentativaLogin = new model.Usuario();
        tentativaLogin.setLogin(login);
        tentativaLogin.setSenha(senhaCripto);
        
        // Consultando o banco, e guarda no objeto "usuario" caso o usuário seja encontrado
        this.usuario = DataAccess.UsuarioBD.validarUsuario(tentativaLogin);
        
        // Verifica se o usuário existe e se a senha bate
        if (usuario == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos.");
            return false;
        }
        
        // Se passou por tudo, o usuário existe
        return true;
        
    }
    
    private javax.swing.ImageIcon redimensionarParaLabel(java.net.URL urlImagem, javax.swing.JLabel label) {
        
        if (urlImagem == null) { // Impedindo método caso não haja imagem
            System.out.println("Erro: URL da imagem não encontrada.");
            return null;
        }
        
        try {
            // Criando um objeto tipo Image "imagemOriginal" para ser manipulado
            java.awt.Image imagemOriginal = new javax.swing.ImageIcon(urlImagem).getImage();
            
            // Recebendo as proporções da Label aonde a imagem entrará
            int larguraLabel = label.getWidth();
            int alturaLabel = label.getHeight();
            // O programa não criou os Labels quando o código é lido, então será usado como parâmetro o PreferredSize
            if (larguraLabel == 0 || alturaLabel == 0) {
                larguraLabel = (int) label.getPreferredSize().getWidth();
                alturaLabel = (int) label.getPreferredSize().getHeight();
            }
            
            // Recebendo o tamanho da imagemOriginal
            int larguraOriginal = imagemOriginal.getWidth(null);
            int alturaOriginal = imagemOriginal.getHeight(null);
            // Calcula a proporção, deixando o maior eixo da foto do tamanho do eixo da moldura, com o menor eixo da foto acompanhando
            double escalaX = (double) larguraLabel / larguraOriginal;
            double escalaY = (double) alturaLabel / alturaOriginal;
            double escalaFinal = Math.min(escalaX, escalaY); // Pega a menor escala para não cortar a imagem
            // Calcula as novas proporções da foto
            int novaLargura = (int) (larguraOriginal * escalaFinal);
            int novaAltura = (int) (alturaOriginal * escalaFinal);

            // Redimensiona a foto a partir das novas proporções de forma suave (smooth sendo um antialiasing)
            java.awt.Image imagemRedimensionada = imagemOriginal.getScaledInstance(novaLargura, novaAltura, java.awt.Image.SCALE_SMOOTH);
            // Retornando o objeto criado da foto redimensionada
            return new javax.swing.ImageIcon(imagemRedimensionada);

        } catch (Exception e) {
            System.out.println("Erro ao redimensionar imagem: " + e.getMessage());
            return null;
        }
    }
    
    
}
