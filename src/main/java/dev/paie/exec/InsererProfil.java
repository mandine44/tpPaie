package dev.paie.exec;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;


import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.GradeRepository;import dev.paie.repository.ProfilRepository;

@Controller
@Profile("InsererProfil")
public class InsererProfil implements CommandLineRunner {

	private ProfilRepository profilRepository;
	private Scanner scanner;

	public InsererProfil(ProfilRepository profilRepository, Scanner scanner) {
		super();
		this.profilRepository = profilRepository;
		this.scanner = scanner;
	}

	@Override
	public void run(String... args) throws Exception {
		ProfilRemuneration profil = new ProfilRemuneration();
		
		String nomProfil;		
		System.out.println("Quel est le nom du profil que vous souhaitez ajouter?");
		nomProfil = scanner.next();
		profil.setCode(nomProfil);
		
		
		int compteur =(int) profilRepository.count();
		profil.setId(Integer.valueOf(compteur+1));
				
		this.profilRepository.save(profil);
	}
}
