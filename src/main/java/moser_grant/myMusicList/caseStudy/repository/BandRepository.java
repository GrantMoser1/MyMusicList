package moser_grant.myMusicList.caseStudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import moser_grant.myMusicList.caseStudy.model.BandReview;

@Repository
public interface BandRepository extends JpaRepository<BandReview, Long> {

}
