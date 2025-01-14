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

import com.project.model.PaperTypeVO;
import com.project.model.LoginVO;
import com.project.model.MillVO;
import com.project.model.PaperTypeVO;
import com.project.service.LoginService;
import com.project.service.MillService;
import com.project.service.PaperTypeService;
import com.project.utils.BaseMethods;

@Controller
public class PaperTypeController {
	
	@Autowired
	private PaperTypeService papertypeService;
	
	@Autowired
	private MillService millService;
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private BaseMethods baseMethod;

	@GetMapping(value={"admin/addPaperType","generalmanager/addPaperType"})
	public ModelAndView loadAddPaperType(HttpServletRequest request){
		List<MillVO> millList = this.millService.searchMill();
		 String role = request.getServletPath().split("/")[1];
			if(role.equals("admin")){
				return new ModelAndView("admin/addPaperType", "paperVO", new PaperTypeVO()).addObject("millList", millList);
			}else if(role.equals("generalmanager")){
				return new ModelAndView("generalmanager/addPaperType", "paperVO", new PaperTypeVO()).addObject("millList", millList);
			}else{
				return new ModelAndView("redirect:/index");
			}
	}
	@PostMapping(value={"admin/insertPaperType","generalmanager/insertPaperType"})
	public ModelAndView insertPaperType(@ModelAttribute PaperTypeVO paperTypeVO,HttpServletRequest request){
		String userName = this.baseMethod.getUsername();
		System.out.println("==== >"+ userName);
		List<LoginVO> loginVOList = this.loginService.searchByUserName(userName);
		LoginVO loginVO = loginVOList.get(0);
		
		paperTypeVO.setLoginVO(loginVO);
	this.papertypeService.insertPaperType(paperTypeVO);
	 String role = request.getServletPath().split("/")[1];
		if(role.equals("admin")){
			return new ModelAndView("redirect:/admin/viewPaperType");
		}else if(role.equals("generalmanager")){
			return new ModelAndView("redirect:/generalmanager/viewPaperType");
		}else{
			return new ModelAndView("redirect:/index");
		}
	}
	@GetMapping(value={"admin/viewPaperType","generalmanager/viewPaperType"})
	public ModelAndView searchPaperType(HttpServletRequest request){
		List<PaperTypeVO> PaperTypeList = this.papertypeService.searchPaperType();
		 String role = request.getServletPath().split("/")[1];
		   if(role.equals("admin")){
				return new ModelAndView("admin/viewPaperType", "PaperTypeList", PaperTypeList);
			}else if(role.equals("generalmanager")){
				return new ModelAndView("generalmanager/viewPaperType", "PaperTypeList", PaperTypeList);
			}else{
				return new ModelAndView("redirect:/index");
			}
	}
	@GetMapping(value="admin/deletePaper")
	public ModelAndView deletePaperType(@ModelAttribute PaperTypeVO paperTypeVO,@RequestParam int id){
		List<PaperTypeVO> PaperTypeList=this.papertypeService.findById(id);
		paperTypeVO = PaperTypeList.get(0);
		paperTypeVO.setStatus(false);
		this.papertypeService.insertPaperType(paperTypeVO);
		return new ModelAndView("redirect:/admin/viewPaperType");
	}
	
	@GetMapping(value={"admin/editPaper","generalmanager/editPaper"})
	public ModelAndView editPaperType(@RequestParam int id,HttpServletRequest request){
		List<PaperTypeVO> PaperTypeList = this.papertypeService.findById(id);
		List<MillVO> millList = this.millService.searchMill();
		PaperTypeVO paperTypeVO = PaperTypeList.get(0);
		String role = request.getServletPath().split("/")[1];
		if(role.equals("admin")){
			return new ModelAndView("admin/addPaperType", "paperVO", paperTypeVO).addObject("millList", millList);
		}else if(role.equals("generalmanager")){
			return new ModelAndView("generalmanager/addPaperType", "paperVO", paperTypeVO).addObject("millList", millList);
		}else{
			return new ModelAndView("redirect:/index");
		}
	}

}