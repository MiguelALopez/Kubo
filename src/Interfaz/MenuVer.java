package Interfaz;

import javax.swing.JOptionPane;

public class MenuVer {
    String leaderboard;
    int fullScore=99999;
    public MenuVer()
    {
    }
    
    public void addPlayer(String name, int score)
    {
            this.leaderboard = name;
            this.fullScore = score;
     
    }

    public String getLeaderboard() {
        return leaderboard;
    }

    public int getFullScore() {
        return fullScore;
    }
    
    public void showScore()
    {
        JOptionPane.showMessageDialog(null, "Best Score\n"+this.leaderboard+" - "+this.fullScore);
    }
    
    
}
