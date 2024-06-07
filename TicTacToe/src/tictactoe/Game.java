/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author vinic
 */
public class Game extends javax.swing.JFrame {
    // True = user, False = machine
    // private boolean turn = true; 
    // private final String players[] = {"User", "JoJoILMa"};
    private final JoJoILMa machine;
    private int userScore;
    private int machineScore;
    public static ImageIcon xIcon, oIcon, tittleIcon;
    public static int moveCount = 0;
    public static boolean hasWinner;
    
    // Initial State of the Game
    /*public static Symbols[][] board = {
        {Symbols.E, Symbols.E, Symbols.E},
        {Symbols.E, Symbols.E, Symbols.E},
        {Symbols.E, Symbols.E, Symbols.E}
    };*/
    
    public static Board board;
    
    static {
        board = new Board();
        xIcon = new ImageIcon("C:\\Users\\vinic\\OneDrive\\Documentos\\NetBeansProjects\\TicTacToe\\src\\tictactoe\\images\\X.png");
        oIcon = new ImageIcon("C:\\Users\\vinic\\OneDrive\\Documentos\\NetBeansProjects\\TicTacToe\\src\\tictactoe\\images\\O.png");
        tittleIcon = new ImageIcon("C:\\Users\\vinic\\OneDrive\\Documentos\\NetBeansProjects\\TicTacToe\\src\\tictactoe\\images\\Tittle.png");
    }
    
    public static void reset() {
        moveCount = 0;
        board.reset();
        hasWinner = false;
        
        /*
        S00.setText("");
        S01.setText("");
        S02.setText("");
        S10.setText("");
        S11.setText("");
        S12.setText("");
        S20.setText("");
        S21.setText("");
        S22.setText("");
        */
        
        S00.setIcon(null);
        S01.setIcon(null);
        S02.setIcon(null);
        S10.setIcon(null);
        S11.setIcon(null);
        S12.setIcon(null);
        S20.setIcon(null);
        S21.setIcon(null);
        S22.setIcon(null);
    }
    
    public static Symbols finish(Board b) {
        for (int i = 0; i < 3; i++) {
            Symbols sl = b.getBoardAt(i, 0);
            Symbols sc = b.getBoardAt(0, i);
            
            int slCount = 0, scCount = 0;
            for (int j = 0; j < 3; j++) {
                // Check Lines
                //if (board[i][j] == sl && sl != Symbols.E) slCount++;
                if (b.getBoardAt(i, j) == sl && sl != Symbols.E) slCount++;
                
                // Check Columns
                // if (board[j][i] == sc && sc != Symbols.E) scCount++;
                if (b.getBoardAt(j, i) == sc && sc != Symbols.E) scCount++;
            }
            if (slCount == 3) {
                hasWinner = true;
                return sl;
            } else if (scCount == 3) {
                hasWinner = true;
                return sc;
            }
        }
        
        // Check Diagonal
        // Symbols sl = board[0][0];
        // Symbols sr = board[0][2];
        
        Symbols sl = b.getBoardAt(0, 0);
        Symbols sr = b.getBoardAt(0, 2);
        
        
        int slCount = 0, srCount = 0;
        for (int i = 0; i < 3; i++) {
            // if (board[i][i] == sl && sl != Symbols.E) slCount++;
            if (b.getBoardAt(i, i) == sl && sl != Symbols.E) slCount++;
            
            // if (board[i][2 - i] == sr && sr != Symbols.E) srCount++;
            if (b.getBoardAt(i, 2 - i) == sr && sr != Symbols.E) srCount++;
        }
        
        if (slCount == 3) {
            hasWinner = true;
            return sl;
        } else if (srCount == 3) {
            hasWinner = true;
            return sr;
        }
        
        // Nobody winns
        return Symbols.E;
    }
    
    public static ImageIcon scaleIcon(ImageIcon icon) {
        Image img = icon.getImage();
        // Image scaledImg = img.getScaledInstance(123, 95, Image.SCALE_SMOOTH);
        Image scaledImg = img.getScaledInstance(60, 47, Image.SCALE_SMOOTH);
        
        return new ImageIcon(scaledImg);
    }
    
