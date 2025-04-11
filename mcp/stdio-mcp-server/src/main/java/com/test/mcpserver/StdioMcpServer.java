package com.test.mcpserver;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StdioMcpServer {

    /*
     * 启动后在控制台输入以下命令, 即可进行交互式调用:
     * 
     * {"jsonrpc":"2.0","id":12345678,"method":"tools/list"}
     * {"jsonrpc":"2.0","id":12345678,"method":"tools/call","params":{"name":"getWeatherForecastByLocation","arguments":{"latitude":"39","longitude":"116"}}}
     */
    public static void main(String[] args) {
        SpringApplication.run(StdioMcpServer.class, args);
    }

    @Bean
    public ToolCallbackProvider weatherTools(WeatherService weatherService) {
        return MethodToolCallbackProvider.builder()
            .toolObjects(weatherService)
            .build();
    }
}
