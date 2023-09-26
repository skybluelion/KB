package spring.aop.solv;

/*
	Target
 */
public class ProductService {
	
	public String deleteProduct(String id) {
		System.out.println("deleteProduct...logic... 삭제 성공");
		return "삭제된 상품ID :"+id;
	}
}
