#counter(heading).update((3, 16))
== Betriebsmodi von Blockchiffren

#v(5pt)

#set enum(numbering: "(a)")

+ $P_1 &:= "1"$, $P_2 &:= "A"$, $P_3 &:= "2"$, $P_4 &:= "B"$

  #v(10pt)

  $C_1 &= "E"("K", P_1 xor "IV") &&= "E"("K", "1" xor 0) &&= "E"("K", "1") &&= "7" \
  C_2 &= "E"("K", P_2 xor C_1) &&= "E"("K", "A" xor "7") &&= "E"("K", "D") &&= "9" \
  C_3 &= "E"("K", P_3 xor C_2) &&= "E"("K", "2" xor "9") &&= "E"("K", "B") &&= "C" \
  C_4 &= "E"("K", P_4 xor C_3) &&= "E"("K", "B" xor "C") &&= "E"("K", "7") &&= "4"$

  #v(10pt)

  $P_1 &= "IV" xor "D"("K", C_1) &&= 0 xor "D"("K", "7") &&= 0 xor 1 &&= "1" \
  P_2 &= C_1 xor "D"("K", C_2) &&= "7" xor "D"("K", "9") &&= 7 xor "D" &&= "A" \
  P_3 &= C_2 xor "D"("K", C_3) &&= "9" xor "D"("K", "C") &&= "9" xor "B" &&= "2" \
  P_4 &= C_3 xor "D"("K", C_4) &&= "C" xor "D"("K", "4") &&= "C" xor "7" &&= "B"$

+ $P_i = "D"("K", C_i)$, #h(5pt) $C_i = "E"("K", P_i)$

  $P = "9889"$

  $E = "EFFE"$

+ $P_1 &:= "A"$, $P_2 &:= "F"$, $P_3 &:= "F"$, $P_4 &:= "E"$

  #v(10pt)

  $C_1 &= P_1 xor "E"("K", (14 + 1) mod 16) &&= "A" xor "E"("K", "F") &&= "A" xor "B" &&= "1"\
  C_2 &= P_2 xor "E"("K", (14 + 2) mod 16) &&= "F" xor "E"("K", "0") &&= "F" xor "8" &&= "7"\
  C_3 &= P_3 xor "E"("K", (14 + 3) mod 16) &&= "F" xor "E"("K", "1") &&= "F" xor "7" &&= "8"\
  C_4 &= P_4 xor "E"("K", (14 + 4) mod 16) &&= "E" xor "E"("K", "2") &&= "E" xor "6" &&= "8"$

  #v(10pt)

  $P_1 &= C_1 xor "E"("K", (14 + 1) mod 16) &&= "1" xor "E"("K", "F") &&= "1" xor "B" &&= "A"\
   P_2 &= C_2 xor "E"("K", (14 + 2) mod 16) &&= "7" xor "E"("K", "0") &&= "7" xor "8" &&= "F"\
   P_3 &= C_3 xor "E"("K", (14 + 3) mod 16) &&= "8" xor "E"("K", "1") &&= "8" xor "7" &&= "F"\
   P_4 &= C_4 xor "E"("K", (14 + 4) mod 16) &&= "8" xor "E"("K", "2") &&= "8" xor "6" &&= "E"$
