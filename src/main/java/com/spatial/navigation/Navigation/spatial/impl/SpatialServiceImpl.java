package com.spatial.navigation.Navigation.spatial.impl;

import com.spatial.navigation.Navigation.commons.ApiResponse;
import com.spatial.navigation.Navigation.commons.Constants;
import com.spatial.navigation.Navigation.spatial.SpatialController;
import com.spatial.navigation.Navigation.spatial.SpatialService;
import com.spatial.navigation.Navigation.spatial.entity.CustomerLocation;
import com.spatial.navigation.Navigation.spatial.entity.MalawiDistrictsEntity;
import com.spatial.navigation.Navigation.spatial.hateos.MalawiDistrictsAssembler;
import com.spatial.navigation.Navigation.spatial.hateos.MalawiDistrictsDto;
import com.spatial.navigation.Navigation.spatial.repository.CustomerLocationRepository;
import com.spatial.navigation.Navigation.spatial.repository.MalawiDistrictRepository;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class SpatialServiceImpl implements SpatialService {
    private final MalawiDistrictRepository malawiDistrictRepository;
    private final MalawiDistrictsAssembler malawiDistrictsAssembler;
    private final CustomerLocationRepository customerLocationRepository;

    public SpatialServiceImpl(MalawiDistrictRepository malawiDistrictRepository, MalawiDistrictsAssembler malawiDistrictsAssembler, CustomerLocationRepository customerLocationRepository) {
        this.malawiDistrictRepository = malawiDistrictRepository;
        this.malawiDistrictsAssembler = malawiDistrictsAssembler;
        this.customerLocationRepository = customerLocationRepository;
    }

    public ResponseEntity<List<MalawiDistrictsEntity>> getAllDistricts() {
        return ResponseEntity.ok(malawiDistrictRepository.findAll());
    }

    @Override
    public ResponseEntity<PagedModel<MalawiDistrictsDto>> getAllDistricts(int page, int size, PagedResourcesAssembler<MalawiDistrictsEntity> pagedResourcesAssembler) {
        Page<MalawiDistrictsEntity> districts = malawiDistrictRepository.findAll(PageRequest.of(page, size));

        PagedModel<MalawiDistrictsDto> districtsDtoPagedModel = pagedResourcesAssembler
                .toModel(districts, malawiDistrictsAssembler);
        return ResponseEntity.ok(districtsDtoPagedModel);
    }

    @Override
    public ResponseEntity<RepresentationModel<?>> exposeResourceLink() {
        Link link = linkTo(methodOn(SpatialController.class).getDistricts(Constants.DEFAULT_PAGE, Constants.DEFAULT_SIZE, null)).withRel("areas");
        RepresentationModel<?> model = new RepresentationModel<>();
        model.add(link);

        return ResponseEntity.ok(model);
    }

    @Override
    public ResponseEntity<ApiResponse> saveCustomerLocation(String locationName, double latitude, double longitude) {

        GeometryFactory geometryFactory = new GeometryFactory();
        Point point = geometryFactory.createPoint( new Coordinate( longitude, latitude ) );
        point.setSRID(4326);

        CustomerLocation customerLocation = CustomerLocation.builder()
                .geom(point)
                .build();
        customerLocationRepository.save(customerLocation);
        return ResponseEntity.ok(ApiResponse.builder().success(true).message("Location saved").build());
    }
}
