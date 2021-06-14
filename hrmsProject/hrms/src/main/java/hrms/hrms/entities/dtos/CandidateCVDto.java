package hrms.hrms.entities.dtos;

import java.util.List;

import hrms.hrms.entities.concretes.Jobseeker;
import hrms.hrms.entities.concretes.ExperienceForCV;
import hrms.hrms.entities.concretes.ForeignLanguageForCV;
import hrms.hrms.entities.concretes.ImageForCV;
import hrms.hrms.entities.concretes.LinkForCV;
import hrms.hrms.entities.concretes.ProgrammingSkillForCV;
import hrms.hrms.entities.concretes.SchoolCV;

public class CandidateCVDto {

	public Jobseeker jobseeker;
	public List<SchoolCV> schools;
	public List<ProgrammingSkillForCV> programingSkills;
	public List<LinkForCV> links;
	public List<ForeignLanguageForCV> languages;
	public List<ExperienceForCV> experiences;
	public ImageForCV image;
}
