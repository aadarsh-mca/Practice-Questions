package com.cdac.vehicle;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VehicleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleProjectApplication.class, args);
	}

	@Bean
	public ModelMapper initModelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		Configuration configuration = modelMapper.getConfiguration();
		configuration
			.setMatchingStrategy(MatchingStrategies.STRICT)
			.setPropertyCondition(Conditions.isNotNull());

		return modelMapper;
	}

}
