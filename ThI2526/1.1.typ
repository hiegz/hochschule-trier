#let T = `true`
#let F = `false`

#v(10pt)

#table(
  columns: 7,
  align: center,
  stroke: (x, y) => (
    if (x != 0) { (left: 0.5pt) } + if (y == 0) { (bottom: 0.5pt) }
  ),
  table.header(
    [$V$],
    [$K$],
    [$V => K$],
    [$not(V => K)$],
    [$V and not K$],
    [$(V and not K) => 0$],
    [$(not K) => (not V)$],
  ),
  [#T], [#T], [#T], [#F], [#F], [#T], [#T],
  [#T], [#F], [#F], [#T], [#T], [#F], [#F],
  [#F], [#T], [#T], [#F], [#F], [#T], [#T],
  [#F], [#F], [#T], [#F], [#F], [#T], [#T],
)

#v(10pt)

Aus der Wahrheitswerte-Tabelle ergibt sich

$ (V => K) <=> (not K) => (not V) <=> not (V => K) => 0 $

was zeigt, dass der Beweis von $V => K$ über die Kontraposition oder durch
Widerspruchch korrekt ist, weil die beiden Methoden logisch äquivalente Aussagen
verwenden.
