package ua.com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import ua.com.shop.entity.UkrMail;

public interface UkrMailRepository extends JpaRepository<UkrMail, Long>,
		JpaSpecificationExecutor<UkrMail> {

	@Query("SELECT a FROM UkrMail a LEFT JOIN FETCH a.city WHERE a.id=?1")
	UkrMail findOne(Long id);

	@Query("SELECT a FROM UkrMail a LEFT JOIN FETCH a.city")
	List<UkrMail> findAll();

	@Query("SELECT a FROM UkrMail a WHERE a.department=?1 AND a.city.id=?2")
	UkrMail findUnique(String department, Long CityId);

	@Modifying
	@Transactional
	@Query("update UkrMail u set u.city = null where u.city.id = ?1")
	void setNullUkrMail(Long id);
}
