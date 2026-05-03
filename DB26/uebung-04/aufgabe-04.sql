select distinct p1.name
from professoren p1
join professoren p2
    on  p1.raum    = p2.raum
    and p1.persnr != p2.persnr;
