package com.jf.ab.java8;

import com.jf.printer.SystemPrinter;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

/**
 * Java-Features
 * argbwl
 * 04/10/22
 **/

public class BiConsumerUseCase<T1,T2> {

    //BiConsumer Interface have one method that is accepted with 2 param with return type void

    /**
     *
     * @param obj1
     * @param obj2
     *
     * <br/>
     * <pre>
     *     This method will check if both the given param is instanceof String<br/>
     *     [implemented base on java8 feature]
     * </pre>
     */
    public void findInstanceof(Object obj1, Object obj2){
        BiConsumer<Object,Object> biConsumer = (o1,o2)-> {
            if(null==o1 || null == o2) return;
            if(o1 instanceof String && o2 instanceof String){
                SystemPrinter.info("Both Object are instanceof of String");
            }else{
                SystemPrinter.info("Both Object are not instanceof of String");
            }
        };
        biConsumer.accept(obj1,obj2);
    }

    //This method will have flexibility to implement accept method as per requirement
    public void biConsumerAcceptImpl(@NotNull BiConsumer<? super T1, ? super T2> biConsumerAction, T1 objT1, T2 objT2){
        biConsumerAction.accept(objT1,objT2);
    }

    public static void main(String[] args) {
        new BiConsumerInnerClassImpl<>().accept("Hi", 10);
        new BiConsumerUseCase<Object,Object>().findInstanceof("Hi","Bye");
        new BiConsumerUseCase<Object,Object>().biConsumerAcceptImpl((t1,t2)->SystemPrinter.info(t1+" "+t2),
                                                                        "Hello","World!!");
    }

}

//Generic approach
final class BiConsumerInnerClassImpl<T1,T2> implements BiConsumer<T1,T2>{
    @Override
    public void accept(Object obj1, Object obj2) {
        if(null==obj1 || null == obj2) return;
        if(obj1 instanceof String && obj2 instanceof String){
            SystemPrinter.info("Both Object are instanceof of String");
        }else{
            SystemPrinter.info("Both Object are not instanceof of String");
        }
    }
}

