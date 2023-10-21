package dat250.votingapp.controller;

import dat250.votingapp.model.Poll;
import dat250.votingapp.model.PollQuestion;
import dat250.votingapp.model.Votes;
import dat250.votingapp.repository.VotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/votes")
public class VotesController {

    @Autowired
    private VotesRepository votesRepository;

    @GetMapping
    public List<Poll> getAllVotes(){//@PathVariable pollId, @RequestBody Poll newQuestion) {
        //return votesRepository.findAll();
        return null;
    }


}
