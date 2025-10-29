#counter(heading).update((3, 23))
== RSA Verfahren 2

#set enum(numbering: "(a)")

+ $M = 3$, $C = "?"$

  $3^7 space (mod 55)$, $7_(10) = 111_(2)$

  $3^0 = 1 space (mod 55)$

  $3^1 = 1 dot 1 dot 3 space (mod 55) = 3 space (mod 55)$

  $3^11 = 3 dot 3 dot 3 = 27 space (mod 55)$

  $3^111 = 27 dot 27 dot 3 = 2187 space (mod 55) = 42 space (mod 55)$

  $space => space C = 42$

+ $d = "?"$

  $phi(n) = (p - 1)(q - 1) = 4 dot 10 = 40$

  $space => space d = 23 space$ so dass $1 < d < phi(n)$ und
  $e dot d space mod phi(n) = 1$.

  $42^(23) mod 55 = 3$

+ $phi(n) = 40$

  Alle Zahlen sind zwischen 1 und $phi(n)$

  $11, 13 "und" phi(n)$ sind zudem teilerfremd und können daher als öffentliche
  Exponenten verwendet werden.

+ $9^(23) space (mod 55) &= (3^2)^(23) space &&(mod 55) \
  &= 3^(46) space &&(mod 55) \
  &= 3^40 dot 3^6 space &&(mod 55) \
  &= 3^(phi(n)) dot 3^6 space &&(mod 55) \
  &= 1 dot 3^6 &&(mod 55)$

  $6_10 = 110_2$

  $3_0 = 1 space (mod 55)$

  $3_1 = 1 dot 1 dot 3 space (mod 55) = 3 space (mod 55)$

  $3_11 = 3 dot 3 dot 3 space (mod 55) = 27 space (mod 55)$

  $3_110 = 27 dot 27 space (mod 55) = 729 space (mod 55) = 14 space (mod 55)$
