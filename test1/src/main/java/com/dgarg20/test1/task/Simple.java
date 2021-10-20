package com.dgarg20.test1.task;


import java.util.*;

/**
 * Created by Deepanshu Garg on 01/07/21.
 */
public class Simple {
    public static void main(String[] args) {
     Simple s = new Simple();

//     System.out.println(s.findWineer(Arrays.asList("A", "B", "A", "C", "D", "B", "A")));
//     System.out.println(s.findWineer(Arrays.asList("A", "B", "A", "C", "D", "B", "A", "B", "B", "B")));
//     System.out.println(s.findWineer(Arrays.asList("A", "B", "A", "C", "D", "B", "A", "B")));
//     System.out.println(s.findWineer(Arrays.asList("A@3", "B@2", "C@1", "A@3", "B@2", "C@1")));


       System.out.println(s.findWineer(Arrays.asList(new VoteObj("A", 3),
               new VoteObj("B", 1),
               new VoteObj("B", 1),
               new VoteObj("B", 1))));


    }

    /**
     * Candidate 1: 3 points
     *
     * Candidate 2: 2 points
     *
     * Candidate 3: 1 point
     *
     *
     *
     *
     *        Candidate 1: 1 points
     *      *
     *      * Candidate 2: 1 points
     *      *
     *      * Candidate 3: 1 point
     * @param votes
     * @return
     *
     */

    public String findWinner(List<VoteObj> votes) {
        Map<String, TieObj> votesCount = new HashMap<>();

        int maxVotes = 0;
        String winner = votes.get(0).getCandidate();

        for(VoteObj s: votes){
            if(votesCount.containsKey(s.getCandidate().toUpperCase())) {

                int absWeight = votesCount.get(s.getCandidate().toUpperCase()).getTotalAbsVotes();
                int maxWeighted = votesCount.get(s.getCandidate().toUpperCase()).getTotalAbsVotes();

                votesCount.get(s.getCandidate().toUpperCase()).setTotalAbsVotes(absWeight + s.getWeight());

                if(maxWeighted < s.getWeight()) {
                    votesCount.get(s.getCandidate().toUpperCase()).setMaxWeightedVote(s.getWeight());
                }

                if(votesCount.get(s.getCandidate().toUpperCase()).getTotalAbsVotes() > maxVotes){
                    maxVotes = votesCount.get(s.getCandidate().toUpperCase()).getTotalAbsVotes();
                    winner = s.getCandidate();
                }
                else if(votesCount.get(s.getCandidate().toUpperCase()).getTotalAbsVotes() == maxVotes){
                    if(votesCount.get(winner).getMaxWeightedVote() < maxWeighted){
                        maxVotes = votesCount.get(s.getCandidate().toUpperCase()).getTotalAbsVotes();
                        winner = s.getCandidate();
                    }
                }
            }
            else {
                votesCount.put(s.getCandidate().toUpperCase(), new TieObj(s.getWeight(), s.getWeight()));
                if(votesCount.get(s.getCandidate().toUpperCase()).getTotalAbsVotes() > maxVotes){
                    maxVotes = votesCount.get(s.getCandidate().toUpperCase()).getTotalAbsVotes();
                    winner = s.getCandidate();
                }
                else if(votesCount.get(s.getCandidate().toUpperCase()).getTotalAbsVotes() == maxVotes){
                    if(votesCount.get(winner).getMaxWeightedVote() < s.getWeight()){
                        maxVotes = votesCount.get(s.getCandidate().toUpperCase()).getTotalAbsVotes();
                        winner = s.getCandidate();
                    }
                }
            }
        }




//        for(Map.Entry<String, Integer> entry: votesCount.entrySet()) {
//            if(entry.getValue() >= maxVotes){
//                maxVotes = entry.getValue();
//                winner = entry.getKey();
//            }
//        }
        return winner;
    }



}
