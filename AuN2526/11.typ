#import "mathblock.typ": mathblock

Ein bekanter Satz der Analysis besagt das Folgende: Ist $f: [a, b] -> RR$
stetig, und auf $(a, b)$ differenzierbar, und gilt $f(a) = f(b)$ so gibt es ein
$xi in (a, b)$ mit

$ f'(xi) = 0 $

+ Skizzieren Sie graphisch die Aussage dieses Satz.

  --

+ Es sei $g: [a, b] -> RR$ stetig, und auf $(a, b)$ differenzierbar. Zeigen Sie,
  dass es dann ein $xi in [a, b]$ gibt, so dass

  $ g'(xi) = (g(b) - g(a))/(b - a) $

  Hinweis: Verwenden Sie die Funktion

  $ f(x) = g(x) - (g(b) - g(a))/(b - a)(x - a) $

  Aus der Hilfsfunktion folgt:

  #mathblock[
    $
      f(a) = g(a) - (g(b) - g(a))/(b - a)(a - a) = g(a)
    $
  ]

  #mathblock[
    $
      f(b) = g(b) - (g(b) - g(a))/(b - a)(b - a) = g(b) -g(b) + g(a) = g(a)
    $
  ]

  Somit gilt $f(a) = f(b)$ und daher gibt es ein $xi in (a, b)$ so, dass $f'(xi) = 0$.

  Es gilt weiter

  #mathblock[
    $
      f'(x) = g'(x) - (g(b) - g(a))/(b - a)
    $
  ]

  #mathblock[
    $
      0 = g'(xi) - (g(b) - g(a))/(b - a) => g'(xi) = (g(b) - g(a))/(b - a) #h(25pt) square
    $
  ]
