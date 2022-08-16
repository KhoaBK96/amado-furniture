package com.khoa.af.api.admin.dto;

import java.util.ArrayList;
import java.util.List;

import com.khoa.af.api.admin.Product;
import com.khoa.af.api.admin.SortType;

public class ShopPageDTO {
	
	private List<Product> products = new ArrayList<>();
	private SortType sortType = SortType.DEFAULT;
	private int categoryId;
	private int maxPage;
	private int page;
	private int itemsPerPage = 8;
	
	public ShopPageDTO() {
		super();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public SortType getSortType() {
		return sortType;
	}

	public void setSortType(SortType sortType) {
		this.sortType = sortType;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	

	public int getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	@Override
	public String toString() {
		return "ShopPageDTO [products=" + products + ", sortType=" + sortType + ", categoryId=" + categoryId
				+ ", maxPage=" + maxPage + ", page=" + page + ", itemsPerPage=" + itemsPerPage + "]";
	}

	
	
	
	
}
