package com.jbdl63.session8JDBC.Model;

import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student
{
    @Id
    private Integer studId;
    @NotBlank(message =" studentName should not be null")
    private String studName;
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}",message = "PAN NO is not vaild")
    private String department;
    @DecimalMin(value = "60.0",message = "marks should greater  then 60")
    private Double marks;


}
