package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello"; // return값으로 문자를 반환하면 -> resources/templates 경로에 이름과 일치하는 화면을 찾아서 처리함

    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) { // param으로 name을 반드시 넣어야함
        model.addAttribute("name", name);
        return "hello-template"; // return값으로 문자를 반환하면 -> resources/templates 경로에 이름과 일치하는 화면을 찾아서 처리함

    }

    @GetMapping("hello-string")
    @ResponseBody // viewResolver 사용하지 않고 httpMessageConverter 동작
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // http의 body 부분에 내용을 실어서 문자를 반환

    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // http의 body 부분에 내용을 실어서 객체를 반환 -> json으로 변환

    }
    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
