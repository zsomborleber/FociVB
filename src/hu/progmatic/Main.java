package hu.progmatic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        List<MatchResults> results = loadMatches("C:\\Users\\Léber Zsombor\\IdeaProjects\\FociVB\\src\\Files\\matches_all.csv");


        System.out.print("Number of matches: ");
        System.out.println(loadMatches("C:\\Users\\Léber Zsombor\\IdeaProjects\\FociVB\\src\\Files\\matches_all.csv").size());


        try {

            List<MatchResults> maxgoaldiff = loadMatches("C:\\Users\\Léber Zsombor\\IdeaProjects\\FociVB\\src\\Files\\matches_all.csv");
            System.out.println("Year of worldcup:");

            Scanner scanner = new Scanner(System.in);
            int getYear = scanner.nextInt();


            int max = Integer.MIN_VALUE;

            for (MatchResults matchResults : maxgoaldiff){
                int sum = 0;
                if (matchResults.getYear() == getYear) {
                    sum = matchResults.getGoalDifference();

                }

                if (sum > max) {
                    max = matchResults.getGoalDifference();
                }
            }


            System.out.println("2. Maximum goal difference: " + max);


            int counter = 0;

            for (MatchResults matchResults : results){
                if (matchResults.getGoalsByTeamA() > matchResults.getGoalsByTeamB()){
                    if(matchResults.getYear() == getYear){
                        counter++;
                    }
                }

            }
            System.out.println("3. The player has won " + counter + " bets.");



            Map<String,Integer> countGoalsByStage = new TreeMap<>();
            System.out.println("4. Total goals by stage:");

            for (MatchResults matchResults : results){
                if (matchResults.getYear() == getYear){
                    int count = countGoalsByStage.getOrDefault(matchResults.getStage(),0);
                    countGoalsByStage.put(matchResults.getStage(),count + (matchResults.getGoalsByTeamA() + matchResults.getGoalsByTeamB()));

                }

            }
            for (String species : countGoalsByStage.keySet()){
                System.out.println(species + ":" + countGoalsByStage.get(species));

            }


        }catch (IOException exception){
            exception.printStackTrace();
        }

    }





    private static List<MatchResults> loadMatches(String path)throws IOException{
        List<MatchResults> results = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;

            reader.readLine(); // fejléc kihagyása
            while ((line = reader.readLine()) != null){
                MatchResults results1 = new MatchResults(line);
                results.add(results1);
            }

        }
        return results;

    }


}
