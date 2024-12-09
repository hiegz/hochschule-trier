def is_palindrome(n):
    string = str(n)
    for i in range(0, len(string) // 2):
        if string[i] != string[len(string) - i - 1]:
            return False
    return True


numbers = set()

for x in range(999, 100 - 1, -1):
    for y in range(999, 100 - 1, -1):
        if is_palindrome(x * y):
            numbers.add(x * y)

print(max(numbers))
