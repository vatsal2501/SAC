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

import com.project.model.LoginVO;
import com.project.model.MillVO;
import com.project.model.PaperTypeVO;
import com.project.model.ReelVO;
import com.project.model.TopPaperVO;
import com.project.service.LoginService;
import com.project.service.MillService;
import com.project.service.PaperTypeService;
import com.project.service.TopPaperService;
import com.project.utils.BaseMethods;

@Controller
public class TopPaperController {

	@Autowired
	private TopPaperService toppaperService;

	@Autowired
	private MillService millService;

	@Autowired
	private PaperTypeService paperTypeService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private BaseMethods baseMethod;

	@GetMapping(value = {"admin/addTopPaper","generalmanager/addTopPaper","manager/addTopPaper"})
	public ModelAndView loadAddTopPaper(HttpServletRequest request) {
		List<MillVO> millList = this.millService.searchMill();
		List<PaperTypeVO> paperTypeList = this.paperTypeService.searchPaperType();
		List<TopPaperVO> toppaperList = this.toppaperService.sortTopPaper();
		 String role = request.getServletPath().split("/")[1];
			if(role.equals("admin")){
				return new ModelAndView("admin/addTopPaper", "toppaperVO", new TopPaperVO()).addObject("millList", millList)
						.addObject("paperTypeList", paperTypeList).addObject("toppaperList", toppaperList);
			}else if(role.equals("generalmanager")){
				return new ModelAndView("generalmanager/addTopPaper", "toppaperVO", new TopPaperVO()).addObject("millList", millList)
						.addObject("paperTypeList", paperTypeList).addObject("toppaperList", toppaperList);
			}else if(role.equals("manager")){
				return new ModelAndView("manager/addTopPaper", "toppaperVO", new TopPaperVO()).addObject("millList", millList)
						.addObject("paperTypeList", paperTypeList).addObject("toppaperList", toppaperList);
			}else{
				return new ModelAndView("redirect:/index");
			}
				}

	@PostMapping(value = {"admin/insertTopPaper","generalmanager/insertTopPaper","manager/insertTopPaper"})
	public ModelAndView inserttoppaper(@ModelAttribute TopPaperVO toppaperVO,HttpServletRequest request) {
		String userName = this.baseMethod.getUsername();
		System.out.println("==== >"+ userName);
		List<LoginVO> loginVOList = this.loginService.searchByUserName(userName);
		LoginVO loginVO = loginVOList.get(0);
		this.toppaperService.calculatePercent();

		toppaperVO.setLoginVO(loginVO);
		this.toppaperService.insertTopPaper(toppaperVO);
		 String role = request.getServletPath().split("/")[1];
			if(role.equals("admin")){
				return new ModelAndView("redirect:/admin/viewTopPaper");
			}else if(role.equals("generalmanager")){
				return new ModelAndView("redirect:/generalmanager/viewTopPaper");
			}else if(role.equals("manager")){
				return new ModelAndView("redirect:/manager/viewTopPaper");
			}
			else{
				return new ModelAndView("redirect:/index");
			}
	}

	@GetMapping(value = {"admin/viewTopPaper","generalmanager/viewTopPaper","manager/viewTopPaper"})
	public ModelAndView searchTopPaper(HttpServletRequest request) {
		List<TopPaperVO> toppaperList = this.toppaperService.searchTopPaper();
		 String role = request.getServletPath().split("/")[1];
		   if(role.equals("admin")){
				return new ModelAndView("admin/viewTopPaper", "toppaperList", toppaperList);
			}else if(role.equals("generalmanager")){
				return new ModelAndView("generalmanager/viewTopPaper", "toppaperList", toppaperList);
			}else if(role.equals("manager")){
				return new ModelAndView("manager/viewTopPaper", "toppaperList", toppaperList);
			}else{
				return new ModelAndView("redirect:/index");
			}
	}

	@GetMapping(value = "admin/deleteTopPaper")
	public ModelAndView deleteTopPaper(@ModelAttribute TopPaperVO toppaperVO, @RequestParam int id) {
		List<TopPaperVO> toppaperList = this.toppaperService.findById(id);
		toppaperVO = toppaperList.get(0);
		toppaperVO.setStatus(false);
		this.toppaperService.insertTopPaper(toppaperVO);
		return new ModelAndView("redirect:/admin/viewTopPaper");
	}

	@GetMapping(value ={ "admin/editTopPaper","generalmanager/editTopPaper","manager/editTopPaper"})
	public ModelAndView editTopPaper(@RequestParam int id,HttpServletRequest request) {
		List<TopPaperVO> toppaperList = this.toppaperService.findById(id);
		List<MillVO> millList = this.millService.searchMill();
		List<PaperTypeVO> paperTypeList = this.paperTypeService.searchPaperType();
		TopPaperVO toppaperVO = toppaperList.get(0);
		String role = request.getServletPath().split("/")[1];
		if(role.equals("admin")){
			return new ModelAndView("admin/addTopPaper", "toppaperVO", toppaperVO).addObject("millList", millList)
					.addObject("paperTypeList", paperTypeList).addObject("toppaperList", toppaperList);
		}else if(role.equals("generalmanager")){
			return new ModelAndView("generalmanager/addTopPaper", "toppaperVO", toppaperVO).addObject("millList", millList)
					.addObject("paperTypeList", paperTypeList).addObject("toppaperList", toppaperList);
		}else if(role.equals("manager")){
			return new ModelAndView("manager/addTopPaper", "toppaperVO", toppaperVO).addObject("millList", millList)
					.addObject("paperTypeList", paperTypeList).addObject("toppaperList", toppaperList);
		}else{
			return new ModelAndView("redirect:/index");
		}
	}

}