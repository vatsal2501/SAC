package com.project.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.project.model.ClientVO;
import com.project.model.LoginVO;
import com.project.model.MillVO;
import com.project.service.ClientService;
import com.project.service.LoginService;
import com.project.utils.BaseMethods;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private BaseMethods baseMethod;
	
	@GetMapping(value={"admin/addClient","generalmanager/addClient"})
	public ModelAndView loadAddClient(HttpServletRequest request){
		String role = request.getServletPath().split("/")[1];
		if(role.equals("admin")){
			return new ModelAndView("admin/addClient", "clientVO", new ClientVO());
		}else if(role.equals("generalmanager")){
			return new ModelAndView("generalmanager/addClient", "clientVO", new ClientVO());
		}else{
			return new ModelAndView("redirect:/index");
		}
	}
	@PostMapping(value={"admin/insertClient", "generalmanager/insertClient"})
	public ModelAndView insertclient(@ModelAttribute ClientVO clientVO,HttpServletRequest request){
		String userName = this.baseMethod.getUsername();
		System.out.println("==== >"+ userName);
		List<LoginVO> loginVOList = this.loginService.searchByUserName(userName);
		LoginVO loginVO = loginVOList.get(0);
		clientVO.setLoginVO(loginVO);
		this.clientService.insertClient(clientVO);
		   String role = request.getServletPath().split("/")[1];
			if(role.equals("admin")){
				return new ModelAndView("redirect:/admin/viewClient");
			}else if(role.equals("generalmanager")){
				return new ModelAndView("redirect:/generalmanager/viewClient");
			}else{
				return new ModelAndView("redirect:/index");
			}
		
	}
	@GetMapping(value={"admin/viewClient", "generalmanager/viewClient"})
	public ModelAndView searchClient(HttpServletRequest request){
		List<ClientVO> clientList = this.clientService.searchClient();
		   String role = request.getServletPath().split("/")[1];
		   if(role.equals("admin")){
				return new ModelAndView("admin/viewClient", "clientList", clientList);
			}else if(role.equals("generalmanager")){
				return new ModelAndView("generalmanager/viewClient", "clientList", clientList);
			}else{
				return new ModelAndView("redirect:/index");
			}
	}
	@GetMapping(value="admin/deleteClient")
	public ModelAndView deleteClient(@ModelAttribute ClientVO clientVO,@RequestParam int id){
		List<ClientVO> clientList=this.clientService.findById(id);
		clientVO = clientList.get(0);
		clientVO.setStatus(false);
		this.clientService.insertClient(clientVO);
		return new ModelAndView("redirect:/admin/viewClient");
	}
	
	@GetMapping(value={"admin/editClient", "generalmanager/editClient"})
	public ModelAndView editClient(@RequestParam int id,HttpServletRequest request){
		List<ClientVO> clientList = this.clientService.findById(id);
		ClientVO clientVO = clientList.get(0);
		String role = request.getServletPath().split("/")[1];
		if(role.equals("admin")){
			return new ModelAndView("admin/addClient", "clientVO", clientVO);
		}else if(role.equals("generalmanager")){
			return new ModelAndView("generalmanager/addClient", "clientVO", clientVO);
		}else{
			return new ModelAndView("redirect:/index");
		}
		}
	}

