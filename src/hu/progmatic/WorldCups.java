package hu.progmatic;

import java.util.ArrayList;
import java.util.List;

public class WorldCups {
    private List<MatchResults> results = new ArrayList<>();
    private int year;
    private String host;
    private String confederation;
    private String dateFrom;
    private String dateTo;

    public WorldCups() {
    }

    public WorldCups(String line) {

        String[] parts = line.split(";");
        this.year = Integer.parseInt(parts[0]);
        this.host = parts[1];
        this.confederation = parts[2];
        this.dateFrom = parts[3];
        this.dateTo = parts[4];
    }

    public List<MatchResults> getResults() {
        return results;
    }

    public void setResults(List<MatchResults> results) {
        this.results = results;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getConfederation() {
        return confederation;
    }

    public void setConfederation(String confederation) {
        this.confederation = confederation;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }
}
