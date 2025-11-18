#import "mathblock.typ": mathblock

+ #mathblock[
    $
      3^(-n) dot 3 n^2 = (3 n^2) / 3^n & <= n^2 #v(10pt) (c = 1) \
               (3 n^2) / (3^n dot n^2) & <= 1 \
                               3 / 3^n & <= 1 \
                                     3 & <= 3^n #v(10pt) ("für alle" n >= n_0 = 1)
    $
  ]

+ #mathblock[
    $
      2^(n + 1) <= 2 dot 2^n = 2^(n + 1) #v(10pt) (c = 2, n_0 = 0)
    $
  ]

+ #mathblock[
    $
      2^(2n) = 4^n, #v(10pt) forall_c forall_n_0 exists_(n > n_0) 4^n > c dot 2^n => 4^n in.not O(2^n)
    $
  ]

+ #mathblock[
    $
      n^((1 \/ log_2 n)) = 2^(log_2(n))^((1 \/ log_2 n)) = 2^(log_2(n)\/log_2(n)) = 2 in O(1)
    $
  ]
