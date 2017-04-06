package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.shop.dto.filter.NewMailFilter;
import ua.com.shop.entity.City;
import ua.com.shop.entity.NewMail;
import ua.com.shop.repository.NewMailRepository;
import ua.com.shop.service.NewMailService;
import ua.com.shop.specification.NewMailSpecification;

@Service
public class NewMailServiceImpl implements NewMailService {
	
	@Autowired
	private NewMailRepository newMailRepository;

	public List<NewMail> findAll() {
		return newMailRepository.findAll();
	}

	public NewMail findOne(Long id) {
		return newMailRepository.findOne(id);
	}

	public void delete(Long id) {
		newMailRepository.delete(id);
	}

	public void save(NewMail newMail) {
		newMailRepository.save(newMail);

	}

	public NewMail findUnique(String department, City city) {
		return newMailRepository.findUnique(department, city.getId());
	}

	@Override
	@Transactional
	@Modifying
	public void setNullNewMail(Long id) {
		newMailRepository.setNullNewMail(id);
	}

	@Override
	public Page<NewMail> findAll(Pageable pageable, NewMailFilter filter) {
		return newMailRepository.findAll(new NewMailSpecification(filter),
				pageable);
	}

}
