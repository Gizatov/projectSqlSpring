package org.example.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.example.spring.dao.CountryDAO;
import org.example.spring.models.Country;

import java.util.List;

@Controller
@RequestMapping("/countries")
public class CountryController {
    private final CountryDAO countryDAO;

    @Autowired
    public CountryController(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    @GetMapping
    public String listCountries(Model model) {
        List<Country> countries = countryDAO.findAll();
        model.addAttribute("countries", countries);
        return "countries/list";
    }

    @GetMapping("/{id}")
    public String showCountry(@PathVariable("id") int countryId, Model model) {
        Country country = countryDAO.findById(countryId);
        model.addAttribute("country", country);
        if (country == null) {
            return "redirect:/countries";
        }
        return "countries/show";
    }

    @GetMapping("/add")
    public String showAddCountryForm(Model model) {
        model.addAttribute("country", new Country());
        return "countries/add";
    }

    @PostMapping("/add")
    public String addCountry(@ModelAttribute("country") Country country) {
        countryDAO.save(country);
        return "redirect:/countries";
    }

    @GetMapping("/{id}/edit")
    public String showEditCountryForm(@PathVariable("id") int id, Model model) {
        Country country = countryDAO.findById(id);
        model.addAttribute("country",country);
        if (country == null) {
            return "redirect:/countries";
        }
        model.addAttribute("country", country);
        return "countries/edit";
    }

    @PostMapping("/{id}/edit")
    public String editCountry(@ModelAttribute("country") Country country) {
        countryDAO.update(country);
        return "redirect:/countries";
    }

    @GetMapping("/{id}/delete")
    public String deleteCountry(@PathVariable("id") int id) {
        countryDAO.delete(id);
        return "redirect:/countries";
    }
}
