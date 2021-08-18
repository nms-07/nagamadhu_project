package com.app;
import java.util.List;
import java.util.regex.*;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.addProduct.service.impl.ProductAddServiceImpl;
import com.app.customerRegister.service.impl.CustomerRegisterServiceImpl;
import com.app.dao.CustomerLoginDAO;
import com.app.dao.ProductAddDAO;
import com.app.dao.impl.CustomerLoginDAOImpl;
import com.app.dao.impl.ProductAddDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Customer;
import com.app.model.Order;
import com.app.model.Product;
import com.app.search.service.CustomerSearchService;
import com.app.search.service.impl.CustomerSearchServiceImpl;
import com.app.service.impl.AddProductToCartServiceImpl;
import com.app.service.impl.CustomerLoginServiceImpl;
import com.app.service.impl.ListProductsServiceImpl;
import com.app.service.impl.MarkDeliveredServiceImpl;
import com.app.service.impl.MarkOrderStatusServiceImpl;
import com.app.service.impl.PlaceAnOrderServiceImpl;
import com.app.service.impl.ViewCartServiceImpl;
import com.app.service.impl.ViewMyOrdersServiceImpl;
public class Main {
	
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		log.info("Welcome to Spiro Shopping app");
		log.info("==============================");
		
		int option = 0;
		do {
			log.info("********************************************");
			log.info("|   1. Employee Login                      |");
			log.info("|   2. Customer Login                      |");
			log.info("|   3. New Customer? Register here         |");
			log.info("|   4. Exit                                |");
			log.info("********************************************");
			
			try {
				option = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {}
			
			switch(option) {
			case 1:
				int op = 0;
				do {
					log.info("Welcome!");
					log.info("\n------------------------");
					log.info("| 1. Add a Product     |");
					log.info("| 2. Update Cost       |");
					log.info("| 3. Search Customers  |");
					log.info("| 4. Mark the status   |");
					log.info("| 5. Logout!           |");
					log.info("------------------------");
					
					try {
						op = Integer.parseInt(scan.nextLine());
					} catch (NumberFormatException e) {}
					
					switch(op) {
					case 1:
						//Product product = new Product();
						log.info("Enter the product details below to add a product");
						log.info("ENTER PRODUCT ID");
						int productId = Integer.parseInt(scan.nextLine());
						log.info("ENTER PRODUCT NAME");
						String productName = scan.nextLine();
						log.info("ENTER MANUFACTURER NAME");
						String manufacturer = scan.nextLine();
						log.info("ENTER COST");
						double productCost = scan.nextDouble();
						Product product = new Product();
						product.setId(productId);
						product.setName(productName);
						product.setManufacturer(manufacturer);
						product.setCost(productCost);
						ProductAddServiceImpl productserviceimpl = new ProductAddServiceImpl();
						try {
							productserviceimpl.addProduct(product);
						} catch (BusinessException e) {
							System.out.println(e.getMessage());
						}
						
						break;
					case 2:
						log.info("Enter the Product Id to update the cost");
						
						break;
					case 3:
						int opt = 0;
						CustomerSearchService customerSearchService=new CustomerSearchServiceImpl();
						do {
							log.info("\n-----------------");
							log.info("|Search By      |");
							log.info("|---------------|");
							log.info("| 1. Id         |");
							log.info("| 2. Name       |");
							log.info("| 3. Email      |");
							log.info("| 4. OrderId    |");
							log.info("| 5. Exit       |");
							log.info("----------------");
							
							try {
								opt = Integer.parseInt(scan.nextLine());
							} catch (NumberFormatException e) {}

							switch(opt) {
							case 1:
//Search Customer By Id
								log.info("Enter customer id to get Customer details");
								try {
								int id=Integer.parseInt(scan.nextLine());
								Customer customer= customerSearchService.getCustomerById(id);
								if(customer!=null) {
									log.info("Customer with id "+id+" found successfully...");
									log.info(customer);
								}
								}catch(NumberFormatException e) {
									log.warn("Player Id should be digit only... Try Again");
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								break;
							case 2:
//Search Customer By Name	
								log.info("Enter customer name to get Customer details");
								try {
								String name = scan.nextLine();
								List<Customer> customers= customerSearchService.getCustomerByName(name);
								if(customers!=null) {
									log.info("Total there are "+customers.size()+" number of customers ");
									for(Customer customer:customers) {
										log.info(customer);
									}
								 }
							    } catch (BusinessException e) {
								log.warn(e.getMessage());
							    }
								break;
							case 3:
//Search By Email
								log.info("Enter customer Email to get Customer details");
								try {
								String email= scan.nextLine();
								Customer customer= customerSearchService.getCustomerByEmail(email);
								if(customer!=null) {
									log.info("Customer with id "+email+" found successfully...");
									log.info(customer);
								}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								break;
							case 4:
								
								break;
							}
							
						 }while(opt!=5);
					 break;
					case 4:
						log.info("ENTER CUSTOMER ID");
						int cid = 0;
						try {
							cid = Integer.parseInt(scan.nextLine());
						}catch(NumberFormatException e) {}
						Order oRder = new Order();
						oRder.setCustomerId(cid);
						ViewMyOrdersServiceImpl viewMyOrdersService = new ViewMyOrdersServiceImpl();
						try {
							log.info("Orders placed by Customer with Id"+" "+cid);
							log.info(viewMyOrdersService.viewMyOrders(oRder));
							
						} catch (BusinessException e) {
							System.out.println(e.getMessage());
						}
						log.info("ENTER PRODUCT ID");
						int pid = 0;
						try {
							pid = Integer.parseInt(scan.nextLine());
						} catch (NumberFormatException e) {}
						MarkDeliveredServiceImpl markDeliveredServiceImpl = new MarkDeliveredServiceImpl();
						try {
							Order order = new Order();
							order.setCustomerId(cid);
							order.setProductId(pid);
							markDeliveredServiceImpl.markDelivered(order);
						}catch (BusinessException e) {
							System.out.println(e.getMessage());
						}
					}
				}while(op!=5);
				
			break;
			case 2:
				log.info("ENTER YOUR EMAIL");
				String customerEmail = scan.nextLine();
				log.info("ENTER YOUR PASSWORD");
				String customerPassword = scan.nextLine();
				Customer customer = new Customer();
				customer.setCustomerEmail(customerEmail);
				customer.setCustomerPassword(customerPassword);
				CustomerLoginServiceImpl customerlogin = new CustomerLoginServiceImpl();
				try {
					if (customerlogin.customerLogin(customerEmail,customerPassword)) {
						log.info("Logged In successfully");
						log.info("\nWelcome");
						log.info("\n Ready to surf shopping?");
						log.info("\n      --Money has no meaning without a need--");
						log.info("             -Make that need meaningful-");
						log.info("                      Naga Madhu");
						int o = 0;
						do {
							log.info("\n------------------------------------------------------");
							log.info("| 1. List the available products                     |");
							log.info("------------------------------------------------------");
							log.info("| 2. Add a product to the Cart                       |");
							log.info("------------------------------------------------------");
							log.info("| 3. View the Cart with product list and total       |");
							log.info("------------------------------------------------------");
							log.info("| 4. PLace orders on the items in the Cart           |");
							log.info("------------------------------------------------------");
							log.info("| 5. Mark the order as received                      |");
							log.info("------------------------------------------------------");
							log.info("| 6. View all my orders and it's status              |");
							log.info("------------------------------------------------------");
							log.info("| 7. Logout                                          |");
							log.info("------------------------------------------------------");
							
							
							try {
								o = Integer.parseInt(scan.nextLine());
							} catch (NumberFormatException e) {}
							
							switch(o) {
							
							case 1:
								Product product = new Product();
								ListProductsServiceImpl listProductsServiceimpl = new ListProductsServiceImpl();
								try {
									log.info(listProductsServiceimpl.listProducts(product));
									
								} catch (BusinessException e) {
									System.out.println(e.getMessage());
								}
								break;
							case 2:
								Product p = new Product();
								 //int cId = CustomerLoginDAOImpl.cd;
								ListProductsServiceImpl listimpl = new ListProductsServiceImpl();
								System.out.println(listimpl.listProducts(p));
								log.info("Enter the Product Id to add in the Cart");
								int id = 0;
								try {
									id = Integer.parseInt(scan.nextLine());
								} catch (NumberFormatException e) {}
								AddProductToCartServiceImpl addProductToCartServiceimpl = new AddProductToCartServiceImpl();
								try {
									Cart cart = new Cart();
									cart.setProductId(id);
									cart.setCustomerId(CustomerLoginDAOImpl.cd);
									addProductToCartServiceimpl.addProductToCart(cart);
								} catch (BusinessException e) {
									System.out.println(e.getMessage());
								}
								break;
							case 3:
								Cart cart = new Cart();
								ViewCartServiceImpl viewCartServiceImpl = new ViewCartServiceImpl();
								try {
									log.info(viewCartServiceImpl.viewCart(cart));
									
								} catch (BusinessException e) {
									System.out.println(e.getMessage());
								}
								break;
							case 4:
								Cart carrt = new Cart();
								ViewCartServiceImpl viewCartServiceImpll = new ViewCartServiceImpl();
								log.info(viewCartServiceImpll.viewCart(carrt));
								log.info("Enter Product Id to place an order");
								int pid = 0;
								try {
									pid = Integer.parseInt(scan.nextLine());
								} catch (NumberFormatException e) {}
								PlaceAnOrderServiceImpl placeAnOrderServiceImpl = new PlaceAnOrderServiceImpl();
								try {
									Cart carT = new Cart();
									carT.setCustomerId(CustomerLoginDAOImpl.cd);
									carT.setProductId(pid);
									placeAnOrderServiceImpl.placeAnOrder(carT);
								} catch (BusinessException e) {
									System.out.println(e.getMessage());
								}

								
								break;
							case 5:
								log.info("Enter the Product Id to mark it as Received");
								int prid = 0;
								try {
									prid = Integer.parseInt(scan.nextLine());
								} catch (NumberFormatException e) {}
								MarkOrderStatusServiceImpl markOrderServiceImpl = new MarkOrderStatusServiceImpl();
								try {
									Order order = new Order();
									order.setCustomerId(CustomerLoginDAOImpl.cd);
									order.setProductId(prid);
									markOrderServiceImpl.markOrderStatus(order);
								}catch (BusinessException e) {
									System.out.println(e.getMessage());
								}
								
								break;
							case 6:
								Order order = new Order();
								order.setCustomerId(CustomerLoginDAOImpl.cd);
								ViewMyOrdersServiceImpl viewMyOrdersService = new ViewMyOrdersServiceImpl();
								try {
									log.info("Orders you have placed");
									log.info(viewMyOrdersService.viewMyOrders(order));
									
								} catch (BusinessException e) {
									System.out.println(e.getMessage());
								}
								break;
							case 7:
								log.info("Visit again");
								System.exit(0);
								break;
							
							}
							
						}while(o!=7);
						
						
				}
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				log.info("\nWelcome to the Family");
				log.info("ENTER YOUR ID");
				int id = Integer.parseInt(scan.nextLine());
				log.info("ENTER YOUR NAME");
				String name = scan.nextLine();
				log.info("ENTER YOUR VALID EMAIL");
				String email = scan.nextLine();
				if(!email.contains("@")) {
					log.info("Enter valid email");
				}
				else {
					log.info("A PASSWORD IS CONSIDERED VALID IF IT HAS");
					log.info("* At least one upper case alphabet");
					log.info("* At least one lower case alphabet");
					log.info("* At least one digit");
					log.info("* At least one special character symbol whih includes !@#$%&*()");
					log.info("* No white spaces");
					log.info("\n ENTER YOUR PASSWORD");
					String password = scan.nextLine();
					String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&*()])(?=\\S+$).{8,15}$";
					Pattern p = Pattern.compile(pattern);
					Matcher m = p.matcher(password);
					if(!m.matches()) {
						log.info("Enter password according to given constraints");
					}
					else {
						log.info("Thank you for providing the details");
						Customer customerc = new Customer();
						customerc.setCustomerId(id);
						customerc.setCustomerName(name);
						customerc.setCustomerEmail(email);
						customerc.setCustomerPassword(password);
						CustomerRegisterServiceImpl customerRegisterserviceimpl = new CustomerRegisterServiceImpl();
						try {
							customerRegisterserviceimpl.registerCustomer(customerc);
						} catch (BusinessException e) {
							System.out.println(e.getMessage());
						}
						

						//log.info("Enter password according to given constraints");
					}
				}
				
				break;
				
			}
		}while (option!=4);

	}

}
