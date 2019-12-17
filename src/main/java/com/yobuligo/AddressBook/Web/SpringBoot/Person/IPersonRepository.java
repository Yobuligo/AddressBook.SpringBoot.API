package com.yobuligo.AddressBook.Web.SpringBoot.Person;

import org.springframework.data.repository.CrudRepository;

public interface IPersonRepository extends CrudRepository<Person, Long> {

}
