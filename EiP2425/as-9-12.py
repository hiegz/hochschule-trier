def verboten_zaehlen(fin, verboten):
    counter = 0
    for line in fin:
        line = line.strip()
        for ch in verboten:
            if ch in line:
                break
        else:
            counter += 1
    return counter


d = {}
datei = open("wortliste.txt")

for line in datei:
    seen = set()
    line = line.strip()
    for ch in line:
        if ch not in seen:
            seen.add(ch)
            d[ch] = d.get(ch, 0) + 1

verboten = ""

for _ in range(3):
    ch = min(d, key=d.get)
    d.pop(ch)
    verboten += ch

datei.seek(0)
print(verboten_zaehlen(datei, "aeiu"))
print(verboten, end=": ")
datei.seek(0)
print(verboten_zaehlen(datei, verboten))
