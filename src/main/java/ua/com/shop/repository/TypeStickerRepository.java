package ua.com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.TypeSticker;

public interface TypeStickerRepository extends
		JpaRepository<TypeSticker, Long>,
		JpaSpecificationExecutor<TypeSticker> {

	TypeSticker findByName(String name);

}
