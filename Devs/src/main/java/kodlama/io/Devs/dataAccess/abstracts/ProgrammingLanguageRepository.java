package kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer>{
	boolean existsByName(String name);
 
}
