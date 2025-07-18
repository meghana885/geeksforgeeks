class Solution:
    def gcd(self, a, b):
        while b:
            a, b = b, a % b
        return a

    def lcm(self, a, b):
        return a * b // self.gcd(a, b)

    def lcm_of_three(self, a, b, c):
        return self.lcm(self.lcm(a, b), c)

    def lcmTriplets(self, n):
        if n <= 2:
            return n
        if n == 3:
            return 6
        
        # For even n, check n*(n-1)*(n-3) and (n-1)*(n-2)*(n-3)
        if n % 2 == 0:
            l1 = self.lcm_of_three(n, n - 1, n - 3)
            l2 = self.lcm_of_three(n - 1, n - 2, n - 3)
            return max(l1, l2)
        else:
            # For odd n, use (n, n-1, n-2)
            return self.lcm_of_three(n, n - 1, n - 2)
