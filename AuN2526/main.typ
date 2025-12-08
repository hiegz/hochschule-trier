#let title = "Analysis und Numerik"
#let author = "Volodymyr But"

#set document(title: title, author: author)
#set page("a4")
#set text(font: "New Computer Modern", lang: "de")
#set math.cases(gap: 0.5em)

#let exercise(id, content) = (
  [#text(weight: "bold")[#id]],
  [#content],
)

#align(center, text(18pt)[#title])
#align(center, text(16pt)[WiSe 2025/26])
#v(15pt)
#align(center, text(15pt)[#author])
#align(center, text(15pt)[Hochschule Trier])

#v(5em)

// @typstyle off
#grid(
  columns: (auto, 1fr),
  row-gutter: 25pt,
  column-gutter: 10pt,

  ..exercise(" 2.", include("2.typ")),
  ..exercise(" 4.", include("4.typ")),
  ..exercise("10.", include("10.typ")),
  ..exercise("11.", include("11.typ")),
  ..exercise("13.", include("13.typ")),
  ..exercise("14.", include("14.typ")),
  ..exercise("15.", include("15.typ")),
  ..for (i) in range(10) { ([], []) },
  ..exercise("16.", include("16.typ")),
  ..exercise("18.", include("18.typ")),
  ..exercise("19.", include("19.typ")),
  ..for (i) in range(5) { ([], []) },
  ..exercise("25.", include("25.typ")),
  ..exercise("29.", include("29.typ")),
  ..exercise("30.", include("30.typ")),
  ..exercise("37.", include("37.typ")),
  ..exercise("39.", include("39.typ")),
  ..exercise("40.", include("40.typ")),
  ..exercise("44.", include("44.typ")),
)
