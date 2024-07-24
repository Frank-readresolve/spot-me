package co.simplon.spotmebusiness.validation;

import co.simplon.spotmebusiness.dtos.SpotUpdate;
import co.simplon.spotmebusiness.repositories.SpotRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SpotUpdateUniqueValidator
	implements ConstraintValidator<SpotUpdateUnique, SpotUpdate> {

    private final SpotRepository spots;

    public SpotUpdateUniqueValidator(SpotRepository spots) {
	this.spots = spots;
    }

    @Override
    public boolean isValid(SpotUpdate inputs,
	    ConstraintValidatorContext context) {
	String name = inputs.name();
	Double lat = inputs.lat();
	Double lng = inputs.lng();
	if (name == null || lat == null || lng == null) {
	    return true;
	}
	Long id = ValidationUtils.pathVariableAsLong("id");
	return !spots.existsByNameIgnoreCaseAndLatAndLngAndIdNot(name, lat, lng,
		id);
    }

}
