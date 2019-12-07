package ua.org.training;

public class Exception {

        public static void main(String[] args) {
                // f(null);
                System.out.println("out".length() + " one more".length() + " string");
                //System.out.println(sqr(2.0));
                //System.out.println("result = " + sqr_nothing(0.));
                System.out.println("area = " + area(-20, 30));
                throw new Error();
        }

        private static void f(NullPointerException e) {
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

        private static int area(int width, int height) {
                if (width < 0 || height < 0) {
                        //return -1;
                        //System.exit(3);
                        throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
                }
                return width * height;
        }
}
