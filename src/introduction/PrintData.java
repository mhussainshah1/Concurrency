package introduction;

public class PrintData implements Runnable {
    public static void main(String[] args) {
        (new Thread(new PrintData())).start();
    }

    @Override
    public void run() { // Overrides method in Runnable
        for (int i = 0; i < 3; i++)
            System.out.println("Printing record: " + i);
    }
}

class ReadInventoryThread extends Thread {
    public static void main(String[] args) {
        (new ReadInventoryThread()).start();
    }

    @Override
    public void run() { // Overrides method in Thread
        System.out.println("Printing zoo inventory");
    }
}


class MultiThreaded {
    public static void main(String[] args) {
        System.out.println("begin");
        (new ReadInventoryThread()).start();
        (new Thread(new PrintData())).start();
        (new ReadInventoryThread()).start();
        System.out.println("end");
    }
}

class SingleThread {
    public static void main(String[] args) {
        System.out.println("begin");
        (new ReadInventoryThread()).run();
        (new Thread(new PrintData())).run();
        (new ReadInventoryThread()).run();
        System.out.println("end");
    }
}

