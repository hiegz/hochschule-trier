#import "mathblock.typ": mathblock

#mathblock[
  $
                 x'(t) & = k dot x(t) = 1/2 dot x(t) \
        (x'(t)) / x(t) & = 1/2 \
             (d x) / x & = 1/2 d t \
    integral (d x) / x & = integral 1/2 d t \
      integral 1/x d x & = integral 1/2 d t
  $
]

#v(10pt)

#mathblock[
  $
    ln(x) + C_1 & = 1/2 t + C_2 \
          ln(x) & = 1/2 t + C #h(5pt) (C = C_2 - C_1) \
      e^(ln(x)) & = e^(1/2t + C) \
           x(t) & = e^(1/2t + C) \
                \
                \
           x(0) & = e^C = 100 \
              C & = ln(100) approx 4.6051701
  $
]

#v(10pt)

#mathblock[
  $
    x(t) = exp(1/2 t + ln(100))
  $
]
