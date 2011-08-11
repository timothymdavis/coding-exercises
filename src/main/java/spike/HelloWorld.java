package spike;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        // At this point you can modify JRebelHotswapTest and it will hotswap on compilation.

        new JRebelHotswapTest().printSomething();
    }

}
