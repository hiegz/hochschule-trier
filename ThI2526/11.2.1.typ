$L_1 =_"def" {a^k b^m | k > m }$

Angenommen $L_1$ ist regulär.

Dann existiert nach dem Pumping-Lemma eine Zahl $p in NN$, so dass jedes Wort
$w in L_1$ mit $|w| >= p$ in drei Teile $w = x y z$ zerlegt werden kann mit den
Eigenschaften

- $|y| > 0$,
- $|x y| <= p$,
- $x y^i z in L_1$ für alle $i >= 0$.

Wir wählen das Wort

$ w = a^(p + 1) b^p $

Offensichtlich gilt $w in L_1$, da $p + 1 > p$

Aus $|x y| <= p$ folgt, dass die Teilwörter $x$ und $y$ ausschließlich aus
`a`-Symbolen bestehen. Insbesondere ist

$ y = a^t " mit " t >= 1 $

Betrachten wir nun den Fall $i = 0$. Dann ergibt sich

$ x y^0 z = x z = a^(p + 1 - t) b^p $

Da $t >= 1$, gilt

$ p + 1 - t <= p $

Somit ist die Anzahl der `a`'s kleiner oder gleich der Anzahl der `b`'s, also

$ x y^0 z in.not L_1 $

Dies widerspricht der Aussage des Pumping-Lemmas.

Folglich ist die Annahme falsch, und $L_1$ ist nicht regulär. $square$
