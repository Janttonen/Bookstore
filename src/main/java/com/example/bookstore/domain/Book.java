package com.example.bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;

	private String author;
	private String isbn;
	private double price;
	private String title;
	
	@Column(name="publishing_year")
	private int year;
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;
	
	public Book() {
	}

	public Book(String author, String isbn, double price, String title, int year, Category category) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.year = year;
		this.price = price;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		if (this.category != null) {
			return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", year=" + year
					+ ", price=" + price + " category =" + this.getCategory() + "]";
		} else {
			return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", year=" + year
					+ ", price=" + price + "]";
		}
	}
}
