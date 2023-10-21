package dat250.votingapp.controller;

import dat250.votingapp.model.AppUserOrig;
import dat250.votingapp.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appUsers")
public class AppUserController {

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping
    public List<AppUserOrig> getAllAppUsers() {
        return appUserRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUserOrig> getAppUserById(@PathVariable int id) {
        Optional<AppUserOrig> appUser = appUserRepository.findById(id);
        if (appUser.isPresent()) {
            return ResponseEntity.ok(appUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public AppUserOrig createAppUser(@RequestBody AppUserOrig appUser) {
        return appUserRepository.save(appUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUserOrig> updateAppUser(@PathVariable int id, @RequestBody AppUserOrig updatedAppUser) {
        Optional<AppUserOrig> appUser = appUserRepository.findById(id);
        if (appUser.isPresent()) {
            updatedAppUser.setId(id);
            return ResponseEntity.ok(appUserRepository.save(updatedAppUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppUser(@PathVariable int id) {
        Optional<AppUserOrig> appUser = appUserRepository.findById(id);
        if (appUser.isPresent()) {
            appUserRepository.delete(appUser.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestParam String username,
                                     @RequestParam String password,
                                     @RequestParam String email) {
        //TODO: Check is user exists, if so return
        // If not, create unverified user
        // send verification code
        throw new UnsupportedOperationException("registerUser Not implemented");
    }

    @PostMapping("/login")
    public ResponseEntity<Void> loginUser(@RequestParam String username, String password) {
        //TODO: confirm correct password, if verifed is true login
        // if not verified, send verification code
        throw new UnsupportedOperationException("loginUser Not implemented");
    }

    @PostMapping("/verify")
    public ResponseEntity<Void> verifyUser(@RequestParam String username) {
        //TODO: confirm correct code, set verified = true
        throw new UnsupportedOperationException("verifyUser Not implemented");
    }

    @PostMapping("/createPoll")
    public ResponseEntity<Void> createPoll(@RequestParam String title) {
        //TODO: create an empty poll
        throw new UnsupportedOperationException("createPoll Not implemented");
    }

    @GetMapping("/viewPollList")
    public ResponseEntity<Void> viewPollList(@RequestParam String username) {
        //TODO: retriever list of all polls
        throw new UnsupportedOperationException("viewPollList Not implemented");
    }

    @PostMapping("/openPoll")
    public ResponseEntity<Void> openPoll(@RequestParam String pollTitle) {
        //TODO: call open poll
        throw new UnsupportedOperationException("openPoll Not implemented");
    }

    @PostMapping("/closePoll")
    public ResponseEntity<Void> closePoll(@RequestParam String pollTitle) {
        //TODO: call close poll
        throw new UnsupportedOperationException("closePoll Not implemented");
    }

    @PostMapping("/deletePoll")
    public ResponseEntity<Void> deletePoll(@RequestParam String pollTitle) {
        //TODO: call to delete poll
        throw new UnsupportedOperationException("deletePoll Not implemented");
    }

    @PostMapping("/reviewPoll")
    public ResponseEntity<Void> reviewPoll(@RequestParam String pollTitle) {
        //TODO: call preview poll
        throw new UnsupportedOperationException("reviewPoll Not implemented");
    }

    @PostMapping("/editPoll")
    public ResponseEntity<Void> editPoll(@RequestParam String pollTitle) {
        //TODO: call edit poll, i.e. add/remove questions
        throw new UnsupportedOperationException("editPoll Not implemented");
    }
}
