def anagramme(wort):
    if wort == "":
        return [wort]
    if len(wort) == 1:
        return [wort]
    if len(wort) == 2:
        return [wort, wort[::-1]]
    ret = []
    for i, letter in enumerate(wort):
        worte = anagramme(wort[:i] + wort[i + 1 :])
        for w in worte:
            ret.append(letter + w)
    return ret


def validate(wort, anagramme):
    for x in anagramme:
        if anagramme.count(x) > 1:
            return (False, "Duplicate value")

    import math

    if math.factorial(len(wort)) != len(anagramme):
        message = "Bad length. Expected {}, found {}".format(
            math.factorial(len(anagramme)), len(anagramme)
        )
        return (False, message)

    return (True, "OK")


for i, case in enumerate(["", "c", "cat", "wcat", "mycat"]):
    sol = anagramme(case)
    isok, message = validate(case, sol)
    print("#{} {} ... {}".format(i, case, message))
    print(case, sol)
    if not isok:
        print(case, sol)
        break
    print()
