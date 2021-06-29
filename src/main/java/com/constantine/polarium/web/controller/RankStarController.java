package com.constantine.polarium.web.controller;

import com.constantine.polarium.model.Person;
import com.constantine.polarium.service.PersonService;
import com.constantine.polarium.web.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import javax.validation.Valid;

@Controller
public class RankStarController {
  @Autowired
  private PersonService personService;

  @RequestMapping("/")
  public String test(Model model) {
    model.addAttribute("serverName", "Server: Mirage Oasis 3");
    return "login";
  }

  @RequestMapping(value = "/RankStar/Members", method = RequestMethod.POST)
  public String formNewMember(@Valid Person member, BindingResult result, RedirectAttributes redirectAttributes) {
    if(result.hasErrors()) {
      // Include validation errors upon redirect
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.category",result);

      // Add  category if invalid was received
      redirectAttributes.addFlashAttribute("person",member);

      // Redirect back to the form
      return "redirect:/RankStar/Members/Add";
    }

    personService.save(member);

    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Category successfully added!", FlashMessage.Status.SUCCESS));

    // TODO: Redirect browser to /categories
    return "redirect:/RankStar/Members/" + member.getId();
  }

  @RequestMapping("RankStar/Members/Add")
  public String formNewCategory(Model model) {
    if(!model.containsAttribute("person")) {
      model.addAttribute("person",new Person());
    }
    model.addAttribute("action","/RankStar/Members");
    model.addAttribute("submit","Add");
    return "RankStar/addNewMember";
  }

  @RequestMapping("RankStar/Members")
  public String displayMembers(Model model){
    List<Person> roster = personService.findAll();
    model.addAttribute("members", roster);
    return "rankStar/members";
  }

  @RequestMapping("RankStar/Members/{personId}")
  public String formEditMember(@PathVariable Long personId, Model model){
    Person member = personService.findById(personId);
    model.addAttribute("person", member);
    model.addAttribute("action","/RankStar/Members");
    List<Person> allMembers = personService.findAll();
    model.addAttribute("members", allMembers);

    return "rankStar/memberEditor";
  }
}