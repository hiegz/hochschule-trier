#import "mathblock.typ": mathblock

#mathblock[
  $
                 x'(t) & = sin(t) dot x(t) \
      (x'(t)) / (x(t)) & = sin(t) \
             (d x) / x & = sin(t) d t \
    integral (d x) / x & = integral sin(t) d t \
    integral 1 / x d x & = integral sin(t) d t \
  $
]

#v(10pt)

#mathblock[
  $
    ln(x) + C_1 & = -cos(t) + C_2 \
          ln(x) & = -cos(t) + C #h(5pt) (C = C_2 - C_1) \
        e^ln(x) & = e^(-cos(t) + C) \
                \
                \
           x(0) & = e^(-cos(0) + C) = 1 \
           x(0) & = e^C dot e^(-1 + C) = 1 \
         -1 + C & = 0 \
              C & = 1
  $
]

#v(10pt)

#mathblock[
  $
    x(t) = e^(-cos(t) + 1)
  $
]
