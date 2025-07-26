def merge(left, right):
    ret = []
    i = 0
    j = 0

    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            ret.append(left[i])
            i += 1
        else:
            ret.append(right[j])
            j += 1

    while i < len(left):
        ret.append(left[i])
        i += 1

    while j < len(right):
        ret.append(right[j])
        j += 1

    return ret


assert merge([1, 2, 3], [4, 5, 6]) == [1, 2, 3, 4, 5, 6]
assert merge([1, 3, 5], [2, 4, 6]) == [1, 2, 3, 4, 5, 6]
assert merge([4, 5, 6], [1, 2, 3]) == [1, 2, 3, 4, 5, 6]
assert merge([1, 3], [2, 4, 5, 6]) == [1, 2, 3, 4, 5, 6]
assert merge([3], [1, 2, 4, 5, 6]) == [1, 2, 3, 4, 5, 6]
assert merge([1, 3, 4, 5, 6], [2]) == [1, 2, 3, 4, 5, 6]
assert merge([1, 3, 5, 6], [2, 4]) == [1, 2, 3, 4, 5, 6]


def mergesort(a):
    n = len(a)

    if n == 1:
        return a

    return merge(mergesort(a[: n // 2]), mergesort(a[n // 2 :]))


assert mergesort([1]) == [1]
assert mergesort([1, 2, 3]) == [1, 2, 3]
assert mergesort([3, 1, 2]) == [1, 2, 3]
assert mergesort([3, 2, 1]) == [1, 2, 3]
assert mergesort([1, 2, 3, 4]) == [1, 2, 3, 4]
assert mergesort([1, 3, 2, 4]) == [1, 2, 3, 4]
assert mergesort([4, 2, 3, 1]) == [1, 2, 3, 4]
assert mergesort([3, 2, 1, 4]) == [1, 2, 3, 4]
assert mergesort([1, 4, 3, 2]) == [1, 2, 3, 4]
assert mergesort([4, 3, 2, 1]) == [1, 2, 3, 4]
