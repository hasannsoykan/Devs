package kodlama.io.Devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.Devs.business.rules.TechnologyBusinessRules;
import kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Devs.entities.concretes.Technology;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TechnologyManager implements TechnologyService{

	private TechnologyRepository technologyRepository;
	private ModelMapperService modelMapperService;
	private TechnologyBusinessRules technologyBusinessRules;
	
	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		technologyBusinessRules.checkIfTechnologyNameExists(createTechnologyRequest.getName());
		Technology technology = modelMapperService.forRequest()
				.map(createTechnologyRequest, Technology.class);
		technologyRepository.save(technology);
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		Technology technology = modelMapperService.forRequest()
				.map(deleteTechnologyRequest, Technology.class);
		technologyRepository.delete(technology);		
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		technologyBusinessRules.checkIfTechnologyNameExists(updateTechnologyRequest.getName());
		Technology technology = modelMapperService.forRequest()
				.map(updateTechnologyRequest, Technology.class);
		technologyRepository.save(technology);
	}

	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologiesResponse> technologiesResponse = technologies.stream()
				.map(technology -> modelMapperService.forResponse()
						.map(technology, GetAllTechnologiesResponse.class))
						.collect(Collectors.toList());
		return technologiesResponse;
	}

}
