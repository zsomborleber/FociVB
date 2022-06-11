package hu.progmatic;

public class MatchResults {

    private int year;
    private String stage;
    private String date;
    private String teamA;
    private String teamB;
    private int goalsByTeamA;
    private int goalsByTeamB;
    private int penaltiesA;
    private int getPenaltiesB;

    public MatchResults() {
    }

    public MatchResults(String line) {

        String[] parts = line.split(";");

        if (parts.length > 7){
            this.year = Integer.parseInt(parts[0]);
            this.stage = parts[1];
            this.date = parts[2];
            this.teamA = parts[3];
            this.teamB = parts[4];
            this.goalsByTeamA = Integer.parseInt(parts[5]);
            this.goalsByTeamB = Integer.parseInt(parts[6]);
            this.penaltiesA = Integer.parseInt(parts[7]);
            this.getPenaltiesB = Integer.parseInt(parts[8]);
        } else {
            this.year = Integer.parseInt(parts[0]);
            this.stage = parts[1];
            this.date = parts[2];
            this.teamA = parts[3];
            this.teamB = parts[4];
            this.goalsByTeamA = Integer.parseInt(parts[5]);
            this.goalsByTeamB = Integer.parseInt(parts[6]);

        }

    }
    public int getGoalDifference(){
        return goalsByTeamA >= goalsByTeamB ? goalsByTeamA - goalsByTeamB : goalsByTeamB - goalsByTeamA ;
    }

    public  String toCSV(){
        return year + ";" + stage + ";" + date +";"
                + teamA + ";" + teamB + ";"
                + goalsByTeamA + ";" + goalsByTeamB + ";" + penaltiesA + ";" + getPenaltiesB;
    }



    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public int getGoalsByTeamA() {
        return goalsByTeamA;
    }

    public void setGoalsByTeamA(int goalsByTeamA) {
        this.goalsByTeamA = goalsByTeamA;
    }

    public int getGoalsByTeamB() {
        return goalsByTeamB;
    }

    public void setGoalsByTeamB(int goalsByTeamB) {
        this.goalsByTeamB = goalsByTeamB;
    }

    public int getPenaltiesA() {
        return penaltiesA;
    }

    public void setPenaltiesA(int penaltiesA) {
        this.penaltiesA = penaltiesA;
    }

    public int getGetPenaltiesB() {
        return getPenaltiesB;
    }

    public void setGetPenaltiesB(int getPenaltiesB) {
        this.getPenaltiesB = getPenaltiesB;
    }
}
