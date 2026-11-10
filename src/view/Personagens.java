package view;

import DataAccess.UsuarioBD;
import model.Usuario;

public class Personagens extends javax.swing.JFrame {
    
    // Variável para guardar a ficha que a tela de Login vai entregar
    private model.Usuario usuario;
    
    // Variáveis globais que definem o tamanho do Card
    private final int LARGURA = 200;
    
    private final int ALTURA_FOTO = 200; 
    private final int ALTURA_NOME = 30;
    
    // A altura do Card é a soma da altura da foto com a altura do nome
    private final int ALTURA_TOTAL_CARD = ALTURA_FOTO + ALTURA_NOME;
    
    
    public Personagens() {
        initComponents();
    }

    Personagens(Usuario _usuario) {
        initComponents();
        this.usuario = _usuario; // "usuario" agora guarda os atributos do objeto usuario equivalente logado
        
        // Atualiza o título com o nome do usuário logado
        lblTitulo.setText("LISTA DE PERSONAGENS DE: " + this.usuario.getNome());
        
        // Carregar lista de personagens na grid
        carregarPersonagens(); 
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        painelPersonagens = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo.setText("LISTA DE PERSONAGENS DE: (nome do usuário logado)");

        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnNovo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        painelPersonagens.setLayout(new java.awt.GridLayout(0, 3));
        jScrollPane1.setViewportView(painelPersonagens);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE))
                        .addContainerGap(50, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        
        // Abre uma nova tela de Login
        new view.Login().setVisible(true);
        
        // Fecha a tela de personagens atual
        this.dispose(); 
        
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        
        // Abre a tela de criar personagem passando o usuário logado
        new view.CriarPersonagem(this.usuario).setVisible(true);

        // Fecha a tela de personagens atual
        this.dispose(); 
        
    }//GEN-LAST:event_btnNovoActionPerformed

    
    
    
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
            java.util.logging.Logger.getLogger(Personagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Personagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Personagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Personagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personagens().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painelPersonagens;
    // End of variables declaration//GEN-END:variables
    
    
    // Método responsável por criar um 'card' para cada personagem a ser alocado
    private void carregarPersonagens() {
        
        painelPersonagens.removeAll();

        DataAccess.PersonagemDAO dao = new DataAccess.PersonagemDAO();
        java.util.ArrayList<model.Personagem> lista = dao.listarPorUsuario(this.usuario.getId());

        // Para cada personagem, configura um card e adiciona no painel
        for (model.Personagem p : lista) {
            javax.swing.JPanel card = configurarCard(p);
            painelPersonagens.add(card);
        }

        painelPersonagens.revalidate();
        painelPersonagens.repaint();
    }
        
    // Método responsável por crira e configurar os cards aonde serão exibidos os personagens
    private javax.swing.JPanel configurarCard(model.Personagem p) {

        // Cria o Card principal
        javax.swing.JPanel card = new javax.swing.JPanel(new java.awt.BorderLayout());
        card.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200), 2));
        card.setBackground(java.awt.Color.WHITE);
        
        // A largura do card é LARGURA, e a altura é a soma (Foto + Nome)
        card.setPreferredSize(new java.awt.Dimension(LARGURA, ALTURA_TOTAL_CARD)); 
        card.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        // Configura a Label da Foto
        javax.swing.JLabel lblFoto = new javax.swing.JLabel();
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        // A largura da foto é igual à largura do card (LARGURA)
        lblFoto.setPreferredSize(new java.awt.Dimension(LARGURA, ALTURA_FOTO)); 
        lblFoto.setMinimumSize(new java.awt.Dimension(LARGURA, ALTURA_FOTO));
        lblFoto.setMaximumSize(new java.awt.Dimension(LARGURA, ALTURA_FOTO));
        
        lblFoto.setBackground(java.awt.Color.WHITE); 
        lblFoto.setOpaque(true);

        lblFoto.setIcon(consultaFoto(p));

        // Configura a Label do Nome
        javax.swing.JLabel lblNome = new javax.swing.JLabel(p.getNome());
        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 18));
        
        lblNome.setPreferredSize(new java.awt.Dimension(LARGURA, ALTURA_NOME)); 
        
        lblNome.setBackground(java.awt.Color.WHITE); 
        lblNome.setOpaque(true);

        // Junta a foto e o nome no Card
        card.add(lblFoto, java.awt.BorderLayout.CENTER);
        card.add(lblNome, java.awt.BorderLayout.SOUTH);
        
        // 
        configurarEventosCard(card, lblFoto, lblNome, p);

        return card;
    }
    
    // Método responsável por gerenciar os eventos de mouse e as mudanças de cor do Card
    private void configurarEventosCard(javax.swing.JPanel card, javax.swing.JLabel lblFoto, javax.swing.JLabel lblNome, model.Personagem p) {
        
        card.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                // Ao clicar e segurar, o card inteiro fica cinza
                card.setBackground(new java.awt.Color(220, 220, 220));
                lblFoto.setBackground(new java.awt.Color(220, 220, 220));
                lblNome.setBackground(new java.awt.Color(220, 220, 220));
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                // Ao soltar, volta ao branco
                card.setBackground(java.awt.Color.WHITE);
                lblFoto.setBackground(java.awt.Color.WHITE);
                lblNome.setBackground(java.awt.Color.WHITE);
                
                // E chama o menu de opções
                opcoesPersonagem(p, card); 
            }
            
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // Opcional: passa o mouse por cima e fica com um cinza mais clarinho
                card.setBackground(new java.awt.Color(245, 245, 245));
                lblFoto.setBackground(new java.awt.Color(245, 245, 245));
                lblNome.setBackground(new java.awt.Color(245, 245, 245));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // Tira o mouse de cima e volta ao branco
                card.setBackground(java.awt.Color.WHITE);
                lblFoto.setBackground(java.awt.Color.WHITE);
                lblNome.setBackground(java.awt.Color.WHITE);
            }
        });
    }
    
    // Método responsável por consultar a foto do personagem no banco
    private javax.swing.ImageIcon consultaFoto(model.Personagem p) {
        
        try {
            // Pega os bytes da imagem (do banco ou a padrão)
            byte[] bytesImagem = p.getFoto();
            
            if (bytesImagem == null || bytesImagem.length == 0) {
                java.net.URL urlPadrao = getClass().getResource("/imagens/default.png"); 
                if (urlPadrao != null) {
                    bytesImagem = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(urlPadrao.toURI()));
                } else {
                    System.out.println("ERRO: default.jpg não encontrada!");
                    return null;
                }
            }

            // 2. Chama o método responsável por redimensionar e retorna o resultado
            return redimensionarParaCard(bytesImagem);
            
        } catch (Exception e) {
            System.out.println("Erro ao carregar imagem: " + e.getMessage());
            return null;
        }
        
    }
    
    
    // Método responsável por redimensionar a imagem para caber no Card
    private javax.swing.ImageIcon redimensionarParaCard(byte[] _fotoBytes) {
        
        if (_fotoBytes == null) {
            return null;
        }

        try {
            javax.swing.ImageIcon icone = new javax.swing.ImageIcon(_fotoBytes);
            java.awt.Image imagemOriginal = icone.getImage();
            
            // Usa a variável LARGURA e a ALTURA_FOTO
            int larguraCard = LARGURA;
            int alturaCard = ALTURA_FOTO;
            
            int larguraOriginal = imagemOriginal.getWidth(null);
            int alturaOriginal = imagemOriginal.getHeight(null);
            
            double escalaX = (double) larguraCard / larguraOriginal;
            double escalaY = (double) alturaCard / alturaOriginal;
            double escalaFinal = Math.min(escalaX, escalaY); 
            
            int novaLargura = (int) (larguraOriginal * escalaFinal);
            int novaAltura = (int) (alturaOriginal * escalaFinal);
            
            java.awt.Image imagemRedimensionada = imagemOriginal.getScaledInstance(novaLargura, novaAltura, java.awt.Image.SCALE_SMOOTH);
            
            return new javax.swing.ImageIcon(imagemRedimensionada);
            
        } catch (Exception e) {
            System.out.println("Erro ao redimensionar: " + e.getMessage());
            return null;
        }
    }
    
    
    // Método responsável pelo menu ao clickar em um personagem e suas opções
    private void opcoesPersonagem(model.Personagem personagem, javax.swing.JPanel botaoOrigem) {
        
        // Cria o menu
        javax.swing.JPopupMenu menu = new javax.swing.JPopupMenu();
        
        // Opção 1: Ir para o Inventário
        javax.swing.JMenuItem opcaoInventario = new javax.swing.JMenuItem("Abrir Inventário");
        opcaoInventario.addActionListener((java.awt.event.ActionEvent evt) -> {
            // Abre a tela de itens, e enviando o objeto "personagem" e "usuario" e suas informações
            view.Itens telaItens = new view.Itens(personagem, this.usuario);
            telaItens.setVisible(true);
            this.dispose(); // Fecha a tela de login
        });

        // Opção 2: Excluir Personagem
        javax.swing.JMenuItem itemExcluir = new javax.swing.JMenuItem("Excluir Personagem");
        itemExcluir.addActionListener((java.awt.event.ActionEvent evt) -> {
            // Pede confirmação
            int resposta = javax.swing.JOptionPane.showConfirmDialog(null,
                    "Tem certeza que deseja excluir o personagem " + personagem.getNome() + "?\nTodos os itens dele serão perdidos.",
                    "Confirmar Exclusão",
                    javax.swing.JOptionPane.YES_NO_OPTION);
            
            if (resposta == javax.swing.JOptionPane.YES_OPTION) {
                // Aqui entra a lógica de exclusão no banco
                excluirPersonagem(personagem.getId());
                // Recarrega a tela para o botão sumir
                carregarPersonagens();
            }
        });

        // Opção 3: Cancelar (apenas fecha o menu)
        javax.swing.JMenuItem itemCancelar = new javax.swing.JMenuItem("Cancelar");
        itemCancelar.addActionListener((java.awt.event.ActionEvent evt) -> {
            menu.setVisible(false); // Fecha o menu
        });

        // Adiciona as opções ao menu
        menu.add(opcaoInventario);
        menu.add(itemExcluir);
        menu.addSeparator(); // Uma linha divisória para separar o Cancelar
        menu.add(itemCancelar);

        // Mostra o menu logo abaixo do botão que foi clicado
        menu.show(botaoOrigem, botaoOrigem.getWidth() / 2, botaoOrigem.getHeight());
    }
    
    // Método responsável por excluir um personagem caso essa seja a escolha no menu
    public boolean excluirPersonagem(int idPersonagem) {
        String sql = "DELETE FROM Personagens WHERE id = ?";

        try (java.sql.Connection conn = UsuarioBD.getConexao();
             java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idPersonagem);
            ps.executeUpdate();
            return true;

        } catch (java.sql.SQLException e) {
            System.out.println("Erro ao excluir personagem: " + e.getMessage());
            return false;
        }
    }
    
    
}
