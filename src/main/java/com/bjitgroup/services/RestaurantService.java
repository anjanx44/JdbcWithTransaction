package com.bjitgroup.services;

import com.bjitgroup.models.Restaurant;

public interface RestaurantService {

	public void createRestaurant(Restaurant restaurent);
	public void removeRestaurent (int id);
	public void updateRestaurant(Restaurant restaurant);
	public void showAll();
	public void searchById(int id);
	public void searchByName(String name);
}
