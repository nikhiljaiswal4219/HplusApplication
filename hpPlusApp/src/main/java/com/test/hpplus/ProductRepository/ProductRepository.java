package com.test.hpplus.ProductRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.hpplus.Beans.Product;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer>{

	@Query("select p from Product p where p.name like %:name%")
	public List<Product> searchByName(@Param("name") String name);
}
