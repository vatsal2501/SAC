package com.project.utils;

import org.eclipse.jdt.internal.compiler.classfmt.ClassFileStruct;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class BaseMethods {

	public static String getUsername() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user.getUsername();
	}
	
	/*
	 * public static void setCreatedBy() { BaseMethods.cast(); }
	 */
	
	private static <T extends Object> T cast(Object obj) {
	    return (T) obj;
	    
	}
}
