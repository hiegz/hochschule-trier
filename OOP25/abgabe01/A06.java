public class A06 {
    public static void main(String[] args) {
        boolean p = true, q = false;

        System.out.println(p ^ q);
        System.out.println((p & !q) | (q & !p));
        System.out.println((p | !q) & (!p | q));

        // @formatter:off
        // p & !q
        assert (true  & !true)  == false;
        assert (false & !false) == false;
        assert (false & !true)  == false;
        assert (true  & !false) == true;
        // @formatter:on

        // @formatter:off
        // p | (p != q)
        assert (true  | (true  != true))  == true;
        assert (false | (false != true))  == true;
        assert (true  | (true  != false)) == true;
        assert (false | (false != false)) == false;
        // @formatter:on

        // @formatter:off
        // p != q <-> !(p & q)
        assert (true  != true)  == !(true  & true);
        assert (false != false) != !(false & false);
        assert (false != true)  == !(false & true);
        assert (true  != false) == !(true  & false);
        // @formatter:on

        // @formatter:off
        // p != q <-> (p | q) & !(p & q)
        assert (true  != true)  == ((true  | true)  & !(true  & true));
        assert (false != false) == ((false | false) & !(false & false));
        assert (false != true)  == ((false | true)  & !(false & true));
        assert (true  != false) == ((true  | false) & !(true  & false));
        // @formatter:on

        // @formatter:off
        assert true == (false != true);
        assert true == !false;
        // @formatter:on
    }
}
