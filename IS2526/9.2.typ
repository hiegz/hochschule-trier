#counter(heading).update((9, 1))
== DNS, HTTP-Proxy & Firewalls

#set enum(numbering: "(a)")

#v(5pt)

1. Unter Berücksichtigung der dargestellten Architektur sollten die
  Firewall-Regeln wie folgt definiert werden:

#image("./assets/9.2.svg")

#align(
  center,
  table(
    columns: 9,
    table.header(
      [Rule],
      [NIC],
      [IP-Src],
      [IP-Dest],
      [Protocol],
      [SrcPort],
      [DestPort],
      [ACK],
      [Action],
    ),

    [1], [NIC1], [Any], [Ext. DNS], [UDP], [>1023], [53], [-], [Permit],

    [2], [NIC2], [Ext. DNS], [Any], [UDP], [53], [>1023], [-], [Permit],

    [3],
    [NIC6],
    [192.168.0.0/24],
    [Int. DNS],
    [UDP],
    [>1023],
    [53],
    [-],
    [Permit],

    [4],
    [NIC5],
    [Int. DNS],
    [192.168.0.0/24],
    [UDP],
    [53],
    [>1023],
    [-],
    [Permit],

    [5], [NIC3], [Ext. DNS], [Int. DNS], [TCP], [>1023], [53], [Any], [Permit],

    [6], [NIC4], [Int. DNS], [Ext. DNS], [TCP], [53], [>1023], [Yes], [Permit],

    [7], [NIC4], [Int. DNS], [Ext. DNS], [TCP], [>1023], [53], [Any], [Permit],

    [8], [NIC3], [Ext. DNS], [Int. DNS], [TCP], [53], [>1023], [Yes], [Permit],

    [9],
    [NIC2],
    [Ext. DNS],
    [Trusted DNS],
    [TCP],
    [>1023],
    [53],
    [Any],
    [Permit],

    [10],
    [NIC1],
    [Trusted DNS],
    [Ext. DNS],
    [TCP],
    [53],
    [>1023],
    [Yes],
    [Permit],

    [11],
    [NIC1],
    [Trusted DNS],
    [Ext. DNS],
    [TCP],
    [>1023],
    [53],
    [Any],
    [Permit],

    [12],
    [NIC2],
    [Ext. DNS],
    [Trusted DNS],
    [TCP],
    [53],
    [>1023],
    [Yes],
    [Permit],

    [13], [NIC1], [Any], [Web Server], [TCP], [>1023], [80], [Any], [Permit],

    [14], [NIC2], [Web Server], [Any], [TCP], [80], [>1023], [Yes], [Permit],

    [15], [NIC4], [Any], [Web Server], [TCP], [>1023], [80], [Any], [Permit],

    [16], [NIC3], [Web Server], [Any], [TCP], [80], [>1023], [Yes], [Permit],

    [17],
    [NIC6],
    [192.168.0.0/24],
    [http proxy],
    [TCP],
    [>1023],
    [81],
    [Any],
    [Permit],

    [18],
    [NIC5],
    [http proxy],
    [192.168.0.0/24],
    [TCP],
    [81],
    [>1023],
    [Yes],
    [Permit],

    [19],
    [NIC4],
    [http proxy],
    [Web Server],
    [TCP],
    [>1023],
    [80],
    [Any],
    [Permit],

    [20],
    [NIC3],
    [Web Server],
    [http proxy],
    [TCP],
    [80],
    [>1023],
    [Yes],
    [Permit],

    [21], [NIC4], [http proxy], [Any], [TCP], [>1023], [80], [Any], [Permit],

    [22], [NIC3], [Any], [http proxy], [TCP], [80], [>1023], [Yes], [Permit],

    [23], [NIC2], [http proxy], [Any], [TCP], [>1023], [80], [Any], [Permit],

    [24], [NIC1], [Any], [http proxy], [TCP], [80], [>1023], [Yes], [Permit],

    [25], [Any], [Any], [Any], [Any], [Any], [Any], [Any], [Deny],
  ),
)

2. Sicherheitsgewinne der Firewall-Topologie

  - Default Deny-Prinzip

    nur notwendiger Verkehr wird zugelassen.

  - Segmentierung des Netzes

    Angreifer, die einen Server in der DMZ kompromittieren, haben keinen
    direkten Zugriff auf interne Systeme.

  - Schutz des Web-Zugriffs über Proxy

    Maskierung interner IP-Adressen zum Schutz von Unternehmensdaten.
