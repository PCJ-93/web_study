package com.app.controller.customer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.app.service.user.UserService;
import com.app.util.LoginManager;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class CustomerController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/customer/signup")
	public String signup() {
		return "customer/signup";
	}
	
	@PostMapping("/customer/signup")
	public String signupAction(User user) {
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		int result = userService.saveUser(user);
		if(result==1) {
			System.out.println("정상처리됨");
			return "redirect:/main";
		}else {
			System.out.println("저장실패");
			return "customer/signup";
		}
	}
	
	@GetMapping("/customer/login")
	public String login() {
		return "customer/login";
	}
	
	@PostMapping("/customer/login")
	public String loginAction(User user, HttpSession session) {
		//id pw 는 전달받음 .. name userType 은 null 상태
		
		// user객체로 로그인 할수 있게 정보가 들어있는지 확인!
		
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		User loginUser = userService.checkUserLogin(user);
		
		if(loginUser == null) { // 로그인 정보 안맞으니 로그인페이지로 다시 이동시킨다
			return "customer/login";
		}else{ // 로그인 정보 맞으니 로그인시켜준다(페이지 이동)
			// 로그인 정보 맞으면 세션에 저장
			//session.setAttribute("loginUser", loginUser); // 로그인정보 통째로저장 (메모리용량을많이잡아먹는다)
			//session.setAttribute("loginUserId", loginUser.getId()); // 로그인된 아이디만 저장(위에거보다효율적)(id가 pk일경우 해당)
			LoginManager.setSessionLogin(session, loginUser.getId()); // util(LoginManager.java) 사용한것
			
			return "redirect:/main";
		}
	}
	
	@GetMapping("/customer/logout")
	public String logout(HttpSession session) {
		//session.invalidate();
		LoginManager.logout(session); // util(LoginManager.java) 사용한것
		return "redirect:/main";
	}
	
	@GetMapping("/customer/mypage")
	public String mypage(HttpSession session, Model model) {
		// session 에 loginUserId 값의 존재 유무 에 따라서 마이페이지로 갈지 로그인페이지로 갈지
		
		//if(session.getAttribute("loginUserId") != null) { //로그인상태
		if(LoginManager.isLogin(session)) { // util(LoginManager.java) 사용한것
			//로그인되어있는 사용자의 정보를 보여준다 model로다가
			//User user = userService.findUserById((String)session.getAttribute("loginUserId"));
			User user = userService.findUserById(LoginManager.getLoginUserId(session)); // util(LoginManager.java) 사용한것
			model.addAttribute("user",user);
			
			return "customer/mypage";
		}else { //로그인 안된 상태
			return "redirect:/customer/login";
		}
	}
	
	
}















