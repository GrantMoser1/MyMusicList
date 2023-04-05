package moser_grant.myMusicList.caseStudy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import moser_grant.myMusicList.caseStudy.model.Review;
import moser_grant.myMusicList.caseStudy.repository.ReviewRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JPAUnitTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  ReviewRepository repository;

  @Test
  public void should_find_no_review_if_repository_is_empty() {
    Iterable review = repository.findAll();

    assertThat(review).isEmpty();
  }

  @Test
  public void should_store_a_review() {
    Review review = repository.save(new Review(1l,"Fizzy Fuzzy Big Buzzy","The Refreshments", "One of my favorite albums ever", 10));

    assertThat(review).hasFieldOrPropertyWithValue("Bandname", "The Refreshments");
    assertThat(review).hasFieldOrPropertyWithValue("albumReview", "One of my favorite albums ever");
  }

//  @Test
//  public void should_find_all_tutorials() { }
//
//  @Test
//  public void should_find_tutorial_by_id() { }
//
//  @Test
//  public void should_find_published_tutorials() { }
//
//  @Test
//  public void should_find_tutorials_by_title_containing_string() { }
//
//  @Test
//  public void should_update_tutorial_by_id() { }
//
//  @Test
//  public void should_delete_tutorial_by_id() { }
//
//  @Test
//  public void should_delete_all_tutorials() { }
}