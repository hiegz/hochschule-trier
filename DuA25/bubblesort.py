def bubblesort(arr):
    n = len(arr)
    for i in range(n):
        swapped = False
        for j in range(n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                swapped = True
        if not swapped:
            break


arr = [1]
bubblesort(arr)
assert arr == [1]

arr = [1, 2]
bubblesort(arr)
assert arr == [1, 2]

arr = [1, 2, 3]
bubblesort(arr)
assert arr == [1, 2, 3]

arr = [1, 2, 3, 4]
bubblesort(arr)
assert arr == [1, 2, 3, 4]

arr = [2, 1]
bubblesort(arr)
assert arr == [1, 2]

arr = [2, 1, 3]
bubblesort(arr)
assert arr == [1, 2, 3]

arr = [3, 1, 2]
bubblesort(arr)
assert arr == [1, 2, 3]

arr = [3, 2, 1]
bubblesort(arr)
assert arr == [1, 2, 3]

arr = [2, 1, 3, 4]
bubblesort(arr)
assert arr == [1, 2, 3, 4]

arr = [2, 1, 4, 3]
bubblesort(arr)
assert arr == [1, 2, 3, 4]

arr = [1, 2, 4, 3]
bubblesort(arr)
assert arr == [1, 2, 3, 4]

arr = [3, 2, 1, 4]
bubblesort(arr)
assert arr == [1, 2, 3, 4]

arr = [1, 4, 3, 2]
bubblesort(arr)
assert arr == [1, 2, 3, 4]

arr = [4, 3, 2, 1]
bubblesort(arr)
assert arr == [1, 2, 3, 4]

print("OK")
