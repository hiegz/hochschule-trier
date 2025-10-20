#import "mathblock.typ": mathblock

Sei $g^+(n) := ((1 + sqrt(5))/2)^n$ und $g^-(n) := ((1 - sqrt(5))/2)^n$

Bemerkungen:

- $g^+(1) + 1 = g^+(2)$
- $g^-(1) + 1 = g^-(2)$

Diese Beziehungen sind für den folgenden Beweis entscheidend.

+ $"fib"(0) = 0$

  $1/sqrt(5)(g^+(0) - g^-(0)) = 1/sqrt(5)(1 - 1) = 0$

  $0 = 0$

+ $"fib"(1) = 1$

  $1/sqrt(5)(g^+(1) - g^-(1)) = sqrt(5)/sqrt(5) = 1$

  $1 = 1$

+ Angenommen, dass gelten

  #mathblock[
    $
          "fib"(n) & = 1/sqrt(5)(g^+(n) - g^-(n)) "und" \
      "fib"(n + 1) & = 1/sqrt(5)(g^+(n + 1) - g^-(n + 1)),
    $
  ]

  folgt

  $
    "fib"(n + 2) = "fib"(n) + "fib"(n + 1) &= 1/sqrt(5) space (g^+(n) - g^-(n)) + 1/sqrt(5)(g^+(n + 1) - g^-(n + 1)) \
    & = 1/sqrt(5) space (g^+(n) + g^+(n + 1) - g^-(n) - g^-(n + 1)) \
    & = 1/sqrt(5) space (g^+(n) + g^+(n) space g^+(1) - g^-(n) - g^-(n) space g^-(1)) \
    & = 1/sqrt(5) space (g^+(n) (1 + g^+(1)) - g^-(n)(1 +g^-(1))) \
    & = 1/sqrt(5) space (g^+(n) dot g^+(2) - g^-(n) dot g^-(2)) \
    & = 1/sqrt(5) space (g^+(n + 2) - g^-(n + 2))
  $

  #h(1fr) #sym.square
