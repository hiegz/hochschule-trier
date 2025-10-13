#let title = "Theoretische Informatik"
#let author = "Volodymyr But"

#set document(title: title, author: author)
#set page("a4")
#set text(font: "New Computer Modern", lang: "de")
#set heading(numbering: "1")

#show heading: it => block(
  above: 3em,
  below: 1.5em,
  counter(heading).display(it.numbering) + [.] + h(10pt) + it.body,
)

#let section(id, heading, ..content) = {
  [= #heading]

  grid(
    columns: (auto, 1fr),
    row-gutter: 25pt,
    column-gutter: 10pt,
    ..content,
  )
}

#let exercise(id, content) = (
  [#text(weight: "bold")[#id]],
  [#content],
)

#align(center, text(18pt)[#title])
#align(center, text(16pt)[SoSe 2025])
#v(15pt)
#align(center, text(15pt)[#author])
#align(center, text(15pt)[Hochschule Trier])

// @typstyle off
#section(
  1, "Einführung",

  ..exercise("1.1",   include("1.1.typ")),
  ..exercise("1.2.1", include("1.2.1.typ")),
  ..exercise("1.2.2", include("1.2.2.typ")),
  ..exercise("1.2.3", include("1.2.3.typ")),
)
