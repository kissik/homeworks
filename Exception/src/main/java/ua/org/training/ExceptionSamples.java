package ua.org.training;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

class Parent {
        public void f() throws IOException, InterruptedException {
                return;
        }
}

class Child extends Parent {
        @Override
        public void f() throws FileNotFoundException {
                return;
        }
}

public class ExceptionSamples {

        public static void main(String[] args) throws IOException, InterruptedException{
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
                /* Error: Child after Parent!
                try {
                        } catch (Exception e) {
                        } catch (RuntimeException e) {
                        }
                 */
                f0();
                f1();
                f2();
        }
        public static void f0() throws EOFException {
                return;
        }
        public static void f1() throws FileNotFoundException {
                return;
        }
        public static void f2() throws InterruptedException {
                return;
        }

        public static void fk(){
                try {
                        System.err.print(" 0");
                        try {
                                System.err.print(" 1");
                                if (true) {throw new Error();}
                                System.err.print(" 2");
                        } catch (RuntimeException e) {
                                System.err.print(" 3");
                        } finally {
                                System.err.print(" 4");
                        }
                        System.err.print(" 5");
                } catch (Exception e) {
                        System.err.print(" 6");
                } finally {
                        System.err.print(" 7");
                }
                System.err.print(" 8");
        }

        public static void fj(){
                try {
                        System.err.print(" 0");
                        try {
                                System.err.print(" 1");
                                if (true) {throw new Exception();}
                                System.err.print(" 2");
                        } catch (RuntimeException e) {
                                System.err.print(" 3");
                        } finally {
                                System.err.print(" 4");
                        }
                        System.err.print(" 5");
                } catch (Exception e) {
                        System.err.print(" 6");
                } finally {
                        System.err.print(" 7");
                }
                System.err.print(" 8");
        }

        public static void fi(){
                try {
                        System.err.print(" 0");
                        try {
                                System.err.print(" 1");
                                if (true) {throw new RuntimeException();}
                                System.err.print(" 2");
                        } catch (RuntimeException e) {
                                System.err.print(" 3");
                        } finally {
                                System.err.print(" 4");
                        }
                        System.err.print(" 5");
                } catch (Exception e) {
                        System.err.print(" 6");
                } finally {
                        System.err.print(" 7");
                }
                System.err.print(" 8");
        }

        public static void fh(){
                try {
                        System.err.print(" 0 ");
                        try {
                                System.err.print(" 1 ");
                                // no more exception!
                                System.err.print(" 2 ");
                        } catch (RuntimeException e) {
                                System.err.print(" 3 ");
                        } finally {
                                System.err.print(" 4 ");
                        }
                        System.err.print(" 5 ");
                } catch (Exception e) {
                        System.err.print(" 6 ");
                } finally {
                        System.err.print(" 7 ");
                }
                System.err.print(" 8 ");
        }

        public static void fg(){
                try {
                        System.err.print(" 0 ");
                        if (true) {throw new RuntimeException();}
                        //sth went wrong and we didn't catch it
                        System.err.print(" 1 ");
                } catch(Error e) {
                        System.err.print(" 2 ");
                } finally {
                        System.err.print(" 3 ");
                }
                System.err.print(" 4 ");
        }

        public static void ff(){
                try {
                        System.err.print(" 0 ");
                        if (true) {throw new Error();}
                        //this never happen
                        System.err.print(" 1 ");
                } catch(Error e) {
                        System.err.print(" 2 ");
                } finally {
                        System.err.print(" 3 ");
                }
                System.err.print(" 4 ");
        }

        public static void fe(){
                try {
                        System.err.print(" 0 ");
                        // everything is ok
                        System.err.print(" 1 ");
                } catch(Error e) {
                        System.err.print(" 2 ");
                } finally {
                        System.err.print(" 3 ");
                }
                System.err.print(" 4 ");
        }

        private static int fa() {
                try {
                        throw new RuntimeException();
                } finally {
                        return 1;
                }
        }

        private static int fb(){
                try {
                        return 0;
                } finally {
                        throw new RuntimeException();
                }
        }

        private static int fc(){
                try {
                        throw new Error();
                } finally {
                        throw new RuntimeException();
                }
        }
        /*
                Lock lock = new ReentrantLock();
                ...
                lock.lock();
                try {
                    // some code
                } finally {
                    lock.unlock();
                }

                InputStream input = new FileInputStream("...");
                try {
                    // some code
                } finally {
                    input.close();
                }

        * */

        private static void fd(){
                        long rnd = System.currentTimeMillis();
                        boolean finished = false;
                        try {
                                if (rnd % 3 == 0) {
                                        throw new Error();
                                } else if (rnd % 3 == 1) {
                                        throw new RuntimeException();
                                } else {
                                        System.out.println("nothing at all");
                                }
                                finished = true;
                        } finally {
                                if (finished) {
                                        System.out.println("nothing at all");
                                } else {
                                        System.out.println("was sth, but what is it?");
                                }
                        }
        }

        private static int tryFinally(){
                try {
                        System.err.println("try");
                        if (true) return 1;
                        //if (true) throw new RuntimeException();
                        //System.exit(42);
                        //Runtime.getRuntime().exit(42);
                        //Runtime.getRuntime().halt(42);
                } finally {
                        System.err.println("finally");
                        if (true) return 42;
                }
                System.err.println("more");
                return 0;
        }

        private static void throwableVSexceptionRuntime(){
                try {
                        Throwable t = new Exception();
                        throw t;
                } catch (RuntimeException e) {
                        System.err.println("catch RuntimeException");
                } catch (Exception e) {
                        System.err.println("catch Exception");
                } catch (Throwable e) {
                        System.err.println("catch Throwable");
                }
                System.err.println("next statement");
        }

        private static void theFirstMatch(){
                try {
                        throw new Exception();
                } catch (RuntimeException e) {
                        System.err.println("catch RuntimeException");
                } catch (Exception e) {
                        System.err.println("catch Exception");
                } catch (Throwable e) {
                        System.err.println("catch Throwable");
                }
                System.err.println("next statement");
        }

        private static void broAfterBroInAnyOrder(){
                try {
                } catch (Error e) {
                } catch (RuntimeException e) {
                }
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
