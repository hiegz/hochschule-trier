#let title = "Software-Entwurf"
#let author = "Volodymyr But"

#set document(title: title, author: author)
#set page("a4")
#set text(font: "New Computer Modern", lang: "de")
#set math.cases(gap: 0.5em)

#align(center, text(18pt)[#title])
#align(center, text(18pt)[Übungsblatt 1])
#align(center, text(16pt)[WiSe 2025/26])
#v(15pt)
#align(center, text(15pt)[#author])
#align(center, text(15pt)[Hochschule Trier])

#v(5em)

= Aufgabe 1

#v(1em)

+ Attribut `Nachname`

  - Name: `name`

    nicht sinnvoll; mehrdeutig.

  - Typ: `String`

    sinnvoll; ein Nachname wird als Text gespeichert.

  - Anfangswert: `Meier`

    nicht sinnvoll;

  - Restriktion: `Länge < 20 Zeichen`

    sinnvoll; könnte aber zu knapp sein (bei Doppelnamen).

  - Klassenattribut: `nein`

    sinnvoll; Nachname soll zu einer spezifischen Instanz gehören

  - Abgeleitetes Attribut: `ja`

    nicht sinnvoll;

  - Muss-Attribut: `ja`

    sinnvoll;

  - Beschreibung: `Gibt den Nachnamen an.`

    sinnvoll;

    #v(90pt)

+ Attribut `Gehalt`

  - Name: `gehalt`

    sinnvoll;

  - Typ: `float`

    sinnvoll;

  - Anfangswert: `0`

    sinnvoll;

  - Restriktion: `1000 Euro < Gehalt < 4000 Euro`

    nicht sinnvoll;

  - Klassenattribut: `ja`

    nicht sinnvoll;

  - Abgeleitetes Attribut: `nein`

    teilweise sinnvoll;

  - Muss-Attribut: `ja`

    sinnvoll;

  - Beschreibung: `Gibt das Brutto-Jahresgehalt an`

    sinnvoll;

#v(30pt)

= Aufgabe 2

#v(10pt)

#figure(
  image("./ueb01/person.svg", width: 250pt),
)

#pagebreak()

= Aufgabe 3

#v(10pt)

+ ```uml
  enum Berechtigungsstufe {
      international
      national
      intern
  }

  class Telefon {
      - nebenstellenNr: int
      - berechtigungsstufe: Berechtigungsstufe
      - aufstellort: String
      - verbrauchteEinheiten: int
      + sperren(): void
  }

  Telefon --> Berechtigungsstufe

  class Telefonanlage {
      - kennung: String
      - amtsnummer: int
      - amtsleitungen: int
  }

  Telefonanlage "1" --- "0..901" Telefon : verwaltet >
  ```

  #v(10pt)

  #figure(
    image("./ueb01/klassendiagramm.svg", width: 200pt),
  )

  #v(14pt)

+ ```uml
  object Telefonanlage1 {
      anlagenkennung = "TA-001"
      amtsnummer = 12345
      amtsleitungen = 5
  }

  object Telefon1 {
      nebenstellenNr = 101
      berechtigungsstufe = intern
      aufstellort = "Büro 1"
      verbrauchteEinheiten = 50
  }

  object Telefon2 {
      nebenstellenNr = 102
      berechtigungsstufe = national
      aufstellort = "Büro 2"
      verbrauchteEinheiten = 20
  }

  Telefonanlage1 -- Telefon1
  Telefonanlage1 -- Telefon2
  ```

  #v(10pt)

  #figure(
    image("./ueb01/objektdiagramm.svg", width: 300pt),
  )

#pagebreak()

= Aufgabe 4

#v(10pt)

#align(
  center,
  grid(
    columns: 2,
    rows: 1,
    align: horizon,
    gutter: 10pt,
    row-gutter: 50pt,

    ```uml
    class Artikel {
      +artikelnr: int { unique, required }
      +bezeichnung: String { unique, required }
      +sprache: String = "Java"
      +beschreibung: String
      +verkaufspreis: float = 0.0
    }
    ```,

    image("./ueb01/artikel-klasse.svg", width: 200pt),

    ```uml
    object DiashowArtikel {
      artikelnr = 4711
      bezeichnung = "Diashow"
      sprache = "Java"
      beschreibung = "Erlaubt Diashow auf HTML-Seite"
      verkaufspreis = 29.90
    }
    ```,

    image("./ueb01/artikel-object.svg", width: 200pt),
  ),
)
