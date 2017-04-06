package ua.com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.MainPage;

public interface MainPageRepository extends JpaRepository<MainPage, Long>,
		JpaSpecificationExecutor<MainPage> {

	@Query("SELECT m FROM MainPage m WHERE m.name = ?1 AND m.content = ?2 ")
	MainPage findUnique(String name, String content);
}
