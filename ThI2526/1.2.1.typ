#import "mathblock.typ": mathblock

Sei $x in RR$. Wenn $x in ZZ$, dann gilt $floor(x) = ceil(x)$

Definitionen:

#mathblock[
  $
    floor(x) & = max && {n in ZZ | n <= x} \
     ceil(x) & = min && {n in ZZ | n >= x}
  $
]

Da $x in ZZ$ folgt:

#mathblock[
  $
    max & {n in ZZ | n <= x} && = max &&& (-infinity, x] = x \
    min & {n in ZZ | n >= x} && = min &&& [x, +infinity) = x
  $
]

Damit ergibt sich:

#mathblock[
  $
       & floor(x) && = max     && {n in ZZ | n <= x} = x \
       & ceil(x)  && = min     && {n in ZZ | n >= x} = x \
    => & floor(x) && = ceil(x) && square
  $
]
