package com.example.corso.flow.controller;

import com.example.corso.flow.viewmodel.HelloWorldViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// tutti i Controller vanno annotati con
@Controller
// l'interfaccia di comunicazione non è specificata da un'interface Java ma da una annotation
// questa annotation vuole un valore String: la path a cui risponde questo controller
@RequestMapping("/hello-world")
public class HelloWorldController {
    // il metodo che risponde alla richiesta http GET si chiama di solito getPage
    // ed è public e restituisce String
    // NOTA: get non è per identificare un getter, ma per identificare un metodo che
    //       risponde alla richiesta http GET
    // Non è sufficiente: devo specificare una annotation che dice qual è la chiamata
    //       http a cui rispondo (GET o POST)
    @GetMapping
    public String getPage(Model model) {
        // i dati da inserire nel ViewBean li inserisco instanziando il ViewBean
        // e invocando i setter
        // La variabile posso chiamarla viewModel
        HelloWorldViewModel viewModel = new HelloWorldViewModel();
        viewModel.setTitle("Mondo Ciao");
        viewModel.setGreet("Mondo Ciao!");
        // per passare il viewModel dal controller alla JSP si scrive così:
        // chiamo il JavaBean "viewModel" perché così uso lo stesso nome che ho usato
        // per la variabile nel Controller
        model.addAttribute("viewModel", viewModel);
        // le view in Spring Web MVC sono rappresentate da String (nomi)
        // se voglio restituire la vista principale uso il nome hello-world
        return "hello-world";
    }
}
