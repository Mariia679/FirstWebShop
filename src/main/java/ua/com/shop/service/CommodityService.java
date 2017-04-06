package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

public interface CommodityService {

	void save(CommodityForm t);

	List<Commodity> findAll();

	Commodity findOne(Long id);

	void delete(Long id);

	CommodityForm findForm(Long id);

	Commodity findUnique(Butt butt, CarvingJoint carvingJoint,
			Category category, Damper damper, Ferula ferula, GashType gashType,
			String length, MainMaterial mainMaterial,
			MaterialJoint materialJoint, String name, String price,
			RingBumper ringBumper, RingEnd ringEnd, Shaft shaft,
			Sticker sticker, TypeSticker typeSticker, String weight, Wood wood);

	Long findCount(Long id);

	List<Commodity> findByUserId(Long userId);
	
	List<Commodity> findByOrderId(Long userId);

	void setNullButt(Long id);

	void setNullCarvingJoint(Long id);

	void setNullCategory(Long id);

	void setNullDamper(Long id);

	void setNullFerula(Long id);

	void setNullGashType(Long id);

	void setNullMainMaterial(Long id);

	void setNullMaterialJoint(Long id);

	void setNullRingBumper(Long id);

	void setNullRingEnd(Long id);

	void setNullShaft(Long id);

	void setNullSticker(Long id);

	void setNullTypeSticker(Long id);

	void setNullWood(Long id);

	Page<Commodity> findAll(Pageable pageable, CommodityFilter filter);

	Commodity save(Commodity commodity);

//	List<Commodity> findPopular();

	void countByPopular(Long commodityId);

	Page<Commodity> findAll(Pageable pageable);

}