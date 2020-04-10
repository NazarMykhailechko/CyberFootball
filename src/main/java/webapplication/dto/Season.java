package webapplication.dto;

public class Season {

    private String season;

    public Season() {
    }

    public Season(String season) {
        this.season = season;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return season;
    }
}
