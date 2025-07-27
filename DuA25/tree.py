class Tree:
    def __init__(self):
        self.left = None
        self.right = None
        self.value = None
        self.height = 1


def height(tree):
    if tree is None:
        return 0
    return tree.height


def balance(tree):
    if tree is None:
        return 0
    return height(tree.left) - height(tree.right)


def rotate_left(x):
    y = x.right
    z = y.left
    y.left = x
    x.right = z
    x.height = 1 + max(height(x.left), height(x.right))
    y.height = 1 + max(height(y.left), height(y.right))
    return y


def rotate_right(x):
    y = x.left
    z = y.right
    y.right = x
    x.left = z
    x.height = 1 + max(height(x.left), height(x.right))
    y.height = 1 + max(height(y.left), height(y.right))
    return y


def rebalance(tree):
    b = balance(tree)

    if b > 1 and balance(tree.left) >= 0:
        return rotate_right(tree)

    if b < -1 and balance(tree.right) <= 0:
        return rotate_left(tree)

    if b > 1 and balance(tree.left) < 0:
        tree.left = rotate_left(tree.left)
        return rotate_right(tree)

    if b < -1 and balance(tree.right) > 0:
        tree.right = rotate_right(tree.right)
        return rotate_left(tree)

    return tree


def member(tree, value):
    assert isinstance(tree, Tree)

    if value < tree.value:
        if tree.left is not None:
            return member(tree.left, value)
        else:
            return False

    if value > tree.value:
        if tree.right is not None:
            return member(tree.right, value)
        else:
            return False

    return True


def insert(tree, value):
    assert tree is None or isinstance(tree, Tree)

    if tree is None:
        tree = Tree()
        tree.value = value
        return tree

    if tree.value is None:
        tree.value = value
        return tree

    if value == tree.value:
        return tree

    if value < tree.value:
        tree.left = insert(tree.left, value)

    if value > tree.value:
        tree.right = insert(tree.right, value)

    tree.height = 1 + max(height(tree.left), height(tree.right))
    return rebalance(tree)


def delete(tree, value):
    if tree is None or tree.value is None:
        return tree

    if value < tree.value:
        tree.left = delete(tree.left, value)
    elif value > tree.value:
        tree.right = delete(tree.right, value)
    else:
        if tree.left is None:
            return tree.right

        if tree.right is None:
            return tree.left

        succ = tree.left
        while succ.right != None:
            succ = succ.right
        tree.value = succ.value
        tree.left = delete(tree.left, succ.value)

    tree.height = 1 + max(height(tree.left), height(tree.right))
    return rebalance(tree)


def export(tree, file):
    import treelib

    def build(tree, display: treelib.Tree, parent=None):
        if tree is None:
            return

        display.create_node(tag=tree.value, identifier=tree.value, parent=parent)

        if tree.left is not None:
            build(tree.left, display, parent=tree.value)

        if tree.right is not None:
            build(tree.right, display, parent=tree.value)

    display = treelib.Tree()
    build(tree, display)
    display.to_graphviz(file)


tree = None
assert height(tree) == 0
assert balance(tree) == 0

tree = insert(tree, 1)
assert member(tree, 1)
assert height(tree) == 1
assert balance(tree) == 0

tree = insert(tree, 3)
assert member(tree, 3)
assert height(tree) == 2
assert balance(tree) == -1

tree = insert(tree, 2)
assert member(tree, 2)
assert height(tree) == 2
assert balance(tree) == 0

tree = insert(tree, 4)
assert member(tree, 4)
assert height(tree) == 3
assert balance(tree) == -1

tree = insert(tree, 5)
assert member(tree, 5)
assert height(tree) == 3
assert balance(tree) == -1

tree = insert(tree, 6)
assert member(tree, 6)
assert height(tree) == 3
assert balance(tree) == 0

tree = delete(tree, 3)
assert not member(tree, 3)
assert height(tree) == 3
assert balance(tree) == 0

tree = delete(tree, 2)
assert not member(tree, 2)
assert height(tree) == 3
assert balance(tree) == -1

tree = insert(tree, 2)
assert member(tree, 2)
assert height(tree) == 3
assert balance(tree) == 0

tree = delete(tree, 6)
assert not member(tree, 6)
assert height(tree) == 3
assert balance(tree) == 1

tree = delete(tree, 5)
assert not member(tree, 5)
assert height(tree) == 2
assert balance(tree) == 0

tree = insert(tree, 0)
assert member(tree, 0)
assert height(tree) == 3
assert balance(tree) == 1

tree = insert(tree, -1)
assert member(tree, -1)
assert height(tree) == 3
assert balance(tree) == 1

tree = insert(tree, -2)
assert member(tree, -2)
assert height(tree) == 3
assert balance(tree) == 0

export(tree, "tree.dot")
print("all assertions passed")
print("tree written to tree.dot")
