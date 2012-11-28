package spike;

public class HelloWorld {

    public static void main(String[] args) throws InterruptedException {
        JRebelHotswapTest jRebelHotswapTest = new JRebelHotswapTest();

        while(true) {
            jRebelHotswapTest.printSomething();
            Thread.sleep(1000);
        }
    }

}
