package com.bjitgroup.services;

import org.springframework.transaction.annotation.Transactional;

import com.bjitgroup.dao.ResturantDAO;
import com.bjitgroup.models.Restaurant;


public class RestaurantServiceImpl implements RestaurantService{

	private ResturantDAO restaurantDAO;

	
	public ResturantDAO getRestaurantDAO() {
		return restaurantDAO;
	}


	public void setRestaurantDAO(ResturantDAO restaurantDAO) {
		this.restaurantDAO = restaurantDAO;
	}


	@Transactional
	public void createRestaurant(Restaurant restaurant) {
		restaurantDAO.create(restaurant);
	}
	
	@Transactional
	public void removeRestaurent(int id) {
		restaurantDAO.remove(id);
	}
	@Transactional
	public void updateRestaurant(Restaurant restaurant) {
		restaurantDAO.update(restaurant);
	}
	@Transactional
	public void showAll() {
		restaurantDAO.select();
	}
	@Transactional
	public void searchById(int id) {
		
	}
	@Transactional
	public void searchByName(String name) {
		restaurantDAO.selectByName(name);
	}
}
