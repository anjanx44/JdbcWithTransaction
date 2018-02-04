package com.bjitgroup.models;

public class Restaurant {

	public int restaurantId;
	public String restaurantName;
	public String restaurantRank;
	public String restaurantAddress;
	
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantRank() {
		return restaurantRank;
	}
	public void setRestaurantRank(String restaurantRank) {
		this.restaurantRank = restaurantRank;
	}
	public String getRestaurantAddress() {
		return restaurantAddress;
	}
	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}
	@Override
	public String toString() {
		return "restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", restaurantRank="
				+ restaurantRank + ", restaurantAddress=" + restaurantAddress + "\n";
	}
	
	
	
}
