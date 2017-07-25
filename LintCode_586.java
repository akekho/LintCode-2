public class Solution {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        // Write your code here
        double left = 0.0;
        double right = x;
        double eps = 1e-11;
        
        if(right < 1.0){
            right = 1.0;
        }
        
        while((right - left) > eps){
            double mid = left + (right - left) / 2;
            if(mid * mid <= x){
                left = mid;
            }else{
                right = mid;
            }
        }

        return left;
    }
}