#import "mathblock.typ": mathblock

Angenommen, $sqrt(3) in QQ$. Dann existieren teilerfremde ganze Zahlen $a$ und
$b != 0$ mit

#mathblock[
  $
    sqrt(3) = a/b => 3 = a^2/b^2 => a^2 = 3b^2
  $
]

Dann muss $a^2$ durch 3 teilbar sein und somit ebenfalls $a$. Sei $a := 3k$,
dann folgt

#mathblock[
  $
    3b^2 = 9k^2 => b^2 = 3k^2
  $
]

Nun folgt, dass $b^2$ und daher $b$ durch 3 teilbar sind. Damit sind $a$ und $b$
beide durch 3 teilbar, was widerspricht der Bedingung, dass $a$ und $b$
teilerfremd sind.

Also, $sqrt(3) in.not QQ$ #h(5pt)$square$
