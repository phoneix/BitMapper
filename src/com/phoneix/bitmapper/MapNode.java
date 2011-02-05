package com.phoneix.bitmapper;

public class MapNode {
	int mX;
	int mY; 
	
	public void setXPosition(int x) {
		mX = x;
	}
	
	public void setYPosition(int y) {
		mY = y;
	}
	
	public void setPosition(int x, int y) {
		setXPosition(x);
		setYPosition(y);
	}
	
	public int	getXPosition() {
		return mX;
	}
	
	public int	getYPoistion() {
		return mY;
	} 
}
