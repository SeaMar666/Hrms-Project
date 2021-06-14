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
@Table(name="cv_links")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkForCV extends Base{
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "url")
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "jobseeker_id")
	private Jobseeker jobseeker;

}
