#import "mathblock.typ": mathblock
#show link: underline

Beweis des Satzes 1.7 (2) mit Hilfe der Zerlegungsformel. (#link(
  "https://mathepedia.de/Stetigkeit_Grenzwerte_und_Stetigkeit.html",
)[Quelle])

#mathblock[
  $
    f(x + h) = f(x) + f'(x) dot h + r(h)
  $
]

mit $lim_(h -> 0)r(h) = 0$

Dann gilt

#mathblock[
  $
    lim_(h -> 0)f(x + h) = lim_(h -> 0)(f(x) + f'(x) dot h + r(h)) = f(x)
  $
]

und nach #link(
  "https://mathepedia.de/Stetigkeit_Grenzwerte_und_Stetigkeit.html",
)[Satz 5225F] ist $f$ an der Stelle $x$ stetig. #sym.square
