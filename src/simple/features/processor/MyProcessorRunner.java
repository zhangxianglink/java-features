package simple.features.processor;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

/**
 * @author xiangzhang
 * @since 2022-01-31 22:52
 */
public class MyProcessorRunner {
    public static void main(String[] args) throws InterruptedException {
        // 发布
        final SubmissionPublisher<Employee> publisher = new SubmissionPublisher<>();
        // 订阅
        final MySubscriber mySubscriber = new MySubscriber();
        publisher.subscribe(mySubscriber);

        // 传输数据
        final List<Employee> emps = EmpHelper.getEmps();
        for (var e:
             emps) {
            publisher.submit(e);
            Thread.sleep(1000);
        }

        while (emps.size() != mySubscriber.getCounter()){
            System.out.println("发布数据未接收完毕");
        }

        publisher.close();
        System.out.println("结束");

    }

}
