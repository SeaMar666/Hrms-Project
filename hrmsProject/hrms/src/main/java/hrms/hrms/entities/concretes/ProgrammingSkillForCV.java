package hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper=false)
@Data
@Table(name = "cv_programming_skills")
@NoArgsConstructor
@AllArgsConstructor
public class ProgrammingSkillForCV extends Base{

	@Column(name = "skill_name")
	private String skillName;
	
	@ManyToOne()
	@JoinColumn(name = "jobseeker_id")
	private Jobseeker jobseeker;
}

