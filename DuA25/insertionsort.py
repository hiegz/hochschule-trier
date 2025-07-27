def insertionsort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1

        while j >= 0 and key < arr[j]:
            arr[j + 1] = arr[j]
            j -= 1

        arr[j + 1] = key


arr = [1]
insertionsort(arr)
assert arr == [1]

arr = [1, 2]
insertionsort(arr)
assert arr == [1, 2]

arr = [2, 1]
insertionsort(arr)
assert arr == [1, 2]

arr = [1, 2, 3]
insertionsort(arr)
assert arr == [1, 2, 3]

arr = [2, 1, 3]
insertionsort(arr)
assert arr == [1, 2, 3]

arr = [1, 3, 2]
insertionsort(arr)
assert arr == [1, 2, 3]

arr = [3, 1, 2]
insertionsort(arr)
assert arr == [1, 2, 3]

arr = [1, 2, 3]
insertionsort(arr)
assert arr == [1, 2, 3]

arr = [15, 6, 27, 2, 34, 62, 19, 25]
insertionsort(arr)
assert arr == [2, 6, 15, 19, 25, 27, 34, 62]

print("OK")
