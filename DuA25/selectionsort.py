def selectionsort(arr):
    n = len(arr)
    for i in range(n):
        minimum = arr[i]
        index = i
        for j in range(i + 1, n):
            if arr[j] < minimum:
                minimum = arr[j]
                index = j
        arr[i], arr[index] = arr[index], arr[i]


arr = [1]
selectionsort(arr)
assert arr == [1]

arr = [1, 2]
selectionsort(arr)
assert arr == [1, 2]

arr = [1, 2, 3]
selectionsort(arr)
assert arr == [1, 2, 3]

arr = [2, 1]
selectionsort(arr)
assert arr == [1, 2]

arr = [2, 1, 3]
selectionsort(arr)
assert arr == [1, 2, 3]

arr = [1, 3, 2]
selectionsort(arr)
assert arr == [1, 2, 3]

arr = [3, 1, 2]
selectionsort(arr)
assert arr == [1, 2, 3]

arr = [3, 2, 1]
selectionsort(arr)
assert arr == [1, 2, 3]

print("OK")
