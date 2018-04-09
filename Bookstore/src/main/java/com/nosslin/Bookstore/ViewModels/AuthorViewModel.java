package com.nosslin.Bookstore.ViewModels;

public class AuthorViewModel {
	private int id;
	private String fullName;
	
	public AuthorViewModel() {
		
	}
	
	public AuthorViewModel(int id, String fullName) {
		this.setId(id);
		this.setFullName(fullName);
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
