package dat250.votingapp.repository;

import dat250.votingapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotesRepository extends JpaRepository<Question, Integer> {
}
