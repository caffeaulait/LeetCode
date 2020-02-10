package com.caffeaulait;

public class nowcoder_46 {
    /**
     * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
     * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
     * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
     */
    public int NumberOf1Between1AndN_Solution(int n){
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<= n; i++){
            sb.append(i);
        }
        String s = sb.toString();
        for (int i = 0; i <s.length(); i++){
            if (s.charAt(i) == '1')
                count++;
        }
        return count;
    }

    public int NumberOf1Between1AndN_Solution2(int n){
        /**
         * 链接：https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6?f=discussion
         * 来源：牛客网
         *
         * 我们知道在个位数上，1会每隔10出现一次，例如1、11、21等等，我们发现以10为一个阶梯的话，每一个完整的阶梯里面都有一个1，
         * 例如数字22，按照10为间隔来分三个阶梯，在完整阶梯0-9，10-19之中都有一个1，但是19之后有一个不完整的阶梯，
         * 我们需要去判断这个阶梯中会不会出现1，易推断知，如果最后这个露出来的部分小于1，则不可能出现1（这个归纳换做其它数字也成立）。
         * n/10 * 1+(n%10!=0 ? 1 : 0)
         *
         * 现在说十位数，十位数上出现1的情况应该是10-19，依然沿用分析个位数时候的阶梯理论，我们知道10-19这组数，每隔100出现一次，
         * 这次我们的阶梯是100，例如数字317，分析有阶梯0-99，100-199，200-299三段完整阶梯，每一段阶梯里面都会出现10次1（从10-19），最后分析露出来的那段不完整的阶梯。我们考虑如果露出来的数大于19，那么直接算10个1就行了，因为10-19肯定会出现；如果小于10，那么肯定不会出现十位数的1；如果在10-19之间的，我们计算结果应该是k - 10 + 1。例如我们分析300-317，17个数字，1出现的个数应该是17-10+1=8个。
         * 那么现在可以归纳：十位上1出现的个数为：
         * 设k = n % 100，即为不完整阶梯段的数字
         * 归纳式为：(n / 100) * 10 + (if(k > 19) 10 else if(k < 10) 0 else k - 10 + 1)
         *
         *
         * 设i为计算1所在的位数，i=1表示计算个位数的1的个数，10表示计算十位数的1的个数等等。
         * k = n % (i * 10)
         * count(i) = (n / (i * 10)) * i + (if(k > i * 2 - 1) i else if(k < i) 0 else k - i + 1)
         */
        if (n <=0)
            return 0;
        int count = 0;
        for (long i = 1; i<=n; i*=10){
            long k = n % (i * 10);
            count += (n/(i*10))*i;
            if (k > 2*i-1){
                count+=i;
            }else if (k>=i && k<=2*i-1){
                count+=k-i+1;
            }else{
                //do nothing
            }
        }
        return count;
    }


}
