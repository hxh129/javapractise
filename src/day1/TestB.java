package day1;

public class TestB extends TestA {
    @Override
    public void testOut() {
        System.out.println("testsB");
    }
    public void realTest(){
        super.testOut();
    }
    public static void main(String[] args){
        TestB testB = new TestB();
        testB.testOut();
        testB.realTest();
    }
}
