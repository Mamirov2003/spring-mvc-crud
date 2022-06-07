package uz.pdp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.entity.Groups;
import uz.pdp.repository.GroupsResponsitory;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/groups")
public class GroupsController {

    @Autowired
    GroupsResponsitory groupsRepository;

    @GetMapping("/all")
    public ModelAndView getAll(ModelAndView mv) {

        List<Groups> groupsList = groupsRepository.read();
        mv.addObject("listGroups", groupsList);
        mv.setViewName("readGroups");
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView getAddPage(ModelAndView mv) {
        mv.setViewName("createGroups");
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView saveGroups(@ModelAttribute("groups") Groups groups, ModelAndView mv) {
        int num = groupsRepository.create(groups);

        if (num == 0) {
            mv.addObject("ketmon", "Groups qo'shishda xatolik");
        } else {
            mv.addObject("ketmon", "Groups added!");
        }

        mv.setViewName("createGroups"); //create.jsp ni   web papkadam qidiradi
        return mv;
    }

    @GetMapping("/update/{id}")
    public ModelAndView getUpdatePage(@PathVariable Integer id, ModelAndView mv) {
        Groups groupsById = groupsRepository.findGroupsById(id);
        List<Groups> groupsList = new ArrayList<>(List.of(groupsById));
        mv.addObject("ketmon", groupsList);
        mv.setViewName("update");
        return mv;
    }

    //    @PutMapping("/update/{id}") aslida http request bo'lsa
    @PostMapping("/update")
    public ModelAndView updateGroups(@ModelAttribute Groups groups, ModelAndView mv) {

        int counter = groupsRepository.update(groups);

        if (counter > 0) {
            mv.addObject("msg", "Groups records updated against groups id: " + groups.getId());
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }

        mv.setViewName("update");

        return mv;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteGroups(@PathVariable Integer id, ModelAndView mv) {

        int counter = groupsRepository.delete(id);

        if (counter > 0) {
            mv.addObject("msg", "Groups records deleted against groups id: " + id);
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }

        mv.setViewName("delete");

        return mv;
    }

}
