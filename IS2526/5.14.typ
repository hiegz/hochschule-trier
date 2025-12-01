#counter(heading).update((5, 13))
== SSL in Wireshark

- Die verwendete Version finden wir im entsprechenden Version-Feld (siehe
  @fig:tls.version)

  In Firefox lässt sich über `about:config` die eingesetzte TLS-Version durch
  entsprechende Einstellungen festlegen (siehe @fig:tls.version.firefox)

  - `1 = TLSv1.0`
  - `2 = TLSv1.1`
  - `3 = TLSv1.2`
  - `4 = TLSv1.3`

- In Wireshark sieht man den „Nonce“ im Feld „Random“ (siehe
  @fig:tls.nonce.client und @fig:tls.nonce.server)

- siehe @fig:tls.session-id

- siehe @fig:tls.ciphersuites und @fig:tls.chosen-ciphersuite

  In Firefox können diese durch Aktivieren/Deaktivieren der entsprechenden
  Cipher-Suite-Flags konfiguriert werden (siehe @fig:tls.ciphersuites.firefox)

- siehe @fig:tls.compression-methods und @fig:tls.chosen-compression-method

- siehe @fig:tls.certificates

- siehe @fig:tls.dh

#pagebreak()

#figure(
  image("./assets/tls.version.png"),
  caption: [TLS-Version],
)<fig:tls.version>

#v(1fr)

#figure(
  image("./assets/tls.version.firefox.png"),
  caption: [TLS-Version in Firefox],
)<fig:tls.version.firefox>

#pagebreak()

#figure(
  image("./assets/tls.nonce.client.png"),
  caption: [TLS-Nonce (Client)],
)<fig:tls.nonce.client>

#v(1fr)

#figure(
  image("./assets/tls.nonce.server.png"),
  caption: [TLS-Nonce (Server)],
)<fig:tls.nonce.server>

#pagebreak()

#v(1fr)

#figure(
  image("./assets/tls.session-id.png"),
  caption: [TLS-SessionID],
)<fig:tls.session-id>

#v(1fr)

#pagebreak()

#figure(
  image("./assets/tls.ciphersuites.png"),
  caption: [TLS Cipher Suites],
)<fig:tls.ciphersuites>

#v(1fr)

#figure(
  image("./assets/tls.chosen-ciphersuite.png"),
  caption: [ausgewähltes Ciphersuite],
)<fig:tls.chosen-ciphersuite>

#pagebreak()

#v(1fr)

#figure(
  image("./assets/tls.ciphersuites.firefox.png"),
  caption: [TLS Ciphersuites in Firefox],
)<fig:tls.ciphersuites.firefox>

#v(1fr)

#pagebreak()

#figure(
  image("./assets/tls.compression-methods.png"),
  caption: [TLS Komprimierungsverfahren],
)<fig:tls.compression-methods>

#v(1fr)

#figure(
  image("./assets/tls.chosen-compression-method.png"),
  caption: [ausgewähltes Komprimierungsverfahren],
)<fig:tls.chosen-compression-method>

#pagebreak()

#v(1fr)

#figure(
  image("./assets/tls.certificates.png"),
  caption: [TLS Zertifikate],
)<fig:tls.certificates>

#v(1fr)

#pagebreak()

#v(1fr)

#figure(
  image("./assets/tls.ec.png"),
  caption: [EC Diffie-Hellman Server-Parameter],
)<fig:tls.dh>

#v(1fr)
