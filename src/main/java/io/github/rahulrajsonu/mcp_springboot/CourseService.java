package io.github.rahulrajsonu.mcp_springboot;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private static final Logger log = LoggerFactory.getLogger(CourseService.class);
    private List<Course> courses = new ArrayList<>();

    @Tool(name = "get_courses", description = "Get a list of courses about java, jdk24, llm, langChain")
    public List<Course> getCourses(){
        return courses;
    }

    @Tool(name = "get_course", description = "Get a single course from youtube about java, jdk24, llm, langChain")
    public Course getCourse(String title){
        return courses.stream().filter(c->c.title().equalsIgnoreCase(title)).findFirst().orElse(null);
    }

    @PostConstruct
    public void init(){
        courses.addAll(
                List.of(
                        new Course("Java Full Course 2024 | Java Tutorial for Beginners", "https://www.youtube.com/watch?v=BGTx91t8q50"),
                        new Course("JDK 24 New Features - Virtual Threads, Structured Concurrency", "https://www.youtube.com/watch?v=k3TJqHlfh8Y"),
                        new Course("Java Programming for Beginners – Full Course", "https://www.youtube.com/watch?v=A74TOX803D0"),
                        new Course("Spring Boot Tutorial for Beginners (Java Framework)", "https://www.youtube.com/watch?v=9SGDpanrc8U"),
                        new Course("Spring Boot Project Full Course 2024", "https://www.youtube.com/watch?v=5RA5NpxbioI"),
                        new Course("Spring Boot and Spring Data JPA – Complete Guide", "https://www.youtube.com/watch?v=8SGI_XS5OPw"),
                        new Course("Building RAG Applications with LangChain", "https://www.youtube.com/watch?v=BrsocJb-fAo"),
                        new Course("LLM Course - From Basic to Advanced", "https://www.youtube.com/watch?v=twHxmU9OxDU"),
                        new Course("How to Build a RAG Application Using LangChain", "https://www.youtube.com/watch?v=cUQjMuPsFH8"),
                        new Course("LangChain4j Tutorial - Build Java AI Applications", "https://www.youtube.com/watch?v=KLKPYWHkgP8"),
                        new Course("Introduction to LangChain4j with Spring Boot", "https://www.youtube.com/watch?v=azWfGnDgmdc"),
                        new Course("Building RAG Applications with LangChain4j and Java", "https://www.youtube.com/watch?v=TnWT-CQ72GU")
                )
        );
    }

}
