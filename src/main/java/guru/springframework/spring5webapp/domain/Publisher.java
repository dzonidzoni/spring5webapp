package guru.springframework.spring5webapp.domain;

import java.util.*;
import javax.persistence.*;

@Entity
public class Publisher
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String addressLine1;
	private String city;
	private String state;
	private String zipCode;

	@OneToMany
	@JoinColumn(name = "publisher_id")
	private Set<Book> books = new HashSet<>();

	public Publisher()
	{
	}

	public Publisher(final String name, final String addressLine1, final String city, final String state, final String zipCode)
	{
		this.name = name;
		this.addressLine1 = addressLine1;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	@Override
	public String toString()
	{
		return "Publisher{" +
			"id=" + id +
			", name='" + name + '\'' +
			", addressLine1='" + addressLine1 + '\'' +
			", city='" + city + '\'' +
			", state='" + state + '\'' +
			", zipCode='" + zipCode + '\'' +
			'}';
	}

	@Override
	public boolean equals(final Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}

		final Publisher publisher = (Publisher)o;

		return Objects.equals(id, publisher.id);
	}

	@Override
	public int hashCode()
	{
		return id != null ? id.hashCode() : 0;
	}

	public Set<Book> getBooks()
	{
		return books;
	}

	public void setBooks(final Set<Book> books)
	{
		this.books = books;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(final Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getAddressLine1()
	{
		return addressLine1;
	}

	public void setAddressLine1(final String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(final String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(final String state)
	{
		this.state = state;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(final String zipCode)
	{
		this.zipCode = zipCode;
	}
}
