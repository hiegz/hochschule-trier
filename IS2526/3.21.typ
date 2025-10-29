#counter(heading).update((3, 20));
== Berechnung großer Potenzen

#v(10pt)

#set enum(numbering: "(a)")

$27^44 mod 85$

+ $m =$ `101100`

  $27^0 = 1 space (mod 85)$

  $27^1 = 1 dot 1 dot 27 = 27 space (mod 85)$

  $27^10 = 27 dot 27 = 729 = 49 space (mod 85)$

  $27^101 = 49 dot 49 dot 27 = 64827 = 57 space (mod 85)$

  $27^1011 = 57 dot 57 dot 27 = 87723 = 3 space (mod 85)$

  $27^10110 = 3 dot 3 = 9 space (mod 85)$

  $27^101100 = 9 dot 9 = 16 = 81 space (mod 85)$

+ $phi(85) = phi(5 dot 17) = 4 dot 16 = 64$

  $27^44 = (3^3)^44 = 3^(132) = 3^(64) dot 3^(64) dot 3^4 = 1 dot 1 dot 81 = 81 space (mod 85)$
