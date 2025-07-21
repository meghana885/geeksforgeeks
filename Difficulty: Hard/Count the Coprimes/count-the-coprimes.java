class Solution {
    int MAX = 10001;

    int cntCoprime(int[] arr) {
        int[] freq = new int[MAX];
        for (int num : arr) {
            freq[num]++;
        }

        int[] mu = new int[MAX];
        boolean[] isPrime = new boolean[MAX];
        for (int i = 0; i < MAX; i++) {
            mu[i] = 1;
            isPrime[i] = true;
        }

        // Compute Möbius function using Sieve
        for (int i = 2; i < MAX; i++) {
            if (isPrime[i]) {
                for (int j = i; j < MAX; j += i) {
                    mu[j] *= -1;
                    isPrime[j] = false;
                }
                for (int j = i * i; j < MAX; j += i * i) {
                    mu[j] = 0;
                }
            }
        }

        // For every d, count how many numbers are divisible by d
        int[] cnt = new int[MAX];
        for (int i = 1; i < MAX; i++) {
            for (int j = i; j < MAX; j += i) {
                cnt[i] += freq[j];
            }
        }

        // Inclusion-Exclusion using Möbius function
        long totalPairs = 0;
        for (int i = 1; i < MAX; i++) {
            if (mu[i] == 0) continue;
            long c = cnt[i];
            totalPairs += mu[i] * (c * (c - 1) / 2);
        }

        return (int) totalPairs;
    }
}
