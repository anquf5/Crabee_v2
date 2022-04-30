package com.crabee.backend.controller;

import com.crabee.backend.model.Company;
import com.crabee.backend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getCompanies(){
        return companyService.getCompany();
    }

    @PostMapping
    public void registerNewCompany(@RequestBody Company company){
        companyService.addNewCompany(company);
    }
    @DeleteMapping(path = "{companyId}")
    public void deleteCompany(@PathVariable("companyId") Long companyId){
        companyService.deleteCompany(companyId);
    }
    @PutMapping(path = "{companyId}")
    public void updateCompanyName(
            @PathVariable("companyId") Long companyId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String intro,
            @RequestParam(required = false) String link){
        companyService.updateCompanyName(companyId, name, intro, link);
    }
}
