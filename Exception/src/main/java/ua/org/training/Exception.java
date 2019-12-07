package ua.org.training;

public class Exception {

        public static void main(String[] args) {
                // f(null);
                System.out.println("out".length() + " one more".length() + " string");
                //System.out.println(sqr(2.0));
                System.out.println("result = " + sqr_nothing(0.));
                throw new Error();
        }
        public static void f(NullPointerException e) {
                try {
                        throw e;
                } catch (NullPointerException npe) {
                        f(npe);
                }
        }

        public double sqr_int(double arg) {
                int k = 1;
                return (double) k;
        }

        public static double sqr(double arg) {
                if (System.currentTimeMillis() % 2 == 0) {
                        return arg * arg;
                }
                while (true);
        }

        public static double sqr_infinity(double arg) {
                while (true);
        }

        public static double sqr_nothing(double arg) {
                throw new RuntimeException();
        }
}
