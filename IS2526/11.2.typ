#counter(heading).update((11, 1))
== DVWA

- Command Injection

  Eingabe:

  `127.0.0.1; uname -ar`

  Ausgabe (Security Level "Low"):

  ```
  PING 127.0.0.1 (127.0.0.1): 56 data bytes
  64 bytes from 127.0.0.1: icmp_seq=0 ttl=64 time=0.055 ms
  64 bytes from 127.0.0.1: icmp_seq=1 ttl=64 time=0.116 ms
  64 bytes from 127.0.0.1: icmp_seq=2 ttl=64 time=0.082 ms
  64 bytes from 127.0.0.1: icmp_seq=3 ttl=64 time=0.094 ms
  --- 127.0.0.1 ping statistics ---
  4 packets transmitted, 4 packets received, 0% packet loss
  round-trip min/avg/max/stddev = 0.055/0.087/0.116/0.000 ms
  Linux 87ca9e989580 6.12.63-1-lts #1 SMP PREEMPT_DYNAMIC Thu, 18 Dec 2025 14:48:15 +0000 x86_64 GNU/Linux
  ```

  Ausgabe (Security Level "Impossible"):

  `ERROR: You have entered an invalid IP`

  Unterschiede:

  Bei dem Securty-Level "Low" hängt die Anwendung alles, was im Eingabefeld für
  die IP-Adresse steht, an den Befehl `ping -c 4` an. Auf dem Security-Level
  "Impossible" hingegen zerlegt die Anwendung die IP-Adresszeichenkette in vier
  Oktette und erstellt daraus eine gültige IP-Adresse und lehnt die Eingabe ab,
  wenn ein Oktett nicht numerisch ist oder mehr als vier Oktette vorhanden sind.

- File Inclusion

  URL:

  `localhost/vulnerabilities/fi/?page=/etc/passwd`

  Ausgabe (Security Level "Low"):

  ```
  root:x:0:0:root:/root:/bin/bash ...
  ```

  Ausgabe (Security Level "Impossible"):

  ```
  ERROR: File not found!
  ```

  Unterschiede:

  Auf dem Securty-Level „Impossible“ prüft der Server, ob die vom Benutzer
  aufgerufene Seite eine der folgenden ist:

  - "include.php"
  - "file1.php"
  - "file2.php"
  - "file3.php"

  Andernfalls meldet der Server einen Fehler.

- Upload

  Eingabe:

  ```php
  <?php
      echo "Hello world from a virus";
  ?>
  ```

  Ausgabe (Security Level "Low"):

  ```
  ../../hackable/uploads/virus.php succesfully uploaded!
  ```

  Jetzt können wir den Code auf dem Server ausführen, indem wir über eine
  File‑Inclusion‑Schwachstelle auf die Datei zugreifen.

  Ausgabe (Security Level "Impossible"):

  ```
  Your image was not uploaded. We can only accept JPEG or PNG images.
  ```

  Hier prüft der Server, ob die Datei ein Bild ist; andernfalls wird eine
  Fehlermeldung wie oben angezeigt.

- SQL Injection

  Eingabe:

  ```
  1' OR '1'='1
  ```

  Ausgabe (Security Level "Low"):

  ```
  ID: 1' OR '1'='1
  First name: admin
  Surname: admin

  ID: 1' OR '1'='1
  First name: Gordon
  Surname: Brown

  ID: 1' OR '1'='1
  First name: Hack
  Surname: Me

  ID: 1' OR '1'='1
  First name: Pablo
  Surname: Picasso

  ID: 1' OR '1'='1
  First name: Bob
  Surname: Smith
  ```

  Ausgabe (Security Level "High"):

  ```
  keine Ausgabe
  ```

  Auf diesem Security Level stellt der Server sicher, dass die `id` numerisch
  ist, und verwendet Prepared Statements, um die Gültigkeit und Sicherheit der
  SQL‑Abfrage zu gewährleisten.

- Stored XSS

  Eingabe:

  ```
  Name: test
  Message: <script>alert("hello world")</script>
  ```

  Ausgabe (Security Level "Low"):

  ```
  Alert: hello world
  ```

  Ausgabe (Security Level "Impossible"):

  ```
  Name: test
  Message: &lt;script&gt;alert(\&quot;hello world\&quot;)&lt;/script&gt;
  ```

  Hier wird die Eingabe vom Server bereinigt, sodass eingeschleuster Inhalt
  weder gespeichert noch als aktives Skript ausgeführt werden kann.
