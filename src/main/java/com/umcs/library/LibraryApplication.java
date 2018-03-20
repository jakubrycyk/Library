package com.umcs.library;

import com.umcs.library.book.controller.BookController;
import com.umcs.library.book.domain.Book;
import com.umcs.library.borrow.controller.BorrowController;
import com.umcs.library.borrow.domain.Borrow;
import com.umcs.library.person.controller.PersonController;
import com.umcs.library.person.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZoneId;
import java.util.Date;
import java.time.LocalDate;

@Slf4j
@SpringBootApplication
public class LibraryApplication implements CommandLineRunner{

	PersonController personController;
	BookController bookController;
	BorrowController borrowController;

	@Autowired
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
		initFirstValues();
		log.info(" W bazie jest 2 użytkowników + 2 książki");
		log.info("Lista osób: " + personController.findAll().toString());
		log.info("Lista książek: " + bookController.findAll().toString());
		log.info("Lista wypożyczeń: " + borrowController.findAll().toString());
		log.info(" Dodanie użytkownika");
		Person person = new Person("NowyUżytkownik", "NowyUżytkownik", Date.from(LocalDate.now().minusYears(20).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		personController.insert(person);
		log.info(personController.findAll().toString());
		log.info("Dodanie książki (zakup)");
		Book book = new Book("JanKsiazka", "JanKsiazka", false, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		bookController.insert(book);
		log.info(bookController.findAll().toString());
		log.info("Zgubienie książki");
		Book bookLost = bookController.findById(2).get();
		log.info(bookLost.toString());
		log.info(bookLost.toString());
		bookLost.setIsLost(true);
		bookController.update(bookLost);
		bookLost = bookController.findById(2).get();
		log.info(bookLost.toString());
		log.info(" Wypożyczenie książki");
		person = personController.findById(1).get();
		log.info(person.toString());
		book = bookController.findById(1).get();
		log.info(book.toString());
		Borrow borrow = new Borrow(person, book, Date.from(LocalDate.now().minusWeeks(2).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		borrowController.insert(borrow);
		log.info(borrowController.findAll().toString());
		log.info("Liczba książek, wypożyczonych książek, oraz nie wypożyczonych.");
		log.info(String.valueOf(bookController.getBorrowedCount()));
		log.info(String.valueOf(bookController.getNonBorrowedCount()));
		log.info(" Naliczenie kary oddania");
		borrow = borrowController.findById(1).get();
		borrow.setReturnDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		borrowController.update(borrow);
		borrow = borrowController.findById(1).get();
		log.info(borrow.toString());
		log.info(String.valueOf(borrow.getPenalty() + " zl"));
		log.info("END");
	}

	public void initFirstValues(){
		personController.insert(new Person("John", "Smith", Date.from(LocalDate.now().minusYears(30).atStartOfDay(ZoneId.systemDefault()).toInstant())));
		personController.insert(new Person("'Fred'", "'Bloggs'", Date.from(LocalDate.now().minusYears(15).atStartOfDay(ZoneId.systemDefault()).toInstant())));

		bookController.insert(new Book("Ksiazka1", "Autor1", false, Date.from(LocalDate.now().minusWeeks(3).atStartOfDay(ZoneId.systemDefault()).toInstant())));
		bookController.insert(new Book("Ksiązka2", "Autor2", false, Date.from(LocalDate.now().minusWeeks(1).atStartOfDay(ZoneId.systemDefault()).toInstant())));
	}
}
