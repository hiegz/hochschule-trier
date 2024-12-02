import math


def eval_loop():
    res = ""
    while True:
        user_input = input("> ")
        if user_input == "done":
            break
        try:
            res = eval(user_input)
            print("\033[0;32m{0}\033[0m".format(res))
        except:
            print("\033[0;31m{0}\033[0m".format("[Err] Falsche eingabe"))
            continue
    print(res)


eval_loop()
