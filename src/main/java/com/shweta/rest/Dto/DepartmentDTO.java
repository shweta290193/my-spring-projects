package com.shweta.rest.Dto;

import javax.persistence.Embeddable;

import com.shweta.rest.entity.Department;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDTO {
	int deptId;
	String deptName;
}
