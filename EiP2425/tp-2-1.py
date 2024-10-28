#
# 42 = n
# ^^
# SyntaxError: cannot assign to literal here. Maybe you meant '==' instead of '='?

#
# x = y = 1
#
# [OK]

#
# 1 + 1 * 2;
#
# [OK]

#
# 1 + 1 * 2.
#
# [OK]

#
# print('hello world').
#                     ^
# SyntaxError: invalid syntax

#
# x = 1
# y = 5
# print(xy)
#       ^^
# NameError: name 'xy' is not defined. Did you mean: 'x'?
