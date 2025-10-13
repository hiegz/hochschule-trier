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
)
