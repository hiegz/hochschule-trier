def quicksort_(arr, low, high):
    if low > high:
        return

    x = arr[high]
    i = low
    j = high - 1

    while True:
        while i <= j and arr[i] < x:
            i += 1
        while i <= j and arr[j] >= x:
            j -= 1

        if i < j:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1
        else:
            break

    arr[i], arr[high] = arr[high], arr[i]

    quicksort_(arr, low, i - 1)
    quicksort_(arr, i + 1, high)


def quicksort(arr):
    quicksort_(arr, 0, len(arr) - 1)


arr = [1]
quicksort(arr)
assert arr == [1]

arr = [1, 2]
quicksort(arr)
assert arr == [1, 2]

arr = [1, 2, 3]
quicksort(arr)
assert arr == [1, 2, 3]

arr = [1, 2, 3, 4]
quicksort(arr)
assert arr == [1, 2, 3, 4]

arr = [2, 1]
quicksort(arr)
assert arr == [1, 2]

arr = [2, 1, 3]
quicksort(arr)
assert arr == [1, 2, 3]

arr = [3, 1, 2]
quicksort(arr)
assert arr == [1, 2, 3]

arr = [3, 2, 1]
quicksort(arr)
assert arr == [1, 2, 3]

arr = [2, 1, 3, 4]
quicksort(arr)
assert arr == [1, 2, 3, 4]

arr = [2, 1, 4, 3]
quicksort(arr)
assert arr == [1, 2, 3, 4]

arr = [1, 2, 4, 3]
quicksort(arr)
assert arr == [1, 2, 3, 4]

arr = [3, 2, 1, 4]
quicksort(arr)
assert arr == [1, 2, 3, 4]

arr = [1, 4, 3, 2]
quicksort(arr)
assert arr == [1, 2, 3, 4]

arr = [4, 3, 2, 1]
quicksort(arr)
assert arr == [1, 2, 3, 4]
