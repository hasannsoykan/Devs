package kodlama.io.Devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Devs.business.responses.GetByIdProgrammingLanguagesResponse;
import kodlama.io.Devs.business.rules.ProgrammingLanguageBusinessRules;
import kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	private ProgrammingLanguageRepository programmingLanguageRepository;
	private ModelMapperService modelMapperService;
	private ProgrammingLanguageBusinessRules programmingLanguageBusinessRules;

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		programmingLanguageBusinessRules.checkIfLanguageNameExists(createProgrammingLanguageRequest.getName());
		ProgrammingLanguage programmingLanguage = modelMapperService.forRequest()
				.map(createProgrammingLanguageRequest, ProgrammingLanguage.class);
		programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public void delete(int id) {
		programmingLanguageRepository.deleteById(id);

	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		programmingLanguageBusinessRules.checkIfLanguageNameExists(updateProgrammingLanguageRequest.getName());
		ProgrammingLanguage programmingLanguage = modelMapperService.forRequest()
				.map(updateProgrammingLanguageRequest, ProgrammingLanguage.class);
		programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> languagesResponse = programmingLanguages.stream()
				.map(programmingLanguage -> modelMapperService.forResponse()
						.map(programmingLanguage, GetAllProgrammingLanguagesResponse.class))
						.collect(Collectors.toList());
		return languagesResponse;
	}

	@Override
	public GetByIdProgrammingLanguagesResponse getById(int id) {
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).orElseThrow();
		GetByIdProgrammingLanguagesResponse languagesResponse = modelMapperService.forResponse()
				.map(programmingLanguage, GetByIdProgrammingLanguagesResponse.class);
		return languagesResponse;
	}

}
