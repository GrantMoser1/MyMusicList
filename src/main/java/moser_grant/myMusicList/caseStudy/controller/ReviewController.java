package moser_grant.myMusicList.caseStudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import moser_grant.myMusicList.caseStudy.model.Review;
import moser_grant.myMusicList.caseStudy.repository.ReviewRepository;

@Controller
public class ReviewController {

	@Autowired
	private ReviewRepository service;

	@GetMapping({"/list"})
	public ModelAndView getAllReviews() {
		ModelAndView mav = new ModelAndView("list-reviews");
		mav.addObject("reviews", service.findAll());
		return mav;
	}

	@GetMapping("/addReviewForm")
	public ModelAndView addReviewForm() {
		ModelAndView mav = new ModelAndView("add-review-form");
		Review newReview = new Review();
		mav.addObject("review", newReview);
		return mav;
	}

	@PostMapping("/saveReview")
	public String saveReview(@ModelAttribute("review") Review review) {
		service.save(review);
		return "redirect:/list";
	}

	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long reviewId) {
		ModelAndView mav = new ModelAndView("add-review-form");
		Review review = service.findById(reviewId).get();
		mav.addObject("review", review);
		return mav;
	}
	@GetMapping("/deleteAlbumReview/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
		// call delete employee method 
        this.service.deleteById(id);
        return "redirect:/list";
    }
}
