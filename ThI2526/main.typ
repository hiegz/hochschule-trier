#let title = "Theoretische Informatik"
#let author = "Volodymyr But"

#set document(title: title, author: author)
#set page("a4")
#set text(font: "New Computer Modern", lang: "de")

#let exercise(id, content) = (
  [#text(weight: "bold")[#id]],
  [#content],
)

#align(center, text(18pt)[#title])
#align(center, text(16pt)[WiSe 2025/26])
#v(15pt)
#align(center, text(15pt)[#author])
#align(center, text(15pt)[Hochschule Trier])

#v(3em)

// @typstyle off
#grid(
  columns: (auto, 1fr),
  row-gutter: 25pt,
  column-gutter: 10pt,

  ..exercise("1.1",   include("1.1.typ")),
  ..exercise("1.2.1", include("1.2.1.typ")),
  ..exercise("1.2.2", include("1.2.2.typ")),
  ..exercise("1.2.3", include("1.2.3.typ")),
  ..exercise("1.3",   include("1.3.typ")),
  ..exercise("1.4",   include("1.4.typ")),
  [], [],
  ..exercise("2.1.1", include("2.1.1.typ")),
  ..exercise("2.1.2", include("2.1.2.typ")),
  ..exercise("2.2.1", include("2.2.1.typ")),
  ..exercise("2.3",   include("2.3.typ")),
  ..exercise("2.5.1", include("2.5.1.typ")),
  ..for i in range(0, 2) { ([], []) },
  ..exercise("2.5.2", include("2.5.2.typ")),
  ..for i in range(0, 5) { ([], []) },
  ..exercise("2.8", include("2.8.typ")),
  ..exercise("3.2", include("3.2.typ")),
  ..exercise("3.3.2", include("3.3.2.typ")),
  ..exercise("3.5.2", include("3.5.2.typ")),
  ..exercise("3.9", include("3.9.typ")),
)
