package com.spatial.navigation.Navigation.spatial;

import com.spatial.navigation.Navigation.commons.ApiResponse;
import com.spatial.navigation.Navigation.spatial.entity.MalawiDistrictsEntity;
import com.spatial.navigation.Navigation.spatial.hateos.MalawiDistrictsDto;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;

public interface SpatialService {
    ResponseEntity<PagedModel<MalawiDistrictsDto>> getAllDistricts(int page, int size, PagedResourcesAssembler<MalawiDistrictsEntity> pagedResourcesAssembler);
    ResponseEntity<RepresentationModel<?>> exposeResourceLink();
    ResponseEntity<ApiResponse> saveCustomerLocation(String locationName, double latitude, double longitude);
}
