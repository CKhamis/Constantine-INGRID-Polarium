package com.constantine.polarium.web.controller;

import com.constantine.polarium.model.DoubleText;
import com.constantine.polarium.model.Person;
import com.constantine.polarium.model.cScore;
import com.constantine.polarium.service.PersonService;
import com.constantine.polarium.web.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
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

  @RequestMapping("RankStar/Members")
  public String displayMembers(Model model){
    List<Person> roster = personService.findAll();
    model.addAttribute("members", roster);
    return "rankStar/members";
  }

  //Adding New Members
  @RequestMapping("RankStar/Members/Add")
  public String formNewMember(Model model) {
    if(!model.containsAttribute("person")) {
      model.addAttribute("person",new Person());
    }
    model.addAttribute("action","/RankStar/Members");
    model.addAttribute("submit","Add");
    return "RankStar/addNewMember";
  }


  @PostMapping("RankStar/Members")
  public RedirectView saveMember(Person member, @RequestParam("image") MultipartFile file, BindingResult result, RedirectAttributes redirectAttributes) throws IOException {
    if(result.hasErrors()) {
      // Include validation errors upon redirect
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.person",result);

      // Add  person if invalid was received
      redirectAttributes.addFlashAttribute("person",member);
    }
    personService.saveOverview(member, file);
    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Success", "Person successfully updated", FlashMessage.Status.SUCCESS));
    return new RedirectView("/RankStar/Members", true);
  }

  //Editing Members
  @RequestMapping("RankStar/Members/{memberId}")
  public String formEditMember(@PathVariable Long memberId, Model model){
    Person member = personService.findById(memberId);
    model.addAttribute("member", member);
    model.addAttribute("generalAction","/RankStar/Members/" + memberId + "/EditGeneral");
    List<Person> allMembers = personService.findAll();
    model.addAttribute("members", allMembers);

    model.addAttribute("timeline", member.getTimeline());
    model.addAttribute("score", new cScore());
    model.addAttribute("timelineAction","/RankStar/Members/" + memberId + "/EditScore");

    model.addAttribute("contactList", member.getSocialMedia());
    model.addAttribute("contact", new DoubleText());
    model.addAttribute("contactAction","/RankStar/Members/" + memberId + "/EditContact");

    return "rankStar/memberEditor";
  }


  @PostMapping("RankStar/Members/{personId}/EditGeneral")
  public String updateMember(@Valid Person member, BindingResult result, RedirectAttributes redirectAttributes, @RequestParam MultipartFile image) throws IOException {
    if(result.hasErrors()) {
      // Include validation errors upon redirect
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.Person",result);
      // Add  member if invalid was received
      redirectAttributes.addFlashAttribute("member",member);
    }

    personService.saveOverview(member, image);
    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Success", "General info successfully updated", FlashMessage.Status.SUCCESS));

    return "redirect:/RankStar/Members/" + member.getId();
  }

  @PostMapping("RankStar/Members/{personId}/EditScore")
  public String cScorePost(@PathVariable Long personId, @Valid cScore cScore, BindingResult result, RedirectAttributes redirectAttributes){
    if(result.hasErrors()) {
      // Include validation errors upon redirect
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.Person",result);
      // Add  member if invalid was received
      //redirectAttributes.addFlashAttribute("member",member);
    }
    Person member = personService.findById(personId);
    member.getTimeline().add(cScore);

    //TODO: Investigate if this deletes the profile image after saving
    personService.saveOverview(member);
    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Success", "cScore Updated", FlashMessage.Status.SUCCESS));

    return "redirect:/RankStar/Members/" + personId;
  }

  @PostMapping("RankStar/Members/{personId}/EditContact")
  public String cScorePost(@PathVariable Long personId, @Valid DoubleText contact, BindingResult result, RedirectAttributes redirectAttributes){
    if(result.hasErrors()) {
      // Include validation errors upon redirect
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.Person",result);
      // Add  member if invalid was received
      //redirectAttributes.addFlashAttribute("member",member);
    }
    Person member = personService.findById(personId);
    member.getSocialMedia().add(contact);

    //TODO: Investigate if this deletes the profile image after saving
    personService.saveOverview(member);
    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Success", "contact Updated", FlashMessage.Status.SUCCESS));

    return "redirect:/RankStar/Members/" + personId;
  }
}