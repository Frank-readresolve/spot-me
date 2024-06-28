package co.simplon.spotmebusiness.validation;

import java.util.Arrays;

import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FileTypeValidator
	implements ConstraintValidator<FileType, MultipartFile> {

    private String[] types;

    @Override
    public void initialize(FileType annotation) {
	types = annotation.types(); // JPEG, GIF, PNG
    }

    @Override
    public boolean isValid(MultipartFile file,
	    ConstraintValidatorContext context) {
	if (file == null) {
	    return true;
	}
	String contentType = file.getContentType(); // image/png
	return Arrays.stream(types)
		.anyMatch((type) -> type.equals(MediaType.ALL_VALUE)
			|| type.equals(contentType));
    }

}
