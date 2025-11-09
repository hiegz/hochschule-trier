$integral_0^2 1 / (1 + x^2) d x = [arctan(x)]_0^2 = arctan(2) - arctan(0) = arctan(2) approx 1.107148717784091$

$Delta x = (b - a)/m = 2/4 = 1/2 #h(10pt) x_0 = 0 #h(10pt) x_1 = 1/2 #h(10pt) x_2 = 1 #h(10pt) x_3 = 3/2 #h(10pt) x_4 = 2$

+ Mittelpunktsregel

  $integral_0^2 1 / (1+x^2) d x &approx 1/2 dot (f(1/4) + f(3/4) + f(5/4) + f(7/4)) \
  &approx 1/2 dot (1/(1 + 1/16) + 1/(1 + 9/16) + 1/(1 + 25/16) + 1/(1 + 49/16)) \
  &approx 1/2 dot (16/17 + 16/25 + 16/41 + 16/65) \
  &approx 1.10879$

+ Trapezregel

  $integral_0^2 1 / (1 + x^2) d x &approx 1/4 dot (f(0) + f(1/2) + f(1/2) + f(1) + f(1) + f(3/2) + f(3/2) + f(2)) \
  &approx 1/4 dot (f(0) + 2 f(1/2) + 2 f(1) + 2 f(3/2) + f(2)) \
  &approx 1/4 dot (1 + 2/(1 + 1/4) + 2/2 + 2/(1 + 9/4) + 1/5) \
  &approx 1/4 dot (1 + 8/5 + 1 + 8/13 + 1/5) \
  &approx 1.10384615$

+ Simpson-Regel

  $integral_0^2 1 / (1 + x^2) d x &approx 1/12 dot (f(0) + 4 dot f(1/4) + 2 dot f(1/2) \
    & #h(57pt) + space 4 dot f(3/4) + 2 dot f(1) \
    & #h(57pt) + space 4 dot f(5/4) + 2 dot f(3/2) \
    & #h(57pt) + space 4 dot f(7/4) + f(2)) \
    &approx 1.10714$
