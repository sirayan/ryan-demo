package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	 @GetMapping("/hello")
	 public String hello(@RequestParam(name="name", required=false, defaultValue="World")String name, Model mod) {
		 mod.addAttribute("name", name);
		 return ("greet");
	 }
	 @GetMapping("/proc")
	 public String name(@RequestParam(name="name", required=false, defaultValue="World")String name, Model mod) {

		 mod.addAttribute("name", name);
		 return ("greet");
	 }
}
