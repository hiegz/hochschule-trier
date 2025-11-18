#import "mathblock.typ": mathblock
```python
def f1(x, y):
  z = 0          # 1
  while (x > y): # (x - y) Durchlaufe * 1 (Bedingung)
    x = (x + 2)  # 2
    y = (y + 3)  # 2
    z = (z + 1)  # 2
  return z       # 1
```

Daher ergibt sich

#v(5pt)

$"STEP"(x, y) &= 1 + 7 (x - y) + 1 + 1 = 7 (x - y) + 3\
"TIME"(n) &= 7n + 3 in O(n) #v(10pt) (n = x - y)$
