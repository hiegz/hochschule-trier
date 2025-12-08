implizites Euler-Verfahren: $x_(n + 1) = x_n + h f(t_(n + 1), x_(n + 1))$

#set enum(numbering: "(a)")

+ $x'(t) = x(t) - t^2 + 1$, $f(t,x) = x - t^2 + 1$,
  $t_0 = 0, x_0 = x(0) = x(t_0) = 0.5$

  $x_(n + 1) = x_n + h f(t_(n + 1), x_(n + 1)) = x_n + h (x_(n + 1) - t^2_(n + 1) + 1) = h x_(n + 1) + x_n - h t^2_(n + 1) + h$

  $g(x_(n + 1)) = h x_(n + 1) - x_(n + 1) + x_n - h t^2_(n + 1) + h = 0$

  $g(x_(n + 1)) = (h - 1) x_(n + 1) + x_n + (1 - t^2_(n + 1)) h = 0$

  $g'(x_(n + 1)) = h - 1$

  Dann wird $x_(n + 1)$ mittels Newton-Verfahren bestimmt (siehe `44.py`):

  $
    x_(n + 1) := x_(n + 1) - g(x)/(g'(x)) = x_(n + 1) - ((h - 1) x_(n + 1) + x_n + (1 - t^2_(n + 1)) h) / (h - 1)
  $

+ $x'(t) = x(t) - t^2 + 1$

  $x'(t) - x(t) = -t^2 + 1$

  $e^(-t)x'(t) - e^(-t)x(t) = e^(-t)(-t^2 + 1)$

  $(e^(-t)x(t))' = e^(-t)(-t^2 + 1)$

  $e^(-t)x(t) = integral (-t^2 + 1) dot e^(-t) d t$

  $e^(-t)x(t) = - integral t^2 e^(-t) d t + integral e^(-t) d t$

  $e^(-t)x(t) = - integral t^2 e^(-t) d t - e^(-t) + C_1$

  $e^(-t)x(t) = t^2 e^(-t) - integral 2 t e^(-t) d t - e^(-t) + C_1$

  $e^(-t)x(t) = t^2 e^(-t) + 2 t e^(-t) - 2 integral e^(-t) d t - e^(-t) + C_1$

  $e^(-t)x(t) = t^2 e^(-t) + 2 t e^(-t) + 2 e^(-t) + C_2 - e^(-t) + C_1$

  $e^(-t)x(t) = t^2 e^(-t) + 2 t e^(-t) + e^(-t) + C$

  $x(t) = t^2 + 2 t + 1 + C dot e^t$

  $x(t) = (t + 1)^2 + C dot e^t$

  $x(0) = 1 + C dot e^0 = 0.5 => C = -0.5$

  $x(t) = (t + 1)^2 - 0.5 dot e^t$
