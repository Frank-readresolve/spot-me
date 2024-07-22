package co.simplon.spotmebusiness.validation;

import co.simplon.spotmebusiness.dtos.SpotCreate;
import co.simplon.spotmebusiness.repositories.SpotRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SpotUniqueValidator
	implements ConstraintValidator<SpotUnique, SpotCreate> {

    private final SpotRepository spots;

    public SpotUniqueValidator(SpotRepository spots) {
	this.spots = spots;
    }

    @Override
    public boolean isValid(SpotCreate inputs,
	    ConstraintValidatorContext context) {
	String name = inputs.name();
	Double lat = inputs.lat();
	Double lng = inputs.lng();
	if (name == null || lat == null || lng == null) {
	    return true;
	}
	return !spots.existsByNameIgnoreCaseAndLatAndLng(name, lat, lng);
    }

}
