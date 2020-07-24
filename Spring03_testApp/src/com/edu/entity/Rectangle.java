package com.edu.entity;

import com.edu.main.Figure;

public class Rectangle implements Figure {

	private String title;
	private int width;
	private int height;

	public Rectangle() {

	}

	public Rectangle(String title, int width, int height) {
		super();
		this.title = title;
		this.width = width;
		this.height = height;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void viewSize() {
//		Rectangle rectangle = new Rectangle();
		
//		rectangle.setTitle("사각형");
//		rectangle.setWidth(3);
//		rectangle.setHeight(5);
		
		System.out.println(getTitle() + " 의 넓이 : " + getWidth() * getHeight());
	}

}
