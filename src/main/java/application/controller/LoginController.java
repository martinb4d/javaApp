package application.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import application.exceptions.BusinessException;
import application.model.Item;
import application.model.Purchase;
import application.model.User;
import application.service.ItemService;
import application.service.PurchaseService;
import application.service.UserService;
import application.vo.ItemModel;

@Controller
public class LoginController {
	private static final String listing = "listing";
	private static final String confirm = "confirm";
	private static final String groceries = "groceries";

	@Autowired
	private UserService userService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private PurchaseService purchaseService;

	@RequestMapping("/login")
	public String login(LoginActionForm actionForm, HttpServletRequest request) {
		return "login";
	}

	@RequestMapping("/history")
	public String showHistory(LoginActionForm actionForm, HttpServletRequest request, Model model) {
		model.addAttribute("actionForm", actionForm);
		actionForm.setPurchaseList(purchaseService.getAllItem());
		return "history";
	}

	@RequestMapping("/logout")
	public String logout(LoginActionForm actionForm, HttpServletRequest request) {
		request.getSession().invalidate();
		return "login";
	}

	@RequestMapping("/performLogin")
	public String perFormLogin(LoginActionForm actionForm, HttpServletRequest request, Model model) {
		model.addAttribute("actionForm", actionForm);
		actionForm.setScreenState(listing);
		try{
			User user = userService.getUserByUsernameAndPassword(actionForm.getUsername(), actionForm.getPassword());
			request.getSession().setAttribute("user", user);
			if(user != null){
				setFormValues(actionForm, user);
				return "item_list";
			}
		}
		catch (BusinessException e){
			actionForm.setMessage(e.getMessage());
		}catch (Exception e){
			actionForm.setMessage("Please login first");
		}
		return "login";
	}
	
	private void setFormValues(LoginActionForm actionForm, User user){
		actionForm.setDiscount(getDiscount(user));
		actionForm.setName(user.getName());
		actionForm.setRegisteredDate(user.getCreatedDate());
	}

@RequestMapping("/backItem")
	public String backItem(LoginActionForm actionForm, HttpServletRequest request, Model model) {
		model.addAttribute("actionForm", actionForm);
		actionForm.setScreenState(listing);
		User user = (User)request.getSession().getAttribute("user");
		if(user != null){
			actionForm.setName(user.getName());
			actionForm.setRegisteredDate(user.getCreatedDate());
			return "item_list";
		}else{
			actionForm.setMessage("Please login first");
			return "login";
		}
	}

	@RequestMapping("/confirm")
	public String confirm(LoginActionForm actionForm, HttpServletRequest request, Model model) {
		model.addAttribute("actionForm", actionForm);
		actionForm.setScreenState(confirm);
		List allItem = itemService.getAllItemModel();
		List itemList = new ArrayList();
		try{
			User user = (User) request.getSession().getAttribute("user");
			setFormValues(actionForm, user);
			BigDecimal total = BigDecimal.ZERO;
			for(int i=0;i<allItem.size();i++){
				if(actionForm.getQuantity()[i]>0){ 
					ItemModel item = (ItemModel) allItem.get(i);
					item.setQty(actionForm.getQuantity()[i]);
					BigDecimal amount = calculateAmount(actionForm.getDiscount(), item, actionForm.getQuantity()[i]);
					item.setTtlPrice(amount);
					total=total.add(amount);
					itemList.add(item);
				}

			}
			actionForm.setItemList(itemList);
			actionForm.setTotal(total);
		}
		catch (BusinessException e){
			actionForm.setMessage(e.getMessage());
		}catch (Exception e){
			throw e;
		}
		return "item_list";
	}

	@RequestMapping("/submit")
	public String submit(LoginActionForm actionForm, HttpServletRequest request, Model model) {
		model.addAttribute("actionForm", actionForm);
		actionForm.setScreenState(listing);
		try{
			User user = (User) request.getSession().getAttribute("user");
			setFormValues(actionForm, user);
			for(int i=0;i<actionForm.getItemSelected().length;i++){
				if(actionForm.getQuantity()[i]>0){
					Purchase purchase = new Purchase();
					purchase.setUser(user);
					Item item = new Item();
					item.setId(actionForm.getItemSelected()[i]);
					purchase.setItem(item);
					purchase.setAmount(calculateAmount(actionForm.getDiscount(), itemService.getItemById(actionForm.getItemSelected()[i]), actionForm.getQuantity()[i]));
					purchase.setQuantity(actionForm.getQuantity()[i]);
					purchase.setCreatedDate(new Timestamp(System.currentTimeMillis()));
					purchaseService.save(purchase);
				}
			}
			actionForm.setMessage("Item purchase completed.");
		}
		catch (BusinessException e){
			actionForm.setMessage(e.getMessage());
		}catch (Exception e){
			throw e;
		}
		return "item_list";
	}

	private BigDecimal calculateAmount(float discount, Object item, int quantity){
		BigDecimal amount = BigDecimal.ZERO;
		BigDecimal price = BigDecimal.ZERO;
		String name = "";
		String category = "";
		if(quantity<=0){
			return amount;
		}
		
		if(item instanceof Item){
			price=((Item) item).getPrice();
			name=((Item) item).getName();
			category=((Item) item).getCategory();
		}else if(item instanceof ItemModel){
			price=((ItemModel) item).getPrice();
			category=((ItemModel) item).getCategory();
		}

		amount = price.multiply(new BigDecimal(quantity));
		if(!groceries.equalsIgnoreCase(category)){
			amount = amount.subtract(amount.multiply(new BigDecimal(discount)).divide(new BigDecimal(100)));
		}
		amount = applyPromo(amount);
		return amount;
	}

	private BigDecimal applyPromo(BigDecimal amount){
		int multiplier = amount.divide(new BigDecimal(100)).intValue();
		amount = amount.subtract(new BigDecimal(multiplier).multiply(new BigDecimal(5)));
		return amount;
	}

	private float getDiscount(User user){
		if(user.getRole().getId().equals("customer")){
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			timestamp.setYear(timestamp.getYear()-2);
			if(user.getCreatedDate().compareTo(timestamp)<=0){
				return user.getRole().getDiscount();
			}
		}else{
			return user.getRole().getDiscount();
		}
		return 0;
	}
}
