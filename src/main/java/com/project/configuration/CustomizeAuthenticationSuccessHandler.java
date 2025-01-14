package com.project.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// set our response to OK status
		response.setStatus(HttpServletResponse.SC_OK);

		boolean admin = false;
		boolean generalmanager = false;
		boolean manager = false;
		boolean corrugationsupervisor = false;
		boolean pastingsupervisor = false;
		boolean roterysupervisor = false;
		boolean rs4supervisor = false;
		boolean stichingsupervisor = false;
		boolean bundlesupervisor = false;
		boolean dispatchsupervisor = false;

		System.out.println("AT onAuthenticationSuccess(...) function!");

		System.out.println(authentication.getAuthorities());
		
		for (GrantedAuthority auth : authentication.getAuthorities()) {
			if ("ROLE_ADMIN".equals(auth.getAuthority())) {
				admin = true;
			} else if ("ROLE_GENERAL_MANAGER".equals(auth.getAuthority())) {
				generalmanager = true;
			} else if ("ROLE_MANAGER".equals(auth.getAuthority())) {
				manager = true;
			} else if ("ROLE_CORRUGATION_SUPERVISOR".equals(auth.getAuthority())) {
				corrugationsupervisor = true;
			} else if ("ROLE_PASTING_SUPERVISOR".equals(auth.getAuthority())) {
				pastingsupervisor = true;
			} else if ("ROLE_ROTERY_SUPERVISOR".equals(auth.getAuthority())) {
				roterysupervisor = true;
			} else if ("ROLE_RS4_SUPERVISOR".equals(auth.getAuthority())) {
				rs4supervisor = true;
			} else if ("ROLE_STICHING_SUPERVISOR".equals(auth.getAuthority())) {
				stichingsupervisor = true;
			} else if ("ROLE_BUNDLE_SUPERVISOR".equals(auth.getAuthority())) {
				bundlesupervisor = true;
			} else if ("ROLE_DISPATCH_SUPERVISOR".equals(auth.getAuthority())) {
				dispatchsupervisor = true;
			}
		}

		if (admin) {
			System.out.println("user is admin");
			response.sendRedirect("/admin/index");
		} else if (generalmanager) {
			System.out.println("generalmanager is user");
			response.sendRedirect("/generalmanager/index");
		} else if (manager) {
			System.out.println("manager is user");
			response.sendRedirect("/manager/index");
		} else if (corrugationsupervisor) {
			System.out.println("corrugationsupervisor is user");
			response.sendRedirect("/corrugationsupervisor/index");
		} else if (pastingsupervisor) {
			System.out.println("pastingsupervisor is user");
			response.sendRedirect("/pastingsupervisor/index");
		} else if (roterysupervisor) {
			System.out.println("roterysupervisor is user");
			response.sendRedirect("/roterysupervisor/index");
		} else if (rs4supervisor) {
			System.out.println("rs4supervisor is user");
			response.sendRedirect("/rs4supervisor/index");
		}
		else if (stichingsupervisor) {
			System.out.println("stichingsupervisor is user");
			response.sendRedirect("/stichingsupervisor/index");
		} else if (bundlesupervisor) {
			System.out.println("bundlesupervisor is user");
			response.sendRedirect("/bundlesupervisor/index");
		} else if (dispatchsupervisor) {
			System.out.println("dispatchsupervisor is user");
			response.sendRedirect("/dispatchsupervisor/index");
		} 
		else {
			System.out.println("user is anonymous");
			response.sendRedirect("/403");
		}
	}
}