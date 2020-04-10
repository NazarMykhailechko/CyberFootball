create definer = root@localhost view getstatall as
select `qq`.`Season`                                              AS `Season`,
       `qq`.`Nick`                                                AS `Nick`,
       `qq`.`TOTAL`                                               AS `TOTAL`,
       `qq`.`W`                                                   AS `W`,
       concat(format(((`qq`.`W` / `qq`.`TOTAL`) * 100), 1), '%')  AS `Wp`,
       `qq`.`D`                                                   AS `D`,
       concat(format(((`qq`.`D` / `qq`.`TOTAL`) * 100), 1), '%')  AS `Dp`,
       `qq`.`L`                                                   AS `L`,
       concat(format(((`qq`.`L` / `qq`.`TOTAL`) * 100), 1), '%')  AS `Lp`,
       `qq`.`TB`                                                  AS `TB`,
       concat(format(((`qq`.`TB` / `qq`.`TOTAL`) * 100), 1), '%') AS `TBp`,
       `qq`.`TM`                                                  AS `TM`,
       concat(format(((`qq`.`TM` / `qq`.`TOTAL`) * 100), 1), '%') AS `TMp`
from (select `q`.`Season`                    AS `Season`,
             `q`.`Nick`                      AS `Nick`,
             ((`q`.`W` + `q`.`D`) + `q`.`L`) AS `TOTAL`,
             `q`.`W`                         AS `W`,
             `q`.`D`                         AS `D`,
             `q`.`L`                         AS `L`,
             `q`.`TB`                        AS `TB`,
             `q`.`TM`                        AS `TM`
      from (select `getteams`.`season`   AS `Season`,
                   `getteams`.`Nick`     AS `Nick`,
                   sum((case
                            when (((`getteams`.`Nick9` = `cyberfootball`.`datacyber`.`nickhome`) and
                                   (`cyberfootball`.`datacyber`.`scorehome` >
                                    `cyberfootball`.`datacyber`.`scoreaway`)) or
                                  ((`getteams`.`Nick9` = `cyberfootball`.`datacyber`.`nickaway`) and
                                   (`cyberfootball`.`datacyber`.`scorehome` < `cyberfootball`.`datacyber`.`scoreaway`)))
                                then 1
                            else 0 end)) AS `W`,
                   sum((case
                            when (((`getteams`.`Nick9` = `cyberfootball`.`datacyber`.`nickhome`) and
                                   (`cyberfootball`.`datacyber`.`scorehome` =
                                    `cyberfootball`.`datacyber`.`scoreaway`)) or
                                  ((`getteams`.`Nick9` = `cyberfootball`.`datacyber`.`nickaway`) and
                                   (`cyberfootball`.`datacyber`.`scorehome` = `cyberfootball`.`datacyber`.`scoreaway`)))
                                then 1
                            else 0 end)) AS `D`,
                   sum((case
                            when (((`getteams`.`Nick9` = `cyberfootball`.`datacyber`.`nickhome`) and
                                   (`cyberfootball`.`datacyber`.`scorehome` <
                                    `cyberfootball`.`datacyber`.`scoreaway`)) or
                                  ((`getteams`.`Nick9` = `cyberfootball`.`datacyber`.`nickaway`) and
                                   (`cyberfootball`.`datacyber`.`scorehome` > `cyberfootball`.`datacyber`.`scoreaway`)))
                                then 1
                            else 0 end)) AS `L`,
                   sum((case
                            when ((`cyberfootball`.`datacyber`.`scorehome` + `cyberfootball`.`datacyber`.`scoreaway`) >
                                  2.5) then 1
                            else 0 end)) AS `TB`,
                   sum((case
                            when ((`cyberfootball`.`datacyber`.`scorehome` + `cyberfootball`.`datacyber`.`scoreaway`) <
                                  2.5) then 1
                            else 0 end)) AS `TM`
            from (`cyberfootball`.`datacyber`
                     join `cyberfootball`.`getteams` on ((`cyberfootball`.`datacyber`.`season` = `getteams`.`season`)))
            where (((`cyberfootball`.`datacyber`.`nickhomelong` like concat(`getteams`.`Nick9`, '%')) and
                    (str_to_date(left(`cyberfootball`.`datacyber`.`dates`, 8),
                                 '%d.%m.%Y') between cast('2020-04-06' as date) and cast('2020-04-06' as date))) or
                   ((str_to_date(left(`cyberfootball`.`datacyber`.`dates`, 8),
                                 '%d.%m.%Y') between cast('2020-04-06' as date) and cast('2020-04-06' as date)) and
                    (`cyberfootball`.`datacyber`.`nickawaylong` like concat(`getteams`.`Nick9`, '%'))))
            group by `getteams`.`season`, `getteams`.`Nick`) `q`) `qq`
order by `qq`.`Nick`;

