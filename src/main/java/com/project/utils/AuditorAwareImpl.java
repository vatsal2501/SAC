package com.project.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import com.project.model.LoginVO;
import com.project.service.LoginService;
import com.project.utils.BaseMethods;

public class AuditorAwareImpl implements AuditorAware<String> {
	@Autowired
	private BaseMethods baseMethods;
	@Autowired
	private LoginService loginService;

	@Override
	public String getCurrentAuditor() {
		String username = baseMethods.getUsername();
		
		List<LoginVO> loginVOList = this.loginService.searchByUserName(username);
		LoginVO loginVO = loginVOList.get(0);
		
		return username;
	}
}