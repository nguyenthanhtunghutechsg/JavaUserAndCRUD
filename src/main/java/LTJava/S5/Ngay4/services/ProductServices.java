package LTJava.S5.Ngay4.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LTJava.S5.Ngay4.models.ProductReopsitoty;
import LTJava.S5.Ngay4.models.product;

@Service
@Transactional
public class ProductServices {
	@Autowired
	private ProductReopsitoty repo;

	public List<product> listAll() {
		return repo.findAll();
	}

	public void save(product i_product) {
		repo.save(i_product);
	}
	
	public product get(Integer ID) {
		return repo.findById(ID).get();
	}
	
	public void delete(Integer ID) {
		repo.deleteById(ID);
	}

}
