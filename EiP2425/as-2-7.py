def solve(str, n):
    vokale = [
        "A",
        "a",
        "E",
        "e",
        "I",
        "i",
        "O",
        "o",
        "U",
        "u",
        "Ä",
        "ä",
        "Ü",
        "ü",
        "Ö",
        "ö",
    ]
    res = ""
    for ch in str:
        if ch in vokale:
            res += ch * n
        else:
            res += ch
    return res


print("1.")
print(f'Informatik (3-fach) -> {solve("Informatik", 3)}')
print(f'Informatik ((-2)-fach) -> {solve("Informatik", -2)}')
#
# print(f'Informatik ((0.5)-fach) -> {solve("Informatik", 0.5)}')
#
# TypeError: can't multiply sequence by non-int of type 'float'

print()


def solve2(str, n):
    vokale = [
        "A",
        "a",
        "E",
        "e",
        "I",
        "i",
        "O",
        "o",
        "U",
        "u",
        "Ä",
        "ä",
        "Ü",
        "ü",
        "Ö",
        "ö",
    ]
    res = ""
    temp = ""
    for ch in str:
        if ch in vokale:
            if len(temp) > 1:
                res += temp * n
            else:
                res += temp
            temp = ""
            res += ch * n
        else:
            temp += ch
    if len(temp) > 1:
        res += temp * n
    else:
        res += temp
    temp = ""
    return res


print("2.")
print(f'Informatik (2-fach) -> {solve2("Informatik", 2)}')
