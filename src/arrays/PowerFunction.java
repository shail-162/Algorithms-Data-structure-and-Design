package arrays;

/**
 * Write a program to calculate pow(x,n)
 * Given two integers x and n, write a function to compute xn.
 * We may assume that x and n are small and overflow doesn’t happen.
 */
public class PowerFunction {

    static float power(float x, int y)
    {
        float temp;
        if( y == 0)
            return 1;
        temp = power(x, y/2);

        if (y%2 == 0)
            return temp*temp;
        else
        {
            if(y > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }

    /* Program to test function power */
    public static void main(String[] args)
    {
        float x = 2;
        int y = -3;
        System.out.printf("%f", power(x, y));
    }
}
