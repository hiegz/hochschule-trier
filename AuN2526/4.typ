#import "mathblock.typ": mathblock

#counter(heading).update(3)
= Aufgabe 4

Es sei $f : RR -> RR$
$
  f(x) = cases(
    x^2\, space "für" x > 0,
    x^3\, space "für" x <= 0,
  )
$
Wie oft ist $f$ an $0$ differenzierbar?

#mathblock[
  $
      f'(0) & = lim_(h -> 0)(f(0 + h) - f(0))/(h) = lim_(h -> 0)f(h)/h \
    f'_+(0) & = lim_(h -> 0)h^2/h = lim_(h -> 0)h = 0 \
    f'_-(0) & = lim_(h -> 0)h^3/h = lim_(h -> 0)h^2 = 0 \
            \
    f'_+(0) & = f'_-(0))
  $
]

#mathblock[
  $
      f''(0) & = lim_(h -> 0)(f'(h))/h \
    f''_+(0) & = lim_(h -> 0)(2h)/h = 2 \
    f''_-(0) & = lim_(h -> 0)(3h^2)/h = lim_(h -> 0)3h = 0 \
             \
    f''_+(0) & != f''_-(0)
  $
]

Daraus folgt, dass $f$ genaul einmal stetig differenzierbar ist.
