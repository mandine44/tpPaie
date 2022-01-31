package dev.paie.exec;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.paie.PaieAppApplication;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.RemunerationEmploye;

@Profile("Menu")
@Controller
public class Menu implements CommandLineRunner {

	private Scanner scanner;

	public Menu(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Souhaitez-vous: ");
		System.out.println("1 - Lister les cotisations ");
		System.out.println("2 - Inserer une rémunération? ");
		System.out.println("3 - Inserer un bulletin? ");
		System.out.println("4 - Inserer un profil de remuneration? ");
		System.out.println("5 - Inserer un grade? ");
		int n = scanner.nextInt();

		if (n == 1) {
			new SpringApplicationBuilder(PaieAppApplication.class).profiles("ListerCotisations") // activation d'un profil
					.build().run(args);

		} else if (n == 2) {
			new SpringApplicationBuilder(PaieAppApplication.class).profiles("InsererRemuneration") // activation d'un profil
					.build().run(args);

		} else if (n == 3) {
			new SpringApplicationBuilder(PaieAppApplication.class).profiles("InsererBulletin") // activation d'un profil
					.build().run(args);

		} else if (n == 4) {
			new SpringApplicationBuilder(PaieAppApplication.class).profiles("InsererProfil") // activation d'un profil
					.build().run(args);

		} else if (n == 5) {
			new SpringApplicationBuilder(PaieAppApplication.class).profiles("InsererGrade") // activation d'un profil
					.build().run(args);

		} else {
			System.out.println("Entree non valide. Saisissez un entier entre 1 et 5");

		}

	}
}
