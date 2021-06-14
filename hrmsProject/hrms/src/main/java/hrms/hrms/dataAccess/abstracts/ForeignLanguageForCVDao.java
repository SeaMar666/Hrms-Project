package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.ForeignLanguageForCV;

public interface ForeignLanguageForCVDao extends JpaRepository<ForeignLanguageForCV, Integer>{
	ForeignLanguageForCV getById(int id);
	List<ForeignLanguageForCV> getAllByJobseeker_id(int id);
}