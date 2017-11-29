/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.game;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;

/**
 *
 * @author sergi
 */
public class GamePanel extends javax.swing.JPanel {
    private GamePanelController controller;
    
    private Map<Integer, JLabel[]> hashMapPlayersCards =new HashMap<>();
    private JLabel[] timeUserLabel;
            
    /**
     * Creates new form GamePanel
     */
    private GamePanel() {
        initComponents();
        
    }
    
    public GamePanel(GamePanelController controller){
        this();
        this.controller = controller;
        disableLabel();
        //JLabel Cartas do usuário 0 (LOGGED)
        hashMapPlayersCards.put(0, new JLabel[]{
            card_u0_c0,
            card_u0_c1,
            card_u0_c2,
            card_u0_c3,
            card_u0_c4,
            card_u0_c5,
            card_u0_c6
        });
        //JLabel Cartas do usuário 1 (ESQUERDA)
        hashMapPlayersCards.put(1, new JLabel[]{
            card_u1_c0,
            card_u1_c1,
            card_u1_c2,
            card_u1_c3,
            card_u1_c4,
            card_u1_c5,
            card_u1_c6
        });
        //JLabel Cartas do usuário 2 (CIMA)
        hashMapPlayersCards.put(2, new JLabel[]{
            card_u2_c0,
            card_u2_c1,
            card_u2_c2,
            card_u2_c3,
            card_u2_c4,
            card_u2_c5,
            card_u2_c6
        });
        //JLabel Cartas do usuário 3 (DIREITA)
        hashMapPlayersCards.put(3, new JLabel[]{
            card_u3_c0,
            card_u3_c1,
            card_u3_c2,
            card_u3_c3,
            card_u3_c4,
            card_u3_c5,
            card_u3_c6
        });
        //JLabel Cartas (CARTAS DE INICIO)
        hashMapPlayersCards.put(4, new JLabel[]{
            card_u0_start,
            card_u1_start,
            card_u2_start,
            card_u3_start
        });
        //JLabel Cartas icones de ativo 
        hashMapPlayersCards.put(5, new JLabel[]{
            active_u0,
            active_u1,
            active_u2,
            active_u3
        });
        timeUserLabel = new JLabel[]{
            txt_time_u0,
            txt_time_u1,
            txt_time_u2,
            txt_time_u3
        };
    }
    
    public JLabel[] getLabels(int userIndex){
        return hashMapPlayersCards.get(userIndex);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        icon_u1 = new javax.swing.JLabel();
        active_u1 = new javax.swing.JLabel();
        card_u1_c0 = new javax.swing.JLabel();
        card_u1_c1 = new javax.swing.JLabel();
        card_u1_c2 = new javax.swing.JLabel();
        card_u1_c3 = new javax.swing.JLabel();
        card_u1_c4 = new javax.swing.JLabel();
        card_u1_c5 = new javax.swing.JLabel();
        card_u1_c6 = new javax.swing.JLabel();
        card_u1_start = new javax.swing.JLabel();
        txt_time_u1 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        btnOut = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        icon_u2 = new javax.swing.JLabel();
        active_u2 = new javax.swing.JLabel();
        card_u2_c0 = new javax.swing.JLabel();
        card_u2_c1 = new javax.swing.JLabel();
        card_u2_c2 = new javax.swing.JLabel();
        card_u2_c3 = new javax.swing.JLabel();
        card_u2_c4 = new javax.swing.JLabel();
        card_u2_c5 = new javax.swing.JLabel();
        card_u2_c6 = new javax.swing.JLabel();
        card_u2_start = new javax.swing.JLabel();
        txt_time_u2 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        panelTable = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        discard_1 = new javax.swing.JLabel();
        discard_2 = new javax.swing.JLabel();
        discard_3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        icon_u0 = new javax.swing.JLabel();
        active_u0 = new javax.swing.JLabel();
        card_u0_c0 = new javax.swing.JLabel();
        card_u0_c1 = new javax.swing.JLabel();
        card_u0_c2 = new javax.swing.JLabel();
        card_u0_c3 = new javax.swing.JLabel();
        card_u0_c4 = new javax.swing.JLabel();
        card_u0_c5 = new javax.swing.JLabel();
        card_u0_c6 = new javax.swing.JLabel();
        card_u0_start = new javax.swing.JLabel();
        btnMoreCards = new javax.swing.JLabel();
        txt_time_u0 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        myLabelTime = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        icon_u3 = new javax.swing.JLabel();
        active_u3 = new javax.swing.JLabel();
        card_u3_c0 = new javax.swing.JLabel();
        card_u3_c1 = new javax.swing.JLabel();
        card_u3_c2 = new javax.swing.JLabel();
        card_u3_c3 = new javax.swing.JLabel();
        card_u3_c4 = new javax.swing.JLabel();
        card_u3_c5 = new javax.swing.JLabel();
        card_u3_c6 = new javax.swing.JLabel();
        card_u3_start = new javax.swing.JLabel();
        txt_time_u3 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jPanel18.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel18);

