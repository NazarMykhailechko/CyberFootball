package webapplication.model;

import webapplication.dto.Season;
import webapplication.dto.Statistic;

import javax.persistence.*;

@NamedNativeQuery(name = "Season", query = "select * from getseasons", resultSetMapping = "Season")
@SqlResultSetMapping(name = "Season", classes = @ConstructorResult(targetClass = Season.class,
        columns = {
                @ColumnResult(name = "season"),
        }
)
)

@NamedNativeQuery(name = "Statistic", query = "select * from getstatall where Season = ?", resultSetMapping = "Statistic")
@SqlResultSetMapping(name = "Statistic", classes = @ConstructorResult(targetClass = Statistic.class,
        columns = {
                @ColumnResult(name = "SEASON"),
                @ColumnResult(name = "NICK"),
                @ColumnResult(name = "TOTAL", type = int.class),
                @ColumnResult(name = "W", type = int.class),
                @ColumnResult(name = "Wp"),
                @ColumnResult(name = "D", type = int.class),
                @ColumnResult(name = "Dp"),
                @ColumnResult(name = "L", type = int.class),
                @ColumnResult(name = "Lp"),
                @ColumnResult(name = "TB", type = int.class),
                @ColumnResult(name = "TBp"),
                @ColumnResult(name = "TM", type = int.class),
                @ColumnResult(name = "TMp")
        }
)
)

@Entity
@Table(name = "datacyber")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "dates",nullable = false)
    private String dates;

    @Column(name = "teamhomelong")
    private String teamhomelong;

    @Column(name = "teamawaylong")
    private String teamawaylong;

    @Column(name = "result",nullable = false)
    private String result;

    @Column(name = "season",nullable = false)
    private String season;

    @Column(name = "times",nullable = false)
    private String times;

    @Column(name = "nickhomelong")
    private String nickhomelong;

    @Column(name = "nickawaylong")
    private String nickawaylong;

    @Column(name = "scorehome",nullable = false)
    private int scorehome;

    @Column(name = "scoreaway",nullable = false)
    private int scoreaway;

    @Column(name = "teamhome",nullable = false)
    private String teamhome;

    @Column(name = "teamaway",nullable = false)
    private String teamaway;

    @Column(name = "nickhome")
    private String nickhome;

    @Column(name = "nickaway")
    private String nickaway;

    public Result() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getTeamhome() {
        return teamhome;
    }

    public void setTeamhome(String teamhome) {
        this.teamhome = teamhome;
    }

    public String getTeamaway() {
        return teamaway;
    }

    public void setTeamaway(String teamaway) {
        this.teamaway = teamaway;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getTeamhomelong() {
        return teamhomelong;
    }

    public void setTeamhomelong(String teamhomelong) {
        this.teamhomelong = teamhomelong;
    }

    public String getTeamawaylong() {
        return teamawaylong;
    }

    public void setTeamawaylong(String teamawaylong) {
        this.teamawaylong = teamawaylong;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getNickhomelong() {
        return nickhomelong;
    }

    public void setNickhomelong(String nickhomelong) {
        this.nickhomelong = nickhomelong;
    }

    public String getNickawaylong() {
        return nickawaylong;
    }

    public void setNickawaylong(String nickawaylong) {
        this.nickawaylong = nickawaylong;
    }

    public int getScorehome() {
        return scorehome;
    }

    public void setScorehome(int scorehome) {
        this.scorehome = scorehome;
    }

    public int getScoreaway() {
        return scoreaway;
    }

    public void setScoreaway(int scoreaway) {
        this.scoreaway = scoreaway;
    }

    public String getNickhome() {
        return nickhome;
    }

    public void setNickhome(String nickhome) {
        this.nickhome = nickhome;
    }

    public String getNickaway() {
        return nickaway;
    }

    public void setNickaway(String nickaway) {
        this.nickaway = nickaway;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", dates='" + dates + '\'' +
                ", teamhomelong='" + teamhomelong + '\'' +
                ", teamawaylong='" + teamawaylong + '\'' +
                ", result='" + result + '\'' +
                ", season='" + season + '\'' +
                ", times='" + times + '\'' +
                ", nickhomelong='" + nickhomelong + '\'' +
                ", nickawaylong='" + nickawaylong + '\'' +
                ", scorehome=" + scorehome +
                ", scoreaway=" + scoreaway +
                ", teamhome='" + teamhome + '\'' +
                ", teamaway='" + teamaway + '\'' +
                ", nickhome='" + nickhome + '\'' +
                ", nickaway='" + nickaway + '\'' +
                '}';
    }
}

