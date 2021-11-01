package study.dao;

import study.entity.Product;
import study.model.PaginationResult;
import study.model.ProductInfo;

import java.util.List;

public interface ProductDAO {

    public Product findProduct(String code);

    public ProductInfo findProductInfo(String code) ;


    public PaginationResult<ProductInfo> queryProducts(int page,
                                                       int maxResult, int maxNavigationPage  );

    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult,
                                                       int maxNavigationPage, String likeName);

    public List<ProductInfo> getListProduct();
    public void save(ProductInfo productInfo);
}
