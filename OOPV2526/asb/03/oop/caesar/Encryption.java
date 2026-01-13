package oop.caesar;

public class Encryption
{
    private static final byte[] ALPHABET = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
    };

    public static String encode(String plaintext, int key)
    {
        byte[] ciphertext = plaintext.toLowerCase().getBytes();

        for (int i = 0; i < ciphertext.length; ++i)
        {
            byte ch = ciphertext[i];
            if (ch < 'a' || ch > 'z')
            {
                continue;
            }
            int pos = ch - 'a';
            ch = ALPHABET[(((pos + key) % ALPHABET.length) + ALPHABET.length) % ALPHABET.length];
            ciphertext[i] = ch;
        }

        return new String(ciphertext);
    }
}
