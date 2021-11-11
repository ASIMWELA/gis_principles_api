package com.spatial.navigation.Navigation.spatial;

import com.spatial.navigation.Navigation.commons.ApiResponse;
import com.spatial.navigation.Navigation.spatial.entity.MalawiDistrictsEntity;
import com.spatial.navigation.Navigation.spatial.hateos.MalawiDistrictsDto;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@RestController
@RequestMapping("/api/v1")
public class SpatialController {
    private final SpatialService spatialService;

    public SpatialController(SpatialService spatialService) {
        this.spatialService = spatialService;
    }

    @GetMapping("/resources")
    public ResponseEntity<RepresentationModel<?>> getResources(){
        return spatialService.exposeResourceLink();
    }

    @GetMapping("/districts")
    public ResponseEntity<PagedModel<MalawiDistrictsDto>> getDistricts(@PositiveOrZero  @RequestParam(value = "page", defaultValue = "0") int page, @Positive @RequestParam(value = "size", defaultValue = "3")int size, PagedResourcesAssembler<MalawiDistrictsEntity> pagedResourceAssember){
        return spatialService.getAllDistricts(page, size, pagedResourceAssember);
    }

    @PostMapping("/locations/{locationName}/{latitude}/{longitude}")
    public ResponseEntity<ApiResponse> postLocation(@PathVariable("locationName") String locationName, @PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude){
        return spatialService.saveCustomerLocation(locationName, latitude, longitude);
    }
}
