package com.khoa.af.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.khoa.af.api.admin.Order;
import com.khoa.af.api.admin.OrderDetail;
import com.khoa.af.api.admin.Product;
import com.khoa.af.service.OrderService;
import com.khoa.af.service.ProductService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductService productService;

	@GetMapping("/admin/order")
	public String showOrder(Model model) {

		List<Order> orderList = orderService.loadOrder();

		model.addAttribute(orderList);

		return "admin/order-list";
	}

	@GetMapping("/admin/addOrder")
	public String addOrder(Model model) {

		Order order = new Order();
		
		model.addAttribute(order);

		return "admin/add-order";
	}

	@PostMapping("/admin/save-order")
	public String saveOrder(Order order) {

		if (order.getId() == 0) {

			orderService.saveOrder(order);

		}else {
			
			orderService.updateOrder(order);
			
		}

		return "redirect:/admin/order";
	}

	@GetMapping("/admin/updateOrder")
	public String updateOrder(@RequestParam("orderId") int id, Model model) {

		Order order = orderService.getOrder(id);

		model.addAttribute(order);

		return "admin/add-order";

	}
	
	@ResponseBody
	@PostMapping("/admin/deleteOrder")
	public String deleteOrder(@RequestParam("orderId") int id) {
		
		boolean result = orderService.deleteOrder(id);
		
		return String.valueOf(result);
	}
	
	
	@GetMapping("/admin/orderDetails")
	public String showOrderDetails(@RequestParam("orderId") int id, Model model) {
		
		Order order = orderService.getOrder(id);
		
			List<OrderDetail> ordersDetails = orderService.loadOrderDetails(id);
			
			double total = orderService.getTotal(ordersDetails);
		
		model.addAttribute("total",total);
		
		model.addAttribute(order);
	
		model.addAttribute("ordersDetails", ordersDetails);
		
		return "admin/order-details";
		
	}
	
	@GetMapping("/admin/addOrderDetails")
	public String addOrderDetail(@RequestParam("orderId") int id, Model model) {
		
		OrderDetail orderDetail = new OrderDetail();
		// set the initial quantity to 1 as it's weird to order 0 product
		orderDetail.setQuantity(1);
		
		Order order = orderService.getOrder(id);
		
		orderDetail.setOrder(order);
		
		List<Product> productList = productService.loadProduct();
		
		
		model.addAttribute("orderDetail",orderDetail);
		
		model.addAttribute("productList", productList);
		
		return "admin/add-order-detail";
		
	}
	
	@PostMapping("/admin/save-orderDetail")
	public String saveOrderDetail(RedirectAttributes redirectAttributes, OrderDetail orderDetail) {
		
		int orderId = orderDetail.getOrder().getId();
		
		redirectAttributes.addAttribute("orderId", orderId);
		
		orderService.addOrderDetail(orderDetail);
		
		return "redirect:/admin/orderDetails";
		
	}
	
	
}
