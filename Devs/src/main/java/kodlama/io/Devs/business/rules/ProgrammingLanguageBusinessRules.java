package kodlama.io.Devs.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.core.exceptions.BusinessException;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageBusinessRules {
	private ProgrammingLanguageRepository programmingLanguageRepository;

	public void checkIfLanguageNameExists(String name) {
		if (programmingLanguageRepository.existsByName(name)) {
			throw new BusinessException("Language name already exists");
		}
	}

}
