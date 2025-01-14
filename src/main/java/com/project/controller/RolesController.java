package com.project.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RolesController {
	@GetMapping(value="admin/roles")
	public ModelAndView viewadminroles(){
		return new ModelAndView("admin/viewRoles");
	}

	@GetMapping(value="generalmanager/roles")
	public ModelAndView viewgeneralmanagerroles(){
		return new ModelAndView("generalmanager/viewRoles");
	}

	@GetMapping(value="manager/roles")
	public ModelAndView viewmanagerroles(){
		return new ModelAndView("manager/viewRoles");
	}
	@GetMapping(value="bundlesupervisor/roles")
	public ModelAndView viewbundlesupervisorrroles(){
		return new ModelAndView("bundlesupervisor/viewRoles");
	}
	
	@GetMapping(value="corrugationsupervisor/roles")
	public ModelAndView viewcorrugationsupervisorrroles(){
		return new ModelAndView("corrugationsupervisor/viewRoles");
	}
	@GetMapping(value="dispatchsupervisor/roles")
	public ModelAndView viewdispatchsupervisorrroles(){
		return new ModelAndView("dispatchsupervisor/viewRoles");
	}
	@GetMapping(value="pastingsupervisor/roles")
	public ModelAndView viewpastingsupervisorrroles(){
		return new ModelAndView("pastingsupervisor/viewRoles");
	}
	@GetMapping(value="roterysupervisor/roles")
	public ModelAndView viewroterysupervisorrroles(){
		return new ModelAndView("roterysupervisor/viewRoles");
	}
	@GetMapping(value="rs4supervisor/roles")
	public ModelAndView viewrs4supervisorrroles(){
		return new ModelAndView("rs4supervisor/viewRoles");
	}
	@GetMapping(value="stichingsupervisor/roles")
	public ModelAndView viewstichingsupervisorrroles(){
		return new ModelAndView("stichingsupervisor/viewRoles");
	}


}
