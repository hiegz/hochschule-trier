#let title = "Objektorientierte Programmierung"
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
#align(center, text(18pt)[Übungsblatt 12])
#align(center, text(16pt)[WiSe 2025/26])
#v(15pt)
#align(center, text(15pt)[#author])
#align(center, text(15pt)[Hochschule Trier])

#v(5em)

= Aufgabe 1 -- Ausgaben über Class Loading und Dependency Management

#table(
  columns: 4,
  stroke: (x, y) => if (y != 0) { (top: 0.5pt) },
  align: (x, y) => if (x != 1) { (center + horizon) } else { auto },
  table.header(
    [],
    [],
    rotate(-90deg, reflow: true, [wahr]),
    rotate(-90deg, reflow: true, [falsch]),
  ),

  [1.],
  [Die Java Virtual Machine benötigt immer eine jar-Datei mit dem zu ladenden
    Programm],
  sym.ballot,
  sym.ballot.check.heavy,

  [2.],
  [Die JVM lädt nur den Bytecode für Klassen, die auch tatsächlich gebraucht
    werden.],
  sym.ballot.check.heavy,
  sym.ballot,

  [3.],
  [Der erste Eintrag im sogenannten Classpath zeigt immer auf den Ordner, in dem
    die „Runtime Library“ der Java Virtual Machine lieg],
  sym.ballot,
  sym.ballot.check.heavy,

  [4.],
  [Für eine Klasse namens „Example“ im Package „oop.ve12“ muss es in einer
    jar-Datei den Eintrag „oop/ve12/Example.class“ geben],
  sym.ballot.check.heavy,
  sym.ballot,

  [5.],
  [Alle Pfadangaben im Classpath sind relativ zum Installationsort der Java
    Virtual Machine],
  sym.ballot,
  sym.ballot.check.heavy,

  [6.],
  [Die Verwendung von Werkzeugen wie Maven ermöglicht die eindeutige Benennung
    und Referenzierung von Abhängigkeiten],
  sym.ballot.check.heavy,
  sym.ballot,

  [7.],
  [Ein Maven-Projekt erkennt man unter anderem daran, dass es eine Datei namens
    pom.xml enthält],
  sym.ballot.check.heavy,
  sym.ballot,

  [8.],
  [Hat man auf einem Rechner mehrere Maven-Projekte, die dieselben
    Abhängigkeiten verwenden, werde diese standardmäßig mehrfach aus dem
    Internet heruntergeladen und in die Projektordner kopier],
  sym.ballot,
  sym.ballot.check.heavy,
)
