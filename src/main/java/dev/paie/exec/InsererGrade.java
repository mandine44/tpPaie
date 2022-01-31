package dev.paie.exec;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.paie.entite.Grade;
import dev.paie.repository.GradeRepository;

@Profile("InsererGrade")
@Controller
public class InsererGrade implements CommandLineRunner {

	private GradeRepository gradeRepository;
	private Scanner scanner;

	public InsererGrade(GradeRepository gradeRepository, Scanner scanner) {
		super();
		this.gradeRepository = gradeRepository;
		this.scanner=scanner;
	}

	@Override
	public void run(String... args) throws Exception {
		Grade grade = new Grade();

		int compteur =(int) gradeRepository.count();
		grade.setId(Integer.valueOf(compteur+1));
		
		String nomGrade;		
		System.out.println("Quel  est le nom du grade que vous souhaitez ajouter?");
		nomGrade = scanner.next();
		grade.setCode(nomGrade);
		
		int heureBase;		
		System.out.println("Rentrez le nombre d'heure base");
		heureBase = scanner.nextInt();
		grade.setNbHeuresBase(BigDecimal.valueOf(heureBase));
		
		int tauxBase;		
		System.out.println("Rentrez le taux");
		tauxBase = scanner.nextInt();		
		grade.setTauxBase(BigDecimal.valueOf(tauxBase));
				
		this.gradeRepository.save(grade);
	}
}