    /**
     * Creates new form Game
     */
    public Game() {
        initComponents();
        
        
        machine = new JoJoILMa();
        // machine.move(board);
        userScore = machineScore = 0;
        hasWinner = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        S00 = new javax.swing.JButton();
        S01 = new javax.swing.JButton();
        S02 = new javax.swing.JButton();
        S10 = new javax.swing.JButton();
        S11 = new javax.swing.JButton();
        S12 = new javax.swing.JButton();
        S20 = new javax.swing.JButton();
        S21 = new javax.swing.JButton();
        S22 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UserScore = new javax.swing.JLabel();
        MachineScore = new javax.swing.JLabel();
        NewGame = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        S00.setBackground(new java.awt.Color(255, 255, 255));
        S00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S00ActionPerformed(evt);
            }
        });

        S01.setBackground(new java.awt.Color(255, 255, 255));
        S01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S01ActionPerformed(evt);
            }
        });

        S02.setBackground(new java.awt.Color(255, 255, 255));
        S02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S02ActionPerformed(evt);
            }
        });

        S10.setBackground(new java.awt.Color(255, 255, 255));
        S10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S10ActionPerformed(evt);
            }
        });

        S11.setBackground(new java.awt.Color(255, 255, 255));
        S11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S11ActionPerformed(evt);
            }
        });

        S12.setBackground(new java.awt.Color(255, 255, 255));
        S12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S12ActionPerformed(evt);
            }
        });

        S20.setBackground(new java.awt.Color(255, 255, 255));
        S20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S20ActionPerformed(evt);
            }
        });

        S21.setBackground(new java.awt.Color(255, 255, 255));
        S21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S21ActionPerformed(evt);
            }
        });

        S22.setBackground(new java.awt.Color(255, 255, 255));
        S22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(S00, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(S01, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(S02, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(S10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(S11, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(S12, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(S20, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(S21, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(S22, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(S00, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(S01, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(S02, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(S10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(S11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(S12, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(S20, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(S21, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(S22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel1.setText("User:");

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel2.setText("JoJoILMa:");

        UserScore.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        UserScore.setText("0");

        MachineScore.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        MachineScore.setText("0");

        NewGame.setBackground(new java.awt.Color(255, 255, 255));
        NewGame.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        NewGame.setText("Novo Jogo Novo");
        NewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(UserScore))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(MachineScore))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(NewGame)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(UserScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(MachineScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NewGame)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoe/images/Title.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void S22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S22ActionPerformed
        if (board.getBoardAt(2, 2) == Symbols.E && !hasWinner) {
            // S22.setIcon(scaleIcon(xIcon));
            S22.setIcon(scaleIcon(xIcon));
            
            board.setBoardAt(Symbols.X, 2, 2);
            moveCount++;
            
            if (finish(board) == Symbols.E) {
                // machine.moveRandom(board.getBoard());
                machine.moveBest(8);
                if (finish(board) == Symbols.O) {
                    machineScore++;
                    MachineScore.setText(Integer.toString(machineScore));
                }
            }
            else {
                userScore++;
                UserScore.setText(Integer.toString(userScore));
            }
        }
    }//GEN-LAST:event_S22ActionPerformed

    private void S12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S12ActionPerformed
        if (board.getBoardAt(1, 2) == Symbols.E && !hasWinner) {
            S12.setIcon(scaleIcon(xIcon));
            // board[1][2] = Symbols.X;
            board.setBoardAt(Symbols.X, 1, 2);
            moveCount++;
            
            if (finish(board) == Symbols.E) {
                // machine.moveRandom(board.getBoard());
                machine.moveBest(5);
                if (finish(board) == Symbols.O) {
                    machineScore++;
                    MachineScore.setText(Integer.toString(machineScore));
                }
            }
            else {
                userScore++;
                UserScore.setText(Integer.toString(userScore));
            }
        }
    }//GEN-LAST:event_S12ActionPerformed

    private void S02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S02ActionPerformed
        if (board.getBoardAt(0, 2) == Symbols.E && !hasWinner) {
            S02.setIcon(scaleIcon(xIcon));
            board.setBoardAt(Symbols.X, 0, 2);
            moveCount++;
            
            if (finish(board) == Symbols.E) {
                // machine.moveRandom(board.getBoard());
                machine.moveBest(2);
                if (finish(board) == Symbols.O) {
                    machineScore++;
                    MachineScore.setText(Integer.toString(machineScore));
                }
            }
            else {
                userScore++;
                UserScore.setText(Integer.toString(userScore));
            }
        }
    }//GEN-LAST:event_S02ActionPerformed

    private void S21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S21ActionPerformed
        if (board.getBoardAt(2, 1) == Symbols.E && !hasWinner) {
            S21.setIcon(scaleIcon(xIcon));
            board.setBoardAt(Symbols.X, 2, 1);
            moveCount++;
            
            if (finish(board) == Symbols.E) {
                // machine.moveRandom(board.getBoard());
                machine.moveBest(7);
                if (finish(board) == Symbols.O) {
                    machineScore++;
                    MachineScore.setText(Integer.toString(machineScore));
                }
            }
            else {
                userScore++;
                UserScore.setText(Integer.toString(userScore));
            }
        }
    }//GEN-LAST:event_S21ActionPerformed

    private void S11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S11ActionPerformed
        if (board.getBoardAt(1, 1) == Symbols.E && !hasWinner) {
            S11.setIcon(scaleIcon(xIcon));
            board.setBoardAt(Symbols.X, 1, 1);
            moveCount++;
            
            if (finish(board) == Symbols.E) {
                // machine.moveRandom(board.getBoard());
                machine.moveBest(4);

                if (finish(board) == Symbols.O) {
                    machineScore++;
                    MachineScore.setText(Integer.toString(machineScore));
                } 
            }
            else {
                userScore++;
                UserScore.setText(Integer.toString(userScore));
            }
        }
    }//GEN-LAST:event_S11ActionPerformed

    private void S20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S20ActionPerformed
        if (board.getBoardAt(2, 0) == Symbols.E && !hasWinner) {
            S20.setIcon(scaleIcon(xIcon));
            board.setBoardAt(Symbols.X, 2, 0);
            moveCount++;
            
            if (finish(board) == Symbols.E) {
                // machine.moveRandom(board.getBoard());
                machine.moveBest(6);
                if (finish(board) == Symbols.O) {
                    machineScore++;
                    MachineScore.setText(Integer.toString(machineScore));
                }
            }
            else {
                userScore++;
                UserScore.setText(Integer.toString(userScore));
            }
        }
    }//GEN-LAST:event_S20ActionPerformed

    private void S00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S00ActionPerformed
        if (board.getBoardAt(0, 0) == Symbols.E && !hasWinner) {
            S00.setIcon(scaleIcon(xIcon));
            board.setBoardAt(Symbols.X, 0, 0);
            
            moveCount++;
            
            if (finish(board) == Symbols.E) {
                // machine.moveRandom(board.getBoard());
                machine.moveBest(0);
                if (finish(board) == Symbols.O) {
                    machineScore++;
                    MachineScore.setText(Integer.toString(machineScore));
                }
            }
            else {
                userScore++;
                UserScore.setText(Integer.toString(userScore));
            }
        }
    }//GEN-LAST:event_S00ActionPerformed

    private void S01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S01ActionPerformed
        if (board.getBoardAt(0, 1) == Symbols.E && !hasWinner) {
            S01.setIcon(scaleIcon(xIcon));
            board.setBoardAt(Symbols.X, 0, 1);
            moveCount++;
            
            if (finish(board) == Symbols.E) {
                // machine.moveRandom(board.getBoard());
                machine.moveBest(1);
                if (finish(board) == Symbols.O) {
                    machineScore++;
                    MachineScore.setText(Integer.toString(machineScore));
                }
            }
            else {
                userScore++;
                UserScore.setText(Integer.toString(userScore));
            }
        }
    }//GEN-LAST:event_S01ActionPerformed

    private void S10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S10ActionPerformed
        if (board.getBoardAt(1, 0) == Symbols.E && !hasWinner) {
            S10.setIcon(scaleIcon(xIcon));
            board.setBoardAt(Symbols.X, 1, 0);
            moveCount++;
            
            if (finish(board) == Symbols.E) {
                // machine.moveRandom(board.getBoard());
                machine.moveBest(3);
                if (finish(board) == Symbols.O) {
                    machineScore++;
                    MachineScore.setText(Integer.toString(machineScore));
                }
            }
            else {
                userScore++;
                UserScore.setText(Integer.toString(userScore));
            }
        }
    }//GEN-LAST:event_S10ActionPerformed

    private void NewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGameActionPerformed
        // TODO add your handling code here:
        machine.newGame();
        reset();
    }//GEN-LAST:event_NewGameActionPerformed

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MachineScore;
    private javax.swing.JButton NewGame;
    public static javax.swing.JButton S00;
    public static javax.swing.JButton S01;
    public static javax.swing.JButton S02;
    public static javax.swing.JButton S10;
    public static javax.swing.JButton S11;
    public static javax.swing.JButton S12;
    public static javax.swing.JButton S20;
    public static javax.swing.JButton S21;
    public static javax.swing.JButton S22;
    private javax.swing.JLabel UserScore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}