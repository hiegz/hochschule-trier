#counter(heading).update((5, 7))
== Diffie-Hellman (2)

#v(5pt)

$p = 13,$ #h(5pt) $g = 2$

#set enum(numbering: "(a)")

+ $Z_p = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10 ,11, 12}$

  $2^0 mod 13 = 1 mod 13 = 1$

  $2^1 mod 13 = 2 mod 13 = 2$

  $2^2 mod 13 = 4 mod 13 = 4$

  $2^3 mod 13 = 8 mod 13 = 8$

  $2^4 mod 13 = 16 mod 13 = 3$

  $2^5 mod 13 = 32 mod 13 = 6$

  $2^6 mod 13 = 64 mod 13 = 12$

  $2^7 mod 13 = 128 mod 13 = 11$

  $2^8 mod 13 = 256 mod 13 = 9$

  $2^9 mod 13 = 512 mod 13 = 5$

  $2^10 mod 13 = 1024 mod 13 = 10$

  $2^11 mod 13 = 2048 mod 13 = 7$

  $2^i mod p = Z_p \\ {0}$ für alle $i = 0,...,p-2$ #h(10pt) $checkmark$

+ Alice und Bob wählen unabghängig voneinander jeweil zufällig Zahlen $a$ und
  $b$ aus ${1,...,p-2}$ und tauschen anschließend $g^a mod p$ bzw. $g^b mod p$
  miteinander aus. Das allgemeine Schlüssel $K$ ist dann gleich
  $(g^a mod p)^b = (g^b mod p)^a = g^(a b) mod p$

+ Mallory stellt eine Verbindung zu Bob und Alice her wie bei einem normalen
  Diffie-Hellman-Austausch, mit dem Unterschied, dass sie sich als Bob oder
  Alice ausgibt und anschließend die Nachrichten von beiden Seiten abfängt und
  über abgeleitete Schlüssel weiterleitet, wie unten:

  #align(
    center,
    image("./assets/5.8.svg"),
  )
