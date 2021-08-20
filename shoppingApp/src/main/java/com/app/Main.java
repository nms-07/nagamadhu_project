package com.app;
import java.util.List;
import java.util.regex.*;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.addProduct.service.ProductAddService;
import com.app.addProduct.service.impl.ProductAddServiceImpl;
import com.app.customerRegister.service.CustomerRegisterService;
import com.app.customerRegister.service.impl.CustomerRegisterServiceImpl;
import com.app.dao.CustomerLoginDAO;
import com.app.dao.ProductAddDAO;
import com.app.dao.impl.CustomerLoginDAOImpl;
import com.app.dao.impl.ProductAddDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Customer;
import com.app.model.Employee;
import com.app.model.Order;
import com.app.model.OrderId;
import com.app.model.Product;
import com.app.search.service.CustomerSearchService;
import com.app.search.service.impl.CustomerSearchServiceImpl;
import com.app.service.AddProductToCartService;
import com.app.service.CustomerLoginService;
import com.app.service.ListProductsService;
import com.app.service.MarkOrderStatusService;
import com.app.service.PlaceAnOrderService;
import com.app.service.ViewAllOrdersService;
import com.app.service.ViewCartService;
import com.app.service.ViewMyOrdersService;
import com.app.service.impl.AddProductToCartServiceImpl;
import com.app.service.impl.CustomerLoginServiceImpl;
import com.app.service.impl.ListProductsServiceImpl;
import com.app.service.MarkAsShippedService;
import com.app.service.impl.MarkAsShippedServiceImpl;
import com.app.service.impl.MarkOrderStatusServiceImpl;
import com.app.service.impl.PlaceAnOrderServiceImpl;
import com.app.service.impl.ViewAllOrderServiceImpl;
import com.app.service.impl.ViewCartServiceImpl;
import com.app.service.impl.ViewMyOrdersServiceImpl;
public class Main {
	
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		log.info("Welcome to Spiro Shopping app");
		log.info("==============================");
		
