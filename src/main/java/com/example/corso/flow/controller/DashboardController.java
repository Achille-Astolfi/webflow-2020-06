package com.example.corso.flow.controller;

import com.example.corso.flow.service.SampleService;
import com.example.corso.flow.viewmodel.DashboardViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    // mi raccomando due cose:
    // 1) la dipendenza SEMPRE verso l'interface
    // 2) la dipendenza da Controller SEMPRE verso Service
    @Autowired
    private SampleService sampleService;

    @GetMapping
    public String getPage(Model model) {
        // invoco uno dei metodi di sampleService per avere il risultato atteso
        String greet = sampleService.greetName("Achille");
        // cambio di specifica: devo aggiungere la proprietà String greet
        // al mio viewModel

        DashboardViewModel viewModel = new DashboardViewModel();
        viewModel.setUsername("achillu");
        viewModel.setFirstName("Achille");
        // vedi sopra:
        viewModel.setGreet(greet);
        model.addAttribute("viewModel", viewModel);
        return "dashboard";
    }
}
