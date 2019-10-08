package com.liuf.springboot.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author liuf
 * @create 2019-06-09 16:41
 * @RabbitListener bindings:绑定队列
 * @QueueBinding
 * @Queue value:配置队列名称
 *        autoDelete:是否是一个可删除的临时队列
 * @Exchange value:命名交换器
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.debug}",autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.DIRECT),
                key = "${mq.config.queue.info.routint.key}"
        )

)
public class DebugReceiver {

    private boolean flag;

    @RabbitHandler
    public void process(String msg){
        try {
            System.out.println(flag);
//            String msg1 = new String(message, "UTF-8");
//            System.out.println("debug msg1........"+msg1);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("debug...........receiver:"+msg);
    }
}