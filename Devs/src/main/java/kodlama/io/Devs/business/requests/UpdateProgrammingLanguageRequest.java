package kodlama.io.Devs.business.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProgrammingLanguageRequest {

	@NotNull
	private int id;
	@NotBlank
	@NotNull
	private String name;
}
