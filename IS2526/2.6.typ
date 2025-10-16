#counter(heading).update((2, 5))
== Vigenère Verschlüsselung

#set enum(numbering: "(a)")

+ #block(
    $
      A + & A & = &&  0 & + &  0 & = A \
      S + & K & = && 18 & + & 10 & = C \
      C + & E & = &&  2 & + &  4 & = G \
      H + & Y & = &&  7 & + & 24 & = F \
      E + & A & = &&  4 & + &  0 & = E \
      R + & K & = && 17 & + & 10 & = B \
      M + & E & = && 12 & + &  4 & = Q \
      I + & Y & = &&  8 & + & 24 & = G \
      T + & A & = && 19 & + &  0 & = T \
      T + & K & = && 19 & + & 10 & = D \
      W + & E & = && 22 & + &  4 & = A \
      O + & Y & = && 14 & + & 24 & = M \
      C + & A & = &&  2 & + &  0 & = C \
      H + & K & = &&  7 & + & 10 & = R
    $,
  )

+ analog zu (a) aber ungekehrt

+ Klartext ABC $->$ Ciphertext XYZ

  #block(
    $
      X - & A & = && 23 & - & 0 & = X \
      Y - & B & = && 24 & - & 1 & = X \
      Z - & C & = && 25 & - & 2 & = X \
    $,
  )

  Schlüssel: XXX

+ Effektive Schlüssellänge für Vigenère Verschlüsselung ist definiert als

  $ k_e = log_(26)("#Schlüssel") $

  Bei einer Klartextlenge $n$ ist \#Schlüssel = $26^n$, also folgt

  $ k_e = log_(26)(26^n) = n $

+ - Kasiski-Test
  - Häufigkeitsanalyse
