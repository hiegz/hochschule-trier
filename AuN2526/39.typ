#import "mathblock.typ": mathblock

#mathblock[
  $
                   x'(t) & = e^t dot x(t) \
          (x'(t))/(x(t)) & = e^t \
               (d x) / x & = e^t d t \
      integral (d x) / x & = integral e^t d t \
    integral 1 / x (d x) & = integral e^t d t
  $
]

#v(10pt)

#mathblock[
  $
    ln(x) + C_1 & = e^t + C_2 \
          ln(x) & = e^t + C #h(5pt) (C = C_2 - C_1) \
        e^ln(x) & = e^(e^t + C) \
           x(t) & = e^(e^t + C) \
                \
                \
           x(0) & = e^(1 + C) = 1 \
          1 + C & = 0 \
              C & = -1
  $
]

#v(10pt)

#mathblock[
  $
    x(t) = e^(e^t - 1)
  $
]
