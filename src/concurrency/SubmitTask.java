package concurrency;

import java.util.List;
import java.util.concurrent.*;

class InvokeALL {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = null;

        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            Callable<String> task = () -> "result";
            List<Future<String>> list = service.invokeAll(List.of(task, task, task));

            for (Future<String> future : list) {
                System.out.println(future.get());
            }
            System.out.println("end");
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}

class InvokeAny {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = null;

        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            Callable<String> task = () -> "result";
            String data = service.invokeAny(List.of(task, task, task));
            System.out.println(data);
            System.out.println("end");
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}