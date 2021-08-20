package com.constantine.polarium.web.controller;

import com.constantine.polarium.model.DoubleText;
import com.constantine.polarium.model.Gift;
import com.constantine.polarium.model.Person;
import com.constantine.polarium.model.cScore;
import com.constantine.polarium.service.GiftService;
import com.constantine.polarium.service.PersonService;
import com.constantine.polarium.service.cScoreService;
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

  @Autowired
  private cScoreService cScoreService;

  @Autowired
  private GiftService giftService;

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
    model.addAttribute("action","/RankStar/Members/New");
    model.addAttribute("submit","Add");
    return "RankStar/addNewMember";
  }

  @PostMapping("RankStar/Members/New")
  public RedirectView saveMember(Person member, @RequestParam("image") MultipartFile file, BindingResult result, RedirectAttributes redirectAttributes) throws IOException {
    if(result.hasErrors()) {
      // Include validation errors upon redirect
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.person",result);

      // Add  person if invalid was received
      redirectAttributes.addFlashAttribute("person",member);
    }
    personService.saveNew(member, file);
    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Success", "Person successfully added", FlashMessage.Status.SUCCESS));
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

    model.addAttribute("medicalList", member.getDrugsAndFrequency());
    model.addAttribute("drug", new DoubleText());
    model.addAttribute("medicalAction","/RankStar/Members/" + memberId + "/EditMedical");

    model.addAttribute("giftList", member.getGiftList());
    model.addAttribute("gift", new Gift());
    model.addAttribute("giftAction","/RankStar/Members/" + memberId + "/EditGift");

    model.addAttribute("iconAction","/RankStar/Members/" + memberId + "/EditIcon");

    return "rankStar/memberEditor";
  }


  @PostMapping("RankStar/Members/{personId}/EditGeneral")
  public String updateMember(@Valid Person member, BindingResult result, RedirectAttributes redirectAttributes){
    if(result.hasErrors()) {
      // Include validation errors upon redirect
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.Person",result);
      // Add  member if invalid was received
      redirectAttributes.addFlashAttribute("member",member);
    }

    personService.saveOverview(member);
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
    /*Person member = personService.findById(personId);
    cScore.setPerson(member);*/
    cScoreService.save(cScore);
    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Success", "cScore Updated", FlashMessage.Status.SUCCESS));

    return "redirect:/RankStar/Members/" + personId;
  }

  @PostMapping("RankStar/Members/{personId}/EditContact")
  public String contactPost(@PathVariable Long personId, @Valid DoubleText contact, BindingResult result, RedirectAttributes redirectAttributes){
    if(result.hasErrors()) {
      // Include validation errors upon redirect
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.Person",result);
      // Add  member if invalid was received
      //redirectAttributes.addFlashAttribute("member",member);
    }
    Person member = personService.findById(personId);
    member.getSocialMedia().add(contact);

    personService.save(member);
    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Success", "contact Updated", FlashMessage.Status.SUCCESS));

    return "redirect:/RankStar/Members/" + personId;
  }

  @PostMapping("RankStar/Members/{personId}/EditGift")
  public String cScorePost(@PathVariable Long personId, @Valid Gift gift, BindingResult result, RedirectAttributes redirectAttributes){
    if(result.hasErrors()) {
      // Include validation errors upon redirect
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.Person",result);
      // Add  member if invalid was received
      //redirectAttributes.addFlashAttribute("member",member);
    }
    Person member = personService.findById(personId);
    gift.setPerson(member);
    giftService.save(gift);

    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Success", "gift Updated", FlashMessage.Status.SUCCESS));

    return "redirect:/RankStar/Members/" + personId;
  }

  @PostMapping("RankStar/Members/{personId}/EditMedical")
  public String medicalPost(@PathVariable Long personId, @Valid DoubleText drug, BindingResult result, RedirectAttributes redirectAttributes){
    if(result.hasErrors()) {
      // Include validation errors upon redirect
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.Person",result);
      // Add  member if invalid was received
      //redirectAttributes.addFlashAttribute("member",member);
    }
    Person member = personService.findById(personId);
    member.getDrugsAndFrequency().add(drug);

    personService.save(member);
    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Success", "drug Updated", FlashMessage.Status.SUCCESS));

    return "redirect:/RankStar/Members/" + personId;
  }

  @PostMapping("RankStar/Members/{personId}/EditIcon")
  public String iconPost(@Valid Person member, BindingResult result, RedirectAttributes redirectAttributes, @RequestParam MultipartFile image, @PathVariable Long personId) throws IOException {
    personService.saveProfileIcon(image, personId);
    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Success", "General info successfully updated", FlashMessage.Status.SUCCESS));
    return "redirect:/RankStar/Members/" + personId;
  }
}