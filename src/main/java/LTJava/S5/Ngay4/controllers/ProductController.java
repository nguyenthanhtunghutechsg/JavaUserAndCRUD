package LTJava.S5.Ngay4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import LTJava.S5.Ngay4.services.ProductServices;
import LTJava.S5.Ngay4.models.product;

@Controller
public class ProductController {
	@Autowired
	private ProductServices services;

	@RequestMapping("/products")
	public String viewHome(Model model) {
		List<product> listProduct = services.listAll();
		model.addAttribute("products", listProduct);
		return "products/index";
	}

	@RequestMapping("/products/new")
	public String showNewProductPage(Model model) {
		product product = new product();
		model.addAttribute("product", product);

		return "products/new_product";
	}

	@RequestMapping(value = "/products/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") product i_product) {
		services.save(i_product);

		return "redirect:/products";
	}
	@RequestMapping("/products/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_product");
	    product i_product = services.get(id);
	    mav.addObject("product", i_product);
	     
	    return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    services.delete(id);
	    return "redirect:/products";       
	}
}
