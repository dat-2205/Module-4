package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    private static ICustomerService customerService = new CustomerService();

    @GetMapping("")
    public String home(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers",customers);
        return "index";
    }

    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable int id) {
        Customer customer = customerService.find(id);
        model.addAttribute("customer",customer);
        return "view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes model) {
        boolean isDelete = customerService.remove(id);
        if(isDelete) {
            model.addFlashAttribute("message"," Delete user !");
        }else {
            model.addFlashAttribute("message","Not found user !");
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model model) {
        model.addAttribute("customer", customerService.find(id));
        return "edit";
    }

    @PostMapping("edit/{id}")
    public String editCustomer(@PathVariable int id, Customer customer) {
        customerService.update(id,customer);
        return "redirect:/";
    }

    @GetMapping("/create/")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create/")
    public String createCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Have A New Customer");
        int id = customerService.findAll().size() + 1;
        customer.setId(id);
        customerService.save(customer);
        return "redirect:/";
    }
}
