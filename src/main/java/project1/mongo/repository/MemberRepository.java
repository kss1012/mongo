package project1.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MemberRepository extends MongoRepository<Member, Integer> {

   // @Query("{id : ?0}")
    List<Member> getMemberBy(String id);
}
