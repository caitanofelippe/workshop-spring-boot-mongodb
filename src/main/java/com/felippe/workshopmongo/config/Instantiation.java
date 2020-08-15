package com.felippe.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.felippe.workshopmongo.domain.Post;
import com.felippe.workshopmongo.domain.User;
import com.felippe.workshopmongo.dto.AuthorDTO;
import com.felippe.workshopmongo.dto.CommentDTO;
import com.felippe.workshopmongo.repository.PostRepository;
import com.felippe.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		List<User> list = new ArrayList<User>();
		list.addAll(Arrays.asList(maria, alex, bob));

		userRepository.saveAll(list);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		Post post1 = new Post(null, sdf.parse("21/03/2020"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!",new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("21/03/2020"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

		List<Post> listPost = new ArrayList<>();
		listPost.addAll(Arrays.asList(post1, post2));
		
		
		CommentDTO comments1 = new CommentDTO("Boa viagem man", sdf.parse("21/03/2020"), new AuthorDTO(alex));
		CommentDTO comments2 = new CommentDTO("Aproveite", sdf.parse("21/03/2020"), new AuthorDTO(bob));
		CommentDTO comments3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("22/03/2020"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(comments1, comments2));
		post2.getComments().addAll(Arrays.asList(comments3));
		
		postRepository.saveAll(listPost);
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);

	}

}
