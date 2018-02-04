package com.bjitgroup.dao;

import com.bjitgroup.models.Restaurant;

public interface ResturantDAO {

	public void create(Restaurant customer);
	public void remove(int id);
	public void update(Restaurant restaurant);
	public void select();
	public void selectByName(String name);
}
