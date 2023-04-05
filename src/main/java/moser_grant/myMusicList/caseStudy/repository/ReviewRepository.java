package moser_grant.myMusicList.caseStudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import moser_grant.myMusicList.caseStudy.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

	 List<Review> findByName(String name);

	

}
