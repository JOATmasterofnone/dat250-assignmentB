package dat250.votingapp.repository;

import dat250.votingapp.model.PollQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotesRepository extends JpaRepository<PollQuestion, Integer> {
}
