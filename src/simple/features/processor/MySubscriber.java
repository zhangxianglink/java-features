package simple.features.processor;

import java.util.concurrent.Flow;

/**
 * @author xiangzhang
 * @since 2022-01-31 22:35
 */
public class MySubscriber implements Flow.Subscriber {

    private Flow.Subscription subscription;
    private int counter = 0;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("订阅");
        this.subscription = subscription;
        this.subscription.request(1);
        System.out.println("onSubscribe requested 1 item");
    }

    @Override
    public void onNext(Object item) {
        System.out.println("Processing Employee " + item);
        counter ++;
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("Some error happened");
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("All Processing Done");
    }

    public int getCounter() {
        return counter;
    }
}
