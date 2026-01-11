// Given two non-negative integers num1 and num2
// represented as strings, return the product 
// of num1 and num2, also represented as a string.

// Note: You must not use any built-in BigInteger
// library or convert the inputs to integer directly.
// 1 <= num1.length, num2.length <= 200
// num1 and num2 consist of digits only.
// Both num1 and num2 do not contain any leading
// zero, except the number 0 itself.

class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int m=num1.length();
        int n=num2.length();
        int[] product=new int[m+n];
        int sum=0;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int prod=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                sum=prod+product[i+j+1];
                product[i+j+1]=sum%10;
                product[i+j]+=sum/10;
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int p:product){
            if( !(sb.isEmpty() && p==0)){
                sb.append(p);
            }
        }

        return sb.toString();
    }
}



// Time	O(m * n)	O(1) (since m, n ≤ 200)
// Space	O(m + n)	O(1)