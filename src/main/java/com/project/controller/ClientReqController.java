package com.project.controller;

import java.text.DecimalFormat;
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
import com.project.model.PaperTypeVO;
import com.project.model.PlyDetailsVO;
import com.project.service.ClientReqService;
import com.project.service.ClientService;
import com.project.service.LoginService;
import com.project.service.PaperTypeService;
import com.project.utils.BaseMethods;

@Controller
public class ClientReqController {

	@Autowired
	private ClientReqService clientreqService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private PaperTypeService papertypeService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private BaseMethods baseMethod;

	@GetMapping(value = { "admin/addClientReq", "generalmanager/addClientReq" })
	public ModelAndView loadAddClientReq(HttpServletRequest request) {
		List<ClientVO> clientList = this.clientService.searchClient();
		List<PaperTypeVO> papertypeList = this.papertypeService.searchPaperType();
		String role = request.getServletPath().split("/")[1];
		if (role.equals("admin")) {
			return new ModelAndView("admin/addClientReq", "clientreqVO", new ClientReqVO())
					.addObject("clientList", clientList).addObject("papertypeList", papertypeList);
		} else if (role.equals("generalmanager")) {
			return new ModelAndView("generalmanager/addClientReq", "clientreqVO", new ClientReqVO())
					.addObject("clientList", clientList).addObject("papertypeList", papertypeList);
		} else {
			return new ModelAndView("redirect:/index");
		}
	}

	@PostMapping(value = { "admin/insertClientReq", "generalmanager/insertClientReq" })
	public ModelAndView insertclientreq(@ModelAttribute ClientReqVO clientreqVO, HttpServletRequest request,
			@RequestParam String length, @RequestParam String height, @RequestParam String width) {

		int clientReqId = clientreqVO.getClientreqId();

		String userName = this.baseMethod.getUsername();
		System.out.println("==== >" + userName);
		List<LoginVO> loginVOList = this.loginService.searchByUserName(userName);
		LoginVO loginVO = loginVOList.get(0);

		clientreqVO.setLoginVO(loginVO);
		double Length = Integer.parseInt(length);
		int Width = Integer.parseInt(width);
		int Height = Integer.parseInt(height);

		Double decal = (Width + Height + 10) / 25.4;

		Double cutting = ((Length + Width) * 2 + 50) / 25.4;

		DecimalFormat numberFormat = new DecimalFormat();
		numberFormat.setMaximumFractionDigits(2);

		clientreqVO.setDecal(numberFormat.format(decal));
		clientreqVO.setCutting(numberFormat.format(cutting));

		this.clientreqService.insertClientReq(clientreqVO);

		for (PlyDetailsVO plyDetailsVO : clientreqVO.getPlyDetailsList()) {
			plyDetailsVO.setClientReqVO(clientreqVO);
			this.clientreqService.savePlyDetails(plyDetailsVO);
		}

		String role = request.getServletPath().split("/")[1];

		if (role.equals("admin")) {
			return new ModelAndView("redirect:/admin/viewClientReq");
		} else if (role.equals("generalmanager")) {
			return new ModelAndView("redirect:/generalmanager/viewClientReq");
		} else {
			return new ModelAndView("redirect:/index");
		}

	}

	@GetMapping(value = { "admin/viewClientReq", "generalmanager/viewClientReq" })
	public ModelAndView searchClientReq(HttpServletRequest request) {
		List<ClientReqVO> ClientReqList = this.clientreqService.searchClientReq();
		String role = request.getServletPath().split("/")[1];
		if (role.equals("admin")) {
			return new ModelAndView("admin/viewClientReq", "ClientReqList", ClientReqList);
		} else if (role.equals("generalmanager")) {
			return new ModelAndView("generalmanager/viewClientReq", "ClientReqList", ClientReqList);
		} else {
			return new ModelAndView("redirect:/index");
		}

	}

	@GetMapping(value = "admin/deleteClientReq")
	public ModelAndView deleteClientReq(@ModelAttribute ClientReqVO clientreqVO, @RequestParam int id) {
		List<ClientReqVO> ClientReqList = this.clientreqService.findById(id);
		clientreqVO = ClientReqList.get(0);
		clientreqVO.setStatus(false);
		this.clientreqService.insertClientReq(clientreqVO);
		return new ModelAndView("redirect:/admin/viewClientReq");
	}

	@GetMapping(value = { "admin/editClientReq", "generalmanager/editClientReq" })
	public ModelAndView editClientReq(@RequestParam int id, HttpServletRequest request) {
		List<ClientReqVO> ClientReqList = this.clientreqService.findById(id);
		List<ClientVO> clientList = this.clientService.searchClient();
		List<PaperTypeVO> papertypeList = this.papertypeService.searchPaperType();
		ClientReqVO clientreqVO = ClientReqList.get(0);
		System.out.println("qwer" + id);
		List<PlyDetailsVO> plyDetailsVOList = this.clientreqService.findPlyDetailsByClientReqId(id);
		System.out.println(plyDetailsVOList);
		String role = request.getServletPath().split("/")[1];
		if (role.equals("admin")) {
			return new ModelAndView("admin/addClientReq", "clientreqVO", clientreqVO)
					.addObject("clientList", clientList).addObject("papertypeList", papertypeList)
					.addObject("plyDetailsVOList", plyDetailsVOList);
		} else if (role.equals("generalmanager")) {
			return new ModelAndView("generalmanager/addClientReq", "clientreqVO", clientreqVO)
					.addObject("clientList", clientList).addObject("papertypeList", papertypeList)
					.addObject("plyDetailsVOList", plyDetailsVOList);
		} else {
			return new ModelAndView("redirect:/index");
		}

	}
	
	//this is ajax to get the ply details using clientReqId
	@GetMapping(value = { "admin/getPlyDetailsByClientReqId", "generalmanager/getPlyDetailsByClientReqId",
			"manager/getPlyDetailsByClientReqId" })
	public ResponseEntity getPlyDetailsByClientReqId(@RequestParam int clientReqId, HttpServletRequest request) {

		List<PlyDetailsVO> plydetailsList = this.clientreqService.findPlyDetailsByClientReqId(clientReqId);
		System.out.println(" :::::: the ajax has been called ::::");
		return new ResponseEntity<>(plydetailsList, HttpStatus.OK);
	}

}
