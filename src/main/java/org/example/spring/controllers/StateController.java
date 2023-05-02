package org.example.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.example.spring.dao.StateDAO;
import org.example.spring.models.State;

import java.util.List;

@Controller
@RequestMapping("/states")
public class StateController {

    private final StateDAO stateDAO;

    @Autowired
    public StateController(StateDAO stateDAO) {
        this.stateDAO = stateDAO;
    }

    @GetMapping()
    public String listStates(Model model) {
        List<State> states = stateDAO.findAll();
        model.addAttribute("states", states);
        return "state/list";
    }

    @GetMapping("/{id}")
    public String getState(@PathVariable("id") int id, Model model) {
        State state = stateDAO.getStateById(id);
        model.addAttribute("state", state);
        return "state/detail";

        //http://localhost:8080/states/3
    }
}
