package project1.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MyDataMongoRepository extends MongoRepository<MyDataMongo, String> {

    public List<MyDataMongo> findByName(String s);
    public List<MyDataMongo> findByNameLike(String s);
}
