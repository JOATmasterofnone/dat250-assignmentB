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
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private Boolean isPrivate;

    private int duration;

    @OneToOne(mappedBy = "pairedPoll")
    //@JoinColumn(name = "iot_device_id")
    private IoTDevice pairedIoT;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private String pollTitle;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Voter> authorizedUsers;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PollQuestion> pollQuestionList;


    /*
     * Creates a new Poll by populating the data and opening it to allow voters to respond.
     * If there is a duration, it will start the countdown before automatically closing it.
     *
     */
    private static void createPolls() {
        throw new UnsupportedOperationException("createPolls method not implemented");
    }

    /*
     * Allows an existing poll to receive votes.
     *
     */
    private static void openPoll(){
        throw new UnsupportedOperationException("openPoll method not implemented");
    }

    /*
     * Make a poll unavailable for receiving votes.
     *
     */
    private static void closePoll(){
        throw new UnsupportedOperationException("closePoll method not implemented");
    }

    /*
     * Deletes a poll.
     *
     */
    private static void deletePoll(){
        throw new UnsupportedOperationException("deletePoll method not implemented");
    }

}
