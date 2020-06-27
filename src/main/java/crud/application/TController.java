package crud.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //marks the class as web controller, capable of handling the requests.
public class TController {

    @Autowired //marks a constructor, field, or setter method to be autowired by Spring dependency injection.
    private TutorialsService service;

    @RequestMapping("/") //this annotation maps HTTP requests to handler methods
    //provide a view with usable data, we simply add this data to its Model object
    public String index(Model model, @Param("keyword") String keyword)  {
        List<Tutorials> listTutorials = service.listAll(keyword);
        model.addAttribute("listTutorials", listTutorials);
        model.addAttribute("keyword", keyword);

        return "index";
    }

    @RequestMapping("/add_tutorial")
    public String add(Model model) {
        Tutorials tutorial = new Tutorials();
        model.addAttribute("tutorial", tutorial);
        //"tutorial" is a name which you can use it in your view get the value with ${products}

        return "add_tutorial";
    }
    //@ModelAttribute annotation that binds a method parameter or method return value
    // to a named model attribute and then exposes it to a web view.
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("tutorial") Tutorials tutorial) {
        service.save(tutorial);

        return "redirect:/";
    }

    //@PathVariable annotation which indicates that a method parameter should be bound to a URI template variable.
    @RequestMapping("/edit/{id}")
    public ModelAndView Edit(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_tutorial");
        Tutorials tutorial = service.get(id);
        mav.addObject("tutorial", tutorial);

        return mav;
    }

    @RequestMapping("/view/{id}")
    public ModelAndView View(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("view");
        Tutorials tutorial = service.get(id);
        mav.addObject("tutorial", tutorial);

        return mav;
    }


    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}

