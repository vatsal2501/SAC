package com.project.controller;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.LoginVO;
import com.project.model.MillVO;
import com.project.model.PaperTypeVO;
import com.project.model.ReelVO;
import com.project.service.LoginService;
import com.project.service.MillService;
import com.project.service.PaperTypeService;
import com.project.service.ReelService;
import com.project.utils.BaseMethods;

@Controller
public class ReelController {

	@Autowired
	private ReelService reelService;

	@Autowired
	private MillService millService;

	@Autowired
	private PaperTypeService paperTypeService;

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private BaseMethods baseMethod;
	
	@GetMapping(value = { "admin/addReel", "generalmanager/addReel", "manager/addReel" })
	public ModelAndView loadAddReel(HttpServletRequest request) {
		List<MillVO> millList = this.millService.searchMill();
		List<PaperTypeVO> paperTypeList = this.paperTypeService.searchPaperType();
		List<ReelVO> reelList = this.reelService.sortReel();
		
		String role = request.getServletPath().split("/")[1];

/* tring to get the next sequence from the hibernate sequence table and assinging the value to the actual reelNumber
*/  
 /* 		int year = new Date().getYear();
 
 		long reelNumber = this.reelService.getNextSequence();
 		String actualReelNumber = year + "/" + reelNumber;
 		
 		ReelVO reelVO = new ReelVO();
 		reelVO.setReelNumber(actualReelNumber);
 */
		
		
		if (role.equals("admin")) {

			return new ModelAndView("admin/addReel", "reelVO", new ReelVO()).addObject("millList", millList)
					.addObject("paperTypeList", paperTypeList).addObject("reelList", reelList);

		} else if (role.equals("generalmanager")) {

			return new ModelAndView("generalmanager/addReel", "reelVO", new ReelVO()).addObject("millList", millList)
					.addObject("paperTypeList", paperTypeList).addObject("reelList", reelList);

		} else if (role.equals("manager")) {

			return new ModelAndView("manager/addReel", "reelVO", new ReelVO()).addObject("millList", millList)
					.addObject("paperTypeList", paperTypeList).addObject("reelList", reelList);

		} else {
			return new ModelAndView("redirect:/index");
		}

	}

	@PostMapping(value = { "admin/insertReel", "generalmanager/insertReel", "manager/insertReel" })
	public ModelAndView insertreel(@ModelAttribute ReelVO reelVO, HttpServletRequest request,Model model) {
		/* int year = Year.now().getValue();
	        String reelNumber = ""+ year ;
	       System.out.println("custom reel"+reelNumber);
			model.addAttribute("reelNumber", reelNumber);
		*/
		String userName = this.baseMethod.getUsername();
		System.out.println("==== >"+ userName);
		List<LoginVO> loginVOList = this.loginService.searchByUserName(userName);
		LoginVO loginVO = loginVOList.get(0);
		
		reelVO.setLoginVO(loginVO);
		this.reelService.calculatePercent();
		this.reelService.insertReel(reelVO);

		String role = request.getServletPath().split("/")[1];
		if (role.equals("admin")) {

			return new ModelAndView("redirect:/admin/viewReel");

		} else if (role.equals("generalmanager")) {           

			return new ModelAndView("redirect:/generalmanager/viewReel");

		} else if (role.equals("manager")) {

			return new ModelAndView("redirect:/manager/viewReel");

		} else {
			return new ModelAndView("redirect:/index");
		}

	}

	@GetMapping(value = { "admin/viewReel", "generalmanager/viewReel", "manager/viewReel" })
	public ModelAndView searchReel(HttpServletRequest request) {
		List<ReelVO> reelList = this.reelService.searchReel();

		String role = request.getServletPath().split("/")[1];
		if (role.equals("admin")) {

			return new ModelAndView("admin/viewReel", "reelList", reelList);

		} else if (role.equals("generalmanager")) {

			return new ModelAndView("generalmanager/viewReel", "reelList", reelList);

		} else if (role.equals("manager")) {

			return new ModelAndView("manager/viewReel", "reelList", reelList);

		} else {
			return new ModelAndView("redirect:/index");
		}

	}

	@GetMapping(value = "admin/deleteReel")
	public ModelAndView deleteReel(@ModelAttribute ReelVO reelVO, @RequestParam int id) {
		List<ReelVO> reelList = this.reelService.findById(id);
		reelVO = reelList.get(0);
		reelVO.setStatus(false);
		this.reelService.insertReel(reelVO);
		return new ModelAndView("redirect:/admin/viewReel");
	}

	@GetMapping(value = { "admin/editReel", "generalmanager/editReel", "manager/editReel" })
	public ModelAndView editReel(@RequestParam int id, HttpServletRequest request) {
		List<ReelVO> seereelList = this.reelService.findById(id);
		List<PaperTypeVO> paperTypeList = this.paperTypeService.searchPaperType();
		List<ReelVO> reelList = this.reelService.sortReel();
		List<MillVO> millList = this.millService.searchMill();
		ReelVO reelVO = seereelList.get(0);

		String role = request.getServletPath().split("/")[1];
		if (role.equals("admin")) {

			return new ModelAndView("admin/addReel", "reelVO", reelVO).addObject("millList", millList)
					.addObject("paperTypeList", paperTypeList).addObject("reelList", reelList);

		} else if (role.equals("generalmanager")) {

			return new ModelAndView("generalmanager/addReel", "reelVO", reelVO).addObject("millList", millList)
					.addObject("paperTypeList", paperTypeList).addObject("reelList", reelList);

		} else if (role.equals("manager")) {

			return new ModelAndView("manager/addReel", "reelVO", reelVO).addObject("millList", millList)
					.addObject("paperTypeList", paperTypeList).addObject("reelList", reelList);

		} else {
			return new ModelAndView("redirect:/index");
		}

	}

}