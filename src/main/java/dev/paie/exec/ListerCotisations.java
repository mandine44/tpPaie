package dev.paie.exec;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.paie.repository.CotisationRepository;

@Profile("ListerCotisations")
@Controller
public class ListerCotisations implements CommandLineRunner {

	
	private CotisationRepository cotisationRepository;

	public ListerCotisations(CotisationRepository cotisationRepository) {
		super();
		this.cotisationRepository = cotisationRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
	
		System.out.println(cotisationRepository.findAll());
	}
}
