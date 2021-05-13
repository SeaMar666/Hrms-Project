package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstarcts.JobTitlesService;
import hrms.hrms.dataAccess.abstracts.JobTitlesDao;
import hrms.hrms.entities.concretes.JobTitles;

@Service
public class JobTitlesManager implements JobTitlesService{
	
	private JobTitlesDao jobTitlesDao;

	@Autowired
	public JobTitlesManager(JobTitlesDao jobTitlesDao) {
		super();
		this.jobTitlesDao = jobTitlesDao;
	}

	@Override
	public List<JobTitles> getAll() {
		return this.jobTitlesDao.findAll();
	}

}
