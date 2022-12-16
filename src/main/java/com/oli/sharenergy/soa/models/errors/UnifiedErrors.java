package com.oli.sharenergy.soa.models.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UnifiedErrors {

    private String type;
    private String instance;
    private String status;
    private UnifiedErrorDetail title;
    private UnifiedErrorDetail detail;

}
