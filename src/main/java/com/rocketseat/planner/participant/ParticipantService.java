package com.rocketseat.planner.participant;

import com.rocketseat.planner.trip.Trip;
import com.rocketseat.planner.trip.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository repository;

    public void registerParticipantsToEvent(List<String> participantsToInvite, Trip tripId){
        List<Participant> participants = participantsToInvite.stream().map(email -> new Participant(email, tripId)).toList();
        this.repository.saveAll(participants);

        System.out.println(participants.get(0).getId());
    }



    public void triggerConfirmationEmailToParticipants(UUID tripId){}
}
