package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;

public interface TechnologyService {
	void add(CreateTechnologyRequest createTechnologyRequest);
	void delete(DeleteTechnologyRequest deleteTechnologyRequest);
	void update(UpdateTechnologyRequest updateTechnologyRequest);
	List<GetAllTechnologiesResponse> getAll();

}
