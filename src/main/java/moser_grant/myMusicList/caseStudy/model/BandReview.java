package moser_grant.myMusicList.caseStudy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BandReview")
@AllArgsConstructor
@NoArgsConstructor
public class BandReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String review;
	private Integer NumOfRecordsOwned;
	
	
	public Integer getNumOfRecordsOwned() {
		return NumOfRecordsOwned;
	}
	public void setNumOfRecordsOwned(Integer numOfRecordsOwned) {
		NumOfRecordsOwned = numOfRecordsOwned;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}

	
}
