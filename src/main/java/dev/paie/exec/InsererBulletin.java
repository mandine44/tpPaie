package dev.paie.exec;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Entreprise;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinRepository;
import dev.paie.repository.RemunerationRepository;



@Profile("InsererBulletin")
@Controller
public class InsererBulletin implements CommandLineRunner{

	private BulletinRepository bulletinRepository;
	private RemunerationRepository remunerationRepository;
	private Scanner scanner;

	public InsererBulletin(BulletinRepository bulletinRepository, RemunerationRepository remunerationRepository, Scanner scanner) {
		super();
		this.bulletinRepository = bulletinRepository;
		this.remunerationRepository=remunerationRepository;
		this.scanner = scanner;
	}

	@Override
	public void run(String... args) throws Exception {
		BulletinSalaire bulletinSalaire = new BulletinSalaire();
		
		System.out.println("Quel est l'id de la remuneration employe?");
		int n= scanner.nextInt();
		Optional<RemunerationEmploye> r = remunerationRepository.findById(n);
		if(r.isPresent()) {
			bulletinSalaire.setRemunerationEmploye(r.get());
		}
		else {
			System.out.println("cet id n'existe pas");
		}
			
		int compteur =(int) bulletinRepository.count();
		bulletinSalaire.setId(Integer.valueOf(compteur+1));
		
		this.bulletinRepository.save(bulletinSalaire);
	}
	
}
