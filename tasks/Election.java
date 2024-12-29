import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.lang.Math;


public class Election {

    public static void main(String[] args) {
        // zadanie 1:
        votesPerCandidate(VOTES);
        // zadanie 2:
        votesPerState(VOTES);
    }

    private static final String[] VOTES = {
        "Joe,Sydnie Jernigan,Floryda",
        "Joe,Meagan Fleming,Ohio",
        "Joe,Denzil Samuelson,Nowy Jork",
        "Joe,Noel Dyer,Arizona",
        "Donald,Ralf Darrell,Nowy Jork",
        "Donald,Kerr Norwood,Arizona",
        "Joe,Desiree Morin,Nowy Jork",
        "Donald,Christa Jefferson,Ohio",
        "Donald,Avaline Romilly,Arizona",
        "Donald,Caelan Aylmer,Floryda",
        "Joe,Kaydence Hepburn,Nowy Jork",
        "Joe,Tobias Thorburn,Arizona",
        "Donald,Lester Royceston,Floryda",
        "Joe,Hazel Mann,Nowy Jork",
        "Donald,Christa Jefferson,Ohio",
        "Joe,Hilda Herman,Nowy Jork",
        "Joe,Berenice Derrickson,Nowy Jork",
        "Joe,Patsy Waters,Nowy Jork",
        "Joe,Fran Elliott,Ohio",
        "Joe,Denzil Samuelson,Nowy Jork",
        "Donald,Augusta Tasker,Nowy Jork",
        "Donald,Fox Sherburne,Arizona",
        "Donald,Christa Jefferson,Ohio",
        "Joe,Desiree Morin,Nowy Jork",
        "Donald,Christa Jefferson,Ohio"
    };

    public static void votesPerCandidate(String[] VOTES) {
        // zadanie 1
        HashMap<String, Integer> voteCount = new HashMap<>();

        for (String vote : VOTES) {
            String[] voteData = vote.split(",");
            String candidate = voteData[0];
            voteCount.merge(candidate, 1, Integer::sum);
        }

        for (String candidate : voteCount.keySet()) {
            System.out.println(candidate.toUpperCase() + " " + voteCount.get(candidate));
        }
    }

    public static void votesPerState(String[] VOTES) {
    // zadanie 2
        HashMap<String, HashMap<String, HashSet<String>>> voteCount = new HashMap<>();
        HashMap<String, HashSet<String>> candidateAndVotes;
        HashSet<String> voters;

        for (String vote : VOTES) {
            String[] voteData = vote.split(",");
            String candidate = voteData[0];
            String voter = voteData[1];
            String state = voteData[2];

            if (voteCount.containsKey(state)) {
                candidateAndVotes = voteCount.get(state);
                if (candidateAndVotes.containsKey(candidate)) {
                    voters = candidateAndVotes.get(candidate);
                    voters.add(voter);
                    candidateAndVotes.put(candidate, voters);
                } else {
                    voters = new HashSet<>();
                    voters.add(voter);
                    candidateAndVotes.put(candidate, voters);
                }
            } else {
                candidateAndVotes = new HashMap<>();
                voters = new HashSet<>();
                voters.add(voter);
                candidateAndVotes.put(candidate, voters);
                voteCount.put(state, candidateAndVotes);
            }
        }
        
        String theWinner = stateWinner(voteCount);
        System.out.println("And the winner is " + theWinner);
    }

    public static String stateWinner(HashMap<String, HashMap<String, HashSet<String>>> voteCount) {
        Integer joeVictories = 0;
        Integer donaldVictories = 0;
        
        for (String state : voteCount.keySet()) {
            HashMap<String, HashSet<String>> candidateAndVotes = voteCount.get(state);
            HashSet<String> joeVoters = candidateAndVotes.get("Joe");
            HashSet<String> donaldVoters = candidateAndVotes.get("Donald");
            Integer joeVotes = joeVoters.size();
            Integer donaldVotes = donaldVoters.size();

            if (joeVotes > donaldVotes) {
                joeVictories += 1;
            } else {
                donaldVictories +=1;
            }
        }
        
        if (Math.max(joeVictories, donaldVictories) == joeVictories) {
            return "Joe!";
        } else {
            return "Donald!";
        }
    }
}