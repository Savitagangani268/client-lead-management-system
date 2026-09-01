package com.example.leadmanagement.controller;
import com.example.leadmanagement.model.*;
import com.example.leadmanagement.service.LeadService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController @RequestMapping("/api/leads") @CrossOrigin(origins="*")
public class LeadController {
    private final LeadService service;
    public LeadController(LeadService service){this.service=service;}
    @GetMapping public List<Lead> all(@RequestParam(required=false) String search,@RequestParam(required=false) LeadStatus status){return service.all(search,status);}
    @GetMapping("/{id}") public Lead get(@PathVariable Long id){return service.get(id);}
    @PostMapping public ResponseEntity<Lead> create(@Valid @RequestBody Lead l){return ResponseEntity.status(HttpStatus.CREATED).body(service.save(l));}
    @PutMapping("/{id}") public Lead update(@PathVariable Long id,@Valid @RequestBody Lead l){return service.update(id,l);}
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){service.delete(id);return ResponseEntity.noContent().build();}
    @GetMapping("/stats") public Map<String,Object> stats(){
      List<Lead> leads=service.all(null,null); Map<String,Object> m=new LinkedHashMap<>();
      m.put("total",leads.size()); m.put("new",count(leads,LeadStatus.NEW)); m.put("contacted",count(leads,LeadStatus.CONTACTED)); m.put("qualified",count(leads,LeadStatus.QUALIFIED)); m.put("proposal",count(leads,LeadStatus.PROPOSAL)); m.put("won",count(leads,LeadStatus.WON)); m.put("lost",count(leads,LeadStatus.LOST));
      m.put("pipelineValue",leads.stream().filter(x->x.getStatus()!=LeadStatus.LOST && x.getValue()!=null).mapToDouble(Lead::getValue).sum());
      m.put("wonValue",leads.stream().filter(x->x.getStatus()==LeadStatus.WON && x.getValue()!=null).mapToDouble(Lead::getValue).sum()); return m;
    }
    private long count(List<Lead> l,LeadStatus s){return l.stream().filter(x->x.getStatus()==s).count();}
}
