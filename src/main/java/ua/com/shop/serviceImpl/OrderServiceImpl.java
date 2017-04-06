package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.CommodityFilter;
import ua.com.shop.dto.filter.OrderFilter;
import ua.com.shop.entity.Chalk;
import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.Glove;
import ua.com.shop.entity.HoldersChalk;
import ua.com.shop.entity.MotherInLaw;
import ua.com.shop.entity.Order;
import ua.com.shop.entity.ProductCare;
import ua.com.shop.entity.Sticker;
import ua.com.shop.entity.Tube;
import ua.com.shop.repository.OrderRepository;
import ua.com.shop.service.OrderService;
import ua.com.shop.specification.CommoditySpecification;
import ua.com.shop.specification.OrderSpecification;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void save(Order order) {
		orderRepository.save(order);
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order findOne(Long orderId) {
		return orderRepository.findOne(orderId);
	}

	@Override
	public List<Glove> findGloveInOrder(Long orderId) {
		return orderRepository.findGloveInOrder(orderId);
	}

	@Override
	public List<Commodity> findCommodityInOrder(Long orderId) {
		return orderRepository.findCommodityInOrder(orderId);
	}

	@Override
	public List<Tube> findTubeInOrder(Long orderId) {
		return orderRepository.findTubeInOrder(orderId);
	}

	@Override
	public List<Chalk> findChalkInOrder(Long orderId) {
		return orderRepository.findChalkInOrder(orderId);
	}

	@Override
	public List<HoldersChalk> findHoldersChalkInOrder(Long orderId) {
		return orderRepository.findHoldersChalkInOrder(orderId);
	}

	@Override
	public List<MotherInLaw> findMotherinLawInOrder(Long orderId) {
		return orderRepository.findMotherinLawInOrder(orderId);
	}

	@Override
	public List<ProductCare> findProductCaresInOrder(Long orderId) {
		return orderRepository.findProductCaresInOrder(orderId);
	}

	@Override
	public List<Sticker> findStickersInOrder(Long orderId) {
		return orderRepository.findStickersInOrder(orderId);
	}
}
