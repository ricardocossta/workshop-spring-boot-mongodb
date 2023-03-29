package com.ricardocosta.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ricardocosta.workshopmongo.domain.Post;
import com.ricardocosta.workshopmongo.domain.User;
import com.ricardocosta.workshopmongo.repository.PostRepository;
import com.ricardocosta.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2023"), "Partiu Viagem", "Vou viajar para SP, abraços", maria);
		Post post2 = new Post(null, sdf.parse("07/02/2023"), "Bom dia", "Bom dia a todos do site!", maria);
		
		userRepository.saveAll(List.of(maria, alex, bob));
		postRepository.saveAll(List.of(post1, post2));
		
	}

}
