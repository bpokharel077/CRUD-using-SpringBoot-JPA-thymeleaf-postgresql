package info.product.productmanagement.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import info.product.productmanagement.model.ProductModel;
import info.product.productmanagement.service.ProductService;

@Controller
public class ProductController {
	//display list of customers
		@Autowired
		private ProductService productService;
		@GetMapping("/product")
		public String viewHomePage(Model model)
		{
			model.addAttribute("listProduct", productService.getAllProduct());
			return "productindex";
		}
		@GetMapping("/addNewProduct")
		public String addProduct(Model model)
		{
			ProductModel product =new ProductModel();
			model.addAttribute("product", product);
			return "addProduct";
		}
		@PostMapping("/saveProduct")
		public String saveProduct(@ModelAttribute("poduct")ProductModel product)
		{
			//save product to database.
			productService.saveProduct(product);
			return "redirect:/product";
		}
		@GetMapping("/updateProduct/{id}")
		public String updateProduct(@PathVariable(value="id")int id,Model model) {
			//get product from service
			ProductModel product= productService.getProductById(id);
			//set product as a model attribute to pre-populate the update form
			model.addAttribute("product", product);
			return "addproduct";
		}
		
		@GetMapping("/deleteProduct/{id}")
		public String deleteProduct(@PathVariable(value="id")int id) {
			this.productService.deleteCustomerById(id);
			return "redirect:/product";
		}
		
		

}
