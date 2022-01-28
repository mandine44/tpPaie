package dev.paie.exec;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRepository;
import dev.paie.repository.RemunerationRepository;

@Controller
@Profile("InsererRemuneration")
public class InsererRemuneration implements CommandLineRunner{

	
	private RemunerationRepository remunerationRepository;
	private EntrepriseRepository entrepriseRepository;
	private GradeRepository gradeRepository;
	private ProfilRepository profilRepository;
	private Scanner scanner;

	public InsererRemuneration(RemunerationRepository remunerationRepository, EntrepriseRepository entrepriseRepository, ProfilRepository profilRepository,GradeRepository gradeRepository,Scanner scanner) {
		super();
		this.remunerationRepository = remunerationRepository;
		this.entrepriseRepository= entrepriseRepository;
		this.gradeRepository= gradeRepository;
		this.profilRepository=profilRepository;
		this.scanner=scanner;
	}

	@Override
	public void run(String... args) throws Exception {
		
		RemunerationEmploye remuneration = new RemunerationEmploye();
		
		System.out.println("Quel est l'id de l'entreprise dans laquelle vous travaillez?");
		int n= scanner.nextInt();
		Optional<Entreprise> e = entrepriseRepository.findById(n);
		if(e.isPresent()) {
			remuneration.setEntreprise(e.get());
		}
		else {
			System.out.println("cet id n'existe pas");
		}
		
		
		System.out.println("Quel est l'id du grade ?");
		int k= scanner.nextInt();
		Optional<Grade> g = gradeRepository.findById(k);
		if(g.isPresent()) {
			remuneration.setGrade(g.get());
		}
		else {
			System.out.println("cet id n'existe pas");
		}
		
		
		System.out.println("Quel est l'id du profil ?");
		int m= scanner.nextInt();
		Optional<ProfilRemuneration> p = profilRepository.findById(m);
		if(p.isPresent()) {
			remuneration.setProfil(p.get());
		}
		else {
			System.out.println("cet id n'existe pas");
		}
		
		
		System.out.println("Quel est votre matricule ?");
		String mat= scanner.next();
		remuneration.setMatricule(mat);

		int compteur =(int) remunerationRepository.count();
		remuneration.setId(Integer.valueOf(compteur+1));
				
		this.remunerationRepository.save(remuneration);
	}
}
