package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstarcts.SchoolForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.SchoolCV;

public class SchoolsController {

	private SchoolForCVService schoolForCVService;

	@Autowired
	public SchoolsController(SchoolForCVService schoolForCVService) {
		super();
		this.schoolForCVService = schoolForCVService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SchoolCV schoolForCV){
		return this.schoolForCVService.add(schoolForCV);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody SchoolCV schoolForCV){
		return this.schoolForCVService.update(schoolForCV);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id){
		return this.schoolForCVService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<SchoolCV> getById(@RequestParam int id){
		return this.schoolForCVService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<SchoolCV>> getAll(){
		return this.schoolForCVService.getAll();
	}
	
	@GetMapping("/getAllByJobseekerIdOrderByEndAtDesc")
	public DataResult<List<SchoolCV>> getAllByJobseekerIdOrderByEndAtDesc(@RequestParam int id){
		return this.schoolForCVService.getAllByJobseekerIdOrderByEndAtDesc(id);
	}
	
	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<SchoolCV>> getAllByJobseekerId(@RequestParam int id){
		return this.schoolForCVService.getAllByJobseekerId(id);
	}

}
