package project1.mongo.controller;

import lombok.Getter;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project1.mongo.repository.MyDataMongo;
import project1.mongo.repository.MyDataMongoRepository;

import java.util.List;

@Controller

public class MyController {

    @Autowired
    MyDataMongoRepository myDataMongoRepository;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("title","Find Page");
        model.addAttribute("msg", "MyDataMongo");
        List<MyDataMongo> list = myDataMongoRepository.findAll();
        model.addAttribute("datalist",list);
        return "index";
    }

    @PostMapping("/")
    public String form(@RequestParam String name,
                       @RequestParam String memo){
        MyDataMongo myDataMongo = new MyDataMongo(name, memo);
        myDataMongoRepository.save(myDataMongo);
        return "redirect:/";
    }

    @PostMapping("/find")
    public String find(Model model){
        model.addAttribute("title","Find Page");
        model.addAttribute("msg","MyData 예제");
        List<MyDataMongo> list = myDataMongoRepository.findAll();
        model.addAttribute("datalist",list);
        return "find";
    }
}
