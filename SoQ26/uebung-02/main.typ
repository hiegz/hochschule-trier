= Aufgabe 1

+ Nicht jeder Fehler ist gleich wichtig. Kritische Bugs sind viel wertvoller als
  kleine UI-Probleme. Ein einfaches „pro Fehler“-Modell bewertet alle Fehler
  gleich und ignoriert die tatsächliche Auswirkung auf das Produkt. Tester
  investieren Zeit eher in leicht findbare Fehler statt in schwierige, aber
  wichtige.

= Aufgabe 2

+ Darstellungsfehler auf alten Android-Versionen

  - Eintrittswahrscheinlichkeit: 3 (möglich)
  - Schadenshöhe: B (gering)

  $arrow$ 3/B, Handlungsbedarf

+ Gehackte Konten

  - Eintrittswahrscheinlichkeit: 2 (unwahrscheinlich)
  - Scahdenshöhe: E (existenzbedrohend)

  $arrow$ 2/E, unbedingt Handlungsbedarf

+ Videoplayer funktioniert nach Update nicht

  - Eintrittswahrscheinlichkeit: 3 (möglich)
  - Scahdenshöhe: C (mittel)

  $arrow$ 3/C, Handlungsbedarf

+ Werbung wird nicht angezeigt

  - Eintrittswahrscheinlichkeit: 3 (möglich)
  - Scahdenshöhe: D (schwerwiegend)

  $arrow$ 3/D, unbedingt Handlungsbedarf

#set enum(numbering: "a.")

= Aufgabe 3

+ Software umfasst Programme, Daten und begleitenden Informationen (wie z.B.
  Dokumentation), die auf einem Computer ausgeführt werden. Software ist
  immateriell (nicht physisch wie Hardware), aber sie steuert, was die Hardware
  macht.

+ Systemsoftware ist die Basissoftware, die den Computer überhaupt erst nutzbar
  macht. Es übernimmt Aufgaben wie Ressourcenverwaltung und Hardware-Steuerung.

  Ein Softwaresystem ist eine konkrete Anwendung oder eine Sammlung von
  Programmen, die zusammen eine bestimmte Aufgabe erfüllen.

+ Der Fortschritt in der Softwareentwicklung ist schwer zu bestimmen, weil er
  nicht direkt sichtbar und oft nicht linear ist.

  - Großer Anteil an „unsichtbarer Arbeit“

    - Testen
    - Fehlersuche
    - Refactoring
    - Optimierung

  - Restaufwand schwer abschätzbar

    "90% fertig" kann täuschen. Die letzten 10% kosten machmal mehr Zeit als die
    ersten 90%.

+ Computer verwenden die Binärschreibweise (Basis 2) auf einem festgelegten
  Speicherplatz (z. B. 32 Bit oder 64 Bit). Viele Dezimalzahlen lassen sich in
  diesem System nicht exakt darstellen.

  - Kleine Ungenauigkeiten entstehen bei jeder Berechnung
  - Viele kleine Fehler summieren sich bei mehreren Rechenoperationen

  Beisplie: $0.1 + 0.2 = 0.30000000000000004$

+ Exakte Berechnungen sind möglich durch den speziellen Datentypen BigDecimal

= Aufgabe 4

+ Der Aufwand für Änderungen an Software ist oft hoch und steigt mit der
  Komplexität des Systems.

  - Änderungen wirken sich häufig auf mehrere Komponenten aus
  - Bestehender Code muss verstanden, angepasst und getestet werden

+ Typische Herausforderungen in Softwareentwicklung und Qualitätssicherung

  - Softwareentwicklung:

    - Komplexität großer Systeme
    - Unklare oder sich ändernde Anforderungen
    - Zeit- und Kostendruck
    - Zusammenarbeit vieler Entwickler

  - Qualitätssicherung

    - Testen aller möglichen Nutzungsszenarien ist unmöglich
    - Finden von schwer reproduzierbaren Fehlern
    - Sicherstellen von Sicherheit und Performance
    - Automatisierung von Tests

+ Die meisten Fehler entstehen in der Anforderungs- und Entwurfsphase

  - Missverständnisse zwischen Kunden und Entwicklern
  - Unklare oder unvollständige Anforderungen

  Falsche Architekturentscheidungen wirken sich später stark aus

+ Der meiste Aufwand für Qualitätssicherung wird in der Testphase (insbesondere
  System- und Integrationstests) betrieben.

  In dieser Phase wird die fertige oder fast fertige Software umfassend geprüft:

  - einzelne Komponenten werden getested
  - Komponenten werden zusammen getestet
  - das Gesamtsystem wird als Ganzes geprüft

= Aufgabe 5

+ Teilweise falsch

  Java wurde zwar so entworfen, dass es einfacher und sicherer ist als Sprachen
  wie C oder C++, aber es ist nicht speziell als besonders einfache
  Einsteiger-Sprache entwickelt worden.

+ Falsch

  Die main()-Methode ist nur der Einstiegspunkt eines Programms, nicht jeder
  Klasse.

  Nur die Klasse, die das Programm startet, benötigt eine main()-Methode.

+ Falsch

  CPUs verstehen nur Maschinensprache (Binary-Code)

  Java-Bytecode wird normalerweise von der Java Virtual Machine (JVM) interpretiert

+ Richtig

  Java ist plattformunabhängig und sehr vielseitig einsetzbar:

    - Smartphone-Apps (Android)
    - Desktop-Anwendungen
    - Server- und Unternehmenssoftware
