package com.example.leadmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name="leads")
public class Lead {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotBlank private String clientName;
    @NotBlank @Email private String email;
    private String phone;
    private String company;
    private String source;
    @Enumerated(EnumType.STRING) private LeadStatus status = LeadStatus.NEW;
    @Enumerated(EnumType.STRING) private LeadPriority priority = LeadPriority.MEDIUM;
    @Column(name = "estimated_value")
    private Double value;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist void onCreate(){ createdAt=LocalDateTime.now(); updatedAt=createdAt; }
    @PreUpdate void onUpdate(){ updatedAt=LocalDateTime.now(); }
    public Lead() {}
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public String getClientName(){return clientName;} public void setClientName(String v){clientName=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
    public String getCompany(){return company;} public void setCompany(String v){company=v;}
    public String getSource(){return source;} public void setSource(String v){source=v;}
    public LeadStatus getStatus(){return status;} public void setStatus(LeadStatus v){status=v;}
    public LeadPriority getPriority(){return priority;} public void setPriority(LeadPriority v){priority=v;}
    public Double getValue(){return value;} public void setValue(Double v){value=v;}
    public String getNotes(){return notes;} public void setNotes(String v){notes=v;}
    public LocalDateTime getCreatedAt(){return createdAt;} public LocalDateTime getUpdatedAt(){return updatedAt;}
}
