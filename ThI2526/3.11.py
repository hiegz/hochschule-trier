def reverse_word(w):
    return w[::-1]


def reverse_set_of_words(L):
    ret = []
    for w in L:
        ret.append(reverse_word(w))
    return ret


assert reverse_word("")    == ""
assert reverse_word("a")   == "a"
assert reverse_word("aaa") == "aaa"
assert reverse_word("abc") == "cba"

assert reverse_set_of_words(["", "a", "aaa", "abc"]) == ["", "a", "aaa", "cba"]
