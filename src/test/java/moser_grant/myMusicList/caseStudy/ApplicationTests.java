package moser_grant.myMusicList.caseStudy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import moser_grant.myMusicList.caseStudy.controller.BandController;
import moser_grant.myMusicList.caseStudy.controller.MainController;
import moser_grant.myMusicList.caseStudy.controller.ReviewController;

import moser_grant.myMusicList.caseStudy.controller.UserRegistrationController;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

	// Testing Controllers
	@Autowired
	private ReviewController reviewController;

	@Test
	public void contextLoadsReview() throws Exception {
		assertThat(reviewController).isNotNull();
	}

	@Autowired
	private BandController bandController;

	@Test
	public void contextLoadsBand() throws Exception {
		assertThat(bandController).isNotNull();
	}

	@Autowired
	private MainController mainController;

	@Test
	public void contextLoadsMain() throws Exception {
		assertThat(mainController).isNotNull();
	}

	@Autowired
	private UserRegistrationController userController;

	@Test
	public void contextLoadsReg() throws Exception {
		assertThat(userController).isNotNull();
	}

	// *******************************************************************************************//
	//Tests HTML pages
	@Value(value = "${local.server.port}")
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class))
				.contains("Login page");
	}
	
//	@Test
//	public void reviewShouldReturnDefaultMessage() throws Exception {
//		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/list-reviews", String.class))
//				.contains("List Reivews");
//	}
//	@Test
//	public void addreivewShouldReturnDefaultMessage() throws Exception {
//		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/add-list-form", String.class))
//				.contains("Add review");
//	}
//	@Test
//	public void	BandShouldReturnDefaultMessage() throws Exception {
//		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/list-bands", String.class))
//				.contains("List Band Reivews");
//	}
//	@Test
//	public void	addBandShouldReturnDefaultMessage() throws Exception {
//		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/add-band-form", String.class))
//				.contains("Add Band review");
//	}
	

}