		int option = 0;
		do {
			log.info("");
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
				log.info("ENTER EMAIL TO LOGIN");
				String employeEmail = scan.nextLine();
				log.info("ENTER YOUR PASSWORD");
				String employePassword = scan.nextLine();
				if(Employee.employeValidate(employeEmail,employePassword)==1) {
					int op = 0;
					do {
						log.info("\n------------------------");
						log.info("| 1. Add a Product     |");
						log.info("| 2. Search Customers  |");
						log.info("| 3. Mark the status   |");
						log.info("| 4. Logout!           |");
						log.info("------------------------");
						try {
							
							op = Integer.parseInt(scan.nextLine());
						} catch (NumberFormatException e) {}
						switch(op) {
						
						case 1:
	/*Add Product*/			Product product = new Product();
							log.info("Enter the product details below to add a product");
							log.info("ENTER PRODUCT ID ");
							product.setId(Integer.parseInt(scan.nextLine()));	
							log.info("ENTER PRODUCT NAME");
							product.setName(scan.nextLine());	
							log.info("ENTER MANUFACTURER NAME");
							product.setManufacturer(scan.nextLine());
							log.info("ENTER COST");
							product.setCost(Double.parseDouble(scan.nextLine()));
							ProductAddService productserviceimpl = new ProductAddServiceImpl();
							try {
								log.info("Product created with below details successfully");
								productserviceimpl.addProduct(product);
							} catch (BusinessException e1) {
								log.info(e1.getMessage());
							}
							
							break;
//						case 2:
//	/*Update*/				Product prodUCT = new Product();
//	/*Product Cost*/		log.info("Enter the Product Id to update the cost");
//							int uid = Integer.parseInt(scan.nextLine());
//							prodUCT.setId(uid);
//							log.info("Enter the New Cost to be updated");
//							Double cost = (Double.parseDouble(scan.nextLine()));
//							prodUCT.setCost(cost);
//							ProductAddService productserviceImpl = new ProductAddServiceImpl();
//							try {
//								log.info("Product cost with"+" "+ uid +" "+" is updated successfully");
//								productserviceImpl.updateCost(uid,cost);
//								log.info(prodUCT);
//							} catch (BusinessException e1) {
//								log.warn(e1.getMessage());
//							}
//							break;
						case 2:
							int opt = 0;
	/*Customer Search*/		CustomerSearchService customerSearchService=new CustomerSearchServiceImpl();
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
	/*By Id*/						log.info("Enter customer id to get Customer details");
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
	/*By Name*/						log.info("Enter customer name to get Customer details");
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
	/*By Email*/					log.info("Enter customer Email to get Customer details");
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
	/*By OrderId*/					log.info("ENTER ORDER ID");
									try {
										int oId=Integer.parseInt(scan.nextLine());
										OrderId customer= customerSearchService.getCustomerByOrderId(oId);
										if(customer!=null) {
											log.info("Customer with Order id "+oId+" found successfully...");
											log.info(customer);
										}
										}catch(NumberFormatException e) {
											log.warn("Order Id should be digit only... Try Again");
										} catch (BusinessException e) {
											log.warn(e.getMessage());
										}
									break;
								}
								
							}while(opt!=5);
							break;
						case 3:
							try {
								Order order = new Order();
	/*Mark as shipped*/			ViewAllOrdersService viewAllOrdersService = new ViewAllOrderServiceImpl();
								List<Order> ordeR = viewAllOrdersService.viewAllOrders(order);
								log.info("Orders placed by the Customers are");
								if(ordeR!=null) {
									for(Order x:ordeR) {
										log.info(x);
									}
								 }
							    } catch (BusinessException e) {
								log.warn(e.getMessage());
							    }
							log.info("");
							log.info("ENTER ORDER ID");
							int oid = 0;
							try {
								oid = Integer.parseInt(scan.nextLine());
							}catch(NumberFormatException e) {}
							ViewMyOrdersService viewMyOrdersService = new ViewMyOrdersServiceImpl();
							MarkAsShippedService markDeliveredServiceImpl = new MarkAsShippedServiceImpl();
							try {
								Order orDer = new Order();
								orDer.setOrderId(oid);
								log.info("Shipped the product successfully!");
								markDeliveredServiceImpl.markDelivered(orDer);
								log.info("Updated the Order Status to shipped");
							}catch (BusinessException e) {
								System.out.println(e.getMessage());
							}
							break;
						case 5:
							log.info("Logged Out!");
							System.exit(0);
						}
					}while(op!=4);
				}else {
					log.info("No account with the entered details....Enter valid details");
				}
				
				break;
			case 2:
				log.info("ENTER YOUR EMAIL");
				String customerEmail = scan.nextLine();
				log.info("ENTER YOUR PASSWORD");
				String customerPassword = scan.nextLine();
				Customer customer = new Customer();
				customer.setCustomerEmail(customerEmail);
				customer.setCustomerPassword(customerPassword);
				CustomerLoginService customerlogin = new CustomerLoginServiceImpl();
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
								try {
									Product producT = new Product();
									ListProductsService listProductsService = new ListProductsServiceImpl();
									List<Product> produCt = listProductsService.listProducts(producT);
									log.info("Below are the available products");
									if(produCt!=null) {
										for(Product x:produCt) {
											log.info(x);
										}
									 }
								    } catch (BusinessException e) {
									log.warn(e.getMessage());
								    }
								break;
							case 2:
								try {
									Product producT = new Product();
									ListProductsService listProductsService = new ListProductsServiceImpl();
									List<Product> produCt = listProductsService.listProducts(producT);
									if(produCt!=null) {
										for(Product x:produCt) {
											log.info(x);
										}
									 }
								    } catch (BusinessException e) {
									log.warn(e.getMessage());
								    }
								log.info(" ");
								log.info("Enter the Product Id to add in the Cart");
								int id = 0;
								try {
									id = Integer.parseInt(scan.nextLine());
								} catch (NumberFormatException e) {}
								AddProductToCartService addProductToCartServiceimpl = new AddProductToCartServiceImpl();
								try {
									Cart cart = new Cart();
									cart.setProductId(id);
									cart.setCustomerId(CustomerLoginDAOImpl.cd);
									log.info("Product with"+" "+ id +" "+"added to cart successfully");
									addProductToCartServiceimpl.addProductToCart(cart);
								} catch (BusinessException e) {
									System.out.println(e.getMessage());
								}
								break;
							case 3:
								try {
									Cart cart = new Cart();
									ViewCartService viewCartService = new ViewCartServiceImpl();
									List<Cart> caRT = viewCartService.viewCart(cart);
									log.info("List of Products placed in your Cart ");
									if(caRT!=null) {
										for(Cart x:caRT) {
											log.info(x);
										}
									 }
									double totalCost = 0;
									if(caRT!=null) {
									for(Cart y : caRT) {
										totalCost = caRT.stream().mapToDouble(p -> p.getProduct().getCost()).sum();
									}
									log.info("");
									log.info("Total Cost is"+" "+totalCost);
									}
									
								    } catch (BusinessException e) {
									log.warn(e.getMessage());
								    }
								break;
							case 4:
								try {
									Cart cart = new Cart();
									ViewCartService viewCartService = new ViewCartServiceImpl();
									List<Cart> caRT = viewCartService.viewCart(cart);
									if(caRT!=null) {
										for(Cart x:caRT) {
											log.info(x);
										}
									 }
								    } catch (BusinessException e) {
									log.warn(e.getMessage());
								    }	
								//log.info("Enter Product Id to place an order");
