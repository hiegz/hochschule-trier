$L = { a^i b^j | i, j in NN " und " j = i^2 }$

Angenommen $L$ ist regulär.

Dann existiert nach dem Pumping-Lemma eine Zahl $p in NN$, so dass jedes Wort
$w in L$ mit $|w| >= p$ in drei Teile $w = x y z$ zerlegt werden kann mit den
Eigenschaften

- $|y| > 0$,
- $|x y| <= p$,
- $x y^i z in L$ für alle $i >= 0$.

Wir wählen das Wort

$ w = a^p b^p^2 = x y z, space space space w in L $

Aus $|x y| <= p$ folgt, dass $y$ im vorderen `a`-Block liegt

$ y = a^t " mit " t >= 0 $

Betrachten wir nun den Fall $i = 2$. Dann ergibt sich

$ x y^2 z = x y y z = a^(p + t) b^p^2 $

Somit ist $(p + t)^2 != p^2$, also

$ x y^2 z in.not L $

Dies widerspricht der Aussage des Pumping-Lemmas.

Folglich ist die Annahme falsch, und $L$ ist nicht regulär. $square$
