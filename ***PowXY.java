//http://www.cnblogs.com/grandyang/p/4383775.html

这道题让我们求x的n次方，如果我们只是简单的用个for循环让x乘以自己n次的话，
未免也把LeetCode上的想的太简单了，一句话形容图样图森破啊。OJ因超时无法通过，
所以我们需要优化我们的算法，使其在更有效的算出结果来。我们可以用递归来折半计算，
每次把n缩小一半，这样n最终会缩小到0，任何数的0次方都为1，这时候我们再往回乘
，如果此时n是偶数，直接把上次递归得到的值算个平方返回即可，如果是奇数，
则还需要乘上个x的值。还有一点需要引起我们的注意的是n有可能为负数，
对于n是负数的情况，我们可以先用其绝对值计算出一个结果再取其倒数即可，代码如下：

class Solution {
public:
    double pow(double x, int n) {
        if (n < 0) return 1 / power(x, -n);
        return power(x, n);
    }
    double power(double x, int n) {
        if (n == 0) return 1;
        double half = power(x, n / 2);
        if (n % 2 == 0) return half * half;
        return x * half * half;
    }
};

class Solution {
public:
    double pow(double x, int n) {
        if (n == 0) return 1;
        double half = pow(x, n / 2);
        if (n % 2 == 0) return half * half;
        else if (n > 0) return half * half * x;
        else return half * half / x;
    }
};


//http://www.cnblogs.com/grandyang/p/4383775.html