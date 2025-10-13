#import "mathblock.typ": mathblock

#counter(heading).update(1)
= Aufgabe 2

+ $f: RR -> RR$, $f(x) = x^exp(x) + x = x^e^x + x = e^(e^x ln(x)) + x$,

  $f'(x) = e^(e^x ln(x)) dot (e^x ln(x) + e^x 1/x) + 1$

+ $f : (0, infinity) -> RR$, $f(x) = x^(sin(x)) = e^(ln(x)sin(x))$,

  $f'(x) = e^(ln(x)sin(x)) dot (1/x sin(x) + ln(x)cos(x))$

+ $f : (0, infinity) -> RR$, $f(x) = |x| dot 2x = 2x^2$

  $f'(x) = 4x$

+ $f: RR -> RR$,

  #mathblock[
    $
      f(x) = cases(e^x - 1\, space &x >= 0, x\, &x < 0) #h(40pt) f'(x) = cases(e^x\, space &x >= 0, 1\, &x < 0)
    $
  ]
