#set text(lang: "de")

- Ein Fehler ist eine menschliche falsche Handlung oder Entscheidung während
  der Entwicklung (z. B. beim Entwurf, der Implementierung oder der
  Anforderungserhebung), die eine Abweichung von Ist-Ergebnis und erwartetem
  Ergebnis im System verursacht.

  Beispiel: Ein Entwickler verwendet > statt >= in einer Bedingung und schließt
  dadurch gültige Werte aus.

- Ein Mangel ist die Abweichung eines Software von seinen Anforderungen.

  Beispiel: Ein „Speichern“-Button führt gelegentlich keine Aktion aus, weil ein Ereignis nicht korrekt verknüpft ist.

- Fehlermaskierung liegt vor, wenn ein vorhandener Fehler oder Mangel durch
  andere Fehlerzustände verdeckt wird und dadurch nicht direkt sichtbar ist.

  Beispiel: Ein Rechenfehler in Zwischenschritten wird durch Rundung am Ende
  ausgeglichen, sodass das Endergebnis korrekt erscheint.

#vt(10pt)

- Verifikation prüft, ob das System korrekt nach den technischen und fachlichen
  Spezifikationen gebaut wurde. Frage: „Wurde das System richtig gebaut?“

  - Eine Überweisung muss Empfänger, IBAN, Betrag und Verwendungszweck enthalten. Verifikation durch Unit-Tests: Negative Beträge werden abgelehnt.
  - Beträge müssen als Dezimalwerte mit zwei Nachkommastellen gespeichert werden. Verifikation durch Datenbanktests: Prüfen ob beträge korrekt mit zwei Nachkommastellen gespeichert werden.

- Validierung prüft, ob das richtige System gebaut wurde, also ob es die tatsächlichen Nutzerbedürfnisse erfüllt.
  Frage: „Wurde das richtige System gebaut?“

  - Unternehmen brauchen Sammelüberweisungen (z. B. Gehaltszahlungen an viele Empfänger gleichzeitig), das System unterstützt das nicht.
  - Nutzer erwarten Echtzeit-Status („ist Geld angekommen?“), aber das System zeigt nur „gesendet“ an.

  Also das System ist technisch korrekt, aber funktional unvollständig für den
  realen Bedarf.
