package ua.com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import ua.com.shop.entity.Order;
import ua.com.shop.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findOne(Long id);

	User findByUsername(String username);

	@Query("SELECT u FROM User u WHERE u.email = ?1 AND u.username = ?2 ")
	User findUnique(String email, String username);

	User findByEmail(String email);

	User findById(Long id);

	@Modifying
	@Transactional
	@Query("update User u set u.username = ?1 where u.id = ?2")
	void setNameToUser(String username, Long id);

	@Modifying
	@Transactional
	@Query("UPDATE User u SET u.name = ?1, u.surname=?2, u.email=?3, u.phone=?4 WHERE u.id = ?5")
	void updateUser(String name, String surname, String email, String phone, 
			Long id);

}
