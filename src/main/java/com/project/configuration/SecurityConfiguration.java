package com.project.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	/*
	 * @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	 */

	@Autowired
	CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;

	@Autowired
	private DataSource dataSource;

	@Value("${spring.queries.users-query}")
	private String usersQuery;

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource);
		// .passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		// The pages does not require login
		http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();

		// For ADMIN only.
		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");

		// /userInfo page requires login as ROLE_GENERAL_MANAGER
		http.authorizeRequests().antMatchers("/generalmanager/**").access("hasAnyRole('ROLE_GENERAL_MANAGER')");
		// /userInfo page requires login as ROLE_MANAGER
				http.authorizeRequests().antMatchers("/manager/**").access("hasAnyRole('ROLE_MANAGER')");
				// /userInfo page requires login as ROLE_CORRUGATION_SUPERVISOR
				http.authorizeRequests().antMatchers("/corrugationsupervisor/**").access("hasAnyRole('ROLE_CORRUGATION_SUPERVISOR')");
				// /userInfo page requires login as ROLE_PASTING_SUPERVISOR
				http.authorizeRequests().antMatchers("/pastingsupervisor/**").access("hasAnyRole('ROLE_PASTING_SUPERVISOR')");
				// /userInfo page requires login as ROLE_ROTERY_SUPERVISOR
				http.authorizeRequests().antMatchers("/roterysupervisor/**").access("hasAnyRole('ROLE_ROTERY_SUPERVISOR')");
				// /userInfo page requires login as ROLE_RS4_SUPERVISOR
				http.authorizeRequests().antMatchers("/rs4supervisor/**").access("hasAnyRole('ROLE_RS4_SUPERVISOR')");
				// /userInfo page requires login as ROLE_STICHING_SUPERVISOR
				http.authorizeRequests().antMatchers("/stichingsupervisor/**").access("hasAnyRole('ROLE_STICHING_SUPERVISOR')");
				// /userInfo page requires login as ROLE_BUNDLE_SUPERVISOR
				http.authorizeRequests().antMatchers("/bundlesupervisor/**").access("hasAnyRole('ROLE_BUNDLE_SUPERVISOR')");
				// /userInfo page requires login as ROLE_DISPATCH_SUPERVISOR
				http.authorizeRequests().antMatchers("/dispatchsupervisor/**").access("hasAnyRole('ROLE_DISPATCH_SUPERVISOR')");


		// When the user has logged in as XX.
		// But access a page that requires role YY,
		// AccessDeniedException will be thrown.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		// Config for Login Form
		http.authorizeRequests().and().formLogin()//
				// Submit URL of login page.
				.loginProcessingUrl("/j_spring_security_check") // Submit URL
				.successHandler(customizeAuthenticationSuccessHandler).loginPage("/")//
				.failureUrl("/login?error=true")//
				.usernameParameter("username")//
				.passwordParameter("password")
				
				// Config for Logout Page
				.and().logout().permitAll();

		// Config Remember Me.
		http.authorizeRequests().and() //
				.rememberMe().tokenRepository(this.persistentTokenRepository()) //
				.tokenValiditySeconds(1 * 24 * 60 * 60); // 24h

	}

	// Token stored in Memory (Of Web Server).
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
		return memory;
	}
}