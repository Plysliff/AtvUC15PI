package view;

import model.Personagem;

public class Itens extends javax.swing.JFrame {
    
    private model.Usuario usuario; 
    private model.Personagem personagem;
    
    // Card atualmente selecionado (apenas um por vez)
    private javax.swing.JPanel cardSelecionado = null;
    // Item correspondente ao card selecionado
    private model.Item itemSelecionado = null;

    // Largura e altura dos cards
    //private final int LARGURA = 100;
    private final int ALTURA = 45;
    // Espaçamento de todas as direções entre um card e outro
    private final int ESPACO = 0;
    
    
    
    public Itens() {
        initComponents();
    }

    Itens(model.Personagem _personagem, model.Usuario _usuario) {
        initComponents();
        
        // Tornando o GridLayout um GridBagLayout, para encaixar os cards com proporções fixas
        painelItens.setLayout(new java.awt.GridBagLayout());
        
        this.usuario = _usuario;
        this.personagem = _personagem;
        
        // Muda o título da tela para mostrar o nome do personagem
        lblTitulo.setText("LISTA DE ITENS DE: " + this.personagem.getNome());
        
        
        carregarItens(); 
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        Novo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        painelItens = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo.setText("LISTA DE ITENS DE: (nome do personagem escolhido)");

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnVoltar.setText("VOLTAR");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        Novo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Novo.setText("NOVO");
        Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoActionPerformed(evt);
            }
        });

        painelItens.setLayout(new java.awt.GridLayout(0, 2));
        jScrollPane1.setViewportView(painelItens);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblTitulo)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
        
        if (itemSelecionado == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione o item que deseja excluir.");
            return;
        }

        // Pede confirmação para o usuário
        int resposta = javax.swing.JOptionPane.showConfirmDialog(this, 
                "Tem certeza que deseja excluir o item \"" + itemSelecionado.getItem() + "\"?", 
                "Confirmar Exclusão", 
                javax.swing.JOptionPane.YES_NO_OPTION);

        if (resposta == javax.swing.JOptionPane.YES_OPTION) {
            // Chama o DAO para apagar no banco
            DataAccess.ItemDAO dao = new DataAccess.ItemDAO();
            if (dao.excluirItem(itemSelecionado.getId())) {
                javax.swing.JOptionPane.showMessageDialog(this, itemSelecionado.getItem() + " foi excluído(a) do seu inventário.");
                
                // Atualiza a tabela na tela chamando o método que já existe
                carregarItens(); 
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Erro ao excluir o item.");
            }
        }
        
        // Zera a seleção de forma centralizada as seleções
        desmarcarCard(cardSelecionado);
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        
        // Cria uma nova tela de personagens passando o usuário (ou apenas fecha)
        new view.Personagens(this.usuario).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoActionPerformed
        
        // Abre a tela de criar item, passando o personagem e o usuário
        new view.CriarItem(this.personagem, this.usuario).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_NovoActionPerformed

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
            java.util.logging.Logger.getLogger(Itens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Itens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Itens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Itens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Itens().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Novo;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painelItens;
    // End of variables declaration//GEN-END:variables
    
    
    private void carregarItens() {
        
        painelItens.removeAll(); // Remove todos os cards existentes
        desmarcarCard(cardSelecionado); // Zera as variáveis ligadas a seleção de cards
        
        // Cria uma instancia DAO a partir de ItemDAO, para trabalhar com seus métodos
        DataAccess.ItemDAO dao = new DataAccess.ItemDAO();
        // Cria uma lista com todos os itens ligados ao ID do personagem selecionado
        java.util.ArrayList<model.Item> lista = dao.listarPorPersonagem(this.personagem.getId());
        
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints(); // Cria a GridBagLayout
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; // O card vai preencher toda a largura da grid
        gbc.weightx = 1.0; // Faz as colunas dividirem a largura horizontal de forma igual (50% cada)
        gbc.weighty = 0.0; // Impede que os cards estiquem verticalmente (obrigando o setPreferredSize a ser respeitado)
        gbc.anchor = java.awt.GridBagConstraints.NORTH; // Se sobrar espaço vertical na grid, o card gruda no topo
        // Define o espaçamento entre os cards -- (0, 0, 0, 0) = (topo, esquerda, baixo, direita)
        gbc.insets = new java.awt.Insets(ESPACO, ESPACO, ESPACO, ESPACO);

        
        int coluna = 0; int linha = 0; // Define a coluna e linha atual a 0
        // Segue lendo a lista de itens encontrados com o ID equivalente do personagem, até que acabe
        for (model.Item i : lista) {
            
            // Definem as coordenadas X e Y de cada card na grid
            gbc.gridx = coluna; 
            gbc.gridy = linha; 
            // Adiciona um card na grid "gbc", com as configurações de "configurarCard" e as informações pegas do item atual listdado "i"
            painelItens.add(configurarCard(i), gbc);

            coluna++; // Adiciona +1 na contagem de colunas após preencher a atual
            /* Se a coluna recém preenchida é a segunda (a ultima da nossa grid sendo a 0 e 1) e a próxima a ser
            preenchida é a coluna 2, voltamos pra coluna 0 e descemos para a próxima linha */
            if (coluna == 2) {
                coluna = 0;
                linha++;
            }
        }

        // Empurra os cards para cima (impede que flutuem no meio do painel)
        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.weighty = 1.0; 
        painelItens.add(javax.swing.Box.createGlue(), gbc);
        
        // Avisa o Java que a estrutura de componentes mudou, para ele recalcular o posicionamento do GridBagLayout
        painelItens.revalidate(); 
        // Manda o Java desenhar a tela novamente. Sem isso, os novos cards podem simplesmente não aparecer na tela até redimensionar a janela.
        painelItens.repaint();
    }
    
    // Cria e configura o card visual de um item
    private javax.swing.JPanel configurarCard(model.Item item) {
    
    // Cria o GridBagLayout
    javax.swing.JPanel card = new javax.swing.JPanel(new java.awt.GridBagLayout());
    // Desenha uma borda, e define sua cor e expessura
    card.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200), 2));
    card.setBackground(java.awt.Color.WHITE); // Deixa o fundo do card branco
    card.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Muda o cursor ao colidir
    // Definindo a largura e altura do card (a largura pode ser 0 pois está configurada para preencher em duas colunas de qualquer modo)
    card.setPreferredSize(new java.awt.Dimension(0, ALTURA)); 
    
    // Recebe o nome do item em uma nova label "lblNome", e configura sua exibição
    javax.swing.JLabel lblNome = new javax.swing.JLabel(item.getItem());
    lblNome.setFont(new java.awt.Font("Segoe UI", 1, 18));
    lblNome.setOpaque(true);
    lblNome.setBackground(java.awt.Color.WHITE);
    // Recebe o tipo do item em uma nova label "lblNome", e configura sua exibição
    javax.swing.JLabel lblTipo = new javax.swing.JLabel(" (" + item.getTipo() + ")");
    lblTipo.setFont(new java.awt.Font("Segoe UI", 0, 16));
    lblTipo.setForeground(new java.awt.Color(80, 80, 80));
    lblTipo.setOpaque(true);
    lblTipo.setBackground(java.awt.Color.WHITE);
    
    
    // ---------------------------------
    
    // (0, 0, 0, 0) = (topo, esquerda, baixo, direita)
    
    // Cria o objeto que guarda as regras de posicionamento para adicionar os textos dentro do card
    java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
    
    // Define que o nome nome será colocado primeira coluna e na primeira linha do card
    gbc.gridx = 0;
    gbc.gridy = 0;
    // Zera as margens, com apenas 2px de espaço pra sua direita (o tipo)
    gbc.insets = new java.awt.Insets(0, 0, 0, 2); 
    // Adiciona ao card 
    card.add(lblNome, gbc);
    
    // Define que o tipo será colocado na segunda coluna (e ainda na primeira linha) do card
    gbc.gridx = 1;
    // Zera as margens, com apenas 2px de espaço pra sua esquerda (o nome)
    // Somando 4px de distância entre o Nome e o Tipo
    gbc.insets = new java.awt.Insets(0, 2, 0, 0);
    // Adiciona ao card
    card.add(lblTipo, gbc);
    
    // ---------------------------------
    
    // Roda o método dos eventos
    configurarEventosCard(card, lblNome, lblTipo, item);

    return card;
}
    
    // Configura os eventos de mouse (clique, entrar, sair)
    private void configurarEventosCard(javax.swing.JPanel card, javax.swing.JLabel lblNome, javax.swing.JLabel lblTipo, model.Item item) {

        card.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Ao clicar, seleciona (ou desseleciona) este card
                selecionarCard(card, lblNome, lblTipo, item);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // Hover: só aplica cinza claro se o card NÃO estiver selecionado
                if (card != cardSelecionado) {
                    card.setBackground(new java.awt.Color(245, 245, 245));
                    lblNome.setBackground(new java.awt.Color(245, 245, 245));
                    lblTipo.setBackground(new java.awt.Color(245, 245, 245));
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // Ao sair do hover: volta ao branco (se não estiver selecionado)
                if (card != cardSelecionado) {
                    card.setBackground(java.awt.Color.WHITE);
                    lblNome.setBackground(java.awt.Color.WHITE);
                    lblTipo.setBackground(java.awt.Color.WHITE);
                }
            }
        });
    }
    
    // Aplica a seleção visual em um card (um por vez)
    private void selecionarCard(javax.swing.JPanel card, javax.swing.JLabel lblNome, javax.swing.JLabel lblTipo, model.Item item) {

        // Clicar de novo no card já selecionado → desmarca
        if (cardSelecionado == card) {
            card.setBackground(java.awt.Color.WHITE);
            lblNome.setBackground(java.awt.Color.WHITE);
            lblTipo.setBackground(java.awt.Color.WHITE);
            card.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200), 2));
            cardSelecionado = null;
            itemSelecionado = null;
            return; // Sai do método (não executa os blocos 2 e 3)
        }

        // Se havia outro card selecionado, restaura ele ao estado normal
        if (cardSelecionado != null) {
            cardSelecionado.setBackground(java.awt.Color.WHITE);
            cardSelecionado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200), 2));

            // Repinta também os labels filhos (senão ficariam azuis)
            for (java.awt.Component c : cardSelecionado.getComponents()) {
                c.setBackground(java.awt.Color.WHITE);
            }
        }

        // Destaca o novo card (fundo azul claro + borda azul)
        java.awt.Color corSelecao = new java.awt.Color(180, 210, 255);
        card.setBackground(corSelecao);
        lblNome.setBackground(corSelecao);
        lblTipo.setBackground(corSelecao);
        card.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 120, 220), 2));

        // Atualiza as variáveis de estado
        cardSelecionado = card;
        itemSelecionado = item;
    }
    
    // Desmarca um card visualmente (cor + borda) e sistematicamente (variáveis)
    private void desmarcarCard(javax.swing.JPanel card) {
        
        // Se receber null, não faz nada
        if (card == null) {
            return;
        }

        // Volta o fundo ao branco
        card.setBackground(java.awt.Color.WHITE);

        // Volta a borda ao cinza fino (estado normal)
        card.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200), 2));

        // Repinta também os labels filhos (senão ficariam azuis)
        for (java.awt.Component c : card.getComponents()) {
            c.setBackground(java.awt.Color.WHITE);
        }

        // Zera as variáveis de estado
        cardSelecionado = null;
        itemSelecionado = null;
    }
    
}
