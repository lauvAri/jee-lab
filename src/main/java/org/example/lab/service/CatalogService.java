package org.example.lab.service;

import org.example.lab.domain.Category;
import org.example.lab.domain.Item;
import org.example.lab.domain.Product;
import org.example.lab.persistence.CategoryDao;
import org.example.lab.persistence.ItemDao;
import org.example.lab.persistence.ProductDao;
import org.example.lab.persistence.impl.CategoryDaoImpl;
import org.example.lab.persistence.impl.ItemDaoImpl;
import org.example.lab.persistence.impl.ProductDaoImpl;

import java.util.List;

public class CatalogService {
    private CategoryDao categoryDao = new CategoryDaoImpl();
    private ItemDao itemDao = new ItemDaoImpl();
    private ProductDao productDao = new ProductDaoImpl();


    public List<Category> getCategoryList() {
        return categoryDao.getCategoryList();
    }

    public Category getCategory(String categoryId) {
        return categoryDao.getCategory(categoryId);
    }

    public Product getProduct(String productId) {
        return productDao.getProduct(productId);
    }

    public List<Product> getProductListByCategory(String categoryId) {
        return productDao.getProductListByCategory(categoryId);
    }

    // TODO enable using more than one keyword
    public List<Product> searchProductList(String keyword) {
        return productDao.searchProductList("%" + keyword.toLowerCase() + "%");
    }

    public List<Item> getItemListByProduct(String productId) {
        return itemDao.getItemListByProduct(productId);
    }

    public Item getItem(String itemId) {
        return itemDao.getItem(itemId);
    }

    public boolean isItemInStock(String itemId) {
        return itemDao.getInventoryQuantity(itemId) > 0;
    }
}
