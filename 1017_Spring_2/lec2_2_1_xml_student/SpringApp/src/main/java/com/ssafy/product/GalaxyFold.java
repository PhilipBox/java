package com.ssafy.product;

public class GalaxyFold implements Phone {

	private int price;
	private Camera camera;
	private Algo algo;
	
	
	public GalaxyFold() {}
	
	public GalaxyFold(int price, Camera camera, Algo algo) {
		super();
		this.price = price;
		this.camera = camera;
		this.algo = algo;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setAlgo(Algo algo) {
		this.algo = algo;
	}
	
	@Override
	public void powerOn() {
		System.out.println("갤럭시 폰 ON");
	}

	@Override
	public void powerOff() {
		System.out.println("갤럭시 폰 OFF");

	}

	@Override
	public void calls() {
		System.out.println("갤럭시 폰으로 전화를 합니다.");
	}

	@Override
	public void takePicture() {
		camera.takePicture();
	}

	@Override
	public void studyAlgo() {
		algo.solve();
	}

	@Override
	public String toString() {
		return "GalaxyFold [price=" + price + ", camera=" + camera + ", algo=" + algo + "]";
	}
	
	
	public void setCamera(Camera c) {
		this.camera = c;
	}
	
}
