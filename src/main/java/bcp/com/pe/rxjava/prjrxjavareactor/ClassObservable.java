package bcp.com.pe.rxjava.prjrxjavareactor;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.List;

public class ClassObservable {

    public static void main(String[] args) {
//        justObservable();
        observableList();

    }

    public static void createObservable() {
        Observable<String> observable = Observable.create(emiter -> {
            try{
                emiter.onNext("first");
                emiter.onNext("secord");
                emiter.onNext("third");
                emiter.onComplete();
            } catch (Exception e) {
                emiter.onError(e);
            }
        });
    }

    public static void justObservable(){

        Observable<String> observable2 = Observable.just("first", "secord", "third");
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("onNext: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("the printing  operation is complete");

            }
        };
        observable2.subscribe(System.out::println, Throwable::printStackTrace,
                () ->  System.out.println("the printing  operation is complete"));
    }

    public static void observableList(){
        Observable<String> observableFirst = Observable.just("first", "secord", "third");
        observableFirst.subscribe(e -> System.out.println("observer1: " + e));
        observableFirst.subscribe(e -> System.out.println("observer2: " + e));


        System.out.println("==============from Iterrable Factory ======================");
        List<String> list = List.of("jack", "Tim","Maria","Jackeline");

        Observable<String> observableSecond = Observable.fromIterable(list);


        observableSecond.subscribe(e -> System.out.println("observer1: " + e));
        observableSecond.subscribe(e -> System.out.println("observer2: " + e));
    }


}
