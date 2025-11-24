#counter(heading).update((5, 2))
== Fehlerhaftes Schlüsselaustausch-Protokoll

#v(5pt)

#set enum(numbering: "(a)")

+ In dem Protokoll, genau wie es geschrieben steht, kann Trudy den Session Key K
  nicht extrahieren, da Nachrichten mit asymmetrischer Kryptografie
  verschlüsselt und signiert werden, es sei denn natürlich, die zugrunde
  liegenden asymmetrischen Algorithmen sind nicht sicher.

  Je nachdem, wie der Schlüsselaustausch durchgeführt wird, könnte Trudy die
  öffentlichen Schlüssel abfangen und durch ihre eigenen ersetzen. Dadurch
  könnte sie den gesamten abgefangenen Datenverkehr einsehen, da die Nachrichten
  – wie unten gezeigt – unwissentlich mit Trudys Schlüssel statt mit dem
  richtigen verschlüsselt werden. Zudem würde Bob eine von Trudy signierte
  Nachricht fälschlich für eine Signatur von Alice halten, weil er aufgrund des
  manipulierten Schlüssels glaubt, Trudys Signatur gehöre zu Alice.

  #v(10pt)

  #align(
    center,
    image("./assets/5.3.svg"),
  )

+ Um das oben beschriebene Problem zu beheben, müssen beide Seiten ein
  vertrauenswürdiges Zertifikat senden, das sie identifiziert. Dann kann Trudy
  die Nachrichten nicht mehr verändern.
