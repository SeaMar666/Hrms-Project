package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobTitles;

public interface JobTitlesDao extends JpaRepository<JobTitles, Integer>{

}
