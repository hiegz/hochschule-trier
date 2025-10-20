#counter(heading).update((3, 11))
== Aufgabe: Feistel-Cipher mit F(X, Y) = X

Für diese Aufgabe wurde das folgende Hilfsprogramm verwendet

```c
#include <stdint.h>
#include <stdio.h>

uint64_t F(uint64_t in, uint64_t key) {
    (void)key;

    return (in & 0x00000000FFFFFFFF);
}

uint64_t R(uint64_t in, uint64_t key) {
    const uint64_t left  = (in & 0xFFFFFFFF00000000) >> 32;
    const uint64_t right = (in & 0x00000000FFFFFFFF);
    const uint64_t fout  = F(right, key);

    return (right << 32) | (left ^ fout) & 0x00000000FFFFFFFF;
}

int main(int argc, char *argv[]) {
    (void)argc, (void)argv;

    uint64_t plaintext = 0x123456789abcdef1;
    uint64_t block     = plaintext;

    fprintf(stdout, "plaintext : %lx\n\n", plaintext);

    for (int i = 1; i < 10; ++i) {
        block = R(block, 0);
        fprintf(stdout, "round #%02d : %lx\n", i, block);
    }

    return 0;
}
```

Der Plaintext ist ein 64-Bit-Block, gegeben durch
$ P = (L_0, R_0) = ("0x12345678", "0x9abcdef1") $
Es werden insgesamt 9 Runden der Feistel-Verschlüsselung durchgeführt. Nach
jeder Runde ergeben sich die folgenden Blöcke:

```
#01 : 9abcdef188888889
#02 : 8888888912345678
#03 : 123456789abcdef1
#04 : 9abcdef188888889
#05 : 8888888912345678
#06 : 123456789abcdef1
#07 : 9abcdef188888889
#08 : 8888888912345678
#09 : 123456789abcdef1
```

Die Qualität der Verschlüsselung ist offensichtlich sehr schlecht, weil die
Feistel-Funktion den Schlüssel komplett ignoriert. Man sieht auch aus den
Blöcken, dass sich der Plaintext jede dritte Runde wiederholt. Somit kann ein
Angreifer den Ciphertext sehr einfach entschlüsseln, sobald er den Algorithmus
kennt.
