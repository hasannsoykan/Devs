package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Devs.business.responses.GetByIdProgrammingLanguagesResponse;

public interface ProgrammingLanguageService {

	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);
	void delete(int id);
	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);
	List<GetAllProgrammingLanguagesResponse> getAll();
	GetByIdProgrammingLanguagesResponse getById(int id);
	
}
