package com.app.controller.customer;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.ApiCommonCode;
import com.app.common.CommonCode;
import com.app.dto.api.ApiResponse;
import com.app.dto.api.ApiResponseHeader;
import com.app.dto.user.User;
import com.app.dto.user.UserDupCheck;
import com.app.service.user.UserService;
import com.app.util.LoginManager;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

@Slf4j
@Controller
public class CustomerController {

	@Autowired
	UserService userService;

	@GetMapping("/customer/signup")
	public String signup() {
		return "customer/signup";
	}

	@PostMapping("/customer/signup")
	public String signupAction(@Valid @ModelAttribute User user, BindingResult br) {

		// 유효성검증!
		if (br.hasErrors()) {
			List<ObjectError> errorList = br.getAllErrors();
			for (ObjectError er : errorList) {
				System.out.println(er.getObjectName());
				System.out.println(er.getDefaultMessage());
				System.out.println(er.getCode());
				System.out.println(er.getCodes()[0]);
			}
			return "customer/signup";
		}

		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		int result = userService.saveUser(user); // DB에 user 정보 저장(가입)

		if (result == 1) {
			System.out.println("정상처리됨");
			return "redirect:/main";
		} else {
			System.out.println("저장실패");
			return "customer/signup";
		}
	}

	@ResponseBody
	@RequestMapping("/customer/checkDupId")
	public String checkDupId(@RequestBody String data) {
		System.out.println("/customer/checkDupId 요청 들어옴");
		System.out.println(data);
		log.info("{} id 중복체크 시도함", data);

		// 매개변수 data : 중복여부를 확인하고 싶은 아이디

		// id 중복 여부 체크 -> 결과 return
		boolean result = userService.isDuplicatedId(data);

		if (result) {
			return "Y중복"; // 중복이면 Y
		} else {
			return "N안중복"; // 중복아니면 N
		}
	}

	@ResponseBody
	@RequestMapping("/customer/checkDupIdJson")
	public ApiResponse<String> checkDupIdJson(@RequestBody UserDupCheck userDupCheck) {
		System.out.println("/customer/checkDupIdJson 요청 들어옴");
		System.out.println(userDupCheck);

		// 매개변수 data : 중복여부를 확인하고 싶은 아이디

		// id 중복 여부 체크 -> 결과 return
		boolean result = userService.isDuplicatedId(userDupCheck.getId());

		ApiResponse<String> apiResponse = new ApiResponse<String>();
		ApiResponseHeader header = new ApiResponseHeader();
		header.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		header.setResultMessage(ApiCommonCode.API_RESULT_SUCCESS_MSG);

		apiResponse.setHeader(header);

		if (result) {
			apiResponse.setBody("Y");
		} else {
			apiResponse.setBody("N");
		}
		return apiResponse;
	}

	@GetMapping("/customer/login")
	public String login() {
		return "customer/login";
	}

	@PostMapping("/customer/login")
	public String loginAction(User user, HttpSession session) {
		// id pw 는 전달받음 .. name userType 은 null 상태

		// user객체로 로그인 할수 있게 정보가 들어있는지 확인!

		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		User loginUser = userService.checkUserLogin(user);

		if (loginUser == null) { // 로그인 정보 안맞으니 로그인페이지로 다시 이동시킨다
			return "customer/login";
		} else { // 로그인 정보 맞으니 로그인시켜준다(페이지 이동)
					// 로그인 정보 맞으면 세션에 저장
					// session.setAttribute("loginUser", loginUser); // 로그인정보 통째로저장 (메모리용량을많이잡아먹는다)
					// session.setAttribute("loginUserId", loginUser.getId()); // 로그인된 아이디만
					// 저장(위에거보다효율적)(id가 pk일경우 해당)
			LoginManager.setSessionLogin(session, loginUser.getId()); // util(LoginManager.java) 사용한것

			return "redirect:/main";
		}
	}

	@GetMapping("/customer/logout")
	public String logout(HttpSession session) {
		// session.invalidate();
		LoginManager.logout(session); // util(LoginManager.java) 사용한것
		return "redirect:/main";
	}

	@GetMapping("/customer/mypage")
	public String mypage(HttpSession session, Model model) {
		// session 에 loginUserId 값의 존재 유무 에 따라서 마이페이지로 갈지 로그인페이지로 갈지

		// if(session.getAttribute("loginUserId") != null) { //로그인상태
		if (LoginManager.isLogin(session)) { // util(LoginManager.java) 사용한것
			// 로그인되어있는 사용자의 정보를 보여준다 model로다가
			// User user =
			// userService.findUserById((String)session.getAttribute("loginUserId"));
			User user = userService.findUserById(LoginManager.getLoginUserId(session)); // util(LoginManager.java) 사용한것
			model.addAttribute("user", user);

			return "customer/mypage";
		} else { // 로그인 안된 상태
			return "redirect:/customer/login";
		}
	}

}
