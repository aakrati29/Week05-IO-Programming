package com.ioprogramming.day02jasondatahandling.iplandcensoranalyzer;

import java.util.Map;

class IPLMatch {
    int match_id;
    String team1;
    String team2;
    Map<String, Integer> score;
    String winner;
    String player_of_match;

    public IPLMatch(){

    }

    public IPLMatch(int match_id, String team1, String team2, Map<String, Integer> score, String winner, String player_of_match) {
        this.match_id = match_id;
        this.team1 = team1;
        this.team2 = team2;
        this.score = score;
        this.winner = winner;
        this.player_of_match = player_of_match;
    }

    public int getMatch_id() { return match_id; }
    public String getTeam1() { return team1; }
    public String getTeam2() { return team2; }
    public Map<String, Integer> getScore() { return score; }
    public String getWinner() { return winner; }
    public String getPlayer_of_match() { return player_of_match; }

    public void setTeam1(String team1) { this.team1 = team1; }
    public void setTeam2(String team2) { this.team2 = team2; }
    public void setWinner(String winner) { this.winner = winner; }
    public void setPlayer_of_match(String player_of_match) { this.player_of_match = player_of_match; }
}

