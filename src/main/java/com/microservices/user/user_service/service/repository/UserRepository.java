package com.microservices.user.user_service.service.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservices.user.user_service.entity.User;

//JpaRepository extends PagingAndSortingRepository extends CrudRepository
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Transactional
	@Modifying
	@Query("update User set phone=:phone where id = :id")
	void updatePhone(@Param("id") Long id, @Param("phone") String phone) ;
			
	//indexed query - where we pass index e.g - here we are passing 1 that means 1 is bind to name
    @Query("select u from User u where u.firstName=?1")
    List<User> getAllUserByFirstName(String firstName);
    
    //named query
    @Query(value = "select u from User u where u.phone=:phone")
    List<User> getUsersByPhone(@Param("phone")String phoneParam);
    
    //This below is the way to write the native Query (DB/SQL specific Query)- where we can use tablename
//  @Query(value = "select u from user u where u.phone=:phone", nativeQuery = true)
    
    //This end-point will get the Users with Last Name and sort the result
    @Query("select u from User u where u.lastName=:lastName")
    List<User> getUsersByLastNameAndSort(@Param("lastName")String lName, Sort sort);
    
//    Page<User> getAllUsersByPages(int pageNumber, int numberOdElementsPerPage);

}
