/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.HashMap;
import java.util.Random;
import javax.swing.JButton;
/**
 *
 * @author vinic
 */
public class JoJoILMa {
    private Universe knowledge;
    private final Universe root;
    private final Random random;
    private final HashMap<Integer, JButton> translate;
    
    public JoJoILMa() {
        random = new Random();
        root = knowledge = new Universe(new Board(), false);
        translate = new HashMap<>();
        
        translate.put(0, Game.S00);
        translate.put(1, Game.S01);
        translate.put(2, Game.S02);
        translate.put(3, Game.S10);
        translate.put(4, Game.S11);
        translate.put(5, Game.S12);
        translate.put(6, Game.S20);
        translate.put(7, Game.S21);
        translate.put(8, Game.S22);
    }
    
    public void newGame() {
        this.knowledge = root;
    }
    
    // Receive the current state of the game
    public void moveRandom(Symbols[][] ttt) {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        }
        while (ttt[x][y] != Symbols.E);
        
        // Update the model
        ttt[x][y] = Symbols.O;
        // Update the View
        int index = (3 * x) + y;
        JButton square = translate.get(index);
        
        if (square != null) {
            square.setText("O");
            Game.moveCount++;
        }
    }
    
    public void moveBest(int userChoice) {
        // Update
        knowledge = knowledge.getChildrenAt(userChoice);
        // knowledge.dispState();
        
        // End of game
        if (knowledge.getChildrens() == null) return;
        
        // Map possibilities
        int best = -1, choice = -1;
        for (int i = 0; i < 9; i++) {
            Universe variant = knowledge.getChildrenAt(i);
            if (variant != null) {
                int score = minimax(variant, 9, false);
                
                // Choose the best option
                if (score > best) {
                    best = score;
                    choice = i;
                } else if (score == best) {
                    int playIt = random.nextInt(2);
                    if (playIt == 1) {
                        choice = i;
                    }
                }
            }
        }
        System.out.println("Move: "+choice+" choosen! Pot: "+best);
        JButton square = this.translate.get(choice);
        if (square != null) {
            // square.setText("O");
            square.setIcon(Game.scaleIcon(Game.oIcon));
            
            int x = (int)choice/ 3;
            int y = choice - (3 * x);
            
            Game.board.setBoardAt(Symbols.O, x, y);
            Game.moveCount++;
            
            // update it again
            knowledge = knowledge.getChildrenAt(choice);
            // knowledge.dispState();
        }
    } 
    
    public int minimax(Universe node, int depth, boolean turn) {
        // If the current node is leaf;
        if (depth == 0 || node.getChildrens() == null) {
            Symbols result = node.getWinner();
            if (null != result) switch (result) {
                case X:
                    return -1;
                    // return -depth;
                case E:
                    return 0;
                case O:
                    // return +1;
                    return +depth;
                default:
                    break;
            }
        }
        
        // Minimize player
        if (!turn) {
            int value = Integer.MAX_VALUE;
            for (Universe children : node.getChildrens()) {
                if (children != null) {
                    value = Math.min(value, minimax(children, depth - 1, true));
                }
            }
            return value;
        }
        // Maximize
        else {
            int value = Integer.MIN_VALUE;
            for (Universe children : node.getChildrens()) {
                if (children != null) {
                    value = Math.max(value, minimax(children, depth - 1, false));
                }
            }
            return value;
        }
    }
}
