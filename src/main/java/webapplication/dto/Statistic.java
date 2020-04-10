package webapplication.dto;

public class Statistic {

    private String season;
    private String nick;
    private int total;
    private int w;
    private String wp;
    private int d;
    private String dp;
    private int l;
    private String lp;
    private int tb;
    private String tbp;
    private int tm;
    private String tmp;

    public Statistic() {
    }
    public Statistic(String season, String nick, int total, int w, String wp, int d, String dp, int l, String lp, int tb, String tbp, int tm, String tmp) {
        this.season = season;
        this.nick = nick;
        this.total = total;
        this.w = w;
        this.wp = wp;
        this.d = d;
        this.dp = dp;
        this.l = l;
        this.lp = lp;
        this.tb = tb;
        this.tbp = tbp;
        this.tm = tm;
        this.tmp = tmp;
    }

    public String getSeason() {
        return season;
    }
    public String getNick() {
        return nick;
    }
    public int getTotal() {
        return total;
    }
    public int getW() {
        return w;
    }
    public String getWp() {
        return wp;
    }
    public int getD() {
        return d;
    }
    public String getDp() {
        return dp;
    }
    public int getL() {
        return l;
    }
    public String getLp() {
        return lp;
    }
    public int getTb() {
        return tb;
    }
    public String getTbp() {
        return tbp;
    }
    public int getTm() {
        return tm;
    }
    public String getTmp() {
        return tmp;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "season='" + season + '\'' +
                ", nick='" + nick + '\'' +
                ", total=" + total +
                ", w=" + w +
                ", wp=" + wp +
                ", d=" + d +
                ", dp=" + dp +
                ", l=" + l +
                ", lp=" + lp +
                ", tb=" + tb +
                ", tbp=" + tbp +
                ", tm=" + tm +
                ", tmp=" + tmp +
                '}';
    }
}
