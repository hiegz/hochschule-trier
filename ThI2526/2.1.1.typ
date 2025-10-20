```python
def g(n):
    assert n >= 1

    if n == 1:
        return 1

    return g(n - 1) + n**3


def sollwert(n):
    return ((n * (n + 1)) / 2) ** 2
```
