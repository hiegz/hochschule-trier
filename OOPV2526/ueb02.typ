#let title = "Objektorientierte Programmierung"
#let author = "Volodymyr But"

#set document(title: title, author: author)
#set page("a4")
#set text(font: "New Computer Modern", lang: "de")
#set math.cases(gap: 0.5em)

#let exercise(id, content) = (
  [#text(weight: "bold")[#id]],
  [#content],
)

#align(center, text(18pt)[#title])
#align(center, text(18pt)[Übungsblatt 2])
#align(center, text(16pt)[WiSe 2025/26])
#v(15pt)
#align(center, text(15pt)[#author])
#align(center, text(15pt)[Hochschule Trier])

#v(5em)

= Aufgabe 1 - Variablen, Attribute und Parameter

#table(
  columns: 4,
  stroke: (x, y) => if (y != 0) { (top: 0.5pt) },
  align: (x, y) => if (x != 1) { (center + horizon) } else { auto },
  table.header(
    [],
    [],
    rotate(-90deg, reflow: true, [wahr]),
    rotate(-90deg, reflow: true, [falsch]),
  ),

  [1.],
  [Eine lokale Variable ist nur innerhalb eines Blocks sichtbar, während ein
    Attribut in der ganzen Klasse sichtbar ist.],
  sym.ballot.check.heavy,
  sym.ballot,

  [2.],
  [Sowohl lokale Variablen als auch Attribute können den Modifier final
    bekommen],
  sym.ballot.check.heavy,
  sym.ballot,

  [3.],
  [Nur der letzte Parameter in der Parameterliste einer Methode darf _variable
      argument types_ verwenden],
  sym.ballot.check.heavy,
  sym.ballot,

  [4.],
  [Sowohl Attribute als auch Parameter einer Methode können mit dem
    Pseudo-Datentyp var deklariert werden.],
  sym.ballot,
  sym.ballot.check.heavy,

  [5.],
  [Sowohl lokale Variablen als auch Attribute können statisch oder nicht-
    statisch sein.],
  sym.ballot,
  sym.ballot.check.heavy,

  [6.],
  [Nicht-statische Attribute können die Sichtbarkeit private bekommen; statische
    Attribute müssen immer public sein.],
  sym.ballot,
  sym.ballot.check.heavy,

  [7.],
  [Es gibt keinen sinnvollen Verwendungszweck für Attribute, die sowohl static
    als auch private sind.],
  sym.ballot,
  sym.ballot.check.heavy,

  [8.],
  [Man kann auf ein statisches Attribut zugreifen, ohne eine Instanz seiner
    Klasse erzeugt zu haben],
  sym.ballot.check.heavy,
  sym.ballot,

  [9.],
  [In statischen Methoden kann this nicht genutzt werden. ],
  sym.ballot.check.heavy,
  sym.ballot,
)

#pagebreak()

= Aufgabe 2 - Schlüsselwörter

#v(1em)

In der Vorlesung wurden zahlreiche Schlüsselwörter besprochen, die bei der
Deklaration von Klassen, Methoden oder Attributen zum Einsatz kommen.

Java hat insgesamt 68 reservierte Schlüsselwörter. Diese sind:

```
abstract  assert  boolean  break  byte  case  catch  char  class  continue default  do  double  else  enum  extends  final  finally  float  for  if implements  import  instanceof  int  interface  long  native  new  package  private  protected  public  return  short  static  super  switch  synchronized this  throw  throws  transient  try  void  volatile  while  exports  module  non-sealed  open  opens  permits  provides  record  requires  sealed  to  transitive  var  when  with  yield  true  false  null  const  goto  strictfp
```
#show link: underline

Quelle: #link("https://en.wikipedia.org/wiki/List_of_Java_keywords")[Wikipedia]

#set enum(numbering: "(a)")

#v(1em)

+ Wie groß ist die größte Anzahl an Schlüsselwörtern, die gemeinsam bei der
  Deklaration einer Klasse zum Einsatz kommen können?

  Eine Klassendeklaration kann die folgenden Schlüsselwörter enthalten:

  ```
  public  private  protected  abstract  final  sealed  non-sealed  class  extends  implements  permits
  ```

  Von diesen dürfen maximal acht gleichzeitig verwendet werden. Zum Beispiel:

  ```java
  public static final strictfp class Class permits OtherClass extends BaseClass implements Interface { ... }
  ```

  #v(2em)

+ Wie groß ist die größte Anzahl an Schlüsselwörtern, die gemeinsam bei der
  Deklaration einer parameterlosen Methode zum Einsatz kommen können?

  Eine parameterlose Methodendeklaration kann die folgenden Schlüsselwörter
  enthalten:

  ```
  public  private  protected  static  synchronized  abstract  final  native  throws  [type]
  ```

  Von diesen dürfen maximal sechs gleichzeitig verwendet werden. Zum Beispiel:

  ```java
  private static synchronized final void method() throws Exception {
      throw new Exception("exception");
  }
  ```

  #v(2em)

+ Wie groß ist die größte Anzahl an Schlüsselwörtern, die gemeinsam bei der
  Deklaration eines Attributs zum Einsatz kommen können?

  Eine Attributsdeklaration kann die folgenden Schlüsselwörter enthalten:

  ```
  public private protected static final transient volatile [type]
  ```

  Von diesen dürfen maximal fünf gleichzeitig verwendet werden. Zum Beispiel:

  ```java
  public static final transient int VARIABLE = 5;
  ```

#pagebreak()

= Aufgabe 3

#v(1em)

```java
private static boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
}

enum Month {
    January,
    Februrary,
    March,
    April,
    May,
    June,
    July,
    August,
    September,
    October,
    November,
    December;

    public int numberOfDaysAtYear(int year) throws Exception {
        switch (this) {
            case January:
            case March:
            case May:
            case July:
            case August:
            case October:
            case December:
                return 31;

            case April:
            case June:
            case September:
            case November:
                return 30;

            case Februrary:
                if (isLeapYear(year))
                    return 29;

                return 28;

            default:
                throw new Exception("unreachable");
        }
    }
}
```
