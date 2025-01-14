package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.ClientReqVO;
import com.project.model.ClientVO;
import com.project.model.LoginVO;
import com.project.model.OrderPlyDetailsVO;
import com.project.model.OrderVO;
import com.project.model.PlyDetailsVO;
import com.project.model.ProgressOrderVO;
import com.project.service.ClientReqService;
import com.project.service.ClientService;
import com.project.service.LoginService;
import com.project.service.OrderService;
import com.project.service.PaperTypeService;
import com.project.utils.BaseMethods;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private ClientReqService clientreqService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private BaseMethods baseMethod;

	@Autowired
	private PaperTypeService paperTypeService;

	@GetMapping(value = { "admin/addOrder", "generalmanager/addOrder", "manager/addOrder" })
	public ModelAndView loadAddOrder(@ModelAttribute OrderVO orderVO, HttpServletRequest request) {

		List<ClientVO> clientList = this.clientService.searchClient();
		List<ClientReqVO> clientreqList = this.clientreqService.searchClientReq();
		String role = request.getServletPath().split("/")[1];
		if (role.equals("admin")) {
			return new ModelAndView("admin/addOrder", "orderVO", new OrderVO()).addObject("clientList", clientList)
					.addObject("clientreqList", clientreqList);
		} else if (role.equals("generalmanager")) {
			return new ModelAndView("generalmanager/addOrder", "orderVO", new OrderVO())
					.addObject("clientList", clientList).addObject("clientreqList", clientreqList);
		} else if (role.equals("manager")) {
			return new ModelAndView("manager/addOrder", "orderVO", new OrderVO()).addObject("clientList", clientList)
					.addObject("clientreqList", clientreqList);
		} else {
			return new ModelAndView("redirect:/index");
		}
	}

	@PostMapping(value = { "admin/insertOrder", "generalmanager/insertOrder", "manager/insertOrder" })
	public ModelAndView insertorder(@ModelAttribute OrderVO orderVO, HttpServletRequest request,
			@RequestParam String height, @RequestParam String width, @RequestParam String length,
			@RequestParam String orderQuantity) {

		String userName = this.baseMethod.getUsername();
		System.out.println("==== >" + userName);
		List<LoginVO> loginVOList = this.loginService.searchByUserName(userName);
		LoginVO loginVO = loginVOList.get(0);

		orderVO.setLoginVO(loginVO);
		orderVO.setProcessStatus("Pending");
		int quantity = Integer.parseInt(orderQuantity);
		orderVO.setTwoPly(2 * quantity);

		this.orderService.insertOrder(orderVO);
		String role = request.getServletPath().split("/")[1];
		if (role.equals("admin")) {
			return new ModelAndView("redirect:/admin/viewOrder");
		} else if (role.equals("generalmanager")) {
			return new ModelAndView("redirect:/generalmanager/viewOrder");
		} else if (role.equals("manager")) {
			return new ModelAndView("redirect:/manager/viewOrder");
		} else {
			return new ModelAndView("redirect:/index");
		}
	}

	@GetMapping(value = "admin/getItemsByClient")
	public ResponseEntity getItemsByClient(@RequestParam int clientId, HttpServletRequest request) {
		List<ClientReqVO> clientreqList = this.clientService.findByClientId(clientId);
		return new ResponseEntity<>(clientreqList, HttpStatus.OK);
	}

	@GetMapping(value = "admin/getItemsDetailsByClientItem")
	public ResponseEntity getItemsDetailsByClientItem(@RequestParam int clientItem, HttpServletRequest request) {
		List<ClientReqVO> clientreqList = this.clientService.getItemsDetailsByClientItem(clientItem);
		return new ResponseEntity<>(clientreqList, HttpStatus.OK);
	}

	@GetMapping(value = { "admin/viewOrder", "generalmanager/viewOrder", "manager/viewOrder" })
	public ModelAndView searchOrder(HttpServletRequest request) {

		List<OrderVO> orderList = this.orderService.searchOrder();
		String role = request.getServletPath().split("/")[1];
		if (role.equals("admin")) {
			return new ModelAndView("admin/viewOrder", "orderList", orderList);
		} else if (role.equals("generalmanager")) {
			return new ModelAndView("generalmanager/viewOrder", "orderList", orderList);
		} else if (role.equals("manager")) {
			return new ModelAndView("manager/viewOrder", "orderList", orderList);
		} else {
			return new ModelAndView("redirect:/index");
		}
	}

	@GetMapping(value = "admin/deleteOrder")
	public ModelAndView deleteOrder(@ModelAttribute OrderVO orderVO, @RequestParam int id) {
		List<OrderVO> orderList = this.orderService.findById(id);
		orderVO = orderList.get(0);
		orderVO.setStatus(false);
		this.orderService.insertOrder(orderVO);
		return new ModelAndView("redirect:/admin/viewOrder");
	}

	@GetMapping(value = { "admin/editOrder", "generalmanager/editOrder", "manager/editOrder" })
	public ModelAndView editOrder(@RequestParam int id, HttpServletRequest request) {

		List<OrderVO> orderList = this.orderService.findById(id);

		OrderVO orderVO = orderList.get(0);

		List<ClientReqVO> clientReqVOList = this.clientreqService.searchClientReq();

		List<ClientVO> clientVOList = this.clientService.searchClient();

		String role = request.getServletPath().split("/")[1];

		if (role.equals("admin")) {

			return new ModelAndView("admin/addOrder", "orderVO", orderVO).addObject("clientList", clientVOList)
					.addObject("clientreqList", clientReqVOList);

		} else if (role.equals("generalmanager")) {

			return new ModelAndView("generalmanager/addOrder", "orderVO", orderVO).addObject("clientList", clientVOList)
					.addObject("clientreqList", clientReqVOList);

		} else if (role.equals("manager")) {

			return new ModelAndView("manager/addOrder", "orderVO", orderVO).addObject("clientList", clientVOList)
					.addObject("clientreqList", clientReqVOList);
		} else {

			return new ModelAndView("redirect:/index");
		}
	}

	@GetMapping(value = { "admin/startOrder", "generalmanager/startOrder", "manager/startOrder" })
	public ModelAndView statusOrder(@RequestParam int id, HttpServletRequest request) {

		List<OrderVO> orderList = this.orderService.findById(id);

		OrderVO orderVO = orderList.get(0);
		
		ProgressOrderVO progressOrderVO = new ProgressOrderVO();
		
		progressOrderVO.setOrderVO(orderVO);
		progressOrderVO.setClientReqVO(orderVO.getClientReqVO());
		progressOrderVO.setClientVO(orderVO.getClientVO());
		progressOrderVO.setProcessStatus("Pending");
		List<PlyDetailsVO> plyDetailsVOList = this.clientreqService.findPlyDetailsByClientReqId(orderVO.getClientReqVO().getClientreqId());
		List<OrderPlyDetailsVO> orderPlyDetailsVOList = new ArrayList<OrderPlyDetailsVO>();
		System.out.println("noice"+plyDetailsVOList);
		for(PlyDetailsVO plydetailsVO : plyDetailsVOList){
			OrderPlyDetailsVO orderPlydetailsVO = new OrderPlyDetailsVO();
			orderPlydetailsVO.setFluteBf(plydetailsVO.getFluteBf());
			orderPlydetailsVO.setFluteGsm(plydetailsVO.getFluteGsm());
			orderPlydetailsVO.setPaperBf(plydetailsVO.getPaperBf());
			orderPlydetailsVO.setPaperGsm(plydetailsVO.getPaperGsm());
			orderPlydetailsVO.setClientReqVO(plydetailsVO.getClientReqVO());
			orderPlydetailsVO.setOrderVO(orderVO);
			
			orderPlyDetailsVOList.add(orderPlydetailsVO);
		}
		System.out.println("---------------->"+orderPlyDetailsVOList);
		

		/*		
		String pending = "Pending";

		String inprocess = "In Process";

		String onhold = "On Hold";

		String resume = "Resume";

		if (pending.equals(orderVO.getProcessStatus())) {
			orderVO.setProcessStatus("In Process");
		} else if ((inprocess.equals(orderVO.getProcessStatus())) || ((resume.equals(orderVO.getProcessStatus())))) {
			orderVO.setProcessStatus("On Hold");
		} else if ((onhold.equals(orderVO.getProcessStatus()))) {
			orderVO.setProcessStatus("Resume");
		}
*/
		String role = request.getServletPath().split("/")[1];

		if (role.equals("admin")) {

			return new ModelAndView("admin/verifyOrderDetails", "progressOrderVO", progressOrderVO)
					.addObject("orderVO", orderVO).addObject("orderPlyDetailsVOList", orderPlyDetailsVOList);

		} else if (role.equals("generalmanager")) {

			return new ModelAndView("generalmanager/verifyOrderDetails", "progressOrderVO", progressOrderVO)
					.addObject("orderVO", orderVO).addObject("orderPlyDetailsVOList", orderPlyDetailsVOList);

		} else if (role.equals("manager")) {

			return new ModelAndView("manager/verifyOrderDetails", "progressOrderVO", progressOrderVO)
					.addObject("orderVO", orderVO).addObject("orderPlyDetailsVOList", orderPlyDetailsVOList);

		} else {

			return new ModelAndView("redirect:/index");
		}
	}
}