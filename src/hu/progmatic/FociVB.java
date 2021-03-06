package hu.progmatic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class FociVB {

    public static void main(String[] args) throws IOException {
        List<MatchResults> results = loadMatches();


        System.out.print("Number of matches: ");
        System.out.println(loadMatches().size());
        saveResults(results);



        try {


            List<MatchResults> maxgoaldiff = loadMatches();
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



            Map<String,Integer> countGoalsByStage = new LinkedHashMap<>();
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


    private static void saveResults(Collection<MatchResults> matchResults)throws IOException {
        try (PrintWriter writer = new PrintWriter("C:\\Users\\L??ber Zsombor\\IdeaProjects\\FociVB\\src\\Files\\matches_all.csv")){
            writer.println("stage;date;team_a;team_b;goals_a;goals_b;penalties_a;penalties_b");
            for (MatchResults saveMatch : matchResults ){
                writer.println(saveMatch.toCSV());
            }
        }

    }


    private static List<MatchResults> loadMatches()throws IOException{
        List<MatchResults> results = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\L??ber Zsombor\\IdeaProjects\\FociVB\\src\\Files\\matches_all.csv"))){
            String line;

            reader.readLine(); // fejl??c kihagy??sa
            while ((line = reader.readLine()) != null){
                MatchResults results1 = new MatchResults(line);
                results.add(results1);
            }

        }
        return results;

    }


}
