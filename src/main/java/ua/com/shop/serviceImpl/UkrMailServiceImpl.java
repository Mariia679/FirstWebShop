package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.shop.dto.filter.UkrMailFilter;
import ua.com.shop.entity.City;
import ua.com.shop.entity.UkrMail;
import ua.com.shop.repository.UkrMailRepository;
import ua.com.shop.service.UkrMailService;
import ua.com.shop.specification.UkrMailSpecification;

@Service
public class UkrMailServiceImpl implements UkrMailService {

	@Autowired
	private UkrMailRepository ukrMailRepository;

	public List<UkrMail> findAll() {
		return ukrMailRepository.findAll();
	}

	public UkrMail findOne(Long id) {
		return ukrMailRepository.findOne(id);
	}

	public void delete(Long id) {
		ukrMailRepository.delete(id);
	}

	public void save(UkrMail ukrMail) {
		ukrMailRepository.save(ukrMail);
	}

	public UkrMail findUnique(String department, City city) {
		return ukrMailRepository.findUnique(department, city.getId());
	}

	@Override
	@Transactional
	@Modifying
	public void setNullUkrMail(Long id) {
		ukrMailRepository.setNullUkrMail(id);
	}

	@Override
	public Page<UkrMail> findAll(UkrMailFilter filter, Pageable pageable) {
		return ukrMailRepository.findAll(new UkrMailSpecification(filter),
				pageable);
	}
}
