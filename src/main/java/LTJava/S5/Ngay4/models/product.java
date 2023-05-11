//`id` int(11) NOT NULL AUTO_INCREMENT,
//  `name` varchar(45) NOT NULL,
//  `brand` varchar(45) NOT NULL,
//  `madein` varchar(45) NOT NULL,
//  `price` float NOT NULL,
package LTJava.S5.Ngay4.models;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false,unique = true,length = 255)
	private String name;
	@Column(nullable = false,length = 255)
	private String brand;
	@Column(nullable = false,length = 255)
	private String madein;
	@Column(nullable = false)
	private Float price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMadein() {
		return madein;
	}

	public void setMadein(String madein) {
		this.madein = madein;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public product(Integer id, String name, String brand, String madein, float price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.madein = madein;
		this.price = price;
	}

	public product() {

	}
}
