public class ThreadsTest {
    public static void main(String[] args) throws InterruptedException {
//        cmp1 cmp = new cmp1();
//        BTree<Integer, cmp1> testBtree = new BTree<>(cmp, 2);
//        Test1 test1 = new Test1(testBtree);
//        Test2 test2 = new Test2(testBtree);
//        Thread testThread1 = new Thread(test1);
//        Thread testThread2 = new Thread(test2);
//
//        testThread1.start();
//        testThread2.start();
//
//        testBtree.levelTravel(testBtree.getRoot());
        ALlTest aLlTest = new ALlTest();
        aLlTest.test();
    }
}

class ALlTest{
    int flag1 = 0;
    int flag2 = 0;
    cmp1 cmp = new cmp1();
    BTree<Integer, cmp1> testBtree = new BTree<>(cmp, 2);

    public void test() throws InterruptedException {
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        Thread testThread1 = new Thread(test1);
        Thread testThread2 = new Thread(test2);

        testThread1.start();
        testThread2.start();

        testThread1.join();//礼让插入线程1
        testThread2.join();//礼让插入线程2

        testBtree.levelTravel(testBtree.getRoot());
    }

    class Test1 implements Runnable{
        @Override
        public void run() {
            testBtree.insert(testBtree.getRoot(), 10);
            testBtree.insert(testBtree.getRoot(), 9);
            testBtree.insert(testBtree.getRoot(), 12);
            testBtree.insert(testBtree.getRoot(), 13);
            testBtree.insert(testBtree.getRoot(), 14);
            testBtree.insert(testBtree.getRoot(), 11);
            testBtree.insert(testBtree.getRoot(), 8);
            flag1++;
        }
    }

    class Test2 implements Runnable{
        @Override
        public void run() {
            testBtree.insert(testBtree.getRoot(), 7);
            testBtree.insert(testBtree.getRoot(), 6);
            testBtree.insert(testBtree.getRoot(), 5);
            testBtree.insert(testBtree.getRoot(), 25);
            testBtree.insert(testBtree.getRoot(), 56);
            testBtree.insert(testBtree.getRoot(), 2);
            testBtree.insert(testBtree.getRoot(), 2);
            testBtree.insert(testBtree.getRoot(), 13);
            flag2++;
        }
    }
}

