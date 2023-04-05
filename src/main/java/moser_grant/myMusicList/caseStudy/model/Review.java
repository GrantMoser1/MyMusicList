package moser_grant.myMusicList.caseStudy.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "review")
@Builder
public class Review {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String Bandname;
	private String albumReview;
	private Integer score;
	 
	
	
	public Review() {
	}
	public Review(Long id, String name, String bandname, String albumReview, Integer score) {
		this.id = id;
		this.name = name;
		Bandname = bandname;
		this.albumReview = albumReview;
		this.score = score;
	}
	public String getBandname() {
		return Bandname;
	}
	public void setBandname(String bandname) {
		Bandname = bandname;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
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
	public String getAlbumReview() {
		return albumReview;
	}
	public void setAlbumReview(String albumReview) {
		this.albumReview = albumReview;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", name=" + name + ", Bandname=" + Bandname + ", albumReview=" + albumReview
				+ ", score=" + score + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Bandname, albumReview, id, name, score);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		return Objects.equals(Bandname, other.Bandname) && Objects.equals(albumReview, other.albumReview)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(score, other.score);
	}
	
	
	

	
}
