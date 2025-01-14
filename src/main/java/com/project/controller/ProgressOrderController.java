package com.project.controller;

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
import com.project.model.OrderVO;
import com.project.model.PaperTypeVO;
import com.project.model.PlyDetailsVO;
import com.project.model.ProgressOrderVO;
import com.project.model.VerifyPlyDetailsVO;
import com.project.service.ClientReqService;
import com.project.service.ClientService;
import com.project.service.LoginService;
import com.project.service.OrderService;
import com.project.service.PaperTypeService;
import com.project.service.ProgressOrderService;
import com.project.utils.BaseMethods;

@Controller
public class ProgressOrderController {

	@Autowired
	private ClientReqService clientreqService;

	@Autowired
	private ProgressOrderService progressOrderService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private PaperTypeService papertypeService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private BaseMethods baseMethod;

	@PostMapping(value = { "admin/insertProcess", "generalmanager/insertProcess", "manager/insertProcess" })
	public ModelAndView insertProcessOrder(@ModelAttribute ProgressOrderVO progressOrderVO,
			HttpServletRequest request) {

		int orderId = progressOrderVO.getOrderVO().getOrderId();

		List<OrderVO> orderList = this.orderService.findById(orderId);

		OrderVO orderVO = orderList.get(0);

		orderVO.setProcessStatus("InProcess");

		progressOrderVO.setProcessStatus("InProcess");

		// to add the OrderPlyDetails
		int progressOrderVOId = progressOrderVO.getProgressOrderId();

		String userName = this.baseMethod.getUsername();

		List<LoginVO> loginVOList = this.loginService.searchByUserName(userName);

		LoginVO loginVO = loginVOList.get(0);

		progressOrderVO.setLoginVO(loginVO);

		this.orderService.insertOrder(orderVO);
		this.progressOrderService.insertProgressOrder(progressOrderVO);

		String role = request.getServletPath().split("/")[1];

		if (role.equals("admin")) {
			return new ModelAndView("redirect:/admin/viewProcess");
		} else if (role.equals("generalmanager")) {
			return new ModelAndView("redirect:/generalmanager/viewProcess");
		} else {
			return new ModelAndView("redirect:/index");
		}

	}

	@GetMapping(value = { "admin/getverifyOrderDetailsById", "generalmanager/getverifyOrderDetailsById",
			"manager/getverifyOrderDetailsById" })
	public ResponseEntity getverifyOrderDetailsById(@RequestParam int orderId, HttpServletRequest request) {

		List<OrderVO> orderList = this.orderService.findById(orderId);

		return new ResponseEntity<>(orderList, HttpStatus.OK);
	}

	@GetMapping(value = { "admin/viewProcess", "generalmanager/viewProcess" })
	public ModelAndView searchClientReq(HttpServletRequest request) {
		List<ProgressOrderVO> progressOrderList = this.progressOrderService.searchProgressOrder();
		String role = request.getServletPath().split("/")[1];
		if (role.equals("admin")) {
			return new ModelAndView("admin/viewProcess", "progressOrderList", progressOrderList);
		} else if (role.equals("generalmanager")) {
			return new ModelAndView("generalmanager/viewProcess", "progressOrderList", progressOrderList);
		} else {
			return new ModelAndView("redirect:/index");
		}

	}

	@GetMapping(value = "admin/deleteProcess")
	public ModelAndView deleteProgressOrder(@ModelAttribute ProgressOrderVO progressOrderVO, @RequestParam int id) {

		List<ProgressOrderVO> progressOrderList = this.progressOrderService.findById(id);

		progressOrderVO = progressOrderList.get(0);

		progressOrderVO.setStatus(false);

		this.progressOrderService.insertProgressOrder(progressOrderVO);

		return new ModelAndView("redirect:/admin/viewProcess");
	}

	@GetMapping(value = { "admin/editProcess", "generalmanager/editProcess", "manager/editProcess" })
	public ModelAndView editProgressOrder(@RequestParam int id, HttpServletRequest request) {

		List<ProgressOrderVO> progressOrderList = this.progressOrderService.findById(id);

		List<ClientVO> clientList = this.clientService.searchClient();

		List<PaperTypeVO> papertypeList = this.papertypeService.searchPaperType();

		ProgressOrderVO processVO = progressOrderList.get(0);

		String role = request.getServletPath().split("/")[1];

		if (role.equals("admin")) {
			return new ModelAndView("admin/addProcess", "processVO", processVO).addObject("clientList", clientList)
					.addObject("papertypeList", papertypeList);

		} else if (role.equals("generalmanager")) {
			return new ModelAndView("generalmanager/addProcess", "processVO", processVO)
					.addObject("clientList", clientList).addObject("papertypeList", papertypeList);
		} else {
			return new ModelAndView("redirect:/index");
		}

	}

}
