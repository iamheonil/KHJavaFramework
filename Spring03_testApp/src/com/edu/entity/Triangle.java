package com.edu.entity;

import com.edu.main.Figure;

public class Triangle implements Figure {

	private String title;
	private int width;
	private int height;

	public Triangle() {

	}

	public Triangle(String title, int width, int height) {
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
		
		Triangle triangle = new Triangle();
		triangle.setTitle("트라이앵글");
		triangle.setWidth(3);
		triangle.setHeight(5);
		
		System.out.println(getTitle() + " 의 넓이 : " + (getHeight() * getWidth()) / 2);
	}
	
}
