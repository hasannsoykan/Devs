package kodlama.io.Devs.business.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTechnologyRequest {

	@NotNull
	private int id;

	@NotNull
	@NotBlank
	private String name;

	@NotNull
	private int programmingLanguageId;

}
