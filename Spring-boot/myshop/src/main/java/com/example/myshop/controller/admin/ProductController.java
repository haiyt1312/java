package com.example.myshop.controller.admin;

import com.example.myshop.domain.Product;
import com.example.myshop.model.ProductDTO;
import com.example.myshop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("add")
    public String add(Model model){
        model.addAttribute("product", new ProductDTO());
        return "/admin/products/saveOrUpdate";
    }

    @GetMapping("edit/{productId}")
    public ModelAndView edit(ModelMap model, @PathVariable("productId") Integer productId){
        Optional<Product> opt = productService.findById(productId);
        ProductDTO dto = new ProductDTO();

        if (opt.isPresent()){
            Product entity = opt.get();
            BeanUtils.copyProperties(entity,dto);
            dto.setIsEdit(true);
            model.addAttribute("product",dto);
            return new ModelAndView("/admin/products/saveOrUpdate", model) ;
        }
        model.addAttribute("message", "Product is not existed");
        return new ModelAndView("forward:/admin/products", model) ;
    }

    @GetMapping("delete/{productId}")
    public ModelAndView delete(@PathVariable("productId") Integer categoryId, ModelMap model){
        productService.deleteById(categoryId);
        model.addAttribute("message", "Product is delete!");

        return new ModelAndView("forward:/admin/products/search",model);
    }

    @PostMapping ("saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("product") ProductDTO dto, BindingResult result){
        if (result.hasErrors()){
            return new ModelAndView("admin/products/saveOrUpdate");
        }
        Product entity = new Product();
        BeanUtils.copyProperties(dto,entity);

        productService.save(entity);
        model.addAttribute("message","Product is save!");
        return new ModelAndView("forward:/admin/products", model);
    }

    @RequestMapping("")
    public String list(ModelMap model){
        List<Product> list = productService.findAll();
        model.addAttribute("products",list);
        return "admin/products/product-list";
    }

    @GetMapping("search")
    public String search(ModelMap model, @RequestParam(name = "name", required = false) String name){
        List<Product> list = null;
        if (StringUtils.hasText(name)){
            list = productService.findByName(name);
        }else {
            list = productService.findAll();
        }
        model.addAttribute("products", list);
        return "admin/products/search";
    }

}
