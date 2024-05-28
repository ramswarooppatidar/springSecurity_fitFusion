package com.CN.FitFusion.dto;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DietDto {


     String name;

     String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DietDto(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
     
	public DietDto() {
		
	}
}
