
归并算法的复杂度计算：

       T(n) = T(n/2) * 2 + c*n
            = {T(n/4) * 2 + c*n/2} * 2 + c*n
            = ......
            = O(1) * 2^k + c*k*n    ---> 2^k == n
            = n + c*n*logn    ---> k == logn
            = T(nlogn)