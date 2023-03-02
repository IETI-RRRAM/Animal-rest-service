package edu.eci.agronomo;

import edu.eci.agronomo.animal.controller.AnimalController;
import edu.eci.agronomo.animal.exceptions.AnimalNotFoundException;
import edu.eci.agronomo.animal.model.animal.Animal;
import edu.eci.agronomo.animal.model.animal.AnimalDto;
import edu.eci.agronomo.animal.service.AnimalServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
@SpringBootTest
class AnimalApplicationTests {

	final String BASE_URL = "/api/animals";



	@MockBean
	private AnimalServiceImpl animalService;

	@Autowired
	private AnimalController animalController;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup(){ mockMvc = standaloneSetup(animalController).build();}

	//TEST GET 1
	@Test
	public void testFindByIdExistingAnimal() throws Exception {
		Animal animal = new Animal("117", "caramelo", "cow", "M");
		when(animalService.findById("1")).thenReturn(Optional.of(animal));

		mockMvc.perform(get(BASE_URL + "/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is("caramelo")))
				.andExpect(jsonPath("$.type", is("cow")));

		verify(animalService, times(1)).findById("1");
	}

	//TEST GET 2
	@Test
	public void testFindByIdNotExistingAnimal() throws Exception {
		String id = "100";
		when(animalService.findById(id)).thenReturn(Optional.empty());

		mockMvc.perform(get(BASE_URL + "/" + id))
				.andExpect(status().isNotFound())
				.andExpect(result -> assertTrue(result.getResolvedException() instanceof AnimalNotFoundException))
				.andExpect(result -> assertEquals("404 NOT_FOUND \"Animal with ID: " + id + " not found\"", result.getResolvedException().getMessage()));

		verify(animalService, times(1)).findById(id);
	}

	@Test
	void testGetAll() throws Exception {
		ArrayList<Animal> animals = new ArrayList<>();
		Animal animal = new Animal("117", "caramelo", "cow", "M");
		Animal animal2 = new Animal("JHGKAIG","117", "caramelo", "cow", "M");
		animals.add(animal);
		animals.add(animal2);

		when(animalService.findAll()).thenReturn(animals);

		mockMvc.perform(get(BASE_URL))
				.andExpect(status().isOk());

		verify(animalService, times(1)).findAll();


	}

	//TEST UPDATE 1
	@Test
	public void testUpdateExistingAnimal() throws Exception {
		AnimalDto animalDto = new AnimalDto("1", "caramelo", "cow", "M");
		Animal animal = new Animal("1", animalDto);

		when(animalService.findById("1")).thenReturn(Optional.of(animal));

		String json = "{\"idRanch\":\"1\",\"name\":\"caramelo\",\"type\":\"cow\",\"gender\":\"M\"}";
		mockMvc.perform(put(BASE_URL + "/1")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
						.andExpect(status().isOk());
	}

	//TEST UPDATE 2
	@Test
	public void testUpdateNotExistingUser() throws Exception {
		String id = "1";
		when(animalService.findById(id)).thenReturn(Optional.empty());
		String json = "{\"idRanch\":\"1\",\"name\":\"caramelo\",\"type\":\"cow\",\"gender\":\"M\"}";
		mockMvc.perform(put(BASE_URL + "/" + id)
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(status().isNotFound())
				.andExpect(result -> assertTrue(result.getResolvedException() instanceof AnimalNotFoundException))
				.andExpect(result -> assertEquals("404 NOT_FOUND \"Animal with ID: " + id + " not found\"", result.getResolvedException().getMessage()));

		verify(animalService, times(0)).save(any());
	}

	//TEST SAVE 1
	@Test
	public void testSaveNewAnimal() throws Exception {
		Animal animal = new Animal("117", "caramelo", "cow", "M");

		when(animalService.save(any())).thenReturn(animal);

		String json = "{\"idRanch\":\"117\",\"name\":\"caramelo\",\"type\":\"cow\",\"gender\":\"M\"}";

		mockMvc.perform(post(BASE_URL)
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
						.andExpect(status().isCreated());

		verify(animalService, times(1)).save(any());
	}

	//TEST DELETE
	@Test
	void testDeleteAnimal() throws Exception {
		Animal animal = new Animal("JHGKAIG","117", "caramelo", "cow", "M");

		when(animalService.findById(any())).thenReturn(Optional.of(animal));

		mockMvc.perform(delete(BASE_URL + "/testid")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk());

		verify(animalService, times(1)).delete(any());
	}

	//TEST DELETE
	@Test
	void testDeleteAnimalNotFound() throws Exception {
		when(animalService.findById(any())).thenReturn(Optional.empty());

		mockMvc.perform(delete(BASE_URL + "/testid")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());

		verify(animalService, times(1)).findById(any());
	}
}
