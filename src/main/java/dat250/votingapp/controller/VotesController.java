package dat250.votingapp.controller;

import dat250.votingapp.model.Votes;
import dat250.votingapp.repository.VotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/votes")
public class VotesController {

    @Autowired
    private VotesRepository votesRepository;

    @GetMapping
    public List<Votes> getAllVoters() {
        //return votesRepository.findAll();
        return null;
    }


}
