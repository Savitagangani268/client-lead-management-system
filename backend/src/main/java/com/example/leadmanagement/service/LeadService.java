package com.example.leadmanagement.service;
import com.example.leadmanagement.model.*;
import com.example.leadmanagement.repository.LeadRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class LeadService {
    private final LeadRepository repo;
    public LeadService(LeadRepository repo){this.repo=repo;}
    public List<Lead> all(String search, LeadStatus status){
        if(status!=null) return repo.findByStatus(status);
        if(search!=null && !search.isBlank()) return repo.findByClientNameContainingIgnoreCaseOrCompanyContainingIgnoreCase(search,search);
        return repo.findAll();
    }
    public Lead get(Long id){ return repo.findById(id).orElseThrow(()->new RuntimeException("Lead not found")); }
    public Lead save(Lead l){return repo.save(l);}
    public Lead update(Long id,Lead x){ Lead l=get(id); l.setClientName(x.getClientName()); l.setEmail(x.getEmail()); l.setPhone(x.getPhone()); l.setCompany(x.getCompany()); l.setSource(x.getSource()); l.setStatus(x.getStatus()); l.setPriority(x.getPriority()); l.setValue(x.getValue()); l.setNotes(x.getNotes()); return repo.save(l); }
    public void delete(Long id){repo.deleteById(id);}
}
