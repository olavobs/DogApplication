package com.udacity.dogRestApi.service;

import java.util.List;

import com.udacity.dogRestApi.entity.Dog;

public interface DogService {

	List<Dog> retrieveDogs();

	List<String> retrieveDogBreed();

	String retrieveDogBreedById(Long id);

	List<String> retrieveDogNames();

}
