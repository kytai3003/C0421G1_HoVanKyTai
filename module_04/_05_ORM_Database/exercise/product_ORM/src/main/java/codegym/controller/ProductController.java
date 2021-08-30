package codegym.controller;

import codegym.model.bean.Product;
import codegym.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String createProduct(Product product, RedirectAttributes attributes) {
//        product.setProductId(productService.findById(productService.findAll().size()).getProductId() + 1);
        productService.save(product);
        attributes.addFlashAttribute("success", "Product <" + product.getProductName() + "> have been created.");
        return "redirect:/product/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateProduct(Product product, RedirectAttributes attributes) {
        productService.update(product);
        attributes.addFlashAttribute("success", "Product <" + product.getProductName() + "> have been updated.");
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        redirect.addFlashAttribute("success", "Product Id <" + product.getProductId() +  "> have been deleted.");
        productService.remove(product.getProductId());
        return "redirect:/product/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchByName(@RequestParam("productName") String productName, Model model) {
        List<Product> products = productService.searchByName(productName);
        model.addAttribute("products", products);
        model.addAttribute("resultMessage", "Found " + products.size() + " record(s)");

        return "search";
    }
}
