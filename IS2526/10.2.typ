#counter(heading).update((10, 1))
== RAID

#set enum(numbering: "(a)")

+ Siehe @fig:10.2.

  Ein Stripe ist 3 Datenblöcke und 1 Parityblock lang.

  #figure(
    image("./assets/10.2.svg"),
    caption: "RAID-Level 5 System mit vier Platten und 12 Datenblöcken",
  )<fig:10.2>

+ #table(
    columns: 4,
    table.header([], [RAID 0], [RAID 1], [RAID 5]),
    [Minimale Anzahl benötigter Platten], [2], [2], [3],
    [Fehlertoleranz], [0], [$n - 1$], [1],
    [Effizienz], [100%], [$1\/n$], [$(n - 1) \/ n$$" "^"*"$],
    [Ausfallwahrscheinlichkeit], [$P(X >= 0)$], [$P(X = n)$], [$P(X >= 2)$],

    [Wie viel Mal schneller können $m$ aufeinanderfolgende Datenblöcke gelesen
      werden als bei der Verwendung einer Platte],
    [$n$],
    [$1$ (genauso schnell)],
    [$n - 1$],

    [Wie viel Mal schneller können $m$ aufeinanderfolgende Datenblöcke
      geschrieben werden als bei der Verwendung einer Platten],
    [$n$],
    [$1$ (genauso schnell)],
    [$n - 1$],
  )

  #text("Effizienz", weight: "bold")

  Seien:

  - $n$ die Anzahl der Platten,
  - $k$ die Anzahl der Stripes,
  - $m_d$ die Anzahl der zu speichernden Datenblöcke und
  - $m$ die Gesamtzahl der gespeicherten Blöcke (Daten + Parität)

  Ein Stripe einthält $n - 1$ Datenblöcke.

  Zur Speicherung von $m_d$ Datenblöcke werden daher

  $ k = m_d / (n - 1) $

  Stripes benötigt. Insgesamt werden

  $ m = k dot n = m_d dot n / (n - 1) $

  Blöcke gespeichert.

  Die Speichereffizienz ergibt sich zu

  $
    m_d/m = m_d/(m_d dot n)/(n - 1) = (m_d dot (n - 1))/(m_d dot n) = (n - 1)/n
  $

  #text("Fehlertoleranz", weight: "bold")

  Die Anzahl ausgefallener Platten sei die Zufallsvariable $X$

  Mit einer individuellen Plattenausfallwahrscheinlichkeit $r$ gilt:

  $ P(X = k) = binom(n, k) r^k (1 - r)^(n - k) $

  - RAID 0:

    Datenverlust bei mindestens einem Ausfall

    $ P(X > 0) = 1 - P(k = 0) = 1 - (1 - r)^n $

  - RAID 1:

    Datenverlust nur bei Ausfall aller Platten

    $ P(X = n) = r^n $

  - RAID 5:

    Datenverlust bei zwei oder mehr ausgefallenen Platten

    $P(X >= 2) = 1 - [P(X = 0) + P(X = 1)] = 1 - [(1 - r)^n + n dot r dot (1 - r)^(n - 1)]$

  #text("Geschwindigkeit", weight: "bold")

  Lesen und Schreiben erfolgen parallel über mehrere Platten:

  - RAID 0

    alle $n$ Platten tragen zur Datenübertragung bei.

  - RAID 1

    Parallelität bringt keinen Geschwindigkeitsgewinn, da identische Daten
    gelesen bzw. geschrieben werden.

  - RAID 5

    effektiv nur $n - 1$ Platten tragen zur Datenübertragung bei, da eine Platte
    pro Stripe Parität speichert.
