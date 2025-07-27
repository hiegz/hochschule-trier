def sink(heap, n, k):
    while 2 * k + 1 < n:
        j = 2 * k + 1
        if j + 1 < n and heap[j] < heap[j + 1]:
            j += 1
        if heap[k] >= heap[j]:
            break
        heap[k], heap[j] = heap[j], heap[k]
        k = j


def heapsort(arr):
    n = len(arr)

    for i in range(n // 2 - 1, -1, -1):
        sink(arr, n, i)

    for i in range(n - 1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]
        sink(arr, i, 0)


arr = [1]
heapsort(arr)
assert arr == [1]

arr = [1, 2]
heapsort(arr)
assert arr == [1, 2]

arr = [1, 2, 3]
heapsort(arr)
assert arr == [1, 2, 3]

arr = [1, 2, 3, 4]
heapsort(arr)
assert arr == [1, 2, 3, 4]

arr = [2, 1]
heapsort(arr)
assert arr == [1, 2]

arr = [2, 1, 3]
heapsort(arr)
assert arr == [1, 2, 3]

arr = [3, 1, 2]
heapsort(arr)
assert arr == [1, 2, 3]

arr = [3, 2, 1]
heapsort(arr)
assert arr == [1, 2, 3]

arr = [2, 1, 3, 4]
heapsort(arr)
assert arr == [1, 2, 3, 4]

arr = [2, 1, 4, 3]
heapsort(arr)
assert arr == [1, 2, 3, 4]

arr = [1, 2, 4, 3]
heapsort(arr)
assert arr == [1, 2, 3, 4]

arr = [3, 2, 1, 4]
heapsort(arr)
assert arr == [1, 2, 3, 4]

arr = [1, 4, 3, 2]
heapsort(arr)
assert arr == [1, 2, 3, 4]

arr = [4, 3, 2, 1]
heapsort(arr)
assert arr == [1, 2, 3, 4]

print("OK")
