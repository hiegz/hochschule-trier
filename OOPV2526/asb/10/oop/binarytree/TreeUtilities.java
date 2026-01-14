package oop.binarytree;

public class TreeUtilities
{
    public static<T> String treeToString(Node<T> node)
    {
        return treeToStringRecursive(node, 0);
    }

    private static<T> String treeToStringRecursive(Node<T> node, int depth)
    {
        if (node == null)
        {
            return "";
        }

        String repr = "";

        T content = node.getContent();
        Node<T> left = node.getLeft();
        Node<T> right = node.getRight();

        for (int i = 0; i < depth; ++i)
        {
            repr += "|__";
        }

        repr += content.toString();
        repr += "\n";

        repr += treeToStringRecursive(left, depth + 1);
        repr += treeToStringRecursive(right, depth + 1);

        return repr;
    }

    public static<T> Node<T> cloneTree(Node<T> node)
    {
        if (node == null)
        {
            return null;
        }

        return new Node<>(node.getContent(), cloneTree(node.getLeft()), cloneTree(node.getRight()));
    }

    public static<T> boolean compareTrees(Node<T> a, Node<T> b)
    {
        if (a == null && b == null)
        {
            return true;
        }

        if ((a == null && b != null) || (a != null && b == null))
        {
            return false;
        }

        return a.getContent().equals(b.getContent()) && compareTrees(a.getLeft(), b.getLeft()) && compareTrees(a.getRight(), b.getRight());
    }

    public static int evaluateTree(Node<String> expression)
    {
        if (expression == null)
        {
            throw new IllegalArgumentException();
        }

        if (expression.getLeft() == null && expression.getRight() == null)
        {
            try
            {
                return Integer.parseInt(expression.getContent());
            }
            catch (NumberFormatException e)
            {
                throw new IllegalArgumentException();
            }
        }

        switch (expression.getContent())
        {
            case "+":
                return evaluateTree(expression.getLeft()) + evaluateTree(expression.getRight());

            case "-":
                return evaluateTree(expression.getLeft()) - evaluateTree(expression.getRight());

            case "*":
                return evaluateTree(expression.getLeft()) * evaluateTree(expression.getRight());

            case "/":
                return evaluateTree(expression.getLeft()) / evaluateTree(expression.getRight());

            default:
                throw new IllegalArgumentException();
        }
    }
}
