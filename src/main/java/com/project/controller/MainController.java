package com.project.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.LoginVO;
import com.project.model.OrderVO;
import com.project.model.ReelVO;
import com.project.model.TopPaperVO;
import com.project.model.UserVO;
import com.project.service.LoginService;
import com.project.service.OrderService;
import com.project.service.ReelService;
import com.project.service.TopPaperService;
import com.project.service.UserService;
import com.project.utils.BaseMethods;

@Controller
public class MainController {

	@Autowired
	private BaseMethods baseMethods;

	@Autowired
	private LoginService loginService;

	@Autowired
	private TopPaperService topPaperService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ReelService reelService;

	// @GetMapping(value="/")
	// public ModelAndView load(){
	// return new ModelAndView("admin/index");
	// }

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loadLogin() {

		return new ModelAndView("login", "loginVO", new LoginVO());
	}

	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public ModelAndView adminIndex(LoginVO loginVO) {
		String username = BaseMethods.getUsername();
		List<LoginVO> loginVOList = this.loginService.searchByUserName(username);

		loginVO = loginVOList.get(0);

		Date date = new Date();

		loginVO.setLastActive(date);

		this.loginService.save(loginVO);
		System.out.println("hello this is logout controller  :  " + date);

		List<ReelVO> reelList = this.reelService.searchReel();

		Long weight = this.reelService.calculatePercent();
		
		System.out.println(":::::"+weight);

		double weightPr = (weight * 100) / weight;
		
		List<TopPaperVO> topPaperList = this.topPaperService.searchTopPaper();
		Long pieces = this.topPaperService.calculatePercent();
		System.out.println("indextoppaer23"+pieces);
		
		List<UserVO> userList = this.userService.searchUser();
		List<OrderVO> orderList = this.orderService.searchOrder();
		System.out.println("Custom Info :: In Main Controller : adminIndex() :: user name" + username);

		return new ModelAndView("admin/index").addObject("weightPr", weightPr).addObject("weight", weight)
				.addObject("reelList", reelList).addObject("pieces",pieces).addObject("userList",userList).addObject("orderList",orderList);
	}

	@RequestMapping(value = "/generalmanager/index", method = RequestMethod.GET)
	public ModelAndView generalmanagerIndex(LoginVO loginVO) {
		// List<ReelVO> reelWeightList = this.reelService.calculatePercent(0);
		String username = BaseMethods.getUsername();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<LoginVO> loginVOList = this.loginService.searchByUserName(username);

		loginVO = loginVOList.get(0);

		Date date = new Date();

		loginVO.setLastActive(date);

		this.loginService.save(loginVO);
		System.out.println("hello this is logout controller  :  " + date);

		List<ReelVO> reelList = this.reelService.searchReel();

		Long weight = this.reelService.calculatePercent();
		
		System.out.println(":::::"+weight);

		double weightPr = (weight * 100) / weight;
		
		
		Long pieces = this.topPaperService.calculatePercent();
		System.out.println("indextoppaer23"+pieces);
		
		List<OrderVO> orderList = this.orderService.searchOrder();
		System.out.println("Custom Info :: In Main Controller : adminIndex() :: user name" + username);

		return new ModelAndView("generalmanager/index").addObject("weightPr", weightPr).addObject("weight", weight)
				.addObject("reelList", reelList).addObject("pieces",pieces).addObject("orderList",orderList);
	}


	@RequestMapping(value = "/manager/index", method = RequestMethod.GET)
	public ModelAndView managerIndex(LoginVO loginVO) {
		String username = BaseMethods.getUsername();
		List<LoginVO> loginVOList = this.loginService.searchByUserName(username);

		loginVO = loginVOList.get(0);

		Date date = new Date();

		loginVO.setLastActive(date);

		this.loginService.save(loginVO);
		System.out.println("hello this is logout controller  :  " + date);

		List<ReelVO> reelList = this.reelService.searchReel();

		Long weight = this.reelService.calculatePercent();
		double weightPr = (weight * 100) / weight;

		System.out.println("Custom Info :: In Main Controller : adminIndex() :: user name" + username);

		Long pieces = this.topPaperService.calculatePercent();
		System.out.println("indextoppaer23"+pieces);
		
		List<OrderVO> orderList = this.orderService.searchOrder();
		System.out.println("Custom Info :: In Main Controller : adminIndex() :: user name" + username);
		
		return new ModelAndView("manager/index").addObject("weightPr", weightPr).addObject("weight", weight)
				.addObject("reelList", reelList).addObject("pieces",pieces).addObject("orderList",orderList);
	}

	@RequestMapping(value = "/corrugationsupervisor/index", method = RequestMethod.GET)
	public ModelAndView corrugationsupervisorIndex(LoginVO loginVO) {
		String username = BaseMethods.getUsername();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<LoginVO> loginVOList = this.loginService.searchByUserName(username);

		loginVO = loginVOList.get(0);

		Date date = new Date();

		loginVO.setLastActive(date);

		this.loginService.save(loginVO);
		System.out.println("hello this is logout controller  :  " + date);

		List<ReelVO> reelList = this.reelService.searchReel();

		Long weight = this.reelService.calculatePercent();
		double weightPr = (weight * 100) / weight;

		System.out.println("Custom Info :: In Main Controller : adminIndex() :: user name" + username);



		return new ModelAndView("corrugationsupervisor/index");
	}

