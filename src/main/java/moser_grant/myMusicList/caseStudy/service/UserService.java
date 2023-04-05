package moser_grant.myMusicList.caseStudy.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import moser_grant.myMusicList.caseStudy.model.User;
import moser_grant.myMusicList.caseStudy.model.UserRegistrationDto;

public interface UserService extends UserDetailsService {
   User findByEmail(String email);
   User save(UserRegistrationDto registration);
}