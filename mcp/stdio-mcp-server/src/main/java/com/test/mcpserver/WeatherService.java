package com.test.mcpserver;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
   
    @Tool(description = "根据经纬度获取天气预报")
    public String getWeatherForecastByLocation(
        @ToolParam(description = "纬度，例如：39.9042") String latitude,
        @ToolParam(description = "经度，例如：116.4074") String longitude) {
        
        return "当前位置（纬度：" + latitude + "，经度：" + longitude + "）的天气信息：\n" + "是晴天";
    }

    @Tool(description = "根据经纬度获取空气质量信息")
    public String getAirQuality(
        @ToolParam(description = "纬度，例如：39.9042") String latitude,
        @ToolParam(description = "经度，例如：116.4074") String longitude) {

        return "当前位置（纬度：" + latitude + "，经度：" + longitude + "）的空气质量：\n" +
            "- PM2.5: 15 μg/m³ (优)\n" +
            "- PM10: 28 μg/m³ (良)\n" +
            "- 空气质量指数(AQI): 42 (优)\n" +
            "- 主要污染物: 无";
    }
}