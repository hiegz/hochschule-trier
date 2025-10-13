#counter(heading).update((1, 4))
== Vergleich Einbruchschutz und Informationssicherheit

#set enum(numbering: "(a)")

+ Für was interessiert sich ein potentieller Dieb/Einbrecher?
  - wertvolle Objekte:
    - Motorrad
    - Auto
    - Fahrrad
    - Wertgegenstände, die man durch die Fenster erkennen kann

+ Welche Schutzmechanismen gibt es?
  - Zaun
  - Abgeschlossenes Tor
  - Rollläden
  - Kameras
  - Alarmanlage
  - Garage

+ Was erleichtert in diesem Haus einen Einbruch / Diebstahl?
  - Offene Tür hinten
  - Fenster ohne geschlossene Rollläden
  - Motorrad und Fahrrad ungesichert draußen

+ Welche Parallelen zur Sicherheit von Informationssystemen sehen Sie?

  #table(
    align: center,
    rows: 2,
    stroke: (x, y) => if (x == 0) { (right: black) },
    columns: (1fr, 1fr),

    table.header([Haus], [IT-Sicherheit]),
    table.hline(),

    [Fenster/Türen], [Login],
    [Kamera/Alarmanlage/Hund], [Intrusion Detection Systeme],

    [Wertsachen sichtbar],
    [Unverschlüsselte Daten, frei zugängliche Informationen],
  )