        jPanel19.setBackground(new java.awt.Color(204, 255, 255));

        jPanel13.setMaximumSize(new java.awt.Dimension(380, 200));
        jPanel13.setMinimumSize(new java.awt.Dimension(380, 200));
        jPanel13.setOpaque(false);
        jPanel13.setPreferredSize(new java.awt.Dimension(380, 200));
        jPanel13.setRequestFocusEnabled(false);
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon_u1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_u1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user/user_3.png"))); // NOI18N
        jPanel13.add(icon_u1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 25, 70, 60));

        active_u1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        active_u1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FundoUser.png"))); // NOI18N
        jPanel13.add(active_u1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        card_u1_c0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u1_c0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel13.add(card_u1_c0, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 80));

        card_u1_c1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u1_c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel13.add(card_u1_c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, 80));

        card_u1_c2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u1_c2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel13.add(card_u1_c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, 80));

        card_u1_c3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u1_c3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel13.add(card_u1_c3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, 80));

        card_u1_c4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u1_c4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel13.add(card_u1_c4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, 80));

        card_u1_c5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u1_c5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel13.add(card_u1_c5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, 80));

        card_u1_c6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u1_c6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel13.add(card_u1_c6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, 80));

        card_u1_start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel13.add(card_u1_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, 80));

        txt_time_u1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        txt_time_u1.setForeground(new java.awt.Color(255, 51, 51));
        txt_time_u1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_time_u1.setText("00:05");
        jPanel13.add(txt_time_u1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 70, 20));

        jPanel19.add(jPanel13);

        jPanel3.add(jPanel19);

        jPanel20.setBackground(new java.awt.Color(204, 255, 255));

        btnOut.setText("Voltar");
        btnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(btnOut, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 229, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(188, Short.MAX_VALUE)
                .addComponent(btnOut)
                .addGap(14, 14, 14))
        );

        jPanel3.add(jPanel20);

        add(jPanel3);

        jPanel6.setBackground(new java.awt.Color(51, 51, 255));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.Y_AXIS));

        jPanel9.setBackground(new java.awt.Color(204, 255, 255));

        jPanel10.setMaximumSize(new java.awt.Dimension(380, 200));
        jPanel10.setMinimumSize(new java.awt.Dimension(380, 200));
        jPanel10.setOpaque(false);
        jPanel10.setPreferredSize(new java.awt.Dimension(380, 200));
        jPanel10.setRequestFocusEnabled(false);
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon_u2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_u2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user/user_3.png"))); // NOI18N
        jPanel10.add(icon_u2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 70, 60));

        active_u2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        active_u2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FundoUser.png"))); // NOI18N
        jPanel10.add(active_u2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 5, -1, -1));

        card_u2_c0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u2_c0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel10.add(card_u2_c0, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 80));

        card_u2_c1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u2_c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel10.add(card_u2_c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, 80));

        card_u2_c2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u2_c2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel10.add(card_u2_c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, 80));

        card_u2_c3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u2_c3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel10.add(card_u2_c3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, 80));

        card_u2_c4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u2_c4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel10.add(card_u2_c4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, 80));

        card_u2_c5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u2_c5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel10.add(card_u2_c5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, 80));

        card_u2_c6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u2_c6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel10.add(card_u2_c6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, 80));

        card_u2_start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel10.add(card_u2_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, 80));

        txt_time_u2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        txt_time_u2.setForeground(new java.awt.Color(255, 51, 51));
        txt_time_u2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_time_u2.setText("00:05");
        jPanel10.add(txt_time_u2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 70, 20));

        jPanel9.add(jPanel10);

        jPanel6.add(jPanel9);

        panel.setBackground(new java.awt.Color(204, 255, 255));

        panelTable.setMaximumSize(new java.awt.Dimension(300, 200));
        panelTable.setMinimumSize(new java.awt.Dimension(300, 200));
        panelTable.setOpaque(false);
        panelTable.setPreferredSize(new java.awt.Dimension(300, 200));
        panelTable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        panelTable.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        panelTable.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 50, 80));

        discard_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        panelTable.add(discard_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 80));

        discard_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        panelTable.add(discard_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, 80));

        discard_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        panelTable.add(discard_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, 80));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        panelTable.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, 80));

        panel.add(panelTable);

        jPanel6.add(panel);

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));

        jPanel11.setMaximumSize(new java.awt.Dimension(380, 200));
        jPanel11.setMinimumSize(new java.awt.Dimension(380, 200));
        jPanel11.setOpaque(false);
        jPanel11.setPreferredSize(new java.awt.Dimension(380, 200));
        jPanel11.setRequestFocusEnabled(false);
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon_u0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_u0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user/user_3.png"))); // NOI18N
        jPanel11.add(icon_u0, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 5, 70, 60));

        active_u0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        active_u0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FundoUser.png"))); // NOI18N
        jPanel11.add(active_u0, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, -1));

        card_u0_c0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u0_c0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel11.add(card_u0_c0, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 80));

        card_u0_c1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u0_c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel11.add(card_u0_c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, 80));

        card_u0_c2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u0_c2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel11.add(card_u0_c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 80));

        card_u0_c3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u0_c3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel11.add(card_u0_c3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, 80));

        card_u0_c4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u0_c4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel11.add(card_u0_c4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, 80));

        card_u0_c5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u0_c5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel11.add(card_u0_c5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, 80));

        card_u0_c6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u0_c6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel11.add(card_u0_c6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, 80));

        card_u0_start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel11.add(card_u0_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, -1, 80));

        btnMoreCards.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/more_cards.png"))); // NOI18N
        jPanel11.add(btnMoreCards, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        txt_time_u0.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        txt_time_u0.setForeground(new java.awt.Color(255, 51, 51));
        txt_time_u0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_time_u0.setText("00:05");
        jPanel11.add(txt_time_u0, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 70, 20));

        jPanel5.add(jPanel11);

        jPanel6.add(jPanel5);

        add(jPanel6);

        jPanel12.setBackground(new java.awt.Color(255, 51, 51));
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.Y_AXIS));

        jPanel21.setBackground(new java.awt.Color(204, 255, 255));

        myLabelTime.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        myLabelTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        myLabelTime.setText("00:00");
        myLabelTime.setToolTipText("");
        myLabelTime.setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 13)); // NOI18N
        jLabel1.setText("TEMPO DE JOGO");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(256, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(myLabelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(myLabelTime)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        myLabelTime.getAccessibleContext().setAccessibleDescription("");

        jPanel12.add(jPanel21);

        jPanel22.setBackground(new java.awt.Color(204, 255, 255));

        jPanel14.setMaximumSize(new java.awt.Dimension(380, 200));
        jPanel14.setMinimumSize(new java.awt.Dimension(380, 200));
        jPanel14.setOpaque(false);
        jPanel14.setPreferredSize(new java.awt.Dimension(380, 200));
        jPanel14.setRequestFocusEnabled(false);
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon_u3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_u3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user/user_3.png"))); // NOI18N
        jPanel14.add(icon_u3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 25, 70, 60));

        active_u3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        active_u3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FundoUser.png"))); // NOI18N
        jPanel14.add(active_u3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        card_u3_c0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u3_c0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel14.add(card_u3_c0, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 80));

        card_u3_c1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u3_c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel14.add(card_u3_c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, 80));

        card_u3_c2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u3_c2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel14.add(card_u3_c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, 80));

        card_u3_c3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u3_c3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel14.add(card_u3_c3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, 80));

        card_u3_c4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u3_c4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel14.add(card_u3_c4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, 80));

        card_u3_c5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u3_c5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel14.add(card_u3_c5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, 80));

        card_u3_c6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card_u3_c6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel14.add(card_u3_c6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, 80));

        card_u3_start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartas/costas.png"))); // NOI18N
        jPanel14.add(card_u3_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, 80));

        txt_time_u3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        txt_time_u3.setForeground(new java.awt.Color(255, 51, 51));
        txt_time_u3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_time_u3.setText("00:05");
        jPanel14.add(txt_time_u3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 70, 20));

        jPanel22.add(jPanel14);

        jPanel12.add(jPanel22);

        jPanel23.setBackground(new java.awt.Color(204, 255, 255));

        btnStart.setText("Iniciar");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 229, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(277, Short.MAX_VALUE)
                .addComponent(btnStart)
                .addGap(14, 14, 14))
        );

        jPanel12.add(jPanel23);

        add(jPanel12);
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
        controller.onBtnStartClicked();
        btnStart.setVisible(false);
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutActionPerformed
        // TODO add your handling code here:
        controller.returnPage();
    }//GEN-LAST:event_btnOutActionPerformed

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel active_u0;
    private javax.swing.JLabel active_u1;
    private javax.swing.JLabel active_u2;
    private javax.swing.JLabel active_u3;
    private javax.swing.JLabel btnMoreCards;
    private javax.swing.JButton btnOut;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel card_u0_c0;
    private javax.swing.JLabel card_u0_c1;
    private javax.swing.JLabel card_u0_c2;
    private javax.swing.JLabel card_u0_c3;
    private javax.swing.JLabel card_u0_c4;
    private javax.swing.JLabel card_u0_c5;
    private javax.swing.JLabel card_u0_c6;
    private javax.swing.JLabel card_u0_start;
    private javax.swing.JLabel card_u1_c0;
    private javax.swing.JLabel card_u1_c1;
    private javax.swing.JLabel card_u1_c2;
    private javax.swing.JLabel card_u1_c3;
    private javax.swing.JLabel card_u1_c4;
    private javax.swing.JLabel card_u1_c5;
    private javax.swing.JLabel card_u1_c6;
    private javax.swing.JLabel card_u1_start;
    private javax.swing.JLabel card_u2_c0;
    private javax.swing.JLabel card_u2_c1;
    private javax.swing.JLabel card_u2_c2;
    private javax.swing.JLabel card_u2_c3;
    private javax.swing.JLabel card_u2_c4;
    private javax.swing.JLabel card_u2_c5;
    private javax.swing.JLabel card_u2_c6;
    private javax.swing.JLabel card_u2_start;
    private javax.swing.JLabel card_u3_c0;
    private javax.swing.JLabel card_u3_c1;
    private javax.swing.JLabel card_u3_c2;
    private javax.swing.JLabel card_u3_c3;
    private javax.swing.JLabel card_u3_c4;
    private javax.swing.JLabel card_u3_c5;
    private javax.swing.JLabel card_u3_c6;
    private javax.swing.JLabel card_u3_start;
    private javax.swing.JLabel discard_1;
    private javax.swing.JLabel discard_2;
    private javax.swing.JLabel discard_3;
    private javax.swing.JLabel icon_u0;
    private javax.swing.JLabel icon_u1;
    private javax.swing.JLabel icon_u2;
    private javax.swing.JLabel icon_u3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel myLabelTime;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelTable;
    private javax.swing.JLabel txt_time_u0;
    private javax.swing.JLabel txt_time_u1;
    private javax.swing.JLabel txt_time_u2;
    private javax.swing.JLabel txt_time_u3;
    // End of variables declaration//GEN-END:variables

    private void disableLabel() {
            card_u0_c0.setVisible(false);
            card_u0_c1.setVisible(false);
            card_u0_c2.setVisible(false);
            card_u0_c3.setVisible(false);
            card_u0_c4.setVisible(false);
            card_u0_c5.setVisible(false);
            card_u0_c6.setVisible(false);
            
            card_u1_c0.setVisible(false);
            card_u1_c1.setVisible(false);
            card_u1_c2.setVisible(false);
            card_u1_c3.setVisible(false);
            card_u1_c4.setVisible(false);
            card_u1_c5.setVisible(false);
            card_u1_c6.setVisible(false);
            
            card_u2_c0.setVisible(false);
            card_u2_c1.setVisible(false);
            card_u2_c2.setVisible(false);
            card_u2_c3.setVisible(false);
            card_u2_c4.setVisible(false);
            card_u2_c5.setVisible(false);
            card_u2_c6.setVisible(false);
            
            card_u3_c0.setVisible(false);
            card_u3_c1.setVisible(false);
            card_u3_c2.setVisible(false);
            card_u3_c3.setVisible(false);
            card_u3_c4.setVisible(false);
            card_u3_c5.setVisible(false);
            card_u3_c6.setVisible(false);
            
            card_u0_start.setVisible(false);
            card_u1_start.setVisible(false);
            card_u2_start.setVisible(false);
            card_u3_start.setVisible(false);
            
            active_u0.setVisible(false);
            active_u1.setVisible(false);
            active_u2.setVisible(false);
            active_u3.setVisible(false);
            
            btnStart.setVisible(false);
            btnMoreCards.setEnabled(false);
            
            txt_time_u0.setVisible(false);
            txt_time_u1.setVisible(false);
            txt_time_u2.setVisible(false);
            txt_time_u3.setVisible(false);
    }

    public void showStartButton() {
        btnStart.setVisible(true);
    }

    void setStartCardVisible(boolean b) {
         card_u0_start.setVisible(b);
            card_u1_start.setVisible(b);
            card_u2_start.setVisible(b);
            card_u3_start.setVisible(b);
    }
    void setStackPlayedVisible(boolean b){
        discard_1.setVisible(b);
        discard_2.setVisible(b);
        discard_3.setVisible(b);
    }

    void updateTimeForUser(int playerIndex, int time) {
        timeUserLabel[playerIndex].setText("00:0"+time);
    }

    void setTimePlayerVisible(int playerIndex, boolean b) {
        timeUserLabel[playerIndex].setVisible(b);
    }

    void updateLabel(String time) {
      myLabelTime.setText(time);
    }

    
}
