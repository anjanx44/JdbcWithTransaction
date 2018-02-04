package com.bjitgroup.models;

public class Food {

	public int foodId;
	public String foodName;
	public String foodCost;
	public int resturentId;
	
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodCost() {
		return foodCost;
	}
	public void setFoodCost(String foodCost) {
		this.foodCost = foodCost;
	}
	public int getResturentId() {
		return resturentId;
	}
	public void setResturentId(int resturentId) {
		this.resturentId = resturentId;
	}
	@Override
	public String toString() {
		return "foodId=" + foodId + ", foodName=" + foodName + ", foodCost=" + foodCost + ", resturentId="
				+ resturentId + "\n";
	}

}
