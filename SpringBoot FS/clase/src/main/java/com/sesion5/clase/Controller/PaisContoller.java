package com.sesion5.clase.Controller;

import com.sesion5.clase.Model.PaisModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PaisContoller {

    private List<PaisModel> paises = new ArrayList<>();

    @GetMapping("/paises")
    public String getPaises(Model model) {
        paises.add(new PaisModel("GT", "Guatemala"));
        paises.add(new PaisModel("MX", "Mexico"));
        paises.add(new PaisModel("ES", "Estados Unidos"));
        model.addAttribute("paises", paises);
        return "paises";
    }

    @GetMapping("/checkboxes")
    public String getCheckBoxes(Model model) {
        model.addAttribute("options", List.of("opcion 1", "opcion 2", "opcion 3"));
        return "checkboxes";
    }

    @PostMapping("/checkboxes")
    public String submitCheckboxes(@RequestParam(name = "selectOptions", required = false) List<String> selectOptions, Model model) {
        // Operar sobre las opciones seleccionadas
        model.addAttribute("selectOptions", selectOptions);
        return "result";
    }

}
