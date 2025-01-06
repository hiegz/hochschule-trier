fin = open("wortliste.txt")
words = []
for word in fin:
    word = word.strip()
    words.append(word)
words.sort()


def contains(arr, item):
    left = 0
    right = len(arr) - 1

    while True:
        if right < left:
            return False

        mid = (left + right) // 2

        if arr[mid] == item:
            return True
        elif arr[mid] > item:
            right = mid - 1
        elif arr[mid] < item:
            left = mid + 1


# arr = [1, 2, 3, 4, 5, 6]
# print(8, contains(arr, 8))
# print(9, contains(arr, 9))
# print(0, contains(arr, 0))
# print(-1, contains(arr, -1))
# print(1, contains(arr, 1))
# print(2, contains(arr, 2))
# print(3, contains(arr, 3))
# print(4, contains(arr, 4))
# print(5, contains(arr, 5))
# print(6, contains(arr, 6))
# print(7, contains(arr, 7))

for word in words:
    rev_word = word[::-1]
    if contains(words, rev_word):
        print(word, rev_word)
