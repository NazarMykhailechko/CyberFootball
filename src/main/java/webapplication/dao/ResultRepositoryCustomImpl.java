package webapplication.dao;

import org.springframework.stereotype.Component;
import webapplication.dto.Season;
import webapplication.dto.Statistic;

import javax.persistence.*;
import java.util.List;


@Component
public class ResultRepositoryCustomImpl implements ResultRepositoryCustom  {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Statistic> getStatistics(String season) {
        List<Statistic> res = em.createNamedQuery("Statistic").setParameter(1,season).getResultList();
        return res;
    }

    @Override
    public List<Season> getSeasons() {
        List<Season> seasons = em.createNamedQuery("Season").getResultList();
        return seasons;
    }
}