package io.github.rahulrajsonu.mcp_springboot;

import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbacks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class McpSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpSpringbootApplication.class, args);
	}

	@Bean
	public List<ToolCallback> courseTools(CourseService courseService){
		return List.of(ToolCallbacks.from(courseService));
	}

}
