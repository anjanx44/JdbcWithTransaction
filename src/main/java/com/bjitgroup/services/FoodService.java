package com.bjitgroup.services;

import com.bjitgroup.models.Food;

public interface FoodService {
	public void createCustomer(Food food);
	public void removeCustomer(int id);
	public void updateFood(Food food);
	public void selectFood();
	public void searchByRestaurantId(int restaurantId);
}
