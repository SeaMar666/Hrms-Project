package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstarcts.JobTitleService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.JobPosition;



@RestController
@RequestMapping("/api/jobTitles")
public class JobTitlesController {
	
	private JobTitleService jobTitleService;
	
    @Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
    
    @GetMapping("/getall")
    public DataResult<List<JobPosition>>  getAll(){
    	return this.jobTitleService.getAll();
    }
    
	
	@PostMapping("/add")
	public void add(@RequestBody JobPosition jobPosition) {
		
		this.jobTitleService.add(jobPosition); 
		
	}
    
}
