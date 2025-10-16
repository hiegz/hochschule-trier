#counter(heading).update((2, 8))
== One-Time-Pad

$K = 6 space 3 space 5 space 7$

#set enum(numbering: "(a)")

+ $P_1 xor K$ = rlpl #h(10pt) $P_2 xor K$ = qlyl

+ (c)

  #v(5pt)

  $P_1 xor C_1 xor C_2 &= (P_1 xor K) xor (P_2 xor K) xor P_1 = P_2 \
  P_2 xor C_1 xor C_2 &= (P_1 xor K) xor (P_2 xor K) xor P_1 = P_1$
