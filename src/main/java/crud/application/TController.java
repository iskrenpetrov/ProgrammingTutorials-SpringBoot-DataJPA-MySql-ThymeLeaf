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

@Controller
public class TController {

    @Autowired
    private TutorialsService service;

    @RequestMapping("/")
    public String index(Model model, @Param("keyword") String keyword) {
        List<Tutorials> listTutorials = service.listAll(keyword);
        model.addAttribute("listTutorials", listTutorials);
        model.addAttribute("keyword", keyword);

        return "index";
    }

//    @RequestMapping("/")
//    public String index(Model model, @Param("keyword") String keyword) {
////        List<Tutorials> listTutorials = service.listAll(keyword);
////        model.addAttribute("listTutorials", listTutorials);
////        model.addAttribute("keyword", keyword);
//
//        return Page(model,keyword,1);
//        //return "index";
//    }
//
//    @RequestMapping("/index/{pageNum}")
//    public String Page(Model model,@Param("keyword") String keyword,
//                           @PathVariable(name = "pageNum") int pageNum) {
//
//        Page<Tutorials> page = service.listAll(keyword,pageNum);
//
//        List<Tutorials> listTutorials = page.getContent();
//        model.addAttribute("currentPage", pageNum);
//        model.addAttribute("totalPages", page.getTotalPages());
//        model.addAttribute("totalItems", page.getTotalElements());
//
//
//
//        model.addAttribute("listTutorials", listTutorials);
//        model.addAttribute("keyword", keyword);
//
//        return "index";
//    }


    @RequestMapping("/add_tutorial")
    public String add(Model model) {
        Tutorials tutorial = new Tutorials();
        model.addAttribute("tutorial", tutorial);

        return "add_tutorial";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("tutorial") Tutorials tutorial) {
        service.save(tutorial);

        return "redirect:/";
    }

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

