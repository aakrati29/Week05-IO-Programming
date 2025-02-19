package com.ioprogramming.day02jasondatahandling.iplandcensoranalyzer;

import java.util.List;
import java.util.ArrayList;

public class IPLCensored {

    public static List<IPLMatch> applyCensorship(List<IPLMatch> matches) {
        List<IPLMatch> censoredMatches = new ArrayList<>();

        for (IPLMatch match : matches) {
            // Masking team names
            String censoredTeam1 = maskTeamName(match.getTeam1());
            String censoredTeam2 = maskTeamName(match.getTeam2());
            String censoredWinner = maskTeamName(match.getWinner());

            IPLMatch censoredMatch = new IPLMatch(
                    match.getMatch_id(),
                    censoredTeam1,
                    censoredTeam2,
                    match.getScore(),
                    censoredWinner,
                    "REDACTED"
            );
            censoredMatches.add(censoredMatch);
        }
        return censoredMatches;
    }

    private static String maskTeamName(String teamName) {
        if (teamName == null || teamName.isEmpty()) return teamName;
        String[] words = teamName.split(" ");
        return words[0] + " ***";
    }
}

