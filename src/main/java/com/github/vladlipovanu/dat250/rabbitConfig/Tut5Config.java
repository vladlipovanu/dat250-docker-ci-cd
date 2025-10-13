package com.github.vladlipovanu.dat250.rabbitConfig;

import org.springframework.amqp.core.*;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;



@Profile({"polls","poll-app"})
@Configuration
public class Tut5Config {

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
    @Bean
    public TopicExchange topic() {
        return new TopicExchange("poll.votes");
    }

    @Profile("receiver")
    private static class ReceiverConfig {

        @Bean
        public Tut5Receiver receiver() {
            return new Tut5Receiver();
        }

      @Bean
        public Queue queue() {
            return new Queue("poll.votes",true);
      }

      @Bean
        public Binding binding(TopicExchange topic, Queue queue) {
            return BindingBuilder.bind(queue).to(topic).with("vote.#");
      }
    }

    @Profile("sender")
    @Bean
    public Tut5Sender sender(){
        return new Tut5Sender();
    }
}
