#counter(heading).update((9, 3))
== SNORT-Regeln

#set enum(numbering: "(i)")

#show link: underline;

+ Das Hochladen auf einen FTP-Server erfolgt über den Befehl `STORE` (`STOR`)
  (siehe #link("https://www.rfc-editor.org/rfc/rfc959", "RFC959"))

  ```
  alert tcp any any -> any 21 (|
    msg:"FTP file upload",
    content: "STOR",
    nocase;
    sid:100001;
    rev:1;
  )
  ```

  False Positive: Ein FTP-Client überträgt eine Datei auf einen FTP-Server (z.
  B. ein automatisiertes Backup).

  False Negative: Ein Angreifer lädt eine Datei mit `APPEND` (`APPE`) statt
  `STORE` (`STOR`) hoch.

+ IP-Adressdeklarationen können negiert werden, um Snort anzuweisen, jede
  IP-Adresse zu matchen, außer den angegebenen. Dies wird mit dem !-Operator
  durchgeführt (entnommen von #link(
    "https://docs.snort.org/rules/headers/ips",
    "hier",
  ))

  ```
  alert tcp !$FTP_CLIENTS any -> any 21 (
    msg:"FTP access from unauthorized client",
    sid:100002,
    rev:1,
  )
  ```

+ Der Download eines Files erfolgt über den FTP-Befehl `RETRIEVE` (`RETR`)
  (siehe #link("https://www.rfc-editor.org/rfc/rfc959", "RFC959"))

  ```
  alert tcp any any -> $FTP_SERVERS 21 (
      msg:"FTP ATTACK: Attempt to download /etc/shadow";
      content:"RETR /etc/shadow";
      nocase;
      sid:100003;
      rev:1;
  )
  ```

  False Positive: ein Benutzer lädt ein lokales File herunter, das im Datenstrom
  den String `/etc/shadow` enthält (z.B., `/etc/shadowdocument`)

  False Negative: ein Angreifer nutzt eine verschlüsselte FTP-Session oder lädt
  die Datei unter einem anderen Namen hoch, beispielsweise über einen
  symbolischen Link.
