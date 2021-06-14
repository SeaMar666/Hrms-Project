package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.SchoolCV;

public interface SchoolCVDao extends JpaRepository<SchoolCV, Integer>{
	SchoolCV getById(int id);
	List<SchoolCV> getAllByJobseeker_idOrderByEndAtDesc(int id);
	List<SchoolCV> getAllByJobseeker_id(int id);
}