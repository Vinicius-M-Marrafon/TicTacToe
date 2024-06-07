/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author vinic
 */
public class Universe {
    private final Universe childrens[];
    private final Board state;
    private final boolean turn; // true for JoJoILMa, false for user
    private final Symbols winner;
    
    public Universe(Board state, boolean turn) {
        this.state = state;
        this.turn = turn;

        // Check the current state for winner
        Symbols result = Game.finish(state);

        // It has a winner or the stata is a leaf;
        if (result != Symbols.E || state.isFull()) {
            this.winner = result;

            // No game after a winner;
            this.childrens = null;
            return;
        }

        this.winner = Symbols.E;
        this.childrens = new Universe[9];

        for (int i = 0; i < 9; i++) {
            int x = (int)i/ 3;
            int y = i - (3 * x);
            
            if (state.getBoardAt(x, y) == Symbols.E) {
                // Symbols TTT = copy
                Board nextState = new Board(state.getBoard());
                nextState.setBoardAt(turn? Symbols.O : Symbols.X, x, y);

                childrens[i] = new Universe(nextState, !turn);
            } else {
                childrens[i] = null;
            }
        }
    } 
    
    public Symbols getWinner() {
        return this.winner;
    }
    
    public boolean getTurn() {
        return this.turn;
    }
    
    public Universe[] getChildrens() {
        return this.childrens;
    }
    
    public Universe getChildrenAt(int index) {
        return this.childrens[index];
    }
    
    
    public void dispState() {
        System.out.println(this.toString());
    }
    
    public void dispUniverse(Universe node) {
        System.out.println(node.toString());
        for (int i = 0; i < 9; i++) {
            if (node.childrens[i] != null) {
                dispUniverse(node.childrens[i]);
            }
        }
    }
    
    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n\t");
        sb.append("Turn: ").append(this.turn? "Machine":"User").append("\n\t");
        sb.append(this.state.toString());
        sb.append("\tWinner: ").append(this.winner);
        sb.append("\n]\n");
        return sb.toString();
    }
}
