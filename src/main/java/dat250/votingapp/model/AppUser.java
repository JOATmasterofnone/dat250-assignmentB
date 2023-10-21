package dat250.votingapp.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String username;

    private String email;

    private String password;

    private Boolean isVerified = false;

    @OneToMany
    private List<Poll> ownedPolls;

    @ManyToMany
    private List<Poll> enteredPolls;

    public void addOwnedPoll(Poll newOwnedPoll){
        ownedPolls.add((newOwnedPoll));
    };

    public void removeOwnedPoll(Poll toBeRemovedPoll){
        ownedPolls.remove(toBeRemovedPoll);
    }

    public void addEnteredPoll(Poll newEnteredPoll){
        enteredPolls.add(newEnteredPoll);
    }

    public void removedEnteredPoll(Poll toBeDeletedPoll){
        enteredPolls.remove(toBeDeletedPoll);
    }

}
