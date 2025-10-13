#let title = "IT-Sicherheit"
#let author = "Volodymyr But"

#set document(title: title, author: author)
#set page("a4")
#set text(font: "New Computer Modern", lang: "de")
#set enum(indent: 1em)
#set heading(numbering: "1.1")

#show heading: set block(below: 1em)

#align(center, text(18pt)[#title])
#align(center, text(16pt)[SoSe 2025])
#v(15pt)
#align(center, text(15pt)[#author])
#align(center, text(15pt)[Hochschule Trier])

#v(5em)

#include("1.5.typ")
#include("1.6.typ")
