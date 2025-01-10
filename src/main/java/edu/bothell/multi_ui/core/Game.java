package edu.bothell.multi_ui.core;

import java.util.ArrayList;

public class Game {
    private final int MAX_PLAYERS = 2;
    private final ArrayList<Player> players;
    private final State state;
    private int turn;
    private Player active;

    public Game() {
        this.turn = 0;
        this.state = new State(3, 3); // 3x3 grid for tic-tac-toe
        this.players = new ArrayList<>();
    }

    public Player addPlayer(Player player) {
        if (players.size() < MAX_PLAYERS) {
            players.add(player);
            return player;
        }
        return null;
    }

    public boolean playMove(int row, int col) {
        if (state.isValidMove(row, col)) {
            state.makeMove(row, col, active.getChar());
            if (state.checkWin(active.getChar())) {
                System.out.println("Player " + active.getChar() + " wins!");
                return true;
            }
            nextTurn();
        }
        return false;
    }

    private void nextTurn() {
        turn = (turn + 1) % players.size();
        active = players.get(turn);
    }

    public void start() {
        if (players.size() == MAX_PLAYERS) {
            active = players.get(0);
        } else {
            System.out.println("Not enough players to start.");
        }
    }
}



/*package edu.bothell.multi_ui.core;

import java.util.ArrayList;


public class Game {
    private final int                  MAX_PLAYERS = 3;
    private final ArrayList<Player>    p;
    private final State                s;
    private int                        turn;
    private Player                     active;

    public Game(Control c){
        this.turn = 0;
        this.s = new World();
        this.p = new ArrayList<>();
    }
    
    public Player addPlayer(Player p){
        this.p.add(p);
        if(this.active == null) active = p;

        return p;
    }

    public Player addPlayer(char c, String sId){
        Player p = new Player(c);
        p.setSId(sId);
        return addPlayer(p);
    }

    public char[] getPlayersChar(){
        char[] pcs = new char[p.size()];
        for(int i = 0; i < pcs.length; i++) 
            pcs[i] = p.get(i).getChar();
        
        return pcs;
    }
    
    public boolean isValid(int[] pos, String sId){
        System.out.println("isVAlid?"+s.getIt(pos)+"|" + sId+"|" + active.getSId()+"|");
        return s.isOpen(pos) && active.getSId().equals(sId);
    }

    public char play(int[] pos, String sId){
        if(!isValid(pos, sId)) return ' ';
        turn++;
        this.s.setIt(active.getChar(), pos[0], pos[1]);
        this.active = p.get( turn % p.size() );

        return active.getChar();
    }

    public Player getActive() {
        return this.active;
    }

    public State getState() {
        return this.s;
    }

    public Location getLocation(int x, int y) {
        return ((World)s).getLocation(x, y);
    }

    public int getMaxPlayers() {
        return MAX_PLAYERS;
    }

    public int getPlayerCount() {
        return p.size();
    }

    public ArrayList<Player> getPlayers(){
        return this.p;
    }

    public int getTurn(){
        return this.turn;
    }


}
*/