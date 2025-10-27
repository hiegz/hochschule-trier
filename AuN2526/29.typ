#import "mathblock.typ": mathblock

+ #mathblock[
    $
      f(x) &= e^x, space x_0 = 1, #h(10pt) f'(x_0) = e, #h(10pt) f''(x_0) = e, #h(10pt) f'''(x_0) = e \
      f(x) &approx f(x_0) + f'(x_0)(x - x_0)/1 + f''(c)(x - x_0)^2/2 + f'''(c)(x - x_0)^3/6 \
      &approx e + e(x - 1)/1 + e(x^2 - 2x + 1)/2 + e(x^3 - 3x^2 + 3x - 1)/6 \
      &approx e dot x + (e dot x^2 - 2 dot e dot x + e) / 2 + (e dot x^3 - 3 dot e dot x^2 + 3 dot e dot x - e)/6 \
      &approx (6 dot e dot x)/6 + (3 dot e dot x^2 - 6 dot e dot x + 3 dot e) / 6 + (e dot x^3 - 3 dot e dot x^2 + 3 dot e dot x - e)/6 \
      &approx (2 dot e + 3 dot e dot x + e dot x^3)/6 = 1/3e + 1/2e x + 1/6e x^3
    $
  ]

  #v(10pt)

+ #mathblock[
    $
      f(x) &= ln(x + 2), space x_0 = 1, #h(10pt) f'(x_0) = 1\/3, #h(10pt) f''(x_0) = -1\/9, #h(10pt) f'''(x_0) = 2\/27 \
      f(x) &approx f(x_0) + f'(x_0)(x - x_0)^1/1 + f''(x_0)(x - x_0)^2/2 + f'''(x_0)(x - x_0)^3/6 \
      &approx ln(3) + 1/3(x - 1) - 1/9(x^2 - 2x + 1) + 2/27 (x^3 - 3x^2 + 3x - 1) \
      &approx (27 dot ln(3) + 9(x - 1) - 3(x^2 - 2x + 1) + 2(x^3 - 3x^2 + 3x - 1)) / 27 \
      &approx (27 dot ln(3) + 9x - 9 - 3x^2 + 6x - 3 + 2x^3 -6x^2 +6x - 2) / 27 \
      &approx ((27 dot ln(3) - 14) + 21x -9x^2 + 2x&^3) / 27 \
      &approx (ln(3) - 14/27) + 21/27 x - 1/3 x^2 + 2/27 x^3
    $
  ]

  #v(10pt)

+ #mathblock[
    $
      f(x) &= sin(x) + cos(x), space x_0 = pi/2, #h(10pt) f'(x_0) = -1, #h(10pt) f''(x_0) = -1, #h(10pt) f'''(x_0) = 1 \
      f(x) &approx f(x_0) + f'(x_0)(x - x_0)^1/1 + f''(x_0)(x - x_0)^2/2 + f'''(x_0)(x - x_0)^3/6 \
      &approx 1 -(x - pi/2) - (x - pi/2)^2/2 + (x - pi/2)^3/6 \
      &approx (6 + 3pi - 6x - 3(x^2 - x pi + pi^2/4) + (x^3 - 3 pi/2 x^2 + 3 pi^2/4 x - pi^3/8))/6 \
      &approx (6 + 3 pi - 6 x - 3x^2 + 3 pi x - 3/4pi^2 + x^3 - 3 pi/2 x^2 + 3 pi^2/4 x - pi^3/8)/6 \
      &approx ((6 + 3pi - 3/4pi^2 - pi^3/8) - 6 x + 3 pi x + 3 pi^2/4 x - 3 pi/2 x^2 - 3 x^2 + x^3) / 6 \
      &approx ((6 + 3pi - 3/4pi^2 - pi^3/8) - (6 - 3 pi - 3 pi^2/4) x - (3 pi/2 + 3) x^2 + x^3)/ 6 \
      &approx (1 + 1/2 pi - 1/8 pi^2 - 1/48 pi^3) - (1 - 1/2 pi - 1/8 pi^2) x - (1/4 pi + 1/2) x^2 + 1/6 x^3
    $
  ]
