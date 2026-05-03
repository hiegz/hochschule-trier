select p.persnr, p.name, avg(pr.note) as durchschnittsnote
from professoren p
join pruefen pr on p.persnr = pr.persnr
group by p.persnr, p.name
having avg(pr.note) <= 0.9 * (
    select avg(note) from pruefen
);
