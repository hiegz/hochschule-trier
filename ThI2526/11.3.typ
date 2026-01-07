Gegeben: $L =_"def" { 0^i 1^j | i != j }$ und
$L_(01) =_"def" { 0^n 1^n | n in NN }$

Angenommen, $L$ ist regulär. Dann muss auch $overline(L)$ regulär sein.

$L_(01)$ ist bekanntlich nicht regulär.

Wir betrachten das Komplement von $L$

$
  overline(L) = { w in {0,1}^* | forall_(i, j) in NN " mit " i != j : w != 0^i 1^j }
$

Die Sprache $L(0^*1^*)$ ist regulär und die regulären Sprachen sind unter
Durchschnitt abgeschlossen. Wäre also $overline(L)$ regulär, dann auch

$ overline(L) inter L(0^*1^*) = L_(01) $


Aber $L_(01)$ ist nicht regulär. Also ist $overline(L)$ auch nicht regulär und
somit kann $L$ auch nicht regulär sein. $square$
