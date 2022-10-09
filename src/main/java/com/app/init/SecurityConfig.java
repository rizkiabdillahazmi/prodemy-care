package com.app.init;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.service.CustomUserDetailService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	static UserDetailsService userDetailsService = null;
	static DaoAuthenticationProvider authenticationProvider = null;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};

	@Bean
	public UserDetailsService userDetailsService() {
		if (userDetailsService == null) {
			userDetailsService = new CustomUserDetailService();
		}
		return userDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				// .authorizeRequests()
				// .antMatchers("/", "/home").permitAll() // (3)
				// .anyRequest().authenticated() // (4)
				// .and()
				// .formLogin() // (5)
				// .loginPage("/login") // (5)
				// .permitAll()
				// .and()
				// .logout() // (6)
				// .permitAll()
				// .and()
				// .httpBasic(); // (7)

				// .authorizeRequests()
				// .antMatchers("/", "/public/**", "/assets/**", "/static/**", "/resources/**",
				// "/admincoba/**")
				// .permitAll() // (3)
				// .anyRequest().authenticated() // (4)
				// .and()

				// .formLogin()
				// .loginPage("/login")
				// .failureUrl("/login-error")
				// .and()
				// .logout()
				// .logoutSuccessUrl("/");

				.formLogin()
				.loginPage("/login")
				.failureUrl("/?error=1")
				.defaultSuccessUrl("/user")
				.loginProcessingUrl("/login")
				.usernameParameter("userid")
				.passwordParameter("password")
				.and()
				.headers()
				.frameOptions().sameOrigin()
				.httpStrictTransportSecurity().disable()
				.and()
				.csrf().disable()
				.logout()
				.logoutUrl("/logout")
				.and()

				.authorizeRequests()
				.antMatchers(
						"/",
						"/about",
						"/donasi",
						"/donasi/**",
						"/login",
						"/register",
						"/accessdenied",
						"/resources/**")
				.permitAll()
				.anyRequest().authenticated()
				.and()

				.exceptionHandling()
				.accessDeniedPage("/accessdenied");

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/assets**", "/dandelion-assets/**", "/resources/**", "/donasi");
	}
}
