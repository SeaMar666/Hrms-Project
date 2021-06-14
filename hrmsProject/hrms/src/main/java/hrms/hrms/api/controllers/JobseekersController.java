package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstarcts.JobseekerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Jobseeker;
import hrms.hrms.entities.dtos.CandidateCVDto;

@RestController
@RequestMapping("/api/candidates")
public class JobseekersController {

	private JobseekerService jobseekerService;

	@Autowired
	public JobseekersController(JobseekerService jobseekerService) {
		super();
		this.jobseekerService = jobseekerService;
	}
	
	public Result add(@RequestBody Jobseeker jobseeker)
	{
		return this.jobseekerService.add(jobseeker);
	}
	
	public DataResult<List<Jobseeker>> getAll(){
		return this.jobseekerService.getAll();
	}
	
	@GetMapping("/getJobseekerCVById")
	public DataResult<CandidateCVDto> getJobseekerCVById(@RequestParam int id){
		return this.jobseekerService.getCandidateCVById(id);
	}
	
}
