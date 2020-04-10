package webapplication.dao;

import webapplication.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import webapplication.dto.Statistic;

import java.util.List;

public interface Dao extends JpaRepository<Result, Integer>, ResultRepositoryCustom {
    List<Statistic> getStatistics(String season);
}
