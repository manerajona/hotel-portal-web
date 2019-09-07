package ar.edu.iua.portal.hotel.controller;

import ar.edu.iua.portal.hotel.entity.User;
import ar.edu.iua.portal.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{usr}/{pass}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("usr") String usuario, @PathVariable("pass") String password) {
		return this.userService.getUser(usuario, password);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User createUser(@RequestBody User user) {
		return this.userService.createUser(user);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@RequestBody PasswordForm form) {
		return this.userService.updateUser(form.getUsername(), form.getNewPassword(), form.getOldPassword());
	}

	protected static class PasswordForm {
		@NotBlank
		private String username;
		@NotBlank
		private String newPassword;
		@NotBlank
		private String oldPassword;
		@NotBlank
		private String email;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getNewPassword() {
			return newPassword;
		}

		public void setNewPassword(String newPassword) {
			this.newPassword = newPassword;
		}

		public String getOldPassword() {
			return oldPassword;
		}

		public void setOldPassword(String oldPassword) {
			this.oldPassword = oldPassword;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	}
}
