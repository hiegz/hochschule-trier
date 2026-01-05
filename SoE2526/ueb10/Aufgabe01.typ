#table(
  columns: 4,
  table.header(
    [Komponente],
    [eingehende Abhängigkeiten],
    [ausgehende Abhängigkeiten],
    [Instabilität],
  ),
  [A], [0], [4], [$4\/4 = 1$],
  [B], [1], [1], [$1\/2$],
  [C], [2], [2], [$1\/2$],
  [D], [1], [2], [$2\/3$],
  [E], [3], [0], [$0$],
  [F], [2], [0], [$0$],
);

Stabile Komponenten sollten von instabilen verwendet werden.

Da $I(D) > I(B)$, ist $D$ instabiller als $B$, also muss die Abhängigkeit von
$D$ zu $B$ verlaufen:

$ D -> B $
