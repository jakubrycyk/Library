package com.umcs.library;

import com.umcs.library.book.controller.BookController;
import com.umcs.library.book.domain.Book;
import com.umcs.library.borrow.controller.BorrowController;
import com.umcs.library.borrow.domain.Borrow;
import com.umcs.library.person.controller.PersonController;
import com.umcs.library.person.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


import java.time.LocalDate;

@Slf4j
@SpringBootApplication
@ImportResource("classpath:app-config.xml")
public class LibraryApplication implements CommandLineRunner{

	PersonController personController;
	BookController bookController;
	BorrowController borrowController;

	public LibraryApplication(PersonController personController, BookController bookController, BorrowController borrowController) {
		this.personController = personController;
		this.bookController = bookController;
		this.borrowController = borrowController;
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		log.info(" W bazie jest 2 użytkowników + 2 książki");
		log.info("Lista osób: " + personController.findAll().toString());
		log.info("Lista książek: " + bookController.findAll().toString());
		log.info("Lista wypożyczeń: " + borrowController.findAll().toString());
		log.info(" Dodanie użytkownika");
		Person person = new Person("NowyUżytkownik", "NowyUżytkownik", LocalDate.now().minusYears(20));
		personController.insert(person);
		log.info(personController.findAll().toString());
		log.info("Dodanie książki (zakup)");
		Book book = new Book("JanKsiazka", "JanKsiazka", false, LocalDate.now());
		bookController.insert(book);
		log.info(bookController.findAll().toString());
		log.info("Zgubienie książki");
		Book bookLost = bookController.findById(2);
		log.info(bookLost.toString());
		bookLost.setIsLost(true);
		bookController.update(bookLost);
		bookLost = bookController.findById(2);
		log.info(bookLost.toString());
		log.info(" Wypożyczenie książki");
		person = personController.findById(1);
		log.info(person.toString());
		book = bookController.findById(1);
		log.info(book.toString());
		Borrow borrow = new Borrow(person.getId(), book.getId(), LocalDate.now().minusWeeks(2));
		borrowController.insert(borrow);
		log.info(borrowController.findAll().toString());
		log.info("Liczba książek, wypożyczonych książek, oraz nie wypożyczonych.");
		log.info(String.valueOf(bookController.getBorrowedCount()));
		log.info(String.valueOf(bookController.getNonBorrowedCount()));
		log.info(" Naliczenie kary oddania");
		borrow = borrowController.findById(1);
		borrow.setReturnDate(LocalDate.now());
		borrowController.update(borrow);
		borrow = borrowController.findById(1);
		log.info(borrow.toString());
		log.info(String.valueOf(borrow.getPenalty() + " zl"));
	}
}
