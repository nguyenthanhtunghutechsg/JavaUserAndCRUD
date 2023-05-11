package LTJava.S5.Ngay4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import LTJava.S5.Ngay4.models.ProductReopsitoty;
import LTJava.S5.Ngay4.models.product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProductRepositoryTest {
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private ProductReopsitoty repo;
	
	@Test
	public void testCreateProduct() {
		product i_product = new product();
		i_product.setName("Non Bao Hiem");
		i_product.setBrand("Non Son");
		i_product.setMadein("Viet Nam");
		i_product.setPrice(100000.0f);
		repo.save(i_product);
		product existproduct = testEntityManager.find(product.class, i_product.getId());
		assertThat(i_product.getName()).isEqualTo(existproduct.getName());
		
	}
}
