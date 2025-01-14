package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.LoginVO;
import com.project.model.UserVO;
import com.project.service.LoginService;
import com.project.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private LoginService loginService;
	
	
	@GetMapping(value = "admin/addUser")
	public ModelAndView loadAddUser() {
		return new ModelAndView("admin/addUser", "userVO", new UserVO());
	}

	@PostMapping(value = "admin/saveUser")
	public ModelAndView loadSaveUser(@ModelAttribute UserVO userVO) {

		/*DateFormat dateTimeFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date now = new Date();

		userVO.setCreatedDate(dateTimeFormatter.format(now));
		userVO.setUpdateBy(dateTimeFormatter.format(now));
*/
		LoginVO loginVO = userVO.getLoginVO();
		loginVO.setEnabled(1);
		this.loginService.save(loginVO);
		this.userService.save(userVO);

		return new ModelAndView("redirect:/admin/viewUser");
	}

	@GetMapping(value = "admin/viewUser")
	public ModelAndView searchMill() {
		List<UserVO> userList = this.userService.searchUser();
		return new ModelAndView("admin/viewUser", "userList", userList);
	}

	@GetMapping(value = "admin/deleteUser")
	public ModelAndView deleteUser(@ModelAttribute UserVO userVO, @RequestParam int id) {
		System.out.println(":: in  add user delete method() ");
		
		List<UserVO> userList = this.userService.findById(id);
		userVO = userList.get(0);
		
		List<LoginVO> loginVOList = this.loginService.findById(userVO.getLoginVO().getId());
		LoginVO loginVO=loginVOList.get(0);
		
		loginVO.setStatus(false);
		userVO.setStatus(false);
		this.loginService.save(loginVO);
		this.userService.save(userVO);

		return new ModelAndView("redirect:/admin/viewUser");
	}

	@GetMapping(value = "admin/editUser")
	public ModelAndView editUser(@RequestParam int id) {

		List<UserVO> userList = this.userService.findById(id);

		System.out.println(":: in  add user edit method() ");
		UserVO userVO = userList.get(0);

		return new ModelAndView("admin/addUser", "userVO", userVO);
	}

}
