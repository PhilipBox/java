package edu.ssafy.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.boot.dto.MemDTO;
import edu.ssafy.boot.exception.MyException;
import edu.ssafy.boot.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@ExceptionHandler(Exception.class)
	public String allException(Exception e, HttpServletRequest req) {
		req.setAttribute("message", e.getMessage());
		return "allErrorPage";
	}

	@ExceptionHandler(MyException.class)
	public String myException(Exception e, HttpServletRequest req) {
		req.setAttribute("message", e.getMessage());
		return "myerrorpage";
	}

	@Autowired
	@Qualifier("MemberServiceImpl")
	MemberService ser;

	@RequestMapping("/memregpage")
	public String memregpage() {
		return "member/memreg";
	}

	@RequestMapping("/goindex")
	public String goindex() {
		return "index";
	}	
	
	@RequestMapping("/memreg")
	public ModelAndView memReg(HttpServletRequest req, ModelAndView mv) throws MyException {
		String num = req.getParameter("num");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		try {
			int insert = ser.insert(num, pw, name, tel);
			mv.addObject("cnt", insert);
			mv.setViewName("redirect:goindex");
		} catch (RuntimeException e) {
			mv.addObject("message" ,e.getMessage());
			mv.setViewName("allErrorPage");
		}
		return mv;
	}

	@RequestMapping("/memlist")
	public ModelAndView memList(ModelAndView mv) {
		try {
			List<MemDTO> list = ser.selectList();
			mv.addObject("mems", list);
			mv.setViewName("member/memlist");
		} catch (RuntimeException e) {
			mv.addObject("message" ,e.getMessage());
			mv.setViewName("allErrorPage");
		}
		return mv;
	}

	@RequestMapping("/memview")
	public ModelAndView memView(@RequestParam("num") String num, ModelAndView mv) {
		try {
			MemDTO mem = ser.selectOne(num);
			mv.addObject("mem", mem);
			mv.setViewName("member/memview");
		} catch (RuntimeException e) {
			mv.addObject("message" ,e.getMessage());
			mv.setViewName("allErrorPage");
		}
		return mv;
	}

	@RequestMapping("/memdelete")
	public ModelAndView memDelete(@RequestParam("num") String num, ModelAndView mv) {
		try {
			ser.delete(num);
			mv.setViewName("redirect:memlist");
		} catch (RuntimeException e) {
			mv.addObject("message" ,e.getMessage());
			mv.setViewName("allErrorPage");
		}
		return mv;
	}

	@RequestMapping("/memupdate")
	public ModelAndView memUpdate(MemDTO mem, ModelAndView mv) {
		try {
			ser.update(mem.getNum(), mem.getPw(), mem.getName(), mem.getTel());
			mv.setViewName("redirect:memlist");
		} catch (RuntimeException e) {
			mv.addObject("message" ,e.getMessage());
			mv.setViewName("allErrorPage");
		}
		return mv;
	}

	@RequestMapping("/memlogin")
	public ModelAndView memLogin(HttpServletRequest req, ModelAndView mv) {
		HttpSession session = req.getSession();

		String tID = req.getParameter("loginID");
		String tPW = req.getParameter("loginPW");
		System.out.println("로그인 시도 ID: " + tID);
		System.out.println("로그인 시도 PW: " + tPW);

		boolean res = ser.login(tID, tPW);
		if (res) {
			session.setAttribute("loginID", tID);
			System.out.println("로그인성공 : " + tID);
			mv.setViewName("redirect:memlist");
		} else {
			System.out.println("로그인실패");
			mv.setViewName("redirect:index.jsp");
		}
		return mv;
	}

	@RequestMapping("/memlogout")
	public ModelAndView logout(HttpServletRequest req, ModelAndView mv) {
		HttpSession session = req.getSession();
		session.invalidate();
		mv.setViewName("redirect:goindex");
		return mv;
	}

}
