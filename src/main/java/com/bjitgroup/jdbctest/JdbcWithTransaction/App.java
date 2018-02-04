package com.bjitgroup.jdbctest.JdbcWithTransaction;

import java.util.Random;
import java.util.Scanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjitgroup.models.Food;
import com.bjitgroup.models.Restaurant;
import com.bjitgroup.services.FoodService;
import com.bjitgroup.services.RestaurantService;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		RestaurantService restaurantManager = (RestaurantService) ctx.getBean("restaurantManager");
		FoodService foodManager = (FoodService) ctx.getBean("foodManager");
		Scanner sc = new Scanner(System.in);

		boolean end = true;

		int value;

		showList();
		value = sc.nextInt();

		while (value != 11) {
			if (value == 1) {
				foodManager.selectFood();
			} else if (value == 2) {
				restaurantManager.showAll();
			} else if (value == 3) {
				String restaurentName;
				System.out.println("Enter Name of Restaaurant");
				restaurentName=sc.next();
				restaurantManager.searchByName(restaurentName);
			} else if (value == 4) {
				System.out.println("Enter restaurant Id");
				int id;
				id = sc.nextInt();
				foodManager.searchByRestaurantId(id);
			} else if (value == 5) {
				Food food = new Food();
				int foodId, restaurantId;
				String foodName, foodCost;
				System.out.println("Enter foodId");
				foodId = sc.nextInt();
				System.out.println("Enter foodName");
				foodName = sc.next();
				System.out.println("Enter foodCost");
				foodCost = sc.next();
				System.out.println("Enter which restaurant this food belongs to");
				restaurantId = sc.nextInt();
				food.setFoodId(foodId);
				food.setFoodCost(foodCost);
				food.setFoodName(foodName);
				food.setResturentId(restaurantId);
				foodManager.createCustomer(food);
			} else if (value == 6) {
				int restaurantId;

				String restaurantName, restaurantRank, restaurantAddress;

				Restaurant restaurant = new Restaurant();

				System.out.println("Enter restaurantId");
				restaurantId = sc.nextInt();
				System.out.println("Enter restaurantName");
				restaurantName = sc.next();
				System.out.println("Enter restaurantRank");
				restaurantRank = sc.next();
				System.out.println("Enter restaurantAddress");
				restaurantAddress = sc.next();

				restaurant.setRestaurantAddress(restaurantAddress);
				restaurant.setRestaurantId(restaurantId);
				restaurant.setRestaurantName(restaurantName);
				restaurant.setRestaurantRank(restaurantRank);
				restaurantManager.createRestaurant(restaurant);

			} else if (value == 7) {
				Food food = new Food();
				int foodId, restaurantId;
				String foodName, foodCost;
				System.out.println("Enter foodId");
				foodId = sc.nextInt();
				System.out.println("Enter foodName");
				foodName = sc.next();
				System.out.println("Enter foodCost");
				foodCost = sc.next();
				System.out.println("Enter which restaurant this food belongs to");
				restaurantId = sc.nextInt();
				food.setFoodId(foodId);
				food.setFoodCost(foodCost);
				food.setFoodName(foodName);
				food.setResturentId(restaurantId);
				foodManager.updateFood(food);
			} else if (value == 8) {
				int restaurantId;

				String restaurantName, restaurantRank, restaurantAddress;

				Restaurant restaurant = new Restaurant();

				System.out.println("Enter restaurantId");
				restaurantId = sc.nextInt();
				System.out.println("Enter restaurantName");
				restaurantName = sc.next();
				System.out.println("Enter restaurantRank");
				restaurantRank = sc.next();
				System.out.println("Enter restaurantAddress");
				restaurantAddress = sc.next();

				restaurant.setRestaurantAddress(restaurantAddress);
				restaurant.setRestaurantId(restaurantId);
				restaurant.setRestaurantName(restaurantName);
				restaurant.setRestaurantRank(restaurantRank);
				restaurantManager.updateRestaurant(restaurant);
			} else if (value == 9) {
				System.out.println("Enter food id you want to delete");
				int foodId;
				foodId=sc.nextInt();
				foodManager.removeCustomer(foodId);
			} else if (value == 10) {
				System.out.println("Enter restaurant id you want to delete");
				int restaurantId;
				restaurantId=sc.nextInt();
				foodManager.removeCustomer(restaurantId);
				restaurantManager.removeRestaurent(restaurantId);
			} else {
				break;
			}
			showList();
			value = sc.nextInt();

		}

		Restaurant restaurant = createDummyRestaurantForInsertion();
		/*
		 * restaurantManager.createRestaurant(restaurant); restaurantManager.showAll();
		 * 
		 * restaurantManager.updateRestaurant(restaurant); restaurant =
		 * createDummyRestaurantForUpdate();
		 * restaurantManager.updateRestaurant(restaurant); restaurantManager.showAll();
		 */

		foodManager.searchByRestaurantId(59);
		/*
		 * Food food = createFoodForInsertion(); foodManager.createCustomer(food);
		 * foodManager.selectFood();
		 * 
		 * food = createFoodForUpdate();
		 * 
		 * foodManager.updateFood(food); foodManager.selectFood();
		 */

		// manager.removeCustomer(1);
		// restaurantManager.removeRestaurent(1);
		/*
		 * Food food = createFood(); foodManager.createCustomer(food);
		 */
		ctx.close();
	}

	private static void showList() {
		System.out.println("Insert 1 for showing all food");
		System.out.println("Insert 2 for showing all restaurant");
		System.out.println("Insert 3 for showing food of a restaurent by name");
		System.out.println("Insert 4 for showing food of a restaurent by id");
		System.out.println("Insert 5 for inserting food");
		System.out.println("Insert 6 for inserting restaurant");
		System.out.println("Insert 7 for update food");
		System.out.println("Insert 8 for update restaurant");
		System.out.println("Insert 9 for delete food");
		System.out.println("Insert 10 for delete restaurant");

	}

	private static Restaurant createDummyRestaurantForInsertion() {
		Restaurant restaurant = new Restaurant();
		// int rand = new Random().nextInt(1000);
		restaurant.setRestaurantId(135);
		restaurant.setRestaurantName("Rana");
		restaurant.setRestaurantRank("Rana");
		restaurant.setRestaurantAddress("Rana");

		return restaurant;
	}

	private static Restaurant createDummyRestaurantForUpdate() {
		Restaurant restaurant = new Restaurant();
		// int rand = new Random().nextInt(1000);
		restaurant.setRestaurantId(135);
		restaurant.setRestaurantName("ABC");
		restaurant.setRestaurantRank("ABC");
		restaurant.setRestaurantAddress("ABC");

		return restaurant;
	}

	private static Food createFoodForInsertion() {

		Food food = new Food();
		// int ran = new Random().nextInt(1000);
		food.setFoodId(140);
		food.setFoodName("Food 123 ");
		food.setFoodCost("Expensive");
		food.setResturentId(59);
		return food;
	}

	private static Food createFoodForUpdate() {

		Food food = new Food();
		// int ran = new Random().nextInt(1000);
		food.setFoodId(140);
		food.setFoodName("Food 124 ");
		food.setFoodCost("Budget");
		food.setResturentId(59);
		return food;
	}

}