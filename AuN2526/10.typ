#import "mathblock.typ": mathblock

Es sei $f: X -> RR$ differenzierbar an $x_0 in X$, und es sei $a in RR$. Zeigen
Sie, dass dann auch $a f$ (d.h. die Abbildung $x |-> a f(x)$) an $x_0$
differenzierbar ist und, dass gilt
$ (a f)'(x_0) = a f'((x_0)) $

#v(10pt)

#mathblock[
  $
    (a f)'(x_0) & =       && lim_(h -> 0)((a f)(x_0 + h) - (a f)(x_0))/h \
                & = a dot && lim_(h -> 0)(f(x_0 + h) - f(x_0))/(h) = \
                \
                & = a dot && f'(x_0)
  $
]

Also gilt

#set math.equation(numbering: "(1)")

$ (a f)'(x_0) = a f'(x_0) $ <formula>

Da $f$ an $x_0$ differenzierbar ist, ist auch $a dot f'(x_0)$ an $x_0$
differenzierbar. Aus @formula folgt, dass dann auch $(a f)'(x_0)$ an $x_0$
differenzierbar ist.
