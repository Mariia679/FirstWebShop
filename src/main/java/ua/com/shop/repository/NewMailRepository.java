package ua.com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import ua.com.shop.entity.NewMail;

public interface NewMailRepository extends JpaRepository<NewMail, Long>,
		JpaSpecificationExecutor<NewMail> {

	@Query("SELECT a FROM NewMail a LEFT JOIN FETCH a.city WHERE a.id=?1")
	NewMail findOne(Long id);

	@Query("SELECT a FROM NewMail a LEFT JOIN FETCH a.city")
	List<NewMail> findAll();

	@Query("SELECT a FROM NewMail a WHERE a.department=?1 AND a.city.id=?2")
	NewMail findUnique(String department, Long cityId);

	@Modifying
	@Transactional
	@Query("update NewMail n set n.city = null where n.city.id = ?1")
	void setNullNewMail(Long id);

}
