package com.example.leadmanagement.repository;
import com.example.leadmanagement.model.Lead;
import com.example.leadmanagement.model.LeadStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface LeadRepository extends JpaRepository<Lead,Long> {
    List<Lead> findByStatus(LeadStatus status);
    List<Lead> findByClientNameContainingIgnoreCaseOrCompanyContainingIgnoreCase(String clientName,String company);
}
