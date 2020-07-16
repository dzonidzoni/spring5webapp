package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import guru.springframework.spring5webapp.domain.*;
import guru.springframework.spring5webapp.repositories.*;

@Component
public class BootStrapData implements CommandLineRunner
{
	private final AuthorRepository _authorRepository;
	private final BookRepository _bookRepository;
	private final PublisherRepository _publisherRepository;

	public BootStrapData(
		final AuthorRepository authorRepository,
		final BookRepository bookRepository,
		final PublisherRepository publisherRepository)
	{
		this._authorRepository = authorRepository;
		this._bookRepository = bookRepository;
		this._publisherRepository = publisherRepository;
	}

	@Override
	public void run(final String... args) throws Exception
	{
		final Publisher publisher = new Publisher("someone1", "Address line 1", "city1", "state1", "18000");
		_publisherRepository.save(publisher);

		final Author eric = new Author("Eric", "Evan");
		final Book ddd = new Book("Domain Driven Design", "123123");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		ddd.setPublisher(publisher);
		publisher.getBooks().add(ddd);

		_authorRepository.save(eric);
		_bookRepository.save(ddd);
		_publisherRepository.save(publisher);

		final Author rod = new Author("Rod", "Jonson");
		final Book noEJB = new Book("J@EE Development without EJB", "321321");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);

		noEJB.setPublisher(publisher);
		publisher.getBooks().add(noEJB);

		_authorRepository.save(rod);
		_bookRepository.save(noEJB);
		_publisherRepository.save(publisher);

		System.out.println("Started bootstrap");
		System.out.println("Number of publishers in repo : " + _publisherRepository.count());
		System.out.println("Number of books in repo : " + _bookRepository.count());
		System.out.println("Number of authors in repo : " + _authorRepository.count());
		System.out.println("publisher number of books: " + publisher.getBooks().size());
	}
}
