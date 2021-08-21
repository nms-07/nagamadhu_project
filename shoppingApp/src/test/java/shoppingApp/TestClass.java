package shoppingApp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.app.addProduct.service.impl.ProductAddServiceImpl;
import com.app.customerRegister.service.impl.CustomerRegisterServiceImpl;
import com.app.dao.impl.AddProductToCartDAOImpl;
import com.app.dao.impl.CustomerLoginDAOImpl;
import com.app.dao.impl.CustomerSearchDAOImpl;
import com.app.dao.impl.MarkAsShippedDAOImpl;
import com.app.dao.impl.PlaceAnOrderDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Customer;
import com.app.model.Employee;
import com.app.model.Order;
import com.app.model.OrderId;
import com.app.model.Product;
import com.app.service.impl.AddProductToCartServiceImpl;
import com.app.service.impl.MarkOrderStatusServiceImpl;

class TestClass {
	
	private static Logger log = Logger.getLogger(TestClass.class);
	
	Employee employee = new Employee();

	@Test
	public void testValidate() { 			//checking for valid details
		assertEquals(1,employee.employeValidate("nagamadhu@gmail.com", "nagamadhu"));
	}
	
	@Test
	public void testValid() {				//not valid
		assertEquals(1,employee.employeValidate("madhu@gmail.com", "nagamadhu"));
		
	}
	
	
	CustomerLoginDAOImpl obj = new CustomerLoginDAOImpl();
	
	@Test
	public void testCustomerLogin() {
		try {
			boolean result = true;
			assertEquals(result,obj.customerLogin("madhu@gmail.com", "as@AS1cgrr"));
		} catch (BusinessException e) {
			fail(e.getMessage());
		}
	}
	
	

	
	
	CustomerSearchDAOImpl customerSearch = new CustomerSearchDAOImpl();
	Customer customer = new Customer();
	
	@Test
	public void testCustomerSearchById() {
		try {
			int id = 1;
			assertNotNull(customerSearch.getCustomerById(id));
		} catch (BusinessException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCustomerSearchByName() {
		try {
			assertNotNull(customerSearch.getCustomerByName("madhu"));
		} catch (BusinessException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCustomerSearchByEmail() {
		try {
			assertNotNull(customerSearch.getCustomerByEmail("madhu@gmail.com"));
		} catch (BusinessException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCustomerSearchByOrderId() {
		try {
			int id = 1;
			assertNotNull(customerSearch.getCustomerByOrderId(id));
		} catch (BusinessException e) {
			fail(e.getMessage());
		}
	}
	
	

	
	
	MarkAsShippedDAOImpl markShipped = new MarkAsShippedDAOImpl();
	
	@Test
	public void testMarkShipped() {
		Order order = new Order();
		order.setOrderId(10);
		try {
			assertEquals(1,markShipped.markDelivered(order));
		} catch (BusinessException e) {
			fail(e.getMessage());
		}
	}
	
	
	MarkOrderStatusServiceImpl customerOrderStatus = new MarkOrderStatusServiceImpl();
	
	@Test
	public void testMarkOrderStatus() {
		Order order = new Order();
		order.setOrderId(8);
		try {
			assertEquals(1, customerOrderStatus.markOrderStatus(order));
		} catch (BusinessException e) {
			fail(e.getMessage());
		}
	}
	
	
	ProductAddServiceImpl productAdd = new ProductAddServiceImpl();
	
	@Test
	public void testProductAdd() {
		Product product = new Product();
		product.setId(1212);
		product.setName("Mouse");
		product.setManufacturer("Logitech");
		product.setCost(20000);
		try {
			assertEquals(1,productAdd.addProduct(product));
		} catch (BusinessException e) {
			fail(e.getMessage());
		}
	}
	
	
	CustomerRegisterServiceImpl customerRegister = new CustomerRegisterServiceImpl();
	
	@Test
	public void testCustomerRegister() {
		Customer customer = new Customer();
		customer.setCustomerId(41);
		customer.setCustomerEmail("nmadh@gmail.com");
		customer.setCustomerName("Madhu");
		customer.setCustomerPassword("Q19@ghjd");
		try {
			assertEquals(0,customerRegister.registerCustomer(customer));
		} catch (BusinessException e) {
			fail(e.getMessage());
		}
	}
	
}
