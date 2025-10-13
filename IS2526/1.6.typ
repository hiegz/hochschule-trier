#counter(heading).update((1, 5))
== Grundwerte der Sicherheit

#set enum(numbering: "(a.1)")

+ Nennen Sie drei von der Art her verschiedene Beispiele jeweils für

  - Bedrohungen der Verfügbarkeit

    + DDoS
    + Hardwaredefekt
    + Stromausfall/Netzwerkausfall

  - Bedrohungen der Integrität

    + Ransomware
    + Injektionsangriffe (SQL-Injektion, Prompt-Injektion, ...)
    + Festplattenausfall

  - Bedrohungen der Vertraulichkeit

    + Netzwerk-Sniffing
    + Phishing
    + Spyware

+ Ordnen Sie den Grundwerten der Sicherheit die passenden Sicherheitsmaßnahmen
  zu, in dem Sie die folgende Tabelle ausfüllen

  // @typstyle off
  #table(
    stroke: (x, y) => if (x != 0) { (left: black) },
    columns: 4,
    align: (left, center + horizon, center + horizon, center + horizon),

    table.header([], [Vertraulichkeit], [Integrität], [Verfügbarkeit]),
    table.hline(),

    [Firewall-Cluster],                        [ ], [ ], [x],
    [Signieren von Code],                      [ ], [x], [ ],
    [Intrusion Detection System],              [x], [x], [x],
    [Verschlüsselung mittels AES256],          [x], [ ], [ ],
    [Hash-Werte],                              [ ], [x], [ ],
    [Daten-Backups],                           [ ], [x], [ ],
    [Security Policy],                         [x], [x], [ ],
    [Virenschutz],                             [x], [x], [x],
    [Patch Management],                        [x], [x], [x],
    [Notfallhandbuch],                         [ ], [ ], [x],
    [Redundante Netzwerkanbindung der Server], [ ], [ ], [x],
  )
