package com.bjitgroup.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bjitgroup.models.Food;
import com.bjitgroup.models.Restaurant;

public class RestaurantDAOImpl implements ResturantDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void create(Restaurant restaurent) {
		String queryCustomer = "insert into restaurant (restaurantId, restaurantName,restaurantRank,restaurantAddress) values (?,?,?,?)";
		//String queryAddress = "insert into address (id, address,country) values (?,?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		int x=jdbcTemplate.update(queryCustomer, new Object[] {
				restaurent.getRestaurantId(),
				restaurent.getRestaurantName(),
				restaurent.getRestaurantRank(),
				restaurent.getRestaurantAddress()
				});
		
		System.out.println("Inserted into Customer Table Successfully");
		
		/*jdbcTemplate.update(queryAddress, new Object[] { 
				customer.getId(), 
				customer.getAddress().getAddress(),
				customer.getAddress().getCountry() 
				});
		
		System.out.println("Inserted into Address Table Successfully");*/
	}
	
	public void remove(int id) {
		String query = "delete from restaurant where restaurantId=?";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(query, id);

		System.out.println("deleted Successfully from restaurant");
	}
	
	public void update(Restaurant restaurant) {
		String query = "update restaurant set restaurantName = ?, restaurantRank = ?, restaurantAddress = ? where restaurantId = ?";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		int val = jdbcTemplate.update(query, new Object[] { restaurant.getRestaurantName(), restaurant.getRestaurantRank(),
				restaurant.getRestaurantAddress(), restaurant.getRestaurantId()});
		if (val != 0) {
			System.out.println("Success! Restaurnat with id = " + restaurant.getRestaurantId()+ "  has been updated.");
		} else {
			System.out.println("Failed update! Restaurnat with id = " + restaurant.getRestaurantId() + " not found.");
		}
	}
	
	public void select() {
		String query = "select * from restaurant";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		List<Map<String, Object>> restaurantRows = jdbcTemplate.queryForList(query);
		
		for (Map<String, Object> foodRow : restaurantRows) {
			Restaurant restaurant = new Restaurant();
			restaurant.setRestaurantId(Integer.parseInt(String.valueOf(foodRow.get("restaurantId"))));
			restaurant.setRestaurantName(String.valueOf(foodRow.get("restaurantName")));
			restaurant.setRestaurantRank(String.valueOf(foodRow.get("restaurantRank")));
			restaurant.setRestaurantAddress(String.valueOf(foodRow.get("restaurantAddress")));
			//restaurant.setResturentId(Integer.parseInt(String.valueOf(foodRow.get("resturentId"))));
			restaurantList.add(restaurant);
		}
		if(!restaurantList.isEmpty()) {
			System.out.println(restaurantList);
		}else {
			System.out.println("Search Result: Empty!");
		}
	}
	
	public void selectByName(String name) {
		System.out.println(name);
		String query = "select * from food  join restaurant on food.resturentId=restaurant.restaurantId where restaurant.restaurantName=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Food> restaurantList = new ArrayList<Food>();
		List<Map<String, Object>> restaurantRows = jdbcTemplate.queryForList(query,new Object[] {name});
		
		for (Map<String, Object> foodRow : restaurantRows) {
			Food restaurant = new Food();
			restaurant.setFoodId(Integer.parseInt(String.valueOf(foodRow.get("foodId"))));
			restaurant.setFoodName(String.valueOf(foodRow.get("foodName")));
			restaurant.setFoodCost(String.valueOf(foodRow.get("foodCost")));
			restaurant.setResturentId(Integer.parseInt(String.valueOf(foodRow.get("resturentId"))));
			restaurantList.add(restaurant);
		}
		if(!restaurantList.isEmpty()) {
			System.out.println(restaurantList);
		}else {
			System.out.println("Search Result: Empty!");
		}
	}

}
