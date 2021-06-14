package hrms.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "jobseekers")
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
public class Jobseeker extends User{
	
	@Column(name= "first_name")
	private String firstName;
	
	@Column(name= "last_name")
	private String lastName;
	
	@Column(name= "national_id")
	private String nationalId;
	
	@Column(name= "date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name = "is_verified", columnDefinition = "boolean default false")
	private boolean isVerified = false;

	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<SchoolCV> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<ProgrammingSkillForCV> programingSkills;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<LinkForCV> links;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<ForeignLanguageForCV> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<ExperienceForCV> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<CoverLetterForCV> coverLetters;	

	@JsonIgnore
	@OneToOne(mappedBy = "jobseeker", optional=false, fetch=FetchType.LAZY)
	private ImageForCV image;
	
	

}
