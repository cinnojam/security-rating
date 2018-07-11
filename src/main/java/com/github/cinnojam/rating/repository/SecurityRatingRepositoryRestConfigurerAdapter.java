package com.github.cinnojam.rating.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.github.cinnojam.rating.model.Rating;
import com.github.cinnojam.rating.model.RatingAgency;

@Configuration
public class SecurityRatingRepositoryRestConfigurerAdapter extends RepositoryRestConfigurerAdapter {
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(RatingAgency.class,Rating.class);
	}
}
