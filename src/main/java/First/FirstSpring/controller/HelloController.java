package First.FirstSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name); // model에 "name"이라는 변수에 name 값을 집어 넣음.
        return "hello-template"; // resoures/templates/hello-template로 transmit
    }

    @GetMapping("hello-string")
    @ResponseBody // 위에서 getmapping에서 view에 template에 있는 view 에 내리는 것과 다르게 직접적으로 화면에 내림.  ex) localhost:8080/hello-string?name=spring  --> hello Spring 으로 나옴
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // "hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    } // json 방식 , key - value로 구성되있음.

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
