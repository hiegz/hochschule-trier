#counter(heading).update((4, 5));
== Web of Trust 2

#set enum(numbering: "(a)")
+ #table(
    columns: 4,
    table.header([Owner], [OTF], [Signatures], [KLF]),
    [Alice], [Trusted], [Alice, Bob, Doris, Eve], [valid],
    [Bob], [Trusted], [Alice, Bob, Eve, Ginger], [valid],
    [Charlie], [Partial], [Bob, Charlie, Eve], [valid],
    [Doris], [Untrusted], [Doris, Eve, Janet], [valid],
    [Eve], [Untrusted], [Doris, Eve, Fred], [marginally valid],
    [Fred], [Partial], [Bob, Eve, Fred], [valid],
    [Ginger], [Partial], [Charlie, Eve, Fred, Ginger], [valid],
    [Harry], [Untrusted], [Eve, Harry, Irene], [invalid],
    [Irene], [Untrusted], [Eve, Fred, Harry, Irene], [marginally valid],
    [Janet], [Trusted], [Alice, Bob, Eve, Janet], [valid],
  )

+ Vorteile:
  - Es gibt keine zentrale Autorität (CA)

  - Flexibel. Benutzer können jederzeit anpassen, wem sie vertrauen.

  Nachteile:
  - Wenn ein Benutzer seine privaten Schlüssel verliert, kann er nicht mehr auf
    Ihre Zertifikate zugreifen oder andere überprüfen.

  - Ein WoT ohne zentrale CA ist hinsichtlich der Vertrauenswürdigkeit von
    anderen Nutzern abhängig. Diejenigen mit neuen Zertifikaten werden von
    Personen, die sie nicht persönlich kennen, wahrscheinlich nicht ohne
    Weiteres als vertrauenswürdig eingestuft.
