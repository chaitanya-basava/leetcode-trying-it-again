class Solution:
    def numOfSubarraysSpaceOptimal(self, arr):
        MOD = 1e9 + 7
        n = len(arr)
        count = 0

        # count of even and odd subarrays starting from i
        dp_even, dp_odd = 0, 0

        if arr[n - 1] % 2 == 0:
            dp_even = 1
        else:
            dp_odd = 1
            count += 1

        for num in range(n - 2, -1, -1):
            if arr[num] % 2 == 1:
                temp = dp_odd
                dp_odd = (1 + dp_even) % MOD
                dp_even = temp
            else:
                dp_even = (1 + dp_even) % MOD
                # dp_odd[num] = dp_odd[num + 1]

            count += dp_odd
            count %= MOD

        return int(count)


    def numOfSubarrays(self, arr):
        MOD = 1e9 + 7
        n = len(arr)
        count = 0

        # count of even and odd subarrays starting from i
        dp_even, dp_odd = [0] * n, [0] * n

        if arr[n - 1] % 2 == 0:
            dp_even[n - 1] = 1
        else:
            dp_odd[n - 1] = 1
            count += 1

        for num in range(n - 2, -1, -1):
            if arr[num] % 2 == 1:
                dp_odd[num] = (1 + dp_even[num + 1]) % MOD
                dp_even[num] = dp_odd[num + 1]
            else:
                dp_even[num] = (1 + dp_even[num + 1]) % MOD
                dp_odd[num] = dp_odd[num + 1]

            count += dp_odd[num]
            count %= MOD

        return int(count)