package org.example.spring.controllers;

import org.example.spring.dao.CityDAO;
import org.example.spring.dao.StateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.example.spring.models.City;
import org.example.spring.models.CityByRegion;
import org.example.spring.models.CityInfo;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityController {

    private final CityDAO cityDAO;
    private final StateDAO stateDAO;

    @Autowired
    public CityController(CityDAO cityDAO, StateDAO stateDAO) {
        this.cityDAO = cityDAO;
        this.stateDAO = stateDAO;
    }

    @GetMapping("")
    public String listCities(@RequestParam(name = "search", required = false) String searchQuery, Model model) {
        List<City> cities;
        if (searchQuery != null && !searchQuery.isEmpty()) {
            cities = cityDAO.findByNameContainingIgnoreCase(searchQuery);
            model.addAttribute("searchQuery", searchQuery);
        } else {
            cities = cityDAO.getAllCities();
        }
        model.addAttribute("cities", cities);
        model.addAttribute("countOfPopulation", cityDAO.countOfPopulation());
        return "cities/listOfCities";
    }

    @GetMapping("/citiesWithInfo")
    public String showAllCitiesWithInfo(Model model) {
        List<CityInfo> cityInfos = cityDAO.getAllCitiesInfo();
        model.addAttribute("cities", cityInfos);
        return "cities/list";

        //http://localhost:8080/cities/citiesWithInfo
    }

    @GetMapping("/citiesByRegion")
    public String getCitiesByRegion(@RequestParam("region") String regionName, Model model) {
        List<CityByRegion> cities = cityDAO.getCitiesByRegion(regionName);
        model.addAttribute("cities", cities);
        return "cities/citiesByRegion";

        //http://localhost:8080/cities/citiesByRegion?region=West%20Coast
    }

    @GetMapping("/{id}")
    public String showCity(@PathVariable int id, Model model) {
        City city = cityDAO.getCityById(id);
        if (city == null) {
            return "redirect:/cities";
        }
        model.addAttribute("city", city);
        return "cities/show";

        //http://localhost:8080/cities/2
    }

    @GetMapping("/add")
    public String addCityForm(Model model) {
        model.addAttribute("states",stateDAO.findAll());
        model.addAttribute("city", new City());
        return "cities/add";

        //http://localhost:8080/cities/add
    }

    @PostMapping
    public String addCity(@ModelAttribute("city") @Validated City city, BindingResult result) {
        if (result.hasErrors()) {
            return "cities/add";
        }
        cityDAO.addCity(city);
        return "redirect:/cities";
    }

    @DeleteMapping("/{id}")
    public String deleteCity(@PathVariable int id) {
        cityDAO.deleteCity(id);
        return "redirect:/cities";
    }
}
