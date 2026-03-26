package com.app.service;

import com.app.model.Product;
import com.app.repo.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddStock() {
        Product product = new Product();
        product.setProductName("Laptop");
        product.setQuantity(10);

        when(repository.save(product)).thenReturn(product);

        Product savedProduct = service.addStock(product);

        assertEquals("Laptop", savedProduct.getProductName());
        assertEquals(10, savedProduct.getQuantity());
        verify(repository, times(1)).save(product);
    }

    @Test
    void testGetProducts() {
        Product p1 = new Product();
        p1.setProductName("Laptop");
        p1.setQuantity(5);

        Product p2 = new Product();
        p2.setProductName("Phone");
        p2.setQuantity(15);

        when(repository.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<Product> products = service.getProducts();

        assertEquals(2, products.size());
        assertEquals("Laptop", products.get(0).getProductName());
        assertEquals(5, products.get(0).getQuantity());
        assertEquals("Phone", products.get(1).getProductName());
        assertEquals(15, products.get(1).getQuantity());
        verify(repository, times(1)).findAll();
    }
}
