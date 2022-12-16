package com.oli.sharenergy.soa.models.general;

import com.oli.sharenergy.soa.models.errors.UnifiedErrors;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GeneralizedResponseBody<T> {

    private T data;
    private List<UnifiedErrors> error;

}