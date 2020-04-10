package webapplication.dao;

import webapplication.dto.Season;
import webapplication.dto.Statistic;
import java.util.List;

public interface ResultRepositoryCustom {
    List<Statistic> getStatistics(String season);
    List<Season> getSeasons();
}