package com.amruta.happytech.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class apiResponse {

    private String  errorcode;

    private String errormsg;

    private LocalDate locatedate;
}
