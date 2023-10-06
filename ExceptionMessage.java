package com.cg.bim.exception;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExceptionMessage {
private LocalDate timestamp;
private String message;
private int httpStatusCode;
private String httpStatusMessage;

}
