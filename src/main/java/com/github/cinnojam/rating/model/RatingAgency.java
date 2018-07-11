package com.github.cinnojam.rating.model;

import java.io.Serializable;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SortNatural;

@Entity
@Table(name = "rating_agency")
public class RatingAgency implements Comparable<RatingAgency>, Serializable {
	private static final long serialVersionUID = 692884008492936784L;
	@Id
	private Integer ratingAgencyId;
	private String name;
	@OneToMany(mappedBy = "ratingAgency")
	@SortNatural
	private final SortedSet<Rating> ratings = new TreeSet<>();

	public RatingAgency() {
		super();
	}

	public RatingAgency(Integer id, String name) {
		super();
		this.ratingAgencyId = id;
		this.name = name;
	}

	@Override
	public int compareTo(RatingAgency o) {
		if (o == null) {
			return -1;
		} else {
			return this.name.compareTo(o.getName());
		}
	}

	public Integer getRatingAgencyId() {
		return ratingAgencyId;
	}

	public void setRatingAgencyId(Integer id) {
		this.ratingAgencyId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SortedSet<Rating> getRatings() {
		return ratings;
	}
	
	

}
