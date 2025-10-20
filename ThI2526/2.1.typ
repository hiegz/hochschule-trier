$g(1) = 1$ und $g(n) = g(n - 1) + n^3$ f"ur alle $n >= 2$

Zu zeigen:
$ g(n) = "sollwert"(n) = ((n(n + 1))/2)^2 $

+ $g(1) = 1$ und $"sollwert"(n) = ((1 dot 2)/2)^2 = 1$, also
  $g(1) = "sollwert"(1)$

+ Angenommen, dass $g(n) = "sollwert"(n)$, folgt

  $
    g(n + 1) & = g((n + 1) - 1) + (n + 1)^3 \
             & = g(n) + (n + 1)^3 \
             & = (n(n + 1)/2)^2 + (n + 1)^3 \
             & = (n^2 (n + 1)^2) / 4 + n^3 + 3n^2 + 3n + 1 \
             & = (n^2 (n + 1)^2 + 4n^3 + 12n^2 + 12n + 4) / 4 \
             & = (n^2 (n + 1)^2 + 4n^3 + 8n^2 + 4n + 4n^2 + 8n + 4) / 4 \
             & = (n^2 (n + 1)^2 + 4n(n^2 + 2n + 1) + 4(n^2 + 2n + 1)) / 4 \
             & = (n^2 (n + 1)^2 + 4n(n + 1)^2 + 4(n + 1)^2) / 4 \
             & = ((n^2 + 4n + 4)(n + 1)^2) / 4 \
             & = ((n + 2)^2(n + 1)^2) / 4 \
             & = ((n + 1)^2(n + 2)^2) / 4 \
             & = (((n + 1)(n + 2)) / 2)^2 = "sollwert"(n + 1)
  $

  Also gilt für $n >= 1$

  $
    g(n) = "sollwert"(n) => g(n + 1) = "sollwert"(n + 1) <=> forall_(n in NN, n >= 1) space g(n) = "sollwert"(n)
  $

  #h(1fr) #sym.square
