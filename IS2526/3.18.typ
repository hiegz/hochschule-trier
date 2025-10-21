#counter(heading).update((3, 17))
== Cut-And-Paste Angriff auf ECB

Angenommen, die Nachricht hat immer diese Struktur:
```
Money_for_<Name>_is_<Betrag>
```
wobei `<Betrag>` genau fünf Zeichen lang ist. Dann passt `is_<Betrag>` genau in
den letzten Block.

Im ECB-Modus erzeugt derselbe Klartextblock immer denselben Chiffretextblock.
Somit kann man einfach den letzten Block von Trudy durch den letzten Block von
Alice ersetzen Block ersetzen — beim Entschlüsseln steht dann `is_$1000` im
Klartext
