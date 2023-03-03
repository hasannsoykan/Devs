package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/technologies")
@AllArgsConstructor
public class TechnologiesController {

	private TechnologyService technologyService;

	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public void add(@RequestBody @Valid CreateTechnologyRequest createTechnologyRequest) {
		technologyService.add(createTechnologyRequest);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody @Valid DeleteTechnologyRequest deleteTechnologyRequest) {
		technologyService.delete(deleteTechnologyRequest);
	}

	@PutMapping("/update")
	public void update(@RequestBody @Valid UpdateTechnologyRequest updateTechnologyRequest) {
		technologyService.update(updateTechnologyRequest);
	}

	@GetMapping("/getall")
	public List<GetAllTechnologiesResponse> getAll() {
		return technologyService.getAll();
	}

}
