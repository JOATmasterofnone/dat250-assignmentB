package dat250.votingapp.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PollQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;
    private String questionText;
    private Boolean response;
    private ArrayList<Integer> responses;
    private String username;
    private String pollTitle;
    private int pollId;


    public PollQuestion(String text) {
        this.questionText = text;
        this.responses = new ArrayList<>(2);
    }

    // Method to add a response to the responses list
    public void addResponse(Integer response) {
        this.responses.add(response);
    }

    // Optionally, you might also override equals, hashCode, and toString
    @Override
    public String toString() {
        return "PollQuestion{" +
                "text='" + questionText + '\'' +
                ", response=" + response +
                ", responses=" + responses +
                '}';
    }
}
