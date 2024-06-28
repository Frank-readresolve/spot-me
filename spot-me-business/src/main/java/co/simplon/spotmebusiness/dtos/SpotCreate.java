package co.simplon.spotmebusiness.dtos;

import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import co.simplon.spotmebusiness.validation.FileSize;
import co.simplon.spotmebusiness.validation.FileType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SpotCreate(@NotBlank @Size(max = 200) String name,
	@Size(max = 2000) String description,
	@NotNull @Min(-90) @Max(90) Double lat,
	@NotNull @Min(-180) @Max(180) Double lng, @FileType(types = {
		MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE,
		MediaType.IMAGE_PNG_VALUE })
	@FileSize(max = FileSize.TWO_MB) MultipartFile image){
}
