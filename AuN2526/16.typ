#import "mathblock.typ": mathblock

+ #mathblock[
    $
      integral_0^1 x^2 e^x d x &= [x^2 e^x]_0^1 - integral_0^1 2 x e^x d x \
      &= [x^2 e^x]_0^1 - 2 [x e^x]_0^1 + 2 integral_0^1 e^x d x \
      &= [x^2 e^x]_0^1 - 2 [x e^x]_0^1 + 2 [e^x]_0^1 \
      &= (1^2e^1 -0^2e^0) - 2 dot (1 dot e^1 - 0 dot e^0) + 2 dot (e^1 - e^0) \
      &= e - 2e + 2e - 2 \
      &= e - 2
    $
  ]

+ #mathblock[
    $
      integral_0^2 e^x cos(x) d x &= [e^x cos(x)]_0^2 + integral_0^2 e^x sin(x) d x \
      &= [e^x cos(x)]_0^2 + [e^x sin(x)]_0^2 - integral_0^2 e^x cos(x) d x \ \
      integral_0^2 e^x cos(x) d x &= [e^x cos(x)]_0^2 + [e^x sin(x)]_0^2 - integral_0^2 e^x cos(x) d x \
      2 integral_0^2 e^x cos(x) d x &= [e^x cos(x)]_0^2 + [e^x sin(x)]_0^2 \
      integral_0^2 e^x cos(x) d x &= ([e^x cos(x)]_0^2 + [e^x sin(x)]_0^2)/2 \
      &= ((e^2 cos 2 - e^0 cos 0) + (e^2 sin 2 - e^0 sin 0))/2 \
      &= ((e^2 cos 2 - 1) + (e^2 sin 2 - 0))/2 \
      &= (e^2(sin 2 + cos 2) - 1)/2
    $
  ]

