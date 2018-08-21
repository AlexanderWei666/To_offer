package com.alexander;

public class SingletonTest {

    public static void main(String[] args) {

        System.out.println("生成Singleton4:");
        Singleton4.method();
        Singleton4 s4 = Singleton4.getInstance();
        System.out.println("\n生成Singleton5:");
        Singleton5.method();
        Singleton5 s5 = Singleton5.getInstance();
        System.out.println("\n生成Singleton6:");
        Singleton6.method();
    }
    /**
     * 单例模式，饿汉式，线程安全
     */
    public static class Singleton1{
        private final static Singleton1 INSTANCE = new Singleton1("Singleton1");

        private Singleton1(String s){
            System.out.println("生成了单例：" + s);
        }

        public static Singleton1 getInstance() {
            return INSTANCE;
        }
    }

    /**
     * 单例模式，懒汉式，线程不安全
     */
    public static class Singleton2{
        private static Singleton2 instance = null;

        private Singleton2() {

        }

        public static Singleton2 getInstance() {
            if(instance == null)
                instance = new Singleton2();
            return instance;
        }
    }

    /**
     * 单例模式，懒汉式，线程安全，多线程环境下效率不高
     */
    public static class Singleton3{
        private static Singleton3 instance  = null;

        private Singleton3() {
        }

        public static synchronized Singleton3 getInstance() {
            if (instance == null){
                instance = new Singleton3();
            }
            return instance;
        }
    }


    /**
     * 单例模式，懒汉式，变种，线程安全
     */
    public static class Singleton4 {
        private static Singleton4 instance = null;

        static {
            System.out.println("创造单例");
            instance = new Singleton4();
        }

        public static void method(){
            System.out.println("调用静态方法");
        }

        private Singleton4() {
        }

        public static Singleton4 getInstance() {
            System.out.println("调用生成单例方法");
            return instance;
        }
    }

    /**
     * 单例模式，使用静态内部类，线程安全【推荐】,上面方法只要该类加载就生成单例，该方法只有调用才会
     */
    public static class Singleton5 {
        private final static class Singleton5Holder {
            static {
                System.out.println("创造单例");
            }
            private static final Singleton5 INSTANCE = new Singleton5();
        }

        public static void method(){
            System.out.println("调用静态方法");
        }
        private Singleton5(){
        }

        public static Singleton5 getInstance() {
            System.out.println("调用生成单例方法");
            return Singleton5Holder.INSTANCE;
        }
    }

    /**
     * 单例模式，使用枚举方式，线程安全
     */
    public enum Singleton6 {
        INSTANCE(6);

        private Singleton6(int i){
            System.out.println("调用枚举类私有构造器：" + i);
        }
        public static void method(){
            System.out.println("调用枚举静态方法");
        }
    }

    /**
     * 双重校验锁，线程安全
     */
    public static class Singleton7 {
        private volatile static Singleton7 instance = null;

        private Singleton7() {

        }

        public static Singleton7 getInstance() {
            if(instance == null) {//加锁前判断，避免无谓的加锁
                synchronized (Singleton7.class) {
                    if (instance == null) {
                        instance = new Singleton7();
                    }
                }
            }
            return instance;
        }
    }

}
