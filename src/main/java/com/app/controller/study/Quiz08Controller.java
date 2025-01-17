package com.app.controller.study;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Quiz08Controller {

	@GetMapping("/quiz/session/login")
	public String login() {
		return "quiz/session/login";
	}

	@PostMapping("/quiz/session/login")
	public ModelAndView login(@RequestParam String id, @RequestParam String pw, HttpSession session) {
		if (id != null && !id.isEmpty()) {
			session.setAttribute("userId", id);
			session.setAttribute("count", 0);
		}
		return new ModelAndView("redirect:/quiz/session/count");
	}

	@GetMapping("/quiz/session/count")
	public ModelAndView count(HttpSession session) {
		ModelAndView mav = new ModelAndView("quiz/session/count");

		String userId = (String) session.getAttribute("userId");
		Integer count = (Integer) session.getAttribute("count");

		if (userId == null) {
			
		} else {
			count = (count == null ? 0 : count + 1);
			session.setAttribute("count", count);

			mav.addObject("userId", userId);
			mav.addObject("count", count);
		}

		return mav;
	}

	@GetMapping("/quiz/session/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:/quiz/session/count");
	}
}
