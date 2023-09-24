package com.jangir.ecom.ecommerce.repositories;

import com.jangir.ecom.ecommerce.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
