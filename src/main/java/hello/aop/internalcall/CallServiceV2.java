package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV2 {

    //    private final ApplicationContext applicationContext;
    private final ObjectProvider<CallServiceV2> callServiceObjectProvider;

//    public CallServiceV2(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }


    public CallServiceV2(ObjectProvider<CallServiceV2> callServiceObjectProvider) {
        this.callServiceObjectProvider = callServiceObjectProvider;
    }

    public void external() {
        log.info("call external");
//        CallServiceV2 callServiceV2 = applicationContext.getBean(CallServiceV2.class);
        CallServiceV2 callServiceV2 = callServiceObjectProvider.getObject();
        callServiceV2.internal(); //내부 메서드 호출(this.internal())
    }

    public void internal() {
        log.info("call internal");
    }
}