package com.bjitgroup.services;

import org.springframework.transaction.annotation.Transactional;

import com.bjitgroup.dao.FoodDAO;
import com.bjitgroup.models.Food;


public class FoodServiceImpl implements FoodService{

	private FoodDAO foodDAO;

	public FoodDAO getCustomerDAO() {
		return foodDAO;
	}

	public FoodDAO getFoodDAO() {
		return foodDAO;
	}

	public void setFoodDAO(FoodDAO foodDAO) {
		this.foodDAO = foodDAO;
	}

	@Transactional
	public void createCustomer(Food food) {
		foodDAO.create(food);
	}
	
	@Transactional
	public void removeCustomer(int id) {
		foodDAO.remove(id);
	}
	@Transactional
	public void updateFood(Food food) {
		foodDAO.update(food);
	}
	@Transactional
	public void selectFood() {
		foodDAO.select();
	}
	
	public void searchByRestaurantId(int restaurantId) {
		foodDAO.selectByRestaurantId(restaurantId);
	}
	
	
}
