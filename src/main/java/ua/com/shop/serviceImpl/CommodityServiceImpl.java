package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.dto.filter.CommodityFilter;
import ua.com.shop.dto.form.CommodityForm;
import ua.com.shop.entity.Butt;
import ua.com.shop.entity.CarvingJoint;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.Damper;
import ua.com.shop.entity.Ferula;
import ua.com.shop.entity.GashType;
import ua.com.shop.entity.MainMaterial;
import ua.com.shop.entity.MaterialJoint;
import ua.com.shop.entity.RingBumper;
import ua.com.shop.entity.RingEnd;
import ua.com.shop.entity.Shaft;
import ua.com.shop.entity.Sticker;
import ua.com.shop.entity.TypeSticker;
import ua.com.shop.entity.Wood;
import ua.com.shop.repository.CommodityRepository;
import ua.com.shop.service.CommodityService;
import ua.com.shop.service.FileWriter;
import ua.com.shop.service.FileWriter.Folder;
import ua.com.shop.specification.CommoditySpecification;

@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityRepository commodityRepository;

	@Autowired
	private FileWriter fileWriter;

	@Override
	public void save(CommodityForm form) {
		Commodity entity = new Commodity();
		entity.setButt(form.getButt());
		entity.setDescription(form.getDescription());
		entity.setCarvingJoint(form.getCarvingJoint());
		entity.setCategory(form.getCategory());
		entity.setDamper(form.getDamper());
		entity.setFerula(form.getFerula());
		entity.setGashType(form.getGashType());
		entity.setId(form.getId());
		entity.setLength(form.getLength());
		entity.setMainMaterial(form.getMainMaterial());
		entity.setMaterialJoint(form.getMaterialJoint());
		entity.setName(form.getName());
		entity.setPrice(new Integer(form.getPrice()));
		entity.setRingBumper(form.getRingBumper());
		entity.setRingEnd(form.getRingEnd());
		entity.setShaft(form.getShaft());
		entity.setSticker(form.getSticker());
		entity.setTypeSticker(form.getTypeSticker());
		entity.setWeight(form.getWeight());
		entity.setWood(form.getWood());
		entity.setFile(form.getFile());
		entity.setVersion(form.getVersion());
		MultipartFile file = entity.getFile();
		entity = commodityRepository.saveAndFlush(entity);
		if (fileWriter.write(Folder.COMMODITY, file, entity.getId())) {
			entity.setVersion(entity.getVersion() + 1);
			commodityRepository.save(entity);
		}
	}

	@Override
	public List<Commodity> findAll() {
		return commodityRepository.findAll();
	}

	@Override
	public Commodity findOne(Long id) {
		return commodityRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		commodityRepository.delete(id);
	}

	@Override
	public Long findCount(Long id) {
		Long count = commodityRepository.findCount(id);
		if (count == null)
			return 0L;
		return count;
	}

	@Override
	public List<Commodity> findByUserId(Long userId) {
		return commodityRepository.findByUserId(userId);
	}

	// Method used for validation
	@Override
	public Commodity findUnique(Butt butt, CarvingJoint carvingJoint,
			Category category, Damper damper, Ferula ferula, GashType gashType,
			String length, MainMaterial mainMaterial,
			MaterialJoint materialJoint, String name, String price,
			RingBumper ringBumper, RingEnd ringEnd, Shaft shaft,
			Sticker sticker, TypeSticker typeSticker, String weight, Wood wood) {

		return commodityRepository.findUnique(butt.getId(),
				carvingJoint.getId(), category.getId(), damper.getId(),
				ferula.getId(), gashType.getId(), length, mainMaterial.getId(),
				name, new Integer(price), ringBumper.getId(), ringEnd.getId(),
				shaft.getId(), sticker.getId(), typeSticker.getId(), weight,
				wood.getId());
	}

	// Method used for validation
	@Override
	public CommodityForm findForm(Long id) {
		Commodity entity = findOne(id);
		CommodityForm form = new CommodityForm();
		form.setButt(entity.getButt());
		form.setCarvingJoint(entity.getCarvingJoint());
		form.setCategory(entity.getCategory());
		form.setDamper(entity.getDamper());
		form.setFerula(entity.getFerula());
		form.setGashType(entity.getGashType());
		form.setId(entity.getId());
		form.setLength(entity.getLength());
		form.setMainMaterial(entity.getMainMaterial());
		form.setMaterialJoint(entity.getMaterialJoint());
		form.setName(entity.getName());
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setRingBumper(entity.getRingBumper());
		form.setRingEnd(entity.getRingEnd());
		form.setShaft(entity.getShaft());
		form.setSticker(entity.getSticker());
		form.setTypeSticker(entity.getTypeSticker());
		form.setWeight(entity.getWeight());
		form.setWood(entity.getWood());
		form.setFile(entity.getFile());
		form.setVersion(entity.getVersion());
		return form;
	}

	/*
	 * Set null to record of entity Commodity
	 * 
	 * @Transactional -
	 */

	@Override
	@Transactional
	@Modifying
	public void setNullButt(Long id) {
		commodityRepository.setNullButt(id);
	}

	@Override
	@Transactional
	@Modifying
	public void setNullCarvingJoint(Long id) {
		commodityRepository.setNullCarvingJoint(id);
	}

	@Override
	@Transactional
	@Modifying
	public void setNullCategory(Long id) {
		commodityRepository.setNullCategory(id);
	}

	@Override
	@Transactional
	@Modifying
	public void setNullDamper(Long id) {
		commodityRepository.setNullDamper(id);
	}

	@Override
	@Transactional
	@Modifying
	public void setNullFerula(Long id) {
		commodityRepository.setNullFerula(id);
	}

	@Override
	@Transactional
	@Modifying
	public void setNullGashType(Long id) {
		commodityRepository.setNullGashType(id);
	}

	@Override
	@Transactional
	@Modifying
	public void setNullMaterialJoint(Long id) {
		commodityRepository.setNullMaterialJoint(id);
	}

	@Override
	@Transactional
	@Modifying
	public void setNullRingBumper(Long id) {
		commodityRepository.setNullRingBumper(id);
	}

	@Override
	@Transactional
	@Modifying
	public void setNullRingEnd(Long id) {
		commodityRepository.setNullRingEnd(id);
	}

	@Override
	@Transactional
	@Modifying
	public void setNullShaft(Long id) {
		commodityRepository.setNullShaft(id);
	}

	@Override
	@Transactional
	@Modifying
	public void setNullSticker(Long id) {
		commodityRepository.setNullSticker(id);
	}

	@Override
	@Transactional
	@Modifying
	public void setNullTypeSticker(Long id) {
		commodityRepository.setNullTypeSticker(id);
	}

	@Override
	@Transactional
	@Modifying
	public void setNullWood(Long id) {
		commodityRepository.setNullWood(id);
	}

	@Override
	@Transactional
	@Modifying
	public void setNullMainMaterial(Long id) {
		commodityRepository.setNullMainMaterial(id);
	}

	@Override
	public Page<Commodity> findAll(Pageable pageable, CommodityFilter filter) {
		return commodityRepository.findAll(new CommoditySpecification(filter),
				pageable);
	}

	@Override
	public Commodity save(Commodity commodity) {
		return commodityRepository.save(commodity);
	}


	@Modifying
	@Transactional
	@Override
	public void countByPopular(Long commodityId) {
		Commodity commodity = commodityRepository.findOne(commodityId);
		int count = commodity.addCount();
		commodityRepository.addCount(count, commodityId);
	}

	@Override
	public List<Commodity> findByOrderId(Long userId) {
		return commodityRepository.findByOrderId(userId);
	}

	@Override
	public Page<Commodity> findAll(Pageable pageable) {
		return commodityRepository.findAll(new PageRequest(0, 4));
	}

}