	@RequestMapping(value = "/pastingsupervisor/index", method = RequestMethod.GET)
	public ModelAndView pastingsupervisorIndex(LoginVO loginVO) {
		String username = BaseMethods.getUsername();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<LoginVO> loginVOList = this.loginService.searchByUserName(username);

		loginVO = loginVOList.get(0);

		Date date = new Date();

		loginVO.setLastActive(date);

		this.loginService.save(loginVO);
		System.out.println("hello this is logout controller  :  " + date);

		List<ReelVO> reelList = this.reelService.searchReel();

		Long weight = this.reelService.calculatePercent();
		double weightPr = (weight * 100) / weight;

		System.out.println("Custom Info :: In Main Controller : adminIndex() :: user name" + username);


		

		return new ModelAndView("pastingsupervisor/index");
	}

	@RequestMapping(value = "/roterysupervisor/index", method = RequestMethod.GET)
	public ModelAndView roterysupervisorIndex(LoginVO loginVO) {
		String username = BaseMethods.getUsername();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<LoginVO> loginVOList = this.loginService.searchByUserName(username);

		loginVO = loginVOList.get(0);

		Date date = new Date();

		loginVO.setLastActive(date);

		this.loginService.save(loginVO);
		System.out.println("hello this is logout controller  :  " + date);

		List<ReelVO> reelList = this.reelService.searchReel();

		Long weight = this.reelService.calculatePercent();
		double weightPr = (weight * 100) / weight;

		System.out.println("Custom Info :: In Main Controller : adminIndex() :: user name" + username);



		return new ModelAndView("roterysupervisor/index");
	}

	@RequestMapping(value = "/stichingsupervisor/index", method = RequestMethod.GET)
	public ModelAndView stichingsupervisorIndex(LoginVO loginVO) {
		String username = BaseMethods.getUsername();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<LoginVO> loginVOList = this.loginService.searchByUserName(username);

		loginVO = loginVOList.get(0);

		Date date = new Date();

		loginVO.setLastActive(date);

		this.loginService.save(loginVO);
		System.out.println("hello this is logout controller  :  " + date);

		List<ReelVO> reelList = this.reelService.searchReel();

		Long weight = this.reelService.calculatePercent();
		double weightPr = (weight * 100) / weight;

		System.out.println("Custom Info :: In Main Controller : adminIndex() :: user name" + username);


		return new ModelAndView("stichingsupervisor/index");
	}

	@RequestMapping(value = "/bundlesupervisor/index", method = RequestMethod.GET)
	public ModelAndView bundlesupervisorIndex(LoginVO loginVO) {
		String username = BaseMethods.getUsername();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<LoginVO> loginVOList = this.loginService.searchByUserName(username);

		loginVO = loginVOList.get(0);

		Date date = new Date();

		loginVO.setLastActive(date);

		this.loginService.save(loginVO);
		System.out.println("hello this is logout controller  :  " + date);

		List<ReelVO> reelList = this.reelService.searchReel();

		Long weight = this.reelService.calculatePercent();
		double weightPr = (weight * 100) / weight;

		System.out.println("Custom Info :: In Main Controller : adminIndex() :: user name" + username);


		return new ModelAndView("bundlesupervisor/index");
	}

	@RequestMapping(value = "/dispatchsupervisor/index", method = RequestMethod.GET)
	public ModelAndView dispatchsupervisorIndex(LoginVO loginVO) {
		String username = BaseMethods.getUsername();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<LoginVO> loginVOList = this.loginService.searchByUserName(username);

		loginVO = loginVOList.get(0);

		Date date = new Date();

		loginVO.setLastActive(date);

		this.loginService.save(loginVO);
		System.out.println("hello this is logout controller  :  " + date);

		List<ReelVO> reelList = this.reelService.searchReel();

		Long weight = this.reelService.calculatePercent();
		double weightPr = (weight * 100) / weight;

		System.out.println("Custom Info :: In Main Controller : adminIndex() :: user name" + username);



		return new ModelAndView("dispatchsupervisor/index");
	}
	
	@RequestMapping(value = "/rs4supervisor/index", method = RequestMethod.GET)
	public ModelAndView rs4supervisorIndex(LoginVO loginVO) {
		String username = BaseMethods.getUsername();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<LoginVO> loginVOList = this.loginService.searchByUserName(username);

		loginVO = loginVOList.get(0);

		Date date = new Date();

		loginVO.setLastActive(date);

		this.loginService.save(loginVO);
		System.out.println("hello this is logout controller  :  " + date);

		List<ReelVO> reelList = this.reelService.searchReel();

		Long weight = this.reelService.calculatePercent();
		double weightPr = (weight * 100) / weight;

		System.out.println("Custom Info :: In Main Controller : adminIndex() :: user name" + username);



		return new ModelAndView("rs4supervisor/index");
	}
	

	@RequestMapping(value = "/logout", method = { RequestMethod.POST, RequestMethod.GET })
	public String viewUserDetails(ModelMap model, HttpServletResponse response, HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {

			new SecurityContextLogoutHandler().logout(request, response, auth);
			request.getSession().invalidate();
			request.getSession().setAttribute("tempStatus", "success");
			request.getSession().setAttribute("statusText", "Logout Successfully!");
		}

		System.out.println("====================================");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView load() {

		return new ModelAndView("login");
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView load403() {

		return new ModelAndView("login");
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView error() {

		return new ModelAndView("login");
	}

}
