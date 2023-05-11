package LTJava.S5.Ngay4.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer>{
	 @Query("SELECT u FROM User u WHERE u.UserName = ?1")
	    public User findByUserName(String UserName);
}
