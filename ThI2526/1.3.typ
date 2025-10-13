#import "mathblock.typ": mathblock

Für alle $a in ZZ$ ist $a$ gerade, falls $3a^2$ gerade ist.

#set enum(spacing: 50pt)

+ Direkter Beweis

  Jede natürliche Zahl größer gleich 2 lässt sich als Produkt von Primzahlen
  eindeutig darstellen.

  Dann existiert eine äquivalente Darstellung

  #mathblock[
    $ a = product_(p in PP)p^(e_p) $
  ]

  wobei die Exponenten $e_p in NN_0$ nur für endlich viele $p in PP$ von 0
  verschieden sind.

  Daraus ergibt sich

  #mathblock[
    $ 3a^2 = 3 dot product_(p in PP)(p^(e_p))^2 $
  ]

  Wenn $3a^2$ gerade ist, muss $e_2 > 0$ gelten, um diese Bedingung zu erfüllen.

  Somit ist auch der Produkt

  #mathblock[
    $ product_(p in PP)p^(e_p) $
  ]

  gerade und folglich ebenfalls $a$ $square$

+ Beweis durch Kontraposition

  Wenn $a$ ungerade ist, dann ist auch $3a^2$ ungerade.

  Da $a in ZZ$ ungerade ist, es existiert eine ganze Zahl $k in ZZ$, sodass
  $a = 2k + 1$. Dann ist $3a^2 = 12k^2 + 12k + 1 = 2 dot (6k^2 + 6k) + 1$ durch
  2 nicht teilbar und damit ungerade. $square$
