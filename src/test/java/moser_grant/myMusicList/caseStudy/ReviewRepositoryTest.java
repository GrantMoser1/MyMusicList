package moser_grant.myMusicList.caseStudy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import moser_grant.myMusicList.caseStudy.model.Review;
import moser_grant.myMusicList.caseStudy.repository.ReviewRepository;

@DataJpaTest
public class ReviewRepositoryTest {

	@Autowired
	private ReviewRepository reviewRepository;

	private Review review;

	@BeforeEach
	public void setup() {
		review = Review.builder().id(1L).name("Fizzy Fuzzy Big Buzzy").Bandname("The Refreshments")
				.albumReview("One of my favorite albums ever").score(10).build();
	}
	
	
	// JUnit test for save review operation
	// @DisplayName("JUnit test for save review operation")
	@Test
	public void givenreviewObject_whenSave_thenReturnSavedreview() {

		// given - precondition or setup
		Review review = Review.builder().id(1L).name("Fizzy Fuzzy Big Buzzy").Bandname("The Refreshments")
				.albumReview("One of my favorite albums ever").score(10).build();
		// when - action or the behaviour that we are going test
		Review savedReview = reviewRepository.save(review);

		// then - verify the output
		assertThat(savedReview).isNotNull();
		assertThat(savedReview.getId()).isGreaterThan(0);
	}

	// JUnit test for get all reviews operation
	@DisplayName("JUnit test for get all reviews operation")
	@Test
	public void givenreviewsList_whenFindAll_thenreviewsList() {
		// given - precondition or setup

		Review review1 = Review.builder().id(1L).name("Fizzy Fuzzy Big Buzzy").Bandname("The Refreshments")
				.albumReview("One of my favorite albums ever").score(10).build();

		reviewRepository.save(review);
		reviewRepository.save(review1);

		// when - action or the behaviour that we are going test
		List<Review> reviewList = reviewRepository.findAll();

		// then - verify the output
		assertThat(reviewList).isNotNull();
		assertThat(reviewList.size()).isEqualTo(2);

	}

	// JUnit test for get review by id operation
	@DisplayName("JUnit test for get review by id operation")
	@Test
	public void givenreviewObject_whenFindById_thenReturnreviewObject() {

		reviewRepository.save(review);

		// when - action or the behaviour that we are going test
		Review reviewDB = reviewRepository.findById(review.getId()).get();

		// then - verify the output
		assertThat(reviewDB).isNotNull();
	}

	// JUnit test for update review operation
	@DisplayName("JUnit test for update review operation")
	@Test
	public void givenreviewObject_whenUpdatereview_thenReturnUpdatedreview() {

		reviewRepository.save(review);

		// when - action or the behaviour that we are going test
		Review savedreview = reviewRepository.findById(review.getId()).get();
		savedreview.setBandname("The Refreshments");
		;
		savedreview.setName("Fizzy Fuzzy Big Buzzy");
		Review updatedreview = reviewRepository.save(savedreview);

		// then - verify the output
		assertThat(updatedreview.getBandname()).isEqualTo("The Refreshments");
		assertThat(updatedreview.getName()).isEqualTo("Fizzy Fuzzy Big Buzzy");
	}

	// JUnit test for delete review operation
	@DisplayName("JUnit test for delete review operation")
	@Test
	public void givenreviewObject_whenDelete_thenRemovereview() {

		reviewRepository.save(review);

		// when - action or the behaviour that we are going test
		reviewRepository.deleteById(review.getId());
		Optional<Review> reviewOptional = reviewRepository.findById(review.getId());

		// then - verify the output
		assertThat(reviewOptional).isEmpty();
	}
}
