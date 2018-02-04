package com.bjitgroup.dao;

import javax.sql.DataSource;
import java.util.*;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bjitgroup.models.Food;

public class FoodDAOImpl implements FoodDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void create(Food food) {

		String query = "insert into food (foodId, foodName,foodCost,resturentId) values (?,?,?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(query,
				new Object[] { food.getFoodId(), food.getFoodName(), food.getFoodCost(), food.getResturentId() });
		
		//jdbcTemplate.update(query,
				//new Object[] { food.getFoodId(), food.getFoodName(), food.getFoodCost(), 600000000 });
		System.out.println("Inserted into Food Table Successfully");

	}

	public void remove(int id) {
		String query = "delete from food where resturentId=?";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(query, id);

		System.out.println("deleted Successfully from restaurant");
	}
	
	public void update(Food food) {
		String query = "update food set foodName = ?, foodCost = ?, resturentId = ? where foodId = ?";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		int val = jdbcTemplate.update(query, new Object[] { food.getFoodName(), food.getFoodCost(),
				food.getResturentId(), food.getFoodId()});
		if (val != 0) {
			System.out.println("Success! Food with id = " + food.getFoodId() + "  has been updated.");
		} else {
			System.out.println("Failed update! Restaurnat with id = " + food.getFoodId()+ " not found.");
		}
	}
	
	public void select() {
		String query = "select * from food";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Food> foodList = new ArrayList<Food>();
		List<Map<String, Object>> foodRows = jdbcTemplate.queryForList(query);
		
		for (Map<String, Object> foodRow : foodRows) {
			Food food = new Food();
			food.setFoodId(Integer.parseInt(String.valueOf(foodRow.get("foodId"))));
			food.setFoodName(String.valueOf(foodRow.get("foodName")));
			food.setFoodCost(String.valueOf(foodRow.get("foodCost")));
			food.setResturentId(Integer.parseInt(String.valueOf(foodRow.get("resturentId"))));
			foodList.add(food);
		}
		if(!foodList.isEmpty()) {
			System.out.println(foodList);
		}else {
			System.out.println("Search Result: Empty!");
		}
	}
	
	public void selectByRestaurantId(int resturantId) {
		String query = "select * from food where resturentId=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Food> foodList = new ArrayList<Food>();
		List<Map<String, Object>> foodRows = jdbcTemplate.queryForList(query,resturantId);
		
		for (Map<String, Object> foodRow : foodRows) {
			Food food = new Food();
			food.setFoodId(Integer.parseInt(String.valueOf(foodRow.get("foodId"))));
			food.setFoodName(String.valueOf(foodRow.get("foodName")));
			food.setFoodCost(String.valueOf(foodRow.get("foodCost")));
			food.setResturentId(Integer.parseInt(String.valueOf(foodRow.get("resturentId"))));
			foodList.add(food);
		}
		if(!foodList.isEmpty()) {
			System.out.println(foodList);
		}else {
			System.out.println("Search Result: Empty!");
		}
	}

}