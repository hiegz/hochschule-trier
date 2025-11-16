#counter(heading).update((4, 1));
== Zertifikatsvalidierung

#set enum(numbering: "(a)")

+ Charlie beginnt bei dem signierten Dokument selbst und nutzt den öffentlichen
  Schlüssel aus Bobs Zertifikat, um die Signatur zu prüfen. Danach arbeitet er
  sich den Zertifizierungspfad nach oben: Er kontrolliert für jedes Zertifikat
  die Signaturen mithilfe der jeweiligen Aussteller-Schlüssel und stellt sicher,
  dass alle Zertifikate noch gültig sind. Erst wenn die gesamte Kette sauber
  verifiziert ist, gilt das Dokument als vertrauenswürdig.

  #v(10pt)

  #align(
    center,
    figure(
      caption: "Zertifizierungspfad",
      image("assets/zertifizierungspfad.svg"),
    ),
  );

+ ...
