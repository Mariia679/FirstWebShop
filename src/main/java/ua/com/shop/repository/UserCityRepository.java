//package ua.com.shop.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import ua.com.shop.entity.UserCity;
//
//public interface UserCityRepository extends JpaRepository<UserCity, Long> {
//
//	@Query("SELECT a FROM UserCity a LEFT JOIN FETCH a.user LEFT JOIN FETCH a.city WHERE a.id=?1")
//	UserCity findOne(Long id);
//}
