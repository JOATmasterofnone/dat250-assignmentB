package dat250.votingapp.controller;

import dat250.votingapp.model.AppUser;
import dat250.votingapp.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appUsers")
public class AppUserController {

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("/{login}")
    public List<AppUser> getAllAppUsers() {
        return appUserRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getAppUserById(@PathVariable int id) {
        Optional<AppUser> appUser = appUserRepository.findById(id);
        if (appUser.isPresent()) {
            return ResponseEntity.ok(appUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public AppUser createAppUser(@RequestBody AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    //authentification
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AppUser loginUser) {
        AppUser existingUser = appUserRepository.findByUsername(loginUser.getUsername());
        if (existingUser != null && loginUser.getPassword().equals(existingUser.getPassword())) {
            return ResponseEntity.ok("Logged in successfully");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUser> updateAppUser(@PathVariable int id, @RequestBody AppUser updatedAppUser) {
        Optional<AppUser> appUser = appUserRepository.findById(id);
        if (appUser.isPresent()) {
            updatedAppUser.setId(id);
            return ResponseEntity.ok(appUserRepository.save(updatedAppUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppUser(@PathVariable int id) {
        Optional<AppUser> appUser = appUserRepository.findById(id);
        if (appUser.isPresent()) {
            appUserRepository.delete(appUser.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
