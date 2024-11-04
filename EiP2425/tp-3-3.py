def print_grid(rows, cols, width, height):
    sconnector = "+"
    cseparator = "|"
    rseparator = "-"

    def print_line():
        print(sconnector, end="")
        for _ in range(0, cols):
            print(" ", end="")
            for _ in range(0, width):
                print(rseparator, end=" ")
            print(sconnector, end="")
        print()

    for _ in range(0, rows):
        print_line()
        for _ in range(0, height):
            print(cseparator, end="")
            for _ in range(0, cols):
                print(" " * (width * 2 + 1), end="")
                print(cseparator, end="")
            print()
    print_line()


print_grid(3, 4, 4, 5)
