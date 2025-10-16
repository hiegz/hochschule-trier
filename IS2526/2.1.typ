#counter(heading).update((2, 0))
== Skytale

#let skytale_encrypt(plaintext: str, key: int) = [
  #table(
    align: center,
    rows: key,
    columns: calc.ceil(plaintext.len() / key),

    ..plaintext
      .codepoints()
      .enumerate()
      .map(((index, character)) => table.cell(
        character,
        x: calc.rem(index, key),
        y: calc.floor(index / key),
      ))
  )
]

#let skytale_decrypt(ciphertext: str, key: int) = [
  #table(
    align: center,
    rows: key,
    columns: calc.ceil(ciphertext.len() / key),

    ..ciphertext
      .codepoints()
      .enumerate()
      .map(((index, character)) => table.cell(
        character,
        x: calc.floor(index / key),
        y: calc.rem(index, key),
      ))
  )
]

#set enum(numbering: "(a)")

+ Verschlüsseln Sie den Plaintext HALLOWELT mit dem Schlüssel 3

  #skytale_encrypt(plaintext: "HALLOWELT", key: 3)

  Der Ciphertext lautet: "HLEAOLLWT"

+ Verschlüsseln Sie den Plaintext KRYPTOLOGIEMACHTSPASS mit dem Schlüssel 5.
  Entschlüsseln Sie ihn dann wieder

  #skytale_encrypt(plaintext: "KRYPTOLOGIEMACHTSPASS", key: 5)

  Der Ciphertext lautet: "KOETSRLMS YOAP PGCA TIHS "

  Um den Cipher zu entschlüsseln, wird der Ciphertext spaltenweise in die
  Tabelle eingetragen:

  #skytale_decrypt(ciphertext: "KOETSRLMS YOAP PGCA TIHS ", key: 5)

  und anschließend zeilenweise wieder ausgelesen.

+ Entschlüsseln Sie den Ciphertext PIIIERRSEELEAONREXRTTH mit dem Schlüssel 6

  #skytale_decrypt(ciphertext: "PIIIERRSEELEAONREXRTTH", key: 6)

  Der Klartext lautet: "PRARISOTIENTIERHELE REX "

+ Entschlüsseln Sie den Ciphertext GREATN mit dem Schlüssel 5

  #skytale_decrypt(ciphertext: "GREATN", key: 5)

  Der Klartext lautet: "GNR E A T "

+ Geben Sie die Ver- und Entschlüsselungsvorschrift mit Hilfe einer Tabelle an:

  Geben Sie dazu die Größe der Tabelle an, wie viele „Padding-Zeichen“ benötigt
  werden, in welche Zeilen / Spalten geschrieben und wie wieder ausgelesen wird

  Ich bin mir nicht ganz sicher, ob ich die Aufgabe richtig verstanden habe,
  aber unten habe ich die allgemeinen Regeln zum Ausfüllen einer Tabelle für die
  Ver- und Entschlüsselung mit Skytale angegeben.

  Wenn man die Tabelle zeilen- oder spaltenweise ausliest, erhält man den Klar-
  bzw. Ciphertext.

  #show table.cell.where(y: 0): it => {
    return pad(..it.inset, align(center + bottom, rotate(
      -90deg,
      reflow: true,
    )[#it.body]))
  }

  // @typstyle off
  #table(
      columns: 10,
      inset: (y: 10pt),
      stroke: (x, y) => if (y != 0) { (top: 0.5pt) } + if (x != 0) { (left: 0.5pt) },
      align: horizon + center,

      table.header(
        [Operation],
        [Schlüssel],
        [Eingabegröße],
        [Zeichen-Index],
        [Zeilen-Index],
        [Spalten-Index],
        [Zeilen],
        [Spalten],
        [Tabellengröße],
        [Padding],
      ),

      [E],

      table.cell($k$, rowspan: 2),
      table.cell($l$, rowspan: 2),
      table.cell($i$, rowspan: 2),

      [$r_i := i mod k$],
      [$c_i := floor(i / k)$],

      table.cell($r := k$,           rowspan: 2),
      table.cell($c := ceil(l / k)$, rowspan: 2),
      table.cell($n := r dot c$,     rowspan: 2),
      table.cell($n - l$,            rowspan: 2),

      [D],
      [$r_i := floor(i / k)$],
      [$c_i := i mod k$],
    )
