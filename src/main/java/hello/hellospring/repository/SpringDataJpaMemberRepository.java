package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,
        Long>, MemberRepository {

    Optional<Member> findByName(String name);
}
