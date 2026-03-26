package com.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.app.model.StockRequest;
import com.app.repo.StockRequestRepository;

class StockRequestServiceTest {

	@Mock
	private StockRequestRepository repository;

	@InjectMocks
	private StockRequestService service;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testRequestStock() {
		StockRequest request = new StockRequest();
		request.setProductName("Laptop");
		request.setQuantity(10);
		request.setUsername("john_doe");

		when(repository.save(request)).thenReturn(request);

		StockRequest savedRequest = service.requestStock(request);

		assertEquals("PENDING", savedRequest.getStatus());
		assertEquals("Laptop", savedRequest.getProductName());
		assertEquals(10, savedRequest.getQuantity());
		assertEquals("john_doe", savedRequest.getUsername());
		verify(repository, times(1)).save(request);
	}

	@Test
	void testGetAllRequests() {
		StockRequest req1 = new StockRequest();
		req1.setProductName("Laptop");
		req1.setQuantity(5);
		req1.setStatus("PENDING");

		StockRequest req2 = new StockRequest();
		req2.setProductName("Phone");
		req2.setQuantity(15);
		req2.setStatus("APPROVED");

		when(repository.findAll()).thenReturn(Arrays.asList(req1, req2));

		List<StockRequest> requests = service.getAllRequests();

		assertEquals(2, requests.size());
		assertEquals("Laptop", requests.get(0).getProductName());
		assertEquals(5, requests.get(0).getQuantity());
		assertEquals("Phone", requests.get(1).getProductName());
		assertEquals(15, requests.get(1).getQuantity());
		verify(repository, times(1)).findAll();
	}

}
