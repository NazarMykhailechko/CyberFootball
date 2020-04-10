package webapplication.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import webapplication.dto.Season;
import webapplication.dao.Dao;
import webapplication.model.Result;

import java.io.IOException;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {

     @Autowired
     Dao dao;

    @RequestMapping("/")
    public String home(Model model) throws IOException {
        refreshCyberFootballData();
        //ModelAndView mav = new ModelAndView("index");
        //mav.addObject("tournaments", dao.getSeasons());
        //mav.addObject("season", new Season());
        model.addAttribute("tournaments", dao.getSeasons());
        model.addAttribute("season", new Season());
        return "index";
        //return mav;
    }

//    @RequestMapping(value = "/statistics")
//    public String getStatistics(Model model) throws IOException {
//        model.addAttribute("results", dao.getStatistics());
//        return "statistics";
//    }

//    @RequestMapping(value = "/statistics", method = RequestMethod.POST)
//    public String getStatistics(@RequestParam("name") String name) throws IOException {
//        System.out.println(name);
//        return "statistics";
//    }

    @RequestMapping(value="/statistics")
    private String getStatistics(Model model, @ModelAttribute("season") Season season) {
        //ModelAndView mav = new ModelAndView("statistics");
        model.addAttribute("season", season.getSeason());
        System.out.println(season.getSeason());
        model.addAttribute("results", dao.getStatistics(season.getSeason()));
        //mav.addObject("tournament", tournament);
        return "statistics";
    }

    public void refreshCyberFootballData(){

        String dates = "";
        String teamhomelong = "";
        String teamawaylong = "";
        String result = "";
        String times = "";
        String nickhomelong = "";
        String nickawaylong = "";
        int scorehome;
        int scoreaway;
        String teamhome = "";
        String teamaway = "";
        String nickhome = "";
        String nickaway = "";

        int i;

        Document doc = null;
        try {
            doc = Jsoup.connect("https://classic.parimatch.com/res-frame.html?&Date=20200406&SK=21").get();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements elements = doc.getElementsByClass("TT");//getElementsByTag("div");//select("#mp-itn b a");

        String cyber = "";

        for (Element e : elements) {

            Elements elems = e.getElementsByTag("tr");

            for (Element elem : elems) {

                if (elem.html().contains("class=\"TH\"")) {
                    cyber = elem.text();
                }

                Elements tur = elem.getElementsByTag("td");

                if (elem.html().contains("<td class=\"Mono\" nowrap>")
                        && elem.html().contains("<td class=\"Mono\" align=")
                        && !elem.html().contains("Хозяева")
                        && !elem.html().contains("Гости")
                        && elem.html().endsWith(")</td>")
                        && cyber.contains("Киберфутбол")) {
                    System.out.println("----------------------------------------------------------------");

                    i = 1;
                    for (Element t : tur) {
                        System.out.println(t.text());

                        switch (i) {
                            case (1):
                                dates = t.text();
                                break;
                            case (2):
                                teamhomelong = t.text();
                                break;
                            case (3):
                                teamawaylong = t.text();
                                break;
                            case (4):
                                result = t.text();
                                break;
                        }
                        i++;
                    }

                    times = dates.substring(dates.indexOf(' ') + 1).trim();
                    nickhomelong = teamhomelong.substring(teamhomelong.indexOf('(')).trim();
                    nickawaylong = teamawaylong.substring(teamawaylong.indexOf('(')).trim();
                    scorehome = Integer.parseInt(result.substring(0, result.indexOf(':')).trim());
                    scoreaway = Integer.parseInt(result.substring(result.indexOf(':') + 1, result.indexOf(' ')).trim());
                    teamhome = teamhomelong.substring(0, teamhomelong.indexOf('(') - 1).trim();
                    teamaway = teamawaylong.substring(0, teamawaylong.indexOf('(') - 1).trim();
                    nickhome = nickhomelong.length() > 9 ? nickhomelong.substring(0, 9) : nickhomelong;
                    nickaway = nickawaylong.length() > 9 ? nickawaylong.substring(0, 9) : nickawaylong;

                    Result res = new Result();

                    res.setDates(dates);
                    res.setTeamhomelong(teamhomelong);
                    res.setTeamawaylong(teamawaylong);
                    res.setNickhomelong(nickhomelong);
                    res.setNickawaylong(nickawaylong);
                    res.setResult(result);
                    res.setSeason(cyber);
                    res.setTimes(times);
                    res.setScorehome(scorehome);
                    res.setScoreaway(scoreaway);
                    res.setTeamhome(teamhome);
                    res.setTeamaway(teamaway);
                    res.setNickhome(nickhome);
                    res.setNickaway(nickaway);

                    dao.save(res);
                }

            }

        }
    }
}
