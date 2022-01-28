package dev.paie.exec;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.paie.entite.Grade;
import dev.paie.repository.GradeRepository;

@Profile("InsererGrade")
@Controller
public class InsererGrade implements CommandLineRunner {

	private GradeRepository gradeRepository;

	public InsererGrade(GradeRepository gradeRepository) {
		super();
		this.gradeRepository = gradeRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Grade grade = new Grade();
		grade.setId(4);
		grade.setCode("D");
		grade.setNbHeuresBase(BigDecimal.valueOf(152));
		grade.setTauxBase(BigDecimal.valueOf(41));
				
		this.gradeRepository.save(grade);
	}
}
