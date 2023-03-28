package co.DevelHopeHelloWorld.ormmongodb.Repository;

import co.DevelHopeHelloWorld.ormmongodb.Entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity,String> {



}
