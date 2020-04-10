DELIMITER //
create procedure getstatistics()
BEGIN
SELECT getteams.Season, getteams.Nick, @Total:=@W + @D + @L AS Total,

    @W:=sum(CASE
    WHEN (getteams.Nick9 = DATACyber.NickHome and scorehome > scoreaway) or (getteams.Nick9=DATACyber.NickAway And scorehome<scoreaway) THEN 1
    ELSE 0
    END) AS W,
    sum(CASE
    WHEN (getteams.Nick9 = DATACyber.NickHome and scorehome > scoreaway) or (getteams.Nick9=DATACyber.NickAway And scorehome<scoreaway) THEN 1
    ELSE 0
    END)/@Total "W%",

    @D:=sum(CASE
    WHEN (getteams.Nick9 = DATACyber.NickHome and scorehome = scoreaway) or (getteams.Nick9=DATACyber.NickAway And scorehome=scoreaway) THEN 1
    ELSE 0
    END) AS D,
    sum(CASE
    WHEN (getteams.Nick9 = DATACyber.NickHome and scorehome = scoreaway) or (getteams.Nick9=DATACyber.NickAway And scorehome=scoreaway) THEN 1
    ELSE 0
    END)/@Total AS "D%",

    @L:=sum(CASE
    WHEN (getteams.Nick9 = DATACyber.NickHome and scorehome < scoreaway) or (getteams.Nick9=DATACyber.NickAway And scorehome > scoreaway) THEN 1
    ELSE 0
    END) AS L,
    sum(CASE
    WHEN (getteams.Nick9 = DATACyber.NickHome and scorehome < scoreaway) or (getteams.Nick9=DATACyber.NickAway And scorehome > scoreaway) THEN 1
    ELSE 0
    END)/@Total AS "L%",

    @TB:=sum(CASE
    WHEN (ScoreHome + ScoreAway>2.5) THEN 1
    ELSE 0
    END) AS TB,
    sum(CASE
    WHEN (ScoreHome + ScoreAway>2.5) THEN 1
    ELSE 0
    END)/@Total as 'TB%',

    @TM:=sum(CASE
    WHEN (ScoreHome + ScoreAway<2.5) THEN 1
    ELSE 0
    END) AS TM,
    sum(CASE
    WHEN (ScoreHome + ScoreAway<2.5) THEN 1
    ELSE 0
    END)/@Total as 'TM%'

FROM DATACyber INNER JOIN getteams ON DATACyber.Season = getteams.Season

WHERE (((DATACyber.NickHomeLong) Like CONCAT(Nick9, '%')) AND ((DATACyber.Season)=' Киберфутбол. ФИФА. eSports Battle. Europa League') AND ((str_to_date(left(dates,8), '%d.%m.%Y'))) between cast('2020-04-06' as date) and cast('2020-04-06' as date)
   OR (((DATACyber.Season)=' Киберфутбол. ФИФА. eSports Battle. Europa League') AND ((str_to_date(left(dates,8), '%d.%m.%Y'))) between cast('2020-04-06' as date) and cast('2020-04-06' as date)) AND ((DATACyber.NickAwayLong) Like CONCAT(Nick9, '%')))

GROUP BY getteams.Season, getteams.Nick
ORDER BY Nick;
END;

DELIMITER ;
