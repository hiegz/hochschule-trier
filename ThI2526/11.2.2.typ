$L_2 =_"def" { w in { a, b }^* | w^R = w }$ (alle Palindrome über ${a, b}$)

Angenommen $L_2$ ist regulär.

Dann existiert nach dem Pumping-Lemma eine Zahl $p in NN$, so dass jedes Wort
$w in L_2$ mit $|w| >= p$ in drei Teile $w = x y z$ zerlegt werden kann mit den
Eigenschaften

- $|y| > 0$,
- $|x y| <= p$,
- $x y^i z in L_2$ für alle $i >= 0$.

Wir wählen das Wort

$ w = a^p b a^p in L_2 $

Offensichtlich gilt $w in L_2$, da $w^R = w$

Aus $|x y| <= p$ folgt, dass $y$ im vorderen `a`-Block liegt:

$ y = a^t " mit " t >= 0 $

Mit $i = 0$

$ x y^0 z = x z = a^(p - t) b a^p $

was kein Palindrom mehr ist, also

$ x y^0 z in.not L_2 $

Dies widerspricht der Aussage des Pumping-Lemmas.

Folglich ist die Annahme falsch, und $L_2$ ist nicht regulär. $square$
