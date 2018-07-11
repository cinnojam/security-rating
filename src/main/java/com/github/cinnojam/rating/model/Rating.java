package com.github.cinnojam.rating.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating implements Comparable<Rating>, Serializable {
	private static final long serialVersionUID = 2053784864377099422L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "ratingAgencyId", referencedColumnName = "ratingAgencyId", nullable = false)
	private RatingAgency ratingAgency;
	private String cusip;
	private LocalDate date;
	private String rating;

	public Rating() {
		super();
	}

	public Rating(Integer id, RatingAgency ratingAgency, String cusip, LocalDate date, String rating) {
		super();
		this.id = id;
		this.ratingAgency = ratingAgency;
		this.cusip = cusip;
		this.date = date;
		this.rating = rating;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RatingAgency getRatingAgency() {
		return ratingAgency;
	}

	public void setRatingAgency(RatingAgency ratingAgency) {
		this.ratingAgency = ratingAgency;
	}

	public String getCusip() {
		return cusip;
	}

	public void setCusip(String cusip) {
		this.cusip = cusip;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public int compareTo(Rating o) {
		if (this == o)
			return 0;
		if (this.ratingAgency.equals(o.getRatingAgency())) {
			if (this.date.equals(o.getDate())) {
				return this.cusip.compareTo(o.getCusip());
			} else {
				return this.date.compareTo(o.getDate());
			}
		} else {
			return this.ratingAgency.compareTo(o.getRatingAgency());
		}
	}

}
