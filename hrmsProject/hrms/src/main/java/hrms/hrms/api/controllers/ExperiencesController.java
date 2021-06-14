package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstarcts.ExperienceCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.ExperienceForCV;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {
	
	private ExperienceCVService experienceForCVService;

	@Autowired
	public ExperiencesController(ExperienceCVService experienceForCVService) {
		super();
		this.experienceForCVService = experienceForCVService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ExperienceForCV experienceForCV){
		return this.experienceForCVService.add(experienceForCV);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody ExperienceForCV experienceForCV){
		return this.experienceForCVService.update(experienceForCV);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.experienceForCVService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<ExperienceForCV> getById(@RequestParam int id){
		return this.experienceForCVService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ExperienceForCV>> getAll(){
		return this.experienceForCVService.getAll();
	}
	
	@GetMapping("/getAllByJobseekerIdOrderByEndAtDesc")
	public DataResult<List<ExperienceForCV>> getAllByJobseeker_idOrderByEndAtDesc(@RequestParam("id") int id){
		return this.experienceForCVService.getAllByJobseeker_idOrderByEndAtDesc(id);
	}
	
	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<ExperienceForCV>> getAllByJobseeker_id(@RequestParam int id){
		return this.experienceForCVService.getAllByJobseeker_id(id);
	}
	
	

}
