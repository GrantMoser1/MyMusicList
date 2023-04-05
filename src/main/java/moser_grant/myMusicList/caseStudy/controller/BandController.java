package moser_grant.myMusicList.caseStudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import moser_grant.myMusicList.caseStudy.model.BandReview;
import moser_grant.myMusicList.caseStudy.repository.BandRepository;

@Controller
public class BandController {
	

	@Autowired
	private BandRepository service;

	@GetMapping({"/Bandlist"})
	public ModelAndView getAllBands() {
		ModelAndView mav = new ModelAndView("list-bands");
		mav.addObject("BandReview", service.findAll());
		return mav;
	}

	@GetMapping("/addBandForm")
	public ModelAndView addReviewForm() {
		ModelAndView mav = new ModelAndView("add-band-form");
		BandReview newBand = new BandReview();
		mav.addObject("bandReview", newBand);
		return mav;
	}

	@PostMapping("/saveBandReview")
	public String saveReview(@ModelAttribute BandReview bandReview) {
		service.save(bandReview);
		return "redirect:/Bandlist";
	}

	@GetMapping("/showUpdateBandForm")
	public ModelAndView showUpdateForm(@RequestParam Long reviewId) {
		ModelAndView mav = new ModelAndView("add-band-form");
		BandReview bandReview = service.findById(reviewId).get();
		mav.addObject("bandReview", bandReview);
		return mav;
	}
	@GetMapping("/deleteBandReview/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
		// call delete employee method 
        this.service.deleteById(id);
        return "redirect:/Bandlist";
    }
}
