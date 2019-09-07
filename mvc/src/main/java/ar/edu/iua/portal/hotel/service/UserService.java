package ar.edu.iua.portal.hotel.service;

import ar.edu.iua.portal.hotel.dao.UserDao;
import ar.edu.iua.portal.hotel.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	@Qualifier("userDaoImpl")
	private UserDao userDao;

	public User getUser(Long id) {
		return this.userDao.getUser(id);
	}

	public User getUser(String user, String password) {
		return this.userDao.getUser(user, password);
	}

	public User updateUser(String username, String newPassword, String oldPassword) {
		return this.userDao.updateUser(username, newPassword, oldPassword);
	}

	public User createUser(User user) {
		return this.userDao.createUser(user);
	}
}
