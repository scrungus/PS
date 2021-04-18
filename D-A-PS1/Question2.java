import java.math.BigDecimal;

public class Question2 {
    public static void main(String[] args) {
        System.out.println("//part a)");
        StringRepeater repeater = new StringRepeater();
        int[] inputs = {1,100,1000,10000};
        String s = "hello";
        int SEC_IN_NANO_SEC = 1000000000;

        for(int i =0; i<inputs.length;i++){

            long start = System.nanoTime();
            repeater.repeatString(s, inputs[i]);
            long end = System.nanoTime();

            long timeElapsed = end-start;
            System.out.println(timeElapsed);

            BigDecimal result = new BigDecimal(timeElapsed);
            result = result.divide(new BigDecimal(SEC_IN_NANO_SEC));

            System.out.println("T("+inputs[i]+") = "+result+" seconds");
        }
        System.out.println();
        System.out.println("//part b)");
        int REPEATS = 100;
        for(int i =0; i<inputs.length;i++){

            long start = System.nanoTime();
            for(int j=0; j<REPEATS;j++){
                repeater.repeatString(s, inputs[i]);
            }
            long end = System.nanoTime();
            
            long timeElapsed = end-start;
            System.out.println(timeElapsed);

            BigDecimal result = new BigDecimal(timeElapsed);
            result = result.divide(new BigDecimal(REPEATS));
            result = result.divide(new BigDecimal(SEC_IN_NANO_SEC));

            System.out.println("T("+inputs[i]+") = "+result+" seconds");
        }
        
    }
}
