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
