package com.ftn.sbnz.service.controllers.dtos;

import java.util.ArrayList;
import java.util.List;

public class BrandNamesDTO {
    public List<String> brandNames;

    public BrandNamesDTO() {
        this.brandNames = new ArrayList<>();
    }

    public List<String> getBrandNames() {
        return brandNames;
    }

    public void setBrandNames(List<String> brandNames) {
        this.brandNames = brandNames;
    }
    

}
