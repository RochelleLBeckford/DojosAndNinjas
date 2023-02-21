package com.rochelle.dojos_ninjas_demo.controllers;
//? Pair Programming -> Dominic Basa

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rochelle.dojos_ninjas_demo.models.Dojo;
import com.rochelle.dojos_ninjas_demo.models.Ninja;
import com.rochelle.dojos_ninjas_demo.services.DojoService;
import com.rochelle.dojos_ninjas_demo.services.NinjaService;

// creating a one to many relationship
// designate this as a controller
@Controller
public class MainController {

    @Autowired DojoService dojoService;
    // ^ CREATE & READ ALL ^
    // create my route
    // use request mapping incase want to have multiple routes 
    // Can list as all these routes and it will render this function
    @RequestMapping(value = {"/dojos/new", "/"})
    // now function 
    // -> find my data to Dojo
    public String newDojo(@ModelAttribute("dojo")Dojo dojo) {
        // doing it like this because going to want to start keeping track of things in seperate folders as our app becomes more complex
        return "dojos/new.jsp";
    }
    // not to set up my dojo and ninja models

    /* 
    putting stuff on my DB -> need atleast 2 routes
    -> one to display the form and one to handle the form 
    
    ModelAttribute allows us to pass model back and forth
    -> from controller to view 
    -> from view back to controller
    */
    @PostMapping("/dojos")
    public String createDojo(@ModelAttribute("dojo")Dojo dojo) {
        // -> pass in dojo got from the DB
        dojoService.createDojo(dojo);
        return "redirect:/";
    }
    
    // ~ Ninjas
    @RequestMapping("/ninjas/new")
    public String newDojo(@ModelAttribute("ninja")Ninja ninja, Model model) {
        List<Dojo> dojos = dojoService.getAllDojos();
        model.addAttribute("dojos", dojos);
        return "ninjas/new.jsp";
    }


    @PostMapping("/createninja")
    public String ninjas(@Valid @ModelAttribute("ninja")Ninja ninja,BindingResult result) {
        if(result.hasErrors()) {
            return "ninjas/new.jsp";
        }else {
            ninjaService.createNinja(ninja);
            return "redirect:/show/" + ninja.getDojo().getId();
        }
    }

    // ^ READ ONE ^
    /* 
    -> when do this show.jsp should have access to one expense at the specified index
    -> have one expense object that is being passed down to jsp
    attributes can be individual strings, they can be expenses, they can be whatever you want to pass down
    -> want to click on one of these titles and have it take me to a show page
    -> can use request mapping or get mapping 
    */
    @GetMapping("/dojos/{dojo_id}")
    // -> now just need to call the method created in service to read one 
    // get variables that live in the url -> Path Variable
    public String show(@PathVariable("dojo_id")Long id, Model model) {
        // need to get my expense to my show page -> link data in my controller to my template -> Model model
        Dojo dojo = dojoService.getOneDojo(id);
        model.addAttribute("dojo", dojo);
        return "dojos/show.jsp";
    }
}
