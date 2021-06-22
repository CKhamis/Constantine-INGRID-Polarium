package com.constantine.polarium.web.controller;

import com.constantine.polarium.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RankStarController {
  @Autowired
  private PersonService personService;

  @RequestMapping("/")
  public String test() {
    //model.addAttribute("gifs", gifs);
    return "rankStar/index";
  }
}
