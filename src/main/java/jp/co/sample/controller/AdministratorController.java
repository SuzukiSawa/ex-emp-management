package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorController {
	@Autowired
	private AdministratorService administratorService;

	@Autowired
	private HttpSession session;

	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}

	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}

	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {

		Administrator administrator = new Administrator();

		BeanUtils.copyProperties(form, administrator);

		administratorService.insert(administrator);

		return "redirect:/";
	}

	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert.html";
	}

	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login.html";
	}

	@RequestMapping("/login")
	public String login(LoginForm form, Model model) {
		
	Administrator administrator	= administratorService.login(form.getMailAddress(), form.getPassword());
		
		if (administrator == null) {
			String error="メールアドレスまたはパスワードが不正です。";
			model.addAttribute("error", error);
			return "login";
		}

		session.setAttribute("administorName", form);
		return "forward:/employee/showList";
	}
		@RequestMapping("/logout")
		public String logout() {
			
		  session.invalidate();
		
		  return "rediect:/employee/login";

	}
}
