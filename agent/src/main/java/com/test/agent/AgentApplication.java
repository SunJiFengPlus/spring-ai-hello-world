package com.test.agent;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class AgentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgentApplication.class, args);
    }

    @Bean
    public CommandLineRunner predefinedQuestions(ChatClient.Builder chatClientBuilder, ConfigurableApplicationContext context) {
        return args -> {
            var chatClient = chatClientBuilder.build();
            // 定义用户输入
            String userInput = "你是谁";
            // 打印问题
            System.out.println("\n>>> QUESTION: " + userInput);
            // 调用LLM并打印响应
            System.out.println("\n>>> ASSISTANT: ");
            chatClient.prompt(userInput)
                .stream()
                .content()
                .doOnNext(System.out::print)
                .blockLast();

            // 关闭应用上下文
            context.close();
        };
    }
}
