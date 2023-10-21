package dat250.votingapp.repository;

import dat250.votingapp.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PollRepository extends JpaRepository<Poll, Integer> {

    /*
    * TODO: should this be here?
     */
    Optional<Poll> findByTitle(String pollTitle);
}
