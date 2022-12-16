package com.oli.sharenergy.soa.models.errors;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UnifiedErrorDetail {

    private String lang;
    private String text;

}