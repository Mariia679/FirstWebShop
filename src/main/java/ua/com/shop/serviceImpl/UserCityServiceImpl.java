//package ua.com.shop.serviceImpl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import ua.com.shop.entity.UserCity;
//import ua.com.shop.repository.UserCityRepository;
//import ua.com.shop.service.UserCityService;
//
//@Service
//public class UserCityServiceImpl implements UserCityService {
//
//	@Autowired
//	private UserCityRepository userCityRepository;
//
//	public void save(UserCity t) {
//		userCityRepository.save(t);
//	}
//
//	public List<UserCity> findAll() {
//		return userCityRepository.findAll();
//	}
//
//	public UserCity findOne(Long id) {
//		return userCityRepository.findOne(id);
//	}
//
//	public void delete(Long id) {
//		userCityRepository.delete(id);
//
//	}
//
//}