//								int pid = 0;
//								try {
//									pid = Integer.parseInt(scan.nextLine());
//								} catch (NumberFormatException e) {}
								PlaceAnOrderService placeAnOrderServiceImpl = new PlaceAnOrderServiceImpl();
								try {
									Cart carT = new Cart();
									carT.setCustomerId(CustomerLoginDAOImpl.cd);
									//carT.setProductId(pid);
									placeAnOrderServiceImpl.placeAnOrder(carT);
									log.info("Ordered your product successfully");
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}		
								break;
							case 5:
								log.info("Enter the Order Id to mark it as Received");
								int oid = 0;
								try {
									oid = Integer.parseInt(scan.nextLine());
								} catch (NumberFormatException e) {}
								MarkOrderStatusService markOrderServiceImpl = new MarkOrderStatusServiceImpl();
								try {
									Order order = new Order();
									order.setCustomerId(CustomerLoginDAOImpl.cd);
									order.setOrderId(oid);
									log.info("Changed the order status to received");
									markOrderServiceImpl.markOrderStatus(order);
									log.info("Updated your Order status successfully");
								}catch (BusinessException e) {
									System.out.println(e.getMessage());
								}
								
								break;
							case 6:
								Order order = new Order();
								order.setCustomerId(CustomerLoginDAOImpl.cd);
								ViewMyOrdersService viewMyOrdersService = new ViewMyOrdersServiceImpl();
								try {
									log.info("Orders you have placed");
									List<Order> ordER = viewMyOrdersService.viewMyOrders(order);
									if(ordER!=null) {
										for(Order x:ordER) {
											log.info(x);
										}
									 }
								    } catch (BusinessException e) {
									log.warn(e.getMessage());
								    }
								break;
							case 7:
								log.info("Visit again");
								System.exit(0);
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
						CustomerRegisterService customerRegisterserviceimpl = new CustomerRegisterServiceImpl();
						try {
							customerRegisterserviceimpl.registerCustomer(customerc);
						} catch (BusinessException e) {
							System.out.println(e.getMessage());
						}
					}
				}
				break;
			case 4:
				log.info("Have a good day");
			
			}
		}while(option!=4);
	}
}
			