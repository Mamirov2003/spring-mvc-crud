package uz.pdp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.entity.Classe;
import uz.pdp.repository.ClasseResponsitory;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/classe")
public class ClasseController {

    @Autowired
    ClasseResponsitory classeRepository;

    @GetMapping("/all")
    public ModelAndView getAll(ModelAndView mv) {

        List<Classe> classeList = classeRepository.read();
        mv.addObject("listClasse", classeList);
        mv.setViewName("readClasse");
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView getAddPage(ModelAndView mv) {
        mv.setViewName("createClasse");
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView saveClasse(@ModelAttribute("classe") Classe classe, ModelAndView mv) {
        int num = classeRepository.create(classe);

        if (num == 0) {
            mv.addObject("ketmon", "Classe qo'shishda xatolik");
        } else {
            mv.addObject("ketmon", "Classe added!");
        }

        mv.setViewName("createClasse"); //create.jsp ni   web papkadam qidiradi
        return mv;
    }

    @GetMapping("/update/{id}")
    public ModelAndView getUpdatePage(@PathVariable Integer id, ModelAndView mv) {
        Classe classeById = classeRepository.findClasseById(id);
        List<Classe> classeList = new ArrayList<>(List.of(classeById));
        mv.addObject("ketmon", classeList);
        mv.setViewName("update");
        return mv;
    }

    //    @PutMapping("/update/{id}") aslida http request bo'lsa
    @PostMapping("/update")
    public ModelAndView updateClasse(@ModelAttribute Classe classe, ModelAndView mv) {

        int counter = classeRepository.update(classe);

        if (counter > 0) {
            mv.addObject("msg", "Classe records updated against classe id: " + classe.getId());
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }

        mv.setViewName("update");

        return mv;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteClasse(@PathVariable Integer id, ModelAndView mv) {

        int counter = classeRepository.delete(id);

        if (counter > 0) {
            mv.addObject("msg", "Classe records deleted against classe id: " + id);
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }

        mv.setViewName("delete");

        return mv;
    }

}
