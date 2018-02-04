package com.bjitgroup.dao;

import com.bjitgroup.models.Food;

public interface FoodDAO {

	public void create(Food food);
	public void remove(int id);
	public void update(Food food);
	public void select();
	public void selectByRestaurantId(int id);
}
