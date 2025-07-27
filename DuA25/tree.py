class Tree:
    def __init__(self):
        self.left = None
        self.right = None
        self.value = None


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
        return tree

    if value > tree.value:
        tree.right = insert(tree.right, value)
        return tree


def delete(tree, value):
    if tree is None:
        return None

    if tree.value is None:
        return tree

    if value < tree.value:
        tree.left = delete(tree.left, value)
        return tree

    if value > tree.value:
        tree.right = delete(tree.right, value)
        return tree

    if value == tree.value:
        if tree.left is None:
            return tree.right

        if tree.right is None:
            return tree.left

        succ = tree.left
        while succ.right != None:
            succ = succ.right
        tree.value = succ.value
        tree.left = delete(tree.left, succ.value)

        return tree


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


tree = insert(None, 2)
assert member(tree, 2)
tree = insert(tree, 1)
assert member(tree, 1)
tree = insert(tree, 4)
assert member(tree, 4)
tree = insert(tree, 3)
assert member(tree, 3)
tree = insert(tree, 5)
assert member(tree, 5)
tree = delete(tree, 2)
assert not member(tree, 2)
export(tree, "tree.dot")
