-- select v.vorlnr, v.titel, count(h.matrnr) as anzahl_studenten from vorlesungen v join hoeren h on h.vorlnr = v.vorlnr group by v.vorlnr, v.titel;

-- select v.vorlnr, v.titel, count(h.matrnr) as anzahl_studenten from vorlesungen v left join hoeren h on h.vorlnr = v.vorlnr group by v.vorlnr, v.titel;

-- select v.vorlnr, v.titel, count(h.matrnr) as anzahl_studenten from vorlesungen v left join hoeren h on h.vorlnr = v.vorlnr group by v.vorlnr, v.titel order by anzahl_studenten desc;

-- select v.vorlnr, v.titel, count(h.matrnr) as anzahl_studenten from vorlesungen v left join hoeren h on h.vorlnr = v.vorlnr group by v.vorlnr, v.titel order by anzahl_studenten desc fetch first 1 rows only;

-- select v.vorlnr, v.titel, count(h.matrnr) as anzahl_studenten from vorlesungen v left join hoeren h on h.vorlnr = v.vorlnr group by v.vorlnr, v.titel having count(h.matrnr) >= all (select count(matrnr) as anzahl_studenten from hoeren group by vorlnr);

-- with anz_pro_vorl as (
--     select v.vorlnr, v.titel, count(h.matrnr) anz
--     from hoeren h right outer join vorlesungen v on h.vorlnr = v.vorlnr group by v.vorlnr, v.titel
-- )
-- select * from anz_pro_vorl
-- where anz >= all (select anz from anz_pro_vorl);
