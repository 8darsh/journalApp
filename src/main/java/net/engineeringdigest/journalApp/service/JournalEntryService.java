package net.engineeringdigest.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.Entity.JournalEntry;
import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;   //it is an abstraction to use logback. underlying implementation se baat kar payenge
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;



    @Transactional    ///ya to pura hoga save nhi to pura rollback hojayega
    public void saveEntry(JournalEntry journalEntry, String username){

        try {
            User user = userService.findByUserName(username);
            JournalEntry entry = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(entry);
            userService.saveUser(user);

        } catch (Exception e) {
            throw new RuntimeException("An error occured while saving the entry");
        }


    }

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);

    }

    public List<JournalEntry> getAllEntries(){
        return new ArrayList<>(journalEntryRepository.findAll());
    }

    public Optional<JournalEntry> findEntryById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteEntryById(ObjectId Id, String username){
        boolean removed = false;
        try {
            User user = userService.findByUserName(username);
            removed = user.getJournalEntries().removeIf(x-> x.getId().equals(Id));
            if(removed){
                userService.saveUser(user);
                journalEntryRepository.deleteById(Id);
            }
        } catch (Exception e) {
            log.error("Error",e);
            throw new RuntimeException(e);
        }
        return removed;
    }

    public List<JournalEntry> findByUserName(String userName){
        User user = userService.findByUserName(userName);
        return user.getJournalEntries();
    }
}

// contoller --> service --> repository
