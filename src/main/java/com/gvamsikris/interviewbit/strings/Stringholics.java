package com.gvamsikris.interviewbit.strings;

import java.util.Arrays;
import java.util.List;

public class Stringholics {

    private final static long base = (long) (1e9 + 7);

    public static void main(String[] args) {
        Stringholics stringholics = new Stringholics();
        int solve = stringholics.solve(Arrays.asList(
                new String[] { "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "babaaaabbaba", "baaaaababaabbaaaaabbbbbbbaabbaaaababbabaababaabaaabbbaaaaa",
                        "abaabb",
                        "aababbbbabbaaaabbaaaaaaaababbbabbbbaabbaabaabbaabaababbbababaababaabbababaaabaaaab",
                        "babaaaaababbbbbabbbbabbaaabaaaababbabbaabbbabbaaaabbbabaaaabaaaababb",
                        "bbbbbbaaaaaabbbbbbababaabaabbbbbaaabbabbaabbbbaaaaaababbabaaabbabbabbbabbaabbabbbbaabbbaaaaabbabaaab",
                        "aabaaabaabbbbababbabbabaaaababbababbbabbbbaabbaaaaababbbbbababbbbaaababababab", "aaaababbbaabbbabaabb",
                        "ababaaaabbabbbbaaabbababbbabbbabaaa", "aaabaabbbabaa", "baababbababbbbbabbabaabbabbbbbaaaabaaaababaa", "babaa",
                        "abbabababbbbbbbbbbbaaaaaababbababaaabbbaaaabbbababbabaabbaabbbbaabbbaabbababababaabaaabbaaabbba",
                        "ababbaabbaaabbbabaabababbbabaaabbbaababaaa", "abbaaaababbbbaaabaaaabaaaaabaababbabbaababbbabbbbbbbbbabbaabaaabbaaababbbaa",
                        "bbabababaabbabbabbbabbaababbabaaabbbababab", "abbbaaabaab", "bbaaabbaaabbaabbabababa",
                        "aabaabaaaaaaabaabbbaaababbbbbbababbaabababbaaaaabbabbbabbbaababbaabababbbbbbbbbaabaab", "babbaaabbabbaabaaabbb", "bbabaabba",
                        "baabaaaaabbaaaaaabbbbaaaabababa", "babbaababaaba",
                        "baabaabaabbababbaabbabbbbbabaaaabbbbbabbabbbbbabbbabaabbbbabbbbaaabbbbabababaaaababbaaabbabb",
                        "abbbbaaaabaabbabbaababaabbababbbaaabbabbbbbaaabbabbaabbb",
                        "bababaaaaabababbabbaabababbbaabbaabaabaabbabbbababbaaabababbababbbb",
                        "abaaabbbabbbaabba", "bbbbaaaabbbababaabbbababaaaababbaaaaaabbbabbaababababbba",
                        "bababaabaaaabbaabbababbaabbaabaabbaaaaaaaababbaaaaaabbaaabaabaaababbababbbbaabbabbabaabab",
                        "aabbbabaaabababaabbbbaabbabaaabbbaaabbabbbbabaabbbbaabbbaaaaabbbabbbbb",
                        "aabbbbbbabaabbbabbaababbababaabaaababbbbabbbaababaaaabbaaabaaabaaaabbbabababbab",
                        "abaaaaababbabaabbbaaaaabbaaaabaaaaaaaababbaabbbaabbabbbabbaaaaaab",
                        "bbbaabbabbbbbbaaaabbabbbbbbbaaabaababbaaaabbbaababbaaabbbbbbbbabbabababbaaabaabaaabaaaabbbbbabaabaaa",
                        "bbaaabaaabaaabaabaaabbaabaabbabaabaabbababaaaaabaabbbbaba", "abaababaaabbabaabaabbbaaabbaabababbabaaabbbbabbbbbaaaaa",
                        "abba",
                        "abbbababbaaabbaaabbbabaabbababaaabbbbaaaaababbabbaabbabbbaaabaabbaaaaabaaaabbbaabbbabbbbbbbabb",
                        "bbabbaaabaaaabbaaaabbbaaaababbbaabaaaaab",
                        "abbaabaabbaaaaaaaabbaabbabbababaaaaaaabbabaabaabbbabbaabbaababbaabbaba", "bbbbaababbaaaaaaaaabbbabbbabaabababaababaababa",
                        "baaabaabbbbbbaabbabbbabaaaaababaabaababbbaaaaaaaabbbbbabbabaaaaaaaabababaabaababaaabbaaaaaaaaabaa",
                        "aababbbabbaaaaababbabaababbbbbbbbaaabbaaaaabbaabbbba", "ababababaaaaaabbbabbaaababaabb", "bababbaababaabbbabbaab",
                        "baababababbaaaaabbbbbbbbbaabababb", "bbbbb", "aabaabbbaabababbababaaaaabbbbaababaabbabbbbbbaabbaaabbababbbabbabbbaabbbab",
                        "bbaabbbbaabbaaaaaabbbaabababbbaabaaabbbbbabaababbbaababbbaaabaaabaaaababbbbaabbaababb",
                        "aaababbaaaaabaabababbabaabbbbabbaba" }));
        System.out.println(solve);
    }

    public int solve(List<String> A) {
        int[] primeCnt = new int[300000];
        for (String a : A) {
            long c = minCycle(a);
            if (c <= 1) continue;
            int d = 2;
            do {
                int cnt = 0;
                while (c % d == 0) {
                    c /= d;
                    ++cnt;
                }
                if (cnt > 0 && cnt > primeCnt[d]) primeCnt[d] = cnt;
                ++d;
            } while (c > 1);
        }
        long res = 1L;
        for (int i = 2; i < primeCnt.length; ++i) {
            int cnt = primeCnt[i];
            if (cnt <= 0) continue;
            for (int j = 0; j < cnt; ++j)
                res = (res * i) % base;
        }
        return (int) (res);
    }

    private int minCycle(String a) {
        int l = a.length();
        boolean[] ok = foundPos(a);
        for (int t = 1; t <= 2 * l; ++t) {
            int r = (int) ((t * (t + 1L) / 2L) % l);
            if (ok[r]) return t;
        }
        return -1; // impossible
    }

    boolean[] foundPos(String a) {
        int l = a.length();
        boolean[] res = new boolean[l];
        res[0] = true;
        long aHash = rhash(a);
        long bHash = aHash;
        long pow = twoPow(l);
        for (int r = 1; r < l; ++r) {
            bHash = uphash(bHash, a.charAt(r - 1), pow);
            if (aHash == bHash &&
                    a.substring(0, r).equals(a.substring(l - r, l)) &&
                    a.substring(r, l).equals(a.substring(0, l - r)))
                res[r] = true;
        }
        return res;
    }

    long uphash(long hash, char a, long pow) {
        hash -= (a * pow) % base;
        if (hash < 0) hash += base;
        hash += a;
        return hash % base;
    }

    long twoPow(int pow) {
        long r = 1L;
        while (pow-- > 0)
            r = (r * 2L) % base;
        return r;
    }

    long rhash(String a) {
        long r = 0L;
        for (char c : a.toCharArray()) {
            r = ((r * 2L) + c) % base;
        }
        return r;
    }

}
