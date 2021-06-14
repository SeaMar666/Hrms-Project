package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstarcts.CoverLetterService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.CoverLetterForCV;

@RestController
@RequestMapping("/api/coverletters")
public class CoverLettersContollerController {

	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLettersContollerController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CoverLetterForCV coverLetterForCV){
		return this.coverLetterService.add(coverLetterForCV);
	}
	
	@PostMapping("update")
	public Result update(@RequestBody CoverLetterForCV coverLetterForCV){
		return this.coverLetterService.update(coverLetterForCV);
	}
	
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.coverLetterService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CoverLetterForCV> getById(@RequestParam("id") int id){
		return this.coverLetterService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CoverLetterForCV>> getAll(){
		return this.coverLetterService.getAll();
	}

}
