package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Devs.business.responses.GetByIdProgrammingLanguagesResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/languages")
@AllArgsConstructor
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		programmingLanguageService.add(createProgrammingLanguageRequest);
	} 

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		programmingLanguageService.delete(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody @Valid UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		programmingLanguageService.update(updateProgrammingLanguageRequest);
	}

	@GetMapping("/getall")
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		return programmingLanguageService.getAll();
	}

	@GetMapping("/getbyid/{id}")
	public GetByIdProgrammingLanguagesResponse getById(@PathVariable int id) {
		return programmingLanguageService.getById(id);
	}

}
