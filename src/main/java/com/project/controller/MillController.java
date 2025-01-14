package com.project.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.LoginVO;
import com.project.model.MillVO;
import com.project.service.LoginService;
import com.project.service.MillService;
import com.project.utils.BaseMethods;
import com.project.dao.MillDAO;


@Controller
public class MillController {
	
	@Autowired 
	private MillService millService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private BaseMethods baseMethod;
	
	@GetMapping(value = { "admin/addMill", "generalmanager/addMill" })
	public ModelAndView loadMill(HttpServletRequest request) {
		String role = request.getServletPath().split("/")[1];
		if(role.equals("admin")){
			return new ModelAndView("admin/addMill", "millVO", new MillVO());
		}else if(role.equals("generalmanager")){
			return new ModelAndView("generalmanager/addMill", "millVO", new MillVO());
		}else{
			return new ModelAndView("redirect:/index");
		}
	}
	
	@PostMapping(value={"admin/insertMill","generalmanager/insertMill"})
	public ModelAndView insertMill(@ModelAttribute MillVO millVO,HttpServletRequest request){
	    
		String userName = this.baseMethod.getUsername();
		System.out.println("==== >"+ userName);
		List<LoginVO> loginVOList = this.loginService.searchByUserName(userName);
		LoginVO loginVO = loginVOList.get(0);
		
		millVO.setLoginVO(loginVO);
		String role = request.getServletPath().split("/")[1];
		this.millService.insertMill(millVO);
		if(role.equals("admin")){
			return new ModelAndView("redirect:/admin/viewMill");
		}else if(role.equals("generalmanager")){
			return new ModelAndView("redirect:/generalmanager/viewMill");
		}else{
			return new ModelAndView("redirect:/index");
		}
		
	}
	
	
	@GetMapping(value = { "admin/viewMill", "generalmanager/viewMill" })
	public ModelAndView searchMill(HttpServletRequest request) {
		String role = request.getServletPath().split("/")[1];
		List<MillVO> millList = this.millService.searchMill();
		if(role.equals("admin")){
			return new ModelAndView("admin/viewMill", "millList", millList);
		}else if(role.equals("generalmanager")){
			return new ModelAndView("generalmanager/viewMill", "millList", millList);
		}else{
			return new ModelAndView("redirect:/index");
		}
	}
	
	@GetMapping(value="admin/deleteMillName")
	public ModelAndView deleteMill(@ModelAttribute MillVO millVO,@RequestParam int id){
		List<MillVO> millList=this.millService.findById(id);
		millVO = millList.get(0);
		millVO.setStatus(false);
		this.millService.insertMill(millVO);
		return new ModelAndView("redirect:/admin/viewMill");
	}
		
	@GetMapping(value={"admin/editMillName","generalmanager/editMillName"})
	public ModelAndView editMill(@RequestParam int id,HttpServletRequest request){
		List<MillVO> millList = this.millService.findById(id);
		MillVO millVO = millList.get(0);
		String role = request.getServletPath().split("/")[1];
		if(role.equals("admin")){
			return new ModelAndView("admin/addMill", "millVO", millVO);
		}else if(role.equals("generalmanager")){
			return new ModelAndView("generalmanager/addMill", "millVO", millVO);
		}else{
			return new ModelAndView("redirect:/index");
		}
	}
}
