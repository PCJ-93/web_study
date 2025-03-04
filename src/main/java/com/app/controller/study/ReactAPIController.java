package com.app.controller.study;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.study.DrinkItem;
import com.app.dto.study.Member;
import com.app.util.JwtProvider;
import com.app.util.LoginManager;

@RestController
public class ReactAPIController {
	
	@GetMapping("/api/getMsg")
	public String apiGetMsg() {
		System.out.println("/api/getMsg 요청들어옴");
		return "welcome~";
	}
	
	@GetMapping("/api/getDrinks")
	public List<DrinkItem> getDrinks(){
		
		List<DrinkItem> drinkList = new ArrayList<DrinkItem>();
		
		drinkList.add(new DrinkItem("아메리카노","커피"));
		drinkList.add(new DrinkItem("카페라떼","커피"));
		drinkList.add(new DrinkItem("콜라","탄산음료"));
		
		return drinkList;
	}
	
	@GetMapping("/api/getDrinksDiv")
	public List<DrinkItem> getDrinksDiv(HttpServletRequest request){
		List<DrinkItem> drinkList = new ArrayList<DrinkItem>();
		String type = request.getParameter("type");
		if(type != null) {
			if(type.equals("커피")) {
				drinkList.add(new DrinkItem("아메리카노","커피"));
				drinkList.add(new DrinkItem("카페라떼","커피"));
			}
			if(type.equals("탄산음료")) {
				drinkList.add(new DrinkItem("콜라","탄산음료"));
				drinkList.add(new DrinkItem("사이다","탄산음료"));
				drinkList.add(new DrinkItem("웰치스","탄산음료"));
			}
		}
		return drinkList;
	}
	
	@PostMapping("/api/getDrinksItem")
	public List<DrinkItem> getDrinksItem(@RequestBody DrinkItem drinkItem){
		List<DrinkItem> drinkList = new ArrayList<DrinkItem>();
		
//		System.out.println(bodyText);
		System.out.println(drinkItem);
		System.out.println(drinkItem.getItem());
		System.out.println(drinkItem.getType());
		
		return drinkList;
	}
	
	@PostMapping("/api/getDrinksNum")
	public List<DrinkItem> getDrinksNum(@RequestBody String num){
		System.out.println(num);
		List<DrinkItem> drinkList = new ArrayList<DrinkItem>();
		
		drinkList.add(new DrinkItem("item" + num, "type" + num));
		
		return drinkList;
	}
	
	@PostMapping("/api/login")
	public String login(@RequestBody Member member, HttpServletRequest request) {
		System.out.println("id: " + member.getId());
		System.out.println("pw: " + member.getPw());
		
		//id pw -> db select 비교
		//성공 or 실패
		
		//지금은 로그인 성공으로 간주하고 테스트
		LoginManager.setSessionLogin(request, member.getId());
		//member.getId()로그인 성공 해서 ssesion id 저장
		
		return "ok";
	}
	
	@PostMapping("/api/loginCheck")
	public String lgoinCheck(HttpServletRequest request) {
		
		if(LoginManager.isLogin(request)) {
			String loginId = LoginManager.getLoginUserId(request);
			System.out.println(loginId);
			
			return loginId + " logon";
		}else {
			return "Not login";
		}
	}
	
	@PostMapping("/api/loginJWT")
	public String loginJWT(@RequestBody Member member, HttpServletRequest request) {
		
		//member 값 db 비교 -> 로그인 정상 여부
		
		// 로그인 성공했다고 간주하고 테스트
		// jwt accesstoken 발행 -> fe 전달
		String accessToken = JwtProvider.createAccessToken(member.getId()); //스트링으로된 토큰 발행
		System.out.println("로그인아이디 : " + member.getId());
		System.out.println("발행 accessToken : " + accessToken);
		
		return accessToken;
		
		// accessToken 만 전달
		// header, body
		// header : code, msg
		// body : accessToken, userId, userType, userName, userEmail ...
	}
	
	@PostMapping("/api/loginCheckJWT")
	public String lgoinCheckJWT(HttpServletRequest request) {
		
		// token 열어보고 -> 유효한 토큰인지 -> 누가 로그인했는지 -> 로직실행(db정보조회) -> return
		String accessToken = JwtProvider.extractToken(request);
		
		if(accessToken == null ) { //인증 없음!
			return "no";  // 원래는 ApiResponse형식으로 정리해서 보내야한다
		}
		System.out.println("accessToken : " + accessToken);
		System.out.println(JwtProvider.isVaildToken(accessToken)); //유효한 토큰이냐?
		if(JwtProvider.isVaildToken(accessToken)) {
			String userId = JwtProvider.getUserIdFromToken(accessToken);
			System.out.println("토큰에 들어있는 id : " + userId);
		}
		
		return "ok";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
