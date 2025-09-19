package kz.narxoz.alan.controller;

import kz.narxoz.alan.DTO.ProductDTO;
import kz.narxoz.alan.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class MainController {
    private ProductRepository productRepository;
    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

    @PostMapping
    public String create(@RequestBody ProductDTO productDTO) {
        productRepository.save(productDTO);
        return "redirect:/";
    }

    @DeleteMapping
    public boolean delete(@RequestParam("id") Long id) {
        return productRepository.delete(id);
    }

    @PutMapping
    public ProductDTO update(@RequestBody ProductDTO productDTO) {
        return productRepository.update(productDTO);
    }

}
