package ua.org.training;

public class ExceptionSamples {

        public static void main(String[] args) throws Exception {
             /*   // f(null);
                System.out.println("out".length() + " one more".length() + " string");
                //System.out.println(sqr(2.0));
                //System.out.println("result = " + sqr_nothing(0.));
                System.out.println("area = " + area(-20, 30));
                throw new Error();

                System.err.println("#1.in");
                f();
                System.err.println("#1.out");

              */
                catchAllThrow();
        }

        private static void catchAllThrow(){
                try {
                        System.err.print(" 0 ");
                        if (true) {throw new RuntimeException();}
                        System.err.print(" 1 ");
                } catch (RuntimeException e) {
                        System.err.print(" 2.1 ");
                        try {
                                System.err.print(" 2.2 ");
                                if (true) {throw new Error();}
                                System.err.print(" 2.3 ");
                        } catch (Throwable t) {
                                System.err.print(" 2.4 ");
                        }
                        System.err.print(" 2.5 ");
                } catch (Error e) {
                        System.err.print(" 3 ");
                }
                System.err.println(" 4 ");
        }

        private static void throwsSecondErrorFromCatch(){
                try {
                        System.err.print(" 0 ");
                        if (true) {throw new RuntimeException();}
                        System.err.print(" 1 ");
                } catch (RuntimeException e) {
                        System.err.print(" 2 ");
                        if (true) {throw new Error();}
                } catch (Error e) {
                        System.err.print(" 3 ");
                }
                System.err.println(" 4 ");
        }

        private static void throwsTheSameFromCatch(){
                try {
                        System.err.print(" 0 ");
                        if (true) {throw new RuntimeException();}
                        System.err.print(" 1 ");
                } catch (RuntimeException e) {
                        System.err.print(" 2 ");
                        if (true) {throw e;}
                }
                System.err.println(" 3 ");
        }

        private static void throwsErrorFromCatch(){
                try {
                        System.err.print(" 0 ");
                        if (true) {throw new RuntimeException();}
                        System.err.print(" 1 ");
                } catch (RuntimeException e) {
                        System.err.print(" 2 ");
                        if (true) {throw new Error();}
                }
                System.err.println(" 3");
        }

        private static void exceptionVSchildException() throws Exception{
                try {
                        System.err.print(" 0 ");
                        if (true) {
                                throw new Exception();
                        }
                        System.err.print(" 1 ");
                } catch (RuntimeException e) {
                        if (e instanceof RuntimeException) {
                                RuntimeException re = (RuntimeException) e;
                                System.err.print("This is the RuntimeException!!!");
                        } else {
                                System.err.print("WTF??? But it must be a RuntimeException!!");
                        }
                }
                System.err.print(" 3 ");

        }

        private static void exceptionVSerror(){
                try {
                        System.err.print(" 0 ");
                        if (true) {throw new Error();}
                        System.err.print(" 1 ");
                } catch (Exception e) {
                        System.err.print(" 2 ");
                }
                System.err.print(" 3 ");
        }

        private static void f() {
                System.err.println(".   #2.in");
                g();
                System.err.println(".   #2.out");
        }

        private static void g() {
                System.err.println(".   .   #3.in");
                try {
                        h();
                } catch (Error e) {
                        System.err.println(".   .   #3.CATCH");
                }
                System.err.println(".   .   #3.out");
        }

        private static void h() {
                System.err.println(".   .   .   #4.in");
                if (true) {
                        System.err.println(".   .   .   #4.RETURN");
                        throw new Error();

                }
                System.err.println(".   .   .   #4.out");
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
