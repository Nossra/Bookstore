package com.nosslin.Bookstore.ViewModels;

public class BookViewModel {
	private int id;
	private String title;
	private int nrOfPages;
	private int authorId;
	private String authorName;
	
	public BookViewModel() {
		
	}
	
	public BookViewModel(int id, String title, int nrOfPages, int authorId, String authorName) {
		this.setId(id);
		this.setTitle(title);
		this.setNrOfPages(nrOfPages);
		this.setAuthorId(authorId);
		this.setAuthorName(authorName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNrOfPages() {
		return nrOfPages;
	}

	public void setNrOfPages(int nrOfPages) {
		this.nrOfPages = nrOfPages;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
